package in.career.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnloackAccForm {
	
	private String email;
	private String tempPazzword;
	private String confirmPazzword;
	private String newPazzword;
	

}
