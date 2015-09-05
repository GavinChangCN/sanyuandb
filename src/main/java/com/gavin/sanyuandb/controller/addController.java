package com.gavin.sanyuandb.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gavin.sanyuandb.model.Menus;
import com.gavin.sanyuandb.model.Products;
import com.gavin.sanyuandb.service.MenusService;
import com.gavin.sanyuandb.service.ProductsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
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
    public String addProduct(ModelMap map) {
        List<Menus> menuList = menusService.getList();
        map.addAttribute("menuList", menuList) ;
        return "add_product" ;
    }

    @ResponseBody
    @RequestMapping(value = "/addProductResult")
    public String getResult(@RequestParam("midselect") String midselect,
                            @RequestParam("pdesc") String pdesc,
                            @RequestParam("icon") String icon,
                            @RequestParam("pic") String pic,
                            @RequestParam("video") String video){

        int mid = Integer.parseInt(midselect);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Products products = new Products(mid, pdesc, icon, pic, video, timestamp);
        productsService.addProduct(products);
        return JSON.toJSONString(products);
    }

    @ResponseBody
    @RequestMapping(value = "/addMenu", method = RequestMethod.POST)
    public String addMenu(@RequestParam("title") String title) {
        Menus menus = new Menus(title);
        menus = menusService.addMenu(menus);
        String menusjson = JSON.toJSONString(menus);
        return menusjson;
    }

    @ResponseBody
    @RequestMapping(value = "/uploadIcon")
    public String uploadIcon( @RequestParam("icon")CommonsMultipartFile icon,HttpServletRequest request ) {
        String url = request.getSession().getServletContext().getRealPath("/");
        String iconPath = "/images/icon/";
        File filedir = new File(url+iconPath);
        if ( !filedir.exists() ) {
            filedir.mkdirs();
        }
        String finalName = "" ;
//         DiskFileItemFactory fac = new DiskFileItemFactory();
//         ServletFileUpload upload = new ServletFileUpload(fac);
//         List fileList = null;
//         try {
//             fileList = upload.parseRequest(request);
//         } catch (FileUploadException ex) {
//             return "{msg:error}";
//         }
//
//         Iterator<FileItem> it = fileList.iterator();
//         String name = "";
//         while (it.hasNext()) {
//             FileItem item = it.next();
//             if (!item.isFormField()) {
//
//                 name = item.getName();
//                 long size = item.getSize();
//                 String type = item.getContentType();
//                 if (name == null || name.trim().equals("")) {
//                     continue;
//                 }
//                 File file = null;
//                 do {
//                     Date date = new Date();
//                     //生成文件名：
//                     iconPath = iconPath + SampleDateFormat.toFileDateString(date) + name;
//                     System.out.println("图片存储地址："+iconPath);
//                     file = new File(url + iconPath);
//                 } while (file.exists());
//                 File saveFile = new File(iconPath);
//                 try {
//                     item.write(saveFile);
//                 } catch (Exception e) {
//                     e.printStackTrace();
//                 }
//             }
//         }
        if (!icon.isEmpty()) {
            int pre = (int) System.currentTimeMillis();
            try {
                finalName = iconPath
                        + new Date().getTime() + icon.getOriginalFilename();
                FileOutputStream os = new FileOutputStream( url + finalName ) ;
                FileInputStream in = (FileInputStream) icon.getInputStream() ;

                int b = 0;
                while ((b = in.read()) != -1) {
                    os.write(b);
                }
                os.flush();
                os.close();
                in.close();
                int finaltime = (int) System.currentTimeMillis();
                System.out.println(finaltime - pre);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        JSONObject json = new JSONObject() ;
        json.put("msg", "success");
        json.put("path", finalName) ;
        return json.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/uploadPic")
    public String uploadPic(@RequestParam("pic") CommonsMultipartFile pic, HttpServletRequest request ) {
        String url = request.getSession().getServletContext().getRealPath("/");
        String picPath = "/images/pic/";
        File filedir = new File(url+picPath);
        if ( !filedir.exists() ) {
            filedir.mkdirs();
        }
        String finalName = "" ;
//        DiskFileItemFactory fac = new DiskFileItemFactory();
//        ServletFileUpload upload = new ServletFileUpload(fac);
//        List fileList = null;
//        try {
//            fileList = upload.parseRequest(request);
//        } catch (FileUploadException ex) {
//            return "{msg:error}";
//        }
//
//        Iterator<FileItem> it = fileList.iterator();
//        String name = "";
//        while (it.hasNext()) {
//            FileItem item = it.next();
//            if (!item.isFormField()) {
//                name = item.getName();
//                long size = item.getSize();
//                String type = item.getContentType();
//                if (name == null || name.trim().equals("")) {
//                    continue;
//                }
//                File file = null;
//                do {
//                    Date date = new Date();
//                    //生成文件名：
//                    picPath = picPath + SampleDateFormat.toFileDateString(date) + name;
//                    file = new File(url + picPath);
//                } while (file.exists());
//                File saveFile = new File(picPath);
//                try {
//                    item.write(saveFile);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        if (!pic.isEmpty()) {
            int pre = (int) System.currentTimeMillis();
            try {
                finalName = picPath
                        + new Date().getTime() + pic.getOriginalFilename();
                FileOutputStream os = new FileOutputStream( url + finalName ) ;
                FileInputStream in = (FileInputStream) pic.getInputStream() ;

                int b = 0;
                while ((b = in.read()) != -1) {
                    os.write(b);
                }
                os.flush();
                os.close();
                in.close();
                int finaltime = (int) System.currentTimeMillis();
                System.out.println(finaltime - pre);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        JSONObject json = new JSONObject() ;
        json.put("msg", "success");
        json.put("path", finalName) ;
        return json.toString();
    }
}
