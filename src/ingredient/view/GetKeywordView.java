package ingredient.view;

import mainView.AlertView;

public class GetKeywordView {
	
	public void requestGetKeywordName(String getName) {
		
		new AlertView().alert("'" + getName + "'" + "검색한 결과 입니다.");
		
	}

}
