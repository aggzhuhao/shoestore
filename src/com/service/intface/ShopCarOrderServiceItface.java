package com.service.intface;

import java.util.List;

import com.domain.Product;
import com.domain.ShoppingCart;

public interface ShopCarOrderServiceItface {
	public List<Product> selectADProduct(int begin);
	
	//ͨ���û�ID ��ѯ���ﳵ����
	public List<ShoppingCart> selecetShoppingCart(String userId);
	
	////ͨ��Ь�ӵ�ID,����,�û�ID ��������ﳵ, ���������и����ﳵ�ż�1
	public int insertShoppingCart(int productId,int quantity,String userId);
	
	//���ݹ��ﳵ��ID ��ɾ�����ﳵ
	public int deleteShoppingCart(int shoppingCartId);
	
	//���㹺�ﳵ������е���Ʒ�ļ۸��ܺ�
	public int selectSumCartPrice(String userId);
	
	//�����û���ID��Ь�ӣ����� �������ݿ��������
	public int updateShoppingCartByQuantity(int quantity,int productId,String user_id);
}
