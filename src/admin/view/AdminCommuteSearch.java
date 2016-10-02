package admin.view;

import java.util.ArrayList;
import java.util.Scanner;

import admin.vo.Admin;
import mainController.MainController;
import mainView.AlertView;

public class AdminCommuteSearch {


	private Scanner keyboard;


	public AdminCommuteSearch() {

		keyboard = new Scanner(System.in);

	}
	
	
	//이름 받기 뷰
		public void adminListGetNameView() {


			new AlertView().alert("출퇴근 검색 모드 입니다.");
			System.out.println("찾으시는 관리자 이름을 입력 하세요.");
			System.out.print("관리자 명 : ");
			String searchName = keyboard.next();

			Admin adminCommuteList = new Admin(searchName);
			MainController.getAdminController().adminCommuteSearch(adminCommuteList);

		}


	//관리자 출퇴근 조회	
	public void adminCommuteListView(ArrayList<Admin> adminCommuteList) {

		if(adminCommuteList.size() == 0){

			System.out.println("기록이 없습니다");

		} else {

			System.out.println("번호\t관리자 이름\t관리자 출근시간\t관리자 퇴근시간");

			for(int i=0; i<adminCommuteList.size(); i++){

				System.out.print(adminCommuteList.get(i).getLoginNumber() + "\t");
				System.out.print(adminCommuteList.get(i).getAdminName() + "\t");
				System.out.print(adminCommuteList.get(i).getStartTime() + "\t");
				System.out.println(adminCommuteList.get(i).getEndTime());

			}

		}
	}
}

