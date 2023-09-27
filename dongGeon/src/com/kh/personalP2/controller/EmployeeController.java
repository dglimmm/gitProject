package com.kh.personalP2.controller;

import java.util.ArrayList;

import com.kh.personalP2.service.EmpService;
import com.kh.personalP2.view.EmployeeMenu;
import com.kh.personalP2.vo.Employee;
import com.kh.personalP2.vo.ReservationLog;
import com.kh.personalP2.vo.Room;

public class EmployeeController {
	
	
	/**
	 * 입력받음 아이디 패스워드 서비스로 보냄 
	 * @param empId (아이디)
	 * @param empPwd (패스워드) 
	 */
	public void admLogin(String empId, String empPwd) {
		
		Employee a = new EmpService().admLogin(empId,empPwd);
		
		if(a == null) {
			new EmployeeMenu().displayLoginFail("로그인에 실패하였습니다.");
		}else {
			if(a.getEmpGrade().charAt(0)=='A') {
				new EmployeeMenu().adminLoginSuccess();
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
				new EmployeeMenu().empLoginSuccess();
			}
		
	}
	
	public void selectById() {
		Employee e = new EmpService().selectById();
		
		if(e == null) {
			new EmployeeMenu().displayNoData("조회된 회원이 없습니다.");
		}else {
			new EmployeeMenu().displayEmployee(e);
		}
	}
	
	public void updateEmployee(String phone,String dept,int salary,double bonus) {
		Employee e = new Employee();
		e.setPhone(phone);
		e.setDept(dept);
		e.setSalary(salary);
		e.setBonus(bonus);
		
		int result = new EmpService().updateEmployee(e);
		
		if(result > 0) {
			new EmployeeMenu().displaySuccess("성공적으로 수정되었습니다.");
		}else {
			new EmployeeMenu().displayFail("해당하는 회원이 없어 회원정보수정에 실패했습니다.");
		}
	}
	/**
	 * 입력받은 인자로 사원정보 수정
	 * @param empId
	 * @param phone
	 * @param dept
	 * @param salary
	 * @param bonus
	 */
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
	
	public void deleteEmployee() {
		int result = new EmpService().deleteEmployee();
		
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
	
	/**
	 * 입력받은 룸네임으로 회의실 예약
	 * @param a
	 * @param roomName
	 */
	public void reservationRoom(String roomName) {
		int result = new EmpService().reservationRoom(roomName);
		
		if(result > 0) {
			new EmployeeMenu().displaySuccess("회의실예약 신청이 완료되었습니다.\n 관리자가 승인하면 예약이 확정됩니다.");
		}else {
			new EmployeeMenu().displayFail("회의실 예약에 실패하였습니다. \n 회의실 이름을 확인해주세요.");
		}
	}
	
	/**
	 * 회의실 예약 대기목록 출력
	 */
	public void selectRoomLog() {
		ArrayList<ReservationLog> list = new EmpService().selectRoomLog();
		
		if(list.isEmpty()) {
			new EmployeeMenu().displayNoData("회의실 예약 대기 목록이 없습니다.");
		}else {
			new EmployeeMenu().displayRoomLogList(list);
		}	
	}
	
	/**
	 * 회의실 이름받고 예약 확정
	 * @param roomName
	 */
	public void confirmRoom(String roomName) {
		int result = new EmpService().confirmRoom(roomName);
		
		if(result > 0) {
			new EmployeeMenu().displaySuccess(roomName + "이 예약확정되었습니다.");
		}else {
			new EmployeeMenu().displayFail("없는 회의실 이름이거나 예약이 이미 확정되어있습니다.");
		}
	}
	
	/**
	 * 예약한 회원이 회의실 반납
	 * @param a
	 * @param Rn
	 */
	public void returnRoom(String Rn) {
		int result = new EmpService().returnRoom(Rn);
		
		if(result > 0) {
			new EmployeeMenu().displaySuccess("회의실반납이 완료되었습니다.\n 이용해주셔서 감사합니다.");
		}else {
			new EmployeeMenu().displayFail("회의실 반납에 실패하였습니다. \n 회의실 이름을 또는 본인이 예약한 회의실인지 확인해주세요.");
		}
	}
	
	/**
	 * 회원이 예약 확정목록 보기
	 * @param a
	 */
	public void selectConfirmRoom() {
		ArrayList<ReservationLog> list = new EmpService().selectConfirmRoom();
		
		if(list.isEmpty()) {
			new EmployeeMenu().displayNoData("예약 확정된 회의실이 없습니다.");
		}else {
			new EmployeeMenu().displayConfirmLogList(list);
		}	
	}
	
	
}
