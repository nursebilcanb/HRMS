package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.BackgroundService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.entities.concretes.Background;

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

}
