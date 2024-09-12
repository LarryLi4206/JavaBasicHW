package dao;

import java.util.List;

import model.ProductData;

public interface ProductDataDao {

	//新增
	void insertInto_Product(ProductData productata);
	//列出所有產品
	List<ProductData> selectProductData(); 
	
	//列出所有產品資料
	List<ProductData> selectProductName_Price();
	
	//列出產品名稱的價錢
	List<ProductData> selectProductData(String productName);
	
}
