package com.service.intface;

import java.util.List;

import com.domain.Product;
import com.domain.ShoppingCart;

public interface ShopCarOrderServiceItface {
	public List<Product> selectADProduct(int begin);
	
	//通过用户ID 查询购物车内容
	public List<ShoppingCart> selecetShoppingCart(String userId);
	
	////通过鞋子的ID,数量,用户ID 添加至购物车, 并且用序列给购物车号加1
	public int insertShoppingCart(int productId,int quantity,String userId);
	
	//根据购物车的ID ，删除购物车
	public int deleteShoppingCart(int shoppingCartId);
	
	//计算购物车里的所有的商品的价格总和
	public int selectSumCartPrice(String userId);
	
	//根据用户的ID，鞋子，数量 更新数据库里的内容
	public int updateShoppingCartByQuantity(int quantity,int productId,String user_id);
}
