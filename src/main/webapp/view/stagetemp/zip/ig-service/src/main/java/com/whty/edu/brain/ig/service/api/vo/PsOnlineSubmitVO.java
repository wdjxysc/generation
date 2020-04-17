package com.whty.edu.brain.ig.service.api.vo;
 
 
public class PsOnlineSubmitVO {
 
	/**
	 * 
	 */
 	private Long id;
 	
	/**
	 * 提交唯一标识
	 */
 	private String submitId;
 	
	/**
	 * 检测id
	 */
 	private String examId;
 	
	/**
	 * 科目id
	 */
 	private String subjectId;
 	
	/**
	 * 题卡信息json
	 */
 	private String submitContent;
 	
	/**
	 * 考生题卡校验信息
	 */
 	private String validateMessage;
 	
	/**
	 * 学生id
	 */
 	private String personId;
 	
	/**
	 * 逻辑删除.0-否;1-是
	 */
 	private Integer isDel;
 	
	/**
	 * 接收时间
	 */
 	private Long receiveTime;
 	
	/**
	 * 作答来源：H5,JXZS,ZHKT,STJC
	 */
 	private String submitSource;
 	
 	public Long getId() {
 		return id;
 	}
 	
 	public void setId(Long id) {
 		this.id = id;
 	}
 	
 	public String getSubmitId() {
 		return submitId;
 	}
 	
 	public void setSubmitId(String submitId) {
 		this.submitId = submitId;
 	}
 	
 	public String getExamId() {
 		return examId;
 	}
 	
 	public void setExamId(String examId) {
 		this.examId = examId;
 	}
 	
 	public String getSubjectId() {
 		return subjectId;
 	}
 	
 	public void setSubjectId(String subjectId) {
 		this.subjectId = subjectId;
 	}
 	
 	public String getSubmitContent() {
 		return submitContent;
 	}
 	
 	public void setSubmitContent(String submitContent) {
 		this.submitContent = submitContent;
 	}
 	
 	public String getValidateMessage() {
 		return validateMessage;
 	}
 	
 	public void setValidateMessage(String validateMessage) {
 		this.validateMessage = validateMessage;
 	}
 	
 	public String getPersonId() {
 		return personId;
 	}
 	
 	public void setPersonId(String personId) {
 		this.personId = personId;
 	}
 	
 	public Integer getIsDel() {
 		return isDel;
 	}
 	
 	public void setIsDel(Integer isDel) {
 		this.isDel = isDel;
 	}
 	
 	public Long getReceiveTime() {
 		return receiveTime;
 	}
 	
 	public void setReceiveTime(Long receiveTime) {
 		this.receiveTime = receiveTime;
 	}
 	
 	public String getSubmitSource() {
 		return submitSource;
 	}
 	
 	public void setSubmitSource(String submitSource) {
 		this.submitSource = submitSource;
 	}
 	
	@Override
	public String toString() {
		return "PsOnlineSubmitVO :" + "，id=" + id  + "，submitId=" + submitId  + "，examId=" + examId  + "，subjectId=" + subjectId  + "，submitContent=" + submitContent  + "，validateMessage=" + validateMessage  + "，personId=" + personId  + "，isDel=" + isDel  + "，receiveTime=" + receiveTime  + "，submitSource=" + submitSource ;
	}

}