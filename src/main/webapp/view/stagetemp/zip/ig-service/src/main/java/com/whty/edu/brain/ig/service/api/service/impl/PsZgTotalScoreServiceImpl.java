package com.whty.edu.brain.ig.service.api.service.impl;

import com.whty.edu.brain.ig.service.api.vo.PsZgTotalScoreVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.whty.edu.brain.ig.service.api.service.PsZgTotalScoreService;
import com.whty.edu.brain.ig.service.api.dao.PsZgTotalScoreDAO;

/**   
 * @formatClassName:  PsZgTotalScoreServiceImpl   
 * @Description:TODO    
 * @author: generation
 * @date:   2020年04月17日 09:28:474
 * @Copyright: generation
 */
@Service
public class PsZgTotalScoreServiceImpl implements PsZgTotalScoreService{
	
	/**
	 *	DAO操作注入对象
	 */
	@Autowired
	private PsZgTotalScoreDAO psZgTotalScoreDAO;
	
	/**
	 * <p>Title: insertPsZgTotalScore</p>   
	 * <p>Description: 新增</p>   
	 * @param psZgTotalScore   
	 * @see com.whty.edu.brain.ig.service.api.service.PsZgTotalScoreService#insertPsZgTotalScore(com.whty.edu.brain.ig.service.api.vo.PsZgTotalScoreVO)
	 */
	@Override
	public void insertPsZgTotalScore(PsZgTotalScoreVO psZgTotalScore){
		psZgTotalScoreDAO.insertPsZgTotalScore(psZgTotalScore);
	}
	
	/**
	 * <p>Title: deletePsZgTotalScore</p>   
	 * <p>Description: 删除</p>   
	 * @param psZgTotalScore   
	 * @see com.whty.edu.brain.ig.service.api.service.PsZgTotalScoreService#deletePsZgTotalScore(com.whty.edu.brain.ig.service.api.vo.PsZgTotalScoreVO)
	 */
	@Override
	public void deletePsZgTotalScore(PsZgTotalScoreVO psZgTotalScore){
		psZgTotalScoreDAO.deletePsZgTotalScore(psZgTotalScore);
	}
	
	/**
	 * <p>Title: updatePsZgTotalScore</p>   
	 * <p>Description: 更新</p>   
	 * @param psZgTotalScore   
	 * @see com.whty.edu.brain.ig.service.api.service.PsZgTotalScoreService#updatePsZgTotalScore(com.whty.edu.brain.ig.service.api.vo.PsZgTotalScoreVO)
	 */
	@Override
	public void updatePsZgTotalScore(PsZgTotalScoreVO psZgTotalScore){
		psZgTotalScoreDAO.updatePsZgTotalScore(psZgTotalScore);
	}
	
	/**
	 * <p>Title: listPsZgTotalScore</p>   
	 * <p>Description: 列表查询</p>   
	 * @param psZgTotalScore   
	 * @see com.whty.edu.brain.ig.service.api.service.PsZgTotalScoreService#listPsZgTotalScore(com.whty.edu.brain.ig.service.api.vo.PsZgTotalScoreVO)
	 */
	@Override
	public List<PsZgTotalScoreVO> listPsZgTotalScore(PsZgTotalScoreVO psZgTotalScore){
		List<PsZgTotalScoreVO> list = psZgTotalScoreDAO.listPsZgTotalScore(psZgTotalScore);
		return list;
	}
}