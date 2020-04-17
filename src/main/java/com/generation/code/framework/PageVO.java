package com.generation.code.framework;

/**
 * @ClassName:  PageVO   
 * @Description:TODO(分页信息基类)   
 * @author: 曾肖 
 * @date:   2019年5月30日 上午9:48:44   
 *     
 * @Copyright: 2019
 */
public class PageVO {
	/**
	 * 当前页码
	 */
	private Integer curPage;
	/**
	 * 数据总条数
	 */
	private Long total;
	/**
	 * 数据总页数
	 */
	private Integer totalPage;
	/**
	 * 数据每页多少条数据
	 */
	private Integer pageSize;
	public Integer getCurPage() {
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "PageVO [curPage=" + curPage + ", total=" + total + ", totalPage=" + totalPage + ", pageSize=" + pageSize
				+ "]";
	}
}
