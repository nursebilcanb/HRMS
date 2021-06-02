package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.ForeignLanguage;

public interface ForeignLanguageService {
	
	DataResult<List<ForeignLanguage>> getAll(); 
	DataResult<ForeignLanguage> getById(int id);
	
	
	Result add(ForeignLanguage foreignLanguage);
}
