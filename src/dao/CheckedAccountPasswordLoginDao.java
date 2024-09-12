package dao;

public interface CheckedAccountPasswordLoginDao<E> {
	//驗證帳號密碼做登入
	E CheckedNameAccountPassword(String username,String account,String password);

}
