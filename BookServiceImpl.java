package com.litshelf.litshelf_api.service;

import com.litshelf.litshelf_api.dto.BookDTO;
import com.litshelf.litshelf_api.entity.Book;
import com.litshelf.litshelf_api.exception.ResourceNotFoundException;
import com.litshelf.litshelf_api.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    // ✅ Save Book
    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    // ✅ Get Book by ID (DTO)
    @Override
    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));

        return new BookDTO(book.getId(), book.getTitle(), book.getAuthor());
    }

    // ✅ Get All Books
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // ✅ Update Book
    @Override
    public Book updateBook(Long id, Book updatedBook) {
        Book existing = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));

        existing.setTitle(updatedBook.getTitle());
        existing.setAuthor(updatedBook.getAuthor());

        return bookRepository.save(existing);
    }

    // ✅ Delete Book
    @Override
    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));

        bookRepository.delete(book);
    }

    // ✅ Search by Title
    @Override
    public List<Book> searchByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    // ✅ Search by Author
    @Override
    public List<Book> searchByAuthor(String author) {
        return bookRepository.findByAuthorContainingIgnoreCase(author);
    }

    // ✅ Get Entity by ID
    @Override
    public Book findBookEntityById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
    }
}