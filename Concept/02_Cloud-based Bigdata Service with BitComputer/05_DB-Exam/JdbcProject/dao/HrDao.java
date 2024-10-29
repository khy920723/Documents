package com.adacho.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.adacho.model.Employee;

public class HrDao {
	
	private static HrDao dao = new HrDao(); // �̱��� �������� ����� �ڵ�, static ����
	private Connection conn;
	private ResultSet rSet;
	private PreparedStatement pStmt;
	
	private final String url = "jdbc:oracle:thin:@localhost:1521:xe"; // final: ���̻� �� �ٲٴ� ����� ���ٴ�
	private final String username = "c##hr";
	private final String password = "1234";
	
	private HrDao() { // �̱��� �������� ����� �ڵ�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static HrDao getInstance() {
		return dao;
	}
	
//	public void setDriver() { // �̱����� �ƴ� �Ϲ� ���ڵ�
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	private void getConnection(){
		try{
			conn = DriverManager.getConnection(url, username, password);// ���ο��� ���� ������ private
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
	
	// HrMain���� ������ �κа� ���Ͽ� �̷������� ������ �� �ִٴ� ���� ����
	// a. ��� ���� �˻�(�̸�)
//	   �̸�           ��                    �̸���             ��ȭ                         �Ի���
//	   =================================================================================================
//	        Bruce         Ernst                   BERNST          590.423.4568             2007-05-21
	public List<Employee> getEmployeesName(String name){ // �̸��� �޾Ƽ� ó���ϰڴ�
		List<Employee> employees = new ArrayList<Employee>();
		
		getConnection();
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE "); // �� ĭ�� ���� ���������� ������ �ȳ��Ƿ�(cmdó��)
		sb.append("FROM EMPLOYEES ");
		sb.append("WHERE FIRST_NAME LIKE  ? OR LAST_NAME LIKE ?"); // ?�� ���ڰ� ���� ��
		
		String sql = sb.toString();
		
		try {
			// HrMain���� ������ �κа� ���Ͽ� �̷������� ������ �� �ִٴ� ���� ����
			pStmt = conn.prepareStatement(sql); // �������� �־��ָ� ��ü�� ����� ���۷����� ������
			pStmt.setString(1, "%" + name + "%"); // ?�� ���� �־���
			pStmt.setString(2, "%" + name + "%");// ������ ��Ʈ�� Ÿ���̴ϱ� , ���� 1 �ڰ� 2
			
			rSet = pStmt.executeQuery(); // �̷��� ����
			Employee employee;
			
			while(rSet.next()) { // �� ���� �� �𸣴ϱ� while
				employee = new Employee();
				employee.setFirstName(rSet.getString(1)); // 1�� ° �÷� ��
				employee.setLastName(rSet.getString(2));
				employee.setEmail(rSet.getString(3));
				employee.setPhoneNumber(rSet.getString(4));
				employee.setHireDate(rSet.getDate(5).toString()); // hire date�� Date Ÿ���̶� getString �Ұ���
				employees.add(employee); // ������ employee��ü�� employees�� ADD
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		
		return employees; // ���ϰ��� �� ���ָ� ���� �� ��� ��
	}
	
	
	// b. ��� ���� �˻�(�Ի��)
//	�����ȣ        �̸�         ��                �μ�
//	===========================================================
	public List<Employee> getEmployeesHireDate(String hireDate){ // ��¥�� �޾Ƽ� ó��
		List<Employee> employees = new ArrayList<Employee>();
		
		getConnection();
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT E.EMPLOYEE_ID, E.FIRST_NAME, E.LAST_NAME, NVL(D.DEPARTMENT_NAME, '<Not Assigned>') AS DEPT_NAME "); // �� ĭ�� ���� ���������� ������ �ȳ��Ƿ�(cmdó��)
		sb.append("FROM EMPLOYEES E LEFT OUTER JOIN DEPARTMENTS D ");
		sb.append("ON E.DEPARTMENT_ID = D.DEPARTMENT_ID ");
		sb.append("WHERE TO_CHAR(E.HIRE_DATE, 'YYYY') = ? ");
		sb.append("ORDER BY E.EMPLOYEE_ID");
		
		String sql = sb.toString();
		
		try {
			// HrMain���� ������ �κа� ���Ͽ� �̷������� ������ �� �ִٴ� ���� ����
			pStmt = conn.prepareStatement(sql); // �������� �־��ָ� ��ü�� ����� ���۷����� ������
			pStmt.setString(1, hireDate); // ?�� ���� �־���
			
			rSet = pStmt.executeQuery(); // �̷��� ����
			Employee employee;
			
			while(rSet.next()) { // �� ���� �� �𸣴ϱ� while
				employee = new Employee();
				employee.setEmployeeID(rSet.getLong(1)); // 1�� ° �÷� ��
				employee.setFirstName(rSet.getString(2));
				employee.setLastName(rSet.getString(3));
				employee.setDepartmentName(rSet.getString(4));
				employees.add(employee); // ������ employee��ü�� employees�� ADD
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		
		return employees; // ���ϰ��� �� ���ָ� ���� �� ��� ��
	}
	

	// c. ���� �����̷� �˻�(���ID)
//    �̸�                    ������                ������                  ������
//=================================================================================================
	public List<Employee> getEmployeesID(Long employeeID){ // �̸��� �޾Ƽ� ó���ϰڴ�
		List<Employee> employees = new ArrayList<Employee>();
		
		getConnection();
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT E.FIRST_NAME, J.JOB_TITLE, JH.START_DATE, JH.END_DATE "); // �� ĭ�� ���� ���������� ������ �ȳ��Ƿ�(cmdó��)
		sb.append("FROM EMPLOYEES E JOIN JOB_HISTORY JH ");
		sb.append("ON E.EMPLOYEE_ID = JH.EMPLOYEE_ID JOIN JOBS J ");
		sb.append("ON JH.JOB_ID = J.JOB_ID ");
		sb.append("WHERE E.EMPLOYEE_ID = ?"); // ?�� ���ڰ� ���� ��
		
		String sql = sb.toString();
		
		try {
			// HrMain���� ������ �κа� ���Ͽ� �̷������� ������ �� �ִٴ� ���� ����
			pStmt = conn.prepareStatement(sql); // �������� �־��ָ� ��ü�� ����� ���۷����� ������
			pStmt.setLong(1, employeeID); // ?�� ���� �־���
			
			rSet = pStmt.executeQuery(); // �̷��� ����
			Employee employee;
			
			while(rSet.next()) { // �� ���� �� �𸣴ϱ� while
				employee = new Employee();
				employee.setFirstName(rSet.getString(1)); // 1�� ° �÷� ��
				employee.setJobTitle(rSet.getString(2));
				employee.setStartDate(rSet.getString(3));
				employee.setEndDate(rSet.getString(4));
				employees.add(employee); // ������ employee��ü�� employees�� ADD
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		
		return employees; // ���ϰ��� �� ���ָ� ���� �� ��� ��
	}
}
