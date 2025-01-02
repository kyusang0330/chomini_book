package com.example.book.dao;

import com.example.book.entity.Book;

import java.util.List;

public interface BookDAO {
    void insert(Book book);
    Book findById(Long id);
    void delete(Long id);
    List<Book> findAll();
}
