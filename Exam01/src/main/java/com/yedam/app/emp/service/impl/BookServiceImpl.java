package com.yedam.app.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.BookMapper;
import com.yedam.app.emp.service.BookService;
import com.yedam.app.emp.service.BookVO;

@Service
public class BookServiceImpl implements BookService{
	
	 @Autowired
	 BookMapper bookMapper;

	@Override
	public List<BookVO> bookList() {
		// TODO Auto-generated method stub
		return bookMapper.selectBookAll();
	}

	@Override
	public int insertBook(BookVO bookVO) {
		int result = bookMapper.insertBookInfo(bookVO);
		
		return result == 1 ? bookVO.getBookNo() : -1;
	}
}
