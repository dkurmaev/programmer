package ait.album.model;

import ait.album.dao.Album;
import ait.album.dao.AlbumImpl;

import java.time.LocalDateTime;

public class Main {
	public static void main(String[] args) {
		// Создаем альбом
		Album album = new AlbumImpl(10);

		// Создаем фотографии
		Photo photo1 = new Photo(1, 1, "Photo 1", "https://example.com/photo1.jpg", LocalDateTime.of(2021, 1, 1, 0, 0));
		Photo photo2 = new Photo(1, 2, "Photo 2", "https://example.com/photo2.jpg", LocalDateTime.of(2022, 1, 1, 0, 0));
		Photo photo3 = new Photo(2, 3, "Photo 3", "https://example.com/photo3.jpg", LocalDateTime.of(2023, 1, 1, 0, 0));

		// Добавляем фотографии в альбом
		album.addPhoto(photo1);
		album.addPhoto(photo2);
		album.addPhoto(photo3);

		// Получаем фотографию из альбома
		Photo retrievedPhoto = album.getPhotoFromAlbum(1, 1);
		System.out.println(retrievedPhoto);

		// Удаляем фотографию из альбома
		boolean removed = album.removePhoto(1, 1);
		System.out.println("Photo removed: " + removed);

		// Получаем все фотографии из альбома
		Photo[] allPhotos = album.getAllPhotoFromAlbum(1);
		System.out.println("All photos in album: ");
		for (int i = 0; i < allPhotos.length; i++) {
			System.out.println(allPhotos[i]);
		}
		//for (Photo photo : allPhotos) {


		// Обновляем URL фотографии
		boolean updated = album.updatePhoto(2, 1, "https://example.com/newurl.jpg");
		System.out.println("Photo updated: " + updated);

		// Получаем фотографии в заданном диапазоне дат
		LocalDateTime startDate = LocalDateTime.of(2021, 1, 1, 0, 0);
		LocalDateTime endDate = LocalDateTime.of(2022, 1, 1, 0, 0);
		Photo[] photosBetweenDates = album.getPhotoBetweenDate(startDate, endDate);
		System.out.println("Photos between " + startDate + " and " + endDate + ":");
		for (Photo photo : photosBetweenDates) {
			System.out.println(photo);
		}
	}
}