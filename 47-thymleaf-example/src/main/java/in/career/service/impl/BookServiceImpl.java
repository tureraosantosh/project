package in.career.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import in.career.model.Book;
import in.career.repo.BookRepo;
import in.career.service.BookService;

public class BookServiceImpl implements BookService {
	
	
	@Autowired
	private BookRepo bookRepo;

	@Override
	public List<Book> getBooks() {		
		List<Book> books = bookRepo.findAll();
		return books;
	}

}
