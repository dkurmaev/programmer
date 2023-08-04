package ait.mybook.model;

public class MyBook {
    private long isbn;
    private String titel;
    private String author;
    private int yearOfPublishing;

    public MyBook(long isbn, String titel, String author, int yearOfPublishing) {
        this.isbn = checkIsbn(isbn);
        this.titel = titel;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
    }

    public MyBook(String titel, String author, int yearOfPublishing) {
        this.titel = titel;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
        isbn = 0;
    }

    public MyBook(String titel, int yearOfPublishing) {
        this.titel = titel;
        this.yearOfPublishing = yearOfPublishing;
        isbn = 0;
        author = "unknow";
    }

    public long getIsbn() {
        return isbn;
    }

    public String getTitel() {
        return titel;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    private long checkIsbn(long isbn){
        if (isbn >=1_000_000_000_000L && isbn <= 9_999_999_999_999L){
            return isbn;
        }
        return -1;
    }
    public void display() {
        System.out.println("ISBN: " + isbn + ", Titel: " + titel + ", Author: " + author + ", Year Of Publishing: " + yearOfPublishing);
        System.out.println("***********************************************************************************************");
    }
}
