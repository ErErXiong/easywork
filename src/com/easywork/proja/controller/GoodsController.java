package com.easywork.proja.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.easycore.utils.BaseController;
import com.easywork.proja.model.MyPage;
import com.easywork.proja.persistence.Goods;
import com.easywork.proja.service.GoodsService;

@Controller
@RequestMapping("/proja/Goods")
public class GoodsController extends BaseController {
	@Autowired
	private GoodsService goodsService;
	
	/**分页 后台获取保险产品的内容
	 * @param page 起始页
	 * @param resp 用于把保存数据
	 * @param rows	每页显示数
	 */
	@RequestMapping("/queryGoodsByPaging")
	public String queryGoodsByPaging(HttpServletRequest resp,int page,int rows,String data){
		MyPage<Goods> allGoods = goodsService.queryGoodsByPaging(page,rows);
		for (Goods good : allGoods.getRows()) {
			System.out.println(good);
		}
		resp.setAttribute("allGoods", allGoods);
//		super.printJson(resp, allGoods);
		return "/proj-a-f/index";
	}
	
	/** 异步 模糊查询的保险名称
	 * @param 
	 * @param 
	 * @return
	 */
	@RequestMapping("/indexQuery")
	public void indexQuery(HttpServletResponse resp,@RequestParam(value="data")String name){
		List<String> queryByName = goodsService.queryByName(name);
		System.out.println("data:"+name);
		for (String strings : queryByName) {
			System.out.println(strings);
		}
		super.printJson(resp, queryByName);
	}

	
	
	
	/**按id查询对应的Goods详情
	 * @param ids 以逗号隔开的多个id值
	 */
	@RequestMapping("/queryGoodsById")
	@ResponseBody
	public void queryGoodsById(HttpServletResponse resp,@RequestParam(value="rows")String ids){
		String[] split = ids.split(",");
		Goods queryGoodsById = goodsService.queryGoodsById(Long.parseLong(split[0]));
		super.printJson(resp, queryGoodsById);
	}

	
	/**
	 * @return 转跳到 增添 保险项目 页面
	 */
	@RequestMapping("/addGoodsView")
	public String getNewView(){
		System.out.println("addGoodsView");
		return "/proj-a-b/addIns";
	}
	
	/**
	 * @return 转跳到 保险的详单页面
	 */
	@RequestMapping("/lookGoodsView")
	public String lookGoodsView(){
		System.out.println("getNewView");
		return "/proj-a-b/goodsDetail";
	}
	
	/**
	 * @return 转跳到 保险的详单页面
	 */
	@RequestMapping("/editGoodsView")
	public String editGoodsView(){
		System.out.println("editGoodsView");
		return "/proj-a-b/editGoods";
	}
	
	/** 新增Goods 
	 * @param goods 接收addIns页面表单 传来的goods
	 */
	@RequestMapping("/addInsForm")
	@ResponseBody
	public void addGoods(Goods goods){
		goodsService.insertGoods(goods);
	}
	
	/**按id号删除 对应的保险信息
	 * @param ids  以逗号隔开的多个id值
	 */
	@RequestMapping("/deleteGoods")
	@ResponseBody
	public void deleteGoods(@RequestParam(value="rows")String ids){
		goodsService.deleteGoods(ids);
	}
}