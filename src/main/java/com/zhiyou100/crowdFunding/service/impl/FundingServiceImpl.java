package com.zhiyou100.crowdFunding.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.crowdFunding.mapper.IFundingMapper;
import com.zhiyou100.crowdFunding.service.IFundingService;
import com.zhiyou100.crowdFunding.vo.Funding;

@Service
public class FundingServiceImpl implements IFundingService {

	@Autowired
	private IFundingMapper mapper;

	@Override
	public boolean add(Funding vo) throws Exception {
		return this.mapper.doCreate(vo);
	}

	@Override
	public boolean edit(Funding vo) throws Exception {
		return this.mapper.doUpdate(vo);
	}

	@Override
	public boolean remove(Integer id) throws Exception {
		return this.mapper.doRemove(id);
	}

	@Override
	public boolean removeBatch(Set<Integer> ids) throws Exception {
		return this.mapper.doRemoveBatch(ids);
	}

	@Override
	public Funding findById(Integer id) throws Exception {
		return this.mapper.findById(id);
	}

	@Override
	public List<Funding> findAll(Map<String, Object> map) throws Exception {
		return this.mapper.findAll(map);
	}

	@Override
	public List<Funding> findAllSplit(Map<String, Object> map) throws Exception {
		return this.mapper.findAllSplit(map);
	}

	@Override
	public Long getAllCount() throws Exception {
		return this.mapper.getAllCount();
	}

	@Override
	public Long getAllCountSplit(Map<String, Object> map) throws Exception {
		return this.mapper.getAllCountSplit(map);
	}

}
