package com.service.intface;

import java.util.List;


import com.domain.*;

public interface ShoeStoreServiceIntface {
	//查询用户是否存在
	public Tuser selectTuserByIdPsw(String userId,String password);
	
	//查询所有的鞋子品牌
	public List<Category>  selectAllCategory();
	
	//根据鞋子的品牌查询该品牌所有的鞋子
	public List<Product> selectProductById(int categoryId,int currengPage,int pageSize);
	
	//根据鞋子的日期，查询最新的6款鞋子
	public List<Product> selectNewProduct();
	
	//查询鞋子ID下的所有鞋子的数量
	public int selectCountProductById(int categoryId);
	
	//根据鞋子的model查询该鞋子的所有信息
	public Product selectthisProduct(String model);
	
	//根据鞋子的编号查询库存；
	public int selectQuantityById(int productId);
	
	//根据鞋子的价格越贵，热卖度越高,查询前4的商品
	public List<Product> selectPopolarProduct();
	
	//根据鞋子ID 查询鞋子数量
	public int selectshoeQuantity(int productId);
}
