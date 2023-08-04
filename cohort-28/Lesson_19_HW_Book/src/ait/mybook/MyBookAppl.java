package ait.mybook;

import ait.mybook.model.MyBook;

import java.awt.print.Book;

public class MyBookAppl {
    public static void main(String[] args) {
        MyBook[] books = new MyBook[5];
        books[0] = new MyBook(2000000000000l, "Book0", 1988);
        books[1] = new MyBook(3000000000000l, "Book1", "Author1", 1998);
        books[2] = new MyBook(4000000000000l, "Book2", "Author1", 1995);
        books[3] = new MyBook(5000000000000l, "Book3", "Author2", 1990);
        books[4] = new MyBook(6000000000000l, "Book4", 1981);
        printBooks(books);
        System.out.println("Oldest book");
        MyBook oldestBook = findOldestBook(books);
        System.out.println(oldestBook);
        System.out.println("Newest book");
        MyBook newestBook = findnewestBook(books);
        System.out.println(newestBook);
    }

    public static MyBook findOldestBook(MyBook[] books) {
        MyBook res = books[0];
        for (int i = 1; i < books.length; i++) {
            if (res.getYearOfPublishing() > books[i].getYearOfPublishing() && books[i].getYearOfPublishing() >= 0) {
                res = books[i];
            }
        }
        return res;
    }

    public static MyBook findnewestBook(MyBook[] books) {
        MyBook res = books[0];
        for (int i = 1; i < books.length; i++) {
            if (res.getYearOfPublishing() < books[i].getYearOfPublishing()) {
                res = books[i];
            }
        }
        return res;
    }

    public static void printBooks(MyBook[] books) {
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i]);
        }
    }
}