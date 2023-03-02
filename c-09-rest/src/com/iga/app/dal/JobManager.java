package com.iga.app.dal;

import java.util.List;

import com.iga.app.domain.Job;


public interface JobManager {
	
	Job findById(long id) throws Exception;
	List<Job>findAll() throws Exception;
	Job save(Job j) throws Exception;
	void saveAll(List<Job> l) throws Exception;
	int update(Job j) throws Exception;
	int removeById(long id) throws Exception;

}
