package com.whty.edu.brain.ig.service.api.vo;
 
import java.math.BigDecimal;
 
public class PsSubjectScoreVO {
 
	/**
	 * 
	 */
 	private Long id;
 	
	/**
	 * 考试id
	 */
 	private String examId;
 	
	/**
	 * 科目唯一标识
	 */
 	private String subjectId;
 	
	/**
	 * 科目名称
	 */
 	private String subjectName;
 	
	/**
	 * 考生答题卡唯一标识（关联学生）
	 */
 	private String sheetId;
 	
	/**
	 * 密号
	 */
 	private String cryptCode;
 	
	/**
	 * 准考证号
	 */
 	private String zkzh;
 	
	/**
	 * 总分
	 */
 	private BigDecimal totalScore;
 	
	/**
	 * 客观json
	 */
 	private String kgScoreJson;
 	
	/**
	 * 主观json
	 */
 	private String zgScoreJson;
 	
	/**
	 * 客观题是否有错
	 */
 	private Integer kgErrored;
 	
	/**
	 * 客观题错误信息
	 */
 	private String kgError;
 	
	/**
	 * 主观题是否有错
	 */
 	private Integer zgErrored;
 	
	/**
	 * 主观题错误信息
	 */
 	private String zgError;
 	
	/**
	 * 题卡图片列表
	 */
 	private String imgArrayStr;
 	
 	public Long getId() {
 		return id;
 	}
 	
 	public void setId(Long id) {
 		this.id = id;
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
 	
 	public String getSubjectName() {
 		return subjectName;
 	}
 	
 	public void setSubjectName(String subjectName) {
 		this.subjectName = subjectName;
 	}
 	
 	public String getSheetId() {
 		return sheetId;
 	}
 	
 	public void setSheetId(String sheetId) {
 		this.sheetId = sheetId;
 	}
 	
 	public String getCryptCode() {
 		return cryptCode;
 	}
 	
 	public void setCryptCode(String cryptCode) {
 		this.cryptCode = cryptCode;
 	}
 	
 	public String getZkzh() {
 		return zkzh;
 	}
 	
 	public void setZkzh(String zkzh) {
 		this.zkzh = zkzh;
 	}
 	
 	public BigDecimal getTotalScore() {
 		return totalScore;
 	}
 	
 	public void setTotalScore(BigDecimal totalScore) {
 		this.totalScore = totalScore;
 	}
 	
 	public String getKgScoreJson() {
 		return kgScoreJson;
 	}
 	
 	public void setKgScoreJson(String kgScoreJson) {
 		this.kgScoreJson = kgScoreJson;
 	}
 	
 	public String getZgScoreJson() {
 		return zgScoreJson;
 	}
 	
 	public void setZgScoreJson(String zgScoreJson) {
 		this.zgScoreJson = zgScoreJson;
 	}
 	
 	public Integer getKgErrored() {
 		return kgErrored;
 	}
 	
 	public void setKgErrored(Integer kgErrored) {
 		this.kgErrored = kgErrored;
 	}
 	
 	public String getKgError() {
 		return kgError;
 	}
 	
 	public void setKgError(String kgError) {
 		this.kgError = kgError;
 	}
 	
 	public Integer getZgErrored() {
 		return zgErrored;
 	}
 	
 	public void setZgErrored(Integer zgErrored) {
 		this.zgErrored = zgErrored;
 	}
 	
 	public String getZgError() {
 		return zgError;
 	}
 	
 	public void setZgError(String zgError) {
 		this.zgError = zgError;
 	}
 	
 	public String getImgArrayStr() {
 		return imgArrayStr;
 	}
 	
 	public void setImgArrayStr(String imgArrayStr) {
 		this.imgArrayStr = imgArrayStr;
 	}
 	
	@Override
	public String toString() {
		return "PsSubjectScoreVO :" + "，id=" + id  + "，examId=" + examId  + "，subjectId=" + subjectId  + "，subjectName=" + subjectName  + "，sheetId=" + sheetId  + "，cryptCode=" + cryptCode  + "，zkzh=" + zkzh  + "，totalScore=" + totalScore  + "，kgScoreJson=" + kgScoreJson  + "，zgScoreJson=" + zgScoreJson  + "，kgErrored=" + kgErrored  + "，kgError=" + kgError  + "，zgErrored=" + zgErrored  + "，zgError=" + zgError  + "，imgArrayStr=" + imgArrayStr ;
	}

}