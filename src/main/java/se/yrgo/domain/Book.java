package se.yrgo.domain;

public class Book {

    private int id;
    private String title;
    private int publicationYear;

    public Book() {}

    public Book(int id, String title, int publicationYear) {
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
    }
}
