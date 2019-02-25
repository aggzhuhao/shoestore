package com.dao.intface;

import java.util.ArrayList;
import java.util.List;

import com.domain.Product;
import com.domain.ShoppingCart;

/**
 * 
 *���ﳵ�Լ�������Ҫ�ӿڷ���
 *
 */
public interface ShopCarOrderDaoIntface {
	//��ѯ���AD����ʾ�Ĺ��Ь��
	public List<Product> selectADProduct(String sql,int begin);
	
	
	
	//ͨ���û�ID ��ѯ���ﳵ����
	public List<ShoppingCart> selecetShoppingCart(String sql,String userId);
	
	//ͨ��Ь�ӵ�ID,����,�û�ID ��������ﳵ, ���������и����ﳵ�ż�1
	public int insertShoppingCart(String sql,int productId,int quantity,String userId);
	
	//���ݹ��ﳵ��ID ��ɾ�����ﳵ
	public int deleteShoppingCart(String sql,int shoppingCartId);
	
	//���㹺�ﳵ������е���Ʒ�ļ۸��ܺ�
	public int selectSumCartPrice(String sql,String userId);
	
	//�����û���ID��Ь�ӣ����� �������ݿ��������;
	//UPDATE t_shopping_cart SET quantity = 4 WHERE product_id = 1275 AND user_id = 1001
	public int updateShoppingCartByQuantity(String sql,int quantity,int productId,String user_id);
}
