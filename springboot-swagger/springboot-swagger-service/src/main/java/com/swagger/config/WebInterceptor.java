package com.swagger.config;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;

/**  
* @ClassName: WebInterceptor  
* @Description: TODO()  
* @author lixin(1309244704@qq.com)  
* @date 2018年8月18日 下午2:58:42  
* @version V1.0  
*/ 
public class WebInterceptor implements HandlerInterceptor {
	
	 @Override
	    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
		 System.out.println("==============  request before  ==============");
	        httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
	        httpServletResponse.addHeader("Access-Control-Allow-Methods", "*");
	        httpServletResponse.addHeader("Access-Control-Max-Age", "1800");
	        httpServletResponse.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, token");
	        httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
	        httpServletResponse.setContentType("application/json;charset=UTF-8");
	        httpServletResponse.setHeader("Cache-Control", "no-cache");
	        String token = httpServletRequest.getHeader("token");
			if(null != token){
				return true;
			}
			PrintWriter out = httpServletResponse.getWriter();
			JSONObject res = new JSONObject();
		    res.put("success","false");
		    res.put("msg","登录信息失效，请重新登录！");
		    out.append(res.toString());
			out.flush();  
			return false;
	    }

	    @Override
	    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
	        System.out.println("==============  request  ==============");
	    }

	    @Override
	    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
	        System.out.println("==============  request completion  ==============");
	    }
}
