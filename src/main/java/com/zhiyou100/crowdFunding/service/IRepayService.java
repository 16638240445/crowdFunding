package com.zhiyou100.crowdFunding.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zhiyou100.crowdFunding.vo.Repay;

public interface IRepayService {
	/** ��� */
	boolean add(Repay vo) throws Exception;

	/** ���� */
	boolean edit(Repay vo) throws Exception;

	/** ����idɾ��һ�� */
	boolean remove(Integer id) throws Exception;

	/** ����id����ɾ�� */
	boolean removeBatch(Set<Integer> ids) throws Exception;

	/** ����id����һ�� */
	Repay findById(Integer id) throws Exception;

	/** ����ȫ�� ����ҳ */
	List<Repay> findAll(Map<String, Object> map) throws Exception;

	/** ģ����ѯ����ҳ */
	List<Repay> findAllSplit(Map<String, Object> map) throws Exception;

	/** ��ѯ ȫ������ */
	Long getAllCount() throws Exception;

	/** ģ����ѯ ���� */
	Long getAllCountSplit(Map<String, Object> map) throws Exception;
}
