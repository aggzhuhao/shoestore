package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.domain.Product;
import com.domain.ShoppingCart;
import com.domain.Tuser;
import com.service.*;
import com.service.intface.ShoeStoreServiceIntface;
import com.service.intface.ShopCarOrderServiceItface;

@WebServlet("/ShopCarOrderServlet")
public class ShopCarOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ShopCarOrderServiceItface ShopCarOrderService;
    private ShoeStoreServiceIntface ssService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopCarOrderServlet() {
    	ShopCarOrderService = new ShopCarOrderService();
    	ssService = new ShoeStoreService();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String flag = request.getParameter("flag") == null ? " " : request.getParameter("flag").trim(); 
		HttpSession session = request.getSession();
		List<ShoppingCart> shoppingCartList = new ArrayList<ShoppingCart>();
		Tuser tuser = new Tuser();
		int result = 4;
		if(flag.equals("selectShoppingCart")){
			tuser = (Tuser)session.getAttribute("tuser");
			if(tuser != null){
				String userId = tuser.getUserId();
				int count = ShopCarOrderService. selectSumCartPrice(userId);
				session.setAttribute("count", count);
				shoppingCartList = ShopCarOrderService.selecetShoppingCart(userId);
				session.setAttribute("shoppingCartList", shoppingCartList);
				request.getRequestDispatcher("/shoppingcart.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("/test.jsp").forward(request, response);
			}
		}else if(flag.equals("insertShoppingCart")){
			String productIdStr = request.getParameter("productId") == null ? "0" : request.getParameter("productId").trim();
			String quantityStr = request.getParameter("quantity");
			String userIdstr = request.getParameter("userId") == null ? "0" : request.getParameter("userId").trim();
			int productId = Integer.parseInt(productIdStr);
			int quantity = Integer.parseInt(quantityStr);
			result = ShopCarOrderService.insertShoppingCart(productId, quantity, userIdstr);
			System.out.println(result);
			request.getRequestDispatcher("/ShopCarOrderServlet?flag=selectShoppingCart").forward(request, response);
		}else if(flag.equals("deleteShoppingCart")){
			String shoppingCartIdstr = request.getParameter("shoppingCartId") == null ? " " :request.getParameter("shoppingCartId").trim();
			int shoppingCartId = Integer.parseInt(shoppingCartIdstr);
			result = ShopCarOrderService.deleteShoppingCart(shoppingCartId);
			if(result == 1){
				request.getRequestDispatcher("/ShopCarOrderServlet?flag=selectShoppingCart").forward(request, response);
			}else{
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
		}else if(flag.equals("updateSumShoppingCart")){
			String shoppingCarStr = request.getParameter("shoppingCarStr") == null ? "" :request.getParameter("shoppingCarStr").trim();
			String[] shoppingarr = shoppingCarStr.split(",");
			String userId = request.getParameter("userId") == null ? "" : request.getParameter("userId").trim();
			for(int i = 0; i< shoppingarr.length;i++){
				String[] shoppingShoparr = shoppingarr[i].split(":");
				/*System.out.println(shoppingShoparr[0] +"-------");
				System.out.println(shoppingShoparr[1] + "========");
				System.out.println(userId +".......................");*/
				result = ShopCarOrderService.updateShoppingCartByQuantity(Integer.parseInt(shoppingShoparr[1].trim()), Integer.parseInt(shoppingShoparr[0].trim()), userId);
			}
			if(result > 0){
				request.getRequestDispatcher("/ShopCarOrderServlet?flag=selectShoppingCart").forward(request, response);
			}else{
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
		}else if(flag.equals("checkShoppingCartQuantity")){
			response.setContentType("text/xml;charset=UTF-8");
			String productIdStr = request.getParameter("productId");
			String textQuantityStr = request.getParameter("textQuantity") == "" ? "0" :request.getParameter("textQuantity").trim();
			System.out.println(textQuantityStr);
			int productId = Integer.parseInt(productIdStr.trim());
			int textQuantity = Integer.parseInt(textQuantityStr);
			int quantity = 0;
			PrintWriter out = response.getWriter();
			quantity = ssService.selectshoeQuantity(productId);
			int check = 0;
			if(quantity >= textQuantity){
				check = 1;
			}
			System.out.println("check=" +check);
			out.write("<xml><productId>"+productId+"</productId><check>"+check+"</check></xml>");
			out.flush();
			out.close();
		}
		
	}

}
