
package com.mvc.annoation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  EnjoyRequestMapping.java
 *  TODO
 *  Created: 2018年8月19日 下午2:49:07
 *  Author: raogugen
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnjoyRequestMapping {
	
	String value() default "";
}
