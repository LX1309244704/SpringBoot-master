package com.es.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

/** 
* @ClassName: ESConfig 
* @Description: TODO(动态创建indexName) 
* @author lixin(1309244704@qq.com)
* @date 2019年4月11日 下午12:27:06 
*  
*/
@Component("esConfig")
public class ESConfig {
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private String env = sdf.format(new Date());
    
	public String getEnv() {
		return env;
	}
	public void setEnv(String env) {
		this.env = env;
	}

}
