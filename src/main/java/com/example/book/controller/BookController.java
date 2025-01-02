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
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public Book update(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping("/{id}")
    public String delete(@PathVariable Long id) {
        bookService.delete(id);
        return "Rent deleted successfully! delete -------";
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
//    @GetMapping("/list")
//    public String getReportListPagination(
//                                          @RequestParam(required = false) String tag,
//                                          @RequestParam(required = false) String search,
//                                          @RequestParam(defaultValue = "0") int page,
//                                          @RequestParam(defaultValue = "10") int size) {
//        Page<Report> reports = reportService.getReportListPagination(page, size, tag, search);

//        // 페이지 번호 계산 로직
//        List<Integer> pageNumbers = //... (기존 계산 로직 사용)
//                model.addAttribute("pageNumbers", pageNumbers);
//
//        // 필터 추가
//        Map<String, String> currentFilters = new HashMap<>();
//        currentFilters.put("tag", tag != null ? tag : "");
//        currentFilters.put("search", search != null ? search : "");
//        model.addAttribute("currentFilters", currentFilters);
//
//        return
//    }
//}

