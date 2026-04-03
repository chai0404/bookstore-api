package com.litshelf.litshelf_api.service;
import java.util.List;
import com.litshelf.litshelf_api.dto.BookDTO;

import com.litshelf.litshelf_api.entity.Book;






public interface BookService {

    Book saveBook(Book book);

    

    BookDTO getBookById(Long id);

    Book updateBook(Long id, Book book);
    
    List<Book> getAllBooks();
    void deleteBook(Long id);
    
   

    List<Book> searchByTitle(String title);

    List<Book> searchByAuthor(String author);
    
    Book findBookEntityById(Long id);
}