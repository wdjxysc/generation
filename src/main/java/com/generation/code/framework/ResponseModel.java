package com.generation.code.framework;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName:  ResponseModel   
 * @Description:TODO(返回信息模板)   
 * @author: 曾肖 
 * @date:   2019年5月30日 上午9:48:51   
 *     
 * @Copyright: 2019
 */
@ApiModel
public class ResponseModel {
	@ApiModelProperty(value = "返回编码 - 200：成功 / 900：异常")
    private String code;
	@ApiModelProperty(value = "返回描述信息")
    private String desc;
	@ApiModelProperty(value = "返回数据")
    private Object data;
    
    private PageVO pageInfo;
    
    public ResponseModel(String code, String desc, Object data) {
    	this.code = code;
    	this.desc = desc;
    	this.data = data;
    }
    
    public ResponseModel() {
    	// TODO
    }
    
    public static ResponseModel success() {
    	return new ResponseModel("200", null, null);
    }
    public static ResponseModel success(String desc) {
    	return new ResponseModel("200", desc, null);
    }
    public static ResponseModel success(Object data) {
    	return new ResponseModel("200", null, data);
    }
    public static ResponseModel success(String desc, Object data) {
    	return new ResponseModel("200", desc, data);
    }
    public static ResponseModel fail() {
    	return new ResponseModel("900", null, null);
    }
    public static ResponseModel fail(String desc) {
    	return new ResponseModel("900", desc, null);
    }
    public static ResponseModel fail(Object data) {
    	return new ResponseModel("900", null, data);
    }
    public static ResponseModel fail(String desc, Object data) {
    	return new ResponseModel("900", desc, data);
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
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
    
	@Override
	public String toString() {
		return "ResponseModel [code=" + code + ", desc=" + desc + ", data=" + data + "]";
	}

	public PageVO getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageVO pageInfo) {
		this.pageInfo = pageInfo;
	}
	
}
