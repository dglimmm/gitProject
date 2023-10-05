package com.kh.personalP2.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.personalP2.Dao.EmployeeDao;
import com.kh.personalP2.template.JDBCTemplate;
import com.kh.personalP2.view.EmployeeMenu;
import com.kh.personalP2.vo.Employee;
import com.kh.personalP2.vo.ReservationLog;
import com.kh.personalP2.vo.Room;

public class EmpService {
	//로그인 정보 담기위한 스태틱 변수
	static Employee logindata;

	//관리자 로그인
	public Employee admLogin(String empId,String empPwd) {
		Connection conn = JDBCTemplate.getConnection();
		
		logindata = new EmployeeDao().admLogin(conn, empId,empPwd);
		JDBCTemplate.close(conn);
		
		return logindata;
	}
	//회원 로그인 
	public Employee empLogin(String empId,String empPwd) {
		Connection conn = JDBCTemplate.getConnection();
		
		logindata = new EmployeeDao().empLogin(conn, empId,empPwd);
		JDBCTemplate.close(conn);
		
		return logindata;
	}
	
	// 아이디로 정보 조회
	public Employee selectById() {
		Connection conn = JDBCTemplate.getConnection();
		
		Employee e = new EmployeeDao().selectById(conn, logindata);
		JDBCTemplate.close(conn);
		
		return e;
	}
	
	//회원 정보 업데이트
	public int updateEmployee(Employee e) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new EmployeeDao().updateEmployee(conn, logindata, e);
		if(result >0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}
	//관리자가 회원 수정
	public int updateEmployeeAdm( Employee e) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new EmployeeDao().updateEmployeeAdm(conn,e);
		if(result >0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}
	
	//회원 탈퇴
	public int deleteEmployee() {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new EmployeeDao().deleteEmployee(conn,logindata);
		
		if(result >0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	//관리자가 회원 탈퇴시키는 메소드
	public int deleteEmployeeAdm(String tmp) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new EmployeeDao().deleteEmployeeAdm(conn,tmp);
		
		if(result >0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	//회원 추가
	public int insertEmployee(Employee e) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new EmployeeDao().insertEmployee(conn,e);
		if(result >0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	
	public ArrayList<Employee> selectList(){
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Employee> list = new EmployeeDao().selectList(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	//회의실 정보 가져오는 메소드
	public ArrayList<Room> selectRoom(){
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Room> list = new EmployeeDao().selectRoom(conn);
		JDBCTemplate.close(conn);
		
		return list;
	}
	//회의실 예약 메소드
	public int reservationRoom(String roomName) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new EmployeeDao().reservationRoom(conn,logindata, roomName);
		if(result == 100) {
			System.out.println("회의실 예약에 실패하였습니다. \n 회의실 STATUS가 Y인 회의실을 예약해주세요.");
		}else if(result >0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
		
	}
	
	//관리자가 회의실예약 대기인 회의실 보는 메소드 
	public ArrayList<ReservationLog> selectRoomLog() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<ReservationLog> list = new EmployeeDao().selectRoomLog(conn);
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	//관리자가 예약 대기인 회의실을 예약 확정시키는 메소드
	public int confirmRoom(String roomName){
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new EmployeeDao().confirmRoom(conn, roomName);
		if(result >0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}
	//회원이 회의실 예약을 반납하는 메소드
	public int returnRoom(String Rn) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new EmployeeDao().returnRoom(conn,logindata, Rn);
		if(result >0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
		
	}
	
	//회원이 자신이 신청한 회의실 예약 확정 상태를 볼 수 있는 메소드
	public ArrayList<ReservationLog> selectConfirmRoom() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<ReservationLog> list = new EmployeeDao().selectConfirmRoom(conn,logindata);
		JDBCTemplate.close(conn);
		
		return list;
	}
	
}
