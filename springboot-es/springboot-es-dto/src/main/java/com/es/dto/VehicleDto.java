package com.es.dto;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "vehicle", type = "special" , shards = 1, replicas = 0)
public class VehicleDto implements Serializable {

	private static final long serialVersionUID = -5483287283894740770L;
	
	@Id
	private Long id;
	
	@Field(type = FieldType.Text, fielddata=true)
	private String carDriver;
	
	@Field(type = FieldType.Text)
	private String carType;
	
	//1：ik_smart：做最粗粒度的拆分；2：ik_max_word：做最细粒度的拆分
	@Field(type = FieldType.Text, fielddata=true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
	private String carName;
	
	@Field(type = FieldType.Text)
	private String status;
	
	@Field(type = FieldType.Text)
	private int price;
	
	//嵌套实体使用FieldType.Nested
	@Field(type=FieldType.Nested,includeInParent=true)
	private List<AddressPointDto> addressPointDto;
	
	public VehicleDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCarDriver() {
		return carDriver;
	}

	public void setCarDriver(String carDriver) {
		this.carDriver = carDriver;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<AddressPointDto> getAddressPointDto() {
		return addressPointDto;
	}

	public void setAddressPointDto(List<AddressPointDto> addressPointDto) {
		this.addressPointDto = addressPointDto;
	}

	@Override
	public String toString() {
		return "VehicleDto [id=" + id + ", carDriver=" + carDriver + ", carType=" + carType + ", carName=" + carName
				+ ", status=" + status + ", price=" + price + ", addressPointDto=" + addressPointDto + "]";
	}

}
