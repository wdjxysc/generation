package com.generation.code.util;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import com.aspose.words.BreakType;
import com.aspose.words.Document;
import com.aspose.words.DocumentBuilder;
import com.aspose.words.License;
import com.generation.code.constant.CommonConstant;
import com.generation.code.framework.LoggerUtil;

/**
 * @ClassName:  WordUtil   
 * @Description:TODO(word文档操作类)   
 * @author: 曾肖 
 * @date:   2019年5月30日 上午9:49:52   
 *     
 * @Copyright: 2019
 */
public class WordUtil {
	
	static {
		try {
			// license路径注册破解功能
			InputStream license = new FileInputStream(new File(System.getProperty("user.dir") + "//src//main//resources//license.xml"));    
			License aposeLic = new License();
			aposeLic.setLicense(license);
		}catch(Exception e) { e.printStackTrace(); }
	}
	
	public static String outputDataBaseWord(List<String> tables) {
		try {
			ExecutorService exec = Executors.newFixedThreadPool(tables.size());
			List<FutureTask<Map<String, List<Map<String, Object>>>>> taskList = new ArrayList<FutureTask<Map<String, List<Map<String, Object>>>>>();
			for (int i = 0; i < tables.size(); i++) {
				final String table = tables.get(i);
				FutureTask<Map<String, List<Map<String, Object>>>> futureTask = new FutureTask<Map<String, List<Map<String, Object>>>>(new Callable<Map<String, List<Map<String, Object>>>>() {
					@Override
					public Map<String, List<Map<String, Object>>> call() throws Exception {
						List<Map<String, Object>> l = JdbcUtils.list("select * from information_schema.columns where table_schema = ? and table_name = ?", new String[] {JdbcUtils.getDbname(), table});
						Map<String, List<Map<String, Object>>> m = new HashMap<String, List<Map<String, Object>>>(1);
						m.put(table, l);
						return m;
					}
				});
				taskList.add(futureTask);
				exec.submit(futureTask);
			}
			Map<String, List<Map<String, Object>>> r = new HashMap<String, List<Map<String, Object>>>(tables.size());
			for (int i = 0; i < taskList.size(); i++) {
				try {
					String key = "";
					Map<String, List<Map<String, Object>>> item = taskList.get(i).get();
					for(String ikey : item.keySet()) {
						key = ikey;
						break;
					}
					r.put(key, item.get(key));
				} catch (Exception e) {}
			}
			return createWord(r);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static String createWord(Map<String, List<Map<String, Object>>> map) throws Exception{
		InputStream path = new FileInputStream(new File(System.getProperty("user.dir") + "//src//main//resources//base_table.docx"));
		Document templateDocu = new Document(path);
		DocumentBuilder documentBuilder = new DocumentBuilder(templateDocu);
		String[] titles = new String[] {"字段", "类型", "必填", "默认", "描述"};
		boolean flag = false;
		for(String k : map.keySet()) {
			if(flag) {
				documentBuilder.insertBreak(BreakType.PAGE_BREAK);
			}
			flag = true;
			documentBuilder.insertHtml("<h1>" + k + "</h1>");
			documentBuilder.startTable();
			for (int i = 0; i < titles.length; i++) {
				documentBuilder.insertCell();
				documentBuilder.getCellFormat().getShading().setBackgroundPatternColor(Color.GRAY);
				documentBuilder.write(titles[i]);
			}
			documentBuilder.endRow();
			List<Map<String, Object>> l = map.get(k);
			documentBuilder.getCellFormat().getShading().setBackgroundPatternColor(Color.WHITE);
			for (int i = 0; i < l.size(); i++) {
				Map<String, Object> item = l.get(i);
				documentBuilder.insertCell();
				documentBuilder.write(String.valueOf(item.get("COLUMN_NAME")));
				documentBuilder.insertCell();
				documentBuilder.write(String.valueOf(item.get("COLUMN_TYPE")));
				documentBuilder.insertCell();
				documentBuilder.write("YES".equals(String.valueOf(item.get("IS_NULLABLE"))) ? "否" : "是");
				documentBuilder.insertCell();
				documentBuilder.write(String.valueOf(item.get("COLUMN_DEFAULT")));
				documentBuilder.insertCell();
				documentBuilder.write(String.valueOf(item.get("COLUMN_COMMENT")));
				documentBuilder.endRow();
			}
			documentBuilder.endTable();
		}
		LoggerUtil.info("文档生成完毕");
		LoggerUtil.info("进行输出");
		String savepath = CommonUtil.concat(System.getProperty("user.dir"), CommonConstant.SRC_MAIN_WEBAPP_VIEW, "/docs/输出表结构.docx");
		File file = new File(savepath);
		String fileName = "输出表结构";
		if(file.exists()) {
			fileName = "输出表结构" + System.currentTimeMillis();
			savepath = savepath.replace("输出表结构", fileName);
		}
		templateDocu.save(savepath);
		return fileName;
	}
}
