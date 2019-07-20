package com.fidelity.bookserviceforangular.model;

import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class Book {
    private String title;
    private String author;
    private String cover;
    private long bookId;

    public Book() {
    }

    public Book(String title, String author, String cover, long bookId) {
        super();
        this.title = title;
        this.author = author;
        this.cover = cover;
        this.bookId = bookId;
    }

    public String getTitle() { return title; }

    public void setBookId(long l) { bookId = l; }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", cover='" + cover + '\'' +
                ", bookId=" + bookId +
                '}';
    }

}
