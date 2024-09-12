package dao;

import java.util.List;

import model.CustomerData;

public interface CustomerDao {
	//驗證帳號是否重複(驗證完簡易登入)---再存入資料庫
	//驗證方式--->輸入帳號做查詢使用如果有查詢到代表有重複的資料
	List<CustomerData> check_account(String customer_name,String account);
	
	//簡易註冊(基本三個customer_name,account,password)與完整註冊插入資料用
	void insertinto_customerData(CustomerData customerData);
	
	//搜尋客戶全部資料(人資)
	List<CustomerData> selectAllData();
	
	//用帳號密碼查ID用來產生CustomerID(經過第一階段註冊會有ID)
	//List<CustomerData> selectID(String customer_name,String account);
	
	//一般會員可以跳出並修改--用於填詳細資料或更新Vip等級
	void update_VIPLevel(CustomerData customerData,Integer id);
	
}
