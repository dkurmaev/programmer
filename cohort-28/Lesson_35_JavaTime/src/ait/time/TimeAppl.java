package ait.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Locale;

public class TimeAppl {
	public static void main(String[] args) {
		// LocalDate, LocalTime, LocalDateTime
		LocalDate currentDate = LocalDate.now();//спросили текушую дату
		System.out.println("Текущая дата: " + currentDate);  // Вывод текущей даты
		System.out.println("==========================================");

		LocalTime localTime = LocalTime.now();//спросили текушее время
		System.out.println("Текущее время: " + localTime);  // Вывод текущего времени
		System.out.println("==========================================");

		LocalDateTime localDateTime = LocalDateTime.now();//спросили текушее время и дату
		System.out.println("Текущая дата и время: " + localDateTime);  // Вывод текущей даты и времени
		System.out.println("==========================================");

		// Операции с методом LocalDate
		/*
		Метод LocalDate.of() является статическим методом класса LocalDate из Java Time API.
		Он используется для создания объекта типа LocalDate, представляющего определенную дату.
		Метод принимает аргументы, представляющие год, месяц и день, и возвращает соответствующий объект LocalDate.
		 */
		LocalDate gagarin = LocalDate.of(1961, 4, 12);// Создание объекта LocalDate для даты 12 апреля 1961 года (дата полёта Юрия Гагарина)
		System.out.println("Год был: " + gagarin.getYear());  // Вывод года для даты 12 апреля 1961 года (дата полёта Юрия Гагарина)
		System.out.println("День месяца был: " + gagarin.getDayOfMonth());  // Вывод дня месяца для даты 12 апреля 1961 года (дата полёта Юрия Гагарина)
		System.out.println("День недели был: " + gagarin.getDayOfWeek());  // Вывод дня недели для даты 12 апреля 1961 года (дата полёта Юрия Гагарина)
		System.out.println("День года был: " + gagarin.getDayOfYear());  // Вывод дня года для даты 12 апреля 1961 года (дата полёта Юрия Гагарина)
		System.out.println("==========================================");

		// Операции сравнения дат
		System.out.println(gagarin.isBefore(currentDate));  // Сравнение дат: была ли дата Гагарина раньше текущей
		System.out.println("==========================================");

		// Операции с датами
		LocalDate newDate = currentDate.plusDays(40);  // Добавление 40 дней к текущей дате
		System.out.println("Новая дата: " + newDate);
		System.out.println("Текущая дата: " + currentDate);
		newDate = currentDate.plusWeeks(8);  // Добавление 8 недель к текущей дате
		System.out.println("Новая дата: " + newDate);
		newDate = currentDate.minusMonths(2);  // Вычитание 2 месяцев из текущей даты
		System.out.println("Новая дата: " + newDate);
		newDate = currentDate.plus(10, ChronoUnit.CENTURIES);  // Добавление 10 веков к текущей дате
		System.out.println(newDate);
		newDate = currentDate.plus(10, ChronoUnit.DECADES);  // Добавление 10 десятилетий к текущей дате
		System.out.println(newDate);
		System.out.println("==========================================");

		// Операции с временем
		/*
		Метод plus() является методом экземпляра класса LocalDateTime из Java Time API.
		Он используется для добавления определенного количества временных единиц к существующему объекту LocalDateTime и
		возвращает новый объект LocalDateTime с добавленным временным интервалом.
        Метод plus() принимает два аргумента: количество единиц, которое нужно добавить, и тип временной единицы,
        которую нужно добавить (например, ChronoUnit.DAYS, ChronoUnit.HOURS, ChronoUnit.MONTHS и т.д.).
		 */
		LocalDateTime newDateTime = localDateTime.plus(10, ChronoUnit.HOURS);  // Добавление 10 часов к текущему времени
		System.out.println(newDateTime);
		System.out.println("==========================================");

		// Разница между датами

		/*
		ChronoUnit - это перечисление (enum) из Java Time API, которое предоставляет набор временных единиц для работы с датами и временем.
		Оно представляет различные временные интервалы, такие как дни, часы, минуты, секунды и т. д., и используется для выполнения операций с датами и временем.
        ChronoUnit предоставляет различные константы для разных временных интервалов, например:
        ChronoUnit.DAYS: дни
        ChronoUnit.HOURS: часы
        ChronoUnit.MINUTES: минуты
        ChronoUnit.SECONDS: секунды
        ChronoUnit.MONTHS: месяцы
        ChronoUnit.YEARS: годы
        и т.д.
        Вы можете использовать ChronoUnit вместе с методами из Java Time API, такими как plus(), minus(), between(),
        чтобы добавлять или вычитать временные интервалы, а также определять разницу между датами и временем в заданных единицах.
		 */
		long res = ChronoUnit.YEARS.between(gagarin, currentDate);  // Вычисление разницы в годах между датами
		System.out.println(res);
		res = ChronoUnit.MONTHS.between(gagarin, currentDate);  // Вычисление разницы в месяцах между датами
		System.out.println(res);
		res = ChronoUnit.DAYS.between(gagarin, currentDate);  // Вычисление разницы в днях между датами
		System.out.println(res);
		System.out.println("==========================================");

		// Сортировка дат
		LocalDate lenin = LocalDate.of(1870, 4, 22);

		LocalDate[] dates = {gagarin, currentDate, lenin};
		System.out.println(Arrays.toString(dates));  // Вывод исходного массива дат
		Arrays.sort(dates);  // Сортировка массива дат
		System.out.println(Arrays.toString(dates));  // Вывод отсортированного массива дат
		System.out.println("================= Форматирование даты =======================");

		// Форматирование даты
		DateTimeFormatter df = DateTimeFormatter.BASIC_ISO_DATE;  // Создание форматтера для базового ISO формата даты
		System.out.println(gagarin.format(df));  // Форматирование даты Гагарина в базовом ISO формате
		System.out.println("==========================================");

		df = DateTimeFormatter.ofPattern("dd/MM/yyyy");  // Создание форматтера для пользовательского формата даты
		System.out.println(gagarin.format(df));  // Форматирование даты Гагарина в пользовательском формате
		df = DateTimeFormatter.ofPattern("dd/MMMM/yyyy");  // Создание форматтера для пользовательского формата даты
		System.out.println(gagarin.format(df));  // Форматирование даты Гагарина в пользовательском формате
		df = DateTimeFormatter.ofPattern("dd.MMMM.yyyy", Locale.forLanguageTag("de"));  // Создание форматтера для пользовательского формата даты с указанием локали
		System.out.println(gagarin.format(df));  // Форматирование даты Гагарина в пользовательском формате с указанием локали
		df = DateTimeFormatter.ofPattern("dd/MM/yyyy");  // Создание форматтера для пользовательского формата даты
		String date1 = "06/07/2023";
		LocalDate localDate1 = dateParse(date1);
		System.out.println("Дата: " + localDate1);
		String date2 = "2023-02-02";
		LocalDate localDate2 = dateParse(date2);
		System.out.println("Дата: " + localDate2);
	}
    /*
    метод dateParse выполняет парсинг (преобразование) строки date в объект типа LocalDate с использованием заданного форматтера DateTimeFormatter.
    На первой строке метода создается объект DateTimeFormatter с помощью метода ofPattern, который принимает шаблон формата даты.
    В данном случае, шаблон указывает на два возможных формата даты: [dd/MM/yyyy] и [yyyy-MM-dd]. Квадратные скобки вокруг каждого формата указывают
    на опциональность соответствующей части даты.
    На второй строке метода происходит парсинг строки date в объект LocalDate с использованием созданного форматтера. Метод parse принимает строку,
    содержащую дату, и форматтер, и возвращает соответствующий объект LocalDate.
    Таким образом, этот метод позволяет преобразовать строку, содержащую дату в одном из двух форматов, в объект LocalDate,
    который представляет эту дату для дальнейшей работы с ней в Java Time API.
     */
	private static LocalDate dateParse(String date) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]");  // Создание форматтера для парсинга даты в двух возможных форматах
		return LocalDate.parse(date, df);  // Парсинг даты из строки в объект LocalDate с использованием созданного форматтера
	}
}
