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
	public String queryGoodsByPaging(HttpServletRequest req,int page,int rows,String data){
		MyPage<Goods> allGoods = goodsService.queryGoodsByPaging(page,rows);
		for (Goods good : allGoods.getRows()) {
			System.out.println(good);
		}
		req.setAttribute("allGoods", allGoods);
//		异步的请求（会自动接收返回值的方法）才可以使用下面这个方法传值。 不然就放到req.setAttribute里
//		super.printJson(resp, allGoods);
		return "/proj-a-f/index";
	}
	@RequestMapping("/queryFontGoodsByPaging")
	public void queryFontGoodsByPaging(HttpServletResponse resp,int page,int rows,String data){
		MyPage<Goods> allGoods = goodsService.queryGoodsByPaging(page,rows);
		for (Goods good : allGoods.getRows()) {
			System.out.println(good);
		}
		super.printJson(resp, allGoods);
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
	 * 	state  用于区分前端、后端 的请求
	 */
	@RequestMapping("/queryGoodsById")
	public String queryGoodsById(HttpServletRequest req,String state,@RequestParam(value="rows")String ids){
		String[] split = ids.split(",");
		Goods queryGoodsById = goodsService.queryGoodsById(Long.parseLong(split[0]));
		req.setAttribute("queryGoodsById", queryGoodsById);
		if("b".equals(state)){
			//返回前端的商品详情页面
			return "/proj-a-b/goodsDetail";
		}else if("f".equals(state)){
			return "/proj-a-f/goodsDetail";
		}else {
			return "/proj-a-f/error";
		}
		
	}

	@RequestMapping("addProduct")
	public void addProduct(HttpServletResponse resp,Goods goods){
		boolean result = goodsService.insertGoods(goods);
		printJson(resp, result);
	}
	@RequestMapping("updateProduct")
	public void updateProduct(HttpServletResponse resp,Goods goods,long id){
		boolean result = goodsService.updateProduct(id,goods);
		printJson(resp, result);
	}
	@RequestMapping("deleteProduct")
	public void deleteProduct(HttpServletResponse resp,String id){
		boolean result = goodsService.deleteGoods(id);
		printJson(resp, result);
	}
}