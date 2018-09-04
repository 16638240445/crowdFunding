package com.zhiyou100.crowdFunding.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zhiyou100.crowdFunding.vo.Admin;

public interface IAdminService {
	/** ��ӹ���Ա */
	boolean add(Admin vo) throws Exception;

	/** ���Ĺ���Ա */
	boolean edit(Admin vo) throws Exception;

	/** ����idɾ��һ������Ա */
	boolean remove(Integer id) throws Exception;

	/** ����id����ɾ������Ա */
	boolean removeBatch(Set<Integer> ids) throws Exception;

	/** ����id����һ������Ա */
	Admin findById(Integer id) throws Exception;

	/** ����ȫ������Ա����ҳ */
	List<Admin> findAll(Map<String, Object> map) throws Exception;

	/** ģ����ѯ����ҳ����Ա */
	List<Admin> findAllSplit(Map<String, Object> map) throws Exception;

	/** ��ѯ����Աȫ������ */
	Long getAllCount() throws Exception;

	/** ģ����ѯ����Ա���� */
	Long getAllCountSplit(Map<String, Object> map) throws Exception;

	/** ͨ���˺���������û� */
	Admin findByLogin(Map<String, Object> map) throws Exception;
}
