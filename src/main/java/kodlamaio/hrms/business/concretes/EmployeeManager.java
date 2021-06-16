package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.ErrorResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessResult;

@Service
public class EmployeeManager implements EmployeeService{

	private EmployerService employerService;
	
	@Autowired
	public EmployeeManager(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}

	@Override
	public Result verifyEmployer(int userId) {
		var employer = employerService.getById(userId);
        if (!employer.isSuccess())
            return new ErrorResult("İşveren bulunamadı");	
        
        if(employer.getData().isVerifyByEmployee()) {
        	return new ErrorResult("Bu işveren zaten onaylanmış");
        }
        
        employer.getData().setVerifyByEmployee(true);
        
        return new SuccessResult("İş veren çalışanlar tarafından onaylandı");
	}
	
}
