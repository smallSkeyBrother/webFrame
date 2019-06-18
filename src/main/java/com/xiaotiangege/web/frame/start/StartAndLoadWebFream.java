package com.xiaotiangege.web.frame.start;

/**
 * @author 小天哥哥 
 * @mailto 361807535@qq.com  
 * @Description 启动加载项目中配置的拦截器和url控制器
 * @createDate 2019年6月18日 下午2:22:11 
 */
public class StartAndLoadWebFream {

	/**
	 * 前端控制器扫描包
	 */
	private String[] urlMappingpackages;
	
	/**
	 * 拦截器扫描包
	 */
	private String[] interceptorPackages;

	public StartAndLoadWebFream(String[] urlMappingpackages, String[] interceptorPackages) {
		this.urlMappingpackages = urlMappingpackages;
		this.interceptorPackages = interceptorPackages;
	}

	public StartAndLoadWebFream() {
	}
}
