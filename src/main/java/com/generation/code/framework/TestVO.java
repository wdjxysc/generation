/**  
 * @Title:  TestVO.java   
 * @Package com.generation.code.framework   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 曾肖
 * @date:   2019年8月8日 下午7:04:37   
 * @version V1.0 
 * @Copyright: 2019
 */
package com.generation.code.framework;

import java.io.Serializable;

/**   
 * @ClassName:  TestVO   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 曾肖 
 * @date:   2019年8月8日 下午7:04:37   
 *     
 * @Copyright: 2019
 */
public class TestVO implements Serializable {

	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */
	private static final long serialVersionUID = -2472765604232920191L;

	private String p1;
	
	private String p2;
	
	private String p3;

	public String getP1() {
		return p1;
	}

	public void setP1(String p1) {
		this.p1 = p1;
	}

	public String getP2() {
		return p2;
	}

	public void setP2(String p2) {
		this.p2 = p2;
	}

	public String getP3() {
		return p3;
	}

	public void setP3(String p3) {
		this.p3 = p3;
	}
}
