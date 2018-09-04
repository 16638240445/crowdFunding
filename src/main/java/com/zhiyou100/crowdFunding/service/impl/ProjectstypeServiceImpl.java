package com.zhiyou100.crowdFunding.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.crowdFunding.mapper.IProjectstypeMapper;
import com.zhiyou100.crowdFunding.service.IProjectstypeService;
import com.zhiyou100.crowdFunding.vo.Projectstype;

@Service
public class ProjectstypeServiceImpl implements IProjectstypeService {

	@Autowired
	private IProjectstypeMapper mapper;

	@Override
	public boolean add(Projectstype vo) throws Exception {
		return this.mapper.doCreate(vo);
	}

	@Override
	public boolean edit(Projectstype vo) throws Exception {
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
	public Projectstype findById(Integer id) throws Exception {
		return this.mapper.findById(id);
	}

	@Override
	public List<Projectstype> findAll(Map<String, Object> map) throws Exception {
		return this.mapper.findAll(map);
	}

	@Override
	public List<Projectstype> findAllSplit(Map<String, Object> map) throws Exception {
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

	@Override
	public List<Projectstype> findAllTypes() throws Exception {
		return this.mapper.findAllTypes();
	}

}
