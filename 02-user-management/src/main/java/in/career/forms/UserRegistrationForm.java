package in.career.forms;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationForm {
	
	private String fname;
	private String lname;
	private String email;
	private Long phno;
	 private LocalDate dob;
	 private String gender;
	 private Long countryId;
	 private Long stateId;
	 private Long cityId;
	 

}
