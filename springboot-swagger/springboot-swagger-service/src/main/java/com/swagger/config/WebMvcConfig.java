package com.swagger.config;

import java.util.Arrays;

import javax.servlet.MultipartConfigElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**  
* @ClassName: WebMvcConfig  
* @Description: TODO()  
* @author lixin(1309244704@qq.com)  
* @date 2018年8月18日 下午2:58:52  
* @version V1.0  
*/ 
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	private static Logger logger = LoggerFactory.getLogger(SwaggerCommandLineRunner.class);

	/* (非 Javadoc)
	* <p>Title: addCorsMappings</p>
	* <p>Description: 跨域</p>
	* @param registry
	* @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry)
	*/
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOrigins("*")
			.allowCredentials(true)
			.allowedMethods("GET", "POST", "DELETE", "PUT")
			.maxAge(3600);
	}
	
	 public void addInterceptors(InterceptorRegistry registry) {
//		 	registry.addInterceptor(new WebInterceptor());
	        registry.addInterceptor(new WebInterceptor()).excludePathPatterns(Arrays.asList("/static/**","/api/**")); //放开静态资源拦截
	        logger.debug(">>>>>>>>>>>>>> 拦截器注册完毕<<<<<<<<<<<<<");
	    }
	 /** 上传附件容量限制 */
		@Bean
		public MultipartConfigElement multipartConfigElement() {
			MultipartConfigFactory factory = new MultipartConfigFactory();
			factory.setMaxFileSize("102400KB");
			factory.setMaxRequestSize("112400KB");
			return factory.createMultipartConfig();
		}
}
