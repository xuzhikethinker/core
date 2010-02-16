/*
 * JBoss, Home of Professional Open Source
 * Copyright 2008, Red Hat, Inc., and individual contributors
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
package org.jboss.weld.resolution;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;

import javax.enterprise.inject.spi.InterceptionType;

import org.jboss.weld.bean.AbstractClassBean;

public class ForwardingInterceptorResolvable implements InterceptorResolvable
{

   public InterceptionType getInterceptionType()
   {
      // TODO Auto-generated method stub
      return null;
   }

   public <A extends Annotation> A getAnnotation(Class<A> annotationType)
   {
      // TODO Auto-generated method stub
      return null;
   }

   public AbstractClassBean<?> getDeclaringBean()
   {
      // TODO Auto-generated method stub
      return null;
   }

   public Class<?> getJavaClass()
   {
      // TODO Auto-generated method stub
      return null;
   }

   public Set<Annotation> getQualifiers()
   {
      // TODO Auto-generated method stub
      return null;
   }

   public Set<Type> getTypeClosure()
   {
      // TODO Auto-generated method stub
      return null;
   }

   public boolean isAnnotationPresent(Class<? extends Annotation> annotationType)
   {
      // TODO Auto-generated method stub
      return false;
   }

   public boolean isAssignableTo(Class<?> clazz)
   {
      // TODO Auto-generated method stub
      return false;
   }

}