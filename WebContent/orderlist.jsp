<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page import="com.domain.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Shoes Store - Check Out</title>
<meta name="keywords" content="shoes store, check out, free template, ecommerce, online shop, website templates, CSS, HTML" />
<meta name="description" content="Shoes Store, Check Out, free ecommerce template provided " />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/ddsmoothmenu.js">



</script>

<script type="text/javascript">

ddsmoothmenu.init({
	mainmenuid: "top_nav", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})

</script>

</head>

<script type="text/javascript">
function getTuserMsg(){
	var vq = document.getElementById("tuserMsg").innerHTML;
		if(vq == ""){
			console.log("1");
			document.getElementById("Tusername").style.display = "inline";
			document.getElementById("tMsg").style.display = "none";
		
		}else{
			console.log("2");
			document.getElementById("Tusername").style.display = "none";
			document.getElementById("tMsg").style.display = "inline";
		}
}
</script>
<body onload="getTuserMsg()">

<div id="templatemo_body_wrapper">
<div id="templatemo_wrapper">
<span id="tuserMsg" style="display: none;">${tuser.username }</span>
	<span id="tuserId" style="display: none;">${tuser.userId }</span>
    <div id="templatemo_header">
        <div id="site_title"><h1><a href="#">穿美在线鞋城</a></h1></div>
        <div id="header_right">
            <p id="Tusername" style="display: inline"><a href="login.jsp" target="_blank">登陆</a></p><span id="tMsg" style="display: none">亲爱的:${tuser.username }<a href="LoginServlet?flag=zhuxiaoTuser">注销</a></span>
        </div>
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_header -->

    <div id="templatemo_menubar">
        <div id="top_nav" class="ddsmoothmenu">
            <ul>
                <li><a href="LoginServlet" class="selected">首页</a></li>
                <li><a href="ShoeStoreServlet?currentPage=1&flag=getShoesNames&categoryId=10">产品</a></li>
                <li><a href="ShopCarOrderServlet?flag=selectShoppingCart">我的购物车</a></li>
                <li><a href="ShoeOrderServlet?flag=selectAllOrder&userId=${tuser.userId }&currentPage=1">我的订单</a></li>
            </ul>
            <br style="clear: left" />
        </div> <!-- end of ddsmoothmenu -->
    </div> <!-- END of templatemo_menubar -->
    
    <div id="templatemo_main">
            <div id="content" class="float_l" style="height:600px;margin-left:40px">
        	<h2>订单列表</h2>


            <table style="border:1px solid #CCCCCC;" width="100%">
            
                <tr>
                    <td>
                       订单编号
                    </td>
                    <td width="300px;" style="padding: 0px 20px;">
                        订单日期
                    </td>
                    <td>金额</td>
                </tr>
				<c:forEach items="${orderList }" var="order">
                <tr>
                    <td>
                        <a href="ShoeOrderServlet?flag=seecareful&orderId=${order.orderId }" class="more">${order.orderId }</a>
                    </td>
                    <td width="200px;" style="padding: 0px 20px;">
                        ${order.date }
                    </td>
                    <td>￥${order.amount }</td>
                </tr>

				</c:forEach>
            </table>

            <br>
            <a href="ShoeOrderServlet?flag=selectAllOrder&userId=${tuser.userId }&currentPage=1" class="more">首页</a> |
            <a href="ShoeOrderServlet?flag=selectAllOrder&userId=${tuser.userId }&currentPage=${currentPage - 1}" class="more">上一页</a> |
            <a href="ShoeOrderServlet?flag=selectAllOrder&userId=${tuser.userId }&currentPage=${currentPage + 1}"  class="more">下一页</a> |
            <a href="ShoeOrderServlet?flag=selectAllOrder&userId=${tuser.userId }&currentPage=${pages}"  class="more">尾页</a>
        </div>


        <div class="cleaner"></div>
    </div> <!-- END of templatemo_main -->

    <div id="templatemo_footer">
        <p><a href="LoginServlet">首页</a> | <a href="ShoeStoreServlet?currentPage=1&flag=getShoesNames&categoryId=10">产品</a> | <a href="ShopCarOrderServlet?flag=selectShoppingCart">我的购物车</a> | <a href="ShoeOrderServlet?flag=selectAllOrder&userId=${tuser.userId }&currentPage=1">我的订单</a>
		</p>

        版权所有 (c) 2018 <a href="#">南通穿美网络</a>
    </div> <!-- END of templatemo_footer -->
    
</div> <!-- END of templatemo_wrapper -->
</div> <!-- END of templatemo_body_wrapper -->

</body>
</html>