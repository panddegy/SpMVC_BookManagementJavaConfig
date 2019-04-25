package com.biz.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.book.mapper.LoginMapper;
import com.biz.book.model.AdminVO;

@Service
public class LoginService {

	@Autowired
	LoginMapper loginMapper;
	
	public List<AdminVO> selectAllAdmin(){
		
		return loginMapper.selectAllAdmin();
	}
	
	public boolean findByAdminID(AdminVO adminVO) {
		
		AdminVO _tVO=loginMapper.findByAdminID(adminVO.getAdmin_id());
		
		if(_tVO==null) return false;
		
		if(adminVO.getAdmin_pass().equals(_tVO.getAdmin_pass())) return true;
		
		return false;
	}
	
	public int insertAdmin(AdminVO adminVO) {
		
		return loginMapper.insertAdmin(adminVO);
	}
	
	public int updateAdmin(AdminVO adminVO) {
		
		return loginMapper.updateAdmin(adminVO);
	}
	
	public int deleteAdmin(String admin_id) {
		
		return loginMapper.deleteAdmin(admin_id);
	}
}














