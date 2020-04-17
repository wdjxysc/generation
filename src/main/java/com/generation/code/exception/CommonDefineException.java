package com.generation.code.exception;

/**
 * @ClassName:  CommonDefineException   
 * @Description:TODO(自定义异常返回信息)   
 * @author: 曾肖 
 * @date:   2019年5月30日 上午9:47:14   
 *     
 * @Copyright: 2019
 */
public class CommonDefineException extends RuntimeException{
    private static final long serialVersionUID = -5519743897907627214L;

    private String exceptionCode;

    public CommonDefineException(String code, String msg){
        super(msg);
        this.exceptionCode = code;
    }
    
    public CommonDefineException(String msg) {
    	super(msg);
    	this.exceptionCode = "500";
    }
    
    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }
}
