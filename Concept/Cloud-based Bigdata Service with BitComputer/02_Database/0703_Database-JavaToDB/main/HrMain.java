package com.adacho.main;

import java.util.ArrayList;
import java.util.List;
import com.adacho.dao.HrDao;
import com.adacho.model.Employee;

// ����ڿ� ���α׷��� ����� ���̶�� ���� ��
public class HrMain {
	public static void main(String[] args) {
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String username = "c##hr";
//		String password = "1234";
//		
//		Connection conn = null;
//		StringBuffer sb = new StringBuffer(); // 
//		PreparedStatement pStmt = null; // �غ�� �����̴�, null�� �ʱ�ȭ ���� ������ ���� ��
//		String name = "Su";
//		ResultSet rSet = null; // null�� �ʱ�ȭ ���� ������ ���� ��
//		// ��� ������ �����ؾߵǴ� ������ �ڵ�
////		String firstName, ... hireDate; 
//		
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver"); // class reflextion, ����Ŭ ����̹� �ø���
//			conn = DriverManager.getConnection(url, username, password);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		// �������� �����
//		sb.append("SELECT FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE "); // �� ĭ�� ���� ���������� ������ �ȳ��Ƿ�(cmdó��)
//		sb.append("FROM EMPLOYEES ");
//		sb.append("WHERE FIRST_NAME LIKE  ? OR LAST_NAME = ?"); // ?�� ���ڰ� ���� ��
//		
//		String sql = sb.toString();
//		Employees employee = new Employees();
//		
//		try {
//			pStmt = conn.prepareStatement(sql); // �������� �־��ָ� ��ü�� ����� ���۷����� ������
//			pStmt.setString(1, "%" + name + "%"); // ?�� ���� �־���
//			pStmt.setString(2, "%" + name + "%");// ������ ��Ʈ�� Ÿ���̴ϱ� , ���� 1 �ڰ� 2
//			
//			rSet = pStmt.executeQuery(); // �̷��� ����
//			
//			while(rSet.next()) { // �� ���� �� �𸣴ϱ� while
//				// ��� ������ �����ؾߵǴ� ������ �ڵ�, ������ ������ �־��ִ� �ڵ�� ���� ¥���� �־���
////				employee.setFirstName(rSet.getString(1)); // 1�� ° �÷� ��
////				employee.setLastName(rSet.getString(2));
////				employee.setEmail(rSet.getString(3));
////				employee.setPhoneNumber(rSet.getString(4));
////				employee.setHireDate(rSet.getDate(5).toString()); // hire date�� Date Ÿ���̶� getString �Ұ���
////				System.out.println("First_Name : " + employee.getFirstName());
////				System.out.println("Last_Name : " + employee.getLastName());
////				System.out.println("Email : " + employee.getEmail());
////				System.out.println("Phone_Number : " + employee.getPhoneNumber());
////				System.out.println("Hire Date : " + employee.getHireDate());
////				System.out.println();
//				
//				// java bin�� �̿�(getter setter�� �̷���� ��, Employees.class)
//				employee.setFirstName(rSet.getString(1)); // 1�� ° �÷� ��
//				employee.setLastName(rSet.getString(2));
//				employee.setEmail(rSet.getString(3));
//				employee.setPhoneNumber(rSet.getString(4));
//				employee.setHireDate(rSet.getDate(5).toString()); // hire date�� Date Ÿ���̶� getString �Ұ���
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

		
		
		// ���ڵ� �κ�
//		HrDao dao = new HrDao();
//		dao.setDriver();

		HrDao dao = HrDao.getInstance(); // Singleton Pattern���� ���� ��
		
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
