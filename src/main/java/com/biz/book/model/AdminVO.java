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
public class AdminVO {
/*
	create table tbl_admin(
	    admin_id nvarchar2(15) primary key,
		admin_pass nvarchar2(30) not null
	);
*/
	private String admin_id, admin_pass;
	
}
