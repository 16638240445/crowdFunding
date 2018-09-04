package com.zhiyou100.crowdFunding.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zhiyou100.crowdFunding.vo.Letter;

public interface ILetterService {
	/** ��� */
	boolean add(Letter vo) throws Exception;

	/** ���� */
	boolean edit(Letter vo) throws Exception;

	/** ����idɾ��һ�� */
	boolean remove(Integer id) throws Exception;

	/** ����id����ɾ�� */
	boolean removeBatch(Set<Integer> ids) throws Exception;

	/** ����id����һ�� */
	Letter findById(Integer id) throws Exception;

	/** ����ȫ�� ����ҳ */
	List<Letter> findAll(Map<String, Object> map) throws Exception;

	/** ģ����ѯ����ҳ */
	List<Letter> findAllSplit(Map<String, Object> map) throws Exception;

	/** ��ѯ ȫ������ */
	Long getAllCount() throws Exception;

	/** ģ����ѯ ���� */
	Long getAllCountSplit(Map<String, Object> map) throws Exception;
}
