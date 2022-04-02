package com.hr.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.app.entity.Candidate;
import com.hr.app.service.CandidateService;
public class CandidateRestController {

	public CandidateRestController() {
		
	}
	
	@Autowired
	private CandidateService candidateService;

	@GetMapping("/candidates")
	public List<Candidate> getCandidates() {
		
		return candidateService.getCandidates();
		
	}
	
	@GetMapping("/candidates/{candidateId}")
	public Candidate getCustomer(@PathVariable int candidateId) {
		
		Candidate theCandidate = candidateService.getCandidate(candidateId);
		if (theCandidate == null) {
			throw new CandidateNotFoundException("Candidate id not found - " + candidateId);
		}
		
		return theCandidate;
	}

	@PostMapping("/candidates")
	public Candidate addCandidate(@RequestBody Candidate theCandidate) {
		
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		
		theCandidate.setId(0);
		
		candidateService.saveCandidate(theCandidate);
		
		return theCandidate;
	}
	
	@PutMapping("/customers")
	public Candidate updateCustomer(@RequestBody Candidate theCustomer) {
		
		candidateService.saveCandidate(theCandidate);
		
		return theCandidate;
		
	}
	
	@DeleteMapping("/candidates/{candidateId}")
	public String deleteCustomer(@PathVariable int customerId) {
		
		Candidate tempCandidate = candidateService.getCandidate(candidateId);
		
		// throw exception if null
		
		if (tempCandidate == null) {
			throw new CandidateNotFoundException("Candidate id not found - " + candidateId);
		}
				
		candidateService.deleteCandidate(candidateId);
		
		return "Deleted candidate id - " + candidateId;
	}
	
}
