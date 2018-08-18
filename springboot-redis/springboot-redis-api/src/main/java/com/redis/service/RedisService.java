package com.redis.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.geo.Metric;
import org.springframework.data.geo.Point;

import com.redis.dto.GeoRadiusDto;

public interface RedisService {
	
	/**  
	* @Title: remove  
	* @Description: TODO(批量删除对应的value)  
	* @param @param keys    参数  
	* @return void    返回类型  
	* @throws  
	*/ 
	public void remove(final String... keys);
	
	/**  
	* @Title: removePattern  
	* @Description: TODO(批量删除key)  
	* @param @param pattern    参数  
	* @return void    返回类型  
	* @throws  
	*/ 
	public void removePattern(final String pattern);
	
	/**  
	* @Title: remove  
	* @Description: TODO(删除对应的value)  
	* @param @param key    参数  
	* @return void    返回类型  
	* @throws  
	*/ 
	public void remove(final String key);

	/**  
	* @Title: exists  
	* @Description: TODO(判断缓存中是否有对应的value)  
	* @param @param key
	* @param @return    参数  
	* @return boolean    返回类型  
	* @throws  
	*/ 
	public boolean exists(final String key);

	/**  
	* @Title: get  
	* @Description: TODO(读取缓存)  
	* @param @param key
	* @param @return    参数  
	* @return String    返回类型  
	* @throws  
	*/ 
	public String get(final String key);

	/**  
	* @Title: set  
	* @Description: TODO(写入缓存，永久)  
	* @param @param key
	* @param @param value
	* @param @return    参数  
	* @return boolean    返回类型  
	* @throws  
	*/ 
	public boolean set(final String key, String value);

	/**  
	* @Title: set  
	* @Description: TODO(写入缓存（有时间限制）)  
	* @param @param key
	* @param @param value
	* @param @param expireTime
	* @param @param timeUnit
	* @param @return    参数  
	* @return boolean    返回类型  
	* @throws  
	*/ 
	public boolean set(final String key, String value, Long expireTime, TimeUnit timeUnit);
	
	//////////////////////////////////////////////GEO///////////////////////////////////////////////////
	
	/**  
	* @Title: geoAdd  
	* @Description: TODO(添加geo)  
	* @param @param key
	* @param @param point
	* @param @param member
	* @param @return    参数  
	* @return Long    返回类型  
	* @throws  
	*/ 
	public Long geoAdd(String key, String point, String member);
	
	/**  
	* @Title: geoRemove  
	* @Description: TODO(删除成员)  
	* @param @param key
	* @param @param members
	* @param @return    参数  
	* @return Long    返回类型  
	* @throws  
	*/ 
	public Long geoRemove(String key, String... members);
	
	/**  
	* @Title: geoPos  
	* @Description: TODO(查询地址的经纬度)  
	* @param @param key
	* @param @param members
	* @param @return    参数  
	* @return List<Point>    返回类型  
	* @throws  
	*/ 
	public List<Point> geoPos(String key, String... members);
	
	/**  
	* @Title: geoHash  
	* @Description: TODO(查询位置的geohash)  
	* @param @param key
	* @param @param members
	* @param @return    参数  
	* @return List<String>    返回类型  
	* @throws  
	*/ 
	public List<String> geoHash(String key, String... members);
	
	/**  
	* @Title: geoDist  
	* @Description: TODO(查询2位置距离)  
	* @param @param key
	* @param @param member1 成员1
	* @param @param member2 成员2
	* @param @param metric  单位
	* @param @return    参数  
	* @return Double    返回类型  
	* @throws  
	*/ 
	public Double geoDist(String key, String member1, String member2, Metric metric);
	
	/**  
	* @Title: geoRadius  
	* @Description: TODO(查询附近坐标地址)  
	* @param @param key
	* @param @param center 中心坐标
	* @param @param radius 半径
	* @param @param metric 半径单位
	* @param @param direction 顺序
	* @param @return    参数  
	* @return List<GeoRadiusDto>    返回类型  
	* @throws  
	*/ 
	public List<GeoRadiusDto> geoRadius(String key, String center, Double radius, Metric metric, Direction direction);
	
	/**  
	* @Title: geoRadiusByMember  
	* @Description: TODO(根据成员查询附近点)  
	* @param @param key
	* @param @param member
	* @param @param radius
	* @param @param metric
	* @param @param direction
	* @param @return    参数  
	* @return List<GeoRadiusDto>    返回类型  
	* @throws  
	*/ 
	public List<GeoRadiusDto> geoRadiusByMember(String key, String member, Double radius, Metric metric, Direction direction);
	
	/**  
	* @Title: geoIntersect  
	* @Description: TODO(交集)  
	* @param @param list1
	* @param @param list2
	* @param @return    参数  
	* @return List<GeoRadiusDto>    返回类型  
	* @throws  
	*/ 
	public List<GeoRadiusDto> geoIntersect(List<GeoRadiusDto> list1,List<GeoRadiusDto> list2);
}
