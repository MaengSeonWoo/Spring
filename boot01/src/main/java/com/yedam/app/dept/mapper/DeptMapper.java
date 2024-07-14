package com.yedam.app.dept.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.dept.service.DeptVO;


public interface DeptMapper {
	// 테이블을 기준
	// 전체조회
	public List<DeptVO> selectDeptAll();
	// 단건조회
	public DeptVO selectDeptInfo(DeptVO deptVO);
	// 등록
	public int insertDeptInfo(DeptVO deptVO);
	// 수정(2가지 이상의 값이 넘어올때 @Param을 사용해서 명시
	public int updateDeptInfo(@Param("id") int deptno, 
								@Param("dept")DeptVO deptVO);
	// 삭제
	public int deleteDeptInfo(int deptno);
}
