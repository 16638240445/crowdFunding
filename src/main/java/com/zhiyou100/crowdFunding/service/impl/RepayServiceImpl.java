package com.zhiyou100.crowdFunding.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.crowdFunding.mapper.IRepayMapper;
import com.zhiyou100.crowdFunding.service.IRepayService;
import com.zhiyou100.crowdFunding.vo.Repay;

@Service
public class RepayServiceImpl implements IRepayService {

	@Autowired
	private IRepayMapper mapper;

	@Override
	public boolean add(Repay vo) throws Exception {
		return this.mapper.doCreate(vo);
	}

	@Override
	public boolean edit(Repay vo) throws Exception {
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
	public Repay findById(Integer id) throws Exception {
		return this.mapper.findById(id);
	}

	@Override
	public List<Repay> findAll(Map<String, Object> map) throws Exception {
		return this.mapper.findAll(map);
	}

	@Override
	public List<Repay> findAllSplit(Map<String, Object> map) throws Exception {
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
