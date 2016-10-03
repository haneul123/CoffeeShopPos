package user.view;

import java.util.ArrayList;

import user.vo.User;

public class UserListView {

	public void userListView(ArrayList<User> userList) {
	
		// 많이 구매한 제품 리스트 추가
		// 가장 많이 방문한 시간대 추가
		System.out.println("회원번호\t회원전화번호\t보유쿠폰수\t가입일자\t\t탈퇴여부\t탈퇴날짜");
		
		for(int i=0; i<userList.size(); i++){
		
			System.out.print(userList.get(i).getUserNumber() + "\t");
			System.out.print(userList.get(i).getUserPhoneNumber() + "\t");			
			System.out.print(userList.get(i).getCouponCount() + "\t");
			System.out.print(userList.get(i).getSignUpDate() + "\t");
			
			if(userList.get(i).getIsWithdrawUser() == 1){
				System.out.print("가입회원" + "\t");	
			} else {
				System.out.print("탈퇴회원" + "\t");
			}
			
			if(userList.get(i).getWithdrawDate() == null){
				System.out.println("-");
			} else {
				System.out.println(userList.get(i).getWithdrawDate());	
			}
			
			
		}
		
	}

}
