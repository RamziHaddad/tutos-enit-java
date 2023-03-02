package com.program;
import java.util.List;
import java.util.Random;

import com.conn.ConnectionProvider;
import com.conn.PooledConnectionProvider;
import com.conn.SingletonConnectionProvider;
import com.dal.JobDAO;
import com.dal.JobDAOImpl1;
import com.domain.Job;

public class PP {

	public static ConnectionProvider scp = new SingletonConnectionProvider();
	public static ConnectionProvider pcp = new PooledConnectionProvider();
	public static void main(String[] args) throws Exception {
		JobDAO jdao = new JobDAOImpl1(scp);
		List<Job> l = jdao.findAll();
		l.forEach(System.out::println);
		
		System.out.println("---------------------------");
		Job ingenieur = new Job("Ingenieur",1000d,2000d);
		Job technicien = new Job(21,"Technicien",1000d,2000d);
		Job newJob = jdao.save(ingenieur);
		System.out.println(newJob);
		System.out.println("---------------------------");
		l = jdao.findAll();
		l.forEach(System.out::println);
		System.out.println("------update------");
		technicien.setMinSalary(new Random().nextInt(2000));
		jdao.update(technicien);
		System.out.println("-----delete---------");
		jdao.removeById(newJob.getId());
		System.out.println("---------------------------");
		l = jdao.findAll();
		l.forEach(System.out::println);
	}

}
