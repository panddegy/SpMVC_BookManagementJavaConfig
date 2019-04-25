package com.biz.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.book.model.UserSQL;
import com.biz.book.model.UserVO;

public interface UserMapper {

	@Select(" select * from tbl_user order by user_reg_date desc")
	public List<UserVO> selectAllUsers();
	
	@Select(" select * from tbl_user where user_name like #{user_name} ")
	public List<UserVO> findByUserName(String user_name);
	
	@Select(" select * from tbl_user where user_seq=#{user_seq} ")
	public UserVO findByUserID(long user_seq);
	
	@Select(" select * from tbl_user where user_phone like #{user_phone}")
	public List<UserVO> findByUserPhone(String user_phone);
	
	@InsertProvider(type=UserSQL.class, method="insertUserSQL")
	public int insertUser(UserVO userVO);
	
	@UpdateProvider(type=UserSQL.class, method="updateUserSQL")
	public int updateUser(UserVO userVO);
	
	@Delete(" delete from tbl_user where user_seq=#{user_seq} ")
	public int deleteUser(long user_seq);

}








