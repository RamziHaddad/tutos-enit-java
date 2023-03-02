package com.iga.app.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.iga.app.dal.ConnectionProvider;
import com.iga.app.dal.JobManager;
import com.iga.app.dal.JobManagerImpl;
import com.iga.app.domain.Job;

public class JobBSImpl implements JobBS{
	private JobManager jobManager;
	
	public JobBSImpl() {
		super();
		this.jobManager = new JobManagerImpl();
	}

	@Override
	public Optional<Job> findById(long id) throws Exception {
		Job job = jobManager.findById(id);
		return (job!=null)?Optional.of(job):Optional.empty();
	}
	
	@Override
	public List<Job> findAll() throws Exception {
		return jobManager.findAll();
	}

	@Override
	public Job save(Job j)  throws Exception {
		return jobManager.save(j);
	}

	@Override
	public boolean update(Job j) throws Exception {
		return jobManager.update(j)==1;
	}

	@Override
	public boolean removeById(long id) throws Exception {
		return jobManager.removeById(id)==1;
	}

}
