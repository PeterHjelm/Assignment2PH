package se.yrgo.test;

import jakarta.persistence.*;
import se.yrgo.domain.Author;
import se.yrgo.domain.Book;
import se.yrgo.domain.Reader;

import java.util.List;

public class LibraryTest {

    public static void main(String[] args) {

       setUpData();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("databaseConfig");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        //Task number 2:
        Query q = em.createQuery("SELECT author.booksFromAuthors FROM Author AS author WHERE author.name = 'Astrid Lindgren'");
        List<Book> booksFromAstrid = q.getResultList();
        for (Book book : booksFromAstrid) {
            System.out.println(book);
        }

       //Task number 3:
        Book book2 = em.find(Book.class, 2);
        TypedQuery<Reader> query = em.createQuery("FROM Reader reader WHERE :book member of reader.bookReader",
                Reader.class);
        query.setParameter("book", book2);
        List<Reader> readerOfBook2 = query.getResultList();
        for (Reader reader : readerOfBook2)
            System.out.println(reader);

        //Task number 4:
        Query q2 = em.createQuery("SELECT DISTINCT a FROM Author a JOIN a.booksFromAuthors b " +
                "JOIN b.readerOfBook r");
        List<Author> authors = q2.getResultList();
        for (Author author : authors)
            System.out.println(author);

        //Task number 5:
        List<Object[]> results = em.createQuery(
                "SELECT a.name, COUNT(b) from Author a JOIN a.booksFromAuthors " +
                        "b GROUP BY a.name").getResultList();

        for (Object[] result : results) {
            System.out.println(result[0] + " has written " + result[1] + " books");
        }

        tx.commit();
        em.close();
    }

        public static void setUpData(){

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("databaseConfig");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();

            tx.begin();

            //Task number 1:
            Author author1 = new Author("Astrid Lindgren", "Swedish");
            Author author2 = new Author("J.K Rowling", "British");
            Author author3 = new Author("Jo Nesbö", "Norwegian");

            Book book1 = new Book("Emil i Lönneberga", 1973);
            Book book2 = new Book("Pippi Långstrump", 1969);
            Book book3 = new Book("Harry Potter och de vises sten", 2001);
            Book book4 = new Book("Harry Potter och halvblodsprinsen", 2005);
            Book book5 = new Book("Fladdermusmannen", 1997);
            Book book6 = new Book("Snömannen", 2007);

            author1.addBookToBooksFromAuthor(book1);
            author1.addBookToBooksFromAuthor(book2);
            author2.addBookToBooksFromAuthor(book3);
            author2.addBookToBooksFromAuthor(book4);
            author3.addBookToBooksFromAuthor(book5);
            author3.addBookToBooksFromAuthor(book6);

            Reader reader1 = new Reader("Peter Hjelm", "peter.hjelm1@gmail.com");
            Reader reader2 = new Reader("Kalle Karlsson", "kallekul11@msn.se");
            Reader reader3 = new Reader("Sonja Sundberg", "solenidittliv@hotmail.com");

            book1.addReaderOfBook(reader1);
            book2.addReaderOfBook(reader1);
            book2.addReaderOfBook(reader2);
            book3.addReaderOfBook(reader3);
            book4.addReaderOfBook(reader3);
            book5.addReaderOfBook(reader1);
            book6.addReaderOfBook(reader2);

    em.persist(author1);
    em.persist(author2);
    em.persist(author3);
    em.persist(book1);
    em.persist(book2);
    em.persist(book3);
    em.persist(book4);
    em.persist(book5);
    em.persist(book6);
    em.persist(reader1);
    em.persist(reader2);
    em.persist(reader3);

            tx.commit();
            em.close();
        }
    }

