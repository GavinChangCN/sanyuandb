package com.gavin.springmvcdemo.controller;

import com.alibaba.fastjson.JSON;
import com.gavin.springmvcdemo.model.Menus;
import com.gavin.springmvcdemo.model.Products;
import com.gavin.springmvcdemo.service.MenusService;
import com.gavin.springmvcdemo.service.ProductsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gavin
 * Mail: gavinchangcn@163.com
 * Date: 2015/8/28 0028
 * Time: 18:52
 */
@Controller
public class addController {

    @Resource
    MenusService menusService;

    @Resource
    ProductsService productsService;

    @RequestMapping(value = "/add_product")
    public String addProduct(HttpServletRequest request) {
        List<Menus> menuList = menusService.getList();
        request.setAttribute("menuList", menuList) ;
        return "add_product" ;
    }

    @RequestMapping(value = "/addProductResult", method = RequestMethod.POST)
    public String getResult(@RequestParam("midselect") String midselect,
                            @RequestParam("pdesc") String pdesc,
                            @RequestParam("icon") CommonsMultipartFile icon,
                            @RequestParam("pic") CommonsMultipartFile pic,
                            @RequestParam("video") CommonsMultipartFile video,
                            HttpSession session){

        int mid = Integer.parseInt(midselect);
        String iconPath = "";
        String picPath = "";
        String videoPath = "";
        String url = session.getServletContext().getRealPath("/")+"images/";
        try{
            FileOutputStream os = null;
            InputStream in = null;
            // 保存小图
            if ( !icon.isEmpty() ) {
                iconPath = url + "icon/" + new Date().getTime() + icon.getOriginalFilename();
                os = new FileOutputStream(iconPath);
                in = icon.getInputStream();
                int b = 0;
                while ((b = in.read()) != -1) {
                    os.write(b);
                }
                os.flush();
            }
            if ( !pic.isEmpty() ) {
                picPath = url + "pic/" + new Date().getTime() + pic.getOriginalFilename();
                os = new FileOutputStream(picPath);
                in = pic.getInputStream();
                int b = 0;
                while ((b = in.read()) != -1) {
                    os.write(b);
                }
                os.flush();
            }
            if ( !video.isEmpty() ) {
                videoPath = url + "video/" + new Date().getTime() + video.getOriginalFilename();
                os = new FileOutputStream(videoPath);
                in = video.getInputStream();
                int b = 0;
                while ((b = in.read()) != -1) {
                    os.write(b);
                }
                os.flush();
            }
            os.close();
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Products products = new Products(1, "desc", "icon", "pic", "video", timestamp);
        System.out.println( JSON.toJSON(products));
        products = new Products(mid, pdesc, iconPath, picPath, videoPath, timestamp);
        System.out.println(JSON.toJSON(products));
        products = productsService.addProduct(products);
        System.out.println(JSON.toJSON(products));
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/addMenu", method = RequestMethod.POST)
    public String addMenu(@RequestParam("title") String title) {
        System.out.println(title);
        Menus menus = new Menus(title);
        menus = menusService.addMenu(menus);
        String menusjson = JSON.toJSONString(menus);
        return menusjson;
    }
}
