package com.kh.personalP2.controller;

import java.util.ArrayList;

import com.kh.personalP2.service.EmpService;
import com.kh.personalP2.view.EmployeeMenu;
import com.kh.personalP2.vo.Employee;
import com.kh.personalP2.vo.ReservationLog;
import com.kh.personalP2.vo.Room;

public class EmployeeController {
	
	
	public void admLogin(String empId, String empPwd) {
		
		Employee a = new EmpService().admLogin(empId,empPwd);
		
		if(a == null) {
			new EmployeeMenu().displayLoginFail("로그인에 실패하였습니다.");
		}else {
			if(a.getEmpGrade().charAt(0)=='A') {
				new EmployeeMenu().adminLoginSuccess(a);
			}else {
			new EmployeeMenu().displayAdmLoginFail("관리자 회원이 아닙니다. 로그인에 실패했습니다.");
			}
		}

	}
	
	public void empLogin(String empId, String empPwd) {
		
		Employee e = new EmpService().admLogin(empId,empPwd);
		
		if(e == null) {
			new EmployeeMenu().displayLoginFail("로그인에 실패하였습니다.");
		}else {
				new EmployeeMenu().empLoginSuccess(e);
			}
		
	}
	
	public void selectById(Employee a) {
		Employee e = new EmpService().selectById(a);
		
		if(e == null) {
			new EmployeeMenu().displayNoData(a.getEmpId() + "으로 조회된 회원이 없습니다.");
		}else {
			new EmployeeMenu().displayEmployee(e);
		}
	}
	
	public void updateEmployee(Employee a,String phone,String dept,int salary,double bonus) {
		Employee e = new Employee();
		e.setPhone(phone);
		e.setDept(dept);
		e.setSalary(salary);
		e.setBonus(bonus);
		
		int result = new EmpService().updateEmployee(a, e);
		
		if(result > 0) {
			new EmployeeMenu().displaySuccess("성공적으로 수정되었습니다.");
		}else {
			new EmployeeMenu().displayFail("해당하는 회원이 없어 회원정보수정에 실패했습니다.");
		}
	}
	public void updateEmployeeAdm(String empId,String phone,String dept,int salary,double bonus) {
		Employee e = new Employee();
		e.setEmpId(empId);
		e.setPhone(phone);
		e.setDept(dept);
		e.setSalary(salary);
		e.setBonus(bonus);
		
		int result = new EmpService().updateEmployeeAdm(e);
		
		if(result > 0) {
			new EmployeeMenu().displaySuccess("성공적으로 수정되었습니다.");
		}else {
			new EmployeeMenu().displayFail("해당하는 회원이 없어 회원정보수정에 실패했습니다.");
		}
	}
	
	public void deleteEmployee(Employee a) {
		int result = new EmpService().deleteEmployee(a);
		
		if(result > 0) {
			new EmployeeMenu().displaySuccess("회원 탈퇴에 성공하였습니다.");
		}else {
			new EmployeeMenu().displayFail("회원 탈퇴에 실패했습니다.");
		}
		
	}
	public void deleteEmployeeAdm(String tmp) {
		int result = new EmpService().deleteEmployeeAdm(tmp);
		
		if(result > 0) {
			new EmployeeMenu().displaySuccess("회원 탈퇴에 성공하였습니다.");
		}else {
			new EmployeeMenu().displayFail("회원 탈퇴에 실패했습니다.");
		}
		
	}
	
	public void insertEmployee(String empGrade,String empId,String empPwd, String name,String gender,String phone,String dept,String salary,String bonus) {
		Employee e = new Employee(empGrade,empId,empPwd,name,gender,phone,dept,Integer.parseInt(salary),Double.parseDouble(bonus));
		
		int result = new EmpService().insertEmployee(e);
		
		if(result > 0) {
			new EmployeeMenu().displaySuccess("회원이 정상적으로 추가되었습니다.");
		}else {
			new EmployeeMenu().displayFail("회원 추가에 실패하였습니다.");
		}
	}
	
	public void selectList() {
		ArrayList<Employee> list = new EmpService().selectList();
		
		if(list.isEmpty()) {
			new EmployeeMenu().displayNoData("전체 조회 결과가 없습니다.");
		}else {
			new EmployeeMenu().displayEmployeeList(list);
		}
	}
	
	public void selectRoom() {
		ArrayList<Room> list = new EmpService().selectRoom();
		
		if(list.isEmpty()) {
			new EmployeeMenu().displayNoData("전체 조회 결과가 없습니다.");
		}else {
			new EmployeeMenu().displayRoomList(list);
		}		
	}
	
	public void reservationRoom(Employee a, String roomName) {
		int result = new EmpService().reservationRoom(a,roomName);
		
		if(result > 0) {
			new EmployeeMenu().displaySuccess("회의실예약 신청이 완료되었습니다.\n 관리자가 승인하면 예약이 확정됩니다.");
		}else {
			new EmployeeMenu().displayFail("회의실 예약에 실패하였습니다. \n 회의실 이름을 확인해주세요.");
		}
	}
	
	public void selectRoomLog() {
		ArrayList<ReservationLog> list = new EmpService().selectRoomLog();
		
		if(list.isEmpty()) {
			new EmployeeMenu().displayNoData("회의실 예약 대기 목록이 없습니다.");
		}else {
			new EmployeeMenu().displayRoomLogList(list);
		}	
	}
	
	public void confirmRoom(String roomName) {
		int result = new EmpService().confirmRoom(roomName);
		
		if(result > 0) {
			new EmployeeMenu().displaySuccess(roomName + "이 예약확정되었습니다.");
		}else {
			new EmployeeMenu().displayFail("예약확정하지 못했습니다.");
		}
	}
	
	
	
	
	
}
