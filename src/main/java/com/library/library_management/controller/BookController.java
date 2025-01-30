package com.library.library_management.controller;

import com.library.library_management.model.Book;
import com.library.library_management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/search/title/{title}")
    public List<Book> getBooksByTitle(@PathVariable String title) {
        return bookService.searchBooksByTitle(title);
    }

    @GetMapping("/search/author/{author}")
    public List<Book> getBooksByAuthor(@PathVariable String author) {
        return bookService.searchBooksByAuthor(author);
    }

    @PostMapping("/")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @PostMapping("/rent/{id}")
    public void rentBook(@PathVariable Long id) {
        bookService.rentBook(id);
    }

    @PostMapping("/return/{id}")
    public void returnBook(@PathVariable Long id) {
        bookService.returnBook(id);
    }
}
