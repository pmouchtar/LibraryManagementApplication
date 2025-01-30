package com.library.library_management.service;

import com.library.library_management.model.Book;
import com.library.library_management.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<Book> searchBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Long id, Book book) {
        book.setId(id);
        return bookRepository.save(book);
    }

    public void rentBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow();
        if (!book.isRented()) {
            book.setRented(true);
            bookRepository.save(book);
        }
    }

    public void returnBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow();
        if (book.isRented()) {
            book.setRented(false);
            bookRepository.save(book);
        }
    }
}
