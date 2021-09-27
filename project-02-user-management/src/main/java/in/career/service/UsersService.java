package in.career.service;

import java.util.Map;

public interface UsersService {	
	 public Map<Long,String> getCountry();
	 public Map<Long,String> getStates(Long countryId);
	 public Map<Long,String>  getCities(Long stateId);

}
