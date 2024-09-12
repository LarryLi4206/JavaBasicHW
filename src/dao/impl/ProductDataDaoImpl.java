package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.ProductDataDao;
import model.ProductData;

public class ProductDataDaoImpl implements ProductDataDao{

	public static void main(String[] args) {
		
		//自動生成ID(資料表內不能為空)
		List<ProductData> list=new ProductDataDaoImpl().selectProductData();
		Integer num_id=list.get(list.size()-1).getId();
		num_id=num_id+1;
		String id1=num_id.toString();
		
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
		
		//System.out.println(id1);
		
		/*
		ProductData p=new ProductData();
		p.setProduct_id(id1);
		p.setProduct_type("飲料");
		p.setProduct_name("紅茶");
		p.setPrice(25);
		p.setAddProductDateTime("");
		
		new ProductDataDaoImpl().insertInto_Product(p);
		*/
		List<ProductData> list_PD=new ProductDataDaoImpl().selectProductData();
		
		for(ProductData p: list_PD) {
			System.out.println(p.getProduct_id()+p.getProduct_type()+p.getProduct_name());
		}
		
		
		System.out.println("==========================");
		List<ProductData> list_PD1=new ProductDataDaoImpl().selectProductData("綠茶");
		System.out.println(list_PD1.get(0).getPrice());
		
	
	}
	
	//新增產品資料
	@Override
	public void insertInto_Product(ProductData productata) {
		Connection conn=DbConnection.getDb();
		String sql="insert into ProductData(product_id,product_type,product_name,price,addProductDateTime)"
				+ "values(?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, productata.getProduct_id());
			ps.setString(2, productata.getProduct_type());
			ps.setString(3, productata.getProduct_name());
			ps.setInt(4, productata.getPrice());
			ps.setString(5, productata.getAddProductDateTime());
			
			
			ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//列出所有產品
	@Override
	public List<ProductData> selectProductData() {
		List<ProductData> list_product=new ArrayList();
		Connection conn=DbConnection.getDb();
		String sql="select * from ProductData";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ProductData productData=new ProductData();
				productData.setId(rs.getInt("id"));
				productData.setProduct_id(rs.getString("product_id"));
				productData.setProduct_type(rs.getString("product_type"));
				productData.setProduct_name(rs.getString("product_name"));
				productData.setPrice(rs.getInt("price"));
				productData.setAddProductDateTime(rs.getString("addProductDateTime"));
			
				
				list_product.add(productData);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list_product;
	}
	//列出所有產品資料
	@Override
	public List<ProductData> selectProductName_Price() {
		List<ProductData> list_productdata=new ArrayList();
		Connection conn=DbConnection.getDb();
		
		String sql="select * from ProductData";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ProductData productData=new ProductData();
				productData.setId(rs.getInt("id"));
				productData.setProduct_id(rs.getString("product_id"));
				productData.setProduct_type(rs.getString("product_type"));
				productData.setProduct_name(rs.getString("product_name"));
				productData.setPrice(rs.getInt("price"));
				productData.setAddProductDateTime(rs.getString("addProductDateTime"));
			
				list_productdata.add(productData);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list_productdata;
	}
	
	//列出產品名稱的價錢
	@Override
	public List<ProductData> selectProductData(String productName) {
		List<ProductData> list_productdata=new ArrayList();
		Connection conn=DbConnection.getDb();
		String sql="select * from ProductData where product_name=?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, productName);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ProductData productData=new ProductData();
				productData.setId(rs.getInt("id"));
				productData.setProduct_id(rs.getString("product_id"));
				productData.setProduct_type(rs.getString("product_type"));
				productData.setProduct_name(rs.getString("product_name"));
				productData.setPrice(rs.getInt("price"));
				productData.setAddProductDateTime(rs.getString("addProductDateTime"));
			
				list_productdata.add(productData);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list_productdata;
	}
	
}
