package com.biz.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.biz.book.model.AdminVO;

public interface LoginMapper {

	@Select(" select * from tbl_admin ")
	public List<AdminVO> selectAllAdmin();
	
	@Select(" select * from tbl_admin where admin_id=#{admin_id} ")
	public AdminVO findByAdminID(String admin_id);
	
	@Insert(" insert into tbl_admin(admin_id, admin_pass) values(#{admin_id}, #{admin_pass}) ")
	public int insertAdmin(AdminVO adminVO);
	
	@Update(" update tbl_admin set admin_pass=#{admin_pass} where admin_id=#{admin_id} ")
	public int updateAdmin(AdminVO adminVO);
	
	@Delete(" delete from tbl_admin where admin_id=#{admin_id} ")
	public int deleteAdmin(String admin_id);
	
	
}
