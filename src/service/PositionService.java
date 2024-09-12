package service;

public interface PositionService {
	
	//建立下拉式選單
	String[] choicePosition();
	
	//新增資料
	void addPosition(String positionName,String positionId);
	
	//建立MemberID前兩碼代表部門(自動生成)
	String memberCode(String position);
	
}
