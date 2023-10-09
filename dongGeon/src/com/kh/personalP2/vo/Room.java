	package com.kh.personalP2.vo;

public class Room {

	private String roomName;
	private int roomPeople;
	private String bim;
	private String wifi;
	private String roomYn;
	
	public Room() {
		
	}

	
	public Room(String roomName, int roomPeople, String bim, String wifi, String roomYn) {
		super();
		this.roomName = roomName;
		this.roomPeople = roomPeople;
		this.bim = bim;
		this.wifi = wifi;
		this.roomYn = roomYn;
	}


	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getRoomPeople() {
		return roomPeople;
	}

	public void setRoomPeople(int roomPeople) {
		this.roomPeople = roomPeople;
	}

	public String getBim() {
		return bim;
	}

	public void setBim(String bim) {
		this.bim = bim;
	}

	public String getWifi() {
		return wifi;
	}

	public void setWifi(String wifi) {
		this.wifi = wifi;
	}

	public String getRoomYn() {
		return roomYn;
	}

	public void setRoomYn(String roomYn) {
		this.roomYn = roomYn;
	}


	@Override
	public String toString() {
		return "Room [roomName=" + roomName + ", roomPeople=" + roomPeople + ", bim=" + bim + ", wifi=" + wifi
				+ ", roomYn=" + roomYn + "]";
	}
	
	
	
	
}
