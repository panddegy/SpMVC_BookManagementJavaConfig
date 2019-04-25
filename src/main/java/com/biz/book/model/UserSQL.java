package com.biz.book.model;

import org.apache.ibatis.jdbc.SQL;

public class UserSQL {
/*
	create table tbl_user(
	    user_seq number primary key,
	    user_name nvarchar2(30) not null,
	    user_birth char(10) not null,
	    user_sex char(1)
	    constraint check_sex check(user_sex in('m','f')),
	    user_phone nvarchar2(15) not null,
	    user_mail nvarchar2(255),
	    user_image nvarchar2(125),
	    user_reg_date char(10),
	    user_out_date char(10),
	    user_out_yn char(1) DEFAULT 'n'
	    constraint check_out check(user_out_yn in('y','n')),
	    user_rent_count number default 0,
	    user_rent_total number default 0
	);
*/
	public String insertUserSQL() {
		
		SQL sql=new SQL().INSERT_INTO("tbl_user")
				.VALUES("user_seq", "user_seq.nextval")
				.VALUES("user_name", "#{user_name,jdbcType=NVARCHAR}")
				.VALUES("user_birth", "#{user_birth,jdbcType=CHAR}")
				.VALUES("user_phone", "#{user_phone,jdbcType=NVARCHAR}")
				.VALUES("user_image", "#{user_image,jdbcType=NVARCHAR}")
				.VALUES("user_reg_date", "#{user_reg_date,jdbcType=CHAR}")
				.VALUES("user_rent_count", "#{user_rent_count}")
				.VALUES("user_rent_total", "#{user_rent_total}");
		
		return sql.toString();
	}
	
	public String updateUserSQL() {
		
		SQL sql=new SQL().UPDATE("tbl_user")
				.SET("user_name=#{user_name,jdbcType=NVARCHAR}")
				.SET("user_birth=#{user_birth,jdbcType=CHAR}")
				.SET("user_phone=#{user_phone,jdbcType=NVARCHAR}")
				.SET("user_image=#{user_image,jdbcType=NVARCHAR}")
				.SET("user_rent_count=#{user_rent_count}")
				.SET("user_rent_total=#{user_rent_total}")
				.WHERE("user_seq=#{user_seq}");
		
		return sql.toString();
	}
}




















