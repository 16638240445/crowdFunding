package com.zhiyou100.crowdFunding.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zhiyou100.crowdFunding.vo.Repay;

public interface IRepayService {
	/** 添加 */
	boolean add(Repay vo) throws Exception;

	/** 更改 */
	boolean edit(Repay vo) throws Exception;

	/** 根据id删除一个 */
	boolean remove(Integer id) throws Exception;

	/** 根据id批量删除 */
	boolean removeBatch(Set<Integer> ids) throws Exception;

	/** 根据id查找一个 */
	Repay findById(Integer id) throws Exception;

	/** 查找全部 并分页 */
	List<Repay> findAll(Map<String, Object> map) throws Exception;

	/** 模糊查询并分页 */
	List<Repay> findAllSplit(Map<String, Object> map) throws Exception;

	/** 查询 全部数量 */
	Long getAllCount() throws Exception;

	/** 模糊查询 数量 */
	Long getAllCountSplit(Map<String, Object> map) throws Exception;
}
