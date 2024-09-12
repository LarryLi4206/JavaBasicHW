package service;

import java.util.List;

import dao.impl.MemberDataDaoImpl;
import model.MemberData;

public interface MemberRegisterService {
	
	//自動生成6碼ID
	/*
	 使用MemberDataDaoImpl().selectAllMember()
	接過回傳值，查最後一筆ID
	list_m.get(list_m.size()-1).getId()
	*/
	String productMemberId();
	
	//新增Member資料
	void addMemberData(MemberData memberdata);
	
	//員工更新資料
	void updateMemberData(MemberData memberdata,String name,String account);
	
	//查全部資料(直接接過並顯示於JTable)
	//MemberDataDaoImpl().selectAllMember()
	List<MemberData> selectAllMemberData();
	
	//驗證登入資料
	List<MemberData> checkLoginMemberData(String MemberID, String position, String memberName);
	
	
}
