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

import com.biz.book.model.UserVO;
import com.biz.book.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String viewUserList(Model model) {
		
		model.addAttribute("BODY", "USERLIST");
		model.addAttribute("LIST", userService.selectAllUsers());
		
		return "home";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insertUser(Model model, @ModelAttribute UserVO userVO) {
		
		model.addAttribute("userVO", userVO);
		model.addAttribute("BODY", "USERINSERT");
		
		return "home";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insertUser(Model model, @ModelAttribute UserVO userVO, MultipartHttpServletRequest request) {
		
		int ret=userService.insertUser(userVO, request);
		
		model.addAttribute("BODY", "STATUS");
		
		if(ret>0) model.addAttribute("STATUS", "Insert Successed");
		else model.addAttribute("STATUS", "Insert Failed");
		
		return "home";
	}
	
	@RequestMapping(value="/info/{user_seq}", method=RequestMethod.GET)
	public String infoUser(@PathVariable long user_seq, Model model) {
		
		model.addAttribute("BODY", "USERINFO");
		model.addAttribute("USER", userService.findByUserID(user_seq));
		
		return "home";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateUser(@RequestParam long user_seq, Model model, @ModelAttribute UserVO userVO) {
		
		model.addAttribute("userVO", userService.findByUserID(user_seq));
		model.addAttribute("BODY", "USERUPDATE");
		
		return "home";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateUser(@ModelAttribute UserVO userVO, Model model, MultipartHttpServletRequest request) {
		
		int ret=userService.updateUser(userVO, request);
		
		model.addAttribute("BODY", "STATUS");
		
		if(ret>0) model.addAttribute("STATUS", "Update Successed");
		else model.addAttribute("STATUS", "Update Failed");
		
		return "home";
	}
	
	@RequestMapping(value="/delete/{user_seq}", method=RequestMethod.GET)
	public String deleteUser(@PathVariable long user_seq, Model model) {
		
		int ret=userService.deleteUser(user_seq);
		
		model.addAttribute("BODY", "STATUS");
		
		if(ret>0) model.addAttribute("STATUS", "Delete Successed");
		else model.addAttribute("STATUS", "Delete Failed");
	
		return "home";
	}
	
	@RequestMapping(value="/find", method=RequestMethod.GET)
	public String findUserPhone(@RequestParam String searchPhone, Model model) {
		
		model.addAttribute("LIST", userService.findByUserPhone(searchPhone));
		model.addAttribute("BODY", "USERLIST");
		
		return "home";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String findUserName(String searchWord, Model model) {
		
		model.addAttribute("LIST", userService.findByUserName(searchWord));
		model.addAttribute("BODY", "USERLIST");
		
		return "home";
	}
	
}





















