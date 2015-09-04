package com.gavin.sanyuandb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Gavin
 * Mail: gavinchangcn@163.com
 * Date: 2015/9/4 0004
 * Time: 23:02
 */
@Controller
public class uploadController {

    @RequestMapping(value = "/testupload")
    public String uploadTest() {

        return "testuoload";
    }


    @ResponseBody
    @RequestMapping(value = "/saveupload")
    public String saveupload(@RequestParam("file")CommonsMultipartFile[] files, HttpServletRequest request) {
        String finalName = "";
        for (int i = 0; i < files.length; i ++) {
            System.out.println("fileName---------->" + files[i].getOriginalFilename());

            String url = request.getSession().getServletContext().getRealPath("/");
            String iconPath = "/images/icon/";

            File filedir = new File(url+iconPath);
            if ( !filedir.exists() ) {
                filedir.mkdirs();
            }
            if (!files[i].isEmpty()) {
                int pre = (int) System.currentTimeMillis();
                try {
                    finalName = iconPath
                            + new Date().getTime() + files[i].getOriginalFilename();
                    FileOutputStream os = new FileOutputStream( url + finalName ) ;
                    FileInputStream in = (FileInputStream) files[i].getInputStream() ;

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
        }
        System.out.println(finalName);
        return finalName;
    }
}
