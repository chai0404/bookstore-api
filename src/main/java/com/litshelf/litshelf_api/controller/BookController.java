package com.litshelf.litshelf_api.controller;

import com.litshelf.litshelf_api.dto.BookDTO;
import com.litshelf.litshelf_api.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // ✅ Get all books
    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    // ✅ Create book
    @PostMapping
    public BookDTO saveBook(@RequestBody BookDTO bookDTO) {
        return bookService.createBook(bookDTO);
    }
}