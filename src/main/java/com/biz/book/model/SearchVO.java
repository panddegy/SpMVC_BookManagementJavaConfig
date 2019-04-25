package com.biz.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SearchVO {

	private String book_isbn;
	private String book_title;
	private String user_phone;
	private String user_name;
	private String rent_date;
	
}
