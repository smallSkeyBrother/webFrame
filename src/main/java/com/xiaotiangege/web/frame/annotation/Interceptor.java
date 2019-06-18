package com.xiaotiangege.web.frame.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 小天哥哥 
 * @mailto 361807535@qq.com  
 * @Description 拦截器注解 
 * @createDate 2019年6月18日 下午2:14:17 
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Interceptor {

	/**
	 * 通配符配置
	 * @return
	 */
	String value();
	
	/**
	 * uri集合配置
	 * @return
	 */
	String[] uris();
	
	/**
	 * 作用描述
	 * @return
	 */
	String desc();
}
