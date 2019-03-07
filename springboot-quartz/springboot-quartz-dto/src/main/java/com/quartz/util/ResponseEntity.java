package com.quartz.util;

/**
 * @ClassName: ResponseEntity.java
 * @Description: TODO(返回)
 * @author vaneu(zhaoxiong1003@qq.com)
 * @date 2015年8月11日 下午6:21:36
 * @version V1.0
 */
public class ResponseEntity implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	public static final Integer SUCCESS = 200;
	public static final Integer FAILURE = 300;

	private Integer code;
	private String 	desc;
	private Object 	data;

	public static ResponseEntity SUCCESS() {
		ResponseEntity re = new ResponseEntity();
		re.setCode(SUCCESS);
		re.setDesc("操作成功");
		return re;
	}
	
	public static ResponseEntity FAILURE() {
		ResponseEntity re = new ResponseEntity();
		re.setCode(FAILURE);
		re.setDesc("操作失败");
		return re;
	}
	
	public static ResponseEntity SUCCESS(Object data) {
		ResponseEntity re = new ResponseEntity();
		re.setCode(SUCCESS);
		re.setDesc("操作成功");
		re.setData(data);
		return re;
	}

	public static ResponseEntity FAILURE(Object data) {
		ResponseEntity re = new ResponseEntity();
		re.setCode(FAILURE);
		re.setDesc("操作失败");
		re.setData(data);
		return re;
	}
	
	public static ResponseEntity SUCCESS(String desc, Object data) {
		ResponseEntity re = new ResponseEntity();
		re.setCode(SUCCESS);
		re.setDesc(desc);
		re.setData(data);
		return re;
	}
	
	public static ResponseEntity FAILURE(String desc, Object data) {
		ResponseEntity re = new ResponseEntity();
		re.setCode(FAILURE);
		re.setDesc(desc);
		re.setData(data);
		return re;
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
