package kodlamaio.hrms.business.concretes;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.hrms.entities.concretes.JobExperience;


@Service
public class JobExperienceManager implements JobExperienceService {

	private JobExperienceDao jobExperienceDao;
	
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}

	@Override
	public DataResult<List<JobExperience>> getAll() {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll());
	}

	@Override
	public DataResult<List<JobExperience>> getByCandidateId(int candidateId) {
		var result = this.jobExperienceDao.getByCandidate_Id(candidateId);
		return result.isEmpty() ? new ErrorDataResult<List<JobExperience>>("İş tecrübesi bulunamadı")
								: new SuccessDataResult<List<JobExperience>>(result,"İş tecrübesi bulundu");
	}

	@Override
	public DataResult<List<JobExperience>> getByCandidateIdAndReverseSort(int candidateId) {
		var result = this.getByCandidateId(candidateId);
		if(!result.isSuccess())
			return result;
		
		var sortedResult = result.getData().stream()
                .sorted(Comparator.comparing(JobExperience::getFinishDate, Comparator.nullsLast(Comparator.naturalOrder())).reversed())
                .collect(Collectors.toList());

        return new SuccessDataResult<List<JobExperience>>(sortedResult);
	}

	@Override
	public DataResult<JobExperience> getById(int id) {
		var result = this.jobExperienceDao.findById(id);
		return result.isEmpty() ? new ErrorDataResult<JobExperience>("İş tecrübesi bulunamadı")
								: new SuccessDataResult<JobExperience>(result.get(),"İş tecrübesi bulundu");
	}

	@Override
	public Result add(JobExperience jobExperience) {
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("İş tecrübesi eklendi");
	}

}
