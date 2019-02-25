package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.domain.Order;
import com.domain.OrderDetail;
import com.service.ShoeOrderService;
import com.service.intface.ShoeOrderServiceIntface;

/**
 * Servlet implementation class ShoeOrderServlet
 */
@WebServlet("/ShoeOrderServlet")
public class ShoeOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ShoeOrderServiceIntface soService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoeOrderServlet() {
        soService = new ShoeOrderService();
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
		String flag = request.getParameter("flag") == null ? "" :request.getParameter("flag").trim();
		//System.out.println("--------");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		if(flag.equals("checkOrder")){
			String receiveId = request.getParameter("receiveId") == null ? "" :request.getParameter("receiveId").trim();
			String province = request.getParameter("province") == null ? "" :request.getParameter("province").trim();
			String city = request.getParameter("city") == null ? "" :request.getParameter("city").trim();
			String country = request.getParameter("country") == null ? "" :request.getParameter("country").trim();
			String home = request.getParameter("home") == null ? "" :request.getParameter("home").trim(); 
			String postal = request.getParameter("postal") == null ? "" :request.getParameter("postal").trim(); 
			String phone = request.getParameter("phone") == null ? "" :request.getParameter("phone").trim(); 
			
			String userId = request.getParameter("userId") == null ? "" :request.getParameter("userId").trim(); 
			String agreement = request.getParameter("agreement") == null ? "" :request.getParameter("agreement").trim();
			String count = request.getParameter("count") == null ? "" :request.getParameter("count").trim(); 
			String payWay = request.getParameter("payWay") == null ? "" :request.getParameter("payWay").trim(); 
			payWay = new String(payWay.getBytes("ISO8859-1"),"UTF-8");
			//System.out.println(receiveId+province+city+country+home+postal+phone+":"+userId+"--"+count+"=="+payWay+"**"+agreement);
			int result = 3;
			if(receiveId.equals("")||province.equals("")||city.equals("")||country.equals("")||home.equals("")||postal.equals("")||userId.equals("")){
				result = 0;//有空值
			}else{
				if(agreement.equals("false")){
					result = -1;//为勾选条约
				}else{
					result = 1;
				}
			}
			out.println(result);
			out.flush();
			out.close();
		}else if(flag.equals("successBuy")){
			String receiveId = request.getParameter("receiveId") == null ? "" :request.getParameter("receiveId").trim();
			String province = request.getParameter("province") == null ? "" :request.getParameter("province").trim();
			String city = request.getParameter("city") == null ? "" :request.getParameter("city").trim();
			String country = request.getParameter("country") == null ? "" :request.getParameter("country").trim();
			String home = request.getParameter("home") == null ? "" :request.getParameter("home").trim(); 
			String postal = request.getParameter("postal") == null ? "" :request.getParameter("postal").trim(); 
			String phone = request.getParameter("phone") == null ? "" :request.getParameter("phone").trim(); 
			String userId = request.getParameter("userId") == null ? "" :request.getParameter("userId").trim(); 
			String agreement = request.getParameter("agreement") == null ? "" :request.getParameter("agreement").trim();
			String countStr = request.getParameter("count") == null ? "" :request.getParameter("count").trim(); 
			String payWay = request.getParameter("payWay") == null ? "" :request.getParameter("payWay").trim();
					
			receiveId = new String(receiveId.getBytes("ISO8859-1"),"UTF-8");
			province = new String(province.getBytes("ISO8859-1"),"UTF-8");
			city = new String(city.getBytes("ISO8859-1"),"UTF-8");
			country = new String(country.getBytes("ISO8859-1"),"UTF-8");
			home = new String(home.getBytes("ISO8859-1"),"UTF-8");
			postal = new String(postal.getBytes("ISO8859-1"),"UTF-8");
			phone = new String(phone.getBytes("ISO8859-1"),"UTF-8");
			userId = new String(userId.getBytes("ISO8859-1"),"UTF-8");
			agreement = new String(agreement.getBytes("ISO8859-1"),"UTF-8");
			countStr = new String(countStr.getBytes("ISO8859-1"),"UTF-8");
			double count = Double.parseDouble(countStr);
			payWay = new String(payWay.getBytes("ISO8859-1"),"UTF-8");
			//System.out.println(receiveId+province+city+country+home+postal+phone+":"+userId+"--"+count+"=="+payWay+"**"+agreement);
			int result = 3;
			result = soService.balanceOrder(count, payWay, receiveId, province, city, country, home, postal, phone, userId);
			if(result == 1){
				request.getRequestDispatcher("/ShoeOrderServlet?flag=selectAllOrder").forward(request, response);
			}else{
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
		}else if(flag.equals("selectAllOrder")){
			String userId = request.getParameter("userId") == "" ? "1" : request.getParameter("userId").trim();
			String currentPageStr = request.getParameter("currentPage") == "" ? "1" : request.getParameter("currentPage").trim();
			System.out.println(currentPageStr);
			int currentPage = Integer.parseInt(currentPageStr);
			int count = soService.selectAllOrderById(userId);
			int pageSize = 10;
			int pages = 0;
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
			if(userId.equals("1")){
				request.getRequestDispatcher("/test.jsp").forward(request, response);
			}else{
				List<Order> orderList = new ArrayList<Order>();	
				orderList = soService.selectOrderById(userId, currentPage,pageSize);
				session.setAttribute("pages", pages);
				session.setAttribute("orderList", orderList);
				session.setAttribute("currentPage", currentPage);
				request.getRequestDispatcher("/orderlist.jsp").forward(request, response);
			}
		}else if(flag.equals("seecareful")){
			String orderIdStr = request.getParameter("orderId") == null ? "" : request.getParameter("orderId").trim();
			int orderId = Integer.parseInt(orderIdStr);
			List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
			orderDetailList = soService.quenryOrderById(orderId);
			double countTail = 0.0;
			for(OrderDetail o : orderDetailList){
				countTail += (o.getQuantity() * o.getPrice());
				
			}
			
			String payment = "";
			int paymentint = Integer.parseInt(orderDetailList.get(0).getPayment().trim());
			
			if(paymentint == 1){
				payment = "支付宝";
			}else{
				payment = "微信";
			}
			session.setAttribute("payment", payment);
			session.setAttribute("countTail", countTail);
			session.setAttribute("orderDetailList", orderDetailList);
			request.getRequestDispatcher("/orderdetail.jsp").forward(request, response);
			
			
		}
	}

}
