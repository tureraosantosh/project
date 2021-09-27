package in.career.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.career.forms.LoginForm;
import in.career.service.UsersService;

@RestController
public class LoginRestController {

	@Autowired
	private UsersService service;

	@PostMapping("/login")
	public String login(@RequestBody LoginForm loginForm) {
		String loginCheck = service.loginCheck(loginForm);
		return loginCheck;
	}

}
