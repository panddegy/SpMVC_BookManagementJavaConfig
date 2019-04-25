package com.biz.book.model;

import org.apache.ibatis.jdbc.SQL;

public class BookSQL {
/*
	create table tbl_book(
	    book_seq number primary key,
	    book_isbn char(13) not null,
	    book_title nvarchar2(100) not null,
	    book_author nvarchar2(30),
	    book_price number,
	    book_description nvarchar2(1000),
	    book_image nvarchar2(125),
	    book_link nvarchar2(255),
	    book_rent_yn char(1) default 'y'
	    constraint check_rent check(book_rent_yn in('y','n'))
	);
*/
	public String insertBookSQL() {
		
		SQL sql=new SQL().INSERT_INTO("tbl_book")
				.VALUES("book_seq", "book_seq.nextval")
				.VALUES("book_isbn", "#{book_isbn,jdbcType=CHAR}")
				.VALUES("book_title", "#{book_title,jdbcType=NVARCHAR}")
				.VALUES("book_author", "#{book_author,jdbcType=NVARCHAR}")
				.VALUES("book_price", "#{book_price}")
				.VALUES("book_description", "#{book_description,jdbcType=NVARCHAR}")
				.VALUES("book_image", "#{book_image,jdbcType=NVARCHAR}")
				.VALUES("book_rent_yn", "#{book_rent_yn,jdbcType=CHAR}");
		
		return sql.toString();
	}
	
	public String updateBookSQL() {
		
		SQL sql=new SQL().UPDATE("tbl_book")
				.SET("book_isbn=#{book_isbn,jdbcType=CHAR}")
				.SET("book_title=#{book_title,jdbcType=NVARCHAR}")
				.SET("book_author=#{book_author,jdbcType=NVARCHAR}")
				.SET("book_price=#{book_price}")
				.SET("book_description=#{book_description,jdbcType=NVARCHAR}")
				.SET("book_image=#{book_image,jdbcType=NVARCHAR}")
				.SET("book_rent_yn=#{book_rent_yn,jdbcType=CHAR}")
				.WHERE("book_seq=#{book_seq}");
		
		return sql.toString();
				
	}
	
}






















