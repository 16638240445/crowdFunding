package com.zhiyou100.crowdFunding.mapper;

import java.util.Map;

import com.zhiyou100.crowdFunding.vo.Admin;
/**
 * ����Աmapper�ӿڣ�dao�㣩���̳��ܽӿ�
 * @author Administrator
 *
 */
public interface IAdminMapper extends IMapper<Integer, Admin> {
	Admin findByLogin(Map<String,Object> map) throws Exception;
}
