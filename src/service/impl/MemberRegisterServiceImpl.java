package service.impl;

import java.util.List;

import dao.impl.MemberDataDaoImpl;
import model.MemberData;
import service.MemberRegisterService;

public class MemberRegisterServiceImpl implements MemberRegisterService{

	public static void main(String[] args) {

		System.out.println(new MemberRegisterServiceImpl().productMemberId());
		//String MemberID, String position, String memberName
		List<MemberData> list_m=new MemberRegisterServiceImpl().checkLoginMemberData("PE000003","人事部","Mary");
		
		try {
			if(list_m.get(0)!=null) {
				
				System.out.println(list_m.get(0).getMember_name()+"成功登入");
			}
		}catch(IndexOutOfBoundsException x) {
			System.out.println("帳密輸入錯誤");
		}
	}
	
	MemberDataDaoImpl memberDataDaoImpl=new MemberDataDaoImpl();
	//如果資料表內無資料無法自動生成ID
	@Override
	public String productMemberId() {
		List<MemberData> list_m=memberDataDaoImpl.selectAllMember();
		String id1="";
		
		try {
			if(list_m.get(0)==null) {
				id1="1";
			}else if(list_m.get(0)!=null){
				Integer id=list_m.get(list_m.size()-1).getId();
				id=id+1;
				id1=id.toString();
			}
		}catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		if(id1.length()==1) {
			id1="00000".concat(id1);
		}else if(id1.length()==2) {
			id1="0000".concat(id1);
		}else if(id1.length()==3) {
			id1="000".concat(id1);
		}else if(id1.length()==4) {
			id1="00".concat(id1);
		}else if(id1.length()==5) {
			id1="0".concat(id1);
		}else if(id1.length()==0) {
			id1="".concat(id1);
		}
		
		return id1;
	}
	//新增會員資料
	@Override
	public void addMemberData(MemberData memberdata) {
		String name=memberdata.getMember_name();
		String account=memberdata.getAccount();
		List<MemberData> list_memberData=memberDataDaoImpl.findMemberData(name,account);
		
		if(list_memberData!=null) {
			memberDataDaoImpl.insert_MemberData(memberdata);
		}
		
		
	}
	
	//修改會員資料
	@Override
	public void updateMemberData(MemberData memberdata, String name, String account) {
		
		
	}
	//查全部會員資料顯示於JTable
	@Override
	public List<MemberData> selectAllMemberData() {
		// TODO Auto-generated method stub
		return null;
	}
	//驗證登入資料判斷Position進入不同頁面
	@Override
	public List<MemberData> checkLoginMemberData(String MemberID, String position, String memberName) {
		List<MemberData> list_m=memberDataDaoImpl.checkLoginMemberData(MemberID, position, memberName);
		/*
		try {
			if(list_m.get(0)!=null) {
				
				System.out.println(list_m.get(0).getMember_name()+"成功登入");
			}
		}catch(IndexOutOfBoundsException x) {
			System.out.println("帳密輸入錯誤");
		}
		*/
		return list_m;
	}

}
