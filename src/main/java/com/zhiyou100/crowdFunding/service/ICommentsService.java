package com.zhiyou100.crowdFunding.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zhiyou100.crowdFunding.vo.Comments;

public interface ICommentsService {
	/** 添加 */
	boolean add(Comments vo) throws Exception;

	/** 更改 */
	boolean edit(Comments vo) throws Exception;

	/** 根据id删除一个 */
	boolean remove(Integer id) throws Exception;

	/** 根据id批量删除 */
	boolean removeBatch(Set<Integer> ids) throws Exception;

	/** 根据id查找一个 */
	Comments findById(Integer id) throws Exception;

	/** 查找全部 并分页 */
	List<Comments> findAll(Map<String, Object> map) throws Exception;

	/** 模糊查询并分页 */
	List<Comments> findAllSplit(Map<String, Object> map) throws Exception;

	/** 查询 全部数量 */
	Long getAllCount() throws Exception;

	/** 模糊查询 数量 */
	Long getAllCountSplit(Map<String, Object> map) throws Exception;
	
	/** */
	Comments findByPstidAndUsId(Map<String, Object> map) throws Exception;
}
