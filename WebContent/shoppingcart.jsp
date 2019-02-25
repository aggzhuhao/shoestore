<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Shoes Store - Shopping Cart</title>
<meta name="keywords" content="shoes store, shopping cart, free template, ecommerce, online shop, website templates, CSS, HTML" />
<meta name="description" content="Shoes Store, Shopping Cart, online store template " />
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
<script type="text/javascript">
function getTuserMsg1(){
	var vq = document.getElementById("tuserMsg").innerHTML;
		if(vq == ""){
		
			document.getElementById("Tusername").style.display = "inline";
			document.getElementById("tMsg").style.display = "none";
		
		}else{
			
			document.getElementById("Tusername").style.display = "none";
			document.getElementById("tMsg").style.display = "inline";
		}
}
var checkout;
function getQuantity(){
	
	var quantityerr = document.getElementsByName("quantity");
	var productId = document.getElementsByName("productId");
	var userId = document.getElementById("tuserId").innerHTML;
	console.log(quantityerr);
		var shoppingCarStr = new String();
		//var shoppingCartMap = new Map();
		var productIdarr = new Array();
		var quantityarr = new Array();
	
		for(var i = 0;i < quantityerr.length;i++ ){
			var s = quantityerr[i].value;
			quantityarr[i] = s.trim();
			var d = productId[i].innerHTML;
			productIdarr[i] = d.trim();
			shoppingCarStr += (productIdarr[i]+":"+quantityarr[i]+",");
		}
		console.log(shoppingCarStr);
	if(quantityerr.length == 0){
		alert("您购物车内没有商品");
	}else if(checkout == 0){
		alert("库存不足，无法更新商品");	
	}else{
		location.href="ShopCarOrderServlet?flag=updateSumShoppingCart&shoppingCarStr="+shoppingCarStr+"&userId="+userId;
	}
}

function successBug(){
	var quantityerr = document.getElementsByName("quantity");
	if(quantityerr.length == 0){
		alert("您购物车内没有商品");
	}else if(checkout == 0){
		alert("库存不足，无法购买");	
	}else{
		location.href="checkout.jsp";
	}
	
}
function updateMsg(){

	var quantityerr = document.getElementsByName("quantity");
	if(quantityerr.length == 0){
		document.getElementById("update").style.display = "none";
		document.getElementById("prompt").style.display = "inline";
	}else{
		document.getElementById("update").style.display = "inline";
		document.getElementById("prompt").style.display = "none";
	}
	
	
}
/* AJAX */
var xmlHttpRequest = null;
function getXMLHttpRequest(){
	try{
		xmlHttpRequest = new XMLHttpRequest();
	}catch(e){
		try{
			xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
		}catch(e2){
			xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
}
function checkQuantity(productId,test){
	getXMLHttpRequest();
	console.log(test);
	var textQuantity = document.getElementById(test.id).value;
	
	var url = "ShopCarOrderServlet?flag=checkShoppingCartQuantity&productId="+productId+"&textQuantity="+textQuantity;
	
	
	console.log(url);
	xmlHttpRequest.open("post",url,true);

	xmlHttpRequest.onreadystatechange = callBack;
	xmlHttpRequest.send(null);
}

function callBack(){
	console.log("ajax---------");
	if(xmlHttpRequest.readyState == 4){
		if(xmlHttpRequest.status == 200){
			var checkXml = xmlHttpRequest.responseXML.getElementsByTagName("check");
			var check = checkXml[0].firstChild.nodeValue;
			var productIdXml = xmlHttpRequest.responseXML.getElementsByTagName("productId");
			var productId = productIdXml[0].firstChild.nodeValue;
			console.log(productId+":"+check);
			checkout = check;
			if(check == 0){
				document.getElementById(productId).style.display = "inline";
			}else{
				document.getElementById(productId).style.display = "none";
			}
		}
	}
}  
</script>
</head>

<body onload="getTuserMsg1(),updateMsg()">

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
        <div id="sidebar" class="float_l">
            <div class="sidebar_box"><span class="bottom"></span>
                <h3>品牌</h3>
                <div class="content">
                    <ul class="sidebar_list">
                       <c:forEach items="${categoryList }" var="shoes">
                        <li><a href="ShoeStoreServlet?flag=getShoesNames&categoryId=${shoes.categoryId }&categoryName=${shoes.cname}">${shoes.cname }</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div class="sidebar_box"><span class="bottom"></span>
                <h3>热卖单品 </h3>
                <div class="content">
                   <c:forEach items="${popularProductList }" var="product">
                    <div class="bs_box">
                    	
                        <a href="ShoeStoreServlet?flag=aboutShoes&model=${product.model }&categoryName=${product.name}"><img src="${product.imgpath  }" alt="image" style="width:96px;height:72px"/></a>
                        <h4><a href="ShoeStoreServlet?flag=aboutShoes&model=${product.model }&categoryName=${product.name}">${product.description }</a></h4>
                        <p class="price">￥${product.price }</p>
                        <div class="cleaner"></div>
                    </div>
                    </c:forEach>
                </div>
            </div>
        </div>

        <div id="content" class="float_r">
        	<h1>购物车</h1>
        	<table width="680px" cellspacing="0" cellpadding="5">
                   	  <tr bgcolor="#ddd">
                        	<th width="220" align="left">图片 </th>
                        	<th width="180" align="left">商品描述 </th>
                       	  	<th width="100" align="center">数量 </th>
                        	<th width="60" align="right">价格 </th>
                        	<th width="60" align="right">小计 </th>
                        	<th width="90"> </th>
                            
                      </tr>
                     
                      	<c:forEach items="${shoppingCartList }" var="shoppingCart">
                    	<tr>
                    		
                        	<td><img src="${shoppingCart.product.imgpath }" alt="image 1" /></td> 
                            <span name="productId" style="display: none">${shoppingCart.product.productId}</span>
                            <td>${shoppingCart.product.description }</td>
                            <td align="center"><input type="text" id="${'a' }${shoppingCart.product.productId}" name="quantity" type="text" value="${shoppingCart.quantity }" style="width: 20px; text-align: right" onblur="checkQuantity(${shoppingCart.product.productId },${'a' }${shoppingCart.product.productId})" /><span  id="${shoppingCart.product.productId }" style="color: red;display: none">库存不足</span></td>
                            <td align="right">￥${shoppingCart.product.price } </td>
                            <td  id="countMoney"  align="right">￥${shoppingCart.product.price * shoppingCart.quantity } </td>
                            <td align="center"> <a href="ShopCarOrderServlet?flag=deleteShoppingCart&shoppingCartId=${shoppingCart.shoppingCartId }"><img src="images/remove_x.gif" alt="remove" /><br />移除</a> </td>
						</tr>
                        </c:forEach>
         				
                        <tr>
                        
                        	<td colspan="3" align="right"  height="30px"><span id="update" style="display: none">如果你已修改了商品，请单击 <a onclick="getQuantity()"><strong>更新</strong></a>&nbsp;&nbsp;</td></span>
                            <td align="right" style="background:#ddd; font-weight:bold"> 合计 </td>
                            <td align="right" style="background:#ddd; font-weight:bold"> ￥${count} </td>
                            <td style="background:#ddd; font-weight:bold"> </td>
						</tr>
						
					</table>
					 <span id="prompt" style="font-size: 30px;display: none">购物车内没有任何商品哦！</span>
                    <div style="float:right; width: 215px; margin-top: 20px;">
                   
					<p><a onclick="successBug()">结算</a></p>
                    <p><a href="products.jsp">继续购物</a></p>
                    	
                    </div>
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