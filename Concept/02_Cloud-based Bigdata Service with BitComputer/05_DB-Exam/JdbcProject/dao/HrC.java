package com.adacho.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.adacho.model.GeneralDTO;

public class HrC {

	private static HrC dao = new HrC(); // �̱��� �������� ����� �ڵ�, static ����
	private Connection conn;
	private ResultSet rSet;
	private PreparedStatement pStmt;
	
	private final String url = "jdbc:oracle:thin:@localhost:1521:xe"; // final: ���̻� �� �ٲٴ� ����� ���ٴ�
	private final String username = "c##hr";
	private final String password = "1234";
	
	private HrC() { // �̱��� �������� ����� �ڵ�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static HrC getInstance() {
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
	
	// c. ���� �����̷� �˻�(���ID)
//  �̸�                    ������                ������                  ������
//=================================================================================================
	public List<GeneralDTO> getEmployeesID(String employeeID){ // �̸��� �޾Ƽ� ó���ϰڴ�
		List<GeneralDTO> employees = new ArrayList<GeneralDTO>();
		
		getConnection();
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT E.FIRST_NAME, E.LAST_NAME, J.JOB_TITLE, JH.START_DATE, JH.END_DATE "); // �� ĭ�� ���� ���������� ������ �ȳ��Ƿ�(cmdó��)
		sb.append("FROM EMPLOYEES E JOIN JOB_HISTORY JH ");
		sb.append("ON E.EMPLOYEE_ID = JH.EMPLOYEE_ID JOIN JOBS J ");
		sb.append("ON JH.JOB_ID = J.JOB_ID ");
		sb.append("WHERE E.EMPLOYEE_ID = ?"); // ?�� ���ڰ� ���� ��
		
		String sql = sb.toString();
		
		try {
			// HrMain���� ������ �κа� ���Ͽ� �̷������� ������ �� �ִٴ� ���� ����
			pStmt = conn.prepareStatement(sql); // �������� �־��ָ� ��ü�� ����� ���۷����� ������
			pStmt.setString(1, employeeID); // ?�� ���� �־���
			
			rSet = pStmt.executeQuery(); // �̷��� ����
			GeneralDTO employee;
			
			while(rSet.next()) { // �� ���� �� �𸣴ϱ� while
				employee = new GeneralDTO();
				employee.setString01(rSet.getString(1)); // first name
				employee.setString02(rSet.getString(2)); // last name
				employee.setString03(rSet.getString(3)); // job title 
				employee.setString04(rSet.getString(4)); // start date
				employee.setString05(rSet.getString(5)); // end date
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
