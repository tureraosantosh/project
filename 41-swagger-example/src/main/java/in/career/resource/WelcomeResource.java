package in.career.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeResource {

	@GetMapping("/")
	public String welcome() {
		return "Hello all ";
	}

}
