package com.biz.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.book.model.BookVO;
import com.biz.book.model.SearchVO;
import com.biz.book.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bookService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String viewBookList(Model model) {
		
		model.addAttribute("LIST", bookService.selectAllBooks());
		model.addAttribute("BODY", "BOOKLIST");
		
		return "home";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insertBook(Model model, @ModelAttribute BookVO bookVO) {
		
		model.addAttribute("bookVO", bookVO);
		model.addAttribute("BODY", "BOOKINSERT");
		
		return "home";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insertBook(Model model, @ModelAttribute BookVO bookVO, MultipartHttpServletRequest request) {
		
		log.debug(bookVO.toString());
		int ret=bookService.insertBook(bookVO, request);
		
		model.addAttribute("BODY", "STATUS");
		
		if(ret>0) model.addAttribute("STATUS", "Insert Successed");
		else model.addAttribute("STATUS", "Insert Failed");
		
		return "home";
		
	}
	
	@RequestMapping(value="/info/{book_seq}", method=RequestMethod.GET)
	public String infoBook(@PathVariable long book_seq, Model model) {
		
		model.addAttribute("BODY", "BOOKINFO");
		model.addAttribute("BOOK", bookService.findByBookID(book_seq));
		
		return "home";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateBook(Model model, @RequestParam long book_seq, @ModelAttribute BookVO bookVO) {
		
		model.addAttribute("bookVO", bookService.findByBookID(book_seq));
		model.addAttribute("BODY", "BOOKUPDATE");
		
		return "home";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateBook(Model model, @ModelAttribute BookVO bookVO, MultipartHttpServletRequest request) {
		
		int ret=bookService.updateBook(bookVO, request);
		
		model.addAttribute("BODY", "STATUS");
		
		if(ret>0) model.addAttribute("STATUS", "Update Successed");
		else model.addAttribute("STATUS", "Update Failed");
		
		return "home";
		
	}
	
	@RequestMapping(value="/delete/{book_seq}", method=RequestMethod.GET)
	public String deleteBook(@PathVariable long book_seq, Model model) {
		
		int ret=bookService.deleteBook(book_seq);
		
		model.addAttribute("BODY", "STATUS");
		
		if(ret>0) model.addAttribute("STATUS", "Delete Successed");
		else model.addAttribute("STATUS", "Delete Failed");
	
		return "home";
	}
	
	@RequestMapping(value="/find", method=RequestMethod.GET)
	public String findBook(@RequestParam String book_isbn, Model model) {
		
		model.addAttribute("BODY", "BOOKLIST");
		model.addAttribute("LIST", bookService.findByBookISBN(book_isbn));
		
		return "home";
	}
	
}





















