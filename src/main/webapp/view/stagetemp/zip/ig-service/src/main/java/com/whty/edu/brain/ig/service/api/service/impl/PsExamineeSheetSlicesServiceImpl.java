package com.whty.edu.brain.ig.service.api.service.impl;

import com.whty.edu.brain.ig.service.api.vo.PsExamineeSheetSlicesVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.whty.edu.brain.ig.service.api.service.PsExamineeSheetSlicesService;
import com.whty.edu.brain.ig.service.api.dao.PsExamineeSheetSlicesDAO;

/**   
 * @formatClassName:  PsExamineeSheetSlicesServiceImpl   
 * @Description:TODO    
 * @author: generation
 * @date:   2020年04月17日 09:28:479
 * @Copyright: generation
 */
@Service
public class PsExamineeSheetSlicesServiceImpl implements PsExamineeSheetSlicesService{
	
	/**
	 *	DAO操作注入对象
	 */
	@Autowired
	private PsExamineeSheetSlicesDAO psExamineeSheetSlicesDAO;
	
	/**
	 * <p>Title: insertPsExamineeSheetSlices</p>   
	 * <p>Description: 新增</p>   
	 * @param psExamineeSheetSlices   
	 * @see com.whty.edu.brain.ig.service.api.service.PsExamineeSheetSlicesService#insertPsExamineeSheetSlices(com.whty.edu.brain.ig.service.api.vo.PsExamineeSheetSlicesVO)
	 */
	@Override
	public void insertPsExamineeSheetSlices(PsExamineeSheetSlicesVO psExamineeSheetSlices){
		psExamineeSheetSlicesDAO.insertPsExamineeSheetSlices(psExamineeSheetSlices);
	}
	
	/**
	 * <p>Title: deletePsExamineeSheetSlices</p>   
	 * <p>Description: 删除</p>   
	 * @param psExamineeSheetSlices   
	 * @see com.whty.edu.brain.ig.service.api.service.PsExamineeSheetSlicesService#deletePsExamineeSheetSlices(com.whty.edu.brain.ig.service.api.vo.PsExamineeSheetSlicesVO)
	 */
	@Override
	public void deletePsExamineeSheetSlices(PsExamineeSheetSlicesVO psExamineeSheetSlices){
		psExamineeSheetSlicesDAO.deletePsExamineeSheetSlices(psExamineeSheetSlices);
	}
	
	/**
	 * <p>Title: updatePsExamineeSheetSlices</p>   
	 * <p>Description: 更新</p>   
	 * @param psExamineeSheetSlices   
	 * @see com.whty.edu.brain.ig.service.api.service.PsExamineeSheetSlicesService#updatePsExamineeSheetSlices(com.whty.edu.brain.ig.service.api.vo.PsExamineeSheetSlicesVO)
	 */
	@Override
	public void updatePsExamineeSheetSlices(PsExamineeSheetSlicesVO psExamineeSheetSlices){
		psExamineeSheetSlicesDAO.updatePsExamineeSheetSlices(psExamineeSheetSlices);
	}
	
	/**
	 * <p>Title: listPsExamineeSheetSlices</p>   
	 * <p>Description: 列表查询</p>   
	 * @param psExamineeSheetSlices   
	 * @see com.whty.edu.brain.ig.service.api.service.PsExamineeSheetSlicesService#listPsExamineeSheetSlices(com.whty.edu.brain.ig.service.api.vo.PsExamineeSheetSlicesVO)
	 */
	@Override
	public List<PsExamineeSheetSlicesVO> listPsExamineeSheetSlices(PsExamineeSheetSlicesVO psExamineeSheetSlices){
		List<PsExamineeSheetSlicesVO> list = psExamineeSheetSlicesDAO.listPsExamineeSheetSlices(psExamineeSheetSlices);
		return list;
	}
}