package com.redis.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**  
* @ClassName: JsonUtil  
* @Description: TODO(Json工具类)  
* @author lixin(1309244704@qq.com)  
* @date 2018年8月18日 下午5:04:57  
* @version V1.0  
*/ 
public class JsonUtil {

	private static Logger _logger =  LoggerFactory.getLogger(JsonUtil.class);

	private static final ObjectMapper objectMapper = new ObjectMapper();

	static {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		objectMapper.setDateFormat(sdf);
		objectMapper.setTimeZone(TimeZone.getDefault());
		objectMapper.setSerializationInclusion(Include.ALWAYS);
		// 设置输入时忽略JSON字符串中存在而Java对象实际没有的属性
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	}

	/**
	 * 将对象转换为JSON字符串
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj) {
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (Exception e) {
			_logger.error(e.getMessage(), e);
			return "";
		}
	}
	
	public static <T> T toObject(String json, Class<T> clazz) {
		try {
			if(StringUtils.isNoneBlank(json)){
				return objectMapper.readValue(json, clazz);
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
     * 将Json字符串转换成List
     * @param c
     * @param josn
     * @return
     */
    public static <T> List<T> toObjectList(Class<T> clazz, String json) {
    	JavaType javaType = getCollectionType(ArrayList.class, clazz); 
		try {
			return objectMapper.readValue(json, javaType);
		} catch (IOException e) {
			e.printStackTrace();
		} 
    	return null;   
    }
    
    /**   
    * 获取泛型的Collection Type  
    * @param collectionClass 泛型的Collection   
    * @param elementClasses 元素类   
    * @return JavaType Java类型   
    * @since 1.0   
    */   
	public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
		return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
	}
	
    /**
     * 将JSON字符串转为Map
     * @param obj
     * @return
     */
    public static Map<String, Object> toMap(String json) {
        try { 
        	@SuppressWarnings("unchecked")
			Map<String,Object> maps = objectMapper.readValue(json,Map.class);//转成map  
            return maps;
        } catch (Exception e) {
            return null;
        }
    }
}
