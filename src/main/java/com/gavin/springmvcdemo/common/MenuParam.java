package com.gavin.springmvcdemo.common;

import com.gavin.springmvcdemo.model.Menus;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gavin
 * Mail: gavinchangcn@163.com
 * Date: 2015/8/28 0028
 * Time: 17:30
 */
public class MenuParam {

    private List<Menus> data;

    public List<Menus> getData() {
        return data;
    }

    public void setData(List<Menus> data) {
        this.data = data;
    }
}
