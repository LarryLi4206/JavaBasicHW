package service.impl;

import java.util.List;

import dao.impl.CustomerDaoImpl;
import model.CustomerData;
import service.CustomerLoginService;

public class CustomerLoginServiceImpl implements CustomerLoginService{

	public static void main(String[] args) {
		
		//新增資料
		//new CustomerLoginDaoImpl().CustomerLogin("horse", "horse001","123456");
		
		//System.out.println(new CustomerLoginDaoImpl().CustomerLogin("Dog", "Dog001","123456"));
		//查ID
		//System.out.println(new CustomerLoginDaoImpl().productUserID("horse", "horse001"));
		
		//GetDataModel.customesData.getAccount();
		//System.out.println(new CustomerLoginServiceImpl().findID("horse", "horse001"));
		
		String[] list=new CustomerLoginServiceImpl().checkedLoginData("Mary","Wo123","1234");
		
		System.out.println(list[0]);
		System.out.println(list[1]);
		System.out.println(list[2]);
		System.out.println(list[3]);
		
		
	}
	private CustomerDaoImpl customerDaoImpl=new CustomerDaoImpl();
	
	//先存一般會員資料(View傳值送出去---使用list傳值)
	public String CustomerLogin(String username, String user_account, String password) {
		
		CustomerData customerData=new CustomerData();
		
		customerData.setCustomer_name(username);
		customerData.setAccount(user_account);
		customerData.setPassword(password);
		//驗證資料
		List<CustomerData> list_customerData=customerDaoImpl.check_account(username, user_account);
		
		if(list_customerData.size()==1) {
			//System.out.println("資料重複");
			return "資料重複";
		}else {
			//存資料
			customerDaoImpl.insertinto_customerData(customerData);
			return "成功註冊，是否下一步註冊成銅級會員";
		}
		
	}
	
	//完整註冊
	@Override
	public void CustomerRegister(CustomerData customerData,String username,String user_account) {
		CustomerData customerData_getset=new CustomerData();
		customerData_getset.setCustomer_name(username);
		customerData_getset.setAccount(user_account);
		//customerData_getset.setVip("銀牌會員");
		//驗證資料
		List<CustomerData> list_customerData=customerDaoImpl.check_account(username, user_account);
		
		customerDaoImpl.update_VIPLevel(customerData, list_customerData.get(0).getId());
		
	}
	//生成USER_ID
	@Override
	public String productUserID(String name, String account) {
		List<CustomerData> list_customerData=customerDaoImpl.check_account(name, account);
		list_customerData.get(0);
		String userID=list_customerData.get(0).getId().toString();
		
		if(userID.length()<6) {
			userID="00000".concat(userID);
		}else if(userID.length()<5) {
			userID="0000".concat(userID);
		}else if(userID.length()<4) {
			userID="000".concat(userID);
		}else if(userID.length()<3) {
			userID="00".concat(userID);
		}else if(userID.length()<2) {
			userID="0".concat(userID);
		}else if(userID.length()<1) {
			userID="".concat(userID);
		}
		userID="M-".concat(userID);
		return userID;
	}
	
	//查ID
	@Override
	public Integer findID(String name, String account) {
		List<CustomerData> list_customerData=customerDaoImpl.check_account(name, account);
		list_customerData.get(0);
		Integer AutoAdd_ID=list_customerData.get(0).getId();
		
		return AutoAdd_ID;
	}
	
	//驗證登入(傳入主程序內(點單內容)的搜尋VIP資格使用)
	@Override
	public String[] checkedLoginData(String name, String account, String password) {
		List<CustomerData> list_customerData=customerDaoImpl
				.CheckedNameAccountPassword(name, account, password);
		String[] list_loginData=null;
		try{
			if(list_customerData.get(0)!=null) {
				System.out.println(list_customerData.get(0).getCustomer_name()+"登入成功");
			
				list_loginData=new String[] {
						list_customerData.get(0).getCustomer_id(),
						list_customerData.get(0).getAccount(),
						list_customerData.get(0).getCustomer_name(),
						list_customerData.get(0).getVip()
				};
		
			}
		}catch(IndexOutOfBoundsException e) {
			System.out.println("帳密輸入錯誤");
		}
		
		return list_loginData;
	}
	
	
	
	
	
	
}
