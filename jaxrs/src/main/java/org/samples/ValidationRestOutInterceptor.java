package org.samples;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.jaxrs.validation.ValidationUtils;
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
public class ValidationRestOutInterceptor extends AbstractPhaseInterceptor< Message > implements ContainerResponseFilter   {

    private volatile BeanValidationProvider provider;
    private boolean enforceOnlyBeanConstraints;

    public ValidationRestOutInterceptor() {
        super(Phase.PRE_MARSHAL);
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
    
    protected void handleValidation(final Message message, final Object resourceInstance,
                                    final Method method, final List<Object> arguments) {
        if (arguments.size() == 1) {
            Object entity = unwrapEntity(arguments.get(0));
            BeanValidationProvider theProvider = getOutProvider(message);
            if (isEnforceOnlyBeanConstraints()) {
                theProvider.validateReturnValue(entity);    
            } else {
                theProvider.validateReturnValue(resourceInstance, method, entity);
            }
        }        
    }
    
    protected BeanValidationProvider getOutProvider(Message message) {
        BeanValidationProvider provider = message.getExchange().get(BeanValidationProvider.class);
        return provider == null ? getProvider(message) : provider;
    }
    
    public boolean isEnforceOnlyBeanConstraints() {
        return enforceOnlyBeanConstraints;
    }
    public void setEnforceOnlyBeanConstraints(boolean enforceOnlyBeanConstraints) {
        this.enforceOnlyBeanConstraints = enforceOnlyBeanConstraints;
    }
    
    protected Object getServiceObject(Message message) {
        return ValidationUtils.getResourceInstance(message);
    }
    
    
    protected Object unwrapEntity(Object entity) {
        return entity instanceof Response ? ((Response)entity).getEntity() : entity;
    }
    
    public void filter(ContainerRequestContext in, ContainerResponseContext out) throws IOException {
        handleMessage(PhaseInterceptorChain.getCurrentMessage());
    }


}
