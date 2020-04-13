
package com.mvc.annoation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 *  EnjoyRequestParam.java
 *  TODO
 *  Created: 2018年8月19日 下午2:53:32
 *  Author: raogugen
 */

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnjoyRequestParam {
/**
* 表示参数的别名，必填
* @return
*/
	String[] value() default {};
}
