<%@page import="com.domain.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Shoes Store, free template</title>
<meta name="keywords" content="shoes store, free template, ecommerce, online shop, website templates, CSS, HTML" />
<meta name="description" content="Shoes Store is a free ecommerce template provided " />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="nivo-slider.css" type="text/css" media="screen" />

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

        <!--滚动广告 /////////////////////////////////////////////////////-->
        <div id="content" class="float_r">
        	<div id="slider-wrapper">
                <div id="slider" class="nivoSlider">
                <c:forEach items="${adProductList }" var="product">
                	
                    <a href="ShoeStoreServlet?flag=aboutShoes&model=${product.model }"><img src="${product.imgpath }" title="${product.description }"/></a>
                </c:forEach>
                </div>
            </div>
            <script type="text/javascript" src="js/jquery-1.4.3.min.js"></script>
            <script type="text/javascript" src="js/jquery.nivo.slider.pack.js"></script>
            <script type="text/javascript">
            $(window).load(function() {
                $('#slider').nivoSlider();
            });
            </script>

            <!--新品/////////////////////////////////////////////////////-->
        	<h1>新品上市</h1>
        	<c:forEach items="${newProductList }" var="product">
            <div class="product_box">
                <a href="ShoeStoreServlet?flag=aboutShoes&model=${product.model }"><img src="${product.imgpath  }" alt="Shoes 1" /></a>
                <p>${product.description  }</p>
                <p class="product_price">￥${product.price }</p>
                <a href="shoppingcart.jsp" class="addtocart"></a>
                <a href="ShoeStoreServlet?flag=aboutShoes&model=${product.model }" class="detail"></a>
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