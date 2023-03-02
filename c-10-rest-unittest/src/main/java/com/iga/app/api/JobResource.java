package com.iga.app.api;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.iga.app.api.exceptions.JobNotFoundException;
import com.iga.app.domain.Job;
import com.iga.app.service.JobBS;
import com.iga.app.service.JobBSImpl;

@Path("/jobs")
public class JobResource {
	
	private static JobBS jobBS = new JobBSImpl();
	
	@GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
	public Response findById(@PathParam(value = "id") long id) {
		Optional<Job> j; 
		try {
			j = jobBS.findById(id);
		} catch (Exception e) {
			return Response.noContent().build();	
		}
		if(j.isPresent()) {
			return Response.ok(j.get()).build();
		}else {
			throw new JobNotFoundException(id);
		}
	}
	
	@GET
    @Produces({MediaType.APPLICATION_JSON})
	public Response findAll(){
		try {
			return Response.ok(jobBS.findAll()).build();
		} catch (Exception e) {
		}
		return Response.noContent().build();	
	}
	
	@POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
	public Response save(Job j) {
		try {
			Job newJob = jobBS.save(j);
			return Response.ok(newJob).status(Response.Status.CREATED).build();
		} catch (Exception e) {
		}
		return Response.notModified().build();
	}
	
	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
	public Response update(Job j) {
		boolean ok = false;
		try {
			ok = jobBS.update(j);
		} catch (Exception e) {
			return Response.notModified().build();
		}
		if(ok) {
			return Response.status(Status.OK).entity(j).build();				
		}else {
			throw new JobNotFoundException(j);
		}
		
	}
	@DELETE
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
	public Response removeById(@PathParam(value = "id") long id) {
		boolean ok = false;
		try {
			ok = jobBS.removeById(id);
		} catch (Exception e) {
			return Response.notModified().build();
		}
		if(ok) {
			return Response.ok().build();
		}else{
			throw new JobNotFoundException(id);
		}
	}

	
}
