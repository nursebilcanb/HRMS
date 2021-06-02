package kodlamaio.hrms.business.concretes;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService {

	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public DataResult<List<School>> getAll() {
		
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll(),"Okullar listelendi");
	}

	@Override
	public DataResult<List<School>> getByCandidateId(int candidateId) {
		var result = this.schoolDao.getByCandidate_Id(candidateId);
		
		return result.isEmpty() ? new ErrorDataResult<List<School>>("bulunamadı") 
								: new SuccessDataResult<List<School>>(result,"Okul getirildi");
	}

	@Override
	public DataResult<List<School>> getByCandidateIdAndReverseSort(int candidateId) {
		var result = this.getByCandidateId(candidateId);
		
		if(!result.isSuccess())
			return result;
		
		var sortedResult = result.getData().stream()
				.sorted(Comparator.comparing(School::getFinishDate, Comparator.nullsLast(Comparator.naturalOrder())).reversed())
				.collect(Collectors.toList());
		return new SuccessDataResult<List<School>>(sortedResult);
	}

	@Override
	public DataResult<School> getById(int id) {
		var result = this.schoolDao.findById(id);
		return result.isEmpty() ? new ErrorDataResult<School>("bulunamadı") 
								: new SuccessDataResult<School>(result.get(),"Okul getirildi");	
		}

	@Override
	public Result add(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("Okul eklendi");
	}

}
