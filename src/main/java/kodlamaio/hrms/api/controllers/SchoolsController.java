package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.School;

@RestController
@RequestMapping("/api/schools")
public class SchoolsController {
	
	private SchoolService schoolService;

	@Autowired
	public SchoolsController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	
	@GetMapping("/getAll")
	public 	DataResult<List<School>> getAll(){
		return this.schoolService.getAll();
	}
	
	@GetMapping("/getByCandidateId")
	public DataResult<List<School>> getByCandidateId(@RequestParam int candidateId){
		return this.schoolService.getByCandidateId(candidateId);
	}

	@GetMapping("/getByCandidateIdAndReverseSort")
	public DataResult<List<School>> getByCandidateIdAndReverseSort(@RequestParam int candidateId){
		return this.schoolService.getByCandidateIdAndReverseSort(candidateId);
	}
	
	@GetMapping("/getById")
	public DataResult<School> getById(@RequestParam int id){
		return this.schoolService.getById(id);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody School school) {
		return this.schoolService.add(school); 
	}




}
