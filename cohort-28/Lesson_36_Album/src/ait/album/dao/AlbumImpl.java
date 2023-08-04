package ait.album.dao;

import ait.album.model.Photo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AlbumImpl implements Album {
	private Photo[] photos; // Массив фотографий в альбоме
	private int size; // Текущий размер альбома

	public AlbumImpl(int capacity) {
		photos = new Photo[capacity]; // Инициализация массива фотографий с указанной емкостью
		size = 0; // Изначально размер альбома равен 0
	}

	// Добавляет фотографию в альбом.
	@Override
	public boolean addPhoto(Photo photo) {
		if (size < photos.length - 1) {
			photos[size] = photo;
			size++;
			return true;
		}
		return false;
	}

	@Override
	public boolean removePhoto(int photoId, int albumId) {
		for (int i = 0; i < size; i++) {
			if (photos[i] != null && photos[i].getPhotoid() == photoId && photos[i].getAlbumid() == albumId) {
				for (int j = i; j < size - 1; j++) {
					photos[j] = photos[j + 1];
				}
				photos[size - 1] = null;
				size--;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updatePhoto(int photoId, int albumId, String url) {
		for (int i = 0; i < size; i++) {
			if (photos[i] != null && photos[i].getPhotoid() == photoId && photos[i].getAlbumid() == albumId) {
				photos[i].setUrl(url);
				return true;
			}
		}
		return false;
	}

	@Override
	public Photo getPhotoFromAlbum(int photoId, int albumId) {
		for (int i = 0; i < size; i++) {
			if (photos[i] != null && photos[i].getPhotoid() == photoId && photos[i].getAlbumid() == albumId) {
				return photos[i];
			}
		}
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Photo[] getAllPhotoFromAlbum(int albumId) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (photos[i] != null && photos[i].getAlbumid() == albumId) {
				count++;
			}
		}
		Photo[] res = new Photo[count];
		int index = 0;
		for (int i = 0; i < size; i++) {
			if (photos[i] != null && photos[i].getAlbumid() == albumId) {
				res[index] = photos[i];
				index++;
			}
		}
		return res;
	}

	@Override
	public Photo[] getPhotoBetweenDate(LocalDateTime dateFrom, LocalDateTime dateTo) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (photos[i] != null) {
				LocalDateTime photoDate = photos[i].getDate();
				if (photoDate.isEqual(dateFrom) || photoDate.isEqual(dateTo) || (photoDate.isAfter(dateFrom) && photoDate.isBefore(dateTo))) {
					count++;
				}
			}
		}
		Photo[] res = new Photo[count];
		int index = 0;
		for (int i = 0; i < size; i++) {
			if (photos[i] != null) {
				LocalDateTime photoDate = photos[i].getDate();
				if (photoDate.isEqual(dateFrom) || photoDate.isEqual(dateTo) || (photoDate.isAfter(dateFrom) && photoDate.isBefore(dateTo))) {
					res[index] = photos[i];
					index++;
				}
			}
		}
		return res;
	}
}


