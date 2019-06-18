package com.xiaotiangege.web.frame.dispatcher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 小天哥哥
 * @mailto 361807535@qq.com
 * @Description 请求分发器
 * @createDate 2019年6月18日 下午1:58:31
 */
@WebServlet(value = "/*")
public class WebFrameDispatcherServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		HttpServletRequest hreq = (HttpServletRequest) req;
		HttpServletResponse hres = (HttpServletResponse) res;

		String requestMethod = hreq.getMethod();
		if ("GET".equals(requestMethod) || "POST".equals(requestMethod)) {
			doDispatcher(hreq, hres);
		} else {
			super.service(hreq, hres);
		}
	}

	private void doDispatcher(HttpServletRequest req, HttpServletResponse resp) {

	}
}
