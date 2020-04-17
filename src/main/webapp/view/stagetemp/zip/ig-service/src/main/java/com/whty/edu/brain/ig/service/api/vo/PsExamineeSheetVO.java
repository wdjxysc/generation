package com.whty.edu.brain.ig.service.api.vo;
 
import java.math.BigDecimal;
import java.util.Date;
 
public class PsExamineeSheetVO {
 
	/**
	 * 
	 */
 	private Long id;
 	
	/**
	 * 答题卡唯一标识
	 */
 	private String sheetId;
 	
	/**
	 * 所属科答题卡唯一标识
	 */
 	private String answerSheetId;
 	
	/**
	 * 考试唯一标识
	 */
 	private String examId;
 	
	/**
	 * 扫描批次唯一标识
	 */
 	private String batchId;
 	
	/**
	 * 扫描时生成的唯一标识，在考号异常示未处理完成时作为考生卡的唯一标识
	 */
 	private String sheetKey;
 	
	/**
	 * AB卡分类，有分类时值为Ａ或者B
	 */
 	private String catagory;
 	
	/**
	 * 识别原始结果
	 */
 	private String origin;
 	
	/**
	 * 考号
	 */
 	private String examNumber;
 	
	/**
	 * 科目密号表密号序号
	 */
 	private Long seq;
 	
	/**
	 * 密号,评阅时使用的唯一标识
	 */
 	private String cryptCode;
 	
	/**
	 * 是否分析成绩 0-不分析，1-分析
	 */
 	private Integer analysisable;
 	
	/**
	 * 是否出成绩单：0-不出成绩单，即在成绩单中直接记０分;1-出成绩单元格
	 */
 	private Integer scoredable;
 	
	/**
	 * 是否进行主观题评阅：0-不评;1-评阅
	 */
 	private Integer markable;
 	
	/**
	 * 整卷得分
	 */
 	private BigDecimal score;
 	
	/**
	 * 客观题得分
	 */
 	private BigDecimal kgScore;
 	
	/**
	 * 主观题得分
	 */
 	private BigDecimal zgScore;
 	
	/**
	 * 题卡状态：1-参考(YES);3-缺考(No);4-作弊(Cogged),默认参考,扫描及考号异常处理时更新
	 */
 	private Integer attended;
 	
	/**
	 * 切题版本号,0-题卡还未切割过
	 */
 	private Integer cutSeq;
 	
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
	 * 机评时怀疑卷分类：0-无怀疑;1-有怀疑；若有怀疑，需要根据评卷控制策略决定exam_number是否有值
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
	 * 作答提交时间
	 */
 	private Long answerTime;
 	
	/**
	 * 作答花费时间
	 */
 	private Long costTime;
 	
	/**
	 * 是否超过考试时间提交，1：超时提交，0：准时提交
	 */
 	private Integer submitLater;
 	
	/**
	 * 正确率
	 */
 	private String correctRate;
 	
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
 	
 	public String getAnswerSheetId() {
 		return answerSheetId;
 	}
 	
 	public void setAnswerSheetId(String answerSheetId) {
 		this.answerSheetId = answerSheetId;
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
 	
 	public String getSheetKey() {
 		return sheetKey;
 	}
 	
 	public void setSheetKey(String sheetKey) {
 		this.sheetKey = sheetKey;
 	}
 	
 	public String getCatagory() {
 		return catagory;
 	}
 	
 	public void setCatagory(String catagory) {
 		this.catagory = catagory;
 	}
 	
 	public String getOrigin() {
 		return origin;
 	}
 	
 	public void setOrigin(String origin) {
 		this.origin = origin;
 	}
 	
 	public String getExamNumber() {
 		return examNumber;
 	}
 	
 	public void setExamNumber(String examNumber) {
 		this.examNumber = examNumber;
 	}
 	
 	public Long getSeq() {
 		return seq;
 	}
 	
 	public void setSeq(Long seq) {
 		this.seq = seq;
 	}
 	
 	public String getCryptCode() {
 		return cryptCode;
 	}
 	
 	public void setCryptCode(String cryptCode) {
 		this.cryptCode = cryptCode;
 	}
 	
 	public Integer getAnalysisable() {
 		return analysisable;
 	}
 	
 	public void setAnalysisable(Integer analysisable) {
 		this.analysisable = analysisable;
 	}
 	
 	public Integer getScoredable() {
 		return scoredable;
 	}
 	
 	public void setScoredable(Integer scoredable) {
 		this.scoredable = scoredable;
 	}
 	
 	public Integer getMarkable() {
 		return markable;
 	}
 	
 	public void setMarkable(Integer markable) {
 		this.markable = markable;
 	}
 	
 	public BigDecimal getScore() {
 		return score;
 	}
 	
 	public void setScore(BigDecimal score) {
 		this.score = score;
 	}
 	
 	public BigDecimal getKgScore() {
 		return kgScore;
 	}
 	
 	public void setKgScore(BigDecimal kgScore) {
 		this.kgScore = kgScore;
 	}
 	
 	public BigDecimal getZgScore() {
 		return zgScore;
 	}
 	
 	public void setZgScore(BigDecimal zgScore) {
 		this.zgScore = zgScore;
 	}
 	
 	public Integer getAttended() {
 		return attended;
 	}
 	
 	public void setAttended(Integer attended) {
 		this.attended = attended;
 	}
 	
 	public Integer getCutSeq() {
 		return cutSeq;
 	}
 	
 	public void setCutSeq(Integer cutSeq) {
 		this.cutSeq = cutSeq;
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
 	
 	public Long getAnswerTime() {
 		return answerTime;
 	}
 	
 	public void setAnswerTime(Long answerTime) {
 		this.answerTime = answerTime;
 	}
 	
 	public Long getCostTime() {
 		return costTime;
 	}
 	
 	public void setCostTime(Long costTime) {
 		this.costTime = costTime;
 	}
 	
 	public Integer getSubmitLater() {
 		return submitLater;
 	}
 	
 	public void setSubmitLater(Integer submitLater) {
 		this.submitLater = submitLater;
 	}
 	
 	public String getCorrectRate() {
 		return correctRate;
 	}
 	
 	public void setCorrectRate(String correctRate) {
 		this.correctRate = correctRate;
 	}
 	
	@Override
	public String toString() {
		return "PsExamineeSheetVO :" + "，id=" + id  + "，sheetId=" + sheetId  + "，answerSheetId=" + answerSheetId  + "，examId=" + examId  + "，batchId=" + batchId  + "，sheetKey=" + sheetKey  + "，catagory=" + catagory  + "，origin=" + origin  + "，examNumber=" + examNumber  + "，seq=" + seq  + "，cryptCode=" + cryptCode  + "，analysisable=" + analysisable  + "，scoredable=" + scoredable  + "，markable=" + markable  + "，score=" + score  + "，kgScore=" + kgScore  + "，zgScore=" + zgScore  + "，attended=" + attended  + "，cutSeq=" + cutSeq  + "，fetchTime=" + fetchTime  + "，markerId=" + markerId  + "，markerName=" + markerName  + "，handleTime=" + handleTime  + "，doubt=" + doubt  + "，doubtDone=" + doubtDone  + "，isDel=" + isDel  + "，answerTime=" + answerTime  + "，costTime=" + costTime  + "，submitLater=" + submitLater  + "，correctRate=" + correctRate ;
	}

}