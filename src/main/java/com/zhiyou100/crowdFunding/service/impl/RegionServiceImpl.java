package com.zhiyou100.crowdFunding.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.crowdFunding.mapper.IRegionMapper;
import com.zhiyou100.crowdFunding.service.IRegionService;
import com.zhiyou100.crowdFunding.vo.Region;
@Service
public class RegionServiceImpl implements IRegionService {
	
	@Autowired
	private IRegionMapper mapper;
	
	@Override
	public List<Region> findAllProvince() throws Exception {
		return this.mapper.findAllProvince();
	}

	@Override
	public List<Region> findProvinceCity(Integer id) throws Exception {
		return this.mapper.findProvinceCity(id);
	}

	

	

}
