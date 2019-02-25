package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.intface.*;
import com.domain.*;
import com.jdbc.*;
public class ShoeStoreDao implements ShoeStoreDaoIntface {

	@Override
	public Tuser selectTuserByIdPsw(String sql, String userId, String password) {
		//String sql = "select user_id,Psw,tNAME FROM t_user WHERE user_id = ? AND psw = ?";
		Connection conn = DbConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Tuser tuser = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()){
				String userId1 = rs.getString("user_id");
				String password1 = rs.getString("psw");
				String tname = rs.getString("tname");
				tuser = new Tuser(userId1, password1, tname);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnection.close(rs, ps, conn);
		}
		
		
		return tuser;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ShoeStoreDao s = new ShoeStoreDao();
		//System.out.println(s.selectTuserByIdPsw("select user_id,Psw,tNAME FROM t_user WHERE user_id = ? AND Psw = ?", "1001", "123"));
		/*String sql = "SELECT * FROM t_Category";
		List<Category> ss = s.selectAllCategory(sql);
		System.out.println(ss);*/
		//String sql = "SELECT * FROM (SELECT PRODUCT_ID, DESCRIPTION,price,MODEL,FEATURE,imgpath,novalty_status,publish_date,category_id£¬ROWNUM r FROM t_product WHERE category_id = ?) WHERE r BETWEEN ? AND ?";
		//System.out.println(s.selectProductById(sql, 10, 1, 10));
		/*String sql = "SELECT COUNT(*) FROM T_product WHERE category_id = ?";
		System.out.println(s.selectCountProductById(sql, 10));*/
		/*String sql = "SELECT * FROM t_product WHERE MODEL = ?";
		System.out.println(s.selectthisProduct(sql, "T619N").getModel());*/
		/*String sql = "SELECT quantity FROM t_stock WHERE product_id = ?";
		System.out.println(s.selectQuantityById(sql, 1313));*/
		/*String sql = "SELECT * FROM (SELECT PRODUCT_id,DESCRIPTION,price,MODEL,FEATURE,imgpath,novalty_status,publish_date,d.category_id£¬c.name,ROWNUM r FROM t_product d, t_category c WHERE d.category_id = c.category_id ORDER BY price) WHERE r BETWEEN 1 AND 4";
		List<Product> l = new ArrayList<>();
		l = s.selectPopolarProduct(sql);
		for(Product p : l){
			System.out.println(p.getName() + "!" + p.getCategoryId());
		}*/
		/*String sql ="SELECT * FROM (SELECT PRODUCT_id,DESCRIPTION,price,MODEL,FEATURE,imgpath,novalty_status,publish_date,d.category_id,c.name,ROWNUM r FROM t_product d, t_category c WHERE d.category_id = c.category_id ORDER BY publish_date) WHERE r BETWEEN 1 AND 4";
		List<Product> l = new ArrayList<>();
		l= s.selectNewProduct(sql);
		for(Product p : l){
			System.out.println(p.getName() + "!" + p.getCategoryId());
		}*/
		String sql = "SELECT quantity FROM t_stock WHERE product_id = ?";
		System.out.println(s.selectshoeQuantity(sql, 1314));
	}

	@Override
	public List<Category> selectAllCategory(String sql) {
		List<Category> categoryList = new ArrayList<Category>();
		
		Connection conn = DbConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int categoryId = rs.getInt(1);
				String cname = rs.getString(2);
				Category c = new Category(categoryId, cname);
				categoryList.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnection.close(rs, ps, conn);
		}
		
		return categoryList;
	}
	//String sql = "SELECT * FROM (SELECT PRODUCT_ID, DESCRIPTION,price,MODEL,FEATURE,imgpath,novalty_status,publish_date,category_id£¬ROWNUM r FROM t_product ORDER BY PUBLISH_DATE DESC) WHERE r BETWEEN 5 AND 12";
	@Override
	public List<Product> selectProductById(String sql, int categoryId,int beign,int end) {
		List<Product> productList = new ArrayList<Product>();
		//String sql = "SELECT * FROM (SELECT PRODUCT_id,DESCRIPTION,price,MODEL,FEATURE,imgpath,novalty_status,publish_date,category_id£¬ROWNUM r FROM t_product WHERE category_id = ?) WHERE r BETWEEN ? AND ?";
		Connection conn = DbConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, categoryId);
			ps.setInt(2, beign);
			ps.setInt(3, end);
			rs = ps.executeQuery();
			while(rs.next()){
				int productId = rs.getInt("PRODUCT_ID");
				String description = rs.getString("DESCRIPTION");
				double price = rs.getDouble("price");
				String model = rs.getString("MODEL");
				String feature = rs.getString("FEATURE");
				String imgpath = rs.getString("imgpath");
				int novaltyStatus = rs.getInt("novalty_status");
				String publishDate = rs.getString("publish_date");
				int categoryId1 = rs.getInt("category_id");
				Product product = new Product(productId,description, price, model, feature, imgpath, novaltyStatus, publishDate, categoryId1);
				productList.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnection.close(rs, ps, conn);
		}
		
		return productList;
	}

	@Override
	public int selectCountProductById(String sql,int categoryId) {
		int pages = 0;
		//String sql = "SELECT COUNT(*) FROM T_product WHERE category_id = ?";
		Connection conn = DbConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, categoryId);
			rs = ps.executeQuery();
			if(rs.next()){
				pages = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnection.close(rs, ps, conn);
		}
		return pages;
	}

	@Override
	public Product selectthisProduct(String sql, String model) {
		Product product = new Product();
		//String sql = "SELECT * FROM t_product WHERE MODEL = ?";
		Connection conn = DbConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, model);
			rs = ps.executeQuery();
			if(rs.next()){
				int productId = rs.getInt("PRODUCT_ID");
				String description = rs.getString("DESCRIPTION");
				double price = rs.getDouble("price");
				String model1 = rs.getString("MODEL");
				String feature = rs.getString("FEATURE");
				String imgpath = rs.getString("imgpath");
				int novaltyStatus = rs.getInt("novalty_status");
				String publishDate = rs.getString("publish_date");
				int categoryId1 = rs.getInt("category_id");
				product = new Product(productId,description, price, model1, feature, imgpath, novaltyStatus, publishDate, categoryId1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnection.close(rs, ps, conn);
		}
		return product;
	}

	@Override
	public int selectQuantityById(String sql, int productId) {
		//String sql = "SELECT quantity FROM t_stock WHERE product_id = ?";
		Connection conn = DbConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int quantity = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, productId);
			rs = ps.executeQuery();
			if(rs.next()){
				quantity = rs.getInt("quantity");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnection.close(rs, ps, conn);
		}
		return quantity;
	}

	@Override
	public List<Product> selectNewProduct(String sql) {
		List<Product> productList = new ArrayList<Product>();
		//"SELECT * FROM (SELECT PRODUCT_id,DESCRIPTION,price,MODEL,FEATURE,imgpath,novalty_status,publish_date,category_id£¬ROWNUM r FROM t_product ORDER BY publish_date) WHERE r BETWEEN 1 AND 6";
		Connection conn = DbConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				String name = rs.getString("NAME");
				int productId = rs.getInt("PRODUCT_ID");
				String description = rs.getString("DESCRIPTION");
				double price = rs.getDouble("price");
				String model = rs.getString("MODEL");
				String feature = rs.getString("FEATURE");
				String imgpath = rs.getString("imgpath");
				int novaltyStatus = rs.getInt("novalty_status");
				String publishDate = rs.getString("publish_date");
				int categoryId1 = rs.getInt("category_id");
				Product product = new Product(productId, description, price, model, feature, imgpath, novaltyStatus, publishDate, categoryId1,name);
				productList.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnection.close(rs, ps, conn);
		}
		
		return productList;
	}

	@Override
	public List<Product> selectPopolarProduct(String sql) {
		List<Product> productList = new ArrayList<Product>();
		//SELECT * FROM (SELECT PRODUCT_id,DESCRIPTION,price,MODEL,FEATURE,imgpath,novalty_status,publish_date,d.category_id£¬c.name,ROWNUM r FROM t_product d, t_category c WHERE d.category_id = c.category_id ORDER BY price) WHERE r BETWEEN 1 AND 4;

		Connection conn = DbConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				String name = rs.getString("NAME");
				int productId = rs.getInt("PRODUCT_ID");
				String description = rs.getString("DESCRIPTION");
				double price = rs.getDouble("price");
				String model = rs.getString("MODEL");
				String feature = rs.getString("FEATURE");
				String imgpath = rs.getString("imgpath");
				int novaltyStatus = rs.getInt("novalty_status");
				String publishDate = rs.getString("publish_date");
				int categoryId1 = rs.getInt("category_id");
				Product product = new Product(productId,description, price, model, feature, imgpath, novaltyStatus, publishDate, categoryId1,name);
				productList.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnection.close(rs, ps, conn);
		}
		
		return productList;
	}

	@Override
	public int selectshoeQuantity(String sql, int productId) {
		Connection conn = DbConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, productId);
			rs = ps.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnection.close(rs, ps, conn);
		}
		
		return count;
	}

}
