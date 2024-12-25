package com.example.book.service;

import com.example.book.dao.BookDAO;
import com.example.book.dto.BookRequestDTO;
import com.example.book.dto.BookResponseDTO;
import com.example.book.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookDAO bookDAO;
    public void insert(BookRequestDTO bookdto) {
        Book bookEntity = new Book(bookdto.getName(),bookdto.getWriter(),bookdto.getRegistant());
        bookDAO.insert(bookEntity);
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

    public List<BookResponseDTO> findAll() {
        List<Book> books = bookDAO.findAll();
        List<BookResponseDTO> booklist = new ArrayList<>();
        BookResponseDTO bookdto = null;
        for (Book book : books) {
            bookdto = new BookResponseDTO(book.getBookId(),book.getCreationDate(),book.getName(),
                    book.getWriter(),book.getRegistant());
            booklist.add(bookdto);
        }
        return booklist;
    }
}



//@Service
//@RequiredArgsConstructor
//public class ReportService {
//
//    private final ReportDAO reportDAO;
//
//    public Page<Report> getReportListPagination(String startDate,
//                                                String endDate,
//                                                String status,
//                                                int page,
//                                                int size,
//                                                String tag,
//                                                String search) {
//        PageRequest pageable = PageRequest.of(page, size);
//        return reportDAO.getReportListPagination(startDate, endDate, status, pageable, tag, search);
//    }
//}

