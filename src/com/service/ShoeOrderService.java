package com.service;

import java.util.List;

import com.dao.*;
import com.dao.intface.*;
import com.domain.Order;
import com.domain.OrderDetail;
import com.service.intface.*;

public class ShoeOrderService implements ShoeOrderServiceIntface {
	private ShoeOrderDaoIntface soDao;
	
	public ShoeOrderService(){
		soDao = new ShoeOrderDao();
	}
	
	//Ω·À„
	public int balanceOrder(double amount, String paymeny,
			String receive, String province, String city, String county,
			String address, String zipCode, String telphone, String userId) {
		String sql = "{call scott.sp_insert_orderno(?,?,?,?,?,?,?,?,?,?,?)}";
		return soDao.balanceOrder(sql, amount, paymeny, receive, province, city, county, address, zipCode, telphone, userId);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}

	@Override
	public List<Order> selectOrderById(String userId,int currentPage,int pageSize) {
		String sql = "SELECT order_id,create_time,amount,payment,receiver,province,city,county,address,zipcode,telphone,user_id FROM (select order_id,create_time,amount,payment,receiver,province,city,county,address,zipcode,telphone,user_id,ROWNUM r from t_order where user_id = ? ORDER BY create_time DESC) WHERE r BETWEEN ? AND ?";
		int begin = (currentPage - 1) * pageSize + 1;
		int end = currentPage * pageSize;
		return soDao.selectOrderById(sql, userId, begin, end);
	}

	@Override
	public List<OrderDetail> quenryOrderById(int orderId) {
		String sql = "SELECT o.order_id,create_time,amount,payment,receiver,province,city,county,address,zipcode,telphone,user_id,d.product_id,p.description,d.quantity,price FROM t_order o,t_order_detail d,t_product p WHERE o.order_id = d.order_id AND o.order_id = ? AND d.product_id = p.product_id";
		return soDao.quenryOrderById(sql, orderId);
	}

	@Override
	public int selectAllOrderById(String userId) {
		String sql = "SELECT COUNT(*) FROM t_order WHERE user_id = ?";
		return soDao.selectAllOrderById(sql, userId);
	}

}
