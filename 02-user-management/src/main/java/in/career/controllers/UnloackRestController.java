package in.career.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.career.forms.UnloackAccForm;
import in.career.service.UsersService;

@RestController
public class UnloackRestController {

	@Autowired
	private UsersService usersService;

	@PostMapping("unlockAcc")
	public String unlockAccount(@RequestBody UnloackAccForm unloackAccForm) {
		boolean status = usersService.unlockAccount(unloackAccForm);
		if (status) {
			return "Account unlocked successfully !!!";
		} else {
			return "Incorect Temprory Password";
		}
	}

}
