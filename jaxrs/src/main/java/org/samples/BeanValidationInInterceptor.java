package org.samples;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.validation.AbstractValidationInterceptor;

public class BeanValidationInInterceptor extends AbstractValidationInterceptor {
	
	public BeanValidationInInterceptor() {
		super(Phase.PRE_INVOKE);
	}

	public BeanValidationInInterceptor(String phase) {
		super(phase);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void handleValidation(Message message, Object beanClass, Method method,
			List<Object> parameters) {
		if(parameters.size()>0){
			ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
			Validator validator = validatorFactory.getValidator();
			
			for(Object parameter : parameters){
				Set<ConstraintViolation<Object>> violations = validator.validate(parameter);
				for (ConstraintViolation<Object> violation : violations) {
				    String propertyPath = violation.getPropertyPath().toString();
				    String msg = violation.getMessage();
				    System.out.println("invalid value for: '" + propertyPath + "': " + msg);
				}
			}
			

			System.out.println("***************");
		}
		
		
		
	}

}
