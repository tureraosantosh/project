package in.career.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.career.entity.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {

}
