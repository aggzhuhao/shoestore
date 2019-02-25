package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.domain.Product;
import com.service.ShoeStoreService;
import com.service.intface.ShoeStoreServiceIntface;

/**
 * Servlet implementation class ShoeStoreServlet
 */
@WebServlet("/ShoeStoreServlet")
public class ShoeStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ShoeStoreServiceIntface ssService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoeStoreServlet() {
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
		HttpSession session = request.getSession();
			List<Product> productList = new ArrayList<Product>();
			String categoryIdStr = request.getParameter("categoryId") == null ? "0" : request.getParameter("categoryId").trim();
			String currentPageStr = request.getParameter("currentPage") == null ? "1" : request.getParameter("currentPage").trim();
			String categoryName = request.getParameter("categoryName") == null ? " " : request.getParameter("categoryName").trim();	
			categoryName = new String(categoryName.getBytes("ISO8859-1"),"utf-8");
			PrintWriter out = response.getWriter();
			int categoryId = Integer.parseInt(categoryIdStr);
			int currentPage = Integer.parseInt(currentPageStr);
			int pageSize = 9;
			int pages = 0;//总页数 
			int count = 0;//总记录数
			count = ssService.selectCountProductById(categoryId);
			
			
			if(flag.equals("aboutShoes")){
				String model = request.getParameter("model") == null ? "" :request.getParameter("model");
				Product product = ssService.selectthisProduct(model);
				
				int quantity = ssService.selectQuantityById(product.getProductId());
				
				session.setAttribute("quantity", quantity);
				request.setAttribute("product", product);
				session.setAttribute("categoryName", categoryName);
				request.getRequestDispatcher("/productdetail.jsp").forward(request, response);
			}else if(flag.equals("checkQuantity")){
				
				String textQuantitystr = request.getParameter("textQuantity") == "" ? "0" :request.getParameter("textQuantity").trim();
				String quantityStr = request.getParameter("quantity") == "" ? "0" : request.getParameter("quantity").trim();
				int textQuantity = Integer.parseInt(textQuantitystr);
				int quantity = Integer.parseInt(quantityStr);
				//Map<String, String> resultMap = new HashMap<String, String>();
				boolean result = true;;
				if(textQuantity > quantity){
					result = true;
				}else{
					result = false;
				}
				
				out.println(result);
				out.flush();
				out.close();
				session.setAttribute("textQuantity", textQuantity);
				
			}else{
				if(count % pageSize == 0){
					pages = count / pageSize;
				}else{
					pages = count / pageSize + 1;
				}
				if(currentPage > pages){
					currentPage = pages;
				}else if(currentPage < 1){
					currentPage = 1;
				}
				productList = ssService.selectProductById(categoryId, currentPage, pageSize);
				session.setAttribute("productList", productList);
				request.setAttribute("pages", pages);
				request.setAttribute("count", count);
				request.setAttribute("currentPage", currentPage);
				session.setAttribute("categoryName", categoryName);
				request.getRequestDispatcher("/products.jsp").forward(request, response);
				
			}
		
			
			
		
	}

}
