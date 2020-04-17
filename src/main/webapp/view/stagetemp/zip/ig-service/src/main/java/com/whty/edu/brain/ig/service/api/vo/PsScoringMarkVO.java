package com.whty.edu.brain.ig.service.api.vo;
 
import java.math.BigDecimal;
import java.util.Date;
 
public class PsScoringMarkVO {
 
	/**
	 * 
	 */
 	private Long id;
 	
	/**
	 * 评分题唯一标识
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
	 * 科目唯一标识
	 */
 	private String subjectId;
 	
	/**
	 * 考生答题卡唯一标识（关联学生）
	 */
 	private String sheetId;
 	
	/**
	 * 评题唯一标识
	 */
 	private String answerSheetItemId;
 	
	/**
	 * 班级
	 */
 	private String className;
 	
	/**
	 * 姓名
	 */
 	private String studentName;
 	
	/**
	 * 密号
	 */
 	private String cryptCode;
 	
	/**
	 * 准考证号
	 */
 	private String zkzh;
 	
	/**
	 * 提取顺序号，每个考试科目都重新排序
	 */
 	private Integer fetchSeq;
 	
	/**
	 * 得分
	 */
 	private BigDecimal score;
 	
	/**
	 * 给分点得分，多个给分点分数用，连接
	 */
 	private String scores;
 	
	/**
	 * 抽取时间，回收时判断超过5分钟的强制回收
	 */
 	private Date fetchTime;
 	
	/**
	 * 提交时间
	 */
 	private Date submitTime;
 	
	/**
	 * 回评时间
	 */
 	private Date resubmitTime;
 	
	/**
	 * 抽取阅卷员id，抽取时更新
	 */
 	private String fetchMarkerId;
 	
	/**
	 * 正评已完成的评卷id,正评提交时更新
	 */
 	private String submitMarkerId;
 	
	/**
	 * 被抽取标志-0-否;1-是
	 */
 	private Integer fetchFlag;
 	
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
 	
	/**
	 * 是否是学生评阅 1 是 0 老师评阅
	 */
 	private Integer isExamineeMark;
 	
	/**
	 * 记录回评人的markerId， 正常情况下fetch_markerId与此字段值相同，而智能阅卷后的不同
	 */
 	private String remarkMarkerId;
 	
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
 	
 	public String getSubjectId() {
 		return subjectId;
 	}
 	
 	public void setSubjectId(String subjectId) {
 		this.subjectId = subjectId;
 	}
 	
 	public String getSheetId() {
 		return sheetId;
 	}
 	
 	public void setSheetId(String sheetId) {
 		this.sheetId = sheetId;
 	}
 	
 	public String getAnswerSheetItemId() {
 		return answerSheetItemId;
 	}
 	
 	public void setAnswerSheetItemId(String answerSheetItemId) {
 		this.answerSheetItemId = answerSheetItemId;
 	}
 	
 	public String getClassName() {
 		return className;
 	}
 	
 	public void setClassName(String className) {
 		this.className = className;
 	}
 	
 	public String getStudentName() {
 		return studentName;
 	}
 	
 	public void setStudentName(String studentName) {
 		this.studentName = studentName;
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
 	
 	public Integer getFetchSeq() {
 		return fetchSeq;
 	}
 	
 	public void setFetchSeq(Integer fetchSeq) {
 		this.fetchSeq = fetchSeq;
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
 	
 	public Date getFetchTime() {
 		return fetchTime;
 	}
 	
 	public void setFetchTime(Date fetchTime) {
 		this.fetchTime = fetchTime;
 	}
 	
 	public Date getSubmitTime() {
 		return submitTime;
 	}
 	
 	public void setSubmitTime(Date submitTime) {
 		this.submitTime = submitTime;
 	}
 	
 	public Date getResubmitTime() {
 		return resubmitTime;
 	}
 	
 	public void setResubmitTime(Date resubmitTime) {
 		this.resubmitTime = resubmitTime;
 	}
 	
 	public String getFetchMarkerId() {
 		return fetchMarkerId;
 	}
 	
 	public void setFetchMarkerId(String fetchMarkerId) {
 		this.fetchMarkerId = fetchMarkerId;
 	}
 	
 	public String getSubmitMarkerId() {
 		return submitMarkerId;
 	}
 	
 	public void setSubmitMarkerId(String submitMarkerId) {
 		this.submitMarkerId = submitMarkerId;
 	}
 	
 	public Integer getFetchFlag() {
 		return fetchFlag;
 	}
 	
 	public void setFetchFlag(Integer fetchFlag) {
 		this.fetchFlag = fetchFlag;
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
 	
 	public Integer getIsExamineeMark() {
 		return isExamineeMark;
 	}
 	
 	public void setIsExamineeMark(Integer isExamineeMark) {
 		this.isExamineeMark = isExamineeMark;
 	}
 	
 	public String getRemarkMarkerId() {
 		return remarkMarkerId;
 	}
 	
 	public void setRemarkMarkerId(String remarkMarkerId) {
 		this.remarkMarkerId = remarkMarkerId;
 	}
 	
	@Override
	public String toString() {
		return "PsScoringMarkVO :" + "，id=" + id  + "，markId=" + markId  + "，examId=" + examId  + "，batchId=" + batchId  + "，subjectId=" + subjectId  + "，sheetId=" + sheetId  + "，answerSheetItemId=" + answerSheetItemId  + "，className=" + className  + "，studentName=" + studentName  + "，cryptCode=" + cryptCode  + "，zkzh=" + zkzh  + "，fetchSeq=" + fetchSeq  + "，score=" + score  + "，scores=" + scores  + "，fetchTime=" + fetchTime  + "，submitTime=" + submitTime  + "，resubmitTime=" + resubmitTime  + "，fetchMarkerId=" + fetchMarkerId  + "，submitMarkerId=" + submitMarkerId  + "，fetchFlag=" + fetchFlag  + "，doubt=" + doubt  + "，doubtDone=" + doubtDone  + "，isDel=" + isDel  + "，isExamineeMark=" + isExamineeMark  + "，remarkMarkerId=" + remarkMarkerId ;
	}

}