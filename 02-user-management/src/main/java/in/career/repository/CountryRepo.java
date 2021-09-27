package in.career.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.career.entity.Country;

public interface CountryRepo extends JpaRepository<Country, Serializable> {

}
