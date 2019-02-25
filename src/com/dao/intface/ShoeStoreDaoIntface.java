package com.dao.intface;

import java.util.List;

import com.dao.*;
import com.domain.*;
/**
 * ��ҳ�Ͳ�Ʒ�� ��ѯ���ݿⷽ���ӿڲ������Լ�����ֵ
 */
public interface ShoeStoreDaoIntface {
	//��ѯ�û��Ƿ����
	public Tuser selectTuserByIdPsw(String sql,String userId,String password);
	
	//��ѯ���е�Ь��Ʒ��
	public List<Category> selectAllCategory(String sql);
	
	//ͨ��Ь��ID��ѯ��Ʒ������Ь�ӣ�����ҳ��ѯ;
	public List<Product> selectProductById(String sql,int categoryId,int begin,int end);
	
	//�������µ�Ь�� ��ѯ����ǰ6����Ʒ
	public List<Product> selectNewProduct(String sql);
	
	//��ѯЬ��Ʒ��ID�µ�����Ь�ӵ�����
	public int selectCountProductById(String sql,int categoryId);
	
	//����Ь�ӵ�model��ѯ��Ь�ӵ���ϸ��Ϣ;
	public Product selectthisProduct(String sql,String model);
	
	//����Ь�ӵı�Ų�ѯ��棻
	public int selectQuantityById(String sql,int productId);
	
	//����Ь�ӵļ۸�Խ��������Խ��,��ѯǰ4����Ʒ
	public List<Product> selectPopolarProduct(String sql);
	
	//����Ь��ID ��ѯЬ������
	public int selectshoeQuantity(String sql,int productId);
	
}
