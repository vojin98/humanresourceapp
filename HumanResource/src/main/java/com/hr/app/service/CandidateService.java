package com.hr.app.service;

import java.util.List;

import com.hr.app.entity.Candidate;

public interface CandidateService {

	public List<Candidate> getCandidates();

	public void saveCandidate(Candidate theCandidate);

	public Candidate getCandidate(int theId);

	public void deleteCandidate(int theId);
	
	public void addSkill(String skill);
	
	public List<Candidate> getCandidatesWithSkill();

	public List<Candidate> getCandidatesWithName();

}
