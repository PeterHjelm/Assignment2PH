package se.yrgo.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Reader {
    @Id
    @GeneratedValue
    private int id;
    @Column(length = 40)
    private String name;
    @Column(length = 40)
    private String email;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Book> books;

    public Reader() {}

    public Reader(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", books=" + books +
                '}';
    }
}
