package org.samples;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.validation.ValidationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.InterceptorChain;
import org.apache.cxf.jaxrs.validation.ValidationUtils;
import org.apache.cxf.logging.FaultListener;
import org.apache.cxf.logging.NoOpFaultListener;
import org.apache.cxf.message.Message;
import org.apache.cxf.message.MessageContentsList;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.service.Service;
import org.apache.cxf.service.invoker.MethodDispatcher;
import org.apache.cxf.service.model.BindingOperationInfo;
import org.apache.cxf.validation.BeanValidationProvider;

/**
 * 
 * 
 */
@Provider
public class ValidationRestInInterceptor extends AbstractPhaseInterceptor<Message> implements ContainerRequestFilter {


    private volatile BeanValidationProvider provider;
	
    public ValidationRestInInterceptor() {
        super(Phase.PRE_INVOKE);
    }
    
    public ValidationRestInInterceptor(String phase) {
        super(phase);
    }
    
    public void setProvider(BeanValidationProvider provider) {
        this.provider = provider;
    }
    

    public void handleMessage(Message message) throws Fault {        
        final Object theServiceObject = getServiceObject(message);
        if (theServiceObject == null) {
            return;
        }
        
        final Method method = getServiceMethod(message);
        if (method == null) {
            return;
        }
        
        
        final List< Object > arguments = MessageContentsList.getContentsList(message);
        
        handleValidation(message, theServiceObject, method, arguments);
                    
    }
    
    protected Method getServiceMethod(Message message) {
        Message inMessage = message.getExchange().getInMessage();
        Method method = (Method)inMessage.get("org.apache.cxf.resource.method");
        if (method == null) {
            BindingOperationInfo bop = inMessage.getExchange().get(BindingOperationInfo.class);
            if (bop != null) {
                MethodDispatcher md = (MethodDispatcher) 
                    inMessage.getExchange().get(Service.class).get(MethodDispatcher.class.getName());
                method = md.getMethod(bop);
                if(method==null){
                	//LOG
                	throw new ValidationException("Service Method is null");
                }
            } else{
            	//LOG
            	throw new ValidationException("Service Method is null");
            }
        }
        return method;
    }

    protected BeanValidationProvider getProvider(Message message) {
        if (provider == null) {
            Object prop = message.getContextualProperty(BeanValidationProvider.class.getName());
            if (prop != null) {
                provider = (BeanValidationProvider)prop;    
            } else {
                provider = new BeanValidationProvider();
            }
        }
        return provider;
    }
    
    
    protected List<Object> unwrapArgs(List<Object> arguments) {
        return arguments;
    }

	public void filter(ContainerRequestContext context) throws IOException {
		 InterceptorChain chain = PhaseInterceptorChain.getCurrentMessage().getInterceptorChain();
	     chain.add(this); 
		
	}
	
    protected Object getServiceObject(Message message) {
        return ValidationUtils.getResourceInstance(message);
    }
    

    protected void handleValidation(final Message message, final Object resourceInstance,
                                    final Method method, final List<Object> arguments) {
        try {
        	  if (arguments.size() > 0) {
                  BeanValidationProvider provider = getProvider(message);
                  provider.validateParameters(resourceInstance, method, unwrapArgs(arguments).toArray());
                  message.getExchange().put(BeanValidationProvider.class, provider);
              }
        } catch (ValidationException ex) {
            message.put(FaultListener.class.getName(), new NoOpFaultListener());
            throw ex;
        }
    }

}
