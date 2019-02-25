package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.ShoeStoreDao;
import com.dao.intface.ShoeStoreDaoIntface;
import com.domain.*;
import com.service.intface.ShoeStoreServiceIntface;



public class ShoeStoreService implements ShoeStoreServiceIntface {
	private ShoeStoreDaoIntface ssDao;
	
	public ShoeStoreService(){
		ssDao = new ShoeStoreDao();
	}
	
	public Tuser selectTuserByIdPsw(String userId, String password) {
		String sql =  "select user_id,Psw,tNAME FROM t_user WHERE user_id = ? AND Psw = ?";
		return ssDao.selectTuserByIdPsw(sql, userId, password);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ShoeStoreService s = new ShoeStoreService();
	/*	System.out.println(s.selectAllCategory());*/
		//System.out.println(s.selectProductById(11, 3, 1));
		/*System.out.println(s.selectthisProduct("T619N").getModel());*/
		//String sql = "SELECT * FROM (SELECT PRODUCT_id,DESCRIPTION,price,MODEL,FEATURE,imgpath,novalty_status,publish_date,d.category_id,c.name,ROWNUM r FROM t_product d, t_category c WHERE d.category_id = c.category_id ORDER BY price) WHERE r BETWEEN 1 AND 4";
		/*List<Product> l = new ArrayList<>();
		l = s.selectPopolarProduct();
		for(Product p : l){
			System.out.println(p.getName() + "!" + p.getCategoryId());
		}*/
	}

	@Override
	public List<Category> selectAllCategory() {
		String sql = "SELECT * FROM t_Category";
		return ssDao.selectAllCategory(sql);
	}

	@Override
	public List<Product> selectProductById(int categoryId,int currengPage, int pageSize) {
		String sql = "SELECT * FROM (SELECT PRODUCT_ID, DESCRIPTION,price,MODEL,FEATURE,imgpath,novalty_status,publish_date,category_id£¬ROWNUM r FROM t_product WHERE category_id = ?) WHERE r BETWEEN ? AND ?";
		int begin = (currengPage - 1) * pageSize + 1;
		int end = currengPage * pageSize;
		return ssDao.selectProductById(sql, categoryId, begin, end);
	}

	@Override
	public int selectCountProductById(int categoryId) {
		String sql = "SELECT COUNT(*) FROM T_product WHERE category_id = ?";
		return ssDao.selectCountProductById(sql, categoryId);
	}

	@Override
	public Product selectthisProduct(String model) {
		String sql = "SELECT * FROM t_product WHERE MODEL = ?";
		return ssDao.selectthisProduct(sql, model);
	}

	@Override
	public int selectQuantityById(int productId) {
		String sql = "SELECT quantity FROM t_stock WHERE product_id = ?";
		return ssDao.selectQuantityById(sql, productId);
	}

	@Override
	public List<Product> selectNewProduct() {
		String sql = "SELECT * FROM (SELECT PRODUCT_id,DESCRIPTION,price,MODEL,FEATURE,imgpath,novalty_status,publish_date,d.category_id,c.name,ROWNUM r FROM t_product d, t_category c WHERE d.category_id = c.category_id ORDER BY publish_date) WHERE r BETWEEN 1 AND 6";
		return ssDao.selectNewProduct(sql);
	}

	

	@Override
	public List<Product> selectPopolarProduct() {
		String sql = "SELECT * FROM (SELECT PRODUCT_id,DESCRIPTION,price,MODEL,FEATURE,imgpath,novalty_status,publish_date,d.category_id,c.name,ROWNUM r FROM t_product d, t_category c WHERE d.category_id = c.category_id ORDER BY publish_date) WHERE r BETWEEN 1 AND 4";
		
		return ssDao.selectPopolarProduct(sql);
	}

	@Override
	public int selectshoeQuantity(int productId) {
		String sql = "SELECT quantity FROM t_stock WHERE product_id = ? ";
		return ssDao.selectshoeQuantity(sql, productId);
	}
	

}