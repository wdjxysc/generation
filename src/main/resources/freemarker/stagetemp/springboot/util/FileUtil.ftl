package ${packge}.framework.util;

import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ${packge}.framework.util.StringUtil;

/**
 * @ClassName: FileUtil
 * @Description: 文件操作工具类
 * @author: generation
 * @date: ${.now?string["yyyy年MM月dd日 hh:mm:SS"]}
 * @Copyright: generation
 */
public class FileUtil {

	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);
	
	/**
	 * @Title: delete   
	 * @Description: 递归删除文件夹内文件
	 * @param path
	 * @return  boolean      
	 * @throws
	 */
    public static boolean delete(String path){
        File file = new File(path);
        if(!file.exists()){
            return false;
        }
        if(file.isFile()){
        	if(!file.delete()) {
        		logger.info(StringUtil.concat("isFile删除失败:", path));
        		return false;
        	}else {
        		logger.info(StringUtil.concat("isFile删除成功:", path));
        		return true;
        	}
        }
        File[] files = file.listFiles();
        if(files.length < 1) {
        	if(!file.delete()) {
        		logger.info(StringUtil.concat("空文件夹删除失败:", path));
        		return false;
        	}else {
        		logger.info(StringUtil.concat("空文件夹删除成功:", path));
        		return true;
        	}
        }
        for (File f : files) {
        	delete(f.getAbsolutePath());
        }
        if(!file.delete()) {
    		logger.info(StringUtil.concat("父文件夹删除失败:", path));
    		return false;
    	}else {
    		logger.info(StringUtil.concat("父文件夹删除成功:", path));
    		return true;
    	}
    }
}
