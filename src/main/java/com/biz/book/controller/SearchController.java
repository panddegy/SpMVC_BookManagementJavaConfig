package com.biz.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.book.model.BookVO;
import com.biz.book.model.RentVO;
import com.biz.book.model.SearchVO;
import com.biz.book.model.UserVO;
import com.biz.book.service.SearchService;

@Controller
public class SearchController {

	@Autowired
	SearchService searchService;
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String searchBook(@ModelAttribute SearchVO searchVO, Model model) {
		
		String book_isbn=searchVO.getBook_isbn();
		if(!book_isbn.equals("")) {
			BookVO bookVO=searchService.searchISBN(searchVO.getBook_isbn());
			if(bookVO==null) {
				model.addAttribute("BODY", "STATUS");
				model.addAttribute("STATUS", "검색 결과가 없습니다.");
				return "home";
			} else {
				model.addAttribute("BODY", "BOOKINFO");
				model.addAttribute("BOOK", bookVO);
				return "home";
			}
		}

		String book_title=searchVO.getBook_title();
		if(!book_title.equals("")){
			List<BookVO> bookList=searchService.searchTitle(book_title);
			if(bookList.isEmpty()) {
				model.addAttribute("BODY", "STATUS");
				model.addAttribute("STATUS", "검색 결과가 없습니다.");
				return "home";
			} else {
				model.addAttribute("BODY", "BOOKLIST");
				model.addAttribute("LIST", bookList);
				return "home";
			}
		}
		
		String user_name=searchVO.getUser_name();
		if(!user_name.equals("")){
			List<UserVO> userList=searchService.searchName(user_name);
			if(userList.isEmpty()) {
				model.addAttribute("BODY", "STATUS");
				model.addAttribute("STATUS", "검색 결과가 없습니다.");
				return "home";
			} else {
				model.addAttribute("BODY", "USERLIST");
				model.addAttribute("LIST", userList);
				return "home";
			}
		}
		
		String user_phone=searchVO.getUser_phone();
		if(!user_phone.equals("")){
			List<UserVO> userList=searchService.searchPhone(user_phone);
			if(userList.isEmpty()) {
				model.addAttribute("BODY", "STATUS");
				model.addAttribute("STATUS", "검색 결과가 없습니다.");
				return "home";
			} else {
				model.addAttribute("BODY", "USERLIST");
				model.addAttribute("LIST", userList);
				return "home";
			}
		}
		
		String rent_date=searchVO.getRent_date();
		if(!rent_date.equals("")){
			List<RentVO> rentList=searchService.searchDate(rent_date);
			if(rentList.isEmpty()) {
				model.addAttribute("BODY", "STATUS");
				model.addAttribute("STATUS", "검색 결과가 없습니다.");
				return "home";
			} else {
				model.addAttribute("BODY", "RENTLIST");
				model.addAttribute("LIST", rentList);
				return "home";
			}
		}
		
		model.addAttribute("BODY", "STATUS");
		model.addAttribute("STATUS", "검색 결과가 없습니다.");
		
		return "home";
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
