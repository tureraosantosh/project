package in.career.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.career.service.UsersService;

@RestController
public class ForgotPassRestController {

	@Autowired
	private UsersService usersService;

	@GetMapping("/forgotPwd")
	public String forgotPassword(@PathVariable("email") String emailId) {

		boolean status = usersService.forgotPwd(emailId);
		if (status) {
			return "We Have Sent Email To Your Email Id";
		} else {

			return "Please Enter Valid Email";

		}
	}

}
