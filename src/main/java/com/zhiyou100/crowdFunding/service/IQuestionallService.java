package com.zhiyou100.crowdFunding.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zhiyou100.crowdFunding.vo.Questionall;

public interface IQuestionallService {
	/** ��� */
	boolean add(Questionall vo) throws Exception;

	/** ���� */
	boolean edit(Questionall vo) throws Exception;

	/** ����idɾ��һ�� */
	boolean remove(Integer id) throws Exception;

	/** ����id����ɾ�� */
	boolean removeBatch(Set<Integer> ids) throws Exception;

	/** ����id����һ�� */
	Questionall findById(Integer id) throws Exception;

	/** ����ȫ�� ����ҳ */
	List<Questionall> findAll(Map<String, Object> map) throws Exception;

	/** ģ����ѯ����ҳ */
	List<Questionall> findAllSplit(Map<String, Object> map) throws Exception;

	/** ��ѯ ȫ������ */
	Long getAllCount() throws Exception;

	/** ģ����ѯ ���� */
	Long getAllCountSplit(Map<String, Object> map) throws Exception;

	/** ����ȫ��������� */
	List<Questionall> findAll() throws Exception;
}
