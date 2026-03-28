
package com.litshelf.litshelf_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.litshelf.litshelf_api.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	List<Book> findByTitleContainingIgnoreCase(String title);

    List<Book> findByAuthorContainingIgnoreCase(String author);


}

