package com.example.book.service;

import com.example.book.dao.BookDAO;
import com.example.book.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookDAO bookDAO;
    public void insert(Book book) {
        bookDAO.insert(book);
    }

    public Book findById(Long id) {
        return bookDAO.findById(id);
    }

    public void delete(Long id) {
        bookDAO.delete(id);
    }

    public void update(Book book) {
        bookDAO.update(book);
    }

    public List<Book> findAll() {
        return bookDAO.findAll();
    }
}
