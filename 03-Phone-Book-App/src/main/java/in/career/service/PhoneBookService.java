package in.career.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import in.career.entity.PhoneBook;
import in.career.repo.PhoneBookRepo;

@Service
public class PhoneBookService {

	@Autowired
	private PhoneBookRepo phoneRepo;

	public List<PhoneBook> getAllPhoneBook() {

		PhoneBook phoneBook = new PhoneBook();
		phoneBook.setActive(true);

		Example<PhoneBook> example = Example.of(phoneBook);

		List<PhoneBook> allPhoneBooks = phoneRepo.findAll(example);

		List<PhoneBook> allPhoneBook = phoneRepo.findAll();
		return allPhoneBook;

	}

	public Page<PhoneBook> getAllPhoneBookByPages(Integer pageNo, Integer pageSize) {
		PhoneBook phoneBookFilter = new PhoneBook();
		phoneBookFilter.setActive(true);
		Example<PhoneBook> example = Example.of(phoneBookFilter);

		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Page<PhoneBook> page = phoneRepo.findAll(example, pageRequest);
		return page;
	}

	public PhoneBook getPhoneById(Integer id) {
		
		boolean isAvailable = phoneRepo.existsById(id);
		if (isAvailable) {
			Optional<PhoneBook> findById = phoneRepo.findById(id);
			return findById.get();
		}
		return null;
	}

	public boolean deletePhoneById(Integer id) {

		boolean isAvaialbe = phoneRepo.existsById(id);
		if (isAvaialbe) {
			phoneRepo.deleteById(id);
			return true;
		}
		return false;
	}

	public boolean saveContact(PhoneBook phoneBook) {
		PhoneBook saveObject = phoneRepo.save(phoneBook);
		if (saveObject != null) {
			return true;
		} else {
			return false;
		}

	}

}
