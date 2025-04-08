package se.yrgo.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Book {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 40)
    private String title;
    @Column(length = 40)
    private String genre;
    @Column(length = 40)
    private int publicationYear;


    @ManyToMany(mappedBy = "bookReader")
    private List<Reader> readerOfBook;

    public Book() {}

    public Book(String title, String genre, int publicationYear) {
        this.title = title;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.readerOfBook = new ArrayList<Reader>();
    }

    public void addReaderOfBook(Reader newReader) {
        this.readerOfBook.add(newReader);
        newReader.addbookReader(this);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public List<Reader> getReaderOfBook() {
        return readerOfBook;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                                '}';
    }
}
