package com.dao.intface;

import java.util.List;

import com.domain.Order;
import com.domain.OrderDetail;

public interface ShoeOrderDaoIntface {
	/**
	 * ����
	 * 1.���붩��
	 * 2.���Ŀ��
	 * 3.���붩����ϸ
	 * 4.ɾ�����ﳵ����
	 * SELECT o.order_id,create_time,amount,payment,receiver,province,city,county,address,zipcode,telphone,user_id,d.product_id,p.description,d.quantity FROM t_order o,t_order_detail d,t_product p WHERE o.order_id = d.order_id AND o.order_id = ? AND d.product_id = p.product_id
	 */
	public int balanceOrder(String sql,double amount,String paymeny,String receive,String province,String city,String county,String address,String zipCode,String telphone,String userId);
	
	//��ѯ�û��Ķ�������
	public int selectAllOrderById(String sql,String userId);
	
	//--��ѯ�û����ж���
	public List<Order> selectOrderById(String sql,String userId,int begin,int end);
	
	//�鿴�û�������������
	public List<OrderDetail> quenryOrderById(String sql,int orderId);
}
