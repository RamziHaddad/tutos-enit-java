package com.dal;

import java.util.List;

import com.domain.Job;

public interface JobDAO {
	
	List<Job>findAll() throws Exception;
	Job save(Job j) throws Exception;
	void saveAll(List<Job> l) throws Exception;
	void update(Job j) throws Exception;
	void removeById(long id) throws Exception;

}
