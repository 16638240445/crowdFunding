package com.zhiyou100.crowdFunding.mapper;


import java.util.List;
import java.util.Map;

import com.zhiyou100.crowdFunding.vo.Projects;

public interface IProjectsMapper extends IMapper<Integer, Projects> {
	/**审核项目*/
	boolean doUpdateByReview(Projects vo) throws Exception;
	/**通过邮箱手机号登录*/
	List<Projects> findByEmail(String email) throws Exception; 
	/**更改注册用户状态*/
	List<Projects> findByType(String email) throws Exception; 
	/**所有项目中的多条件查询*/
	List<Projects> findByTerm(Map<String,Object> map) throws Exception;
	/** 查询审核总数量 */
	Long getCountByReview() throws Exception;	
	/**发布项目时插入项目信息*/
	boolean doUpdateProjects(Projects vo) throws Exception;
	/** 发布项目时插入项目详情信息 */
	boolean doUpdateProjectsDetail(Projects vo) throws Exception;
	
}
