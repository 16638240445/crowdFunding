package com.zhiyou100.crowdFunding.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zhiyou100.crowdFunding.vo.Comments;

public interface ICommentsService {
	/** ��� */
	boolean add(Comments vo) throws Exception;

	/** ���� */
	boolean edit(Comments vo) throws Exception;

	/** ����idɾ��һ�� */
	boolean remove(Integer id) throws Exception;

	/** ����id����ɾ�� */
	boolean removeBatch(Set<Integer> ids) throws Exception;

	/** ����id����һ�� */
	Comments findById(Integer id) throws Exception;

	/** ����ȫ�� ����ҳ */
	List<Comments> findAll(Map<String, Object> map) throws Exception;

	/** ģ����ѯ����ҳ */
	List<Comments> findAllSplit(Map<String, Object> map) throws Exception;

	/** ��ѯ ȫ������ */
	Long getAllCount() throws Exception;

	/** ģ����ѯ ���� */
	Long getAllCountSplit(Map<String, Object> map) throws Exception;
	
	/** */
	Comments findByPstidAndUsId(Map<String, Object> map) throws Exception;
}
