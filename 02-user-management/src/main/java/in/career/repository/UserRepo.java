package in.career.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.career.entity.Users;

public interface UserRepo extends JpaRepository<Users, Serializable> {

	Optional<Users> findByEmailAndPazzword(String email, String pazzword);


}
