package kodlamaio.hrms.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.Background;
import kodlamaio.hrms.entities.dtos.BackgroundAddDto;

public interface BackgroundService {
	DataResult<List<Background>> getAll();
	DataResult<Background> getById(int backgroundId);
	DataResult<List<Background>> getByCandidateId(int candidateId);
	
	Result add(BackgroundAddDto backgroundAddDto);
	Result addImage(MultipartFile multipartFile, int backgroundId) throws IOException;
}
