package com.service.intface;

import java.util.List;

import com.domain.Order;
import com.domain.OrderDetail;

public interface ShoeOrderServiceIntface {
	/**
	 * 结算
	 * 1.插入订单
	 * 2.更改库存
	 * 3.插入订单明细
	 * 4.删除购物车内容
	 */
	public int balanceOrder(double amount,String paymeny,String receive,String province,String city,String county,String address,String zipCode,String telphone,String userId);
	
	//查询用户的订单总数
	public int selectAllOrderById(String userId);
	
	//--查询订单详情
	//--查询用户所有订单
	public List<Order> selectOrderById(String userId,int currentPage,int pageSize);
	
	//查看用户单个订单详情
	public List<OrderDetail> quenryOrderById(int orderId);
}
