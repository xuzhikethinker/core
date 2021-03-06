package org.jboss.weld.bean.interceptor;

import javax.enterprise.inject.spi.Interceptor;

import org.jboss.weld.interceptor.proxy.CustomInterceptorInvocation;
import org.jboss.weld.interceptor.proxy.InterceptorInvocation;
import org.jboss.weld.interceptor.spi.metadata.ClassMetadata;
import org.jboss.weld.interceptor.spi.metadata.InterceptorMetadata;
import org.jboss.weld.interceptor.spi.metadata.InterceptorReference;
import org.jboss.weld.interceptor.spi.model.InterceptionType;
import org.jboss.weld.serialization.spi.helpers.SerializableContextual;

/**
 * @author Marius Bogoevici
 */
public class CustomInterceptorMetadata implements InterceptorMetadata<SerializableContextual<Interceptor<?>, ?>> {

    private static final long serialVersionUID = -4399216536392687374L;

    private SerializableContextualInterceptorReference reference;

    private ClassMetadata<?> classMetadata;

    public CustomInterceptorMetadata(SerializableContextualInterceptorReference serializableContextualInterceptorReference, ClassMetadata<?> classMetadata) {
        this.reference = serializableContextualInterceptorReference;
        this.classMetadata = classMetadata;
    }

    public InterceptorReference<SerializableContextual<Interceptor<?>, ?>> getInterceptorReference() {
       return reference;
    }

    public ClassMetadata<?> getInterceptorClass() {
        return classMetadata;
    }

    public boolean isEligible(InterceptionType interceptionType) {
        return reference.getInterceptor().get().intercepts(javax.enterprise.inject.spi.InterceptionType.valueOf(interceptionType.name()));
    }

    public InterceptorInvocation getInterceptorInvocation(Object interceptorInstance, InterceptorMetadata interceptorReference, InterceptionType interceptionType) {
        return new CustomInterceptorInvocation(reference.getInterceptor().get(), interceptorInstance, javax.enterprise.inject.spi.InterceptionType.valueOf(interceptionType.name()));
    }

    @Override
    public String toString() {
        return "CustomInterceptorMetadata [" + getInterceptorClass().getClassName() + "]";
    }
}
