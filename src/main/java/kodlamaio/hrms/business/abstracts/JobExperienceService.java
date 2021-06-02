package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.JobExperience;

public interface JobExperienceService {

	DataResult<List<JobExperience>> getAll(); 
	DataResult<List<JobExperience>> getByCandidateId(int candidateId);
	DataResult<List<JobExperience>> getByCandidateIdAndReverseSort(int candidateId);
	DataResult<JobExperience> getById(int id);
	
	
	Result add(JobExperience jobExperience);
}
