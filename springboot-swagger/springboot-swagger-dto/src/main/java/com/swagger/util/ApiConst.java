package com.swagger.util;

/**
 * @ClassName: ResultConstant
 * @Description: TODO(返回的常量)
 * @author vaneu(zhaoxiong1003@qq.com)
 * @date 2017年4月25日 下午3:28:26
 */
public class ApiConst implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	public static final Integer CODE_SUCC = 0;	//成功
	public static final Integer CODE_FAIL = 1;	//失败
	public static final Integer CODE_FAIL_TOKEN = 2;	//token失效
	
	public static final String DESC_SUCC = "成功";
	public static final String DESC_FAIL = "失败";
	
	public static final Long HEAD_IMAGE_MAX_UPLOAD_SIZE = 5242880L;		// 上传头像文件最大5M=5*1024*1024
	public static final Long RECEIPT_IMAGE_MAX_UPLOAD_SIZE = 10485760L;	// 上传回单文件最大10M=5*1024*1024
}
