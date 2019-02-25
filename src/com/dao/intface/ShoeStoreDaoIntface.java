package com.dao.intface;

import java.util.List;

import com.dao.*;
import com.domain.*;
/**
 * 首页和产品的 查询数据库方法接口参数，以及返回值
 */
public interface ShoeStoreDaoIntface {
	//查询用户是否存在
	public Tuser selectTuserByIdPsw(String sql,String userId,String password);
	
	//查询所有的鞋子品牌
	public List<Category> selectAllCategory(String sql);
	
	//通过鞋子ID查询该品牌所有鞋子，并分页查询;
	public List<Product> selectProductById(String sql,int categoryId,int begin,int end);
	
	//根据最新的鞋子 查询日期前6的商品
	public List<Product> selectNewProduct(String sql);
	
	//查询鞋子品牌ID下的所有鞋子的数量
	public int selectCountProductById(String sql,int categoryId);
	
	//更具鞋子的model查询该鞋子的详细信息;
	public Product selectthisProduct(String sql,String model);
	
	//根据鞋子的编号查询库存；
	public int selectQuantityById(String sql,int productId);
	
	//根据鞋子的价格越贵，热卖度越高,查询前4的商品
	public List<Product> selectPopolarProduct(String sql);
	
	//根据鞋子ID 查询鞋子数量
	public int selectshoeQuantity(String sql,int productId);
	
}
