package com.iga.app.domain;

public class Job {
	
	private long id;
	private String title;
	private double minSalary;
	private double maxSalary;
	private double avgSalary;
	
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Job(long id, String title, double minSalary, double maxSalary) {
		super();
		this.id = id;
		this.title = title;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.setAvgSalary(0.5*(maxSalary+minSalary));
	}
	public Job(String title, double minSalary, double maxSalary) {
		super();
		this.title = title;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.setAvgSalary(0.5*(maxSalary+minSalary));
	}
	
	public Job(long id, String title, double minSalary, double maxSalary, double avgSalary) {
		super();
		this.id = id;
		this.title = title;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.avgSalary = avgSalary;
	}
	
	public Job(String title, double minSalary, double maxSalary, double avgSalary) {
		super();
		this.title = title;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.avgSalary = avgSalary;
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
	public double getAvgSalary() {
		return avgSalary;
	}
	public void setAvgSalary(double avgSalary) {
		this.avgSalary = avgSalary;
	}
	

}
