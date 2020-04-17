package ${packgeName}.framework.exception;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import ${packgeName}.framework.config.ResponseModel;

/**   
 * @formatClassName:  CommonDefineExceptionHandle
 * @Description:TODO 自定义返回异常，用于参数校验等的固定模板
 * @author: generation
 * @date:   ${.now?string["yyyy年MM月dd日 hh:mm:SS"]}
 * @Copyright: generation
 */
@ControllerAdvice
@ResponseBody
public class CommonDefineExceptionHandle {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonDefineExceptionHandle.class);
	
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
			logger.error(ex.getMessage(), ex);
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch(IOException ex) {
				logger.error(ex.getMessage(), ex);
			}
		}
    }
}
