package admin.view;

import java.text.SimpleDateFormat;
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

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");

		if(adminCommuteList.size() == 0){

			System.out.println("기록이 없습니다");

		} else {

			System.out.println("[번호]\t[관리자 이름]\t[관리자 출근시간]\t\t[관리자 퇴근시간]");

			for(int i=0; i<adminCommuteList.size(); i++){


				System.out.print(adminCommuteList.get(i).getLoginNumber() + "\t");
				System.out.print(adminCommuteList.get(i).getAdminName() + "\t");
				String startTime = dateFormat.format(adminCommuteList.get(i).getStartTime());
				System.out.print(startTime + "\t");

				if(adminCommuteList.get(i).getEndTime() != null){

					String endTime = dateFormat.format(adminCommuteList.get(i).getEndTime());
					System.out.println(endTime);

				} else {

					System.out.println("아직 퇴근기록이 없습니다");

				}


			}

		}
	}
}

