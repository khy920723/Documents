package com.adacho.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.adacho.model.GeneralDTO;

public class HrB {

	private static HrB dao = new HrB(); // �̱��� �������� ����� �ڵ�, static ����
	private Connection conn;
	private ResultSet rSet;
	private PreparedStatement pStmt;
	
	private final String url = "jdbc:oracle:thin:@localhost:1521:xe"; // final: ���̻� �� �ٲٴ� ����� ���ٴ�
	private final String username = "c##hr";
	private final String password = "1234";
	
	private HrB() { // �̱��� �������� ����� �ڵ�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static HrB getInstance() {
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
	
	// b. ��� ���� �˻�(�Ի��)
//	�����ȣ        �̸�         ��                �μ�
//	===========================================================
	public List<GeneralDTO> getEmployeesHireDate(String hireDate){ // ��¥�� �޾Ƽ� ó��
		List<GeneralDTO> employees = new ArrayList<GeneralDTO>();
		
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
			GeneralDTO employee;
			
			while(rSet.next()) { // �� ���� �� �𸣴ϱ� while
				employee = new GeneralDTO();
				employee.setLong01(rSet.getLong(1)); // employee id
				employee.setString01(rSet.getString(2)); // first name
				employee.setString02(rSet.getString(3)); // last name
				employee.setString03(rSet.getString(4)); // department name
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
