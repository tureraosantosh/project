package in.career.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.career.entity.PhoneBook;

public interface PhoneBookRepo  extends JpaRepository<PhoneBook, Integer>{

}
