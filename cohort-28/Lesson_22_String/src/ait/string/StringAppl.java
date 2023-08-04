package ait.string;

public class StringAppl {
    public static void main(String[] args) {
        String str = "Hello"; // Создание строки "Hello"
        char[] chars = {32, 'w', 'o', 'r', 'l', 'd'};
        String str1 = new String(chars); // Создание строки из массива символов
        System.out.println(str1);
        str += str1; // Конкатенация строк: "Hello" + " world"
        System.out.println(str);
        System.out.println(str.length()); // Вывод длины строки
        char c = str.charAt(str.length() - 1); // Получение символа по индексу
        System.out.println(c);
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i)); // Перебор и вывод символов строки
        }
        String str2 = " World";
        System.out.println(str1.equals(str2)); // Сравнение строк на равенство
        System.out.println(str1.equalsIgnoreCase(str2)); // Сравнение строк без учета регистра
        String str3 = str.toUpperCase(); // Преобразование строки к верхнему регистру
        System.out.println(str3);
        System.out.println(str);
        str3 = str3.toLowerCase(); // Преобразование строки к нижнему регистру
        System.out.println(str3);
        int index = str.indexOf('l'); // Поиск индекса первого вхождения символа 'l'
        System.out.println(index);
        index = str.indexOf("or"); // Поиск индекса первого вхождения подстроки "or"
        System.out.println(index);
        index = str.indexOf('l', 3); // Поиск индекса первого вхождения символа 'l' начиная с индекса 3
        System.out.println(index);
        System.out.println(str.substring(2));
        System.out.println(str.substring(2,7));
        System.out.println(str.replace("o", "o-o-o"));
        String str4 = "                     John      Klaus  ";
        str4 = str4.trim();
        System.out.println(str4);

    }
}
