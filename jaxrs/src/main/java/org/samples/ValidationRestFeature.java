package org.samples;

import org.apache.cxf.Bus;
import org.apache.cxf.feature.AbstractFeature;
import org.apache.cxf.interceptor.InterceptorProvider;
import org.apache.cxf.validation.BeanValidationProvider;

public class ValidationRestFeature extends AbstractFeature {

	private BeanValidationProvider validationProvider;

	@Override
	protected void initializeProvider(InterceptorProvider interceptorProvider,Bus bus) {
		ValidationRestInInterceptor in = new ValidationRestInInterceptor();
		ValidationRestOutInterceptor out = new ValidationRestOutInterceptor();
		if (validationProvider != null) {
			in.setProvider(validationProvider);
			out.setProvider(validationProvider);
		}
		interceptorProvider.getInInterceptors().add(in);
		interceptorProvider.getOutInterceptors().add(out);
	}

	public void setProvider(BeanValidationProvider provider) {
		this.validationProvider = provider;
	}

}
