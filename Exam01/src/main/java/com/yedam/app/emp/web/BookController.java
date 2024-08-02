package com.yedam.app.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.emp.service.BookService;
import com.yedam.app.emp.service.BookVO;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("bookList")
	public String bookList(Model model) {
		List<BookVO> list = bookService.bookList();
		model.addAttribute("bookList", list);
		
		return "book/empList";
	}
	
		@GetMapping("bookInsert")
		public String bookInsertForm(Model model) {
			return "book/empInsert";
		}
		
		@PostMapping("bookInsert")
		public String bookInsertProcess(BookVO bookVO) {
			bookService.insertBook(bookVO);
			return "redirect:bookList";
		}
}
