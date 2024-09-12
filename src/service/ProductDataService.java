package service;

import java.util.List;

import model.ProductData;

public interface ProductDataService {
	//新增產品
	void addProductData(ProductData productData);
	//所有產品資料
	List<ProductData> findAllProductData();
	
	
	
}
