package com.yedam.app.emp.service;

import java.util.List;

public interface BookService {
	// 전체조회
	public List<BookVO> bookList();
	
	// 등록
	public int insertBook(BookVO bookVO);
}
