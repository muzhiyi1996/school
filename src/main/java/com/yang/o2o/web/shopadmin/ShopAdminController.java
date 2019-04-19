package com.yang.o2o.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * 解析路由并转发到相应的html中
 * @author asus
 *
 */
@Controller
@RequestMapping(value="shopadmin",method= {RequestMethod.GET})
public class ShopAdminController {
	@RequestMapping(value = "/shopoperation")
	public String shopOperation() {
		//店铺注册/编辑
		return "shop/shopoperation";
	}
	@RequestMapping(value = "/shoplist")
	public String shoplist() {
		//店铺列表 
		return "shop/shoplist";
	}
	@RequestMapping(value = "/shopmanagement")
	public String shopmanagement() {
		//店铺管理
		return "shop/shopmanagement";
	}
	@RequestMapping(value="/productcategorymanagement",method=RequestMethod.GET)
	private String productCategoryManage() {
		//商品类别管理
		return "shop/productcategorymanagement";
	}
	@RequestMapping(value = "/productoperation")
	public String productOperation() {
		//商品添加/编辑
		return "shop/productoperation";
	}
	@RequestMapping(value = "/productmanagement")
	public String productManagement() {
		//商品管理
		return "shop/productmanagement";
	}
	
}
