package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CheckedAccountPasswordLoginDao;
import dao.CustomerDao;
import dao.DbConnection;
import model.CustomerData;

public class CustomerDaoImpl implements CustomerDao,CheckedAccountPasswordLoginDao{

	public static void main(String[] args) {
		//新增資料OK
		/*
		CustomerData c=new CustomerData(null,"John","John123","1234",null,null,null,null);
		new CustomerDamImpl().insertinto_customerData(c);
		*/
		//驗證資料是否重複OK
		/*
		List<CustomerData> list_c=new CustomerDamImpl().check_account("John","John123");
		CustomerData c=null;
		
		if(list_c.size()!=0) {
			c=list_c.get(0);//傳值
			System.out.println(list_c.get(0)+"\n"+c.getAccount()+c.getCustomer_name()+c.getId());
		}else if(list_c.size()==0){
			System.out.println("查無資料");
		}
		*/
		
		/*
		//OK
		List<CustomerData> list_c1=(List<CustomerData>) new CustomerDamImpl().checkedLogin("");
		CustomerData c1=null;
		if(list_c1.size()!=0) {
			c1=list_c1.get(0);//傳值
			System.out.println(list_c1.get(0)+"\n"+c1.getAccount()+c1.getCustomer_name()+c1.getId());
		}else if(list_c1.size()==0){
			System.out.println("查無資料");
		}
		*/
		System.out.println("========================驗證取得ID==============================");
		
		//用名字customer_name和帳號account查ID用來產生CustomerID(經過第一階段註冊會有ID)
		/*幾種地方使用
		* 1.驗證輸入是否重複有則重新輸入
		* 2.產生CustomerID(因為有存資料一定有註冊)
		* 3.輸入好等於註冊
		*/
		List<CustomerData> list_c1=(List<CustomerData>) new CustomerDaoImpl().check_account("John", "John123");
		List<CustomerData> list=new ArrayList();
		list_c1.get(0);
		
		System.out.println(list_c1.get(0).getCustomer_id());
		System.out.println(list_c1.get(0).getId());
		
		/*
		//如果填妥資料更新動作()OK
		CustomerData cdata=new CustomerData(null,"John","John123","1234","123456","Taipei","12378",null);
		new CustomerDamImpl().update_VIPLevel(cdata, getlistId);
		*/
		System.out.println("======================================================");
		//搜尋全部資料OK
		List<CustomerData> list_c2=new CustomerDaoImpl().selectAllData();
		for(CustomerData c:list_c2) {
			System.out.println(c.getId()+"\t"+c.getCustomer_id()+"\t"+c.getCustomer_name()+"\t"+c.getAccount()+
					"\t"+c.getPassword()+"\t"+c.getAddress()+"\t"+c.getMail_address()+"\t"+c.getTelephone()+"\t"+c.getVip());
		}
		
		System.out.println("======================================================");
		/*
		//驗證三項登入資訊是否正確
		List<CustomerData> list_c3=new CustomerDaoImpl().CheckedNameAccountPassword("Mary","Wo123","1234");
		//list_c3.get(0);
		try{
			if(list_c3.get(0)!=null) {
				System.out.println(list_c3.get(0).getCustomer_name()+"登入成功");
			}
		}catch(IndexOutOfBoundsException e) {
			System.out.println("帳密輸入錯誤");
		}
		*/
	}
	
