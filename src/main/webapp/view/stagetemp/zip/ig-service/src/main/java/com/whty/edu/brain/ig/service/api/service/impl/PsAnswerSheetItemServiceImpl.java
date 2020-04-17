package com.whty.edu.brain.ig.service.api.service.impl;

import com.whty.edu.brain.ig.service.api.vo.PsAnswerSheetItemVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.whty.edu.brain.ig.service.api.service.PsAnswerSheetItemService;
import com.whty.edu.brain.ig.service.api.dao.PsAnswerSheetItemDAO;

/**   
 * @formatClassName:  PsAnswerSheetItemServiceImpl   
 * @Description:TODO    
 * @author: generation
 * @date:   2020年04月17日 09:28:471
 * @Copyright: generation
 */
@Service
public class PsAnswerSheetItemServiceImpl implements PsAnswerSheetItemService{
	
	/**
	 *	DAO操作注入对象
	 */
	@Autowired
	private PsAnswerSheetItemDAO psAnswerSheetItemDAO;
	
	/**
	 * <p>Title: insertPsAnswerSheetItem</p>   
	 * <p>Description: 新增</p>   
	 * @param psAnswerSheetItem   
	 * @see com.whty.edu.brain.ig.service.api.service.PsAnswerSheetItemService#insertPsAnswerSheetItem(com.whty.edu.brain.ig.service.api.vo.PsAnswerSheetItemVO)
	 */
	@Override
	public void insertPsAnswerSheetItem(PsAnswerSheetItemVO psAnswerSheetItem){
		psAnswerSheetItemDAO.insertPsAnswerSheetItem(psAnswerSheetItem);
	}
	
	/**
	 * <p>Title: deletePsAnswerSheetItem</p>   
	 * <p>Description: 删除</p>   
	 * @param psAnswerSheetItem   
	 * @see com.whty.edu.brain.ig.service.api.service.PsAnswerSheetItemService#deletePsAnswerSheetItem(com.whty.edu.brain.ig.service.api.vo.PsAnswerSheetItemVO)
	 */
	@Override
	public void deletePsAnswerSheetItem(PsAnswerSheetItemVO psAnswerSheetItem){
		psAnswerSheetItemDAO.deletePsAnswerSheetItem(psAnswerSheetItem);
	}
	
	/**
	 * <p>Title: updatePsAnswerSheetItem</p>   
	 * <p>Description: 更新</p>   
	 * @param psAnswerSheetItem   
	 * @see com.whty.edu.brain.ig.service.api.service.PsAnswerSheetItemService#updatePsAnswerSheetItem(com.whty.edu.brain.ig.service.api.vo.PsAnswerSheetItemVO)
	 */
	@Override
	public void updatePsAnswerSheetItem(PsAnswerSheetItemVO psAnswerSheetItem){
		psAnswerSheetItemDAO.updatePsAnswerSheetItem(psAnswerSheetItem);
	}
	
	/**
	 * <p>Title: listPsAnswerSheetItem</p>   
	 * <p>Description: 列表查询</p>   
	 * @param psAnswerSheetItem   
	 * @see com.whty.edu.brain.ig.service.api.service.PsAnswerSheetItemService#listPsAnswerSheetItem(com.whty.edu.brain.ig.service.api.vo.PsAnswerSheetItemVO)
	 */
	@Override
	public List<PsAnswerSheetItemVO> listPsAnswerSheetItem(PsAnswerSheetItemVO psAnswerSheetItem){
		List<PsAnswerSheetItemVO> list = psAnswerSheetItemDAO.listPsAnswerSheetItem(psAnswerSheetItem);
		return list;
	}
}