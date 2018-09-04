package com.zhiyou100.crowdFunding.mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * mapper总接口（dao层）
 * 
 * @author Administrator
 *
 * @param <K>
 * @param <V>
 */
public interface IMapper<K, V> {
	/** 添加 */
	boolean doCreate(V vo) throws Exception;

	/** 更改 */
	boolean doUpdate(V vo) throws Exception;

	/** 根据id删除一个 */
	boolean doRemove(K id) throws Exception;

	/** 根据id批量删除 */
	boolean doRemoveBatch(Set<K> ids) throws Exception;

	/** 根据id查找一个 */
	V findById(K id) throws Exception;

	/** 查找全部兵分页 */
	List<V> findAll(Map<String,Object> map) throws Exception;

	/** 模糊查询并分页 */
	List<V> findAllSplit(Map<String, Object> map) throws Exception;

	/** 查询全部数量 */
	Long getAllCount() throws Exception;

	/** 模糊查询数量 */
	Long getAllCountSplit(Map<String, Object> map) throws Exception;
}
