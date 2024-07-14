package com.yedam.app.dept.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;


public class DeptController {
	@Autowired
	DeptService deptService;
	
	// GET : 조회, 빈페이지
	// POST : 데이터 조작(등록, 수정, 삭제)
	
	// 전체조회
	@GetMapping("deptList")
	public String deptList(Model model) { // Model = Request + Response
		// 1) 기능 수행
		List<DeptVO> list = deptService.deptList();
		// 2) 클라이언트에 전달할 데이터 담기
		model.addAttribute("deptList", list);
		// 3) 데이터를 출력할 페이지를 결정
		return "dept/list";
		
	}
	// 단건조회
	@GetMapping("deptInfo") // 커맨드 객체 => application/x-www-form-urlencoded
	public String deptInfo(DeptVO deptVO, Model model) {
		DeptVO findVO = deptService.deptInfo(deptVO);
		model.addAttribute("deptInfo", findVO);
		return "dept/info";
	}
	// 등록 - 페이지
	@GetMapping("deptInsert")
	public String deptInsertForm() {
		return "dept/insert";
	}
	// 등록 - 처리(연산, submit)
	@PostMapping("deptInsert")
	public String deptInsertProcess(DeptVO deptVO) {
		int did = deptService.deptInsert(deptVO);
		String url = null;
		if(did > -1) {
			// 정상적으로 등록된 경우
			url = "redirect:deptInfo?deptid=" + did;
		}else {
			// 정상적으로 등록되지 않은 경우
			url = "redirect:deptList";
		}
		return url;
	}
}
