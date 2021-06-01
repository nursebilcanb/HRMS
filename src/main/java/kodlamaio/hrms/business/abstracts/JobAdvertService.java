package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertDto;

public interface JobAdvertService {
	DataResult<List<JobAdvertDto>> getAllByActivity(Boolean activityStatus);
	DataResult<List<JobAdvertDto>> getAllActiveAdvertsByDate();
	DataResult<List<JobAdvertDto>> getAllActiveAdvertsByEmployerId(int employerId);
	
	DataResult<JobAdvert> getById(int jobAdvertId);
	
	Result add(JobAdvert jobAdvert);
	Result update(JobAdvert jobAdvert);
	Result convertToPassive(int jobAdvertId);

}
