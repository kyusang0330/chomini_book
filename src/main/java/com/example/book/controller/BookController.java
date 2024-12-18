package com.example.book.controller;

import com.example.book.entity.Book;
import com.example.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;
    @PostMapping("/insert")
    public String insert(@RequestBody Book book) {
        bookService.insert(book);
        return "Rent Insert +++++++++++++++";
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        bookService.delete(id);
        return "Rent deleted successfully! delete -------";
    }

    @PostMapping("/update")
    public String update(@RequestBody Book book) {
        bookService.update(book);
        return "Rent updated successfully!update update upupupupup";
    }

    @GetMapping("/all")
    public List<Book> findAll() {
        return bookService.findAll();
    }
}
