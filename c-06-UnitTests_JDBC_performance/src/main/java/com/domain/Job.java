package com.domain;

public class Job {
	private long id = 0;
	private String title;
	private double minSalary;
	private double maxSalary;
	public Job(long id, String title, double minSalary, double maxSalary) {
		super();
		this.id = id;
		this.title = title;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}
	public Job(String title, double minSalary, double maxSalary) {
		super();
		this.id = 0;
		this.title = title;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}
	public long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public double getMinSalary() {
		return minSalary;
	}
	public double getMaxSalary() {
		return maxSalary;
	}
	
	
	
	public void setId(long id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setMinSalary(double minSalary) {
		this.minSalary = minSalary;
	}
	public void setMaxSalary(double maxSalary) {
		this.maxSalary = maxSalary;
	}
	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", minSalary=" + minSalary + ", maxSalary=" + maxSalary + "]";
	}
	

}
