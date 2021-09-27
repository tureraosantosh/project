package in.career.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.career.entities.Contact;

public interface ContactRepo extends JpaRepository<Contact, Serializable> {

}
