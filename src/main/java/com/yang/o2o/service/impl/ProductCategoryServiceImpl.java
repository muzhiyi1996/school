package com.yang.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yang.o2o.dao.ProductCategoryDao;
import com.yang.o2o.dao.ProductDao;
import com.yang.o2o.dto.ProductCategoryExecution;
import com.yang.o2o.entity.ProductCategory;
import com.yang.o2o.enums.ProductCategoryStateEnum;
import com.yang.o2o.exceptions.productCategoryOperationException;
import com.yang.o2o.service.ProductCategoryService;
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	private ProductCategoryDao productCategoryDao;
	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<ProductCategory> getProductCategoryList(long shopId) {
		return productCategoryDao.queryProductCategoryList(shopId);
	}

	@Override
	@Transactional
	public ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
			throws productCategoryOperationException {
		if (productCategoryList != null && productCategoryList.size() > 0) {
			try {
				int effectedNum = productCategoryDao
						.batchInsertProductCategory(productCategoryList);
				if (effectedNum <= 0) {
					throw new RuntimeException("店铺类别创建失败");
				} else {

					return new ProductCategoryExecution(
							ProductCategoryStateEnum.SUCCESS);
				}

			} catch (Exception e) {
				throw new productCategoryOperationException("batchAddProductCategory error: "
						+ e.getMessage());
			}
		} else {
			return new ProductCategoryExecution(
					ProductCategoryStateEnum.EMPTY_LIST);
		}
	}

	@Override
	@Transactional
	public ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId)
			throws productCategoryOperationException {
		// 解除tb_product里的商品与该productcategoryId的关联
		try {
			int effectedNum = productDao.updateProductCategoryToNull(productCategoryId);
			if(effectedNum < 0) {
				throw new productCategoryOperationException("商品類別更新失败");
			}
		}catch(Exception e) {
			throw new productCategoryOperationException("deleteProductCategory error:" + e.getMessage());
		}
		//删除该productCategory
		try {
			int effectedNum = productCategoryDao.deleteProductCategory(
					productCategoryId, shopId);
			if (effectedNum <= 0) {
				throw new productCategoryOperationException("商品类别删除失败");
			} else {
				return new ProductCategoryExecution(
						ProductCategoryStateEnum.SUCCESS);
			}

		} catch (Exception e) {
			throw new productCategoryOperationException("deleteProductCategory error: "
					+ e.getMessage());
		}
	}

}
