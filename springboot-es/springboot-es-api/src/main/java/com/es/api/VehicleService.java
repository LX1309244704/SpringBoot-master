package com.es.api;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.es.dto.VehicleDto;

public interface VehicleService {
	
	public void set(VehicleDto dto);
	
	public void setAll(Iterable<VehicleDto> ite);
	
	public void del(Long id);
	
	public VehicleDto findById(Long id);
	
	public List<VehicleDto> findAll();
	
	public List<VehicleDto> findCarDriver(String carDriver,Pageable pageable);
	
	public List<VehicleDto> findByAddressPointDtoName(String name,Pageable pageable); 
	
	public List<VehicleDto> findByCarDriverAndPrice(String carDriver,int price,Pageable pageable);
	
	public List<VehicleDto> findByCarDriverOrCarType(String carDriver,String carType,Pageable pageable);
	
	public List<VehicleDto> findByPriceBetween(int price1, int price2);
	
}
