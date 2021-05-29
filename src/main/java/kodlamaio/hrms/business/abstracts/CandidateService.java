package kodlamaio.hrms.business.abstracts;


import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateService {

	Result register(Candidate candidate);
	Result verifyEmail(String email);
	
	DataResult<List<Candidate>> getAll();
	DataResult<Candidate> getById(int id);

}
