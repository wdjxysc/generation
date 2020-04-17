package com.whty.edu.brain.ig.service.api.vo;
 
import java.util.Date;
 
public class PsExamineeSheetSlicesVO {
 
	/**
	 * 
	 */
 	private Long id;
 	
	/**
	 * 考生答题卡唯一标识
	 */
 	private String sheetId;
 	
	/**
	 * 考试唯一标识
	 */
 	private String examId;
 	
	/**
	 * 提交内容
	 */
 	private String submitContent;
 	
	/**
	 * 提交时间
	 */
 	private Date submitTime;
 	
	/**
	 * 提交的图片地址
	 */
 	private String imgUrl;
 	
	/**
	 * 旋转角度 -360--360
	 */
 	private Integer roate;
 	
	/**
	 * 评题唯一标识
	 */
 	private String answerSheetItemId;
 	
	/**
	 * 顺序
	 */
 	private String seq;
 	
	/**
	 * 逻辑删除.0-否;1-是
	 */
 	private Integer isDel;
 	
	/**
	 * 英语的填空题采取文字作答时，会将所有文字记录合成一个图片
	 */
 	private Integer isComplex;
 	
	/**
	 * 英语的填空题采取文字作答时，会将 所有文字记录合成一个图片,所以此情况只有第一条记录textImgBase64存储图片信息，其他记录为空
	 */
 	private String textImgBase64;
 	
	/**
	 * 切片坐标信息
	 */
 	private String coordinate;
 	
 	public Long getId() {
 		return id;
 	}
 	
 	public void setId(Long id) {
 		this.id = id;
 	}
 	
 	public String getSheetId() {
 		return sheetId;
 	}
 	
 	public void setSheetId(String sheetId) {
 		this.sheetId = sheetId;
 	}
 	
 	public String getExamId() {
 		return examId;
 	}
 	
 	public void setExamId(String examId) {
 		this.examId = examId;
 	}
 	
 	public String getSubmitContent() {
 		return submitContent;
 	}
 	
 	public void setSubmitContent(String submitContent) {
 		this.submitContent = submitContent;
 	}
 	
 	public Date getSubmitTime() {
 		return submitTime;
 	}
 	
 	public void setSubmitTime(Date submitTime) {
 		this.submitTime = submitTime;
 	}
 	
 	public String getImgUrl() {
 		return imgUrl;
 	}
 	
 	public void setImgUrl(String imgUrl) {
 		this.imgUrl = imgUrl;
 	}
 	
 	public Integer getRoate() {
 		return roate;
 	}
 	
 	public void setRoate(Integer roate) {
 		this.roate = roate;
 	}
 	
 	public String getAnswerSheetItemId() {
 		return answerSheetItemId;
 	}
 	
 	public void setAnswerSheetItemId(String answerSheetItemId) {
 		this.answerSheetItemId = answerSheetItemId;
 	}
 	
 	public String getSeq() {
 		return seq;
 	}
 	
 	public void setSeq(String seq) {
 		this.seq = seq;
 	}
 	
 	public Integer getIsDel() {
 		return isDel;
 	}
 	
 	public void setIsDel(Integer isDel) {
 		this.isDel = isDel;
 	}
 	
 	public Integer getIsComplex() {
 		return isComplex;
 	}
 	
 	public void setIsComplex(Integer isComplex) {
 		this.isComplex = isComplex;
 	}
 	
 	public String getTextImgBase64() {
 		return textImgBase64;
 	}
 	
 	public void setTextImgBase64(String textImgBase64) {
 		this.textImgBase64 = textImgBase64;
 	}
 	
 	public String getCoordinate() {
 		return coordinate;
 	}
 	
 	public void setCoordinate(String coordinate) {
 		this.coordinate = coordinate;
 	}
 	
	@Override
	public String toString() {
		return "PsExamineeSheetSlicesVO :" + "，id=" + id  + "，sheetId=" + sheetId  + "，examId=" + examId  + "，submitContent=" + submitContent  + "，submitTime=" + submitTime  + "，imgUrl=" + imgUrl  + "，roate=" + roate  + "，answerSheetItemId=" + answerSheetItemId  + "，seq=" + seq  + "，isDel=" + isDel  + "，isComplex=" + isComplex  + "，textImgBase64=" + textImgBase64  + "，coordinate=" + coordinate ;
	}

}