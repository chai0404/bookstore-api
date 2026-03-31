package com.litshelf.litshelf_api.service;

import com.litshelf.litshelf_api.dto.BookDTO;
import java.util.List;

public interface BookService {
    // We use BookDTO here so the Controller never touches the Entity directly
    BookDTO createBook(BookDTO bookDTO);
    
    List<BookDTO> getAllBooks();
    
    BookDTO getBookById(Long id);
    
    BookDTO updateBook(Long id, BookDTO bookDTO);
    
    void deleteBook(Long id);

    // Search methods
    List<BookDTO> searchByTitle(String title);
    List<BookDTO> searchByAuthor(String author);
}