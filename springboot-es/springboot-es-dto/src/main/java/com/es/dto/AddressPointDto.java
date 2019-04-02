package com.es.dto;

import java.io.Serializable;

import org.elasticsearch.common.geo.GeoPoint;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.GeoPointField;

import com.fasterxml.jackson.annotation.JsonFormat;


@Document(indexName ="vehiclepoint", type = "specialpoint" , shards = 1, replicas = 0)
public class AddressPointDto implements Serializable {

	private static final long serialVersionUID = -5483287283894740770L;
	
	@Id
	private Long id;
	
	@Field( type = FieldType.Date,format = DateFormat.custom,pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String xjTime;
	
//	@Field(type = FieldType.String)//1.5.8 spring-boot使用类型
	//1：ik_smart：做最粗粒度的拆分；2：ik_max_word：做最细粒度的拆分
	@Field(type = FieldType.Text, fielddata=true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")//使用ik分词器
	private String name;
	
	//必须使用@Field注解，否则使用精确匹配查询字段需要type.Keyword
//	@Field(type = FieldType.Keyword)
	@Field(type = FieldType.Text)
//	@Field(type = FieldType.String)//1.5.8 spring-boot使用类型
	private String type;
	
//	@Field(type = FieldType.String,analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")//1.5.8 spring-boot使用类型
	@Field(type = FieldType.Text,analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
	private String remark;
	
	@GeoPointField
    private GeoPoint address;

	public AddressPointDto() {
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getXjTime() {
		return xjTime;
	}

	public void setXjTime(String xjTime) {
		this.xjTime = xjTime;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public GeoPoint getAddress() {
		return address;
	}


	public void setAddress(GeoPoint address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "VehiclePointEsDto [id=" + id + ", name=" + name + ", type=" + type + ", xjTime=" + xjTime + ", remark="
				+ remark + ", address=" + address + "]";
	}

}
