/**  
 * @Title:  FileUtil.java   
 * @Package com.generation.code.util   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 曾肖
 * @date:   2019年5月31日 上午10:26:00   
 * @version V1.0 
 * @Copyright: 2019
 */
package com.generation.code.util;

import java.io.File;

import com.generation.code.framework.LoggerUtil;

/**   
 * @ClassName:  FileUtil   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 曾肖 
 * @date:   2019年5月31日 上午10:26:00   
 *     
 * @Copyright: 2019
 */
public class FileUtil {
	
	/**
	 * @Title: delete   
	 * @Description: 递归删除文件夹内文件
	 * @param path
	 * @return      
	 * boolean      
	 * @throws
	 */
    public static boolean delete(String path){
        File file = new File(path);
        if(!file.exists()){
            return false;
        }
        if(file.isFile()){
        	if(!file.delete()) {
        		LoggerUtil.info(CommonUtil.concat("isFile删除失败:", path));
        		return false;
        	}else {
        		LoggerUtil.info(CommonUtil.concat("isFile删除成功:", path));
        		return true;
        	}
        }
        File[] files = file.listFiles();
        if(files.length < 1) {
        	if(!file.delete()) {
        		LoggerUtil.info(CommonUtil.concat("空文件夹删除失败:", path));
        		return false;
        	}else {
        		LoggerUtil.info(CommonUtil.concat("空文件夹删除成功:", path));
        		return true;
        	}
        }
        for (File f : files) {
        	delete(f.getAbsolutePath());
        }
        if(!file.delete()) {
    		LoggerUtil.info(CommonUtil.concat("父文件夹删除失败:", path));
    		return false;
    	}else {
    		LoggerUtil.info(CommonUtil.concat("父文件夹删除成功:", path));
    		return true;
    	}
    }
}
