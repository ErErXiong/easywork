package com.easywork.proja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easywork.proja.model.MyPage;
import com.easywork.proja.persistence.Goods;
import com.easywork.proja.persistence.GoodsMapper;
import com.github.pagehelper.PageHelper;

@Transactional
@Service
public class GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;

	public GoodsMapper getGoodsMapper() {
		return goodsMapper;
	}

	public List<Goods> queryAll(){
		
		List<Goods> selectAll = goodsMapper.selectAll();
		return selectAll;
	}
	
	// 按分页从数据库获取所有产品的内容
	public MyPage<Goods> queryGoodsByPaging(int page, int rows) {
		// 获取总页数
		int total = goodsMapper.selectCountByExample(null);
		// 设置分页查询的起始页和查询数量（每页数）
		PageHelper.startPage(page, rows);
		List<Goods> goodsList = goodsMapper.selectAll();
		// 把 页面总数total和goodslist 放入MyPage对象中， 打包传递
		MyPage<Goods> myPage = new MyPage<Goods>(total, goodsList,page,rows);
		return myPage;
	}
	
	/**按id查询对应的Goods详情
	 * @param parseLong
	 */
	public Goods queryGoodsById(long parseLong) {
		Goods good = goodsMapper.selectByPrimaryKey(parseLong);
		return good;
	}
	
	/** 按name 模糊查询
	 * @param name
	 */
	public List<String> queryByName(String name) {
		List<String> queryByName = goodsMapper.queryByName(name);
		return queryByName;
		// TODO Auto-generated method stub
		
	}
	
	public void insertGoods(Goods goods){
	
			{
//				通过创建人姓名查找创建人id，然后set进去
				goods.setCreateid(10L);
			}
			goodsMapper.insertGoods();
			{
//				创建user-goods 关联表
			}
		
	}

	/**
	 * 按id删除保险产品（Goods）
	 * 
	 * @param ids 以逗号隔开的多个id值
	 *            
	 */
	public void deleteGoods(String ids) {
		String[] idList = ids.split(",");
		for (int i = 0; i < idList.length; i++) {
			goodsMapper.deleteByPrimaryKey(Long.parseLong(idList[i]));
		}
	}





}