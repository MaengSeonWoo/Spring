package com.yedam.app;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;



@SpringBootTest
class Boot01ApplicationTests {
//	@Autowired
//	DeptMapper deptMapper;
//	
//	//@Test
//	void contextLoads() {
//		assertNotNull(deptMapper);
//	}
//	
//	//@Test
//	void selectDeptAll() {
//		// 전체조회
//		List<DeptVO> list = deptMapper.selectDeptAll();
//		assertTrue(!list.isEmpty());
//		
//	}
//	
//	@Test
//	void selectDeptInfo() {
//		// 단건조회
//		DeptVO deptVO = new DeptVO();
//		deptVO.setLoc("DALLAS");
//		
//		DeptVO findVO = deptMapper.selectDeptInfo(deptVO);
//		assertEquals(findVO.getDeptname(), "RESEARCH");
//	}
//	
//	@Test
//	void insertDeptInfo() {
//		// 등록
//		DeptVO deptVO = new DeptVO();
//		deptVO.setDeptname("RESEARCH");
//		deptVO.setLoc("Seoul");
//		
//		int result = deptMapper.insertDeptInfo(deptVO);
//		//assertEquals(result, 1);
//		assertEquals(deptVO.getDeptno(), 50);
//	}
//	
//	//@Test
//	void updateDeptInfo() {
//		// 1.단건조회 => 2. 업데이트
//		// 1-1) 조건
//		DeptVO deptVO = new DeptVO();
//		deptVO.setDeptno(2);
//		
//		// 1-2) 조회
//		DeptVO findVO = deptMapper.selectDeptInfo(deptVO);
//		findVO.setDeptname("SALES");
//		findVO.setLoc("CHICAGO");
//		
//		// 2) 업데이트
//		int result = deptMapper.updateDeptInfo(findVO.getDeptno(), findVO);
//		
//		assertEquals(1, result);
//	}
//	
//	//@Test
//	void deleteDeptInfo() {
//		int result = deptMapper.deleteDeptInfo(2);
//		assertEquals(1, result);
//	}

}
