package com.kh.personalP2.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.personalP2.controller.EmployeeController;
import com.kh.personalP2.vo.Employee;
import com.kh.personalP2.vo.ReservationLog;
import com.kh.personalP2.vo.Room;

public class EmployeeMenu {
	private Scanner sc = new Scanner(System.in);
	private EmployeeController ec = new EmployeeController();
	
	public EmployeeMenu() {
		
	}
	/**
	 * 관리자 또는 회원 로그인 뷰
	 */
	public void logintoMain() {
		while(true) {
			System.out.println("erp 프로그램을 시작합니다.");
			System.out.println("1. 관리자로그인.");
			System.out.println("2. 회원로그인. ");
			System.out.println("9. 프로그램 종료.");
			int num = sc.nextInt();
			
			switch(num) {
				case 1 :{
				System.out.print("아이디를 입력하세요 : ");
				String empId =	sc.next();
				System.out.print("비밀번호를 입력하세요 : ");
				String empPwd =	sc.next();
				
				ec.admLogin(empId, empPwd);
				break;
				}
				case 2 : {
					System.out.print("아이디를 입력하세요 : ");
					String empId =	sc.next();
					System.out.print("비밀번호를 입력하세요 : ");
					String empPwd =	sc.next();
					
					ec.empLogin(empId,empPwd);
					break;
				}
				case 9 :{ 
					System.out.println("프로그램을 종료합니다. ");
					return;
				}
				default : 
					System.out.println("없는 메뉴입니다. 다시입력해주세요.");
			}
		}
	}
	
	
	/**
	 * 회원등급으로 로그인시 나타나는 메뉴 
	 */
	public void mainMenuEmployee() {
		boolean istrue = true;
		while(istrue) {
			System.out.println("\n회원 메뉴입니다. 원하시는 메뉴번호를 입력해주세요.");
			System.out.println("1. 내정보 보기");
			System.out.println("2. 내정보 수정");
			System.out.println("3. 회원 탈퇴");
			System.out.println("4. 회의실 예약");
			System.out.println("5. 회의실 반납");
			System.out.println("6. 회의실 예약상태 확인");
			System.out.println("9. 뒤로가기");
			int num = sc.nextInt();
			sc.nextLine();
			
			switch(num) {
				case 1 :
					ec.selectById();
					break;
				case 2 : 
					System.out.println("==회원 정보 변경==");
					
					System.out.print("변경할 전화 번호 : ");
					String phone = sc.nextLine();
					
					System.out.print("변경할 부서 : ");
					String dept = sc.nextLine();
					
					System.out.print("변경할 사원 월급 : ");
					int salary = sc.nextInt();
					sc.nextLine();
					
					System.out.print("변경할 보너스 율 : ");
					double bonus = sc.nextDouble();
					sc.nextLine();
					
					ec.updateEmployee(phone,dept,salary,bonus);
					
					break;
				case 3 :
					System.out.println("==회원 탈퇴==");
					System.out.println("정말로 탈퇴하시겠습니까?(y/n)");
					char ch = sc.next().charAt(0);
					
					if(ch == 'y' || ch == 'Y') {
						ec.deleteEmployee();
					}
					istrue=false;
					break;
				case 4 :
					ec.selectRoom();
					
					System.out.print("예약하시고 싶은 roomName을 입력해주세요.");
					String roomName = sc.next();
					
					ec.reservationRoom(roomName);
					
					break;
				case 5 :
					System.out.print("반납하시고 싶은 회의실이름을 입력해주세요.\n");
					ec.selectConfirmRoom();
					String Rn = sc.next();
					
					ec.returnRoom(Rn);
					
					break;
				case 6 :
					System.out.println("\n회원님의 회의실 예약 확정 내역입니다.");
					ec.selectConfirmRoom();
					
					break;
				case 9 :
					istrue = false;
					break;
				default : 
					System.out.println("잘못 입력하셨습니다. 다시입력해주세요.");
			}
		}		
	}
	/**
	 * 관리자 등급으로 로그인할 시 보여주는 메뉴
	 */
	public void mainMenuAdmin() {
		while(true) {
			System.out.println("\n관리자 메뉴입니다. 원하시는 메뉴번호를 입력해주세요.");
			System.out.println("1. 사원 추가");
			System.out.println("2. 사원 수정");
			System.out.println("3. 사원 삭제");
			System.out.println("4. 사원 전체 출력");
			System.out.println("5. 회의실 예약 관리목록 조회");
			System.out.println("6. 회의실 예약 관리(확정)");
			System.out.println("9. 뒤로가기");
			int num = sc.nextInt();
			sc.nextLine();
		
		switch(num) {
			case 1 :
				inputEmp();
				break;
			case 2 :
				System.out.println("==회원 정보 변경==");
				System.out.print("==정보를 변경할 ID를 입력하세요. : ");
				String empId = sc.nextLine();
				
				System.out.print("변경할 전화 번호 : ");
				String phone = sc.nextLine();
				
				System.out.print("변경할 부서 : ");
				String dept = sc.nextLine();
				
				System.out.print("변경할 사원 월급 : ");
				int salary = sc.nextInt();
				sc.nextLine();
				
				System.out.print("변경할 보너스 율 : ");
				double bonus = sc.nextDouble();
				sc.nextLine();
				
				ec.updateEmployeeAdm(empId, phone,dept,salary,bonus);
				
				break;
			case 3 :
				ec.selectList();
				
				System.out.println("==회원 탈퇴==");
				System.out.println("탈퇴시킬 id를 입력하세요. : ");
				String tmp = sc.next();
				
				ec.deleteEmployeeAdm(tmp);	
				break;
			case 4 :
				ec.selectList();
				break;
			case 5 :
				ec.selectRoomLog();
				break;
			case 6 :
				
				System.out.println("==회의실 예약확정==");
				System.out.println("예약확정할 회의실 이름을 입력해주세요 : ");
				String roomName = sc.next();
				
				ec.confirmRoom(roomName);
				
				break;
		
			case 9 :
				System.out.println("처음으로 돌아갑니다.");
				return;
			default :
				System.out.println("잘못 입력하셨습니다.");
		}
		}
	}
	//사원 삽입 메서드
	public void inputEmp() {
		
		System.out.print("사원 등급 : ");
		String empGrade= sc.nextLine();
		
		System.out.print("사원 아이디 : ");
		String empId= sc.nextLine();
		
		System.out.print("사원 패스워드 : ");
		String empPwd= sc.nextLine();
		
		System.out.print("사원 이름 : ");
		String name= sc.nextLine();
		
		System.out.print("사원 성별 : ");
		String gender= sc.nextLine();
		
		System.out.print("전화 번호 : ");
		String phone = sc.nextLine();
		
		System.out.print("사원 부서 : ");
		String dept = sc.nextLine();
		
		System.out.print("사원 월급(원) 숫자만입력 : ");
		String salary = sc.nextLine();
		
		System.out.print("보너스 율(퍼센트) 실수형으로 입력 (ex) 30% = 0.3 : ");
		String bonus = sc.nextLine();
			
		ec.insertEmployee(empGrade.toUpperCase(),empId, empPwd, name,gender,phone,dept,salary,bonus);
		
		
	}
	
	
	
