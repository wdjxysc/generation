package com.whty.edu.brain.ig.service.api.service.impl;

import com.whty.edu.brain.ig.service.api.vo.PsScoringMarkVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.whty.edu.brain.ig.service.api.service.PsScoringMarkService;
import com.whty.edu.brain.ig.service.api.dao.PsScoringMarkDAO;

/**   
 * @formatClassName:  PsScoringMarkServiceImpl   
 * @Description:TODO    
 * @author: generation
 * @date:   2020年04月17日 09:28:452
 * @Copyright: generation
 */
@Service
public class PsScoringMarkServiceImpl implements PsScoringMarkService{
	
	/**
	 *	DAO操作注入对象
	 */
	@Autowired
	private PsScoringMarkDAO psScoringMarkDAO;
	
	/**
	 * <p>Title: insertPsScoringMark</p>   
	 * <p>Description: 新增</p>   
	 * @param psScoringMark   
	 * @see com.whty.edu.brain.ig.service.api.service.PsScoringMarkService#insertPsScoringMark(com.whty.edu.brain.ig.service.api.vo.PsScoringMarkVO)
	 */
	@Override
	public void insertPsScoringMark(PsScoringMarkVO psScoringMark){
		psScoringMarkDAO.insertPsScoringMark(psScoringMark);
	}
	
	/**
	 * <p>Title: deletePsScoringMark</p>   
	 * <p>Description: 删除</p>   
	 * @param psScoringMark   
	 * @see com.whty.edu.brain.ig.service.api.service.PsScoringMarkService#deletePsScoringMark(com.whty.edu.brain.ig.service.api.vo.PsScoringMarkVO)
	 */
	@Override
	public void deletePsScoringMark(PsScoringMarkVO psScoringMark){
		psScoringMarkDAO.deletePsScoringMark(psScoringMark);
	}
	
	/**
	 * <p>Title: updatePsScoringMark</p>   
	 * <p>Description: 更新</p>   
	 * @param psScoringMark   
	 * @see com.whty.edu.brain.ig.service.api.service.PsScoringMarkService#updatePsScoringMark(com.whty.edu.brain.ig.service.api.vo.PsScoringMarkVO)
	 */
	@Override
	public void updatePsScoringMark(PsScoringMarkVO psScoringMark){
		psScoringMarkDAO.updatePsScoringMark(psScoringMark);
	}
	
	/**
	 * <p>Title: listPsScoringMark</p>   
	 * <p>Description: 列表查询</p>   
	 * @param psScoringMark   
	 * @see com.whty.edu.brain.ig.service.api.service.PsScoringMarkService#listPsScoringMark(com.whty.edu.brain.ig.service.api.vo.PsScoringMarkVO)
	 */
	@Override
	public List<PsScoringMarkVO> listPsScoringMark(PsScoringMarkVO psScoringMark){
		List<PsScoringMarkVO> list = psScoringMarkDAO.listPsScoringMark(psScoringMark);
		return list;
	}
}