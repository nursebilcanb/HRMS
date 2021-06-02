package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.BackgroundService;
import kodlamaio.hrms.core.utilities.DataResult;
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
		// TODO Auto-generated method stub
		return null;
	}

}
