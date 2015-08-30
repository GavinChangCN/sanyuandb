package com.gavin.springmvcdemo.common;

import com.gavin.springmvcdemo.model.Menus;
import com.gavin.springmvcdemo.model.Products;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gavin
 * Mail: gavinchangcn@163.com
 * Date: 2015/8/27 0027
 * Time: 18:11
 */
public class PageParam {

    private int currPage ; // 当前页

    private int totalPage ; // 总页数

    private int rowCount ; // 总记录数

    public static int pageSize = 10 ; // 页大小

    private Integer mid = 0 ; // 分类Id

    private List<Products> data ; // 数据

    private List<Menus> menus ; // 分类

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        int totalp = rowCount / pageSize ;
        if (rowCount % pageSize > 0) {
            ++totalp;
        }
        setTotalPage(totalp);
        this.rowCount = rowCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public List<Products> getData() {
        return data;
    }

    public void setData(List<Products> data) {
        this.data = data;
    }

    public List<Menus> getMenus() {
        return menus;
    }

    public void setMenus(List<Menus> menus) {
        this.menus = menus;
    }
}
