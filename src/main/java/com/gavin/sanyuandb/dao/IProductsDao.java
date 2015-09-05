package com.gavin.sanyuandb.dao;

import com.gavin.sanyuandb.model.Products;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Gavin
 * Mail: gavinchangcn@163.com
 * Date: 2015/8/27 0027
 * Time: 18:36
 */
@Repository
public interface IProductsDao {

    /**
     * 获得总产品数
     * @return 总产品数
     */
    int getRowCount(@Param("mid")int mid);

    /**
     * 搜索全部产品，按时间顺序排序
     * @param params 含两个属性，offset 从第几个元素开始， size 取多少个元素
     * @return 全部产品
     */
    List<Products> selectByParams(Map<String, Object> params);

    /**
     * 根据分类查找产品
     * @param params 分类以及页面页码信息 offset size
     * @return
     */
    List<Products> selectByMid(Map<String, Object> params);

    /**
     * 插入新产品
     * @param products
     * @return
     */
    void insertProduct(@Param("products")Products products);
}
