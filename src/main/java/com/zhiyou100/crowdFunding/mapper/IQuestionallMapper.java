package com.zhiyou100.crowdFunding.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou100.crowdFunding.vo.Questionall;

public interface IQuestionallMapper extends IMapper<Integer, Questionall> {
	/** ����ȫ���������*/
	List<Questionall> findAll() throws Exception;
}
