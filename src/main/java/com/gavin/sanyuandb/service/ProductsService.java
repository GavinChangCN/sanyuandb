package com.gavin.sanyuandb.service;

import com.gavin.sanyuandb.common.PageParam;
import com.gavin.sanyuandb.dao.IProductsDao;
import com.gavin.sanyuandb.model.Products;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Gavin
 * Mail: gavinchangcn@163.com
 * Date: 2015/8/27 0027
 * Time: 18:35
 */
@Service
public class ProductsService {

    @Resource
    IProductsDao ipdao ;


    public int getRowCount(int mid) {
        return ipdao.getRowCount(mid);
    }

    // 根据页数，查找全部产品
    public PageParam getListByPage(PageParam pageParam) {
        int currPage = pageParam.getCurrPage();
        // limit offset(从第几个开始）, size（取多少个对象）
        int offset = (currPage - 1) * PageParam.pageSize;
        int size = PageParam.pageSize;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("offset", offset);
        params.put("size", size);

        List<Products> productlist = ipdao.selectByParams(params);
        pageParam.setData(productlist);

        return pageParam;
    }

    // 根据选择类别
    public PageParam getListByMidAndPage(PageParam pageParam) {
        int currPage = pageParam.getCurrPage();
        int offset = (currPage - 1) * PageParam.pageSize;
        int size = PageParam.pageSize;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("mid", pageParam.getMid());
        params.put("offset", offset);
        params.put("size", size);
        List<Products> productsList = ipdao.selectByMid(params);
        pageParam.setData(productsList);

        return pageParam;

    }

    // 插入新产品
    public Products addProduct(Products products) {
        ipdao.insertProduct(products) ;
        return products;
    }
}
