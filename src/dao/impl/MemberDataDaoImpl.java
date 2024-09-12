package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CheckedAccountPasswordLoginDao;
import dao.DbConnection;
import dao.MemberDataDao;
import model.MemberData;

public class MemberDataDaoImpl implements MemberDataDao{
	
	
	public static void main(String[] args) {
		
		MemberData memberdata=new MemberData();
		memberdata.setAccount("Test");
		//new MemberDataDaoImpl().insert_MemberData(memberdata);
		
		//先新增人員做測試功能
		/*
		MemberData memberdata1=new MemberData("0001","老闆",
				"Jack","0001","0001","台北","yahoo","01234");
		MemberData memberdata2=new MemberData("0002","人事部",
				"Mary","0002","0002","台北","yahoo","01234");
		MemberData memberdata3=new MemberData("0003","普通員工",
				"man01","0003","0003","台北","yahoo","01234");
		MemberData memberdata4=new MemberData("0004","普通員工",
				"man02","0004","0004","台北","gmail","01234");
		MemberData memberdata5=new MemberData("0005","普通員工",
				"man03","0005","0005","台北","gmail","01234");
		MemberData memberdata6=new MemberData("0006","普通員工",
				"man04","0006","0006","台北","gmail","01234");
		
		new MemberDataDaoImpl().insert_MemberData(memberdata6);
		*/
		
		//查表格內最後一筆資料的ID的值--如果為Null則輸入1，否則就加1，顯示於員工ID自動編號
		
		List<MemberData> list_m=new MemberDataDaoImpl().selectAllMember();
		
		//最後一筆ID--成功
		
		list_m.size();
		System.out.println(list_m.size());
		
		System.out.println(list_m.get(list_m.size()-1).getId());
		
		//全資料顯示於JTable
		for(MemberData md:list_m) {
			System.out.println(md.getId()+"\t"+md.getMember_name()+"\t"+md.getAccount()+"\t"+md.getPosition());
		}
		
		System.out.println("===============驗證姓名帳號是否重複===============");
		//驗證姓名帳號是否重複
		List<MemberData> list_m1=new MemberDataDaoImpl().findMemberData("Jack","0001");
		
		if(list_m1.get(0)!=null) {
			System.out.println("重輸入");
		}
		System.out.println("==================驗證登入==================");
		
		List<MemberData>  list_m01=new MemberDataDaoImpl().checkLoginMemberData("0001","老闆","Jack");
		try {
			if(list_m01.get(0)!=null) {
				System.out.println("成功登入");
			}
		}catch(IndexOutOfBoundsException x) {
			System.out.println("帳密輸入錯誤");
		}
		
	}
	
	//新增員工資料(人事部權限)
	@Override
	public void insert_MemberData(MemberData memberdata) {
		Connection conn=DbConnection.getDb();
		String sql="insert into MemberData(member_id,position,member_name,"
				+ "account,password,address,mail_address,telephone) "
				+ "values( ?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,memberdata.getMember_id());
			ps.setString(2,memberdata.getPosition());
			ps.setString(3,memberdata.getMember_name());
			ps.setString(4,memberdata.getAccount());
			ps.setString(5,memberdata.getPassword());
			ps.setString(6,memberdata.getAddress());
			ps.setString(7,memberdata.getMail_address());
			ps.setString(8,memberdata.getTelephone());
			
			ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	//查全部員工資料
	@Override
	public List<MemberData> selectAllMember() {
		Connection conn=DbConnection.getDb();
		String sql="select * from memberData";
		List<MemberData> list_memberData=new ArrayList();
		try {
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				MemberData memberdata=new MemberData();
				memberdata.setId(rs.getInt("id"));
				memberdata.setMember_name(rs.getString("member_id"));
				memberdata.setPosition(rs.getString("position"));
				memberdata.setMember_name(rs.getString("member_name"));
				memberdata.setAccount(rs.getString("account"));
				memberdata.setPassword(rs.getString("password"));
				memberdata.setAddress(rs.getString("address"));
				memberdata.setMail_address(rs.getString("mail_address"));
				memberdata.setTelephone(rs.getString("telephone"));
				
				list_memberData.add(memberdata);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list_memberData;
	}
	
	/*檢查資料&驗證登入--順便查ID
	1.只有一筆可以用來查ID，
	2.驗證判斷是否有查到內容如果有則重新輸入帳號)
	*/
	@Override
	public List<MemberData> findMemberData(String name, String account) {
		List<MemberData> list_memberData=new ArrayList();
		Connection conn=DbConnection.getDb();
		String sql="select * from MemberData where member_name=? and account=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, account);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				MemberData memberdata=new MemberData();
				memberdata.setId(rs.getInt("id"));
				memberdata.setMember_name(rs.getString("member_id"));
				memberdata.setPosition(rs.getString("position"));
				memberdata.setMember_name(rs.getString("member_name"));
				memberdata.setAccount(rs.getString("account"));
				memberdata.setPassword(rs.getString("password"));
				memberdata.setAddress(rs.getString("address"));
				memberdata.setMail_address(rs.getString("mail_address"));
				memberdata.setTelephone(rs.getString("telephone"));
				
				list_memberData.add(memberdata);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list_memberData;
	}
	
	//修改資料(帳號和ID不能重複也不能修改)
	@Override
	public void updateMemberData(MemberData memberdata,String member_id, String member_name) {
		Connection conn=DbConnection.getDb();
		String sql="update MemberData set account=?,password=?,address=?,"
				+"mail_address=?,telephone=?"
				+ "where member_name=? and member_id=?";
		try {
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, memberdata.getAccount());
			ps.setString(2, memberdata.getPassword());
			ps.setString(3, memberdata.getAddress());
			ps.setString(4, memberdata.getMail_address());
			ps.setString(5, memberdata.getTelephone());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//刪除人員
	@Override
	public void delete_Member(Integer id) {
		// TODO Auto-generated method stub
		
	}
	//用Member給View送出資料
	@Override
	public List<MemberData> checkLoginMemberData(String MemberID, String position, String memberName) {
		List<MemberData> list_memberData=new ArrayList();
		Connection conn=DbConnection.getDb();
		String sql="select * from MemberData where member_id=? and position=? and member_name=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, MemberID);
			ps.setString(2, position);
			ps.setString(3, memberName);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				MemberData memberdata=new MemberData();
				memberdata.setId(rs.getInt("id"));
				memberdata.setMember_name(rs.getString("member_id"));
				memberdata.setPosition(rs.getString("position"));
				memberdata.setMember_name(rs.getString("member_name"));
				memberdata.setAccount(rs.getString("account"));
				memberdata.setPassword(rs.getString("password"));
				memberdata.setAddress(rs.getString("address"));
				memberdata.setMail_address(rs.getString("mail_address"));
				memberdata.setTelephone(rs.getString("telephone"));
				
				list_memberData.add(memberdata);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list_memberData;
	}
	
}
