package in.career.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Users {
	@Id
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String contact;
	private String dob;
	private String gender;
	private String tempPassword;
	private Long countryId;
	private Long stateId;
	private Long cityId;

}
