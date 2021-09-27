package in.career.entity;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class States {
	
	private Long id;
	private String name;
	private Long countryId;
	

}
