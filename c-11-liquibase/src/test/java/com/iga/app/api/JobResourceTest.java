/**
 * 
 */
package com.iga.app.api;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.iga.app.domain.Job;

/**
 * @author Ramzi
 *
 */
@TestMethodOrder(OrderAnnotation.class)
class JobResourceTest extends JerseyTest{
	//les deux premieres méthodes juste pour junit 5
	@BeforeEach
    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    @AfterEach
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

	@Override
    protected Application configure() {
        return new ResourceConfig(JobResource.class);
    }

	@Test
	@Order(0)
    public void test_fictif_pour_timer_demarrage() {
		Response response = target("/jobs").path("0").request().get();
        assertEquals(Status.NOT_FOUND.getStatusCode(), response.getStatus());
	}
	
    @RepeatedTest(5)
    public void givenJobsEndpoint_whenFindAllJobs_ThenCorrect() {
        Response response = target("/jobs").request().get();
        assertEquals(Status.OK.getStatusCode(), response.getStatus());
             
    }
    @RepeatedTest(5)
    public void givenJobsEndpoint_whenFindAllJobs_ThenAtLeastAJob() {
        List<Job> jobs = target("/jobs").request().get().readEntity(new GenericType<List<Job>>() {});
        assertTrue(jobs.size()>0);      
    }

    @RepeatedTest(5)
    public void givenJobsEndpoint_whenFindById_ThenCorrect() {
        Job j = target("/jobs").path("18799").request().get(Job.class);
        assertEquals(j.getId(),18799);
    }
    
    @RepeatedTest(5)
    public void givenJobsEndpoint_whenPost_ThenOKAndReturnCorect() {
    	Job j = new Job("test",10,20);
        Response response = target("/jobs").request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(j,MediaType.APPLICATION_JSON_TYPE));
        assertEquals(Status.CREATED.getStatusCode(), response.getStatus());
        Job j2 = response.readEntity(Job.class);
        assertNotEquals(j.getId(), j2.getId());
        assertEquals(j.getMaxSalary(), j2.getMaxSalary());
        assertEquals(j.getMinSalary(), j2.getMinSalary());
        assertEquals(j.getTitle(), j2.getTitle());
    }
    
    
    @Test
    public void givenExistingJob_whenRemoveById_ThenRemoved() {
    	Job j1 = new Job("test",10,20);
        Response response1 = target("/jobs").request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(j1,MediaType.APPLICATION_JSON_TYPE));
        assertEquals(Status.CREATED.getStatusCode(), response1.getStatus());
        Job j2 = response1.readEntity(Job.class);
        assertNotNull(j2);
        Response response2= target("/jobs").path(String.valueOf(j2.getId())).request().delete();
        assertEquals(Status.OK.getStatusCode(), response2.getStatus());
        Response response3 = target("/jobs").path(String.valueOf(j2.getId())).request().get();
        assertEquals(Status.NOT_FOUND.getStatusCode(), response3.getStatus());
    }

}
