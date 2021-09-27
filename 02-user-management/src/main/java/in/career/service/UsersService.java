package in.career.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;

import in.career.forms.LoginForm;
import in.career.forms.UnloackAccForm;
import in.career.forms.UserRegistrationForm;

@Service
public interface UsersService {
	
	public String loginCheck(LoginForm loginForm);

	public Map<Integer, String> getCountries();

	public Map<Integer, String> getStates(Integer countryId);

	public Map<Integer, String> getCities(Integer stateId);

	public String emailCheck (String emailId);

	public boolean saveUser(UserRegistrationForm userForm);

	public boolean unlockAccount(UnloackAccForm unloackAccForm);

	public boolean forgotPwd(String emailId);

}
