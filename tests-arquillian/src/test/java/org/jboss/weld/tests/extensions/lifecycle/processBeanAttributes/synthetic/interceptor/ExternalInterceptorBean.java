/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.weld.tests.extensions.lifecycle.processBeanAttributes.synthetic.interceptor;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.Set;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.BeanAttributes;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.enterprise.inject.spi.InterceptionType;
import javax.enterprise.inject.spi.Interceptor;
import javax.interceptor.InvocationContext;

import org.jboss.weld.util.bean.ForwardingBeanAttributes;

public class ExternalInterceptorBean extends ForwardingBeanAttributes<ExternalInterceptor> implements Interceptor<ExternalInterceptor> {

    private final ExternalInterceptor instance = new ExternalInterceptor();
    private final BeanAttributes<ExternalInterceptor> delegate;
    private final Annotation binding;

    public ExternalInterceptorBean(BeanAttributes<ExternalInterceptor> delegate, Annotation binding) {
        this.delegate = delegate;
        this.binding = binding;
    }

    public Class<?> getBeanClass() {
        return ExternalInterceptor.class;
    }

    public Set<InjectionPoint> getInjectionPoints() {
        return Collections.emptySet();
    }

    public ExternalInterceptor create(CreationalContext<ExternalInterceptor> creationalContext) {
        return instance;
    }

    public void destroy(ExternalInterceptor instance, CreationalContext<ExternalInterceptor> creationalContext) {
    }

    public Set<Annotation> getInterceptorBindings() {
        return Collections.<Annotation> singleton(binding);
    }

    public boolean intercepts(InterceptionType type) {
        return true;
    }

    public Object intercept(InterceptionType type, ExternalInterceptor instance, InvocationContext ctx) throws Exception {
        return instance.intercept(ctx);
    }

    @Override
    protected BeanAttributes<ExternalInterceptor> attributes() {
        return delegate;
    }
}
