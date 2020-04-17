package com.whty.edu.brain.ig.service.api.service.impl;

import com.whty.edu.brain.ig.service.api.vo.PsSubjectScoreVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.whty.edu.brain.ig.service.api.service.PsSubjectScoreService;
import com.whty.edu.brain.ig.service.api.dao.PsSubjectScoreDAO;

/**   
 * @formatClassName:  PsSubjectScoreServiceImpl   
 * @Description:TODO    
 * @author: generation
 * @date:   2020年04月17日 09:28:485
 * @Copyright: generation
 */
@Service
public class PsSubjectScoreServiceImpl implements PsSubjectScoreService{
	
	/**
	 *	DAO操作注入对象
	 */
	@Autowired
	private PsSubjectScoreDAO psSubjectScoreDAO;
	
	/**
	 * <p>Title: insertPsSubjectScore</p>   
	 * <p>Description: 新增</p>   
	 * @param psSubjectScore   
	 * @see com.whty.edu.brain.ig.service.api.service.PsSubjectScoreService#insertPsSubjectScore(com.whty.edu.brain.ig.service.api.vo.PsSubjectScoreVO)
	 */
	@Override
	public void insertPsSubjectScore(PsSubjectScoreVO psSubjectScore){
		psSubjectScoreDAO.insertPsSubjectScore(psSubjectScore);
	}
	
	/**
	 * <p>Title: deletePsSubjectScore</p>   
	 * <p>Description: 删除</p>   
	 * @param psSubjectScore   
	 * @see com.whty.edu.brain.ig.service.api.service.PsSubjectScoreService#deletePsSubjectScore(com.whty.edu.brain.ig.service.api.vo.PsSubjectScoreVO)
	 */
	@Override
	public void deletePsSubjectScore(PsSubjectScoreVO psSubjectScore){
		psSubjectScoreDAO.deletePsSubjectScore(psSubjectScore);
	}
	
	/**
	 * <p>Title: updatePsSubjectScore</p>   
	 * <p>Description: 更新</p>   
	 * @param psSubjectScore   
	 * @see com.whty.edu.brain.ig.service.api.service.PsSubjectScoreService#updatePsSubjectScore(com.whty.edu.brain.ig.service.api.vo.PsSubjectScoreVO)
	 */
	@Override
	public void updatePsSubjectScore(PsSubjectScoreVO psSubjectScore){
		psSubjectScoreDAO.updatePsSubjectScore(psSubjectScore);
	}
	
	/**
	 * <p>Title: listPsSubjectScore</p>   
	 * <p>Description: 列表查询</p>   
	 * @param psSubjectScore   
	 * @see com.whty.edu.brain.ig.service.api.service.PsSubjectScoreService#listPsSubjectScore(com.whty.edu.brain.ig.service.api.vo.PsSubjectScoreVO)
	 */
	@Override
	public List<PsSubjectScoreVO> listPsSubjectScore(PsSubjectScoreVO psSubjectScore){
		List<PsSubjectScoreVO> list = psSubjectScoreDAO.listPsSubjectScore(psSubjectScore);
		return list;
	}
}