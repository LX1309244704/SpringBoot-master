package com.es.api;

import java.util.List;

import com.es.dto.VehicleDto;

public interface VehicleTemplateService {
	
	public void bulkIndex(List<VehicleDto> personList);
	
	public List<VehicleDto> queryForList(double lat, double lon);
	
	public List<VehicleDto> queryDto();
	
}
