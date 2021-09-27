package in.career.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static in.career.constants.AppConstatns.GREET;
import static in.career.constants.AppConstatns.WELCOME_MSG;

import  in.career.properties.AppProps;

@RestController
public class WelcomeRestController {

	@Autowired
	private AppProps appProps;

	@GetMapping
	public String getWelcomeMsg() {
		Map<String, String> messages = appProps.getMessages();
		String welComeMsg = messages.get(WELCOME_MSG);
		return welComeMsg;
	}

	@GetMapping("/greet")
	public String getGreetMsg() {
		Map<String, String> messages = appProps.getMessages();
		String welComeMsg = messages.get(GREET);
		return welComeMsg;
	}
}
