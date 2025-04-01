package se.yrgo.domain;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String nationality;

    @OneToMany
    private List<Book>authorsBooks;

    public Author () {}

    public Author (int id, String name, String nationality) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
    }
}
