package com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.conn.ConnectionProvider;
import com.domain.Job;

//implémentation basée sur les requêtes précompilées et paramétrées (recommandée)
public class JobDAOImpl1 implements JobDAO{

	private ConnectionProvider cp;
	
	public JobDAOImpl1(ConnectionProvider cp) {
		super();
		this.cp = cp;
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
	public void update(Job j) throws Exception {
		Connection c = cp.getConnection();
		PreparedStatement st = c.prepareStatement(UPDATE);
		st.setString(1, j.getTitle());
		st.setDouble(2, j.getMinSalary());
		st.setDouble(3, j.getMaxSalary());
		st.setLong(4, j.getId());
		int ok= st.executeUpdate();		
		st.close();
		c.close();
	}
	private static final String DELETE = "DELETE FROM public.jobs WHERE job_id = ?";
	@Override
	public void removeById(long id) throws Exception {
		Connection c = cp.getConnection();
		PreparedStatement st = c.prepareStatement(DELETE);
		st.setLong(1, id);
		int ok= st.executeUpdate();		
		st.close();
		c.close();
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
