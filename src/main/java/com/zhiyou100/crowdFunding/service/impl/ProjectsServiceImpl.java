package com.zhiyou100.crowdFunding.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.crowdFunding.mapper.IProjectsMapper;
import com.zhiyou100.crowdFunding.service.IProjectsService;
import com.zhiyou100.crowdFunding.vo.Projects;

@Service
public class ProjectsServiceImpl implements IProjectsService {

	@Autowired
	private IProjectsMapper mapper;

	@Override
	public boolean add(Projects vo) throws Exception {
		return this.mapper.doCreate(vo);
	}

	@Override
	public boolean edit(Projects vo) throws Exception {
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
	public Projects findById(Integer id) throws Exception {
		return this.mapper.findById(id);
	}

	@Override
	public List<Projects> findAll(Map<String, Object> map) throws Exception {
		return this.mapper.findAll(map);
	}

	@Override
	public List<Projects> findAllSplit(Map<String, Object> map) throws Exception {
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
	public boolean doUpdateByReview(Projects vo) throws Exception {
		return this.mapper.doUpdateByReview(vo);
	}

	@Override
	public List<Projects> findByEmail(String email) throws Exception {
		return this.mapper.findByEmail(email);
	}

	@Override
	public List<Projects> findByType(String email) throws Exception {
		return this.mapper.findByType(email);
	}

	@Override
	public List<Projects> findByTerm(Map<String,Object> map) throws Exception {
		return this.mapper.findByTerm(map);
	}

	@Override
	public Long getCountByReview() throws Exception {
		return this.mapper.getCountByReview();
	}

	@Override
	public boolean doUpdateProjects(Projects vo) throws Exception {
		return this.mapper.doUpdateProjects(vo);
	}

	@Override
	public boolean doUpdateProjectsDetail(Projects vo) throws Exception {
		return this.mapper.doUpdateProjectsDetail(vo);
	}

	

}
