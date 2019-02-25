package com.service;

import java.util.List;

import com.dao.ShopCarOrderDao;
import com.dao.intface.*;
import com.domain.*;
import com.service.intface.*;

public class ShopCarOrderService implements ShopCarOrderServiceItface {
	private ShopCarOrderDaoIntface scoDao;
	public ShopCarOrderService(){
		scoDao = new ShopCarOrderDao();
	}
	public List<Product> selectADProduct(int begin) {
		String sql = "SELECT * FROM (SELECT d.PRODUCT_id,d.DESCRIPTION,price,MODEL,FEATURE,s.imgpath,novalty_status,publish_date,d.category_id£¬c.name,ROWNUM r FROM t_product d, t_category c ,t_slider s WHERE d.category_id = c.category_id AND d.product_id = s.product_id ORDER BY price)WHERE r BETWEEN 1 AND ?";
		return scoDao.selectADProduct(sql, begin);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String sql = "SELECT shopping_cart_id,s.product_id,quantity,s.user_id,price,imgpath,description FROM t_shopping_cart s,t_product p WHERE p.product_id = s.product_id AND s.user_id = ?";
		ShopCarOrderDaoIntface scoDao =  new ShopCarOrderDao();
		System.out.println(scoDao.selecetShoppingCart(sql, "1001"));
	}
	@Override
	public List<ShoppingCart> selecetShoppingCart(String userId) {
		String sql = "SELECT shopping_cart_id,s.product_id,quantity,s.user_id,price,imgpath,description FROM t_shopping_cart s,t_product p WHERE p.product_id = s.product_id AND s.user_id = ?";
		return scoDao.selecetShoppingCart(sql, userId);
	}
	@Override
	public int insertShoppingCart(int productId, int quantity, String userId) {
		String sql = "{call scott.sp_insert_shoppingcartno(?,?,?,?)}";
		return scoDao.insertShoppingCart(sql, productId, quantity, userId);
	}
	@Override
	public int deleteShoppingCart(int shoppingCartId) {
		String sql = "DELETE FROM t_shopping_cart WHERE shopping_cart_id = ?";
		return scoDao.deleteShoppingCart(sql, shoppingCartId);
	}
	@Override
	public int selectSumCartPrice(String userId) {
		String sql = "SELECT SUM(price * quantity) FROM t_shopping_cart s,t_product p WHERE user_id = ? AND s.product_id = p.product_id ";
		return scoDao.selectSumCartPrice(sql, userId);
	}
	@Override
	public int updateShoppingCartByQuantity(int quantity, int productId,
			String user_id) {
		String sql = "UPDATE t_shopping_cart SET quantity = ? WHERE product_id = ? AND user_id = ?";
		return scoDao.updateShoppingCartByQuantity(sql, quantity, productId, user_id);
	}

	

}
