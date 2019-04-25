package com.biz.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.book.model.BookSQL;
import com.biz.book.model.BookVO;

public interface BookMapper {

	@Select(" select * from tbl_book order by book_title desc ")
	public List<BookVO> selectAllBooks();
	
	@Select(" select * from tbl_book where book_rent_yn='y' order by book_title desc ")
	public List<BookVO> selectAllRentableBooks();
	
	@Select(" select * from tbl_book where book_title like #{book_title} ")
	public List<BookVO> findByBookTitle(String book_title);
	
	@Select(" select * from tbl_book where book_seq=#{book_seq} ")
	public BookVO findByBookID(long book_seq);
	
	@Select(" select * from tbl_book where book_isbn=#{book_isbn,jdbcType=CHAR} ")
	public BookVO findByBookISBN(String book_isbn);
	
	@InsertProvider(type=BookSQL.class, method="insertBookSQL")
	public int insertBook(BookVO bookVO);
	
	@UpdateProvider(type=BookSQL.class, method="updateBookSQL")
	public int updateBook(BookVO bookVO);
	
	@Delete(" delete from tbl_book where book_seq=#{book_seq} ")
	public int deleteBook(long book_seq);
	
	
}