	//---------------------------------응답화면------------------------------
	
	public void displayLoginFail(String message) {
		System.out.println("\n"+ message);
		System.out.println("\n"+ "아이디 또는 비밀번호를 확인해주세요");
		
	}
	public void displayAdmLoginFail(String message) {
		System.out.println("\n"+ message);
		
	}
	public void adminLoginSuccess() {
		System.out.println("\n 관리자 로그인에 성공하였습니다." );
		mainMenuAdmin();
	}
	
	public void empLoginSuccess() {
		System.out.println("\n 회원 로그인에 성공하였습니다.");
		mainMenuEmployee();
	}
	
	
	public void displayNoData(String message) {
		System.out.println("\n"+ message);
	}
	public void displayEmployee(Employee e) {
		System.out.println("\n조회된 데이터는 다음과 같습니다.");
		System.out.println(e);
	}
	
	public void displaySuccess(String message) {
		System.out.println("\n서비스 요청 성공 : "+ message);
	}
	public void displayFail(String message) {
		System.out.println("\n서비스 요청 실패 : "+ message);
	}
	public void displayEmployeeList(ArrayList<Employee> list) {
		System.out.println("\n조회된 데이터는 다음과 같습니다\n");
		
		for(Employee e : list) {
			System.out.println(e);
		}
	}
	public void displayRoomList(ArrayList<Room> list) {
		System.out.println("\n조회된 데이터는 다음과 같습니다\n");
		
		for(Room r : list) {
			System.out.println(r);
		}
	}
	
	public void displayRoomLogList(ArrayList<ReservationLog> list) {
		System.out.println("\n조회된 데이터는 다음과 같습니다\n");
		
		for(ReservationLog rl : list) {
			System.out.println(rl);
		}
	}
	
	public void displayConfirmLogList(ArrayList<ReservationLog> list) {
		
		for(ReservationLog rl : list) {
			System.out.println(rl);
		}
	}
	
}
