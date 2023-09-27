package com.kh.personalP2.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.personalP2.Dao.EmployeeDao;
import com.kh.personalP2.template.JDBCTemplate;
import com.kh.personalP2.vo.Employee;
import com.kh.personalP2.vo.ReservationLog;
import com.kh.personalP2.vo.Room;

public class EmpService {
	static Employee logindata;

	
	public Employee admLogin(String empId,String empPwd) {
		Connection conn = JDBCTemplate.getConnection();
		
		logindata = new EmployeeDao().admLogin(conn, empId,empPwd);
		JDBCTemplate.close(conn);
		
		return logindata;
	}
	public Employee empLogin(String empId,String empPwd) {
		Connection conn = JDBCTemplate.getConnection();
		
		logindata = new EmployeeDao().empLogin(conn, empId,empPwd);
		JDBCTemplate.close(conn);
		
		return logindata;
	}
	
	public Employee selectById() {
		Connection conn = JDBCTemplate.getConnection();
		
		Employee e = new EmployeeDao().selectById(conn, logindata);
		JDBCTemplate.close(conn);
		
		return e;
	}
	
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
	
	public ArrayList<Room> selectRoom(){
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Room> list = new EmployeeDao().selectRoom(conn);
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	public int reservationRoom(String roomName) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new EmployeeDao().reservationRoom(conn,logindata, roomName);
		if(result >0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
		
	}
	
	public ArrayList<ReservationLog> selectRoomLog() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<ReservationLog> list = new EmployeeDao().selectRoomLog(conn);
		JDBCTemplate.close(conn);
		
		return list;
	}
	
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
	
	public ArrayList<ReservationLog> selectConfirmRoom() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<ReservationLog> list = new EmployeeDao().selectConfirmRoom(conn,logindata);
		JDBCTemplate.close(conn);
		
		return list;
	}
	
}
