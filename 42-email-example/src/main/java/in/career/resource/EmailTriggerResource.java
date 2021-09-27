package in.career.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.career.utils.EmailUtils;

@RestController
public class EmailTriggerResource {

	@Autowired
	private EmailUtils emailUtils;

	@GetMapping
	public boolean sendEmail() {

		String body = "this is text body";
		String subject = "welcome";
		String to = "tureraosantosh@gmail.com";
		return emailUtils.sendEmail(to, subject, body);

	}

}
