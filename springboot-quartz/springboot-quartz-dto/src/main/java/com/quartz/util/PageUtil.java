package com.quartz.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: PageUtil
 * @Description: TODO(Easyui分页基本类)
 * @author vane(zhaoxiong1003@126.com)
 * @date 2014年8月1日 下午3:57:07
 */
public class PageUtil implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**当前页*/
	private Integer page 		= 1;
	/**每页显示多少条，默认是10条*/
	private Integer rows 		= 10;
	/**总页数*/
	private Integer totalPage 	= 0;
	/**总记录数*/
	private Integer totalRow 	= 0; 
	/**排序字段*/
	private String  sort;
	/**ASC DESC*/
	private String  order;
	/**查询参数*/
	private Map<String, Object> params;
	
	/**分页*/
	public void setTotalRows(Integer totalRow) {
		this.totalRow 	= totalRow;
		this.page 		= (page - 1) * rows;
		this.totalPage 	= ((totalRow - 1) / rows) + 1;
	}
	
	public Integer getTotalPage() {
		return totalPage;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(Integer totalRow) {
		this.totalRow = totalRow;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	// 得到返回Easyui的数据
	public Map<String, Object> getResultMap(List<?> content) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("total", 	totalRow);
		resultMap.put("rows",	content);
		return resultMap;
	}
	
	// 得到返回Easyui的数据
	public Map<String, Object> getResultMap(Integer totalRow, List<?> content) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("total", 	totalRow);
		resultMap.put("rows",	content);
		return resultMap;
	}
	
	// 得到返回APP的数据
	public Map<String, Object> getAppResultMap(PageUtil pageUtil, List<?> content) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("pages", 	pageUtil);
		resultMap.put("result",	content);
		return resultMap;
	}
}
