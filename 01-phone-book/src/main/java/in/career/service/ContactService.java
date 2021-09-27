package in.career.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.career.entities.Contact;
import in.career.repo.ContactRepo;

@Service
public class ContactService {

	@Autowired
	private ContactRepo contactRepo;

	public Boolean saveContact(Contact contact) {

		Contact contacts = contactRepo.save(contact);
		if(contacts==null) {
			return false;
		}

		return true;
	}

	public Contact getContactById(Integer id) {
		Optional<Contact> findById = contactRepo.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	public List<Contact> getContacts() {

		List<Contact> allContacts = contactRepo.findAll();
		return allContacts;
	}

	public boolean deleteContactById(Integer id) {
		boolean existsById = contactRepo.existsById(id);
		if (existsById) {
			contactRepo.deleteById(id);
			return true;
		}
		return false;
	}

}
