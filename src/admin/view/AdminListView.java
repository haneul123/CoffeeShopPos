package admin.view;

import java.util.ArrayList;

import admin.vo.Admin;

public class AdminListView {

	public void adminListView(ArrayList<Admin> adminList) {
	
		if(adminList.size() == 0){
			
			System.out.println("관리자가 없습니다");
			
		} else {
			
			System.out.println("관리자 번호\t관리자 권한\t관리자 아이디\t관리자 패스워드\t관리자 이름");
			
			for(int i=0; i<adminList.size(); i++){
				
				System.out.print(adminList.get(i).getAdminNumber() + "\t");
				System.out.print(adminList.get(i).getAuthority() + "\t");
				System.out.print(adminList.get(i).getAdminId() + "\t");
				System.out.print(adminList.get(i).getAdminPassword() + "\t");
				System.out.println(adminList.get(i).getAdminName() + "\t");
				
			}
			
		}
			
	}

}
