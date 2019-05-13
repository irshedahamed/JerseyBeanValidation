/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import javax.ws.rs.core.MediaType;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author irshed-pt2884
 */
@Provider
public class ValidationException implements ExceptionMapper<javax.validation.ValidationException> {

    @Override
    public Response toResponse(javax.validation.ValidationException e) {
        final StringBuilder strBuilder = new StringBuilder();
        for (ConstraintViolation<?> cv : ((ConstraintViolationException) e).getConstraintViolations()) {
            strBuilder.append(cv.getPropertyPath().toString() + " " + cv.getMessage());
        }
        System.out.println("Inside Exception");
        return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                .type("application/json")
                .entity(new ExceptionInfo(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), strBuilder.toString()))
                .build();
    }
}

@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlRootElement
class ExceptionInfo {

    private int status;
    private String msg;

    public ExceptionInfo(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    @XmlElement
    public int getStatus() {
        return status;
    }

    @XmlElement
    public String getMessage() {
        return msg;
    }
}
