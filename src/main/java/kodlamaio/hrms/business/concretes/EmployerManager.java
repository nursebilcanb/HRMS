package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.validationRules.EmailValidator;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.ErrorResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public Result register(Employer employer) {
		Result isVerify = verifyEmail(employer.getEmail());
		Result isVerifyByEmployee= verifyByEmployee();

		var existBefore = getById(employer.getId());
		
		if(existBefore.isSuccess()) {
			return new ErrorResult("Kullanıcı zaten mevcut");
		}
		
		if((isVerify.isSuccess()) && (isVerifyByEmployee.isSuccess())) {
			this.employerDao.save(employer);
			return new SuccessResult("Kayıt olundu");
		}
		return new ErrorResult("Kayıt olunamadı");
	}

	@Override
	public Result verifyEmail(String email) {
		boolean isEmailValid = EmailValidator.isEmailValid(email);
		
		if(isEmailValid) {
			return new SuccessResult("Email doğrulandı");
		}
		return new ErrorResult("Email doğrulanamadı");
	}

	@Override
	public Result verifyByEmployee() {
		return new SuccessResult("Sistem tarafından onaylandı");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İş verenler listelendi");
	}

	@Override
	public Result addNotice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<Employer> getById(int id) {
		var result = employerDao.findById(id);

		return result.isEmpty() ? new ErrorDataResult<Employer>("Kullanıcı bulunamadı") : new SuccessDataResult<Employer>(result.get(),"Kullanıcı gönderildi");
	}

}
