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
	public List<Employee> getEmployees(String name){ // �̸��� �޾Ƽ� ó���ϰڴ�
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
				// ������ employee��ü�� employees�� ADD
				employees.add(employee);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		
		return employees; // ���ϰ��� �� ���ָ� ���� �� ��� ��
	}
	
}
