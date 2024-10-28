package com.adacho.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.adacho.model.GeneralDTO;

public class HrA {

	private static HrA dao = new HrA(); // �̱��� �������� ����� �ڵ�, static ����
	private Connection conn;
	private ResultSet rSet;
	private PreparedStatement pStmt;
	
	private final String url = "jdbc:oracle:thin:@localhost:1521:xe"; // final: ���̻� �� �ٲٴ� ����� ���ٴ�
	private final String username = "c##hr";
	private final String password = "1234";
	
	private HrA() { // �̱��� �������� ����� �ڵ�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static HrA getInstance() {
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
	public List<GeneralDTO> getEmployeesName(String name){ // �̸��� �޾Ƽ� ó���ϰڴ�
		List<GeneralDTO> employees= new ArrayList<GeneralDTO>();
		
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
			GeneralDTO employee;
			
			while(rSet.next()) { // �� ���� �� �𸣴ϱ� while
				employee = new GeneralDTO();
				employee.setString01(rSet.getString(1)); // first name
				employee.setString02(rSet.getString(2)); // last name
				employee.setString03(rSet.getString(3)); // email
				employee.setString04(rSet.getString(4)); // phone number
				employee.setString05(rSet.getDate(5).toString()); // hire date, Date�� �޾ƿ� String���� ��ȯ
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
