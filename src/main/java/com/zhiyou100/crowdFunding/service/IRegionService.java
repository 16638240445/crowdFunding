package com.zhiyou100.crowdFunding.service;

import java.util.List;

import com.zhiyou100.crowdFunding.vo.Region;

public interface IRegionService {

	/** 查询全部省份 */
	List<Region> findAllProvince() throws Exception;

	/** 查询所在省份所有市 */
	List<Region> findProvinceCity(Integer id) throws Exception;
}
