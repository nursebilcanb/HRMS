package kodlamaio.hrms.api.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.BackgroundService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.Background;
import kodlamaio.hrms.entities.dtos.BackgroundAddDto;

@RestController
@RequestMapping("api/backgrounds")
public class BackgroundsController {

	private BackgroundService backgroundService;

	@Autowired
	public BackgroundsController(BackgroundService backgroundService) {
		super();
		this.backgroundService = backgroundService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Background>> getAll(){
		return this.backgroundService.getAll();
	}

	@PostMapping
	public Result add(@RequestBody BackgroundAddDto backgroundAddDto) {
		return this.backgroundService.add(backgroundAddDto);
	}
	
    @PostMapping("/addImage")
    public Result addImage(@RequestBody MultipartFile multipartFile, @RequestParam int id) throws IOException {
        return this.backgroundService.addImage(multipartFile, id);
    }
    
    @GetMapping("/getByCandidateId")
    public DataResult<List<Background>> getByCandidateId(@RequestBody int candidateId){
    	return this.backgroundService.getByCandidateId(candidateId);
    }
    
}
