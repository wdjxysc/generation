package com.whty.edu.brain.ig.service.api.vo;
 
import java.util.Date;
import java.math.BigDecimal;
 
public class PsKgMarkVO {
 
	/**
	 * 
	 */
 	private Long id;
 	
	/**
	 * 考号题唯一标识
	 */
 	private String markId;
 	
	/**
	 * 考试唯一标识
	 */
 	private String examId;
 	
	/**
	 * 扫描批次唯一标识
	 */
 	private String batchId;
 	
	/**
	 * 评题唯一标识
	 */
 	private String answerSheetItemId;
 	
	/**
	 * 考生答题卡唯一标识
	 */
 	private String sheetId;
 	
	/**
	 * 提取时间
	 */
 	private Date fetchTime;
 	
	/**
	 * 评卷员唯一标识，markType=Mechine时值为：Mechine
	 */
 	private String markerId;
 	
	/**
	 * 评卷员名称
	 */
 	private String markerName;
 	
	/**
	 * 处理时间
	 */
 	private Date handleTime;
 	
	/**
	 * 密号
	 */
 	private String cryptCode;
 	
	/**
	 * 得分
	 */
 	private BigDecimal score;
 	
	/**
	 * 每题得分，以;分隔
	 */
 	private String scores;
 	
	/**
	 * 每题选项，以;分隔，无选项以＃代替
	 */
 	private String optional;
 	
	/**
	 * 机评时怀疑卷分类：0-无怀疑;1-有怀疑
	 */
 	private Integer doubt;
 	
	/**
	 * 机评时怀疑卷处理标志：1-已经处理;0-未处理
	 */
 	private Integer doubtDone;
 	
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
 	
 	public String getMarkId() {
 		return markId;
 	}
 	
 	public void setMarkId(String markId) {
 		this.markId = markId;
 	}
 	
 	public String getExamId() {
 		return examId;
 	}
 	
 	public void setExamId(String examId) {
 		this.examId = examId;
 	}
 	
 	public String getBatchId() {
 		return batchId;
 	}
 	
 	public void setBatchId(String batchId) {
 		this.batchId = batchId;
 	}
 	
 	public String getAnswerSheetItemId() {
 		return answerSheetItemId;
 	}
 	
 	public void setAnswerSheetItemId(String answerSheetItemId) {
 		this.answerSheetItemId = answerSheetItemId;
 	}
 	
 	public String getSheetId() {
 		return sheetId;
 	}
 	
 	public void setSheetId(String sheetId) {
 		this.sheetId = sheetId;
 	}
 	
 	public Date getFetchTime() {
 		return fetchTime;
 	}
 	
 	public void setFetchTime(Date fetchTime) {
 		this.fetchTime = fetchTime;
 	}
 	
 	public String getMarkerId() {
 		return markerId;
 	}
 	
 	public void setMarkerId(String markerId) {
 		this.markerId = markerId;
 	}
 	
 	public String getMarkerName() {
 		return markerName;
 	}
 	
 	public void setMarkerName(String markerName) {
 		this.markerName = markerName;
 	}
 	
 	public Date getHandleTime() {
 		return handleTime;
 	}
 	
 	public void setHandleTime(Date handleTime) {
 		this.handleTime = handleTime;
 	}
 	
 	public String getCryptCode() {
 		return cryptCode;
 	}
 	
 	public void setCryptCode(String cryptCode) {
 		this.cryptCode = cryptCode;
 	}
 	
 	public BigDecimal getScore() {
 		return score;
 	}
 	
 	public void setScore(BigDecimal score) {
 		this.score = score;
 	}
 	
 	public String getScores() {
 		return scores;
 	}
 	
 	public void setScores(String scores) {
 		this.scores = scores;
 	}
 	
 	public String getOptional() {
 		return optional;
 	}
 	
 	public void setOptional(String optional) {
 		this.optional = optional;
 	}
 	
 	public Integer getDoubt() {
 		return doubt;
 	}
 	
 	public void setDoubt(Integer doubt) {
 		this.doubt = doubt;
 	}
 	
 	public Integer getDoubtDone() {
 		return doubtDone;
 	}
 	
 	public void setDoubtDone(Integer doubtDone) {
 		this.doubtDone = doubtDone;
 	}
 	
 	public Integer getIsDel() {
 		return isDel;
 	}
 	
 	public void setIsDel(Integer isDel) {
 		this.isDel = isDel;
 	}
 	
	@Override
	public String toString() {
		return "PsKgMarkVO :" + "，id=" + id  + "，markId=" + markId  + "，examId=" + examId  + "，batchId=" + batchId  + "，answerSheetItemId=" + answerSheetItemId  + "，sheetId=" + sheetId  + "，fetchTime=" + fetchTime  + "，markerId=" + markerId  + "，markerName=" + markerName  + "，handleTime=" + handleTime  + "，cryptCode=" + cryptCode  + "，score=" + score  + "，scores=" + scores  + "，optional=" + optional  + "，doubt=" + doubt  + "，doubtDone=" + doubtDone  + "，isDel=" + isDel ;
	}

}