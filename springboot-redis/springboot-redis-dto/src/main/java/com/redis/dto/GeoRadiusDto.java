package com.redis.dto;

/**  
* @ClassName: GeoRadiusDto  
* @Description: TODO(GeoRadius)  
* @author lixin(1309244704@qq.com)  
* @date 2018年8月14日 下午3:14:08  
* @version V1.0  
*/ 
public class GeoRadiusDto implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields key : TODO(key值)
	 */
	private String key;
	/**
	 * @Fields member : TODO(成员名称)
	 */
	private String member;
	/**
	 * @Fields x : TODO(纬度)
	 */
	private double x;
	/**
	 * @Fields y : TODO(精度)
	 */
	private double y;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((member == null) ? 0 : member.hashCode());
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GeoRadiusDto other = (GeoRadiusDto) obj;
		if (member == null) {
			if (other.member != null)
				return false;
		} else if (!member.equals(other.member))
			return false;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

}
