package com.whty.edu.brain.ig.service.api.service.impl;

import com.whty.edu.brain.ig.service.api.vo.PsMarkerVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.whty.edu.brain.ig.service.api.service.PsMarkerService;
import com.whty.edu.brain.ig.service.api.dao.PsMarkerDAO;

/**   
 * @formatClassName:  PsMarkerServiceImpl   
 * @Description:TODO    
 * @author: generation
 * @date:   2020年04月17日 09:28:461
 * @Copyright: generation
 */
@Service
public class PsMarkerServiceImpl implements PsMarkerService{
	
	/**
	 *	DAO操作注入对象
	 */
	@Autowired
	private PsMarkerDAO psMarkerDAO;
	
	/**
	 * <p>Title: insertPsMarker</p>   
	 * <p>Description: 新增</p>   
	 * @param psMarker   
	 * @see com.whty.edu.brain.ig.service.api.service.PsMarkerService#insertPsMarker(com.whty.edu.brain.ig.service.api.vo.PsMarkerVO)
	 */
	@Override
	public void insertPsMarker(PsMarkerVO psMarker){
		psMarkerDAO.insertPsMarker(psMarker);
	}
	
	/**
	 * <p>Title: deletePsMarker</p>   
	 * <p>Description: 删除</p>   
	 * @param psMarker   
	 * @see com.whty.edu.brain.ig.service.api.service.PsMarkerService#deletePsMarker(com.whty.edu.brain.ig.service.api.vo.PsMarkerVO)
	 */
	@Override
	public void deletePsMarker(PsMarkerVO psMarker){
		psMarkerDAO.deletePsMarker(psMarker);
	}
	
	/**
	 * <p>Title: updatePsMarker</p>   
	 * <p>Description: 更新</p>   
	 * @param psMarker   
	 * @see com.whty.edu.brain.ig.service.api.service.PsMarkerService#updatePsMarker(com.whty.edu.brain.ig.service.api.vo.PsMarkerVO)
	 */
	@Override
	public void updatePsMarker(PsMarkerVO psMarker){
		psMarkerDAO.updatePsMarker(psMarker);
	}
	
	/**
	 * <p>Title: listPsMarker</p>   
	 * <p>Description: 列表查询</p>   
	 * @param psMarker   
	 * @see com.whty.edu.brain.ig.service.api.service.PsMarkerService#listPsMarker(com.whty.edu.brain.ig.service.api.vo.PsMarkerVO)
	 */
	@Override
	public List<PsMarkerVO> listPsMarker(PsMarkerVO psMarker){
		List<PsMarkerVO> list = psMarkerDAO.listPsMarker(psMarker);
		return list;
	}
}