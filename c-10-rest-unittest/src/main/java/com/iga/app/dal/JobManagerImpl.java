package com.iga.app.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iga.app.domain.Job;


public class JobManagerImpl implements JobManager{

	private ConnectionProvider cp;
	
	public JobManagerImpl() {
		super();
		this.cp = new PooledConnectionProvider();
	}

	private static final String FIND_BY_ID = "select * from jobs where job_id=?";
	@Override
	public Job findById(long id) throws Exception {
		Connection c = cp.getConnection();
		PreparedStatement st = c.prepareStatement(FIND_BY_ID);
		st.setLong(1, id);
		ResultSet rs = st.executeQuery();
		if(rs.next()){
			return new Job(rs.getLong("Job_id"),rs.getString("job_title"),rs.getDouble("min_salary"),rs.getDouble("max_salary"));
		}
		st.close();
		c.close();
		return null;
	}

	@Override
	public List<Job> findAll() throws Exception {
		Connection c = cp.getConnection();
		PreparedStatement st = c.prepareStatement("select * from jobs");
		ResultSet rs = st.executeQuery();
		List<Job> l = new ArrayList<>();
		while(rs.next()){
			l.add(new Job(rs.getLong("Job_id"),rs.getString("job_title"),rs.getDouble("min_salary"),rs.getDouble("max_salary")));
		}
		st.close();
		c.close();
		return l;
	}

	
	private static final String INSERT = "INSERT INTO public.jobs(job_title, min_salary, max_salary) VALUES (?, ?, ?)";
	
	@Override
	public Job save(Job j)  throws Exception {
		Connection c = cp.getConnection();
		PreparedStatement st = c.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
		st.setString(1, j.getTitle());
		st.setDouble(2, j.getMinSalary());
		st.setDouble(3, j.getMaxSalary());
		int ok= st.executeUpdate();
		if(ok==1) {
			ResultSet generatedKeysResultSet = st.getGeneratedKeys();
			generatedKeysResultSet.next();
			long id = generatedKeysResultSet.getLong(1);
			j.setId(id);
		}
		st.close();
		c.close();
		return j;
	}
	private static final String UPDATE = "UPDATE public.jobs SET job_title=?, min_salary=?, max_salary=? WHERE job_id=?";

	@Override
	public int update(Job j) throws Exception {
		Connection c = cp.getConnection();
		PreparedStatement st = c.prepareStatement(UPDATE);
		st.setString(1, j.getTitle());
		st.setDouble(2, j.getMinSalary());
		st.setDouble(3, j.getMaxSalary());
		st.setLong(4, j.getId());
		int ok= st.executeUpdate();	
		st.close();
		c.close();
		return ok;
	}
	private static final String DELETE = "DELETE FROM public.jobs WHERE job_id = ?";
	@Override
	public int removeById(long id) throws Exception {
		Connection c = cp.getConnection();
		PreparedStatement st = c.prepareStatement(DELETE);
		st.setLong(1, id);
		int ok= st.executeUpdate();		
		st.close();
		c.close();
		return ok;
	}
	@Override//voir technique batch
	public void saveAll(List<Job> l) throws Exception {
		Connection c = cp.getConnection();
		PreparedStatement st = c.prepareStatement(INSERT);
		l.forEach(j->{
			try {
				st.setString(1, j.getTitle());
				st.setDouble(2, j.getMinSalary());
				st.setDouble(3, j.getMaxSalary());
				int ok= st.executeUpdate();
				st.clearParameters();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		st.close();
		c.close();
	}


	
}
