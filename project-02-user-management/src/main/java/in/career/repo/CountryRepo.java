package in.career.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.career.entity.Country;
@Repository
public interface CountryRepo extends JpaRepository<Country, Long> {

}
