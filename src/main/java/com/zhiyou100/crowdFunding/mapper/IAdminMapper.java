package com.zhiyou100.crowdFunding.mapper;

import java.util.Map;

import com.zhiyou100.crowdFunding.vo.Admin;
/**
 * 管理员mapper接口（dao层），继承总接口
 * @author Administrator
 *
 */
public interface IAdminMapper extends IMapper<Integer, Admin> {
	Admin findByLogin(Map<String,Object> map) throws Exception;
}
