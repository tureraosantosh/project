package in.career.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.career.model.Book;

@Service
public interface BookService {
	
	public List<Book> getBooks();

}
