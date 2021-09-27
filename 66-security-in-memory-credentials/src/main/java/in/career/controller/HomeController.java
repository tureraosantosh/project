package in.career.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String getHome() {
		return "homePage";
	}

	@GetMapping("/welcome")
	public String getWelcome() {
		return "welcomePage";
	}

	@GetMapping("/admin")
	public String getAdmin() {
		return "adminPage";
	}

	@GetMapping("/emp")
	public String getEmp() {
		return "empPage";
	}

	@GetMapping("/mgr")
	public String getMgr() {
		return "mgrPage";
	}

	@GetMapping("/common")
	public String getCommon() {
		return "commonPage";
	}
	
	@GetMapping("/accessDenied")
	public String getAccessDenied() {
		return "accessDenied";
	}
	

}
