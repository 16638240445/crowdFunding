package com.zhiyou100.crowdFunding.mapper;

import java.util.Map;

import com.zhiyou100.crowdFunding.vo.User;

public interface IUserMapper extends IMapper<Integer, User> {
	User findByLogin(Map<String,Object> map) throws Exception;
	
	/**ͨ��������в���*/
	User findByEmail(String email) throws Exception;
	
	/**�����û�״̬*/
	boolean doUpdateRole(Integer id) throws Exception;
}
