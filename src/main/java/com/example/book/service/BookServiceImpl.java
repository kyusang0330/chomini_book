package com.example.book.service;

import com.example.book.dao.BookDAOImpl;
import com.example.book.dto.BookRequestDTO;
import com.example.book.dto.BookResponseDTO;
import com.example.book.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookDAOImpl bookDAO;
    @Override
    public void insert(BookRequestDTO bookdto) {
        Book bookEntity = new Book(bookdto.getName(),bookdto.getWriter(),bookdto.getRegistrant());
        bookDAO.insert(bookEntity);
    }
    @Override
    public Book findById(Long id) {
        return bookDAO.findById(id);
    }
    @Override
    public void delete(Long id) {
        bookDAO.delete(id);
    }
    @Override
    public List<BookResponseDTO> findAll() {
        List<Book> books = bookDAO.findAll();
        List<BookResponseDTO> booklist = new ArrayList<>();
        BookResponseDTO bookdto = null;
        for (Book book : books) {
            bookdto = new BookResponseDTO(book.getBookId(),book.getCreationDate(),book.getName(),
                    book.getWriter(),book.getRegistrant());
            booklist.add(bookdto);
        }
        return booklist;
    }
}



//public class ReportService {
//    public Page<Report> getReportListPagination(
//                                                int page,
//                                                int size,
//                                                String tag,
//                                                String search) {
//        PageRequest pageable = PageRequest.of(page, size);
//        return reportDAO.getReportListPagination(pageable, tag, search);
//    }
//}

