package kodlamaio.hrms.business.concretes;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.adapters.cloudinary.FileService;
import kodlamaio.hrms.business.abstracts.BackgroundService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.ForeignLanguageService;
import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.business.abstracts.ProgrammingLanguageService;
import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.ErrorResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.BackgroundDao;
import kodlamaio.hrms.entities.concretes.Background;
import kodlamaio.hrms.entities.dtos.BackgroundAddDto;

@Service
public class BackgroundManager implements BackgroundService {
	
	private BackgroundDao backgroundDao;
	private FileService fileService;
	private CandidateService candidateService;
	private JobExperienceService jobExperienceService;
	private ForeignLanguageService foreignLanguageService;
	private ProgrammingLanguageService programmingLanguageService;
	private SchoolService schoolService;
	
	
	@Autowired
	public BackgroundManager(BackgroundDao backgroundDao, FileService fileService, CandidateService candidateService,
			JobExperienceService jobExperienceService, ForeignLanguageService foreignLanguageService,
			ProgrammingLanguageService programmingLanguageService, SchoolService schoolService) {
		
		this.backgroundDao = backgroundDao;
		this.fileService = fileService;
		this.candidateService = candidateService;
		this.jobExperienceService = jobExperienceService;
		this.foreignLanguageService = foreignLanguageService;
		this.programmingLanguageService = programmingLanguageService;
		this.schoolService = schoolService;
	}

	@Override
	public DataResult<List<Background>> getAll() {
		return new SuccessDataResult<List<Background>>(this.backgroundDao.findAll(),"Özgeçmişler listelendi");
	}

	@Override
	public Result add(BackgroundAddDto backgroundAddDto) {
		var candidate = this.candidateService.getById(backgroundAddDto.getCandidateId());
		if(!candidate.isSuccess())
			return candidate;
		
		var background = new Background(
				candidate.getData(),
				backgroundAddDto.getGithub(),
				backgroundAddDto.getLinkedin(),
				backgroundAddDto.getCoverLetter());
		
		for(int schoolId : backgroundAddDto.getSchoolIds()) {
			var school = this.schoolService.getById(schoolId).getData();
			background.getSchools().add(school);
		}
		
		for(int jobExperienceId : backgroundAddDto.getJobExperienceIds()) {
			var jobExperience = this.jobExperienceService.getById(jobExperienceId).getData();
			background.getJobExperiences().add(jobExperience);
		}
		
		for(int foreignLanguageId : backgroundAddDto.getForeignLanguageIds()) {
			var foreignLanguage = this.foreignLanguageService.getById(foreignLanguageId).getData();
			background.getForeignLanguages().add(foreignLanguage);
		}
	
		for(int programmingLanguageId : backgroundAddDto.getProgrammingLanguageIds()) {
			var programmingLanguage = this.programmingLanguageService.getById(programmingLanguageId).getData();
			background.getProgrammingLanguages().add(programmingLanguage);
		}
		
		this.backgroundDao.save(background);
		return new SuccessResult("Özgeçmiş eklendi");
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
	public Result addImage(MultipartFile multipartFile, int backgroundId) throws IOException {
		var resumeIsExist = this.getById(backgroundId);
		if(!resumeIsExist.isSuccess()) {
			return resumeIsExist;
		}
		var imageAdd = this.fileService.upload(multipartFile);
		if(!imageAdd.isSuccess()) {
			return new ErrorResult("Resim eklenemedi");
		}
		
		var currentResume = resumeIsExist.getData();
        Map<String, String> newImage = (Map<String, String>) imageAdd.getData();
        
        currentResume.setImageUrl((newImage.get("url"))); 

        return new SuccessResult("Özgeçmişe resim eklendi");
	}

}
