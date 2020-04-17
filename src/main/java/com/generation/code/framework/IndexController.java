package com.generation.code.framework;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.generation.code.util.AppUtil;
import com.generation.code.util.HmacSHA256Utils;
import com.generation.code.util.StringUtils;
/**
 * @ClassName:  IndexController   
 * @Description:TODO(主页控制层)   
 * @author: 曾肖 
 * @date:   2019年5月30日 上午9:48:19   
 *     
 * @Copyright: 2019
 */
@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String index() {
		return "/web/index";
	}
	
	@RequestMapping("/home.view")
	public String home() {
		return "/web/home";
	}
	
	@PostMapping("/gateway/post/test")
	@ResponseBody
	public ResponseModel post(@RequestBody TestVO test) {
		Map<String, String[]> queryParams = AppUtil.getRequest().getParameterMap();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("queryParams", queryParams);
		result.put("body", test);
		return ResponseModel.success("post请求访问成功 , 入参：" + JSON.toJSONString(result));
	}
	
	@RequestMapping(value="/publish/file", method = {RequestMethod.POST})
	@ResponseBody
	public ResponseModel publish(HttpServletRequest request, String fileName) {
		try {
			byte[] bytes = IOUtils.toByteArray(request.getInputStream());
			for(int j = 0;j < bytes.length; ++j){
                if(bytes[j] < 0){
                    //调整异常数据
                	bytes[j]+=256;
                }
            }
			writeFile(bytes, fileName, 222L);
			return ResponseModel.success(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseModel.success();
	}
	
	@Async
	public void writeFile(byte[] bytes, String id, Long batchId) {
		try {
			String serverFile = StringUtils.append("H://acceptor/upload/", "/", batchId, "/", id, ".jpg");
			if(!new File(StringUtils.append("H://acceptor/upload/", "/", batchId, "/")).exists()) {
				new File(StringUtils.append("H://acceptor/upload/", "/", batchId, "/")).mkdirs();
			}
			OutputStream out = new FileOutputStream(new String(serverFile.getBytes("iso8859-1"),"UTF-8"), false);
	        out.write(bytes);
	        out.flush();
	        out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@GetMapping("/gateway/get/test1")
	@ResponseBody
	public ResponseModel get(@RequestBody Map<String, Object> params) {
		return ResponseModel.success("get请求访问成功, 入参：" + JSON.toJSONString(params));
	}
	
	@GetMapping("/gateway/get/test2")
	@ResponseBody
	public List<String> get1(@RequestBody Map<String, Object> params) {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			result.add("gateway-test-data-" + i);
		}
		return result;
	}
	
	@GetMapping("/gateway/get/getSignature")
	@ResponseBody
	public Map<String, String> getSignature(String timestamp, String appkey, String method, String stage, String secret){
    	String authStr = appkey + "&" + method.toUpperCase(Locale.ENGLISH) + "&" + stage + "&" + timestamp;
    	Map<String, String> map = new HashMap<String, String>();
    	map.put("signature", HmacSHA256Utils.digest(secret, authStr));
    	return map;
	}
}
