package com.zhiyou100.crowdFunding.mapper;

import java.util.Map;

import com.zhiyou100.crowdFunding.vo.Comments;

public interface ICommentsMapper extends IMapper<Integer, Comments> {
	Comments findByPstidAndUsId(Map<String, Object> map) throws Exception;
}
