package com.whty.edu.brain.ig.service.api.vo;
 
 
public class PsMarkerVO {
 
	/**
	 * 
	 */
 	private Long id;
 	
	/**
	 * 评卷员唯一标识
	 */
 	private String markerId;
 	
	/**
	 * 考试唯一标识
	 */
 	private String examId;
 	
	/**
	 * 评题唯一标识
	 */
 	private String answerSheetItemId;
 	
	/**
	 * 人员唯一标识,源于外部系统
	 */
 	private String personId;
 	
	/**
	 * 校考，统考，联考使用评卷老师的学校唯一标识,即ps_tested_org.target_org_id
	 */
 	private String orgId;
 	
	/**
	 * 姓名
	 */
 	private String name;
 	
	/**
	 * 评卷角色：Normal-普通评卷员;
	 */
 	private String role;
 	
	/**
	 * 计划评卷量,-1表示无计划评卷量
	 */
 	private Integer planned;
 	
	/**
	 * 实际完成评卷量
	 */
 	private Integer finished;
 	
	/**
	 * 工作状态：0-待命;1-正评;2-试评;3-暂停
	 */
 	private Integer status;
 	
	/**
	 * 在线状态：0-离线;1-在线
	 */
 	private Integer online;
 	
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
 	
 	public String getMarkerId() {
 		return markerId;
 	}
 	
 	public void setMarkerId(String markerId) {
 		this.markerId = markerId;
 	}
 	
 	public String getExamId() {
 		return examId;
 	}
 	
 	public void setExamId(String examId) {
 		this.examId = examId;
 	}
 	
 	public String getAnswerSheetItemId() {
 		return answerSheetItemId;
 	}
 	
 	public void setAnswerSheetItemId(String answerSheetItemId) {
 		this.answerSheetItemId = answerSheetItemId;
 	}
 	
 	public String getPersonId() {
 		return personId;
 	}
 	
 	public void setPersonId(String personId) {
 		this.personId = personId;
 	}
 	
 	public String getOrgId() {
 		return orgId;
 	}
 	
 	public void setOrgId(String orgId) {
 		this.orgId = orgId;
 	}
 	
 	public String getName() {
 		return name;
 	}
 	
 	public void setName(String name) {
 		this.name = name;
 	}
 	
 	public String getRole() {
 		return role;
 	}
 	
 	public void setRole(String role) {
 		this.role = role;
 	}
 	
 	public Integer getPlanned() {
 		return planned;
 	}
 	
 	public void setPlanned(Integer planned) {
 		this.planned = planned;
 	}
 	
 	public Integer getFinished() {
 		return finished;
 	}
 	
 	public void setFinished(Integer finished) {
 		this.finished = finished;
 	}
 	
 	public Integer getStatus() {
 		return status;
 	}
 	
 	public void setStatus(Integer status) {
 		this.status = status;
 	}
 	
 	public Integer getOnline() {
 		return online;
 	}
 	
 	public void setOnline(Integer online) {
 		this.online = online;
 	}
 	
 	public Integer getIsDel() {
 		return isDel;
 	}
 	
 	public void setIsDel(Integer isDel) {
 		this.isDel = isDel;
 	}
 	
	@Override
	public String toString() {
		return "PsMarkerVO :" + "，id=" + id  + "，markerId=" + markerId  + "，examId=" + examId  + "，answerSheetItemId=" + answerSheetItemId  + "，personId=" + personId  + "，orgId=" + orgId  + "，name=" + name  + "，role=" + role  + "，planned=" + planned  + "，finished=" + finished  + "，status=" + status  + "，online=" + online  + "，isDel=" + isDel ;
	}

}