package com.zhiyou100.crowdFunding.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zhiyou100.crowdFunding.vo.User;

public interface IUserService {
	/** 添加管理员 */
	boolean add(User vo) throws Exception;

	/** 更改管理员 */
	boolean edit(User vo) throws Exception;

	/** 根据id删除一个管理员 */
	boolean remove(Integer id) throws Exception;

	/** 根据id批量删除管理员 */
	boolean removeBatch(Set<Integer> ids) throws Exception;

	/** 根据id查找一个管理员 */
	User findById(Integer id) throws Exception;

	/** 查找全部管理员并分页 */
	List<User> findAll(Map<String, Object> map) throws Exception;

	/** 模糊查询并分页管理员 */
	List<User> findAllSplit(Map<String, Object> map) throws Exception;

	/** 查询管理员全部数量 */
	Long getAllCount() throws Exception;

	/** 模糊查询管理员数量 */
	Long getAllCountSplit(Map<String, Object> map) throws Exception;
	
	/** 通过账号密码查找用户 */
	User findByLogin(Map<String, Object> map) throws Exception;
	
	/**通过邮箱进行查找*/
	User findByEmail(String email) throws Exception;
	
	/**更改用户状态*/
	boolean doUpdateRole(Integer id) throws Exception;
	
}
