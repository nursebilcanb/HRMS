package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertDto;

@CrossOrigin
@RestController
@RequestMapping("/api/jobAdverts")
public class JobAdvertsController {
	
	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	

	@GetMapping("/getAllByActivity")
	public DataResult<List<JobAdvertDto>> getAllByActivity(@RequestParam boolean activityStatus){
		return this.jobAdvertService.dtoGetJobAdvertsByIsActivated(activityStatus);
	}

	@GetMapping("/getAllActiveAdvertsByEmployerId")
	public DataResult<List<JobAdvertDto>> getAllActiveAdvertsByEmployerId(@RequestParam int employerId){
		return this.jobAdvertService.dtoGetAllActiveAdvertsByEmployerId(employerId);
	}
	
	@GetMapping("/getAllActiveAdvertsByDate")
	public 	DataResult<List<JobAdvertDto>> getAllActiveAdvertsByDate(){
		return this.jobAdvertService.dtoGetAllActiveAdvertsByDate();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertService.add(jobAdvert);
	}
	
	@PostMapping("/convertToPassive")
	public Result convertToPassive(@RequestBody int jobAdvertId) {
		return this.jobAdvertService.convertToPassive(jobAdvertId);
	}
	
	
	@GetMapping("/getById")
	public DataResult<JobAdvert> getById(@RequestParam int jobAdvertId){
		return this.jobAdvertService.getById(jobAdvertId);
	}




}
