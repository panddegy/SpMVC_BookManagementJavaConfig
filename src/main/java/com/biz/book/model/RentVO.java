package com.biz.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RentVO {
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

	private long rent_seq;
	private String rent_date, rent_return_date;
	private long rent_book_seq, rent_user_seq;
	private String rent_return_yn;
}
