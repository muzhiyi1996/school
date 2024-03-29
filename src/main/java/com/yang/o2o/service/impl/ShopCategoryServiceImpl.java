package com.yang.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yang.o2o.dao.ShopCategoryDao;
import com.yang.o2o.entity.ShopCategory;
import com.yang.o2o.service.ShopCategoryService;

@Service
public class ShopCategoryServiceImpl implements ShopCategoryService{

	@Autowired
	private ShopCategoryDao ShopCategoryDao;
	@Override
	public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {
		// TODO Auto-generated method stub
		return ShopCategoryDao.queryShopCategory(shopCategoryCondition);
	}

}
