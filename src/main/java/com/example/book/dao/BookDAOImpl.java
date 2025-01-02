package com.example.book.dao;

import com.example.book.entity.Book;
import com.example.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookDAOImpl implements BookDAO {
    private final BookRepository bookRepository;
    @Override
    public void insert(Book book) {
        bookRepository.save(book);
    }
    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Rent not found"));
    }
    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}


//public class ReportDAO {
//    public Page<Report> getReportListPagination(
//                                                Pageable pageable,
//                                                String tag,
//                                                String search) {
//        return reportRepository.findAll(
//                ReportSpecification.filterReports( tag, search),
//                pageable
//        );
//    }
//}

