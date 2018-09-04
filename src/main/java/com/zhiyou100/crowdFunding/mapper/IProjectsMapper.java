package com.zhiyou100.crowdFunding.mapper;


import java.util.List;
import java.util.Map;

import com.zhiyou100.crowdFunding.vo.Projects;

public interface IProjectsMapper extends IMapper<Integer, Projects> {
	/**�����Ŀ*/
	boolean doUpdateByReview(Projects vo) throws Exception;
	/**ͨ�������ֻ��ŵ�¼*/
	List<Projects> findByEmail(String email) throws Exception; 
	/**����ע���û�״̬*/
	List<Projects> findByType(String email) throws Exception; 
	/**������Ŀ�еĶ�������ѯ*/
	List<Projects> findByTerm(Map<String,Object> map) throws Exception;
	/** ��ѯ��������� */
	Long getCountByReview() throws Exception;	
	/**������Ŀʱ������Ŀ��Ϣ*/
	boolean doUpdateProjects(Projects vo) throws Exception;
	/** ������Ŀʱ������Ŀ������Ϣ */
	boolean doUpdateProjectsDetail(Projects vo) throws Exception;
	
}
