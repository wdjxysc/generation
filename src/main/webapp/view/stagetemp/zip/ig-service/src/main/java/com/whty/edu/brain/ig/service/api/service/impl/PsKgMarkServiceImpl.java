package com.whty.edu.brain.ig.service.api.service.impl;

import com.whty.edu.brain.ig.service.api.vo.PsKgMarkVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.whty.edu.brain.ig.service.api.service.PsKgMarkService;
import com.whty.edu.brain.ig.service.api.dao.PsKgMarkDAO;

/**   
 * @formatClassName:  PsKgMarkServiceImpl   
 * @Description:TODO    
 * @author: generation
 * @date:   2020年04月17日 09:28:488
 * @Copyright: generation
 */
@Service
public class PsKgMarkServiceImpl implements PsKgMarkService{
	
	/**
	 *	DAO操作注入对象
	 */
	@Autowired
	private PsKgMarkDAO psKgMarkDAO;
	
	/**
	 * <p>Title: insertPsKgMark</p>   
	 * <p>Description: 新增</p>   
	 * @param psKgMark   
	 * @see com.whty.edu.brain.ig.service.api.service.PsKgMarkService#insertPsKgMark(com.whty.edu.brain.ig.service.api.vo.PsKgMarkVO)
	 */
	@Override
	public void insertPsKgMark(PsKgMarkVO psKgMark){
		psKgMarkDAO.insertPsKgMark(psKgMark);
	}
	
	/**
	 * <p>Title: deletePsKgMark</p>   
	 * <p>Description: 删除</p>   
	 * @param psKgMark   
	 * @see com.whty.edu.brain.ig.service.api.service.PsKgMarkService#deletePsKgMark(com.whty.edu.brain.ig.service.api.vo.PsKgMarkVO)
	 */
	@Override
	public void deletePsKgMark(PsKgMarkVO psKgMark){
		psKgMarkDAO.deletePsKgMark(psKgMark);
	}
	
	/**
	 * <p>Title: updatePsKgMark</p>   
	 * <p>Description: 更新</p>   
	 * @param psKgMark   
	 * @see com.whty.edu.brain.ig.service.api.service.PsKgMarkService#updatePsKgMark(com.whty.edu.brain.ig.service.api.vo.PsKgMarkVO)
	 */
	@Override
	public void updatePsKgMark(PsKgMarkVO psKgMark){
		psKgMarkDAO.updatePsKgMark(psKgMark);
	}
	
	/**
	 * <p>Title: listPsKgMark</p>   
	 * <p>Description: 列表查询</p>   
	 * @param psKgMark   
	 * @see com.whty.edu.brain.ig.service.api.service.PsKgMarkService#listPsKgMark(com.whty.edu.brain.ig.service.api.vo.PsKgMarkVO)
	 */
	@Override
	public List<PsKgMarkVO> listPsKgMark(PsKgMarkVO psKgMark){
		List<PsKgMarkVO> list = psKgMarkDAO.listPsKgMark(psKgMark);
		return list;
	}
}