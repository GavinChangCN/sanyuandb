package com.gavin.sanyuandb.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gavin.sanyuandb.model.Menus;
import com.gavin.sanyuandb.model.Products;
import com.gavin.sanyuandb.service.MenusService;
import com.gavin.sanyuandb.service.ProductsService;
import com.gavin.sanyuandb.utils.SampleDateFormat;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
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
                            @RequestParam("icon") String icon,
                            @RequestParam("pic") String pic,
                            @RequestParam("video") String video){

        int mid = Integer.parseInt(midselect);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Products products = new Products(1, "desc", "icon", "pic", "video", timestamp);
        System.out.println( JSON.toJSON(products));
        products = new Products(mid, pdesc, icon, pic, video, timestamp);
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

     @ResponseBody
     @RequestMapping(value = "/uploadIcon", method = RequestMethod.POST)
     public String uploadIcon( HttpServletRequest request ) {
        String url = request.getSession().getServletContext().getRealPath("/");
        String iconPath = "/images/icon/";

        File filedir = new File(url+iconPath);
        if ( !filedir.exists() ) {
            filedir.mkdirs();
        }
         DiskFileItemFactory fac = new DiskFileItemFactory();
         ServletFileUpload upload = new ServletFileUpload(fac);
         List fileList = null;
         try {
             fileList = upload.parseRequest(request);
         } catch (FileUploadException ex) {
             return "{msg:error}";
         }

         Iterator<FileItem> it = fileList.iterator();
         String name = "";
         while (it.hasNext()) {
             FileItem item = it.next();
             if (!item.isFormField()) {

                 name = item.getName();
                 long size = item.getSize();
                 String type = item.getContentType();
                 if (name == null || name.trim().equals("")) {
                     continue;
                 }
                 File file = null;
                 do {
                     Date date = new Date();
                     //生成文件名：
                     iconPath = iconPath + SampleDateFormat.toFileDateString(date) + name;
                     System.out.println("图片存储地址："+iconPath);
                     file = new File(url + iconPath);
                 } while (file.exists());
                 File saveFile = new File(iconPath);
                 try {
                     item.write(saveFile);
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
             }
         }
        JSONObject json = new JSONObject() ;
         json.put("msg", "success");
        json.put("path", iconPath) ;
        return json.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/uploadPic", method = RequestMethod.POST)
    public String uploadPic(HttpServletRequest request ) {
        String url = request.getSession().getServletContext().getRealPath("/");
        String picPath = "/images/pic/";
        File filedir = new File(url+picPath);
        if ( !filedir.exists() ) {
            filedir.mkdirs();
        }
        DiskFileItemFactory fac = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(fac);
        List fileList = null;
        try {
            fileList = upload.parseRequest(request);
        } catch (FileUploadException ex) {
            return "{msg:error}";
        }

        Iterator<FileItem> it = fileList.iterator();
        String name = "";
        while (it.hasNext()) {
            FileItem item = it.next();
            if (!item.isFormField()) {
                name = item.getName();
                long size = item.getSize();
                String type = item.getContentType();
                if (name == null || name.trim().equals("")) {
                    continue;
                }
                File file = null;
                do {
                    Date date = new Date();
                    //生成文件名：
                    picPath = picPath + SampleDateFormat.toFileDateString(date) + name;
                    file = new File(url + picPath);
                } while (file.exists());
                File saveFile = new File(picPath);
                try {
                    item.write(saveFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        JSONObject json = new JSONObject() ;
        json.put("msg", "success");
        json.put("path", picPath) ;
        return json.toString();
    }
}
