package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.dao.intface.ShoeOrderDaoIntface;
import com.domain.*;
import com.jdbc.DbConnection;

public class ShoeOrderDao implements ShoeOrderDaoIntface {

	@Override
	public int balanceOrder(String sql, double amount, String paymeny,
			String receive, String province, String city, String county,
			String address, String zipCode, String telphone, String userId) {
		int result = 2;
		Order order = new Order();
		Connection conn = null;
		CallableStatement cs = null;
		conn = DbConnection.getConnection();
		try {
			cs = conn.prepareCall(sql);
			cs.setDouble(1, amount);
			cs.setString(2, paymeny);
			cs.setString(3, receive);
			cs.setString(4, province);
			cs.setString(5, city);
			cs.setString(6, county);
			cs.setString(7, address);
			cs.setString(8, zipCode);
			cs.setString(9, telphone);
			cs.setString(10, userId);
			
			cs.registerOutParameter(11, Types.NUMERIC);
			
			cs.execute();
			result = cs.getInt(11);
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}

	
	public static void main(String[] args) {
		ShoeOrderDao s = new ShoeOrderDao();
		/*String sql = "{call scott.sp_insert_orderno(?,?,?,?,?,?,?,?,?,?,?)}";
		System.out.println(s.balanceOrder(sql, 12.1, "1", "1", "1", "3", "3", "1", "12", "21", "1003"));*/
		/*String sql = "select * from t_order where user_id = ?";
		List<Order> orderList = new ArrayList<Order>();
		orderList = s.selectOrderById(sql, "1001");
		for(Order o : orderList){
			System.out.println(o.getAddress());
		}*/
		/*String sql = "SELECT o.order_id,create_time,amount,payment,receiver,province,city,county,address,zipcode,telphone,user_id,d.product_id,p.description,d.quantity,price FROM t_order o,t_order_detail d,t_product p WHERE o.order_id = d.order_id AND o.order_id = ? AND d.product_id = p.product_id";
		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
		orderDetailList = s.quenryOrderById(sql, 55993553);
		for(OrderDetail o : orderDetailList){
			System.out.println(o.getDescription());
		}*/
		/*String sql = "SELECT COUNT(*) FROM t_order WHERE user_id = ?";
		System.out.println(s.selectAllOrderById(sql, "1001"));*/
		//String sql = "SELECT order_id,create_time,amount,payment,receiver,province,city,county,address,zipcode,telphone,user_id FROM (select order_id,create_time,amount,payment,receiver,province,city,county,address,zipcode,telphone,user_id,ROWNUM r from t_order where user_id = ?) WHERE r BETWEEN ? AND ?";
		//System.out.println(s.selectOrderById(sql, "1001", 1, 10));
	}


	@Override
	public List<Order> selectOrderById(String sql,String userId,int begin,int end) {
		//String sql = "SELECT order_id,create_time,amount,payment,receiver,province,city,county,address,zipcode,telphone,user_id FROM (select order_id,create_time,amount,payment,receiver,province,city,county,address,zipcode,telphone,user_id,ROWNUM r from t_order where user_id = ?) WHERE r BETWEEN ? AND ?";
		Connection conn = DbConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Order> orderList = new ArrayList<Order>();
		Order order = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setInt(2, begin);
			ps.setInt(3, end);
			rs = ps.executeQuery();
			while(rs.next()){
				int orderId = rs.getInt(1);
				String date = rs.getString(2);
				double amount = rs.getDouble(3);
				String paument = rs.getString(4);
				String receiver = rs.getString(5);
				String province = rs.getString(6);
				String city = rs.getString(7);
				String county = rs.getString(8);
				String address = rs.getString(9);
				String zipCode = rs.getString(10);
				String telphone = rs.getString(11);
				String userId1 = rs.getString(12);
				order = new Order(orderId, date, amount, paument, receiver, province, city, county, address, zipCode, telphone, userId1);
				orderList.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnection.close(rs, ps, conn);
		}
		
		
		return orderList;
	}


	@Override
	public List<OrderDetail> quenryOrderById(String sql,int orderId) {
		//String sql = "SELECT o.order_id,create_time,amount,payment,receiver,province,city,county,address,zipcode,telphone,user_id,d.product_id,p.description,d.quantity,price FROM t_order o,t_order_detail d,t_product p WHERE o.order_id = d.order_id AND o.order_id = ? AND d.product_id = p.product_id";
		Connection conn = DbConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, orderId);
			rs = ps.executeQuery();
			while(rs.next()){
				int orderId1 = rs.getInt(1);
				String date = rs.getString(2);
				double amount = rs.getDouble(3);
				String paument = rs.getString(4);
				String receiver = rs.getString(5);
				String province = rs.getString(6);
				String city = rs.getString(7);
				String county = rs.getString(8);
				String address = rs.getString(9);
				String zipCode = rs.getString(10);
				String telphone = rs.getString(11);
				String userId1 = rs.getString(12);
				String productId = rs.getString(13);
				String description = rs.getString(14);
				int quantity = rs.getInt(15);
				double price = rs.getDouble(16);
				OrderDetail deOrderDetail = new OrderDetail(orderId1, date, amount, paument, receiver, province, city, county, address, zipCode, telphone, userId1, productId, description, quantity, price);
				orderDetailList.add(deOrderDetail);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnection.close(rs, ps, conn);
		}
		return orderDetailList;
	}


	@Override
	public int selectAllOrderById(String sql, String userId) {
		
		int count = 0;
		//String sql = "SELECT COUNT(*) FROM t_order WHERE user_id = ?";
		Connection conn = DbConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
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
		return count;
	}

}
