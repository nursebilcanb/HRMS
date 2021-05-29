package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {
	Result register(Employer employer);
	Result verifyEmail(String email);
	Result verifyByEmployee();
	
	Result addNotice();
	
	DataResult<List<Employer>> getAll();
	DataResult<Employer> getById(int id);
	
}
