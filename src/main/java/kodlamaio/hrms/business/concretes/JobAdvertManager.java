package kodlamaio.hrms.business.concretes;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.business.validationRules.JobAdvertValidation;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.ErrorResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertDto;

@Service
public class JobAdvertManager implements JobAdvertService{
	
	private JobAdvertDao jobAdvertDao;

	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public DataResult<List<JobAdvertDto>> dtoGetJobAdvertsByIsActivated(boolean activityStatus) {
		var result = this.jobAdvertDao.dtoGetJobAdvertsByIsActivatedIs(activityStatus);
		return result.isEmpty() ? new ErrorDataResult<List<JobAdvertDto>>("Aktif iş ilanı bulunamadı") : new SuccessDataResult<List<JobAdvertDto>>(result, "Aktif iş ilanları listelendi"); 
	}

	@Override
	public DataResult<List<JobAdvertDto>> dtoGetAllActiveAdvertsByDate() {
		var result = this.jobAdvertDao.dtoGetJobAdvertsByIsActivatedIs(true);

        var sortedResult = result.stream()
                .sorted(Comparator.comparing(JobAdvertDto::getCreatedAt).reversed())
                .collect(Collectors.toList());

        return result.isEmpty()
                ? new ErrorDataResult<List<JobAdvertDto>>("Aktif iş ilanı bulunamadı")
                : new SuccessDataResult<List<JobAdvertDto>>(sortedResult, "İş ilanları tarihe göre listelendi");
	}

	@Override
	public DataResult<List<JobAdvertDto>> dtoGetAllActiveAdvertsByEmployerId(int employerId) {
		var result = this.jobAdvertDao.dtoGetAllActiveAdvertsByEmployerId(employerId);
		
		return result.isEmpty() ? new ErrorDataResult<List<JobAdvertDto>>("Bu firmaya ait iş ilanı bulunamadı") : new SuccessDataResult<List<JobAdvertDto>>(result,"Bu firmaya ait iş ilanlari listelendi");
	}

	@Override
	public DataResult<JobAdvert> getById(int jobAdvertId) {
		var result = this.jobAdvertDao.findById(jobAdvertId);
		return result.isEmpty() ? new ErrorDataResult<JobAdvert>("İş ilanı bulunamadı") : new SuccessDataResult<JobAdvert>(result.get(),"İş ilanı getirildi");
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("İş ilanı eklendi");
	}

	@Override
	public Result convertToPassive(int jobAdvertId) {
		var isExist = this.getById(jobAdvertId);
		
		if(!isExist.isSuccess()) {
			return isExist;
		}
		
		isExist.getData().setActivated(false);
		
		var result = this.update(isExist.getData());
		if(result == null) {
			return new ErrorResult("İş ilanı pasifleştirilemedi");
		}
		
		return new SuccessResult("İş ilanı başarıyla pasifleştirildi");
	}

	@Override
	public Result update(JobAdvert jobAdvert) {
		var validate = JobAdvertValidation.checkValidate(jobAdvert);
        if (validate != null)
            return validate;

        this.jobAdvertDao.save(jobAdvert);
        return new SuccessResult("İş ilanı başarıyla güncellendi");
	}

}
