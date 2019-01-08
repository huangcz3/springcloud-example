package com.example.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Huangcz
 * @date 2018-11-22 10:24
 * @desc xxx
 */
@Component
public class MyFilter extends ZuulFilter {

	private static final Logger logger = LoggerFactory.getLogger(MyFilter.class);

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run(){

		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		logger.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));

		Object token = request.getParameter("token");

		if (token == null) {
			logger.warn("token is empty !!!");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);

			try {
				ctx.getResponse().getWriter().write("token is empty !!!");
			} catch (IOException e) {
				logger.error("io异常",e);
			}
			return null;
		}

		logger.info("ok !!!");
		return null;
	}
}
