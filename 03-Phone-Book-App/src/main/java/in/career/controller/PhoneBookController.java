package in.career.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.career.entity.PhoneBook;
import in.career.service.PhoneBookService;

@Controller
public class PhoneBookController {

	@Autowired
	private PhoneBookService phoneService;

	@GetMapping("delete")
	public String deletePhoneBook(Integer id, Model model) {
		boolean isDeleted = phoneService.deletePhoneById(id);
		if (isDeleted) {

			model.addAttribute("success", "data delete successfully !!!");
			// delete successfully
		} else {
			model.addAttribute("failed", "Unable to delete Data");
			// unable to delete record
		}
		return "redirect:/allContacts";
	}

	@GetMapping("/")
	public ModelAndView loadForm() {
		ModelAndView mav = new ModelAndView();
		PhoneBook phoneBook = new PhoneBook();
		mav.addObject("phoneBook", phoneBook);
		mav.setViewName("contact");
		return mav;
	}

	@PostMapping(value= {"savePhone",})
	public ModelAndView savePhoneBook(PhoneBook phoneBook) {

		boolean isSaved = phoneService.saveContact(phoneBook);
		ModelAndView mav = new ModelAndView();

		if (isSaved) {
			mav.addObject("successMsg", "Data saved Successfully !!");
		} else {
			mav.addObject("failedMsg", "Unable to save data!!!");
		}

		mav.setViewName("contact");

		return mav;

	}

	// update/123
	@GetMapping("update")
	public ModelAndView getContactById(@RequestParam("id") Integer id) {

		PhoneBook phoneBook = phoneService.getPhoneById(id);

		ModelAndView mav = new ModelAndView();
		mav.addObject("phoneBook", phoneBook);
		mav.setViewName("contact");
		return mav;
	}

}
