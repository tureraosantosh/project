package in.career.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import in.career.entity.PhoneBook;
import in.career.service.PhoneBookService;

@Controller
public class PhoneBookViewController {

	@Autowired
	private PhoneBookService phoneBookService;

//	@GetMapping("allContacts")
//	public ModelAndView getAllContacts() {
//
//		ModelAndView mav = new ModelAndView();
//		/*
//		 * */
//
//		List<PhoneBook> allPhoneBook = phoneBookService.getAllPhoneBook();
//		mav.addObject("allPhoneBook", allPhoneBook);
//		mav.setViewName("viewContacts");
//
//		return mav;
//	}

	@GetMapping("allContacts")
	public ModelAndView getAllContacts(HttpServletRequest request) {

		Integer pageNo = 1;
		Integer pageSize = 2;
		String page = request.getParameter("pageNo");
		if (page != null && !page.isEmpty()) {
			pageNo = Integer.parseInt(page);
		}

		ModelAndView mav = new ModelAndView();

		Page<PhoneBook> allPhoneBookByPages = phoneBookService.getAllPhoneBookByPages(pageNo - 1, pageSize);
		int totalPages = allPhoneBookByPages.getTotalPages();
		List<PhoneBook> allPhoneBook = allPhoneBookByPages.getContent();
		mav.addObject("allPhoneBook", allPhoneBook);
		mav.addObject("tp", totalPages);
		mav.addObject("currentPage", pageNo);
		mav.setViewName("viewContacts");
		

		return mav;
	}

}
