package com.fidelity.bookserviceforangular.Repository;

import com.fidelity.bookserviceforangular.config.Config;
import com.fidelity.bookserviceforangular.model.Book;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookRepository {
    private final Config config;

    private String bookImageBaseUrl;
    private List<Book> books = new ArrayList<>();
    private long bookId = 4;

    BookRepository(Config config) {
        this.config = config;
        bookImageBaseUrl = config.getImagePath();
        books.add(new Book("Design Patterns", "Gamma, Helm, Johnson, Vlissides", bookImageBaseUrl + "9780201633610.jpg", 4));
        books.add(new Book("UML Distilled", "Martin Fowler", bookImageBaseUrl + "umldist.jpg", 3));
        books.add(new Book("Clean Code", "Robert Martin", bookImageBaseUrl + "cleancode.jpg", 2));
        books.add(new Book("Cryptonomicon", "Neal Stephenson", "", 1));
    }

    public List<Book> getBooks(String title) {
        return books.stream()
                .filter(b -> b.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Book addBook(Book book) {
        book.setBookId(++bookId);
        books.add(book);
        return book;
    }
}
