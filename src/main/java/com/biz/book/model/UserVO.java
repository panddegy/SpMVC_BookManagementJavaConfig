package com.biz.book.model;

import org.springframework.web.multipart.MultipartFile;

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
public class UserVO {
/*
	create table tbl_user(
		user_seq number primary key,
		user_name nvarchar2(30) not null,
		user_birth char(10) not null,
		user_phone nvarchar2(15) not null,
		user_image nvarchar2(125),
		user_reg_date char(10),
		user_rent_count number default 0,
		user_rent_total number default 0
	);
*/

	private long user_seq;
	private String user_name, user_birth, user_phone, user_image;
	private String user_reg_date;
	private long user_rent_count, user_rent_total;
	private MultipartFile user_file;
	
}
