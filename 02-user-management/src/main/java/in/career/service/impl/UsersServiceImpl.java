package in.career.service.impl;

import static in.career.constants.AppConstatns.CANDIDATE_CHARS;
import static in.career.constants.AppConstatns.DUPLICATE;
import static in.career.constants.AppConstatns.EMAIL;
import static in.career.constants.AppConstatns.FNAME;
import static in.career.constants.AppConstatns.FORGOT_EMAIL_FILE;
import static in.career.constants.AppConstatns.LNAME;
import static in.career.constants.AppConstatns.LOCKED;
import static in.career.constants.AppConstatns.TEMP_PWD;
import static in.career.constants.AppConstatns.UNIQUE;
import static in.career.constants.AppConstatns.UNLOACK_EMAIL_FILE;
import static in.career.constants.AppConstatns.UNLOCKED;
import static in.career.constants.AppConstatns.UNLOCK_ACC_EMAIL_SUB;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.career.constants.AppConstatns;
import in.career.entity.City;
import in.career.entity.Country;
import in.career.entity.State;
import in.career.entity.Users;
import in.career.forms.LoginForm;
import in.career.forms.UnloackAccForm;
import in.career.forms.UserRegistrationForm;
import in.career.properties.AppProps;
import in.career.repository.CityRepo;
import in.career.repository.CountryRepo;
import in.career.repository.StateRepo;
import in.career.repository.UserRepo;
import in.career.service.UsersService;
import in.career.util.EmailUtils;;

@Service
public class UsersServiceImpl implements UsersService {

	String mailBody;

	public UsersServiceImpl() {
	}

	@Autowired
	private CountryRepo countryRepo;
	@Autowired
	private StateRepo stateRepo;
	@Autowired
	private CityRepo cityRepo;
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private EmailUtils emailUtils;

	@Autowired
	private AppProps appProps;

	@Override
	public String loginCheck(LoginForm loginForm) {
		String msg;
		Optional<Users> users = userRepo.findByEmailAndPazzword(loginForm.getEmail(), loginForm.getPazzword());
		if (users.isPresent()) {
			Users users2 = users.get();
			if (AppConstatns.LOCKED.equals(users2.getAcctStatus())) {
				msg = appProps.getMessages().get(AppConstatns.ACCOUNT_LOCKED);

			} else {
				msg = appProps.getMessages().get(AppConstatns.SUCCESS);

			}

		} else {
			msg = appProps.getMessages().get(AppConstatns.INVALID_CREDENTIALS);
		}

		return msg;
	}

	@Override
	public Map<Integer, String> getCountries() {

		List<Country> countries = countryRepo.findAll();

		HashMap<Integer, String> countryMap = new HashMap<>();

		for (Country country : countries) {
			countryMap.put(country.getId(), country.getCountryName());
		}

//		countries.forEach(con -> {
//			countryMap.put(con.getId(), con.getCountryName());
//		});

		return countryMap;
	}

	@Override
	public Map<Integer, String> getStates(Integer countryId) {

		HashMap<Integer, String> statesMap = new HashMap<>();

		List<State> statesByCountryById = stateRepo.findStatesByCountryId(countryId);

		statesByCountryById.forEach(state -> {
			statesMap.put(state.getId(), state.getStateName());
		});
		return statesMap;

	}

	@Override
	public Map<Integer, String> getCities(Integer stateId) {

		HashMap<Integer, String> cityMap = new HashMap<>();
		List<City> cities = cityRepo.findByStateId(stateId);
		cities.forEach(city -> {

			cityMap.put(city.getId(), city.getCityName());
		});

		return cityMap;
	}

	@Override
	public String emailCheck(String emailId) {

		Users users = new Users();
		users.setEmail(emailId);
		Example<Users> example = Example.of(users);

		Optional<Users> findOne = userRepo.findOne(example);
		if (findOne.isPresent()) {
			return DUPLICATE;
		} else {
			return UNIQUE;
		}

	}

	@Override
	public boolean saveUser(UserRegistrationForm userForm) {
		Users entity = new Users();
		BeanUtils.copyProperties(userForm, entity);
		entity.setAcctStatus(LOCKED);
		entity.setPazzword(generateRandomChars(6));
		// TODO:Password Encryption.
		Users savedUser = userRepo.save(entity);
		String readUnloackAccEmailBody = readUnloackAccEmailBody(savedUser);
		String subject = appProps.getMessages().get(UNLOCK_ACC_EMAIL_SUB);
		emailUtils.sendEmail(userForm.getEmail(), subject, readUnloackAccEmailBody);
		return savedUser.getId() != null;
	}

	@Override
	public boolean unlockAccount(UnloackAccForm unloackAccForm) {
		String email = unloackAccForm.getEmail();
		String tempPazzword = unloackAccForm.getTempPazzword();
		Optional<Users> user = userRepo.findByEmailAndPazzword(email, tempPazzword);
		if (user.isPresent()) {
			Users users = user.get();
			users.setAcctStatus(UNLOCKED);
			users.setPazzword(unloackAccForm.getNewPazzword());
			userRepo.save(users);
			return true;
		}
		return false;
	}

	@Override
	public boolean forgotPwd(String emailId) {

		Users users = new Users();
		users.setEmail(emailId);
		Example<Users> example = Example.of(users);
		Optional<Users> findOne = userRepo.findOne(example);

		if (findOne.isPresent()) {
			Users foundUser = findOne.get();
			String email2 = foundUser.getEmail();
			String pazzword = foundUser.getPazzword();
			String body = readForgotPasswordEmailBody(foundUser);
			String subject = appProps.getMessages().get(AppConstatns.FORGOT_EMAIL_FILE);
			emailUtils.sendEmail(email2, subject, body);
			// TODO Send mail to User

			return true;
		}
		return false;
	}

	private String readForgotPasswordEmailBody(Users user) {
		String mailBody = "";
		StringBuffer sb = new StringBuffer("");
		FileReader fileReader;
		try {

			String unlockFileName = appProps.getMessages().get(FORGOT_EMAIL_FILE);
			fileReader = new FileReader(unlockFileName);
			BufferedReader br = new BufferedReader(fileReader);
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}

			mailBody = sb.toString();

			mailBody = mailBody.replace(FNAME, user.getFname());
			mailBody = mailBody.replace(LNAME, user.getLname());
			mailBody = mailBody.replace(TEMP_PWD, user.getPazzword());

			br.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return mailBody;

	}

	private static String generateRandomChars(int length) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(CANDIDATE_CHARS.charAt(random.nextInt(CANDIDATE_CHARS.length())));
		}
		return sb.toString();
	}

	private String readUnloackAccEmailBody(Users user) {
		String mailBody = "";
		StringBuffer sb = new StringBuffer("");
		FileReader fileReader;
		try {

			String unlockFileName = appProps.getMessages().get(UNLOACK_EMAIL_FILE);
			fileReader = new FileReader(unlockFileName);
			BufferedReader br = new BufferedReader(fileReader);
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}

			mailBody = sb.toString();

			mailBody = mailBody.replace(FNAME, user.getFname());
			mailBody = mailBody.replace(LNAME, user.getLname());
			mailBody = mailBody.replace(TEMP_PWD, user.getPazzword());
			mailBody = mailBody.replace(EMAIL, user.getEmail());
			br.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return mailBody;

	}

}
