package com.zhiyou100.crowdFunding.mapper;

import java.util.Map;

import com.zhiyou100.crowdFunding.vo.User;

public interface IUserMapper extends IMapper<Integer, User> {
	User findByLogin(Map<String,Object> map) throws Exception;
	
	/**通过邮箱进行查找*/
	User findByEmail(String email) throws Exception;
	
	/**更改用户状态*/
	boolean doUpdateRole(Integer id) throws Exception;
}
