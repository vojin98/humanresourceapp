package com.hr.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hr.app.entity.Candidate;

@Repository
public class CandidateDAOImpl implements CandidateDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Candidate> getCandidates() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Candidate> theQuery = 
				currentSession.createQuery("from Candidate order by name",
											Candidate.class);
		
		// execute query and get result list
		List<Candidate> candidates = theQuery.getResultList();
				
		// return the results		
		return candidates;
	}
	
	
	public List<Candidate> getCandidatesWithSkill() {
	
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Candidate> theQuery = 
				currentSession.createQuery("from Candidate order by name",
											Candidate.class);

		List<Candidate> candidates = theQuery.getResultList();
		return candidates;

	}
	
	public List<Candidate> getCandidatesWithName() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Candidate> theQuery = 
				currentSession.createQuery("from Candidate where  name = 'laza'",
											Candidate.class);

		List<Candidate> candidates = theQuery.getResultList();
		return candidates;

	}
	
	
	
	

	@Override
	public void saveCandidate(Candidate theCandidate) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(theCandidate);
		
	}
	
	@Override
	public void addSkill(String skill) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(skill);
		
	}

	@Override
	public Candidate getCandidate(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Candidate theCandidate = currentSession.get(Candidate.class, theId);
		
		return theCandidate;
	}

	@Override
	public void deleteCandidate(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Candidate where id=:candidateId");
		theQuery.setParameter("candidateId", theId);
		
		theQuery.executeUpdate();		
	}

}











