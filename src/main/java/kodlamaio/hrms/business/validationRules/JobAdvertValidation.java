package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.core.utilities.ErrorResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;

public class JobAdvertValidation {

	 public static Result checkValidate(JobAdvert jobAdvert) {
	        boolean result = true;

	        if (!BaseValidation.requiredInteger(jobAdvert.getJobPosition().getId()))
	            result = false;

	        if (!BaseValidation.requiredInteger(jobAdvert.getCity().getId()))
	            result = false;

	        if (!BaseValidation.requiredInteger(jobAdvert.getEmployer().getId()))
	            result = false;

	        if (!BaseValidation.requiredString(jobAdvert.getDescription()))
	            result = false;

	        if (!BaseValidation.requiredInteger(jobAdvert.getOpenPositionAmount()))
	            result = false;

	        if (!BaseValidation.requiredLocalDate(jobAdvert.getApplicationDeadline()))
	            result = false;

	        if (!result)
	            return new ErrorResult("Boş alan bırakmayın");

	        return null;
	        
	 }
}
