package in.career.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.career.entity.State;

public interface StateRepo extends JpaRepository<State, Serializable> {

	List<State> findStatesByCountryId(Integer countryId);

}
