package com.adacho.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.adacho.dao.HrA;
import com.adacho.dao.HrB;
import com.adacho.dao.HrC;
import com.adacho.model.GeneralDTO;

// import com.adacho.dao.HrDao;
// import com.adacho.model.Employee;

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

		String menuSelect; // 메인 화면 메뉴 선택 저장 변수
		String name;
		String hireDate;
		String employeeID;
		Scanner sc = new Scanner(System.in);

//		메뉴 선택!
//		===================================
//		a. 사원정보 검색(이름)
//		b. 사원정보 검색(입사년)
//		c. 과거 업무이력 검색(사원ID)
//		q. 종료		
		while(true) {
			System.out.println("메뉴 선택!");
			System.out.println("===================================");
			System.out.println("a. 사원정보 검색(이름)");
			System.out.println("b. 사원정보 검색(입사년도)");
			System.out.println("c. 과거 업무이력 검색(사원ID)");
			System.out.println("q. 종료");
			menuSelect = sc.next();
			
			switch (menuSelect) {
			case "a":
				// public List<Employee> getEmployeesName(String name) 실행부분
				System.out.print("사원의 First name 또는 Last name을 입력하세요: ");
				name = sc.next();
				
				HrA hrA = HrA.getInstance(); // Singleton Pattern으로 만든 것
				
				List<GeneralDTO> employeesA = new ArrayList<GeneralDTO>();
				employeesA = hrA.getEmployeesName(name);
				
				System.out.printf("%-30s", "이름 ");
				System.out.printf("%-30s","성 ");
				System.out.printf("%-30s","이메일 ");
				System.out.printf("%-30s","전화 ");
				System.out.printf("%-30s","입사일 ");
				System.out.println();
				System.out.print("=============================================================================================");
				System.out.println();
				if(employeesA.size() == 0) {
					System.out.println("데이터가 없습니다!");
					System.out.println();
					break;
				}
//				hireDate = sc.next();
				
//				   이름           성                    이메일             전화                         입사일
//				   =================================================================================================
//				        Susan        Mavris                  SMAVRIS          515.123.7777             2002-06-07
				for (GeneralDTO employee : employeesA) {
					System.out.printf("%-20s", employee.getString01() + " "); // 이름
					System.out.printf("%-20s",employee.getString02() + " "); // 성
					System.out.printf("%-20s",employee.getString03() + " "); // 이메일
					System.out.printf("%-20s",employee.getString04() + " "); // 전화
					System.out.printf("%-20s",employee.getString05() + " "); // 이메일
					System.out.println();
				}
				System.out.println();
				break;
				
				
			case "b":
				// public List<Employee> getEmployeesHireDate(String hireDate) 실행부분
				System.out.print("입사년도를 입력하세요: ");
				hireDate = sc.next();
				
				HrB hrB = HrB.getInstance(); // Singleton Pattern으로 만든 것
				
				List<GeneralDTO> employeesB = new ArrayList<GeneralDTO>();
				employeesB = hrB.getEmployeesHireDate(hireDate);
				
				System.out.printf("%-30s","사원번호 ");
				System.out.printf("%-30s","이름 ");
				System.out.printf("%-30s","성 ");
				System.out.printf("%-30s","부서 ");
				System.out.println();
				System.out.print("=============================================================================================");
				System.out.println();
				
				if(employeesB.size() == 0) {
					System.out.println("데이터가 없습니다!");
					System.out.println();
					break;
				}
//				hireDa
//				hireDate = sc.next();
				
//				사원번호        이름         성                부서
//				===========================================================
//				  104         Bruce          Ernst                    IT
//				  107         Diana        Lorentz                    IT
//				  113          Luis           Popp               Finance
				for (GeneralDTO employee : employeesB) {
//					employee.setEmployeeID(rSet.getLong(1)); // 1번 째 컬럼 값
//					employee.setFirstName(rSet.getString(2));
//					employee.setLastName(rSet.getString(3));
//					employee.setDepartmentName(rSet.getString(3));
					System.out.printf("%-20s",employee.getLong01() + " "); // 사원번호
					System.out.printf("%-20s",employee.getString01() + " "); // 이름
					System.out.printf("%-20s",employee.getString02() + " "); // 성
					System.out.printf("%-20s",employee.getString03() + " "); // 부서이름
					System.out.println();
				}
				System.out.println();
				break;
				
			case "c":
				// public List<Employee> getEmployeesID(String name) 실행부분
				System.out.print("사원번호를 입력하세요: ");
				employeeID = sc.next();
				
				HrC hrC = HrC.getInstance(); // Singleton Pattern으로 만든 것
				
				List<GeneralDTO> employeesC = new ArrayList<GeneralDTO>();
				employeesC = hrC.getEmployeesID(employeeID);
				
				System.out.printf("%-30s","이름 ");
				System.out.printf("%-30s","담당업무 ");
				System.out.printf("%-30s","시작일 ");
				System.out.printf("%-30s","종료일 ");
				System.out.println();
				System.out.print("=============================================================================================");
				System.out.println();
				
				if(employeesC.size() == 0) {
					System.out.println("데이터가 없습니다!");
					System.out.println();
					break;
				}
//				hireDa
//				hireDate = sc.next();
				
//		        이름                    담당업무                시작일                  종료일
//		        =================================================================================================
//		             Jennifer Whalen    Administration Assistant     1995-09-17 00:00:00       2001-06-17 00:00:00
//		             Jennifer Whalen       Public Accountant     2002-07-01 00:00:00       2006-12-31 00:00:00
				for (GeneralDTO employee : employeesC) {
//					employee.setFirstName(rSet.getString(1)); // 1번 째 컬럼 값
//					employee.setJobTitle(rSet.getString(2));
//					employee.setStartDate(rSet.getString(3));
//					employee.setEndDate(rSet.getString(4));
					System.out.printf("%-20s",employee.getString01() + employee.getString02() + " "); // 이름
					System.out.printf("%-20s",employee.getString03() + " "); // 담당업무
					System.out.printf("%-20s",employee.getString04() + " "); // 시작일
					System.out.printf("%-20s",employee.getString05() + " "); // 종료일
					System.out.println();
				}
				System.out.println();
				break;
				
			case "q":
				// public List<Employee> Exit(String name) 실행부분
				System.out.print("프로그램 종료!!");
				System.exit(0);
				
				
			default: // 변수와 값이 불일치 하면 default 실행문 작동
				System.out.println("잘못 선택하셨습니다. 다시 선택하세요!!");
			}
		}
		
		// 생코딩 부분
//		HrDao dao = new HrDao();
//		dao.setDriver();
//		HrDao dao = HrDao.getInstance(); // Singleton Pattern으로 만든 것
//		
//		List<Employee> employees = new ArrayList<Employee>();
//
//		name = sc.next();
//		employees = dao.getEmployeesName(name);
//		hireDate = sc.next();
//		
//
//		for (Employee employee : employees) {
//			System.out.println("First_Name : " + employee.getFirstName());
//			System.out.println("Last_Name : " + employee.getLastName());
//			System.out.println("Email : " + employee.getEmail());
//			System.out.println("Phone_Number : " + employee.getPhoneNumber());
//			System.out.println("Hire Date : " + employee.getHireDate());
//			System.out.println();
//		}
	}
}
