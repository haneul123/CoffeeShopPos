package user.view;

import java.util.ArrayList;

import user.vo.User;

public class UserListView {

	public void userListView(ArrayList<User> userList) {
	
		// 많이 구매한 제품 리스트 추가
		// 가장 많이 방문한 시간대 추가
		System.out.println("회원번호\t회원전화번호\t보유쿠폰수");
		
		for(int i=0; i<userList.size(); i++){
		
			System.out.println(userList.get(i).getUserNumber());
			System.out.println(userList.get(i).getUserPhoneNumber());
			System.out.println(userList.get(i).getCouponCount());
			
		}
		
	}

}
