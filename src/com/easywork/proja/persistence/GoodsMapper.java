package com.easywork.proja.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import tk.mybatis.mapper.common.Mapper;

public interface GoodsMapper extends Mapper<Goods> {

	void insertGoods();
	
	List<String> queryByName(@Param("name")String name);
}