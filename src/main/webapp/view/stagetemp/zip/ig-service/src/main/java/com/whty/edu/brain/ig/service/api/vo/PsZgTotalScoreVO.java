package com.whty.edu.brain.ig.service.api.vo;
 
import java.math.BigDecimal;
 
public class PsZgTotalScoreVO {
 
	/**
	 * 
	 */
 	private Long id;
 	
	/**
	 * 
	 */
 	private String examId;
 	
	/**
	 * 
	 */
 	private String subjectId;
 	
	/**
	 * 密号
	 */
 	private String cryptCode;
 	
	/**
	 * 主观题总分
	 */
 	private BigDecimal score;
 	
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
 	
	@Override
	public String toString() {
		return "PsZgTotalScoreVO :" + "，id=" + id  + "，examId=" + examId  + "，subjectId=" + subjectId  + "，cryptCode=" + cryptCode  + "，score=" + score ;
	}

}