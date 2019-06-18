package com.xiaotiangege.web.frame.start;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

import com.xiaotiangege.web.frame.annotation.UriMapping;
import com.xiaotiangege.web.frame.config.RequestUrlMapping;

/**
 * @author 小天哥哥
 * @mailto 361807535@qq.com
 * @Description TODO
 * @createDate 2019年6月18日 下午3:20:03
 */
public class ClassResolveUtil {
	public static void main(String[] args) throws Exception {
		Class<?> clazz = Class.forName("com.kx.init.controller.RoleController");
		initUri(clazz);
		runAllMethod();
	}

	public static void initUri(Class<?> clazz) {
		String clazzUri = null;
		Annotation[] annos = clazz.getAnnotations();
		for (int i = 0; i < annos.length; i++) {
			Annotation anno = annos[i];
			if (anno instanceof UriMapping) {
				clazzUri = ((UriMapping) anno).value();
				break;
			}
		}

		if (clazzUri == null) {
			return;
		}

		Method[] methods = clazz.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			Method m = methods[i];
			Annotation[] mannos = m.getAnnotations();
			for (int j = 0; j < mannos.length; j++) {
				Annotation manno = mannos[j];
				if (manno instanceof UriMapping) {
					String mUri = ((UriMapping) manno).value();
					RequestUrlMapping.addUri(clazzUri.concat(mUri), m);
				}
			}
		}
	}

	public static void runAllMethod() throws Exception {
		ConcurrentHashMap<String, Method> map = (ConcurrentHashMap<String, Method>) RequestUrlMapping.getUriMapping();
		map.keySet().forEach(key -> {
			System.out.println(key);
			Method m = map.get(key);
			Class<?> clazz = m.getDeclaringClass();
			try {
				Object o = clazz.newInstance();
				try {
					m.invoke(o, null);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		});
	}
}
