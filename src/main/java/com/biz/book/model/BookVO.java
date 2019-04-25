package com.biz.book.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookVO {
/*
	create table tbl_book(
	    book_seq number primary key,
	    book_isbn char(13) not null,
	    book_title nvarchar2(100) not null,
	    book_author nvarchar2(30),
	    book_price number,
	    book_description nvarchar2(1000),
	    book_image nvarchar2(125),
	    book_rent_yn char(1) default 'y'
	    constraint check_rent check(book_rent_yn in('y','n'))
	);
*/
	private long book_seq;
	private String book_isbn, book_title, book_author;
	private int book_price;
	private String book_description, book_image, book_rent_yn;
	private MultipartFile book_file;
	
}






















