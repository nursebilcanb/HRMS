package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.Background;
import kodlamaio.hrms.entities.dtos.BackgroundAddDto;

public interface BackgroundService {
	DataResult<List<Background>> getAll();
	
	Result add(BackgroundAddDto backgroundAddDto);
}
