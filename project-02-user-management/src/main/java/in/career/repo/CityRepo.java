package in.career.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.career.entity.Cities;

@Repository
public interface CityRepo extends JpaRepository<Cities, Long> {

}
