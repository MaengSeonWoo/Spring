package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller // 사용자의 요청(endpoint)에 대한 처리를 정의
			// => url + method => service => view
public class EmpController {
	// 해당 컨트롤러에서 서비스를 추가
	@Autowired
	EmpService empService;
	
	// GET : 조회, 빈페이지
	// POST : 데이터 조작(등록, 수정, 삭제)
	
	// 전체조회
	@GetMapping("empList")
	public String empList(Model model) { // Model = Request + Response
		// 1) 기능 수행
		List<EmpVO> list = empService.empList();
		// 2) 클라이언트에 전달할 데이터 담기
		model.addAttribute("empList", list);
		// 3) 데이터를 출력할 페이지를 결정
		return "emp/list";
		// classpath:/templates/    emp/list   .html
		// prefix                   return     suffix
		// => classpath:/templates/emp/list.html
	}
	// 단건조회
	@GetMapping("empInfo") // 커맨드 객체 => application/x-www-form-urlencoded
	public String empInfo(EmpVO empVO, Model model) {
		EmpVO findVO = empService.empInfo(empVO);
		model.addAttribute("empInfo", findVO);
		return "emp/info";
		// classpath:/templates/    emp/info   .html
		// prefix                   return     suffix
		// => classpath:/templates/emp/info.html
	}
	// 등록 - 페이지
	@GetMapping("empInsert")
	public String empInsertForm() {
		return "emp/insert";
		// classpath:/templates/    emp/insert   .html
		// prefix                   return       suffix
		// => classpath:/templates/emp/insert.html          
	}
	// 등록 - 처리(연산, submit)
	@PostMapping("empInsert")
	public String empInsertProcess(EmpVO empVO) {
		int eid = empService.empInsert(empVO);
		String url = null;
		if(eid > -1) {
			// 정상적으로 등록된 경우
			url = "redirect:empInfo?empid=" + eid;
		}else {
			// 정상적으로 등록되지 않은 경우
			url = "redirect:empList";
		}
		return url;
	}
	// 수정 - 페이지 1) 단건조회
	@GetMapping("empUpdate")
	public String empUpdateForm(@RequestParam Integer empid,
								Model model) {
		EmpVO empVO = new EmpVO();
		empVO.setEmpid(empid);
		
		EmpVO findVO = empService.empInfo(empVO);
		model.addAttribute("empInfo", findVO);
		
		return "emp/update";
	}
	// 수정 - 처리(연산, AJAX => QueryString)
	//@PostMapping("empUpdate")
	@ResponseBody // => AJAX
	public Map<String, Object> empUpdateAJAXQueryString(EmpVO empVO){
		return empService.empUpdate(empVO);
	}
	// 수정 - 처리(연산, AJAX => JSON : @RequestBody)
	@PostMapping("empUpdate")
	@ResponseBody // => AJAX
	public Map<String, Object> empUpdateAJAXJSON(@RequestBody EmpVO empVO){
		return empService.empUpdate(empVO);
	}
	// 삭제 - 처리
	@GetMapping("empDelete")
	public String empDelete(EmpVO empVO) {
		empService.empDelete(empVO);
		return "redirect:empList";
	}
}
