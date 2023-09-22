package com.kh.personalP2.vo;

public class Employee {
	private int empNo;
	private String empGrade;
	private String empId;	
	private String empPwd;	
	private String name ;
	private String gender;
	private	String phone;
	private String dept;
	private int salary;
	private double bonus;
	
	public Employee() {
		
	}
	public Employee(int empNo,String name,String gender,String phone) {
		this.empNo=empNo;
		this.name=name;
		this.gender=gender;
		this.phone=phone;
	
	}
	public Employee(int empNo, String empGrade, String empId, String empPwd, String name, String gender, String phone,
			String dept, int salary, double bonus) {
		super();
		this.empNo = empNo;
		this.empGrade = empGrade;
		this.empId = empId;
		this.empPwd = empPwd;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.dept = dept;
		this.salary = salary;
		this.bonus = bonus;
	}
	
	public Employee(String empGrade, String empId, String empPwd, String name, String gender, String phone, String dept,
			int salary, double bonus) {
		super();
		this.empGrade = empGrade;
		this.empId = empId;
		this.empPwd = empPwd;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.dept = dept;
		this.salary = salary;
		this.bonus = bonus;
	}
	public String getEmpGrade() {
		return empGrade;
	}
	public void setEmpGrade(String empGrade) {
		this.empGrade = empGrade;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpPwd() {
		return empPwd;
	}
	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}
	public Employee(int empNo,String name,String gender,String phone,String dept,int salary,double bonus) {
		this.empNo = empNo;
		this.name=name;
		this.gender=gender;
		this.phone=phone;
		this.dept=dept;
		this.salary=salary;
		this.bonus=bonus;
	}
	public Employee(String name,String gender,String phone,String dept,int salary,double bonus) {
		
		this.name=name;
		this.gender=gender;
		this.phone=phone;
		this.dept=dept;
		this.salary=salary;
		this.bonus=bonus;
	}
	
	public void setEmpNo(int empNo) {
		this.empNo=empNo;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setGender(String gender) {
		this.gender=gender;
	}
	public void setPhone(String phone) {
		this.phone=phone;
	}
	public void setDept(String dept) {
		this.dept=dept;
	}
	public void setSalary(int salary) {
		this.salary=salary;
	}
	public void setBonus(double bonus) {
		this.bonus=bonus;
	}
	
	public int getEmpNo() {
		return empNo;
	}
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public String getPhone() {
		return phone;
	}
	public String getDept() {
		return dept;
	}
	public int getSalary() {
		return salary;
	}
	public double getBonus() {
		return bonus;
	}
	
	@Override
	public String toString() {
		return "empNo=" + empNo + ", empGrade=" + empGrade + ", empId=" + empId + ", empPwd=" + empPwd
				+ ", name=" + name + ", gender=" + gender + ", phone=" + phone + ", dept=" + dept + ", salary=" + salary
				+ ", bonus=" + bonus ;
	}

	
}
