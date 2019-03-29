package com.es.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import com.es.dto.VehicleDto;


@Component
public interface VehicleRepository extends ElasticsearchRepository<VehicleDto, Long>{

    /**
     * @return
     */
    List<VehicleDto> findByCarDriver(String carDriver,Pageable pageable);
    
    /**
     * @param name
     * @return
     */
    List<VehicleDto> findByAddressPointDtoName(String name,Pageable pageable); 
    
    /**
     * @param id1
     * @param id2
     * @return
     */
    List<VehicleDto> findByCarDriverAndPrice(String carDriver,int price,Pageable pageable);
    
    /**
     * @return
     */
    List<VehicleDto> findByCarDriverOrCarType(String carDriver,String carType,Pageable pageable);
    
    /**
     * @param id1
     * @param id2
     * @return
     */
    List<VehicleDto> findByPriceBetween(int price1, int price2);
}
