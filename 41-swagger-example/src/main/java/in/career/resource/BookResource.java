package in.career.resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.career.entity.Book;

@RestController
public class BookResource {

	@PostMapping
	public Book saveBook(@RequestBody Book book) {
		return book;
	}

}
