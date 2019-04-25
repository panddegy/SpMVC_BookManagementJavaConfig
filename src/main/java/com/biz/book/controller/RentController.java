package com.biz.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.book.model.BookVO;
import com.biz.book.model.RentVO;
import com.biz.book.service.BookService;
import com.biz.book.service.RentService;
import com.biz.book.service.UserService;

import lombok.experimental.PackagePrivate;

@Controller
@RequestMapping("/rent")
public class RentController {

	@Autowired
	RentService rentService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	BookService bookService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String viewRentList(Model model) {
		
		model.addAttribute("BODY", "RENTLIST");
		model.addAttribute("LIST", rentService.selectAllRents());
		
		return "home";
	}
	
	@RequestMapping(value="/info/{rent_seq}", method=RequestMethod.GET)
	public String infoBook(@PathVariable long rent_seq, Model model) {
				
		RentVO rentVO=rentService.findByRentID(rent_seq);
		
		model.addAttribute("BODY", "RENTINFO");
		model.addAttribute("RENT", rentVO);
		model.addAttribute("BOOK", bookService.findByBookID(rentVO.getRent_book_seq()));
		model.addAttribute("USER", userService.findByUserID(rentVO.getRent_user_seq()));
		
		return "home";
	}
	
	@RequestMapping(value="/member/{book_seq}", method=RequestMethod.GET)
	public String memberRent(@ModelAttribute RentVO rentVO, @PathVariable long book_seq, Model model) {
		
		rentVO.setRent_book_seq(book_seq);
		
		model.addAttribute("BODY", "RENTINSERT");
		model.addAttribute("rentVO", rentVO);
		
		return "home";
	}
	
	@RequestMapping(value="/book/{user_seq}", method=RequestMethod.GET)
	public String bookRent(@ModelAttribute RentVO rentVO, @PathVariable long user_seq, Model model) {
		
		rentVO.setRent_user_seq(user_seq);
		
		model.addAttribute("BODY", "RENTINSERT");
		model.addAttribute("rentVO", rentVO);
		
		return "home";
	}
	
	@RequestMapping(value="/rent_member", method=RequestMethod.GET)
	public String rentMember(@RequestParam String search, Model model) {
		
		model.addAttribute("LIST", userService.findByUserName(search));
		
		return "rent_member";
	}
	
	@RequestMapping(value="/rent_book", method=RequestMethod.GET)
	public String rentBook(@RequestParam String search, Model model) {
		
		model.addAttribute("LIST", bookService.findByBookName(search));
		
		return "rent_book";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insertRent(@ModelAttribute RentVO rentVO, Model model, String _t) {
		
		model.addAttribute("BODY", "RENTINSERT");
		model.addAttribute("rentVO", rentVO);
		
		return "home";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insertRent(@ModelAttribute RentVO rentVO, Model model) {
		
		int ret=rentService.insertRent(rentVO);
		
		if(ret>0) model.addAttribute("STATUS", "Rental Complete");
		else model.addAttribute("STATUS", "Rental Failed");
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/return/{rent_seq}", method=RequestMethod.GET)
	public String updateRent(@PathVariable long rent_seq, Model model) {
		
		RentVO rentVO=rentService.findByRentID(rent_seq);
		
		int ret=rentService.updateRent(rentVO);
		
		if(ret>0) model.addAttribute("STATUS", "Return Complete");
		else model.addAttribute("STATUS", "Return Failed");
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateRent(Model model) {
		
		model.addAttribute("BODY", "RETURNLIST");
		model.addAttribute("LIST", rentService.selectAllReturns());
		
		return "home";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateRent(@ModelAttribute RentVO rentVO, Model model) {
		
		int ret=rentService.updateRent(rentVO);
		
		if(ret>0) model.addAttribute("STATUS", "Return Complete");
		else model.addAttribute("STATUS", "Return Failed");
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteRent(@RequestParam long rent_seq, Model model) {
		
		int ret=rentService.deleteRent(rent_seq);
		
		if(ret>0) model.addAttribute("STATUS", "Delete Successed");
		else model.addAttribute("STATUS", "Delete Failed");
		
		return "redirect:/";
	}
	@ResponseBody
	@RequestMapping(value="/find", method=RequestMethod.GET)
	public BookVO findByRentISBN(@RequestParam String book_isbn, Model model) {
		
		model.addAttribute("BODY", "RENTLIST");
		//model.addAttribute("LIST", bookService.findByBookISBN(book_isbn));
		BookVO bookVO=bookService.findByBookISBN(book_isbn);
		return bookVO;
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String findByRentDate(@RequestParam String searchDate, Model model) {
		
		model.addAttribute("BODY", "RENTLIST");
		model.addAttribute("LIST", rentService.selectAllRents());
		
		return "home";
	}
	
}





















