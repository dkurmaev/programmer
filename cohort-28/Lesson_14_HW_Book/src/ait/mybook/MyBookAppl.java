package ait.mybook;


import ait.mybook.model.MyBook;

public class MyBookAppl {
    public static void main(String[] args) {
        MyBook[] books = new MyBook[6];
        for (int i = 0; i < books.length; i++) {
            //System.out.println(books[i]);
        }
        books[0] = new MyBook(97837475026315L, "JavaScript für Kids", "Hans-Georg Schumann", 2020);
        books[1] = new MyBook("JavaScript für Kids", "Hans-Georg Schumann", 2021);
        books[2] = new MyBook(9783747502631L, "JavaScript für Kids", "Hans-Georg Schumann", 1990);
        books[3] = new MyBook(9783747502631L, "JavaScript für Kids", "Hans-Georg Schumann", 2000);
        books[4] = new MyBook("JavaScript für Kids", 2022);
        books[5] = new MyBook(9783747502631L, "JavaScript für Kids", "Hans-Georg Schumann", 1984);
        printBooks(books);
        System.out.println("Oldest Book:" );
        MyBook oldestBook = findOldestBook(books);
        oldestBook.display();
        System.out.println("Newest Book: ");
        MyBook newestBook = findNewestBook(books);
        newestBook.display();


    }

    public static MyBook findOldestBook(MyBook[] books) {
        MyBook res = books[0];
        for (int i = 0; i < books.length; i++) {
            if (res.getYearOfPublishing() > books[i].getYearOfPublishing()) {
                res = books[i];
            }

        }
        return res;
    }

    public static MyBook findNewestBook(MyBook[] books) {
        MyBook res = books[0];
        for (int i = 0; i < books.length; i++) {
            if (res.getYearOfPublishing() < books[i].getYearOfPublishing()) {
                res = books[i];
            }

        }
        return res;
    }

    public static void printBooks(MyBook[] books) {
        for (int i = 0; i < books.length; i++) {
            books[i].display();
        }
    }

}

