package admin.view;

import java.util.ArrayList;

import admin.vo.Admin;

public class AdminListView {


	//관리자 조회 리스트
	public void adminListView(ArrayList<Admin> adminList) {


		if(adminList.size() == 0){

			System.out.println("관리자가 없습니다");

		} else {

			System.out.println("[관리자 번호]\t[권한]\t[아이디]\t[패스워드]\t[관리자 이름]");

			for(int i=0; i<adminList.size(); i++){

				System.out.print(adminList.get(i).getAdminNumber() + "\t\t");
				
				if(adminList.get(i).getAuthority() == 1){
					System.out.print("관리자\t");	
				} else {
					System.out.print("직원\t");
				}
				
				System.out.print(adminList.get(i).getAdminId() + "\t");
				System.out.print(adminList.get(i).getAdminPassword() + "\t");
				System.out.println(adminList.get(i).getAdminName() + "\t");

			}

		}

	}

}
