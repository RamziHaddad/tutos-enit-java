package com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.conn.ConnectionProvider;
import com.domain.Job;

public class JobDAOImpl2 implements JobDAO{

	private ConnectionProvider cp;
	
	public JobDAOImpl2(ConnectionProvider cp) {
		super();
		this.cp = cp;
	}


	@Override
	public List<Job> findAll() throws Exception {
		Connection c = cp.getConnection();
		Statement st = c.createStatement();
		ResultSet rs = st.executeQuery("select * from jobs");
		List<Job> l = new ArrayList<>();
		while(rs.next()){
			l.add(new Job(rs.getLong("Job_id"),rs.getString("job_title"),rs.getDouble("min_salary"),rs.getDouble("max_salary")));
		}
		st.close();
		c.close();
		return l;
	}

	
	
	@Override
	public Job save(Job j)  throws Exception {
		Connection c = cp.getConnection();
		Statement st = c.createStatement();
		int ok= st.executeUpdate("INSERT INTO jobs("
				+ "	job_title, min_salary, max_salary)"
				+ "	VALUES ('"+j.getTitle()+"',"+j.getMinSalary()+","+j.getMinSalary()+")"
						, Statement.RETURN_GENERATED_KEYS);
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

	@Override
	public void update(Job j) throws Exception {
		Connection c = cp.getConnection();
		Statement st = c.createStatement();
		int ok= st.executeUpdate("UPDATE jobs SET job_title='"+j.getTitle()+"', min_salary="+j.getMinSalary()+", max_salary="+j.getMinSalary()+"WHERE job_id="+j.getMinSalary());		
		st.close();
		c.close();
	}
	@Override
	public void removeById(long id) throws Exception {
		Connection c = cp.getConnection();
		Statement st = c.createStatement();
		int ok= st.executeUpdate("DELETE FROM jobs WHERE job_id = "+id);		
		st.close();
		c.close();
	}


	@Override
	public void saveAll(List<Job> l) throws Exception {
		Connection c = cp.getConnection();
		Statement st = c.createStatement();
		l.forEach(j->{
			try {
				st.executeUpdate("INSERT INTO jobs("
						+ "	job_title, min_salary, max_salary)"
						+ "	VALUES ('"+j.getTitle()+"',"+j.getMinSalary()+","+j.getMinSalary()+")");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
	}

}
