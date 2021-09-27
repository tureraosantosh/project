package in.career.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.career.entities.Contact;
import in.career.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	@GetMapping("/")
	public String loadForm(Model model) {
		Contact contact = new Contact();
		model.addAttribute("contact", contact);
		return "contact";
	}

	@PostMapping("saveContact")
	public String handleSaveBtnClick(Contact con, Model model) {
		Boolean saveContact = contactService.saveContact(con);
		if (saveContact) {
			model.addAttribute("successMsg", "Contact Saved Successfully");
			
		} else {
			model.addAttribute("failedMsg", "Contact Saved Failed");

		}

		return "contact";
	}

}
