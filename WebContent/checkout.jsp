<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script type="text/javascript">
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

</script>
</head>
<script type="text/javascript">
function getTuserMsg(){
	var vq = document.getElementById("tuserMsg").innerHTML;
		if(vq == ""){
			
			document.getElementById("Tusername").style.display = "inline";
			document.getElementById("tMsg").style.display = "none";
		
		}else{
			
			document.getElementById("Tusername").style.display = "none";
			document.getElementById("tMsg").style.display = "inline";
		}
}
function checkForm(){
	
	
	var phonereg=/^[1][3,4,5,7,8][0-9]{9}$/; //手机号正则
	
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
function check1(){
	getXMLHttpRequest();
	var receiveId = document.getElementById("receiveId").value;
	var province = document.getElementById("province").value;
	var city = document.getElementById("city").value;
	var country = document.getElementById("country").value;
	var home = document.getElementById("home").value;
	var postal = document.getElementById("postal").value;
	var phone = document.getElementById("phone").value;
	var userId = document.getElementById("tuserId").innerHTML;
	var count = document.getElementById("count").innerHTML;
	var agreement = document.getElementById("agreement").checked;
	var url = "ShoeOrderServlet?flag=checkOrder&receiveId="+receiveId+"&province="+province+"&city="+city+"&country="+country+"&home="+home+"&postal="+postal+"&phone="+phone+"&count="+count+"&userId="+userId+"&payWay=2"+"&agreement="+agreement+"&currentPage=1";
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
			if(result.trim() == 0){
				alert("请完善订单信息");
			}else if(result.trim() == -1){
				alert("请勾选本网站的使用条款");
			}else{
				alert("购买成功");
				var receiveId = document.getElementById("receiveId").value;
				var province = document.getElementById("province").value;
				var city = document.getElementById("city").value;
				var country = document.getElementById("country").value;
				var home = document.getElementById("home").value;
				var postal = document.getElementById("postal").value;
				var phone = document.getElementById("phone").value;
				var userId = document.getElementById("tuserId").innerHTML;
				var count = document.getElementById("count").innerHTML;
				var agreement = document.getElementById("agreement").checked;
				
				location.href="ShoeOrderServlet?flag=successBuy&receiveId="+receiveId+"&province="+province+"&city="+city+"&country="+country+"&home="+home+"&postal="+postal+"&phone="+phone+"&count="+count+"&userId="+userId+"&payWay=2"+"&agreement="+agreement+"&currentPage=1";
			}
		}
	}
}
function check2(){
	getXMLHttpRequest();
	var receiveId = document.getElementById("receiveId").value;
	var province = document.getElementById("province").value;
	var city = document.getElementById("city").value;
	var country = document.getElementById("country").value;
	var home = document.getElementById("home").value;
	var postal = document.getElementById("postal").value;
	var phone = document.getElementById("phone").value;
	var userId = document.getElementById("tuserId").innerHTML;
	var count = document.getElementById("count").innerHTML;
	var agreement = document.getElementById("agreement").checked;
	var url = "ShoeOrderServlet?flag=checkOrder&receiveId="+receiveId+"&province="+province+"&city="+city+"&country="+country+"&home="+home+"&postal="+postal+"&phone="+phone+"&count="+count+"&userId="+userId+"&payWay=1"+"&agreement="+agreement+"&currentPage=1";
	console.log(url);
	xmlHttpRequest.open("post",url,true);

	xmlHttpRequest.onreadystatechange = callBackc;
	xmlHttpRequest.send(null);
}
function callBackc(){
	if(xmlHttpRequest.readyState == 4){
		if(xmlHttpRequest.status == 200){
			var result = xmlHttpRequest.responseText;
			console.log(result);
			if(result.trim() == 0){
				alert("请完善订单信息");
			}else if(result.trim() == -1){
				alert("请勾选本网站的使用条款");
			}else{
				alert("购买成功");
				var receiveId = document.getElementById("receiveId").value;
				var province = document.getElementById("province").value;
				var city = document.getElementById("city").value;
				var country = document.getElementById("country").value;
				var home = document.getElementById("home").value;
				var postal = document.getElementById("postal").value;
				var phone = document.getElementById("phone").value;
				var userId = document.getElementById("tuserId").innerHTML;
				var count = document.getElementById("count").innerHTML;
				var agreement = document.getElementById("agreement").checked;
				
				location.href="ShoeOrderServlet?flag=successBuy&receiveId="+receiveId+"&province="+province+"&city="+city+"&country="+country+"&home="+home+"&postal="+postal+"&phone="+phone+"&count="+count+"&userId="+userId+"&payWay=1"+"&agreement="+agreement+"&currentPage=1";
			}
		}
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
        	<h2>结算</h2>
            <h5><strong>收货人信息</strong></h5>
            <div class="content_half float_l checkout">
               收货人姓名:
                  <input id="receiveId" type="text"  style="width:300px;"  />
                <br />
                <br />
              省份:
				<input id="province" type="text"  style="width:300px;"  />
                <br />
                <br />
              城市:
                <input id="city" type="text"  style="width:300px;"  />
                <br />
                <br />
                区、县:
                <input id="country" type="text"  style="width:300px;"  />
            </div>
            
            <div class="content_half float_r checkout">
            	地址
                <input id="home" type="text"  style="width:300px;" />
                <br />
                <br />
                邮编
                <input id="postal" type="text"  style="width:300px;"  />
                <br />
                <br />
                电话<br />
				<span style="font-size:10px">请提供真实有效的电话，以便快递员送货时与您联系.</span>
                <input id="phone" type="text"  style="width:300px;"  />
            </div>
            
            <div class="cleaner h50"></div>
            <h3>购物车</h3>
            <h4>总金额: ￥<strong id="count">${count }</strong></h4>
			<p><input id="agreement" name="agreement" type="checkbox" />
			我接受本网站的使用条款.</p>
            <table style="border:1px solid #CCCCCC;" width="100%">
                <tr>
                    <td height="80px"> <img src="images/alipay.jpg" alt="alipay" /></td>
                    <td width="400px;" style="padding: 0px 20px;">推荐使用支付宝付款。使用红包支付，更多实惠！</td>
                    <td><a onclick="check2()" class="more">支付宝支付</a></td>
                </tr>
                <tr>
                    <td  height="80px"><img src="images/wechat.jpg" alt="wechatpay" />
                    </td>
                    <td  width="400px;" style="padding: 0px 20px;">没有支付宝帐户，不用担心，我们也支持微信支付</td>
                    <td><a onclick="check1()" class="more">微信支付</a></td>
                </tr>
            </table>

            <br>
            <a href="javascript:history.back()">暂不结算，返回购物车</a>
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