package com.zhiyou100.crowdFunding.mapper;

import java.util.List;

import com.zhiyou100.crowdFunding.vo.Region;

public interface IRegionMapper {
	
	/**��ѯȫ��ʡ��*/ 
	List<Region> findAllProvince() throws Exception;
	
	/**��ѯ����ʡ��������*/ 
	List<Region> findProvinceCity(Integer id) throws Exception;
}
