package service;

import model.CustomerData;

public interface CustomerLoginService {
	
	//初次登入並註冊--要調用資料庫驗證資料是否重複並且註冊為普通會員
	String CustomerLogin(String username,String user_account,String password);
	
	//完整註冊--填寫完成為銅等級會員
	void CustomerRegister(CustomerData customerData,String username,String user_account);
	
	//產生UserID
	String productUserID(String name,String account);
	//找ID
	Integer findID(String name,String account);
	//驗證登入(傳入主程序內(點單內容)的搜尋VIP資格使用)
	String[] checkedLoginData(String name,String account,String password);
	
	
}
