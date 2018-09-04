package com.zhiyou100.crowdFunding.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zhiyou100.crowdFunding.vo.Admin;

public interface IAdminService {
	/** 添加管理员 */
	boolean add(Admin vo) throws Exception;

	/** 更改管理员 */
	boolean edit(Admin vo) throws Exception;

	/** 根据id删除一个管理员 */
	boolean remove(Integer id) throws Exception;

	/** 根据id批量删除管理员 */
	boolean removeBatch(Set<Integer> ids) throws Exception;

	/** 根据id查找一个管理员 */
	Admin findById(Integer id) throws Exception;

	/** 查找全部管理员并分页 */
	List<Admin> findAll(Map<String, Object> map) throws Exception;

	/** 模糊查询并分页管理员 */
	List<Admin> findAllSplit(Map<String, Object> map) throws Exception;

	/** 查询管理员全部数量 */
	Long getAllCount() throws Exception;

	/** 模糊查询管理员数量 */
	Long getAllCountSplit(Map<String, Object> map) throws Exception;

	/** 通过账号密码查找用户 */
	Admin findByLogin(Map<String, Object> map) throws Exception;
}
