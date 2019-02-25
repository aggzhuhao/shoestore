package com.dao.intface;

import java.util.ArrayList;
import java.util.List;

import com.domain.Product;
import com.domain.ShoppingCart;

/**
 * 
 *购物车以及订单主要接口方法
 *
 */
public interface ShopCarOrderDaoIntface {
	//查询广告AD的显示的广告鞋子
	public List<Product> selectADProduct(String sql,int begin);
	
	
	
	//通过用户ID 查询购物车内容
	public List<ShoppingCart> selecetShoppingCart(String sql,String userId);
	
	//通过鞋子的ID,数量,用户ID 添加至购物车, 并且用序列给购物车号加1
	public int insertShoppingCart(String sql,int productId,int quantity,String userId);
	
	//根据购物车的ID ，删除购物车
	public int deleteShoppingCart(String sql,int shoppingCartId);
	
	//计算购物车里的所有的商品的价格总和
	public int selectSumCartPrice(String sql,String userId);
	
	//根据用户的ID，鞋子，数量 更新数据库里的内容;
	//UPDATE t_shopping_cart SET quantity = 4 WHERE product_id = 1275 AND user_id = 1001
	public int updateShoppingCartByQuantity(String sql,int quantity,int productId,String user_id);
}
