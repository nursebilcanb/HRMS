package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.School;

public interface SchoolService {

	DataResult<List<School>> getAll(); 
	DataResult<List<School>> getByCandidateId(int candidateId);
	DataResult<List<School>> getByCandidateIdAndReverseSort(int candidateId);
	DataResult<School> getById(int id);
	
	
	Result add(School school);
}
