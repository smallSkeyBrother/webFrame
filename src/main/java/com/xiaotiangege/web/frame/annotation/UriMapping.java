package com.xiaotiangege.web.frame.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 小天哥哥
 * @mailto 361807535@qq.com
 * @Description 处理器注解
 * @createDate 2019年6月18日 下午2:13:34
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface UriMapping {
	/**
	 * 请求地址
	 * 
	 * @return
	 */
	String value();

	/**
	 * 请求地址
	 * 
	 * @return
	 */
	String uri() default "";

	/**
	 * 请求描述
	 * 
	 * @return
	 */
	String desc() default "";
}
