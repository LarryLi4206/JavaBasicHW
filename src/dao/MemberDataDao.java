package dao;

import java.util.List;

import model.MemberData;

public interface MemberDataDao {
	
	//新增員工資料
	void insert_MemberData(MemberData memberdata);
	
	//查全部資料
	List<MemberData> selectAllMember();
	
	//檢查資料
	List<MemberData> findMemberData(String name,String account);
		
	//修改資料
	void updateMemberData(MemberData memberdata,String name, String account);
	
	//刪除職位
	void delete_Member(Integer id);
	
	//檢查資料
	List<MemberData> checkLoginMemberData(String MemberID,String position,String memberName);
		
	
}
