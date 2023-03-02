package com.iga.app.api;

import java.io.InputStream;
import java.io.Reader;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/multimedias")
public class FileResource {
    @POST
    @Path("/upload")
    @Consumes("application/pdf")
    public void doSomethingWithInputStream(InputStream inputStream) {
        //doSomeReading(inputStream);
    }

}