package ait.book.dao;

import ait.book.model.Book;

//Класс Library представляет собой модель библиотеки.
// В нем есть приватные поля books и size, которые представляют массив книг и текущий размер библиотеки соответственно.
public class Library {
    private Book[] books;
    private int size;

    //Конструктор Library принимает емкость (capacity) библиотеки и инициализирует массив books указанной емкостью.
    public Library(int capacity) {
        books = new Book[capacity];


    }


    //Метод addBook добавляет книгу в библиотеку. Он проверяет, есть ли еще место для книги
// (проверяя, равен ли размер size длине массива books). Если места нет, метод возвращает false,
// иначе добавляет книгу в массив books, увеличивает size на 1 и возвращает true.
    public boolean addBook(Book book) {
        if (size == books.length || findBook(book.getIsbn()) != null) {
            return false;
        }
        books[size] = book;
        size++;
        return true;
    }

    //Метод printBooks выводит на экран информацию о всех книгах в библиотеке.
// Он использует цикл для перебора всех элементов массива books с индексами
// от 0 до size - 1 и вызывает метод toString() для каждой книги, чтобы получить строковое представление и вывести его на экран.
    public void printBooks() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);

        }
    }

    //Метод getSize возвращает текущий размер библиотеки, то есть количество книг,
    // которые уже были добавлены в библиотеку. Он возвращает значение переменной size.
    public int getSize() {
        return size;
    }

    //Метод findBook в классе Library ищет книгу по заданному ISBN. Он перебирает все книги в массиве books
    // и сравнивает ISBN каждой книги с заданным значением. Если находит книгу с соответствующим ISBN,
    // возвращает эту книгу. Если ни одна книга не соответствует заданному ISBN, возвращает null.
    public Book findBook(long isbn) {
        for (int i = 0; i < size; i++) {
            if (books[i].getIsbn() == isbn) {
                return books[i];
            }

        }
        return null;
    }


    //Метод removeBook также ищет книгу по заданному ISBN. Если находит книгу, сохраняет ее в переменной victim,
    // затем заменяет эту книгу последней книгой в массиве books и уменьшает значение size на 1.
    // После этого удаляет последнюю книгу (которая была перемещена) из массива и возвращает удаленную книгу victim.
    // Если книга с заданным ISBN не найдена, возвращает null.
    public Book removeBook(long isbn) {
        Book victim = null;
        for (int i = 0; i < size; i++) {
            if (books[i].getIsbn() == isbn) {
                victim = books[i];
                books[i] = books[size - 1];
                books[size - 1] = null;
                size--;
                break;

            }

        }
        return victim;
    }
}
