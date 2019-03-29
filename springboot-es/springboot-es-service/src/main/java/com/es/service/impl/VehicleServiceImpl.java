package com.es.service.impl;

import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.es.api.VehicleService;
import com.es.dto.VehicleDto;
import com.es.service.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService{
	
	private @Autowired VehicleRepository vehicleRepository;
	
	@Override
	public void set(VehicleDto dto) {
		vehicleRepository.save(dto);
	}

	@Override
	public void setAll(Iterable<VehicleDto> ite) {
//		vehicleRepository.save(ite);
		vehicleRepository.saveAll(ite);
	}
	
	@Override
	public void del(Long id) {
		vehicleRepository.deleteById(id);
	}
	

	
	@Override
	public VehicleDto findById(Long id) {
//		VehicleEsDto dto = vehicleRepository.findOne(id);
//		return dto;
		Optional<VehicleDto> dto = vehicleRepository.findById(id);
		return dto.get();
	}

	@Override
	public List<VehicleDto> findAll() {
		List<VehicleDto> list = Lists.newArrayList(vehicleRepository.findAll());
		return list;
	}

	@Override
	public List<VehicleDto> findCarDriver(String carDriver, Pageable pageable) {
		List<VehicleDto> list = vehicleRepository.findByCarDriver(carDriver, pageable);
		return list;
	}

	@Override
	public List<VehicleDto> findByCarDriverAndPrice(String carDriver, int price, Pageable pageable) {
		List<VehicleDto> list = vehicleRepository.findByCarDriverAndPrice(carDriver, price, pageable);
		return list;
	}

	@Override
	public List<VehicleDto> findByCarDriverOrCarType(String carDriver, String carType, Pageable pageable) {
		List<VehicleDto> list = vehicleRepository.findByCarDriverOrCarType(carDriver, carType, pageable);
		return list;
	}

	@Override
	public List<VehicleDto> findByPriceBetween(int price1, int price2) {
		List<VehicleDto> list = vehicleRepository.findByPriceBetween(price1, price2);
		return list;
	}

	@Override
	public List<VehicleDto> findByAddressPointDtoName(String name,Pageable pageable) {
		List<VehicleDto> list = vehicleRepository.findByAddressPointDtoName(name,pageable);
		return list;
	}

}
