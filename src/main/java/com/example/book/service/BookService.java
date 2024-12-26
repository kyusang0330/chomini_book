package com.example.book.service;

import com.example.book.dto.BookRequestDTO;
import com.example.book.dto.BookResponseDTO;
import com.example.book.entity.Book;

import java.util.ArrayList;
import java.util.List;

public interface BookService {
    void insert(BookRequestDTO bookdto);
    Book findById(Long id);
    void delete(Long id);
    void update(Book book);
    List<BookResponseDTO> findAll() ;
}
