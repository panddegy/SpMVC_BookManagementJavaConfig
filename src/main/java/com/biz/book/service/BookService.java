package com.biz.book.service;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.book.mapper.BookMapper;
import com.biz.book.model.BookVO;

@Service
public class BookService {
	
	@Autowired
	BookMapper bookMapper;
	
	@Autowired
	ServletContext sevletContext;
	
	@Autowired
	FileService fileService;

	public List<BookVO> selectAllBooks(){
		
		return bookMapper.selectAllBooks();
	}
	
	public List<BookVO> selectAllRentableBooks(){
		
		return bookMapper.selectAllRentableBooks();
	}
	
	public List<BookVO> findByBookName(String searchWord){
		
		searchWord="%"+searchWord+"%";
		
		return bookMapper.findByBookTitle(searchWord);
	}
	
	public BookVO findByBookID(long book_seq) {
		
		return bookMapper.findByBookID(book_seq);
	}
	
	public BookVO findByBookISBN(String book_isbn) {
		
		return bookMapper.findByBookISBN(book_isbn);
	}
	
	public int insertBook(BookVO bookVO, MultipartHttpServletRequest request) {
		
		if(request!=null) {
			MultipartFile file=request.getFile("book_file");
			String realPath=sevletContext.getRealPath("/files/book/");
			
			if(file!=null) {
				String saveName=fileService.fileUpload(file, realPath);
				if(saveName==null) return 0;
				bookVO.setBook_image(saveName);
			}
		}
		bookVO.setBook_rent_yn("y");
		
		return bookMapper.insertBook(bookVO);
	}
	
	
	public int updateBook(BookVO bookVO, MultipartHttpServletRequest request) {
				
		if(request!=null) {
			MultipartFile file=request.getFile("book_file");
			String realPath=sevletContext.getRealPath("/files/book/");
			
			BookVO _t=this.findByBookID(bookVO.getBook_seq());
			String fileName=_t.getBook_image();
			bookVO.setBook_image(fileName);
			
			if(!file.isEmpty()){
				fileService.deleteFile(_t.getBook_image(), realPath);
				bookVO.setBook_image(fileService.fileUpload(file, realPath));
			}
		}
		
		return bookMapper.updateBook(bookVO);
	}
	
	public int deleteBook(long book_seq) {
		
		BookVO bookVO=bookMapper.findByBookID(book_seq);
		String fileName=bookVO.getBook_image();
		String realPath=sevletContext.getRealPath("/files/book/");
		
		if(fileName!=null) {
			fileService.deleteFile(fileName, realPath);
		}
		
		return bookMapper.deleteBook(book_seq);
	}
	
	
	
}





















