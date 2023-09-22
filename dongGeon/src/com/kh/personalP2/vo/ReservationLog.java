package com.kh.personalP2.vo;

public class ReservationLog {
	private int rNo;
	private String roomName;
	private int empNo;
	private String status;
	
	
	public ReservationLog() {
		
	}
	
	public ReservationLog(int rNo, String roomName, int empNo, String status) {
		super();
		this.rNo = rNo;
		this.roomName = roomName;
		this.empNo = empNo;
		this.status = status;
	}

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "rNo=" + rNo + ", roomName=" + roomName + ", empNo=" + empNo + ", status=" + status;
	}
	
	
	
	
}