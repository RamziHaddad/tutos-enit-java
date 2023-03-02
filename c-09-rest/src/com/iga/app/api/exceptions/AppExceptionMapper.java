package com.iga.app.api.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

//une autre mani�re de faire le mapping des exceptions (standards ou custom) � des codes http
// cette classe n'est pas utilis�e dans cette application car toutes les exceptions sont captur�es
//vaut mieux utiliser ce mapper pour des excptions custom et ne pas remonter des exceptions divulgant de l'info compromettante
@Provider
public class AppExceptionMapper implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception e) {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(e.getMessage())
                .build();
    }
}
