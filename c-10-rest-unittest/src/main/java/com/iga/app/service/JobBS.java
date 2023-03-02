package com.iga.app.service;

import java.util.List;
import java.util.Optional;

import com.iga.app.domain.Job;


public interface JobBS {
	Optional<Job> findById(long id) throws Exception;
	List<Job>findAll() throws Exception;
	Job save(Job j) throws Exception;
	boolean update(Job j) throws Exception;
	boolean removeById(long id) throws Exception;

}
