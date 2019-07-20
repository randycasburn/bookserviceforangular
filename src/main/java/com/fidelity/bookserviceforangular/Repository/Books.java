package com.fidelity.bookserviceforangular.Repository;

import com.fidelity.bookserviceforangular.model.Book;
import org.springframework.web.util.UriBuilder;

import java.util.List;

public interface Books {
    List<Book> queryBooksByTitle(String title);
    Book addBook(Book book);
//    List<Book> getBooks();
}
