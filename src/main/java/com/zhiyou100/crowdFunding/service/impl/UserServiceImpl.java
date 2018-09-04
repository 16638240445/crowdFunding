package com.zhiyou100.crowdFunding.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.crowdFunding.mapper.IUserMapper;
import com.zhiyou100.crowdFunding.service.IUserService;
import com.zhiyou100.crowdFunding.vo.User;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserMapper mapper;

	@Override
	public boolean add(User vo) throws Exception {
		return this.mapper.doCreate(vo);
	}

	@Override
	public boolean edit(User vo) throws Exception {
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
	public User findById(Integer id) throws Exception {
		return this.mapper.findById(id);
	}

	@Override
	public List<User> findAll(Map<String, Object> map) throws Exception {
		return this.mapper.findAll(map);
	}

	@Override
	public List<User> findAllSplit(Map<String, Object> map) throws Exception {
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
	public User findByLogin(Map<String, Object> map) throws Exception {
		return this.mapper.findByLogin(map);
	}

	@Override
	public User findByEmail(String email) throws Exception {
		return this.mapper.findByEmail(email);
	}

	@Override
	public boolean doUpdateRole(Integer id) throws Exception {
		return this.mapper.doUpdateRole(id);
	}

}
