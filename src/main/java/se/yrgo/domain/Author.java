package se.yrgo.domain;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 40)
    private String name;
    @Column(length = 40)
    private String nationality;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Book> booksFromAuthors;

    public Author () {}

    public Author (String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
        this.booksFromAuthors = new ArrayList<>();
    }

    public void addBookToBooksFromAuthor(Book newBook) {
        this.booksFromAuthors.add(newBook);
    }

    public Set<Book> booksFromAuthors () {
        Set<Book> books = new HashSet<Book>();
        return books;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public List<Book> getBooksFromAuthors() {
        return booksFromAuthors;
    }
}
