package com.biz.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.book.model.RentSQL;
import com.biz.book.model.RentVO;

public interface RentMapper {

	@Select(" select * from tbl_rent order by rent_date desc ")
	public List<RentVO> selectAllRents();
	
	@Select(" select * from tbl_rent where rent_return_yn='n' order by rent_date desc ")
	public List<RentVO> selectAllReturns();
	
	@Select(" select * from tbl_rent where rent_date >= #{rent_date} order by rent_date desc ")
	public List<RentVO> findByRentDate(String rent_date);
	
	@Select(" select * from tbl_rent where rent_seq=#{rent_seq} ")
	public RentVO findByRentID(long rent_seq);
	
	@InsertProvider(type=RentSQL.class, method="insertRentSQL")
	public int insertRent(RentVO rentVO);
	
	@UpdateProvider(type=RentSQL.class, method="updateRentSQL")
	public int updateRent(RentVO rentVO);
	
	@Delete(" delete from tbl_rent where rent_seq=#{rent_seq} ")
	public int deleteRent(long rent_seq);

	@Select(" select * from tbl_rent where book_seq=#{book_seq} and rent_return_yn='n' ")
	public RentVO findByRentBookSeq(long book_seq);
	
	
}
