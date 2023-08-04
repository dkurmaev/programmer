package ait.album.test;

import ait.album.dao.Album;
import ait.album.dao.AlbumImpl;
import ait.album.model.Photo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PhotoTest {

	private Album album;
	private LocalDateTime now = LocalDateTime.now();

	@BeforeEach
	void setUp() {
		album = new AlbumImpl(8);// Изменили размер альбома на 6


		// Создаем массив из шести фотографий
		Photo[] photos = new Photo[6];

		photos[0] = new Photo(1, 1, "Photo 1", "https://example.com/photo1.jpg", LocalDateTime.of(2021, 1, 1, 0, 0));
		photos[1] = new Photo(2, 2, "Photo 2", "https://example.com/photo2.jpg", LocalDateTime.of(2022, 1, 1, 0, 0));
		photos[2] = new Photo(3, 1, "Photo 3", "https://example.com/photo3.jpg", LocalDateTime.of(2023, 1, 1, 0, 0));
		photos[3] = new Photo(4, 2, "Photo 4", "https://example.com/photo4.jpg", LocalDateTime.of(2024, 1, 1, 0, 0));
		photos[4] = new Photo(5, 1, "Photo 5", "https://example.com/photo5.jpg", LocalDateTime.of(2025, 1, 1, 0, 0));
		photos[5] = new Photo(6, 2, "Photo 6", "https://example.com/photo6.jpg", LocalDateTime.of(2026, 1, 1, 0, 0));

		// Добавляем фотографии в альбом
		for (Photo photo : photos) {
			album.addPhoto(photo);
		}

		LocalDateTime photo1Date = LocalDateTime.of(2021, 1, 1, 0, 0);
		now = photo1Date;
	}

	@Test
	void addPhoto() {
		// Тест добавления фотографии в альбом
		Photo photo = new Photo(1, 1, "Photo 1", "https://example.com/photo1.jpg", LocalDateTime.of(2021, 1, 1, 0, 0));
		photo.setPhotoid(7);
		photo.setAlbumid(1);
		photo.setDate(LocalDateTime.of(2023, 1, 1, 0, 0));
		boolean res = album.addPhoto(photo);
		assertTrue(res); // Убеждаемся, что фотография была успешно добавлена
		assertEquals(7, album.size()); // Убеждаемся, что размер альбома увеличился до 7
	}

	@Test
	void removePhoto() {
		// Тест удаления существующей фотографии из альбома
		boolean result = album.removePhoto(1, 1);
		assertTrue(result); // Убеждаемся, что фотография была успешно удалена
		assertEquals(5, album.size()); // Убеждаемся, что размер альбома уменьшился до 5
	}

	@Test
	void updatePhoto() {
		// Тест обновления URL существующей фотографии в альбоме
		boolean result = album.updatePhoto(1, 1, "https://example.com/newurl.jpg");
		assertTrue(result); // Убеждаемся, что URL фотографии был успешно обновлен
		assertEquals("https://example.com/newurl.jpg", album.getPhotoFromAlbum(1, 1).getUrl()); // Убеждаемся, что URL обновлен
	}

	@Test
	void getPhotoFromAlbum() {
		// Тест получения существующей фотографии из альбома
		Photo photo = album.getPhotoFromAlbum(1, 1);
		assertNotNull(photo); // Убеждаемся, что фотография не является null
		assertEquals(1, photo.getPhotoid()); // Убеждаемся, что идентификатор фотографии совпадает
		assertEquals(1, photo.getAlbumid()); // Убеждаемся, что идентификатор альбома фотографии совпадает
	}

	@Test
	void getAllPhotoFromAlbum() {
		// Тест получения всех фотографий из альбома
		Photo[] photos = album.getAllPhotoFromAlbum(1);
		assertNotNull(photos); // Убеждаемся, что массив фотографий не является null
		assertEquals(1, photos.length); // Убеждаемся, что количество фотографий равно ожидаемому
		assertEquals(1, photos[0].getPhotoid()); // Убеждаемся, что идентификатор первой фотографии совпадает
		assertEquals(1, photos[0].getAlbumid()); // Убеждаемся, что идентификатор альбома первой фотографии совпадает
	}

	@Test
	void getPhotoBetweenDate() {
		// Тест получения фотографий из альбома в указанном диапазоне дат
		LocalDateTime startDate = LocalDateTime.of(2021, 1, 1, 0, 0);
		LocalDateTime endDate = LocalDateTime.of(2022, 1, 1, 0, 0);
		Photo[] photos = album.getPhotoBetweenDate(startDate, endDate);
		assertNotNull(photos); // Убеждаемся, что массив фотографий не является null
		assertEquals(2, photos.length); // Убеждаемся, что количество фотографий равно ожидаемому
		assertEquals(1, photos[0].getPhotoid()); // Убеждаемся, что идентификатор первой фотографии совпадает
		assertEquals(1, photos[0].getAlbumid()); // Убеждаемся, что идентификатор альбома первой фотографии совпадает
	}

	@Test
	void setTitle() {
		album.getPhotoFromAlbum(1, 1).setTitle("New Title");
		String title = album.getPhotoFromAlbum(1, 1).getTitle();
		assertEquals("New Title", title);
	}

	@Test
	void setUrl() {
		album.getPhotoFromAlbum(1, 1).setUrl("https://example.com/photo.jpg");
		String url = album.getPhotoFromAlbum(1, 1).getUrl();
		assertEquals("https://example.com/photo.jpg", url);
	}

	@Test
	void setDate() {
		LocalDateTime newDate = LocalDateTime.of(2022, 1, 1, 0, 0);
		album.getPhotoFromAlbum(1, 1).setDate(newDate);
		LocalDateTime date = album.getPhotoFromAlbum(1, 1).getDate();
		assertEquals(newDate, date);
	}

	@Test
	void testToString() {
		Photo photo = album.getPhotoFromAlbum(1, 1);
		String expectedString = "Photo albumid = 1, photoid = 1, title = Photo 1, url = https://example.com/photo1.jpg, date=" + now;
		assertEquals(expectedString, photo.toString());
	}

	@Test
	void testEquals() {
		Photo photo1 = album.getPhotoFromAlbum(1, 1);
		Photo photo2 = album.getPhotoFromAlbum(1, 1);
		assertEquals(photo1, photo2);
	}

	@Test
	void compareTo_GreaterDate_ReturnsPositiveValue() {
		Photo photo1 = album.getPhotoFromAlbum(1, 1);
		Photo photo2 = album.getPhotoFromAlbum(2, 2);
		assertTrue(photo1.compareTo(photo2) < 0);
	}
}


