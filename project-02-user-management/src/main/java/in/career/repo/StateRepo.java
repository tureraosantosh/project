package in.career.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.career.entity.States;
@Repository
public interface StateRepo extends JpaRepository<States, Long> {

}
