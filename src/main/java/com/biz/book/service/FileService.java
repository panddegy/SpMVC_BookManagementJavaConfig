package com.biz.book.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

	public String fileUpload(MultipartFile file, String realPath) {
		
		
		String saveName=UUID.randomUUID().toString()+file.getOriginalFilename();
		
		File dir=new File(realPath);
		if(!dir.exists()) dir.mkdir();
		
		File saveFile=new File(realPath, saveName);
		try {
			file.transferTo(saveFile);
			return saveName;
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public boolean deleteFile(String fileName, String realPath) {
		
		File file=new File(realPath, fileName);
		
		if(file.delete()) return true;
		
		return false;
	}
	
}

















