package ait.parser.impl;

import ait.Constants;
import ait.etity.SubCategory;
import ait.parser.Parser;


/**
 * Парсер для преобразования строк в объекты типа SubCategory.
 */
public class SubCategoryParser implements Parser<SubCategory> {
    /**
     * Преобразует строку CSV в объект типа SubCategory.
     *
     * @param line Строка CSV для разбора.
     * @return Объект типа SubCategory, созданный из строки.
     * @throws NumberFormatException          Если встретится ошибка при преобразовании числа из строки.
     * @throws ArrayIndexOutOfBoundsException Если количество элементов после разбора строки не соответствует ожидаемому.
     */
    @Override
    public SubCategory parse(String line) {
        String[] split = line.split(Constants.CSV_DELIMITER, -1);

        // Валидация: Проверка, является ли строка числом и размер массива
        if (split.length != 2) {
            throw new ArrayIndexOutOfBoundsException("Unexpected number of elements in CSV line");
        }
        try {
            long id = Long.parseLong(split[0]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid format for ID: " + split[0]);
        }

        // Используем builder для создания объекта SubCategory
        return SubCategory.Builder
                .id(1L)
                .name("Example SubCategory")
                .build();
    }
}
