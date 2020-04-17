package com.whty.edu.brain.ig.service.api.service.impl;

import com.whty.edu.brain.ig.service.api.vo.PsExamineeVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.whty.edu.brain.ig.service.api.service.PsExamineeService;
import com.whty.edu.brain.ig.service.api.dao.PsExamineeDAO;

/**   
 * @formatClassName:  PsExamineeServiceImpl   
 * @Description:TODO    
 * @author: generation
 * @date:   2020年04月17日 09:28:482
 * @Copyright: generation
 */
@Service
public class PsExamineeServiceImpl implements PsExamineeService{
	
	/**
	 *	DAO操作注入对象
	 */
	@Autowired
	private PsExamineeDAO psExamineeDAO;
	
	/**
	 * <p>Title: insertPsExaminee</p>   
	 * <p>Description: 新增</p>   
	 * @param psExaminee   
	 * @see com.whty.edu.brain.ig.service.api.service.PsExamineeService#insertPsExaminee(com.whty.edu.brain.ig.service.api.vo.PsExamineeVO)
	 */
	@Override
	public void insertPsExaminee(PsExamineeVO psExaminee){
		psExamineeDAO.insertPsExaminee(psExaminee);
	}
	
	/**
	 * <p>Title: deletePsExaminee</p>   
	 * <p>Description: 删除</p>   
	 * @param psExaminee   
	 * @see com.whty.edu.brain.ig.service.api.service.PsExamineeService#deletePsExaminee(com.whty.edu.brain.ig.service.api.vo.PsExamineeVO)
	 */
	@Override
	public void deletePsExaminee(PsExamineeVO psExaminee){
		psExamineeDAO.deletePsExaminee(psExaminee);
	}
	
	/**
	 * <p>Title: updatePsExaminee</p>   
	 * <p>Description: 更新</p>   
	 * @param psExaminee   
	 * @see com.whty.edu.brain.ig.service.api.service.PsExamineeService#updatePsExaminee(com.whty.edu.brain.ig.service.api.vo.PsExamineeVO)
	 */
	@Override
	public void updatePsExaminee(PsExamineeVO psExaminee){
		psExamineeDAO.updatePsExaminee(psExaminee);
	}
	
	/**
	 * <p>Title: listPsExaminee</p>   
	 * <p>Description: 列表查询</p>   
	 * @param psExaminee   
	 * @see com.whty.edu.brain.ig.service.api.service.PsExamineeService#listPsExaminee(com.whty.edu.brain.ig.service.api.vo.PsExamineeVO)
	 */
	@Override
	public List<PsExamineeVO> listPsExaminee(PsExamineeVO psExaminee){
		List<PsExamineeVO> list = psExamineeDAO.listPsExaminee(psExaminee);
		return list;
	}
}