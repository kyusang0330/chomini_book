package com.example.book.controller;

import com.example.book.dto.BookRequestDTO;
import com.example.book.dto.BookResponseDTO;
import com.example.book.entity.Book;
import com.example.book.service.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookServiceImpl bookService;
    //도서 등록
    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody BookRequestDTO bookdto) {
        bookService.insert(bookdto);
        return /*"redirect://book/list"*/ResponseEntity.ok(HttpStatus.OK);
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
    //도서 목록
    @GetMapping("/list")
    public List<BookResponseDTO> findAll() {
        return bookService.findAll();
    }
}

//검색과 페이지ㅣ네이션 예시
//public class ReportController {
//
//    private final ReportService reportService;
//
//    @GetMapping("/reports")
//    public String getReportListPagination(Model model,
//                                          @RequestParam(required = false) String startDate,
//                                          @RequestParam(required = false) String endDate,
//                                          @RequestParam(required = false) String status,
//                                          @RequestParam(required = false) String tag,
//                                          @RequestParam(required = false) String search,
//                                          @RequestParam(defaultValue = "0") int page,
//                                          @RequestParam(defaultValue = "10") int size) {
//        Page<Report> reports = reportService.getReportListPagination(startDate, endDate, status, page, size, tag, search);
//        model.addAttribute("reports", reports);
//
//        // 페이지 번호 계산 로직
//        List<Integer> pageNumbers = //... (기존 계산 로직 사용)
//                model.addAttribute("pageNumbers", pageNumbers);
//
//        // 필터 추가
//        Map<String, String> currentFilters = new HashMap<>();
//        currentFilters.put("startDate", startDate != null ? startDate : "");
//        currentFilters.put("endDate", endDate != null ? endDate : "");
//        currentFilters.put("status", status != null ? status : "");
//        currentFilters.put("tag", tag != null ? tag : "");
//        currentFilters.put("search", search != null ? search : "");
//        model.addAttribute("currentFilters", currentFilters);
//
//        return "reports/report-list";
//    }
//}

