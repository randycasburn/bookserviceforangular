package com.fidelity.bookserviceforangular.endpoint;

import com.fidelity.bookserviceforangular.Repository.BookRepository;
import com.fidelity.bookserviceforangular.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/books")
public class BookController {
    private final BookRepository repo;

    public BookController(BookRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Book> queryBooksByTitle(@RequestParam(defaultValue = "") String title ) {
        return repo.getBooks(title);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return repo.addBook(book);
    }

}
