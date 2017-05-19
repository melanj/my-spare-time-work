package org.samples;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.cxf.validation.ResponseConstraintViolationException;

@Provider
public class ValidationRestExceptionMapper implements ExceptionMapper< ValidationException > {

	@Override
	    public Response toResponse(ValidationException exception) {
	        if (exception instanceof ConstraintViolationException) { 
	            
	            final ConstraintViolationException constraint = (ConstraintViolationException) exception;
	            final boolean isResponseException = constraint instanceof ResponseConstraintViolationException;
	            StringBuffer errors = new StringBuffer("Constraint Violation : ");
	                        
	            for (final ConstraintViolation< ? > violation: constraint.getConstraintViolations()) {
	              //  LOG.log(Level.WARNING, 
	              //      violation.getRootBeanClass().getSimpleName() 
	              //      + "." + violation.getPropertyPath() 
	              //      + ": " + violation.getMessage());
	            	String violationDetails = violation.getRootBeanClass().getSimpleName() 
	      	                    + "." + violation.getPropertyPath() 
	      	                    + ": " + violation.getMessage();
					System.out.println(violationDetails);
					errors.append(violationDetails).append(", ");
	            }
	            GenericEntity<String> errorEntity = new GenericEntity<String>(errors.toString().replaceAll(", $", "")){};
	            
	            if (isResponseException) {
	                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorEntity).build();
	            }
	            
	            return Response.status(Response.Status.BAD_REQUEST).entity(errorEntity).build();
	        } else {
	            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	        }
	        
	        
	    }
}
