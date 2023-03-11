package com.dal;

import static org.junit.jupiter.api.Assertions.*;

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
import com.domain.Job;

class JobDAOImpl1PCPTest {
	static ConnectionProvider cp;
	static JobDAO jdao;
	static Random rnd = new Random();
	static List<Job> l = new ArrayList<>();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cp = new PooledConnectionProvider();
		jdao = new JobDAOImpl1(cp);
		for(int i=0;i<100;i++) {
			l.add(new Job("Job"+i,i,2000d));
		}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		//close the connection
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
		//close conn
	}

	@Test
	void testSingleInsert() throws Exception {
		int n1 = jdao.findAll().size();
		Job ingenieur = new Job("Ingenieur",1000d,2000d);
		long ancienID = ingenieur.getId();
		Job newJob = jdao.save(ingenieur);
		assertEquals(ingenieur.getTitle(), newJob.getTitle());
		assertEquals(ingenieur.getMinSalary(), newJob.getMinSalary());
		assertEquals(ingenieur.getMaxSalary(), newJob.getMaxSalary());
		assertNotEquals(ancienID,newJob.getId());
		int n2 = jdao.findAll().size();
		assertEquals(n2, n1+1);

	}
	@RepeatedTest(100)
	void testMultipleInserts() throws Exception {
		Job ingenieur = new Job("Ingenieur_"+rnd.nextInt(),rnd.nextLong()%2000,2000d);
		long ancienID = ingenieur.getId();
		Job newJob = jdao.save(ingenieur);
		assertNotEquals(ancienID, newJob.getId());
	}
	
	@Test
	void testSaveAll() throws Exception {
		int n1 = jdao.findAll().size();
		jdao.saveAll(l);
		int n2 = jdao.findAll().size();
		assertEquals(n2, n1+l.size());
	}

}
