package com.zhiyou100.crowdFunding.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zhiyou100.crowdFunding.vo.Projects;

public interface IProjectsService {

	/** ��� */
	boolean add(Projects vo) throws Exception;

	/** ���� */
	boolean edit(Projects vo) throws Exception;

	/** ����idɾ��һ�� */
	boolean remove(Integer id) throws Exception;

	/** ����id����ɾ�� */
	boolean removeBatch(Set<Integer> ids) throws Exception;

	/** ����id����һ�� */
	Projects findById(Integer id) throws Exception;

	/** ����ȫ�� ����ҳ */
	List<Projects> findAll(Map<String, Object> map) throws Exception;

	/** ģ����ѯ����ҳ */
	List<Projects> findAllSplit(Map<String, Object> map) throws Exception;

	/** ��ѯ ȫ������ */
	Long getAllCount() throws Exception;

	/** ģ����ѯ ���� */
	Long getAllCountSplit(Map<String, Object> map) throws Exception;

	/** �����Ŀ */
	boolean doUpdateByReview(Projects vo) throws Exception;

	/** ͨ����������ֻ��Ž��в��� */
	List<Projects> findByEmail(String email) throws Exception;

	/** ͨ����������ֻ��Ų�ѯ�����ڳ��е���Ŀ */
	List<Projects> findByType(String email) throws Exception;

	/** ������Ŀ�еĶ�������ѯ */
	List<Projects> findByTerm(Map<String, Object> map) throws Exception;

	/** ��ѯ��������� */
	Long getCountByReview() throws Exception;

	/** ������Ŀʱ������Ŀ��Ϣ */
	boolean doUpdateProjects(Projects vo) throws Exception;

	/** ������Ŀʱ������Ŀ������Ϣ */
	boolean doUpdateProjectsDetail(Projects vo) throws Exception;
}
