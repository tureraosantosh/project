package in.career.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.career.model.Book;
import in.career.service.BookService;

@Controller
public class BookController {

	@GetMapping("/")
	public String loadBook(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "addBook";
	}

	@PostMapping("/addBook")
	public String handleBookSubmit(Book book, Model model) {
		model.addAttribute("book", book);
		return "redirect://books";
	}

	@GetMapping("/books")
	public String getBooks(Model model) {
		return "bookDetails";
	}
	
	@Autowired
	private BookService bookService;
}
