package ${packgeName}.framework.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**   
 * @formatClassName:  ThreadLocalVariableHolder
 * @Description:TODO 线程本地变量持有类
 * @author: generation
 * @date:   ${.now?string["yyyy年MM月dd日 hh:mm:SS"]}
 * @Copyright: generation
 */
public class ThreadLocalVariableHolder {
	
	private static final ThreadLocal<HttpServletRequest> threadLocalRequest = new ThreadLocal<>();
	
	private static final ThreadLocal<HttpServletResponse> threadLocalResponse = new ThreadLocal<>();
	
	public static void setHttpServletRequest(HttpServletRequest request) {
		threadLocalRequest.set(request);
	}
	
	public static HttpServletRequest getHttpServletRequest() {
		return threadLocalRequest.get();
	}
	
	public static void setHttpServletResponse(HttpServletResponse response) {
		threadLocalResponse.set(response);
	}
	
	public static HttpServletResponse getHttpServletResponse() {
		return threadLocalResponse.get();
	}
	
	public static void remove() {
		threadLocalRequest.remove();
		threadLocalResponse.remove();
	}

}
