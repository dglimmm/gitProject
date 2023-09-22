package com.kh.personalP2.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.personalP2.Dao.EmployeeDao;
import com.kh.personalP2.template.JDBCTemplate;
import com.kh.personalP2.vo.Employee;
import com.kh.personalP2.vo.ReservationLog;
import com.kh.personalP2.vo.Room;

public class EmpService {

	
	public Employee admLogin(String empId,String empPwd) {
		Connection conn = JDBCTemplate.getConnection();
		
		Employee e = new EmployeeDao().admLogin(conn, empId,empPwd);
		JDBCTemplate.close(conn);
		
		return e;
	}
	public Employee empLogin(String empId,String empPwd) {
		Connection conn = JDBCTemplate.getConnection();
		
		Employee e = new EmployeeDao().empLogin(conn, empId,empPwd);
		JDBCTemplate.close(conn);
		
		return e;
	}
	
	public Employee selectById(Employee a) {
		Connection conn = JDBCTemplate.getConnection();
		
		Employee e = new EmployeeDao().selectById(conn, a);
		JDBCTemplate.close(conn);
		
		return e;
	}
	
	public int updateEmployee(Employee a, Employee e) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new EmployeeDao().updateEmployee(conn, a, e);
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
	
	public int deleteEmployee(Employee a) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new EmployeeDao().deleteEmployee(conn,a);
		
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
	
	public int reservationRoom(Employee a,String roomName) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new EmployeeDao().reservationRoom(conn,a, roomName);
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
	
}
