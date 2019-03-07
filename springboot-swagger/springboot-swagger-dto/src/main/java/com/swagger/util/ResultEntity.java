package com.swagger.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName: ResponseEntity.java
 * @Description: TODO(返回)
 * @author vaneu(zhaoxiong1003@qq.com)
 * @date 2015年8月11日 下午6:21:36
 * @version V1.0
 */
@ApiModel
public class ResultEntity<T> implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "状态：{0,成功},{1,失败},{2,Token失效}", required = true,position = 1,example="0")
	private Integer code;
	@ApiModelProperty(value = "描述：成功或失败等", required = true,position = 2,example="描述信息")
	private String 	desc;
	@ApiModelProperty(value = "数据：Json格式数据", required = true,position = 3)
	private T data;

	public ResultEntity() {
		super();
	}
	
	public ResultEntity(Integer code, String desc) {
		super();
		this.code = code;
		this.desc = desc;
	}
	
	public ResultEntity(Integer code, String desc, T data) {
		super();
		this.code = code;
		this.desc = desc;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
