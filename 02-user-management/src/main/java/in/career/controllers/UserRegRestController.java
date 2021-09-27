package in.career.controllers;

import static in.career.constants.AppConstatns.USER_REG_FAIL;
import static in.career.constants.AppConstatns.USER_REG_SUCCESS;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.career.forms.UserRegistrationForm;
import in.career.properties.AppProps;
import in.career.service.UsersService;

@RestController
public class UserRegRestController {

	@Autowired
	private UsersService usersService;

	@Autowired
	private AppProps appProps;

	@GetMapping("/countries")
	public Map<Integer, String> getCountries() {
		
		Map<Integer, String> countries = usersService.getCountries();
		
		return countries;
	}

	@GetMapping("/states/{countryId}")
	public Map<Integer, String> getStates(@PathVariable("countryId") Integer countryId) {
		return usersService.getStates(countryId);
	}

	@GetMapping("/cities/{stateId}")
	public Map<Integer, String> getCities(@PathVariable("stateId") Integer stateId) {
		return usersService.getCities(stateId);
	}

	@GetMapping("/emailcheck/{email}")
	public String uniqueEmailCheck(@PathVariable("email") String email) {
		return usersService.emailCheck(email);
	}

	@PostMapping("/saveUser")
	public String saveUser(@RequestBody UserRegistrationForm userForm) {
		boolean saveUser = usersService.saveUser(userForm);
		if (saveUser) {
			return appProps.getMessages().get(USER_REG_SUCCESS);
		} else {
			return appProps.getMessages().get(USER_REG_FAIL);
		}
	}
}
