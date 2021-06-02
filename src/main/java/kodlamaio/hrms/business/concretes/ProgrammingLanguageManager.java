package kodlamaio.hrms.business.concretes;

import java.util.List;

import kodlamaio.hrms.business.abstracts.ProgrammingLanguageService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ProgrammingLanguageDao;
import kodlamaio.hrms.entities.concretes.ProgrammingLanguage;

public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageDao programmingLanguageDao; 
	
	public ProgrammingLanguageManager(ProgrammingLanguageDao programmingLanguageDao) {
		super();
		this.programmingLanguageDao = programmingLanguageDao;
	}

	@Override
	public DataResult<List<ProgrammingLanguage>> getAll() {
		return new SuccessDataResult<List<ProgrammingLanguage>>(this.programmingLanguageDao.findAll());
	}

	@Override
	public DataResult<ProgrammingLanguage> getById(int id) {
		var result = this.programmingLanguageDao.findById(id);
		return result.isEmpty() ? new ErrorDataResult<ProgrammingLanguage>("Programlama dili bulunamadı")
								: new SuccessDataResult<ProgrammingLanguage>(result.get());
	}

	@Override
	public Result add(ProgrammingLanguage programmingLanguage) {
		this.programmingLanguageDao.save(programmingLanguage);
		return new SuccessResult("Programlama dili eklendi");
	}

}
