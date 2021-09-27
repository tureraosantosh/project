package in.career.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.career.utils.EmailUtil;

@RestController
@RequestMapping("email")
public class EmailResource {
	
	@Autowired
	private EmailUtil emailUtil;
	
	@GetMapping("/trigger")
	public boolean emailTrigger()
	{
		return emailUtil.sendEmail("sanketgupta315@gmail.com", "Fist App Email", "Welcome to Learn Email Sending");
	}

}
