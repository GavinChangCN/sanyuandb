package com.gavin.springmvcdemo.controller;

import com.gavin.springmvcdemo.common.MenuParam;
import com.gavin.springmvcdemo.common.PageParam;
import com.gavin.springmvcdemo.model.Menus;
import com.gavin.springmvcdemo.service.MenusService;
import com.gavin.springmvcdemo.service.ProductsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

	@Resource
	ProductsService productsService;

	@Resource
	MenusService menusService;

	@RequestMapping(value = "/index")
	public String indexC(HttpServletRequest request) {
		String currPageStr = request.getParameter("page");
		String midstr = request.getParameter("mid");
		int currPage = 1;
		try {
			currPage = Integer.parseInt(currPageStr);
		} catch (Exception e) {
		}
		int mid = 0;
		try {
			mid = Integer.parseInt(midstr);
		} catch (Exception e) {
		}

		// 获取总记录数
		int rowCount = productsService.getRowCount(mid);
		PageParam pageParam = new PageParam();
		pageParam.setRowCount(rowCount);
		if (pageParam.getTotalPage() < currPage ) {
			currPage = pageParam.getTotalPage();
		}
		pageParam.setCurrPage(currPage);
		pageParam.setMid(mid);
		pageParam.setMenus(menusService.getList());
		pageParam = productsService.getListByMidAndPage(pageParam);
		List<Menus> menuList = menusService.getList();
		MenuParam menuParam = new MenuParam();
		menuParam.setData(menuList);
		request.setAttribute("pageParam", pageParam);
		request.setAttribute("menuParam", menuParam);
		return "index";
	}

//	@RequestMapping(value = "getMenus", method = RequestMethod.POST )
//	public void getMenus(HttpServletResponse response) throws ServletException, IOException {
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		List<Menus> menuList = menusService.getList();
//		out.print( menuList );
//		out.flush();
//		out.close();
//	}

}
