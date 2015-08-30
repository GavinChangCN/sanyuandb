package com.gavin.springmvcdemo.service;

import com.gavin.springmvcdemo.dao.IMenusDao;
import com.gavin.springmvcdemo.model.Menus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gavin
 * Mail: gavinchangcn@163.com
 * Date: 2015/8/27 0027
 * Time: 18:09
 */
@Service
public class MenusService {

    @Resource
    IMenusDao imdao;

    public List<Menus> getList() {
        return imdao.getList();
    }

    /**
     * 增加新分类，返回结果为-1表示已经存在该分类，后者返回该新增分类的ID
     * @param menus
     * @return
     */
    public Menus addMenu (Menus menus) {
        Menus newmenu = imdao.getByTitle(menus);
        if (newmenu != null) {
            menus.setId(-1);
            return menus;
        } else {
            imdao.addMenu(menus);
            return menus;
        }
    }
}
