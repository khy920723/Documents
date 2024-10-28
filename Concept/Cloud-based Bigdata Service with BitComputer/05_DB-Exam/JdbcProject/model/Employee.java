package com.adacho.model;

public class Employee {

// EMPLOYEES TABLE
//	 이름                                      널?      유형
//			 ----------------------------------------- -------- ----------------------------
//			 EMPLOYEE_ID                               NOT NULL NUMBER(6)
//			 FIRST_NAME                                         VARCHAR2(20)
//			 LAST_NAME                                 NOT NULL VARCHAR2(25)
//			 EMAIL                                     NOT NULL VARCHAR2(25)
//			 PHONE_NUMBER                                       VARCHAR2(20)
//			 HIRE_DATE                                 NOT NULL DATE
//			 JOB_ID                                    NOT NULL VARCHAR2(10)
//			 SALARY                                             NUMBER(8,2)
//			 COMMISSION_PCT                                     NUMBER(2,2)
//			 MANAGER_ID                                         NUMBER(6)
//			 DEPARTMENT_ID                                      NUMBER(4)	
	private Long employeeID;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String hireDate;
	private String jobID;
	private Double salary;
	private Double commission;
	private Long managerID;
	private Long departmentID;
	
// DEPARTMENTS TABLE
//	 이름                                      널?      유형
//	 ----------------------------------------- -------- ----------------------------
//	 DEPARTMENT_ID                             NOT NULL NUMBER(4)
//	 DEPARTMENT_NAME                           NOT NULL VARCHAR2(30)
//	 MANAGER_ID                                         NUMBER(6)
//	 LOCATION_ID                                        NUMBER(4)	
	private String departmentName;
	private Long locationID;
	
// JOBHISTORY TABLE
//	 이름                                      널?      유형
//	 ----------------------------------------- -------- ----------------------------
//	 EMPLOYEE_ID                               NOT NULL NUMBER(6)
//	 START_DATE                                NOT NULL DATE
//	 END_DATE                                  NOT NULL DATE
//	 JOB_ID                                    NOT NULL VARCHAR2(10)
//	 DEPARTMENT_ID                                      NUMBER(4)
	private String startDate;
	private String endDate;

// JOBS TABLE
//	 이름                                      널?      유형
//	 ----------------------------------------- -------- ----------------------------
//	 JOB_ID                                    NOT NULL VARCHAR2(10)
//	 JOB_TITLE                                 NOT NULL VARCHAR2(35)
//	 MIN_SALARY                                         NUMBER(6)
//	 MAX_SALARY                                         NUMBER(6)
	private String jobTitle;
	private Long minSalary;
	private Long maxSalary;
	
	/**
	 * @return the employeeID
	 */
	public Long getEmployeeID() {
		return employeeID;
	}
	/**
	 * @param employeeID the employeeID to set
	 */
	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the hireDate
	 */
	public String getHireDate() {
		return hireDate;
	}
	/**
	 * @param hireDate the hireDate to set
	 */
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	/**
	 * @return the jobID
	 */
	public String getJobID() {
		return jobID;
	}
	/**
	 * @param jobID the jobID to set
	 */
	public void setJobID(String jobID) {
		this.jobID = jobID;
	}
	/**
	 * @return the salary
	 */
	public Double getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	/**
	 * @return the commission
	 */
	public Double getCommission() {
		return commission;
	}
	/**
	 * @param commission the commission to set
	 */
	public void setCommission(Double commission) {
		this.commission = commission;
	}
	/**
	 * @return the managerID
	 */
	public Long getManagerID() {
		return managerID;
	}
	/**
	 * @param managerID the managerID to set
	 */
	public void setManagerID(Long managerID) {
		this.managerID = managerID;
	}
	/**
	 * @return the departmentID
	 */
	public Long getDepartmentID() {
		return departmentID;
	}
	/**
	 * @param departmentID the departmentID to set
	 */
	public void setDepartmentID(Long departmentID) {
		this.departmentID = departmentID;
	}
	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}
	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	/**
	 * @return the locationID
	 */
	public Long getLocationID() {
		return locationID;
	}
	/**
	 * @param locationID the locationID to set
	 */
	public void setLocationID(Long locationID) {
		this.locationID = locationID;
	}
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return jobTitle;
	}
	/**
	 * @param jobTitle the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	/**
	 * @return the minSalary
	 */
	public Long getMinSalary() {
		return minSalary;
	}
	/**
	 * @param minSalary the minSalary to set
	 */
	public void setMinSalary(Long minSalary) {
		this.minSalary = minSalary;
	}
	/**
	 * @return the maxSalary
	 */
	public Long getMaxSalary() {
		return maxSalary;
	}
	/**
	 * @param maxSalary the maxSalary to set
	 */
	public void setMaxSalary(Long maxSalary) {
		this.maxSalary = maxSalary;
	}

		
}
