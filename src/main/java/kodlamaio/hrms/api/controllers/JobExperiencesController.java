package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.JobExperience;

@RestController
@RequestMapping("api/jobExperiences")
public class JobExperiencesController {

	private JobExperienceService jobExperienceService;

	@Autowired
	public JobExperiencesController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobExperience>> getAll(){
		return this.jobExperienceService.getAll();
	}
	
	@GetMapping("/getByCandidateId")
	public DataResult<List<JobExperience>> getByCandidateId(@RequestParam int candidateId){
		return this.jobExperienceService.getByCandidateId(candidateId);
	}
	
	@GetMapping("/getByCandidateIdAndReverseSort")
	public DataResult<List<JobExperience>> getByCandidateIdAndReverseSort(@RequestParam int candidateId){
		return this.jobExperienceService.getByCandidateIdAndReverseSort(candidateId);
	}
	
	@GetMapping("/getById")
	public DataResult<JobExperience> getById(@RequestParam int id){
		return this.jobExperienceService.getById(id);
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobExperience jobExperience) {
		return this.jobExperienceService.add(jobExperience);
	}



}
