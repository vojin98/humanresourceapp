package com.hr.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hr.app.dao.CandidateDAO;
import com.hr.app.entity.Candidate;

@Service
public class CandidateServiceImpl implements CandidateService {

	// need to inject customer dao
	@Autowired
	private CandidateDAO candidateDAO;
	
	@Override
	@Transactional
	public List<Candidate> getCandidates() {
		return candidateDAO.getCandidates();
	}

	@Override
	@Transactional
	public void saveCandidate(Candidate theCandidate) {

		candidateDAO.saveCandidate(theCandidate);
	}
	
	public void addSkill(String skill)
	{
	candidateDAO.addSkill(skill);
	}

	@Override
	@Transactional
	public Candidate getCandidate(int theId) {
		
		return candidateDAO.getCandidate(theId);
	}

	@Override
	@Transactional
	public void deleteCandidate(int theId) {
		
		candidateDAO.deleteCandidate(theId);
	}
	
public Candidate getCandidatesWithSkill(int theId) {
		
		return candidateDAO.getCandidate(theId);
	}
	
public Candidate getCandidatesWithName(int theId) {
	
	return candidateDAO.getCandidate(theId);
}


}





