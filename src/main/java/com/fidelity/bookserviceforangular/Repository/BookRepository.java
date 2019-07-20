package com.fidelity.bookserviceforangular.Repository;

import com.fidelity.bookserviceforangular.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookRepository implements Books {
    @Autowired
    Book book;

    private List<Book> books;
    private long bookId;

    BookRepository(Book book){
        books = new ArrayList<Book>();
        books.add(new Book("Design Patterns", "Gamma, Helm, Johnson, Vlissides", "covers/9780201633610.jpg", 4));
        books.add(new Book("UML Distilled", "Martin Fowler", "covers/umldist.jpg", 3));
        books.add(new Book("Clean Code", "Robert Martin", "covers/cleancode.jpg", 2));
        books.add(new Book("Cryptonomicon", "Neal Stephenson", "", 1));

        bookId = 4;
    }

    @Override
    @GetMapping
    public List<Book> queryBooksByTitle(@RequestParam(defaultValue = "") String title ) {
        return this.books.stream()
                .filter(book -> book.getTitle().contains(title))
                .collect(Collectors.toList());
    }


    @Override
    @PostMapping
    public Book addBook(Book book) {
        book.setBookId(++bookId);
        books.add(book);
        return book;
    }
}
