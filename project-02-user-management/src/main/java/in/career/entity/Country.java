package in.career.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Country {
	@Id
	private Long id;
	private String countryName;

}
