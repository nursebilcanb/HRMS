package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserCheckService;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class UserCheckManager implements UserCheckService{

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		
		return true;
	}

}
