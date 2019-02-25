package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.domain.*;
import com.service.*;
import com.service.intface.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ShoeStoreServiceIntface ssService;
    public LoginServlet() {
        ssService = new ShoeStoreService();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String flag = request.getParameter("flag") == null ? " " : request.getParameter("flag").trim(); 
		String userId = request.getParameter("username");
		String password = request.getParameter("password");
		Tuser tuser = new Tuser();
		HttpSession session = request.getSession();
		tuser = ssService.selectTuserByIdPsw(userId, password);
		List<Category> categoryList = new ArrayList<Category>();
		categoryList = ssService.selectAllCategory();
		List<Product> newProductList = new ArrayList<Product>();
		newProductList = ssService.selectNewProduct();
		List<Product> popularProductList = new ArrayList<Product>();
		popularProductList = ssService.selectPopolarProduct();
		ShopCarOrderService scoService = new ShopCarOrderService();
		List<Product> adProductList = scoService.selectADProduct(4);
		
		if(flag.equals("zhuxiaoTuser")){
			session.removeAttribute("tuser");
			session.setAttribute("categoryList", categoryList);
			session.setAttribute("popularProductList", popularProductList);
			session.setAttribute("newProductList", newProductList);
			session.setAttribute("adProductList", adProductList);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else if(flag.equals("loginTuser")){
			if(tuser != null){
				session.setAttribute("tuser", tuser);
				session.setAttribute("categoryList", categoryList);
				session.setAttribute("popularProductList", popularProductList);
				session.setAttribute("newProductList", newProductList);
				session.setAttribute("adProductList", adProductList);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}else{
				session.setAttribute("categoryList", categoryList);
				session.setAttribute("popularProductList", popularProductList);
				session.setAttribute("newProductList", newProductList);
				session.setAttribute("adProductList", adProductList);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}else{
			session.setAttribute("categoryList", categoryList);
			session.setAttribute("popularProductList", popularProductList);
			session.setAttribute("newProductList", newProductList);
			session.setAttribute("adProductList", adProductList);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
