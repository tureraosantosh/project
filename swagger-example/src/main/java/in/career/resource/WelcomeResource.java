package in.career.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.career.dto.Book;

@RestController
@RequestMapping("/welcome")
public class WelcomeResource {
	
	@GetMapping
	public String welcome()
	{
		return "hello welcome";
	}
	
	@PostMapping
	public Book saveBook(@RequestBody Book book)
	{
		return book;
	}

}
