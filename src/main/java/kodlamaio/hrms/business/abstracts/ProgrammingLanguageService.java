package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {

	DataResult<List<ProgrammingLanguage>> getAll();
	DataResult<ProgrammingLanguage> getById(int id);

	Result add(ProgrammingLanguage programmingLanguage);
}
