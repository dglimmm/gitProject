package com.kh.personalP2.Dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.personalP2.template.JDBCTemplate;
import com.kh.personalP2.vo.Employee;
import com.kh.personalP2.vo.ReservationLog;
import com.kh.personalP2.vo.Room;

public class EmployeeDao {
private Properties prop = new Properties();
	
	public EmployeeDao() {
		try {
			prop.load(new FileInputStream("resources/query.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Employee admLogin(Connection conn, String empId,String empPwd) {
		
		Employee e =null;
		
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		
		String sql = prop.getProperty("loginAdmin");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empId);
			pstmt.setString(2, empPwd);
			
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				e  = new Employee();
				e.setEmpNo(rset.getInt("empno"));
				e.setEmpGrade(rset.getString("empgrade"));
				e.setEmpId(rset.getString("empid"));
				e.setEmpPwd(rset.getString("emppwd"));
				e.setName(rset.getString("name"));
				e.setGender(rset.getString("gender"));
				e.setPhone(rset.getString("phone"));
				e.setDept(rset.getString("dept"));
				e.setSalary(rset.getInt("salary"));
				e.setBonus(rset.getDouble("bonus"));
				
				
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return e;
	}
	
	public Employee empLogin(Connection conn, String empId,String empPwd) {
		
		Employee e =null;
		
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		
		String sql = prop.getProperty("loginAdmin");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empId);
			pstmt.setString(2, empPwd);
			
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				e  = new Employee();		
				e.setEmpNo(rset.getInt("empno"));
				e.setEmpGrade(rset.getString("empgrade"));
				e.setEmpId(rset.getString("empid"));
				e.setEmpPwd(rset.getString("emppwd"));
				e.setName(rset.getString("name"));
				e.setGender(rset.getString("gender"));
				e.setPhone(rset.getString("phone"));
				e.setDept(rset.getString("dept"));
				e.setSalary(rset.getInt("salary"));
				e.setBonus(rset.getDouble("bonus"));
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return e;
	}
	
	public Employee selectById(Connection conn, Employee a) {
		Employee e = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectById");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, a.getEmpId());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				e = new Employee();
				e.setEmpNo(rset.getInt("empno"));
				e.setEmpGrade(rset.getString("empgrade"));
				e.setEmpId(rset.getString("empid"));
				e.setEmpPwd(rset.getString("emppwd"));
				e.setName(rset.getString("name"));
				e.setGender(rset.getString("gender"));
				e.setPhone(rset.getString("phone"));
				e.setDept(rset.getString("dept"));
				e.setSalary(rset.getInt("salary"));
				e.setBonus(rset.getDouble("bonus"));
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return e;
	}
	
	public int updateEmployee(Connection conn,Employee a, Employee e) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateEmployee");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, e.getPhone());
			pstmt.setString(2, e.getDept());
			pstmt.setInt(3, e.getSalary());
			pstmt.setDouble(4, e.getBonus());
			pstmt.setString(5, a.getEmpId());
			
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int updateEmployeeAdm(Connection conn, Employee e) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateEmployeeAdm");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, e.getPhone());
			pstmt.setString(2, e.getDept());
			pstmt.setInt(3, e.getSalary());
			pstmt.setDouble(4, e.getBonus());
			pstmt.setString(5, e.getEmpId());
			
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int deleteEmployee(Connection conn, Employee a) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteEmployee");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a.getEmpId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int deleteEmployeeAdm(Connection conn, String tmp) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteEmployee");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tmp);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	
	public int insertEmployee(Connection conn, Employee e) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertEmployee");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, e.getEmpGrade());
			pstmt.setString(2, e.getEmpId());
			pstmt.setString(3, e.getEmpPwd());
			pstmt.setString(4, e.getName());
			pstmt.setString(5, e.getGender());
			pstmt.setString(6, e.getPhone());
			pstmt.setString(7, e.getDept());
			pstmt.setInt(8, e.getSalary());
			pstmt.setDouble(9, e.getBonus());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public ArrayList<Employee> selectList(Connection conn){
		
		ArrayList<Employee> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Employee e = new Employee();
				e.setEmpNo(rset.getInt("empno"));
				e.setEmpGrade(rset.getString("empgrade"));
				e.setEmpId(rset.getString("empid"));
				e.setEmpPwd(rset.getString("emppwd"));
				e.setName(rset.getString("name"));
				e.setGender(rset.getString("gender"));
				e.setPhone(rset.getString("phone"));
				e.setDept(rset.getString("dept"));
				e.setSalary(rset.getInt("salary"));
				e.setBonus(rset.getDouble("bonus"));
				
				list.add(e);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Room> selectRoom(Connection conn){
		
		ArrayList<Room> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectRoom");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Room r = new Room();
				r.setRoomName(rset.getString("ROOM_NAME"));
				r.setRoomPeople(rset.getInt("ROOM_PEOPLE"));
				r.setBim(rset.getString("BIM"));
				r.setWifi(rset.getString("WIFI"));
				r.setRoomYn(rset.getString("ROOM_YN"));
				r.setRno(rset.getInt("rno"));
				
				list.add(r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
		
	}
	
	public int reservationRoom(Connection conn, Employee a ,String roomName){
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("reservationRoom");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, roomName);
			pstmt.setInt(2, a.getEmpNo());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public ArrayList<ReservationLog> selectRoomLog(Connection conn){
		ArrayList<ReservationLog> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectRoomLog");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReservationLog rl = new ReservationLog();
				rl.setrNo(rset.getInt("rno"));
				rl.setRoomName(rset.getString("ROOM_NAME"));
				rl.setEmpNo(rset.getInt("EMPNO"));
				rl.setStatus(rset.getString("STATUS"));
				
				
				list.add(rl);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public int confirmRoom(Connection conn, String roomName){
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("confirmRoom");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, roomName);
			
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
}