package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.ErrorResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionDao;
	
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>> (this.jobPositionDao.findAll(),"İş pozisyonları listelendi");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		var existBefore = getById(jobPosition.getId());
				
		if(existBefore.isSuccess()) {
			return new ErrorResult("Bu iş pozisyonu zaten kayıtlı");
		}
		
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("İş pozisyonu eklendi");
	}

	@Override
	public DataResult<JobPosition> getById(int id) {
		var result = this.jobPositionDao.findById(id);
		return result.isEmpty() ? new ErrorDataResult<JobPosition>("İş pozisyonu bulunamadı") : new SuccessDataResult<JobPosition>(result.get(),"Kullanıcı gönderildi");
	}


}
