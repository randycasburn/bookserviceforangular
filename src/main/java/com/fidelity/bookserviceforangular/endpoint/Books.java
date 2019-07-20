package com.fidelity.bookserviceforangular.endpoint;

import com.fidelity.bookserviceforangular.Repository.BookRepository;
import com.fidelity.bookserviceforangular.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class Books {
    @Autowired
    BookRepository repo;

    @GetMapping
    public List<Book> queryBooksByTitle(@RequestParam(defaultValue = "") String title ) {
        return repo.getBooks().stream()
                .filter(book -> book.getTitle().contains(title))
                .collect(Collectors.toList());
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return repo.addBook(book);
    }

}
