package com.zhiyou100.crowdFunding.mapper;

import java.util.List;

import com.zhiyou100.crowdFunding.vo.Projectstype;

public interface IProjectstypeMapper extends IMapper<Integer, Projectstype> {
	/** ����ȫ������ */
	List<Projectstype> findAllTypes() throws Exception;
}
