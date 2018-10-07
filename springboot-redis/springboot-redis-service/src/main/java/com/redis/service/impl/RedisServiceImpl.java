package com.redis.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metric;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.format.PointFormatter;
import org.springframework.data.redis.connection.RedisGeoCommands.GeoLocation;
import org.springframework.data.redis.connection.RedisGeoCommands.GeoRadiusCommandArgs;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.redis.dto.GeoRadiusDto;
import com.redis.service.RedisService;

/**
 * @ClassName: RedisServiceImpl
 * @Description: TODO()
 * @author lixin(1309244704@qq.com)
 * @date 2018年8月15日 上午10:06:21
 * @version V1.0
 */
@Service
public class RedisServiceImpl implements RedisService {

	@Autowired
	private StringRedisTemplate template;

	public RedisServiceImpl() {
	}

	@Override
	public void remove(String... keys) {
		String[] var2 = keys;
		int var3 = keys.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			String key = var2[var4];
			this.remove(key);
		}
	}

	@Override
	public void removePattern(String pattern) {
		Set<String> keys = this.template.keys(pattern);
		if (keys.size() > 0) {
			this.template.delete(keys);
		}
	}

	@Override
	public void remove(String key) {
		if (this.exists(key)) {
			this.template.delete(key);
		}
	}

	@Override
	public boolean exists(String key) {
		return this.template.hasKey(key);
	}

	@Override
	public String get(String key) {
		ValueOperations<String, String> operations = this.template.opsForValue();
		return (String) operations.get(key);
	}

	@Override
	public boolean set(String key, String value) {
		boolean result = false;
		try {
			ValueOperations<String, String> operations = this.template.opsForValue();
			operations.set(key, value);
			result = true;
		} catch (Exception var5) {
			var5.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean set(String key, String value, Long expireTime, TimeUnit timeUnit) {
		boolean result = false;
		try {
			ValueOperations<String, String> operations = this.template.opsForValue();
			operations.set(key, value);
			this.template.expire(key, expireTime, timeUnit);
			result = true;
		} catch (Exception var7) {
			var7.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<String> range(String key, Long start, Long end) {
		ListOperations<String, String> operations =  this.template.opsForList();
		return operations.range(key, start, end);
	}

	@Override
	public void trim(String key, Long start, Long end) {
		ListOperations<String, String> operations =  this.template.opsForList();
		operations.trim(key, start, end);
	}

	@Override
	public Long size(String key) {
		ListOperations<String, String> operations =  this.template.opsForList();
		return operations.size(key);
	}

	@Override
	public Long leftPush(String key, String value) {
		ListOperations<String, String> operations =  this.template.opsForList();
		return operations.leftPush(key, value);
	}

	@Override
	public Long leftPushAll(String key, String... values) {
		ListOperations<String, String> operations =  this.template.opsForList();
		return operations.leftPushAll(key, values);
	}

	@Override
	public Long leftPushIfPresent(String key, String value) {
		ListOperations<String, String> operations =  this.template.opsForList();
		return operations.leftPushIfPresent(key, value);
	}

	@Override
	public Long leftPush(String key, String pivot, String value) {
		ListOperations<String, String> operations =  this.template.opsForList();
		return operations.leftPush(key, pivot, value);
	}

	@Override
	public Long rightPush(String key, String value) {
		ListOperations<String, String> operations =  this.template.opsForList();
		return operations.rightPush(key, value);
	}

	@Override
	public Long rightPushAll(String key, String... values) {
		ListOperations<String, String> operations =  this.template.opsForList();
		return operations.rightPushAll(key, values);
	}

	@Override
	public Long rightPushIfPresent(String key, String value) {
		ListOperations<String, String> operations =  this.template.opsForList();
		return operations.rightPushIfPresent(key, value);
	}

	@Override
	public Long rightPush(String key, String pivot, String value) {
		ListOperations<String, String> operations =  this.template.opsForList();
		return operations.rightPush(key, pivot, value);
	}

	@Override
	public void set(String key, Long index, String value) {
		ListOperations<String, String> operations =  this.template.opsForList();
		operations.set(key, index, value);
	}

	@Override
	public Long remove(String key, Long count, Object value) {
		ListOperations<String, String> operations =  this.template.opsForList();
		if (this.exists(key)) {
			return operations.remove(key, count, value);
		}
		return null;
	}

	@Override
	public String index(String key, Long index) {
		ListOperations<String, String> operations =  this.template.opsForList();
		return operations.index(key, index);
	}

	@Override
	public String leftPop(String key) {
		ListOperations<String, String> operations =  this.template.opsForList();
		if (this.exists(key)) {
			return operations.leftPop(key);
		}
		return null;
	}

	@Override
	public String leftPop(String key, Long timeout, TimeUnit unit) {
		ListOperations<String, String> operations =  this.template.opsForList();
		return operations.leftPop(key, timeout, unit);
	}

	@Override
	public String rightPop(String key) {
		ListOperations<String, String> operations =  this.template.opsForList();
		return operations.rightPop(key);
	}

	@Override
	public String rightPop(String key, Long timeout, TimeUnit unit) {
		ListOperations<String, String> operations =  this.template.opsForList();
		return operations.rightPop(key, timeout, unit);
	}

	@Override
	public String rightPopAndLeftPush(String sourceKey, String destinationKey) {
		ListOperations<String, String> operations =  this.template.opsForList();
		return operations.rightPopAndLeftPush(sourceKey, destinationKey);
	}

	@Override
	public String rightPopAndLeftPush(String sourceKey, String destinationKey, Long timeout, TimeUnit unit) {
		ListOperations<String, String> operations =  this.template.opsForList();
		return operations.rightPopAndLeftPush(sourceKey, destinationKey, timeout, unit);
	}
	
	@Override
	public Long geoAdd(String key, String point, String member) {
		return this.template.opsForGeo().add(key, PointFormatter.INSTANCE.convert(point), member);
	}

	@Override
	public Long geoRemove(String key, String... members) {
		return this.template.opsForGeo().remove(key, members);
	}

	@Override
	public List<Point> geoPos(String key, String... members) {
		return this.template.opsForGeo().position(key, members);
	}

	@Override
	public List<String> geoHash(String key, String... members) {
		return this.template.opsForGeo().hash(key, members);
	}

	@Override
	public Double geoDist(String key, String member1, String member2, Metric metric) {
		return this.template.opsForGeo().distance(key, member1, member2, metric).getValue();
	}

	@Override
	public List<GeoRadiusDto> geoRadius(String key, String center, Double radius, Metric metric, Direction direction) {
		List<GeoRadiusDto> radiusDtos = new ArrayList<GeoRadiusDto>();
		Distance distance = new Distance(radius, metric);
		Circle within = new Circle(PointFormatter.INSTANCE.convert(center), distance);
		GeoRadiusCommandArgs args = null;
		if (direction.isAscending()) {
			args = GeoRadiusCommandArgs.newGeoRadiusArgs().sortAscending().includeCoordinates();
		}

		if (direction.isDescending()) {
			args = GeoRadiusCommandArgs.newGeoRadiusArgs().sortDescending().includeCoordinates();
		}

		GeoResults<GeoLocation<String>> geoResults = this.template.opsForGeo().radius(key, within, args);
		List<GeoResult<GeoLocation<String>>> geoResultList = geoResults.getContent();
		Iterator<GeoResult<GeoLocation<String>>> var12 = geoResultList.iterator();

		while (var12.hasNext()) {
			GeoResult<GeoLocation<String>> geoResult = (GeoResult<GeoLocation<String>>) var12.next();
			String name = (String) ((GeoLocation<?>) geoResult.getContent()).getName();
			Point point = ((GeoLocation<?>) geoResult.getContent()).getPoint();
			GeoRadiusDto radiusDto = new GeoRadiusDto();
			radiusDto.setKey(key);
			radiusDto.setMember(name);
			radiusDto.setX(point.getX());
			radiusDto.setY(point.getY());
			radiusDtos.add(radiusDto);
		}

		return radiusDtos;
	}

	@Override
	public List<GeoRadiusDto> geoRadiusByMember(String key, String member, Double radius, Metric metric,
			Direction direction) {
		List<GeoRadiusDto> radiusDtos = new ArrayList<GeoRadiusDto>();
		Distance distance = new Distance(radius, metric);
		GeoRadiusCommandArgs args = null;
		if (direction.isAscending()) {
			args = GeoRadiusCommandArgs.newGeoRadiusArgs().sortAscending().includeCoordinates();
		}

		if (direction.isDescending()) {
			args = GeoRadiusCommandArgs.newGeoRadiusArgs().sortDescending().includeCoordinates();
		}

		GeoResults<GeoLocation<String>> geoResults = this.template.opsForGeo().radius(key, member, distance, args);
		List<GeoResult<GeoLocation<String>>> geoResultList = geoResults.getContent();
		Iterator<GeoResult<GeoLocation<String>>> var11 = geoResultList.iterator();

		while (var11.hasNext()) {
			GeoResult<GeoLocation<String>> geoResult = (GeoResult<GeoLocation<String>>) var11.next();
			String name = (String) ((GeoLocation<?>) geoResult.getContent()).getName();
			Point point = ((GeoLocation<?>) geoResult.getContent()).getPoint();
			GeoRadiusDto radiusDto = new GeoRadiusDto();
			radiusDto.setKey(key);
			radiusDto.setMember(name);
			radiusDto.setX(point.getX());
			radiusDto.setY(point.getY());
			radiusDtos.add(radiusDto);
		}

		return radiusDtos;
	}

	@Override
	public List<GeoRadiusDto> geoIntersect(List<GeoRadiusDto> list1, List<GeoRadiusDto> list2) {
		return list1.retainAll(list2) ? list1 : null;
	}

}
