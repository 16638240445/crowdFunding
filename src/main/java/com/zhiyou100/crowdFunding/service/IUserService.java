package com.zhiyou100.crowdFunding.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zhiyou100.crowdFunding.vo.User;

public interface IUserService {
	/** ��ӹ���Ա */
	boolean add(User vo) throws Exception;

	/** ���Ĺ���Ա */
	boolean edit(User vo) throws Exception;

	/** ����idɾ��һ������Ա */
	boolean remove(Integer id) throws Exception;

	/** ����id����ɾ������Ա */
	boolean removeBatch(Set<Integer> ids) throws Exception;

	/** ����id����һ������Ա */
	User findById(Integer id) throws Exception;

	/** ����ȫ������Ա����ҳ */
	List<User> findAll(Map<String, Object> map) throws Exception;

	/** ģ����ѯ����ҳ����Ա */
	List<User> findAllSplit(Map<String, Object> map) throws Exception;

	/** ��ѯ����Աȫ������ */
	Long getAllCount() throws Exception;

	/** ģ����ѯ����Ա���� */
	Long getAllCountSplit(Map<String, Object> map) throws Exception;
	
	/** ͨ���˺���������û� */
	User findByLogin(Map<String, Object> map) throws Exception;
	
	/**ͨ��������в���*/
	User findByEmail(String email) throws Exception;
	
	/**�����û�״̬*/
	boolean doUpdateRole(Integer id) throws Exception;
	
}
