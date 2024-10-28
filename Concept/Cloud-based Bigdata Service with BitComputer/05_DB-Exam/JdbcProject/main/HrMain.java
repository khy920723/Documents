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

		String menuSelect; // ���� ȭ�� �޴� ���� ���� ����
		String name;
		String hireDate;
		String employeeID;
		Scanner sc = new Scanner(System.in);

//		�޴� ����!
//		===================================
//		a. ������� �˻�(�̸�)
//		b. ������� �˻�(�Ի��)
//		c. ���� �����̷� �˻�(���ID)
//		q. ����		
		while(true) {
			System.out.println("�޴� ����!");
			System.out.println("===================================");
			System.out.println("a. ������� �˻�(�̸�)");
			System.out.println("b. ������� �˻�(�Ի�⵵)");
			System.out.println("c. ���� �����̷� �˻�(���ID)");
			System.out.println("q. ����");
			menuSelect = sc.next();
			
			switch (menuSelect) {
			case "a":
				// public List<Employee> getEmployeesName(String name) ����κ�
				System.out.print("����� First name �Ǵ� Last name�� �Է��ϼ���: ");
				name = sc.next();
				
				HrA hrA = HrA.getInstance(); // Singleton Pattern���� ���� ��
				
				List<GeneralDTO> employeesA = new ArrayList<GeneralDTO>();
				employeesA = hrA.getEmployeesName(name);
				
				System.out.printf("%-30s", "�̸� ");
				System.out.printf("%-30s","�� ");
				System.out.printf("%-30s","�̸��� ");
				System.out.printf("%-30s","��ȭ ");
				System.out.printf("%-30s","�Ի��� ");
				System.out.println();
				System.out.print("=============================================================================================");
				System.out.println();
				if(employeesA.size() == 0) {
					System.out.println("�����Ͱ� �����ϴ�!");
					System.out.println();
					break;
				}
//				hireDate = sc.next();
				
//				   �̸�           ��                    �̸���             ��ȭ                         �Ի���
//				   =================================================================================================
//				        Susan        Mavris                  SMAVRIS          515.123.7777             2002-06-07
				for (GeneralDTO employee : employeesA) {
					System.out.printf("%-20s", employee.getString01() + " "); // �̸�
					System.out.printf("%-20s",employee.getString02() + " "); // ��
					System.out.printf("%-20s",employee.getString03() + " "); // �̸���
					System.out.printf("%-20s",employee.getString04() + " "); // ��ȭ
					System.out.printf("%-20s",employee.getString05() + " "); // �̸���
					System.out.println();
				}
				System.out.println();
				break;
				
				
			case "b":
				// public List<Employee> getEmployeesHireDate(String hireDate) ����κ�
				System.out.print("�Ի�⵵�� �Է��ϼ���: ");
				hireDate = sc.next();
				
				HrB hrB = HrB.getInstance(); // Singleton Pattern���� ���� ��
				
				List<GeneralDTO> employeesB = new ArrayList<GeneralDTO>();
				employeesB = hrB.getEmployeesHireDate(hireDate);
				
				System.out.printf("%-30s","�����ȣ ");
				System.out.printf("%-30s","�̸� ");
				System.out.printf("%-30s","�� ");
				System.out.printf("%-30s","�μ� ");
				System.out.println();
				System.out.print("=============================================================================================");
				System.out.println();
				
				if(employeesB.size() == 0) {
					System.out.println("�����Ͱ� �����ϴ�!");
					System.out.println();
					break;
				}
//				hireDa
//				hireDate = sc.next();
				
//				�����ȣ        �̸�         ��                �μ�
//				===========================================================
//				  104         Bruce          Ernst                    IT
//				  107         Diana        Lorentz                    IT
//				  113          Luis           Popp               Finance
				for (GeneralDTO employee : employeesB) {
//					employee.setEmployeeID(rSet.getLong(1)); // 1�� ° �÷� ��
//					employee.setFirstName(rSet.getString(2));
//					employee.setLastName(rSet.getString(3));
//					employee.setDepartmentName(rSet.getString(3));
					System.out.printf("%-20s",employee.getLong01() + " "); // �����ȣ
					System.out.printf("%-20s",employee.getString01() + " "); // �̸�
					System.out.printf("%-20s",employee.getString02() + " "); // ��
					System.out.printf("%-20s",employee.getString03() + " "); // �μ��̸�
					System.out.println();
				}
				System.out.println();
				break;
				
			case "c":
				// public List<Employee> getEmployeesID(String name) ����κ�
				System.out.print("�����ȣ�� �Է��ϼ���: ");
				employeeID = sc.next();
				
				HrC hrC = HrC.getInstance(); // Singleton Pattern���� ���� ��
				
				List<GeneralDTO> employeesC = new ArrayList<GeneralDTO>();
				employeesC = hrC.getEmployeesID(employeeID);
				
				System.out.printf("%-30s","�̸� ");
				System.out.printf("%-30s","������ ");
				System.out.printf("%-30s","������ ");
				System.out.printf("%-30s","������ ");
				System.out.println();
				System.out.print("=============================================================================================");
				System.out.println();
				
				if(employeesC.size() == 0) {
					System.out.println("�����Ͱ� �����ϴ�!");
					System.out.println();
					break;
				}
//				hireDa
//				hireDate = sc.next();
				
//		        �̸�                    ������                ������                  ������
//		        =================================================================================================
//		             Jennifer Whalen    Administration Assistant     1995-09-17 00:00:00       2001-06-17 00:00:00
//		             Jennifer Whalen       Public Accountant     2002-07-01 00:00:00       2006-12-31 00:00:00
				for (GeneralDTO employee : employeesC) {
//					employee.setFirstName(rSet.getString(1)); // 1�� ° �÷� ��
//					employee.setJobTitle(rSet.getString(2));
//					employee.setStartDate(rSet.getString(3));
//					employee.setEndDate(rSet.getString(4));
					System.out.printf("%-20s",employee.getString01() + employee.getString02() + " "); // �̸�
					System.out.printf("%-20s",employee.getString03() + " "); // ������
					System.out.printf("%-20s",employee.getString04() + " "); // ������
					System.out.printf("%-20s",employee.getString05() + " "); // ������
					System.out.println();
				}
				System.out.println();
				break;
				
			case "q":
				// public List<Employee> Exit(String name) ����κ�
				System.out.print("���α׷� ����!!");
				System.exit(0);
				
				
			default: // ������ ���� ����ġ �ϸ� default ���๮ �۵�
				System.out.println("�߸� �����ϼ̽��ϴ�. �ٽ� �����ϼ���!!");
			}
		}
		
		// ���ڵ� �κ�
//		HrDao dao = new HrDao();
//		dao.setDriver();
//		HrDao dao = HrDao.getInstance(); // Singleton Pattern���� ���� ��
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
