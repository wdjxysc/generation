package com.whty.edu.brain.ig.service.api.service.impl;

import com.whty.edu.brain.ig.service.api.vo.PsOnlineSubmitVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.whty.edu.brain.ig.service.api.service.PsOnlineSubmitService;
import com.whty.edu.brain.ig.service.api.dao.PsOnlineSubmitDAO;

/**   
 * @formatClassName:  PsOnlineSubmitServiceImpl   
 * @Description:TODO    
 * @author: generation
 * @date:   2020年04月17日 09:28:457
 * @Copyright: generation
 */
@Service
public class PsOnlineSubmitServiceImpl implements PsOnlineSubmitService{
	
	/**
	 *	DAO操作注入对象
	 */
	@Autowired
	private PsOnlineSubmitDAO psOnlineSubmitDAO;
	
	/**
	 * <p>Title: insertPsOnlineSubmit</p>   
	 * <p>Description: 新增</p>   
	 * @param psOnlineSubmit   
	 * @see com.whty.edu.brain.ig.service.api.service.PsOnlineSubmitService#insertPsOnlineSubmit(com.whty.edu.brain.ig.service.api.vo.PsOnlineSubmitVO)
	 */
	@Override
	public void insertPsOnlineSubmit(PsOnlineSubmitVO psOnlineSubmit){
		psOnlineSubmitDAO.insertPsOnlineSubmit(psOnlineSubmit);
	}
	
	/**
	 * <p>Title: deletePsOnlineSubmit</p>   
	 * <p>Description: 删除</p>   
	 * @param psOnlineSubmit   
	 * @see com.whty.edu.brain.ig.service.api.service.PsOnlineSubmitService#deletePsOnlineSubmit(com.whty.edu.brain.ig.service.api.vo.PsOnlineSubmitVO)
	 */
	@Override
	public void deletePsOnlineSubmit(PsOnlineSubmitVO psOnlineSubmit){
		psOnlineSubmitDAO.deletePsOnlineSubmit(psOnlineSubmit);
	}
	
	/**
	 * <p>Title: updatePsOnlineSubmit</p>   
	 * <p>Description: 更新</p>   
	 * @param psOnlineSubmit   
	 * @see com.whty.edu.brain.ig.service.api.service.PsOnlineSubmitService#updatePsOnlineSubmit(com.whty.edu.brain.ig.service.api.vo.PsOnlineSubmitVO)
	 */
	@Override
	public void updatePsOnlineSubmit(PsOnlineSubmitVO psOnlineSubmit){
		psOnlineSubmitDAO.updatePsOnlineSubmit(psOnlineSubmit);
	}
	
	/**
	 * <p>Title: listPsOnlineSubmit</p>   
	 * <p>Description: 列表查询</p>   
	 * @param psOnlineSubmit   
	 * @see com.whty.edu.brain.ig.service.api.service.PsOnlineSubmitService#listPsOnlineSubmit(com.whty.edu.brain.ig.service.api.vo.PsOnlineSubmitVO)
	 */
	@Override
	public List<PsOnlineSubmitVO> listPsOnlineSubmit(PsOnlineSubmitVO psOnlineSubmit){
		List<PsOnlineSubmitVO> list = psOnlineSubmitDAO.listPsOnlineSubmit(psOnlineSubmit);
		return list;
	}
}