package com.generation.code.exception;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.generation.code.framework.LoggerUtil;
import com.generation.code.framework.ResponseModel;

/**
 * @ClassName:  CommonDefineExceptionHandle   
 * @Description:TODO(自定义返回异常，用于参数校验等的固定模板)   
 * @author: 曾肖 
 * @date:   2019年5月30日 上午9:47:30   
 *     
 * @Copyright: 2019
 */
@ControllerAdvice
@ResponseBody
public class CommonDefineExceptionHandle {
	
    @ExceptionHandler(CommonDefineException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void handlerMyRuntimeException(CommonDefineException ex) {
    	responseJson(ex.getMessage());
    }
    /**
     * 将错误信息以ResponseModel的格式输出
     * @param msg
     */
    public void responseJson(String msg) {
    	ResponseModel responseModel = ResponseModel.fail(msg);
    	HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    	response.setContentType("application/json;charset=UTF-8");
		BufferedOutputStream out = null;
		ByteArrayInputStream in = null;
		String result = JSON.toJSONString(responseModel, SerializerFeature.WriteDateUseDateFormat);
		try {
			out = new BufferedOutputStream(response.getOutputStream());
			in = new ByteArrayInputStream(result.getBytes("UTF-8"));
			byte[] buff = new byte[1024 * 512];
			int len;
			while ((len = in.read(buff)) > 0) {
				out.write(buff, 0, len);
			}
			out.flush();
		} catch(IOException ex) {
			LoggerUtil.error(ex.getMessage(), ex);
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch(IOException ex) {
				LoggerUtil.error(ex.getMessage(), ex);
			}
		}
    }
}
