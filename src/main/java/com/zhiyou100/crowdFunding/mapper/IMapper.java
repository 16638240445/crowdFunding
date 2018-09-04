package com.zhiyou100.crowdFunding.mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * mapper�ܽӿڣ�dao�㣩
 * 
 * @author Administrator
 *
 * @param <K>
 * @param <V>
 */
public interface IMapper<K, V> {
	/** ��� */
	boolean doCreate(V vo) throws Exception;

	/** ���� */
	boolean doUpdate(V vo) throws Exception;

	/** ����idɾ��һ�� */
	boolean doRemove(K id) throws Exception;

	/** ����id����ɾ�� */
	boolean doRemoveBatch(Set<K> ids) throws Exception;

	/** ����id����һ�� */
	V findById(K id) throws Exception;

	/** ����ȫ������ҳ */
	List<V> findAll(Map<String,Object> map) throws Exception;

	/** ģ����ѯ����ҳ */
	List<V> findAllSplit(Map<String, Object> map) throws Exception;

	/** ��ѯȫ������ */
	Long getAllCount() throws Exception;

	/** ģ����ѯ���� */
	Long getAllCountSplit(Map<String, Object> map) throws Exception;
}
