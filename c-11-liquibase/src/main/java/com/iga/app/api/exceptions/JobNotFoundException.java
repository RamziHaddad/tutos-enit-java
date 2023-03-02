package com.iga.app.api.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.iga.app.domain.Job;

public class JobNotFoundException extends WebApplicationException {
    public JobNotFoundException(long idJob) {
        super(Response.status(Status.NOT_FOUND).entity(idJob).build());
    }
    public JobNotFoundException(Job job) {
        super(Response.status(Status.NOT_FOUND).entity(job).build());
    }
}