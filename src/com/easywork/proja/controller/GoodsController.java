package com.easywork.proja.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easycore.utils.BaseController;
import com.easywork.proja.model.MyPage;
import com.easywork.proja.persistence.Goods;
import com.easywork.proja.service.GoodsService;

@Controller
@RequestMapping("/proja/Goods")
public class GoodsController extends BaseController {
	@Autowired
	private GoodsService goodsService;
	
	/**分页 获取保险产品的内容
	 * @param page 起始页
	 * @param resp 用于把保存数据
	 * @param rows	每页显示数
	 */
	@RequestMapping("/queryGoodsByPaging")
	@ResponseBody
	public void queryGoodsByPaging(HttpServletResponse resp,int page,int rows){
		MyPage<Goods> queryGoodsByPaging = goodsService.queryGoodsByPaging(page,rows);
		super.printJson(resp, queryGoodsByPaging);
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
	
	/**按id号删除 对应的保险信息
	 * @param ids  以逗号隔开的多个id值
	 */
	@RequestMapping("/deleteGoods")
	@ResponseBody
	public void deleteGoods(@RequestParam(value="rows")String ids){
		goodsService.deleteGoods(ids);
	}
}