	//用名字customer_name和帳號account查ID用來產生CustomerID(經過第一階段註冊會有ID)
	/*幾種地方使用
	* 1.驗證輸入是否重複有則重新輸入
	* 2.產生CustomerID(因為有存資料一定有註冊)
	* 3.
	*/
	@Override
	public List<CustomerData> check_account(String customer_name,String account) {
		List<CustomerData> list_customer=new ArrayList();
		
		Connection conn=DbConnection.getDb();
		String sql="select * from customerData where account=? and customer_name=?";
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			ps.setString(2, customer_name);
			ResultSet rs=ps.executeQuery();
			CustomerData customer=new CustomerData();
			while(rs.next()) {
				
				customer.setId(rs.getInt("id"));
				customer.setCustomer_id(rs.getString("Customer_id"));
				customer.setCustomer_name(rs.getString("Customer_name"));
				customer.setAccount(rs.getString("Account"));
				customer.setPassword(rs.getString("Password"));
				customer.setAddress(rs.getString("Address"));
				customer.setMail_address(rs.getString("Mail_address"));
				customer.setTelephone(rs.getString("Telephone"));
				customer.setVip(rs.getString("Vip"));
				
				list_customer.add(customer);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list_customer;
	}
	
	//簡易註冊則存入為空或null/和完整註冊(給方法或前端判斷資料)
	@Override
	public void insertinto_customerData(CustomerData customerData) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into customerData "
				+ "(customer_id,customer_name,account,password,address,mail_address,telephone,vip)"
				+ "values(?,?,?,?,?,?,?,?)";
		
		try {
			
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1,customerData.getCustomer_id());
			ps.setString(2,customerData.getCustomer_name());
			ps.setString(3,customerData.getAccount());
			ps.setString(4,customerData.getPassword());
			ps.setString(5,customerData.getAddress());
			ps.setString(6,customerData.getMail_address());
			ps.setString(7,customerData.getTelephone());
			ps.setString(8,customerData.getVip());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	//找出全部資料
	@Override
	public List<CustomerData> selectAllData() {
		List<CustomerData> list_customer=new ArrayList();
		String sql="select * from customerData;";
		Connection conn=DbConnection.getDb();
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				//迴圈每次清空
				CustomerData customerData=new CustomerData();
				
				customerData.setId(rs.getInt("id"));
				customerData.setCustomer_id(rs.getString("Customer_id"));
				customerData.setCustomer_name(rs.getString("Customer_name"));
				customerData.setAccount(rs.getString("account"));
				customerData.setPassword(rs.getString("password"));
				customerData.setAddress(rs.getString("address"));
				customerData.setMail_address(rs.getString("mail_address"));
				customerData.setTelephone(rs.getString("telephone"));
				customerData.setVip(rs.getString("vip"));
			
				list_customer.add(customerData);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list_customer;
	}

	//更新資料(更新VIP資料，更新customer_id)
	@Override
	public void update_VIPLevel(CustomerData customerData,Integer id) {
		Connection conn =DbConnection.getDb();
		
		String sql="update customerData set "
				+ "customer_id=?,customer_name=?,account=?,"
				+ "password=?,address=?,mail_address=?,telephone=?,vip=? where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(1,customerData.getCustomer_id());
			ps.setString(2,customerData.getCustomer_name());
			ps.setString(3,customerData.getAccount());
			ps.setString(4,customerData.getPassword());
			ps.setString(5,customerData.getAddress());
			ps.setString(6,customerData.getMail_address());
			ps.setString(7,customerData.getTelephone());
			ps.setString(8,customerData.getVip());
			
			ps.setInt(9, id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	//驗證登入OR資料重複(驗證姓名帳號密碼)
	@Override
	public List<CustomerData> CheckedNameAccountPassword(String username, String account, String password) {
		Connection conn=DbConnection.getDb();
		String sql="select * from CustomerData where customer_name=? and account=? and password=?";
		
		List<CustomerData> list_customerData=new ArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2,account);
			ps.setString(3,password);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				CustomerData customerData=new CustomerData();
				customerData.setId(rs.getInt("id"));
				customerData.setCustomer_id(rs.getString("Customer_id"));
				customerData.setCustomer_name(rs.getString("Customer_name"));
				customerData.setAccount(rs.getString("account"));
				customerData.setPassword(rs.getString("password"));
				customerData.setAddress(rs.getString("address"));
				customerData.setMail_address(rs.getString("mail_address"));
				customerData.setTelephone(rs.getString("telephone"));
				customerData.setVip(rs.getString("vip"));
				
				list_customerData.add(customerData);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list_customerData;
	}
	
	
}
