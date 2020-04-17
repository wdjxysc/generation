package com.whty.edu.brain.ig.service.api.dao;
import com.whty.edu.brain.ig.service.api.vo.PsExamineeVO;
import java.util.List;
/**   
 * @formatClassName:  PsExamineeDAO   
 * @Description:TODO(持久层接口)   
 * @author: generation
 * @date:   2020年04月17日 09:28:481
 * @Copyright: generation
 */
public interface PsExamineeDAO {
	/**
	 * @Title: insertPsExaminee
	 * @Description:新增
	 * @author: generation
	 * @date:   2020年04月17日 09:28:481
	 * @param psExaminee 新增内容
	 */
	void insertPsExaminee(PsExamineeVO psExaminee);
	
	/**
	 * @Title: deletePsExaminee
	 * @Description:删除
	 * @author: generation
	 * @date:   2020年04月17日 09:28:481
	 * @param psExaminee 删除对象条件
	 */
	void deletePsExaminee(PsExamineeVO psExaminee);
	
	/**
	 * @Title: updatePsExaminee
	 * @Description:更新
	 * @author: generation
	 * @date:   2020年04月17日 09:28:482
	 * @param psExaminee 更新条件及目标对象标识
	 */
	void updatePsExaminee(PsExamineeVO psExaminee);
	
	/**
	 * @Title: listPsExaminee
	 * @Description:查询列表
	 * @author: generation
	 * @date:   2020年04月17日 09:28:482
	 * @param psExaminee 查询条件
	 * @return List<PsExamineeVO> 返回结果
	 */
	List<PsExamineeVO> listPsExaminee(PsExamineeVO psExaminee);
}
