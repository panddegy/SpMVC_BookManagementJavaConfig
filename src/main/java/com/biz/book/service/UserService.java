package com.biz.book.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.book.mapper.UserMapper;
import com.biz.book.model.UserVO;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;
	
	@Autowired
	ServletContext sevletContext;
	
	@Autowired
	FileService fileService;

	public List<UserVO> selectAllUsers() {

		return userMapper.selectAllUsers();
	}

	public List<UserVO> findByUserName(String searchWord) {

		searchWord="%"+searchWord+"%";
		
		return userMapper.findByUserName(searchWord);
	}
	
	public List<UserVO> findByUserPhone(String searchPhone) {

		return userMapper.findByUserPhone(searchPhone);
	}

	public UserVO findByUserID(long user_seq) {

		return userMapper.findByUserID(user_seq);
	}

	public int insertUser(UserVO userVO, MultipartHttpServletRequest request) {

		if(request!=null) {
			MultipartFile file=request.getFile("user_file");
			String realPath=sevletContext.getRealPath("/files/user/");
			
			if(file!=null) {
				String saveName=fileService.fileUpload(file, realPath);
				if(saveName==null) return 0;
				userVO.setUser_image(saveName);
			}
		}
		
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		Date d=new Date();
		String today = sf.format(d);
		userVO.setUser_reg_date(today);
		
		return userMapper.insertUser(userVO);
	}

	public int updateUser(UserVO userVO, MultipartHttpServletRequest request) {

		if(request!=null) {
			MultipartFile file=request.getFile("user_file");
			String realPath=sevletContext.getRealPath("/files/user/");
			
			UserVO _t=userMapper.findByUserID(userVO.getUser_seq());
			
			String fileName=_t.getUser_image();
			userVO.setUser_image(fileName);
			if(!file.isEmpty()) {
				fileService.deleteFile(fileName, realPath);
				String saveName=fileService.fileUpload(file, realPath);
				if(saveName==null) return 0;
				userVO.setUser_image(saveName);
			}
		}
		
		return userMapper.updateUser(userVO);
	}

	public int deleteUser(long user_seq) {
		
		UserVO userVO=userMapper.findByUserID(user_seq);
		String fileName=userVO.getUser_image();
		String realPath=sevletContext.getRealPath("/files/user/");
		
		if(fileName!=null) {
			fileService.deleteFile(userVO.getUser_image(), realPath);
		}
		
		return userMapper.deleteUser(user_seq);
	}
	
}


















