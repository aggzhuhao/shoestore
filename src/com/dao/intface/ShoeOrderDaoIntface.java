package com.dao.intface;

import java.util.List;

import com.domain.Order;
import com.domain.OrderDetail;

public interface ShoeOrderDaoIntface {
	/**
	 * 结算
	 * 1.插入订单
	 * 2.更改库存
	 * 3.插入订单明细
	 * 4.删除购物车内容
	 * SELECT o.order_id,create_time,amount,payment,receiver,province,city,county,address,zipcode,telphone,user_id,d.product_id,p.description,d.quantity FROM t_order o,t_order_detail d,t_product p WHERE o.order_id = d.order_id AND o.order_id = ? AND d.product_id = p.product_id
	 */
	public int balanceOrder(String sql,double amount,String paymeny,String receive,String province,String city,String county,String address,String zipCode,String telphone,String userId);
	
	//查询用户的订单总数
	public int selectAllOrderById(String sql,String userId);
	
	//--查询用户所有订单
	public List<Order> selectOrderById(String sql,String userId,int begin,int end);
	
	//查看用户单个订单详情
	public List<OrderDetail> quenryOrderById(String sql,int orderId);
}
