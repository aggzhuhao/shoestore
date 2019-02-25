<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Shoes Store - Product Detail</title>
<meta name="keywords" content="shoes store, product detail, free template, ecommerce, online shop, website templates, CSS, HTML" />
<meta name="description" content="Shoes Store, Product Detail, free ecommerce template provided " />
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

<script type="text/javascript" src="js/jquery-1-4-2.min.js"></script> 
<link rel="stylesheet" href="css/slimbox2.css" type="text/css" media="screen" /> 
<script type="text/JavaScript" src="js/slimbox2.js"></script> 
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
function check(){
	getXMLHttpRequest();
	var textQuantity = document.getElementById("textQuantity").value;
	var quantity = document.getElementById("quantity").innerHTML;
	var url = "ShoeStoreServlet?flag=checkQuantity&textQuantity="+textQuantity+"&quantity="+quantity;
	console.log(url);
	xmlHttpRequest.open("post",url,true);

	xmlHttpRequest.onreadystatechange = callBack;
	xmlHttpRequest.send(null);
}
function callBack(){
	if(xmlHttpRequest.readyState == 4){
		if(xmlHttpRequest.status == 200){
			var result = xmlHttpRequest.responseText;
			
			console.log(result);
			if(result.trim() == "true"){
				document.getElementById("errMsg").style.display = "inline";
			}else{
				document.getElementById("errMsg").style.display = "none";
			}
		}
	}
}
function insertShopping(){
	var textQuantity = document.getElementById("textQuantity").value;
	var quantity = document.getElementById("quantity").innerHTML;
	console.log(textQuantity.trim() +"::"+quantity.trim())
	var a = parseInt(textQuantity.trim());
	var b = parseInt(quantity.trim());
	var reg = /^[1-9]+.?[0-9]*$/;
	if(!reg.test(textQuantity)){
		alert("请输入正确的数值");
	}else{
		if(a < b ){
			location.href="ShopCarOrderServlet?flag=insertShoppingCart&userId=" + ${tuser.userId } +"&productId="+${product.productId}+"&quantity=" + textQuantity;
		}else{
			alert("库存不足，无法加入购物车");
		}
	}
}


</script>

</head>

<body onload="getTuserMsg()">
<span id="tuserMsg" style="display: none;">${tuser.username }</span>
<div id="templatemo_body_wrapper">
<div id="templatemo_wrapper">

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

        <!--产品细节-->
        <div id="content" class="float_r">
        	<h1>产品细节</h1>
            <div class="content_half float_l">
        	<a  rel="lightbox[portfolio]" href="${product.imgpath }"><img src="${product.imgpath }" alt="image" /></a>
            </div>
            <div class="content_half float_r">
                <table>
                    <tr>
                        <td width="160">单价:</td>
                        <td>￥${product.price }</td>
                    </tr>
                    <tr>
                        <td>库存:</td>
                        <td id="quantity">${quantity }</td>
                    </tr>
                    <tr>
                        <td>型号:</td>
                        <td>${product.model }</td>
                    </tr>
                    <tr>
                        <td>品牌:</td>
                        <td>${categoryName }</td>
                    </tr>
                    <tr>
                    	<td>数量</td>
                        <td><input id="textQuantity" type="text" value="1" style="width: 20px; text-align: right"  onblur="check()" /><span id="errMsg" style="display: none;color: red">库存不足</span></td>
                    </tr>
                    
                </table>
                <div class="cleaner h20"></div>

                <a onclick="insertShopping()" class="addtocart" ></a>

			</div>
            <div class="cleaner h30"></div>
            
            <h5>特性描述</h5>
            <p>${product.feature }</p>
            
          <div class="cleaner h50"></div>
            
            <h3>与您浏览过的商品相关的推荐</h3>
        	<c:forEach items="${popularProductList }" var="product">
        	<div class="product_box">
            	<a href="ShoeStoreServlet?flag=aboutShoes&model=${product.model }&categoryName=${product.name}"><img src="${product.imgpath  }" alt="" /></a>
                <h3>${product.description }</h3>
                <p class="product_price">￥${product.price }</p>
                <a onclick="insertShopping()" class="addtocart"></a>
                <a href="ShoeStoreServlet?flag=aboutShoes&model=${product.model }&categoryName=${product.name}" class="detail"></a>
            </div>
            </c:forEach>
                    
                    
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