package com.adacho.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.adacho.model.GeneralDTO;

public class HrB {

	private static HrB dao = new HrB(); // 싱글톤 패턴으로 만드는 코드, static 영역
	private Connection conn;
	private ResultSet rSet;
	private PreparedStatement pStmt;
	
	private final String url = "jdbc:oracle:thin:@localhost:1521:xe"; // final: 더이상 못 바꾸는 상수로 쓰겟다
	private final String username = "c##hr";
	private final String password = "1234";
	
	private HrB() { // 싱글톤 패턴으로 만드는 코드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static HrB getInstance() {
		return dao;
	}
	
//	public void setDriver() { // 싱글톤이 아닌 일반 쌩코딩
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	private void getConnection(){
		try{
			conn = DriverManager.getConnection(url, username, password);// 내부에서 쓰기 때문에 private
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void closeConnection() {
		try {
			if(rSet != null)
				rSet.close();
			if(pStmt != null)
				pStmt.close();
			if(conn != null)
				conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// b. 사원 정보 검색(입사년)
//	사원번호        이름         성                부서
//	===========================================================
	public List<GeneralDTO> getEmployeesHireDate(String hireDate){ // 날짜를 받아서 처리
		List<GeneralDTO> employees = new ArrayList<GeneralDTO>();
		
		getConnection();
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT E.EMPLOYEE_ID, E.FIRST_NAME, E.LAST_NAME, NVL(D.DEPARTMENT_NAME, '<Not Assigned>') AS DEPT_NAME "); // 한 칸을 띄어야 문법적으로 오류가 안나므로(cmd처럼)
		sb.append("FROM EMPLOYEES E LEFT OUTER JOIN DEPARTMENTS D ");
		sb.append("ON E.DEPARTMENT_ID = D.DEPARTMENT_ID ");
		sb.append("WHERE TO_CHAR(E.HIRE_DATE, 'YYYY') = ? ");
		sb.append("ORDER BY E.EMPLOYEE_ID");
		
		String sql = sb.toString();
		
		try {
			// HrMain에서 구현한 부분과 비교하여 이런식으로 구현할 수 있다는 것을 인지
			pStmt = conn.prepareStatement(sql); // 쿼리문을 넣어주면 객체를 만들어 레퍼런스를 던져줌
			pStmt.setString(1, hireDate); // ?인 곳에 넣어줌
			
			rSet = pStmt.executeQuery(); // 이렇게 실행
			GeneralDTO employee;
			
			while(rSet.next()) { // 몇 개인 지 모르니까 while
				employee = new GeneralDTO();
				employee.setLong01(rSet.getLong(1)); // employee id
				employee.setString01(rSet.getString(2)); // first name
				employee.setString02(rSet.getString(3)); // last name
				employee.setString03(rSet.getString(4)); // department name
				employees.add(employee); // 생성한 employee객체를 employees에 ADD
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		
		return employees; // 리턴값을 안 해주면 빨간 줄 계속 뜸
	}
}
