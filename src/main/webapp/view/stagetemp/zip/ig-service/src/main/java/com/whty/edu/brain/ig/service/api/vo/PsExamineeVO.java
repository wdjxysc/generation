package com.whty.edu.brain.ig.service.api.vo;
 
import java.util.Date;
 
public class PsExamineeVO {
 
	/**
	 * 
	 */
 	private Long id;
 	
	/**
	 * 考生唯一标识
	 */
 	private String examineeId;
 	
	/**
	 * 考试唯一标识
	 */
 	private String examId;
 	
	/**
	 * 考生唯一标识,源于外部系统
	 */
 	private String personId;
 	
	/**
	 * 考生所在学校唯一标识;源于ps_TestedOrg.targetOrgId
	 */
 	private String schoolId;
 	
	/**
	 * 学校名称
	 */
 	private String schoolName;
 	
	/**
	 * 考生所在班级唯一标识;源于ps_TestedOrg.targetOrgId
	 */
 	private String clazzId;
 	
	/**
	 * 考生所在班级名称
	 */
 	private String clazzName;
 	
	/**
	 * 考生姓名
	 */
 	private String name;
 	
	/**
	 * 
	 */
 	private String studentNo;
 	
	/**
	 * 参与标志：1-参考(YES);2-缺卡(None);3-缺考(No);4-作弊(Cogged),默认缺卡,扫描及考号异常处理时更新
	 */
 	private Integer attended;
 	
	/**
	 * 考号
	 */
 	private String examNumber;
 	
	/**
	 * 最后更新时间
	 */
 	private Date lastUpdateTime;
 	
	/**
	 * 最后更新者唯一标识
	 */
 	private String lastOperatorId;
 	
	/**
	 * 最后更新者姓名
	 */
 	private String lastOperatorName;
 	
	/**
	 * 逻辑删除.0-否;1-是
	 */
 	private Integer isDel;
 	
 	public Long getId() {
 		return id;
 	}
 	
 	public void setId(Long id) {
 		this.id = id;
 	}
 	
 	public String getExamineeId() {
 		return examineeId;
 	}
 	
 	public void setExamineeId(String examineeId) {
 		this.examineeId = examineeId;
 	}
 	
 	public String getExamId() {
 		return examId;
 	}
 	
 	public void setExamId(String examId) {
 		this.examId = examId;
 	}
 	
 	public String getPersonId() {
 		return personId;
 	}
 	
 	public void setPersonId(String personId) {
 		this.personId = personId;
 	}
 	
 	public String getSchoolId() {
 		return schoolId;
 	}
 	
 	public void setSchoolId(String schoolId) {
 		this.schoolId = schoolId;
 	}
 	
 	public String getSchoolName() {
 		return schoolName;
 	}
 	
 	public void setSchoolName(String schoolName) {
 		this.schoolName = schoolName;
 	}
 	
 	public String getClazzId() {
 		return clazzId;
 	}
 	
 	public void setClazzId(String clazzId) {
 		this.clazzId = clazzId;
 	}
 	
 	public String getClazzName() {
 		return clazzName;
 	}
 	
 	public void setClazzName(String clazzName) {
 		this.clazzName = clazzName;
 	}
 	
 	public String getName() {
 		return name;
 	}
 	
 	public void setName(String name) {
 		this.name = name;
 	}
 	
 	public String getStudentNo() {
 		return studentNo;
 	}
 	
 	public void setStudentNo(String studentNo) {
 		this.studentNo = studentNo;
 	}
 	
 	public Integer getAttended() {
 		return attended;
 	}
 	
 	public void setAttended(Integer attended) {
 		this.attended = attended;
 	}
 	
 	public String getExamNumber() {
 		return examNumber;
 	}
 	
 	public void setExamNumber(String examNumber) {
 		this.examNumber = examNumber;
 	}
 	
 	public Date getLastUpdateTime() {
 		return lastUpdateTime;
 	}
 	
 	public void setLastUpdateTime(Date lastUpdateTime) {
 		this.lastUpdateTime = lastUpdateTime;
 	}
 	
 	public String getLastOperatorId() {
 		return lastOperatorId;
 	}
 	
 	public void setLastOperatorId(String lastOperatorId) {
 		this.lastOperatorId = lastOperatorId;
 	}
 	
 	public String getLastOperatorName() {
 		return lastOperatorName;
 	}
 	
 	public void setLastOperatorName(String lastOperatorName) {
 		this.lastOperatorName = lastOperatorName;
 	}
 	
 	public Integer getIsDel() {
 		return isDel;
 	}
 	
 	public void setIsDel(Integer isDel) {
 		this.isDel = isDel;
 	}
 	
	@Override
	public String toString() {
		return "PsExamineeVO :" + "，id=" + id  + "，examineeId=" + examineeId  + "，examId=" + examId  + "，personId=" + personId  + "，schoolId=" + schoolId  + "，schoolName=" + schoolName  + "，clazzId=" + clazzId  + "，clazzName=" + clazzName  + "，name=" + name  + "，studentNo=" + studentNo  + "，attended=" + attended  + "，examNumber=" + examNumber  + "，lastUpdateTime=" + lastUpdateTime  + "，lastOperatorId=" + lastOperatorId  + "，lastOperatorName=" + lastOperatorName  + "，isDel=" + isDel ;
	}

}