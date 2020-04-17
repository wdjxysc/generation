package com.whty.edu.brain.ig.service.api.service.impl;

import com.whty.edu.brain.ig.service.api.vo.PsExamineeSheetVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.whty.edu.brain.ig.service.api.service.PsExamineeSheetService;
import com.whty.edu.brain.ig.service.api.dao.PsExamineeSheetDAO;

/**   
 * @formatClassName:  PsExamineeSheetServiceImpl   
 * @Description:TODO    
 * @author: generation
 * @date:   2020年04月17日 09:28:467
 * @Copyright: generation
 */
@Service
public class PsExamineeSheetServiceImpl implements PsExamineeSheetService{
	
	/**
	 *	DAO操作注入对象
	 */
	@Autowired
	private PsExamineeSheetDAO psExamineeSheetDAO;
	
	/**
	 * <p>Title: insertPsExamineeSheet</p>   
	 * <p>Description: 新增</p>   
	 * @param psExamineeSheet   
	 * @see com.whty.edu.brain.ig.service.api.service.PsExamineeSheetService#insertPsExamineeSheet(com.whty.edu.brain.ig.service.api.vo.PsExamineeSheetVO)
	 */
	@Override
	public void insertPsExamineeSheet(PsExamineeSheetVO psExamineeSheet){
		psExamineeSheetDAO.insertPsExamineeSheet(psExamineeSheet);
	}
	
	/**
	 * <p>Title: deletePsExamineeSheet</p>   
	 * <p>Description: 删除</p>   
	 * @param psExamineeSheet   
	 * @see com.whty.edu.brain.ig.service.api.service.PsExamineeSheetService#deletePsExamineeSheet(com.whty.edu.brain.ig.service.api.vo.PsExamineeSheetVO)
	 */
	@Override
	public void deletePsExamineeSheet(PsExamineeSheetVO psExamineeSheet){
		psExamineeSheetDAO.deletePsExamineeSheet(psExamineeSheet);
	}
	
	/**
	 * <p>Title: updatePsExamineeSheet</p>   
	 * <p>Description: 更新</p>   
	 * @param psExamineeSheet   
	 * @see com.whty.edu.brain.ig.service.api.service.PsExamineeSheetService#updatePsExamineeSheet(com.whty.edu.brain.ig.service.api.vo.PsExamineeSheetVO)
	 */
	@Override
	public void updatePsExamineeSheet(PsExamineeSheetVO psExamineeSheet){
		psExamineeSheetDAO.updatePsExamineeSheet(psExamineeSheet);
	}
	
	/**
	 * <p>Title: listPsExamineeSheet</p>   
	 * <p>Description: 列表查询</p>   
	 * @param psExamineeSheet   
	 * @see com.whty.edu.brain.ig.service.api.service.PsExamineeSheetService#listPsExamineeSheet(com.whty.edu.brain.ig.service.api.vo.PsExamineeSheetVO)
	 */
	@Override
	public List<PsExamineeSheetVO> listPsExamineeSheet(PsExamineeSheetVO psExamineeSheet){
		List<PsExamineeSheetVO> list = psExamineeSheetDAO.listPsExamineeSheet(psExamineeSheet);
		return list;
	}
}