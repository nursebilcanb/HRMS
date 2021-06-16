package kodlamaio.hrms.business.concretes;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.BackgroundService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.BackgroundDao;
import kodlamaio.hrms.entities.concretes.Background;
import kodlamaio.hrms.entities.dtos.BackgroundAddDto;

@Service
public class BackgroundManager implements BackgroundService {
	
	private BackgroundDao backgroundDao;

	@Autowired
	public BackgroundManager(BackgroundDao backgroundDao) {
		super();
		this.backgroundDao = backgroundDao;
	}

	@Override
	public DataResult<List<Background>> getAll() {
		return new SuccessDataResult<List<Background>>(this.backgroundDao.findAll(),"Özgeçmişler listelendi");
	}

	@Override
	public Result add(BackgroundAddDto backgroundAddDto) {
		return null;
	}

	@Override
	public DataResult<Background> getById(int backgroundId) {
		var result = this.backgroundDao.findById(backgroundId);
		return result.isEmpty() ? new ErrorDataResult<Background>("Özgeçmiş bulunamadı")
								: new SuccessDataResult<Background>(result.get());
	}

	@Override
	public DataResult<List<Background>> getByCandidateId(int candidateId) {
		var result = this.backgroundDao.getByCandidateId(candidateId);
		return result.isEmpty() ? new ErrorDataResult<List<Background>>("Bu iş arayanın özgeçmişi bulunamadı")
								: new SuccessDataResult<List<Background>>(result);
	}

	@Override
	public Result addImage(MultipartFile multipartFile, int candidateId) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
