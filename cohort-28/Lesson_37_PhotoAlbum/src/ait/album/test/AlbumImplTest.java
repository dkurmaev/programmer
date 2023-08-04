package ait.album.test;

import ait.album.dao.Album;
import ait.album.dao.AlbumImpl;
import ait.album.model.Photo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

class AlbumImplTest {

	Album albums; // Интерфейс альбома
	LocalDateTime now = LocalDateTime.now(); // Текущая дата и время
	Photo[] ph = new Photo[6]; // Массив фотографий

	@BeforeEach
	void setUp() {
		albums = new AlbumImpl(7); // Создаем альбом с вместимостью 7
		ph[0] = new Photo(1,1,"title1","url1",now.minusDays(7)); // Фотография 1
		ph[1] = new Photo(1,2,"title2","url2",now.minusDays(7)); // Фотография 2
		ph[2] = new Photo(1,3,"title3","url3",now.minusDays(5)); // Фотография 3
		ph[3] = new Photo(2,1,"title1","url1",now.minusDays(7)); // Фотография 1 в другом альбоме
		ph[4] = new Photo(2,4,"title4","url4",now.minusDays(2)); // Фотография 4
		ph[5] = new Photo(1,4,"title4","url1",now.minusDays(2)); // Фотография 4 в первом альбоме

		// Добавляем фотографии в альбом
		for (int i = 0; i < ph.length; i++) {
			albums.addPhoto(ph[i]);
		}
	}

	@Test
	void addPhoto() {
		assertFalse(albums.addPhoto(null)); // Пустая фотография, ожидаем false
		assertFalse(albums.addPhoto(ph[1])); // Фотография, которая уже есть в альбоме, ожидаем false
		Photo photo = new Photo(1, 5, "title5", "url5", now.minusDays(3)); // Новая фотография
		assertTrue(albums.addPhoto(photo)); // Добавляем новую фотографию, ожидаем true
		assertEquals(7, albums.size()); // Проверяем, что количество фотографий в альбоме увеличилось до 7
		photo = new Photo(1, 6, "title6", "url6", now.minusDays(3)); // Еще одна новая фотография
		assertFalse(albums.addPhoto(photo)); // Добавляем новую фотографию, но альбом уже полон, ожидаем false
	}

	@Test
	void removePhoto() {
		assertFalse(albums.removePhoto(5,1)); // Пытаемся удалить несуществующую фотографию, ожидаем false
		assertTrue(albums.removePhoto(1,1)); // Удаляем существующую фотографию, ожидаем true
		assertEquals(5,albums.size()); // Проверяем, что количество фотографий в альбоме уменьшилось до 5
		assertNull(albums.getPhotoFromAlbum(1,1)); // Проверяем, что удаленная фотография больше не существует в альбоме
	}

	@Test
	void updatePhoto() {
		assertTrue(albums.updatePhoto(1,1,"newUrl")); // Обновляем URL существующей фотографии, ожидаем true
		assertEquals("newUrl", albums.getPhotoFromAlbum(1,1).getUrl()); // Проверяем, что URL фотографии обновился
	}

	@Test
	void getPhotoFromAlbum() {
		assertEquals(ph[0], albums.getPhotoFromAlbum(1,1)); // Получаем существующую фотографию из альбома
		assertNull(albums.getPhotoFromAlbum(3,2)); // Получаем несуществующую фотографию из альбома, ожидаем null
	}

	@Test
	void getAllPhotoFromAlbum() {
		Photo[] actual = albums.getAllPhotoFromAlbum(2); // Получаем все фотографии из другого альбома
		Arrays.sort(actual);
		Photo[] expected = {ph[3], ph[4]}; // Ожидаемые фотографии
		assertArrayEquals(expected,  actual); // Проверяем, что полученные фотографии совпадают с ожидаемыми
	}

	@Test
	void getPhotoBetweenDate() {
		LocalDate ld = LocalDate.now(); // Текущая дата
		Photo[] actual = albums.getPhotoBetweenDate(ld.minusDays(5), ld.minusDays(2));
		Arrays.sort(actual);
		// Получаем фотографии в указанном диапазоне дат
		Photo[] expected = {ph[2], ph[5], ph[4]}; // Ожидаемые фотографии
		assertArrayEquals(expected,  actual); // Проверяем, что полученные фотографии совпадают с ожидаемыми
	}

	@Test
	void size() {
		assertEquals(6, albums.size()); // Проверяем, что количество фотографий в альбоме равно 6
	}
}
