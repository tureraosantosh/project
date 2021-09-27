package in.career.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.career.model.Book;

public interface BookRepo extends JpaRepository<Book, Serializable>{
	
	

}
