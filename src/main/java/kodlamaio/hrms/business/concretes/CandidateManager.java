package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.UserCheckService;
import kodlamaio.hrms.business.validationRules.EmailValidator;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.ErrorResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{

	private UserCheckService userCheckService;
	private CandidateDao candidateDao;
	
	
	@Autowired
	public CandidateManager(UserCheckService userCheckService,CandidateDao candidateDao) {
		super();
		this.userCheckService = userCheckService;
		this.candidateDao = candidateDao;
	}

	@Override
	public Result register(Candidate candidate) {
		boolean result = userCheckService.checkIfRealPerson(candidate);

		var existBefore = getById(candidate.getId());
	
		if(result == false) {
			return new ErrorResult("Gecersiz kullanici");
		}
		
		if(existBefore.isSuccess()) {
			return new ErrorResult("Kullanıcı zaten mevcut");
		}
	
		Result isVerify = verifyEmail(candidate.getEmail());
		if(isVerify.isSuccess()) {
			this.candidateDao.save(candidate);
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
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"İş arayanlar listelendi");
	}

	@Override
	public DataResult<Candidate> getById(int id) {
		var result = this.candidateDao.findById(id);
		return result.isEmpty() ? new ErrorDataResult<Candidate>("Kullanıcı bulunamadı") : new SuccessDataResult<Candidate>(result.get(),"Kullanıcı gönderildi");
	}

}
