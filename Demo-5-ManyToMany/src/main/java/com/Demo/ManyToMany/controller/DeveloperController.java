package com.Demo.ManyToMany.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Demo.ManyToMany.customException.DeveloperNotFoundException;
import com.Demo.ManyToMany.model.Developer;
import com.Demo.ManyToMany.service.DeveloperService;
import com.Demo.ManyToMany.service.SkillService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class DeveloperController {
	@Autowired
	DeveloperService developerService;

	@Autowired
	SkillService skillService;

	@PostMapping(path = "/developer/save")
	public ResponseEntity<?> saveDeveloperAndOfficeDetail(@RequestBody Developer developer) {
		// save developer
		/*
		 * { "developerName": "Er.Manmath", "developerExperience": "2.5 Year", "skill":
		 * [ { "skillName": "Java", "bornYear": "1996" }, { "skillName": "React",
		 * "bornYear": "2014" } ] }
		 */
//		Developer developer = new Developer();
//		developer.setId(3);
//		developer.setDeveloperName("Er. Chess King");
//		developer.setDeveloperExperience("5 Years");
//		
//		Optional<Skill> skill1 = skillService.getSkill(3);
//		Optional<Skill> skill2 = skillService.getSkill(4);
//		List<Skill> list = new ArrayList<Skill>();
//		list.add(skill1.get());
//		list.add(skill2.get());
//		developer.setSkill(list);
		Developer savedDeveloper = developerService.saveDeveloper(developer);

		if (savedDeveloper != null) {
			return new ResponseEntity<>(savedDeveloper, HttpStatus.OK);
		} else {
			throw new DeveloperNotFoundException("Developer Saving issue...");
		}
	}

	@GetMapping("/developer/{id}")
	public ResponseEntity<?> getDeveloperAndOfficeDetailById(@PathVariable("id") int id) {
		// Retrieve Developers
		Optional<Developer> developer = developerService.getDeveloper(id);

		if (developer.isPresent()) {
			return new ResponseEntity<>(developer.get(), HttpStatus.OK);
		} else {
			throw new DeveloperNotFoundException("Developer Not Found: " + id);
		}
	}

	@DeleteMapping("/developer/{id}")
	public ResponseEntity<?> deleteDeveloperAndOfficeDetailById(@PathVariable("id") int id) {
		// Retrieve Developers
		Optional<Developer> developer = developerService.getDeveloper(id);

		if (developer.isPresent()) {
			developerService.deleteDeveloper(id);
			return new ResponseEntity<>(developer.get(), HttpStatus.OK);
		} else {
			throw new DeveloperNotFoundException("Developer Not Deleted");
		}
	}

	@GetMapping(path = "/developers")
	public ResponseEntity<?> getListOfDeveloperAndOfficeDetail() {
		// Retrieve Developers
		List<Developer> developers = developerService.developers();

		if (developers.size() > 0) {
			return new ResponseEntity<>(developers, HttpStatus.OK);
		} else {
			throw new DeveloperNotFoundException("Developers Not Available");
		}
	}
	/*
	 * @ExceptionHandler public ResponseEntity<?>
	 * handleException(DeveloperNotFoundException exc) { DeveloperErrorResponse
	 * error = new DeveloperErrorResponse();
	 * 
	 * error.setStatus(HttpStatus.NOT_FOUND.value());
	 * error.setMessage(exc.getMessage());
	 * error.setTimeStamp(System.currentTimeMillis());
	 * 
	 * return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); }
	 * 
	 * @ExceptionHandler public ResponseEntity<?> handleException(Exception exc) {
	 * DeveloperErrorResponse error = new DeveloperErrorResponse();
	 * 
	 * error.setStatus(HttpStatus.BAD_REQUEST.value());
	 * error.setMessage(exc.getMessage());
	 * error.setTimeStamp(System.currentTimeMillis());
	 * 
	 * return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST); }
	 */
}
