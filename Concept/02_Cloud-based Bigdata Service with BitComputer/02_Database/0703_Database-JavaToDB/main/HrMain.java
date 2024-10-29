package com.adacho.main;

import java.util.ArrayList;
import java.util.List;
import com.adacho.dao.HrDao;
import com.adacho.model.Employee;

// 사용자용 프로그램을 만드는 것이라고 보면 됨
public class HrMain {
	public static void main(String[] args) {
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String username = "c##hr";
//		String password = "1234";
//		
//		Connection conn = null;
//		StringBuffer sb = new StringBuffer(); // 
//		PreparedStatement pStmt = null; // 준비된 문장이다, null로 초기화 하지 않으면 에러 뜸
//		String name = "Su";
//		ResultSet rSet = null; // null로 초기화 하지 않으면 에러 뜸
//		// 모든 변수를 선언해야되는 안좋은 코드
////		String firstName, ... hireDate; 
//		
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver"); // class reflextion, 오라클 드라이버 올리고
//			conn = DriverManager.getConnection(url, username, password);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		// 쿼리문을 만들고
//		sb.append("SELECT FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE "); // 한 칸을 띄어야 문법적으로 오류가 안나므로(cmd처럼)
//		sb.append("FROM EMPLOYEES ");
//		sb.append("WHERE FIRST_NAME LIKE  ? OR LAST_NAME = ?"); // ?는 인자가 들어올 것
//		
//		String sql = sb.toString();
//		Employees employee = new Employees();
//		
//		try {
//			pStmt = conn.prepareStatement(sql); // 쿼리문을 넣어주면 객체를 만들어 레퍼런스를 던져줌
//			pStmt.setString(1, "%" + name + "%"); // ?인 곳에 넣어줌
//			pStmt.setString(2, "%" + name + "%");// 직원은 스트링 타입이니까 , 앞이 1 뒤가 2
//			
//			rSet = pStmt.executeQuery(); // 이렇게 실행
//			
//			while(rSet.next()) { // 몇 개인 지 모르니까 while
//				// 모든 변수를 선언해야되는 안좋은 코드, 각각의 변수에 넣어주는 코드로 원래 짜여져 있었음
////				employee.setFirstName(rSet.getString(1)); // 1번 째 컬럼 값
////				employee.setLastName(rSet.getString(2));
////				employee.setEmail(rSet.getString(3));
////				employee.setPhoneNumber(rSet.getString(4));
////				employee.setHireDate(rSet.getDate(5).toString()); // hire date는 Date 타입이라 getString 불가능
////				System.out.println("First_Name : " + employee.getFirstName());
////				System.out.println("Last_Name : " + employee.getLastName());
////				System.out.println("Email : " + employee.getEmail());
////				System.out.println("Phone_Number : " + employee.getPhoneNumber());
////				System.out.println("Hire Date : " + employee.getHireDate());
////				System.out.println();
//				
//				// java bin을 이용(getter setter만 이루어진 것, Employees.class)
//				employee.setFirstName(rSet.getString(1)); // 1번 째 컬럼 값
//				employee.setLastName(rSet.getString(2));
//				employee.setEmail(rSet.getString(3));
//				employee.setPhoneNumber(rSet.getString(4));
//				employee.setHireDate(rSet.getDate(5).toString()); // hire date는 Date 타입이라 getString 불가능
//				System.out.println("First_Name : " + employee.getFirstName());
//				System.out.println("Last_Name : " + employee.getLastName());
//				System.out.println("Email : " + employee.getEmail());
//				System.out.println("Phone_Number : " + employee.getPhoneNumber());
//				System.out.println("Hire Date : " + employee.getHireDate());
//				System.out.println();
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(rSet != null)
//					rSet.close();
//				if(pStmt != null)
//					pStmt.close();
//				if(conn != null)
//					conn.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//		
//		
//		
//		
//		
//		for(int i = 0; i < 10000; i++) {
//			
//		}
//		
//		try {
//			conn.close();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}

		
		
		// 생코딩 부분
//		HrDao dao = new HrDao();
//		dao.setDriver();

		HrDao dao = HrDao.getInstance(); // Singleton Pattern으로 만든 것
		
		List<Employee> employees = new ArrayList<Employee>();

		employees = dao.getEmployees("Su");

		for (Employee employee : employees) {
			System.out.println("First_Name : " + employee.getFirstName());
			System.out.println("Last_Name : " + employee.getLastName());
			System.out.println("Email : " + employee.getEmail());
			System.out.println("Phone_Number : " + employee.getPhoneNumber());
			System.out.println("Hire Date : " + employee.getHireDate());
			System.out.println();
		}
	}
}
