package com.biz.book.model;

import org.apache.ibatis.jdbc.SQL;

public class RentSQL {
/*
	create table tbl_rent(
	    rent_seq number primary key,
	    rent_date char(10) not null,
	    rent_return_date char(10),
	    rent_book_seq number,
	    rent_user_seq number,
	    rent_return_yn char(1) default 'n'
	    constraint check_return check(rent_return_yn in('y','n'))
	);
*/
	public String insertRentSQL() {
		
		SQL sql=new SQL().INSERT_INTO("tbl_rent")
				.VALUES("rent_seq", "rent_seq.nextval")
				.VALUES("rent_date", "#{rent_date}")
				.VALUES("rent_return_date", "#{rent_return_date}")
				.VALUES("rent_book_seq", "#{rent_book_seq}")
				.VALUES("rent_user_seq", "#{rent_user_seq}")
				.VALUES("rent_return_yn", "#{rent_return_yn}");
		
		return sql.toString();
	}
	
	public String updateRentSQL() {
		
		SQL sql=new SQL().UPDATE("tbl_rent")
				.SET("rent_date=#{rent_date}")
				.SET("rent_return_date=#{rent_return_date}")
				.SET("rent_book_seq=#{rent_book_seq}")
				.SET("rent_user_seq=#{rent_user_seq}")
				.SET("rent_return_yn=#{rent_return_yn}")
				.WHERE("rent_seq=#{rent_seq}");
		
		return sql.toString();
				
	}
	
}











