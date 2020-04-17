package com.generation.code.dbreport.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.generation.code.constant.CommonConstant;
import com.generation.code.constant.ConnectTypeConstant;
import com.generation.code.constant.StatusCodeConstant;
import com.generation.code.dbreport.vo.DataBaseVO;
import com.generation.code.framework.ResponseModel;
import com.generation.code.util.JdbcUtils;
import com.generation.code.util.WordUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
/**
 * @ClassName:  DbReportController   
 * @Description:TODO(数据报表操作层)   
 * @author: 曾肖 
 * @date:   2019年5月30日 上午9:49:04   
 *     
 * @Copyright: 2019
 */
@Controller
@RequestMapping("/dbreport")
@Api(tags="数据报表操作层")
public class DbReportController {
	/**
	 * @Title: viewIndex   
	 * @Description: TODO(主页)   
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	@RequestMapping(value="/index.view", method=RequestMethod.GET)
	public String viewIndex() {
		return "/web/dbreport/index";
	}
	/**
	 * @Title: testDataBaseConnection   
	 * @Description: TODO(测试当前配置连接)   
	 * @param: @param dataBase
	 * @param: @return      
	 * @return: ResponseModel      
	 * @throws
	 */
	@RequestMapping(value="/testConnection.do", method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation("测试数据库连接")
	@ApiImplicitParams({
		@ApiImplicitParam(name="dburl",value="数据库连接",required=true,paramType="String"),
		@ApiImplicitParam(name="username",value="数据库用户名",required=true,paramType="String"),
		@ApiImplicitParam(name="password",value="数据库密码",required=true,paramType="String"),
		@ApiImplicitParam(name="dbdriver",value="数据库驱动类型",required=true,paramType="String")
	})
	public ResponseModel testDataBaseConnection(DataBaseVO dataBase) {
		if(ConnectTypeConstant.MYSQL.equals(dataBase.getDbdriver())) {
			JdbcUtils.initMysql(dataBase.getDburl(), dataBase.getUsername(), dataBase.getPassword(), dataBase.getDbname());
		}
		String re = JdbcUtils.get(StatusCodeConstant.TEST_DB_CONNECTION_SQL, null);
		if(StatusCodeConstant.TEST_DB_CONNECTION_RESULT.equals(re)) {
			return ResponseModel.success();
		}
		return ResponseModel.fail();
	}
	/**
	 * @Title: getDataBaseTables   
	 * @Description: TODO(根据输入的表名模糊查询所有匹配的数据库表)   
	 * @param: @param dataBase
	 * @param: @param queryTableName
	 * @param: @return      
	 * @return: ResponseModel      
	 * @throws
	 */
	@RequestMapping(value="/getDataBaseTables.do", method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation("根据输入的表名模糊查询所有匹配的数据库表")
	@ApiImplicitParams({
		@ApiImplicitParam(name="dburl",value="数据库连接",required=true,paramType="String"),
		@ApiImplicitParam(name="username",value="数据库用户名",required=true,paramType="String"),
		@ApiImplicitParam(name="password",value="数据库密码",required=true,paramType="String"),
		@ApiImplicitParam(name="dbdriver",value="数据库驱动类型",required=true,paramType="String"),
		@ApiImplicitParam(name="queryTableName",value="模糊匹配的表名",required=true,paramType="String")
	})
	public ResponseModel getDataBaseTables(DataBaseVO dataBase, String queryTableName) {
		if(ConnectTypeConstant.MYSQL.equals(dataBase.getDbdriver())) {
			JdbcUtils.initMysql(dataBase.getDburl(), dataBase.getUsername(), dataBase.getPassword(), dataBase.getDbname());
		}
		String sql = "select table_name from information_schema.tables where table_schema = ? and table_name like concat('%', ?, '%')";
		List<Map<String, Object>> tables = JdbcUtils.list(sql, new String[] {dataBase.getDbname(), queryTableName});
		return ResponseModel.success(tables);
	}
	/**
	 * @Title: reportTablesDoc   
	 * @Description: TODO(输出文档)   
	 * @param: @param dataBase
	 * @param: @param tables
	 * @param: @return      
	 * @return: ResponseModel      
	 * @throws
	 */
	@RequestMapping(value="/reportTablesDoc.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseModel reportTablesDoc(DataBaseVO dataBase, String tables) {
		String[] arr = tables.split(",");
		List<String> list = Arrays.asList(arr);
		if(ConnectTypeConstant.MYSQL.equals(dataBase.getDbdriver())) {
			JdbcUtils.initMysql(dataBase.getDburl(), dataBase.getUsername(), dataBase.getPassword(), dataBase.getDbname());
		}
		if(list.size() < 1) {
			return ResponseModel.fail("未选择表");
		}else {
			String path = WordUtil.outputDataBaseWord(list);
			if(StringUtils.isNotBlank(path)) {
				return ResponseModel.success(CommonConstant.BASE_TABLE_DOWNLOAD.replace("{docname}", path));
			}
		}
		return ResponseModel.fail();
	} 
}
