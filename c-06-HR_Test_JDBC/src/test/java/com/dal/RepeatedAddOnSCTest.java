package com.dal;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import com.conn.ConnectionProvider;
import com.conn.PooledConnectionProvider;
import com.conn.SingletonConnectionProvider;
import com.domain.Job;

class RepeatedAddOnSCTest {
	static ConnectionProvider cp;
	static Random rnd = new Random();
	static List<Job> l = new ArrayList<>();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cp = new SingletonConnectionProvider();
		for(int i=0;i<100;i++) {
			l.add(new Job("Job"+i,i,2000d));
		}
	}

	
	@Test
	void test01() throws Exception {
		l.forEach(j->{
			try {
				Connection c = cp.getConnection();
				Statement st = c.createStatement();
				st.executeUpdate("INSERT INTO public.jobs(job_title, min_salary, max_salary) VALUES ('"+j.getTitle()+"',"+j.getMinSalary()+","+j.getMinSalary()+")");
				st.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

	}
	@Test
	void test02() throws Exception {
		l.forEach(j->{
			try {
				Connection c = cp.getConnection();
				PreparedStatement st = c.prepareStatement("INSERT INTO public.jobs(job_title, min_salary, max_salary) VALUES (?, ?, ?)");
				st.setString(1, j.getTitle());
				st.setDouble(2, j.getMinSalary());
				st.setDouble(3, j.getMaxSalary());
				int ok= st.executeUpdate();
				st.clearParameters();
				st.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	@Test
	void test11() throws Exception {
		Connection c = cp.getConnection();
		Statement st = c.createStatement();
		l.forEach(j->{
			try {
				st.executeUpdate("INSERT INTO public.jobs(job_title, min_salary, max_salary) VALUES ('"+j.getTitle()+"',"+j.getMinSalary()+","+j.getMinSalary()+")");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		st.close();
		c.close();
	}
	@Test
	void test12() throws Exception {
		Connection c = cp.getConnection();
		PreparedStatement st = c.prepareStatement("INSERT INTO public.jobs(job_title, min_salary, max_salary) VALUES (?, ?, ?)");
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
	@Test
	void test21() throws Exception {
		Connection c = cp.getConnection();
		Statement st = c.createStatement();
		l.forEach(j->{
			try {
				st.addBatch("INSERT INTO public.jobs(job_title, min_salary, max_salary) VALUES ('"+j.getTitle()+"',"+j.getMinSalary()+","+j.getMinSalary()+")");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		st.executeBatch();
		st.close();
		c.close();
	}
	@Test
	void test22() throws Exception {
		Connection c = cp.getConnection();
		PreparedStatement st = c.prepareStatement("INSERT INTO public.jobs(job_title, min_salary, max_salary) VALUES (?, ?, ?)");
		l.forEach(j->{
			try {
				st.setString(1, j.getTitle());
				st.setDouble(2, j.getMinSalary());
				st.setDouble(3, j.getMaxSalary());
				st.addBatch();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		st.execute();
		st.close();
		c.close();
	}
	@Test
	void test31() throws Exception {
		Connection c = cp.getConnection();
		c.setAutoCommit(false);
		Statement st = c.createStatement();
		l.forEach(j->{
			try {
				st.addBatch("INSERT INTO public.jobs(job_title, min_salary, max_salary) VALUES ('"+j.getTitle()+"',"+j.getMinSalary()+","+j.getMinSalary()+")");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		st.executeBatch();
		c.commit();
		st.close();
		c.close();
	}
	@Test
	void test32() throws Exception {
		Connection c = cp.getConnection();
		c.setAutoCommit(false);
		PreparedStatement st = c.prepareStatement("INSERT INTO public.jobs(job_title, min_salary, max_salary) VALUES (?, ?, ?)");
		l.forEach(j->{
			try {
				st.setString(1, j.getTitle());
				st.setDouble(2, j.getMinSalary());
				st.setDouble(3, j.getMaxSalary());
				st.addBatch();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		st.execute();
		c.commit();
		st.close();
		c.close();
	}
}
