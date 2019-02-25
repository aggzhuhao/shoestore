package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;


import com.dao.intface.ShopCarOrderDaoIntface;

import com.domain.Product;
import com.domain.ShoppingCart;
import com.jdbc.DbConnection;

public class ShopCarOrderDao implements ShopCarOrderDaoIntface {

	
	public List<Product> selectADProduct(String sql, int begin) {
		List<Product> productList = new ArrayList<Product>();
		//SELECT * FROM (SELECT d.PRODUCT_id,d.DESCRIPTION,price,MODEL,FEATURE,d.imgpath,novalty_status,publish_date,d.category_id，c.name,ROWNUM r FROM t_product d, t_category c ,t_slider sWHERE d.category_id = c.category_id AND d.product_id = s.product_id ORDER BY price)WHERE r BETWEEN 1 AND ?;

		Connection conn = DbConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, begin);
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ShopCarOrderDao sc = new ShopCarOrderDao();
		/*List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT * FROM (SELECT d.PRODUCT_id,d.DESCRIPTION,price,MODEL,FEATURE,d.imgpath,novalty_status,publish_date,d.category_id，c.name,ROWNUM r FROM t_product d, t_category c ,t_slider s WHERE d.category_id = c.category_id AND d.product_id = s.product_id ORDER BY price)WHERE r BETWEEN 1 AND ?";
		productList = sc.selectADProduct(sql,4);
		for(Product p : productList){
			System.out.println(p.getCategoryId() + p.getImgpath());
		}*/
		/*String sql = "SELECT shopping_cart_id,s.product_id,quantity,s.user_id,price,imgpath,description FROM t_shopping_cart s,t_product p WHERE p.product_id = s.product_id AND s.user_id = ?";
		List<ShoppingCart> shoppingCartList = new ArrayList<ShoppingCart>();
		shoppingCartList = sc.selecetShoppingCart(sql, "1001");
		for(ShoppingCart s : shoppingCartList){
			System.out.println(s.getUserId() + ";;" + s.getShoppingCartId() + ":" + s.getProduct().getPrice() + ":" + s.getProduct().getImgpath());
		}*/
		/*String sql = "{call scott.sp_insert_shoppingcartno(?,?,?,?)}";
		System.out.println(sc.insertShoppingCart(sql, 1314, 1, "1001"));
		String sql = "DELETE FROM t_shopping_cart WHERE shopping_cart_id = ?";
		System.out.println(sc.deleteShoppingCart(sql, 1960));*/
		/*String sql = "SELECT SUM(product_id * quantity) FROM t_shopping_cart WHERE user_id = ?";
		System.out.println(sc.selectSumCartPrice(sql, "1001"));*/
		String sql = "UPDATE t_shopping_cart SET quantity = ? WHERE product_id = ? AND user_id = ?";
		System.out.println(sc.updateShoppingCartByQuantity(sql, 12, 1275, "1001"));
		
	}

	
	public List<ShoppingCart> selecetShoppingCart(String sql,String userId) {
		List<ShoppingCart> shoppingCartList = new ArrayList<ShoppingCart>();
		Connection conn = DbConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			while(rs.next()){
				int shoppingCartId = rs.getInt("shopping_cart_id");
				int productId = rs.getInt("product_id");
				int quantity = rs.getInt("quantity");
				double price = rs.getDouble("price");
				String userId1 = rs.getString("user_id");
				String imgpath = rs.getString("imgpath");
				String description = rs.getString("description");
				
				Product product = new Product();
				product.setDescription(description);
				product.setPrice(price);
				product.setProductId(productId);
				product.setImgpath(imgpath);
				ShoppingCart shoppingCart = new ShoppingCart(shoppingCartId, product, quantity, userId1);
				shoppingCartList.add(shoppingCart);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnection.close(rs, ps, conn);
		}
		return shoppingCartList;
	}

	

	@Override
	public int insertShoppingCart(String sql, int productId, int quantity,
			String userId) {
		Connection conn = DbConnection.getConnection();
		CallableStatement cs = null;
		int result = 3;
		//String sql = "{call scott.sp_insert_shoppingcartno(?,?,?,?)}";
		try {
			cs = conn.prepareCall(sql);
			cs.setInt(1, productId);
			cs.setInt(2, quantity);
			cs.setString(3, userId);
			
			cs.registerOutParameter(4, Types.NUMERIC);
			cs.execute();
			result = cs.getInt(4);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnection.close(null, cs, conn);
		}
		
		return result;
	}

	@Override
	public int deleteShoppingCart(String sql, int shoppingCartId) {
		Connection conn = DbConnection.getConnection();
		PreparedStatement ps = null;
		
		int result = 3;
		//String sql = "DELETE FROM t_shopping_cart WHERE shopping_cart_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, shoppingCartId);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnection.close(null, ps, conn);
		}	
		//0 失败
		//1 成功
		return result;
	}

	@Override
	public int selectSumCartPrice(String sql, String userId) {
		Connection conn = DbConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 3;
		//String sql = "SELECT SUM(product_id * quantity) FROM t_shopping_cart WHERE user_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
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
		//0 失败
		//1 成功
		return count;
	}

	

	public int updateShoppingCartByQuantity(String sql, int quantity,
			int productId, String userId) {
		Connection conn = DbConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 3;
		//String sql = "UPDATE t_shopping_cart SET quantity = ? WHERE product_id = ? AND user_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, quantity);
			ps.setInt(2, productId);
			ps.setString(3, userId);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnection.close(rs, ps, conn);
		}	
		//0 失败
		//1 成功
		return result;
	}



	
	

}
