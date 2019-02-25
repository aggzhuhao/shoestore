package com.service.intface;

import java.util.List;


import com.domain.*;

public interface ShoeStoreServiceIntface {
	//��ѯ�û��Ƿ����
	public Tuser selectTuserByIdPsw(String userId,String password);
	
	//��ѯ���е�Ь��Ʒ��
	public List<Category>  selectAllCategory();
	
	//����Ь�ӵ�Ʒ�Ʋ�ѯ��Ʒ�����е�Ь��
	public List<Product> selectProductById(int categoryId,int currengPage,int pageSize);
	
	//����Ь�ӵ����ڣ���ѯ���µ�6��Ь��
	public List<Product> selectNewProduct();
	
	//��ѯЬ��ID�µ�����Ь�ӵ�����
	public int selectCountProductById(int categoryId);
	
	//����Ь�ӵ�model��ѯ��Ь�ӵ�������Ϣ
	public Product selectthisProduct(String model);
	
	//����Ь�ӵı�Ų�ѯ��棻
	public int selectQuantityById(int productId);
	
	//����Ь�ӵļ۸�Խ��������Խ��,��ѯǰ4����Ʒ
	public List<Product> selectPopolarProduct();
	
	//����Ь��ID ��ѯЬ������
	public int selectshoeQuantity(int productId);
}
