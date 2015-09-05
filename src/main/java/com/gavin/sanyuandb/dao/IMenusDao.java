package com.gavin.sanyuandb.dao;

import com.gavin.sanyuandb.model.Menus;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gavin
 * Mail: gavinchangcn@163.com
 * Date: 2015/8/27 0027
 * Time: 18:07
 */

@Repository
public interface IMenusDao {

    /**
     * 得到分类名称
     * @param id
     * @return 分类名称
     */
    String getTitle(@Param("id")int id);

    /**
     * 得到全部分类
     * @return 分类
     */
    List<Menus> getList();

    /**
     * 查看是否已经存在该标题的数据
     * @param menus
     * @return
     */
    Menus getByTitle(@Param("menus")Menus menus);

    /**
     * 添加分类，返回分类ID
     * @param menus
     */
    void addMenu(@Param("menus")Menus menus);
}
