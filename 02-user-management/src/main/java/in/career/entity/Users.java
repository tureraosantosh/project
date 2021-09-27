package in.career.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

	@Id
	@GeneratedValue
	private Long id;
	private String fname;
	private String lname;
	@Column(unique = true)
	private String email;
	private String pazzword;
	private Long phno;
	private LocalDate dob;
	private String gender;
	private Long countryId;
	private Long stateId;
	private Long cityId;
	private String acctStatus;
	
	@Column(updatable=false)
	private LocalDateTime createdDate;
	@Column(insertable=false)
	private LocalDateTime updatedDate;
	

}
