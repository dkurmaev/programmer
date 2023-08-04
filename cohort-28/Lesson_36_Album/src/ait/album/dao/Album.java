package ait.album.dao;

import ait.album.model.Photo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Album {
	boolean addPhoto(Photo photo);
	boolean removePhoto(int photoId, int albumId);
	boolean updatePhoto(int photoId, int albumId, String url);
	Photo getPhotoFromAlbum(int photoId, int albumId);
	int size();
	Photo[] getAllPhotoFromAlbum(int albumId);
	Photo[] getPhotoBetweenDate(LocalDateTime dateFrom, LocalDateTime dateTo);
}
