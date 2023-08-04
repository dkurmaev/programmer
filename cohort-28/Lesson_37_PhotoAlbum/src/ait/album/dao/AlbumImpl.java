package ait.album.dao;

import ait.album.model.Photo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class AlbumImpl implements Album {

	static Comparator<Photo> comparator = (p1, p2) -> p1.getDate().compareTo(p2.getDate());
	Photo[] photos; // Массив фотографий
	int size; // Количество фотографий

	public AlbumImpl(int capacity) { // Конструктор класса
		photos = new Photo[capacity]; // Создаем массив фотографий размером capacity
	}

	@Override
	public boolean addPhoto(Photo photo) { // Метод для добавления фотографии в альбом
		if (photo == null || photos.length == size || getPhotoFromAlbum(photo.getPhotoId(), photo.getAlbumId()) != null) {
			// Проверяем, что фотография не является null, альбом не переполнен и фотография с такими же ID не существует
			return false;
		}
		int index = Arrays.binarySearch(photos, 0, size, photo, comparator);
		index = index >= 0 ? index : -index - 1;
		System.arraycopy(photos, index, photos, index + 1, size - index);
		photos[index] = photo;// Добавляем фотографию в массив
		size++; //и увеличиваем размер
		return true;
	}

	@Override
	public boolean removePhoto(int photoId, int albumId) { // Метод для удаления фотографии из альбома
		for (int i = 0; i < size; i++) {
			if (photos[i].getPhotoId() == photoId && photos[i].getAlbumId() == albumId) {
				// Ищем фотографию с указанными ID и альбомом
				System.arraycopy(photos, i + 1, photos, i, size - 1 - i);
				// Сдвигаем элементы массива влево, чтобы удалить фотографию
				photos[--size] = null; // Обнуляем последний элемент и уменьшаем счетчик
				return true;
			}
		}
		return false; // Фотография не найдена
	}

	@Override
	public boolean updatePhoto(int photoId, int albumId, String url) { // Метод для обновления URL фотографии
		Photo photo = getPhotoFromAlbum(photoId, albumId); // Ищем фотографию с указанными ID и альбомом
		if (photo == null) {
			return false; // Фотография не найдена
		}
		photo.setUrl(url); // Обновляем URL фотографии
		return true;
	}

	@Override
	public Photo getPhotoFromAlbum(int photoId, int albumId) { // Метод для получения фотографии из альбома
		for (int i = 0; i < size; i++) {
			if (photos[i].getPhotoId() == photoId && photos[i].getAlbumId() == albumId) {
				// Ищем фотографию с указанными ID и альбомом
				return photos[i]; // Возвращаем найденную фотографию
			}
		}
		return null; // Фотография не найдена
	}

	@Override
	public Photo[] getAllPhotoFromAlbum(int albumId) { // Метод для получения всех фотографий из альбома
		return findByPredicate(p -> p.getAlbumId() == albumId);
		// Используем метод findByPredicate с предикатом, чтобы найти фотографии с указанным альбомом
	}

	@Override
	public Photo[] getPhotoBetweenDate(LocalDate dateFrom, LocalDate dateTo) { // Метод для получения фотографий в заданном диапазоне дат
		Photo pattern = new Photo(0, 1, null, null, dateFrom.atStartOfDay());// создаем паттерн для поиска
		int from = - Arrays.binarySearch(photos, 0, size, pattern, comparator) - 1;// ищем индекс первого элемента
		//from = from >= 0 ? from : -from - 1;
		pattern = new Photo(0, 1, null, null, LocalDateTime.of(dateTo, LocalTime.MAX));// создаем паттерн для поиска
		int to = - Arrays.binarySearch(photos, 0, size, pattern, comparator)-1;// ищем индекс последнего элемента
		//to = to >= 0 ? to : -to - 1;
		return Arrays.copyOfRange(photos, from, to);// возвращаем массив фотографий в заданном диапазоне дат


//		return findByPredicate(p -> p.getDate().toLocalDate().compareTo(dateFrom) >= 0
//				&& p.getDate().toLocalDate().compareTo(dateTo) <= 0);
		// Используем метод findByPredicate с предикатом, чтобы найти фотографии с датой в указанном диапазоне
	}

	@Override
	public int size() { // Метод для получения количества фотографий в альбоме
		return size; // Возвращаем количество фотографий
	}

	private Photo[] findByPredicate(Predicate<Photo> predicate) {
		// Вспомогательный метод для поиска фотографий в массиве Photo по предикату
		Photo[] res = new Photo[size]; // Создаем переменную для создания результата
		int j = 0; // Индекс для заполнения результата
		for (int i = 0; i < size; i++) {
			if (predicate.test(photos[i])) { // Проверяем, что фотография удовлетворяет условию предиката
				res[j++] = photos[i]; // Добавляем фотографию в результат и увеличиваем индекс
			}
		}
		return Arrays.copyOf(res, j); // Возвращаем новый массив, содержащий только найденные фотографии
	}

}
