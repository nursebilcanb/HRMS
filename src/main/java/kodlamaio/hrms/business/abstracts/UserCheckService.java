package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface UserCheckService {
	boolean checkIfRealPerson(Candidate candidate);
}
