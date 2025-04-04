package se.yrgo.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 40)
    private String name;
    @Column(length = 40)
    private String email;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Book> bookReader;

    public Reader() {}

    public Reader(String name, String email) {
        this.name = name;
        this.email = email;
        this.bookReader = new ArrayList<>();
    }
    public void addbookReader(Book newBook){
        this.bookReader.add(newBook);
        newBook.getReaderOfBook().add(this);
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                 '}';
    }
}
