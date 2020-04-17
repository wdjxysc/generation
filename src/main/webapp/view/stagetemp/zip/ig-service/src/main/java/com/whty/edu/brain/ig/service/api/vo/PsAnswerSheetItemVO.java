package com.whty.edu.brain.ig.service.api.vo;
 
import java.math.BigDecimal;
import java.util.Date;
 
public class PsAnswerSheetItemVO {
 
	/**
	 * 
	 */
 	private Long id;
 	
	/**
	 * 答题卡题目唯一标识
	 */
 	private String answerSheetItemId;
 	
	/**
	 * 
	 */
 	private String parentItemId;
 	
	/**
	 * 考试唯一标识
	 */
 	private String examId;
 	
	/**
	 * 答题卡唯一标识
	 */
 	private String answerSheetId;
 	
	/**
	 * 库题题目唯一标识
	 */
 	private String originItemId;
 	
	/**
	 * 扫描端上传的序号
	 */
 	private String scanSeq;
 	
	/**
	 * 题目名称
	 */
 	private String name;
 	
	/**
	 * 题目一级类型：0-考号;1-客观题(KG);2-主观题(KG)
	 */
 	private Integer catagory1;
 	
	/**
	 * 题目二级类型：客观题（4-填空题, 5-解答题,6-英语作文,7-语文作文,8-选做题）
	 */
 	private Integer catagory2;
 	
	/**
	 * 满分
	 */
 	private BigDecimal score;
 	
	/**
	 * 是否必做:0-选做；1-必做
	 */
 	private Integer required;
 	
	/**
	 * 为选择题时，记录扫描段设置的答案个数
	 */
 	private Integer num;
 	
	/**
	 * 参考答案
	 */
 	private String content;
 	
	/**
	 * 答案类型：1-json;2-文本;3-url
	 */
 	private Integer stType;
 	
	/**
	 * 编辑状态：0-不可编辑;１-可编辑
	 */
 	private Integer readonly;
 	
	/**
	 * 答案组合规则：0系统默认，1自定义
	 */
 	private Integer rule;
 	
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
 	
	/**
	 * 知识点ID字符串
	 */
 	private String knowledgeId;
 	
	/**
	 * 知识点
	 */
 	private String knowledge;
 	
	/**
	 * 选做题题组编号
	 */
 	private String groups;
 	
	/**
	 * 科目Id
	 */
 	private String subjectId;
 	
 	public Long getId() {
 		return id;
 	}
 	
 	public void setId(Long id) {
 		this.id = id;
 	}
 	
 	public String getAnswerSheetItemId() {
 		return answerSheetItemId;
 	}
 	
 	public void setAnswerSheetItemId(String answerSheetItemId) {
 		this.answerSheetItemId = answerSheetItemId;
 	}
 	
 	public String getParentItemId() {
 		return parentItemId;
 	}
 	
 	public void setParentItemId(String parentItemId) {
 		this.parentItemId = parentItemId;
 	}
 	
 	public String getExamId() {
 		return examId;
 	}
 	
 	public void setExamId(String examId) {
 		this.examId = examId;
 	}
 	
 	public String getAnswerSheetId() {
 		return answerSheetId;
 	}
 	
 	public void setAnswerSheetId(String answerSheetId) {
 		this.answerSheetId = answerSheetId;
 	}
 	
 	public String getOriginItemId() {
 		return originItemId;
 	}
 	
 	public void setOriginItemId(String originItemId) {
 		this.originItemId = originItemId;
 	}
 	
 	public String getScanSeq() {
 		return scanSeq;
 	}
 	
 	public void setScanSeq(String scanSeq) {
 		this.scanSeq = scanSeq;
 	}
 	
 	public String getName() {
 		return name;
 	}
 	
 	public void setName(String name) {
 		this.name = name;
 	}
 	
 	public Integer getCatagory1() {
 		return catagory1;
 	}
 	
 	public void setCatagory1(Integer catagory1) {
 		this.catagory1 = catagory1;
 	}
 	
 	public Integer getCatagory2() {
 		return catagory2;
 	}
 	
 	public void setCatagory2(Integer catagory2) {
 		this.catagory2 = catagory2;
 	}
 	
 	public BigDecimal getScore() {
 		return score;
 	}
 	
 	public void setScore(BigDecimal score) {
 		this.score = score;
 	}
 	
 	public Integer getRequired() {
 		return required;
 	}
 	
 	public void setRequired(Integer required) {
 		this.required = required;
 	}
 	
 	public Integer getNum() {
 		return num;
 	}
 	
 	public void setNum(Integer num) {
 		this.num = num;
 	}
 	
 	public String getContent() {
 		return content;
 	}
 	
 	public void setContent(String content) {
 		this.content = content;
 	}
 	
 	public Integer getStType() {
 		return stType;
 	}
 	
 	public void setStType(Integer stType) {
 		this.stType = stType;
 	}
 	
 	public Integer getReadonly() {
 		return readonly;
 	}
 	
 	public void setReadonly(Integer readonly) {
 		this.readonly = readonly;
 	}
 	
 	public Integer getRule() {
 		return rule;
 	}
 	
 	public void setRule(Integer rule) {
 		this.rule = rule;
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
 	
 	public String getKnowledgeId() {
 		return knowledgeId;
 	}
 	
 	public void setKnowledgeId(String knowledgeId) {
 		this.knowledgeId = knowledgeId;
 	}
 	
 	public String getKnowledge() {
 		return knowledge;
 	}
 	
 	public void setKnowledge(String knowledge) {
 		this.knowledge = knowledge;
 	}
 	
 	public String getGroups() {
 		return groups;
 	}
 	
 	public void setGroups(String groups) {
 		this.groups = groups;
 	}
 	
 	public String getSubjectId() {
 		return subjectId;
 	}
 	
 	public void setSubjectId(String subjectId) {
 		this.subjectId = subjectId;
 	}
 	
	@Override
	public String toString() {
		return "PsAnswerSheetItemVO :" + "，id=" + id  + "，answerSheetItemId=" + answerSheetItemId  + "，parentItemId=" + parentItemId  + "，examId=" + examId  + "，answerSheetId=" + answerSheetId  + "，originItemId=" + originItemId  + "，scanSeq=" + scanSeq  + "，name=" + name  + "，catagory1=" + catagory1  + "，catagory2=" + catagory2  + "，score=" + score  + "，required=" + required  + "，num=" + num  + "，content=" + content  + "，stType=" + stType  + "，readonly=" + readonly  + "，rule=" + rule  + "，lastUpdateTime=" + lastUpdateTime  + "，lastOperatorId=" + lastOperatorId  + "，lastOperatorName=" + lastOperatorName  + "，isDel=" + isDel  + "，knowledgeId=" + knowledgeId  + "，knowledge=" + knowledge  + "，groups=" + groups  + "，subjectId=" + subjectId ;
	}

}