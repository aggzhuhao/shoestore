package com.service.intface;

import java.util.List;

import com.domain.Order;
import com.domain.OrderDetail;

public interface ShoeOrderServiceIntface {
	/**
	 * ����
	 * 1.���붩��
	 * 2.���Ŀ��
	 * 3.���붩����ϸ
	 * 4.ɾ�����ﳵ����
	 */
	public int balanceOrder(double amount,String paymeny,String receive,String province,String city,String county,String address,String zipCode,String telphone,String userId);
	
	//��ѯ�û��Ķ�������
	public int selectAllOrderById(String userId);
	
	//--��ѯ��������
	//--��ѯ�û����ж���
	public List<Order> selectOrderById(String userId,int currentPage,int pageSize);
	
	//�鿴�û�������������
	public List<OrderDetail> quenryOrderById(int orderId);
}
