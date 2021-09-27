package in.career.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.career.entity.City;

public interface CityRepo extends JpaRepository<City, Serializable> {

	List<City> findByStateId(Integer stateId);

}
