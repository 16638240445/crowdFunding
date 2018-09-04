package com.zhiyou100.crowdFunding.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou100.crowdFunding.vo.Questionall;

public interface IQuestionallMapper extends IMapper<Integer, Questionall> {
	/** 查找全部多表连查*/
	List<Questionall> findAll() throws Exception;
}
