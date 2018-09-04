package com.zhiyou100.crowdFunding.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zhiyou100.crowdFunding.vo.Projects;

public interface IProjectsService {

	/** 添加 */
	boolean add(Projects vo) throws Exception;

	/** 更改 */
	boolean edit(Projects vo) throws Exception;

	/** 根据id删除一个 */
	boolean remove(Integer id) throws Exception;

	/** 根据id批量删除 */
	boolean removeBatch(Set<Integer> ids) throws Exception;

	/** 根据id查找一个 */
	Projects findById(Integer id) throws Exception;

	/** 查找全部 并分页 */
	List<Projects> findAll(Map<String, Object> map) throws Exception;

	/** 模糊查询并分页 */
	List<Projects> findAllSplit(Map<String, Object> map) throws Exception;

	/** 查询 全部数量 */
	Long getAllCount() throws Exception;

	/** 模糊查询 数量 */
	Long getAllCountSplit(Map<String, Object> map) throws Exception;

	/** 审核项目 */
	boolean doUpdateByReview(Projects vo) throws Exception;

	/** 通过邮箱或者手机号进行查找 */
	List<Projects> findByEmail(String email) throws Exception;

	/** 通过邮箱或者手机号查询正在众筹中的项目 */
	List<Projects> findByType(String email) throws Exception;

	/** 所有项目中的多条件查询 */
	List<Projects> findByTerm(Map<String, Object> map) throws Exception;

	/** 查询审核总数量 */
	Long getCountByReview() throws Exception;

	/** 发布项目时插入项目信息 */
	boolean doUpdateProjects(Projects vo) throws Exception;

	/** 发布项目时插入项目详情信息 */
	boolean doUpdateProjectsDetail(Projects vo) throws Exception;
}
