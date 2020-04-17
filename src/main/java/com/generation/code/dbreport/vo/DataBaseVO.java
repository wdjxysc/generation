package com.generation.code.dbreport.vo;
/**
 * 
 * @ClassName:  DataBaseVO   
 * @Description:TODO(数据库连接基础信息)   
 * @author: 曾肖 
 * @date:   2019年5月30日 上午9:46:52   
 * @Copyright: 2019
 */
public class DataBaseVO {
	private String dburl;
	private String username;
	private String password;
	private String dbdriver;
	private String dbname;
	public String getDburl() {
		return dburl;
	}
	public void setDburl(String dburl) {
		this.dburl = dburl;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDbdriver() {
		return dbdriver;
	}
	public void setDbdriver(String dbdriver) {
		this.dbdriver = dbdriver;
	}
	public String getDbname() {
		return dbname;
	}
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}
	@Override
	public String toString() {
		return "DataBaseVO [dburl=" + dburl + ", username=" + username + ", password=" + password + ", dbdriver="
				+ dbdriver + ", dbname=" + dbname + "]";
	}
	
}
