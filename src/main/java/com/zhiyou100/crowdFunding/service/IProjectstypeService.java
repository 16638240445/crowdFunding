package com.zhiyou100.crowdFunding.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zhiyou100.crowdFunding.vo.Projectstype;

public interface IProjectstypeService {
	/** ��� */
	boolean add(Projectstype vo) throws Exception;

	/** ���� */
	boolean edit(Projectstype vo) throws Exception;

	/** ����idɾ��һ�� */
	boolean remove(Integer id) throws Exception;

	/** ����id����ɾ�� */
	boolean removeBatch(Set<Integer> ids) throws Exception;

	/** ����id����һ�� */
	Projectstype findById(Integer id) throws Exception;

	/** ����ȫ�� ����ҳ */
	List<Projectstype> findAll(Map<String, Object> map) throws Exception;

	/** ģ����ѯ����ҳ */
	List<Projectstype> findAllSplit(Map<String, Object> map) throws Exception;

	/** ��ѯ ȫ������ */
	Long getAllCount() throws Exception;

	/** ģ����ѯ ���� */
	Long getAllCountSplit(Map<String, Object> map) throws Exception;
	
	/** ����ȫ������ */
	List<Projectstype> findAllTypes() throws Exception;
}
