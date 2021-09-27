package in.career.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("welcome")
public class WelcomeController {

	@GetMapping("/")
	public String welcomeMsgs(Model model) {
		model.addAttribute("msg", "WELCOME To Learn!! Santosh");
		return "index";
	}

}
