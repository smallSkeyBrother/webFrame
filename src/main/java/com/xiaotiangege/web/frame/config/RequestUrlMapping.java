package com.xiaotiangege.web.frame.config;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 小天哥哥
 * @mailto 361807535@qq.com
 * @Description TODO
 * @createDate 2019年6月18日 下午2:12:55
 */
public class RequestUrlMapping {
	private static volatile ConcurrentHashMap<String, Method> uriMapping = new ConcurrentHashMap<>(256);

	public static void addUri(String uri, Method m) {
		uriMapping.put(uri, m);
	}

	public static void deleteUri(String uri) {
		uriMapping.remove(uri);
	}

	public static int getUriSize() {
		return uriMapping.size();
	}

	public static ConcurrentHashMap<String, Method> getUriMapping() {
		return uriMapping;
	}
}
