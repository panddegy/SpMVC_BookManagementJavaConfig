package com.biz.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.book.mapper.BookMapper;
import com.biz.book.mapper.RentMapper;
import com.biz.book.mapper.UserMapper;
import com.biz.book.model.BookVO;
import com.biz.book.model.RentVO;
import com.biz.book.model.UserVO;

@Service
public class SearchService {

	@Autowired
	BookMapper bookMapper;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	RentMapper rentMapper;
	
	public BookVO searchISBN(String book_isbn) {
		
		return bookMapper.findByBookISBN(book_isbn);
	}
	
	public List<BookVO> searchTitle(String book_title){
		
		book_title="%"+book_title+"%";
		
		return bookMapper.findByBookTitle(book_title);
	}
	
	public List<UserVO> searchPhone(String user_phone){
		
		user_phone="%"+user_phone;
		
		return userMapper.findByUserPhone(user_phone);
	}
	
	public List<UserVO> searchName(String user_name){
		
		user_name="%"+user_name+"%";
		
		return userMapper.findByUserName(user_name);
	}
	
	public List<RentVO> searchDate(String rent_date){
		
		return rentMapper.findByRentDate(rent_date);
	}
}



























