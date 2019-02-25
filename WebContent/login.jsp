<%@page import="com.domain.Tuser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%String basePath = request.getScheme() + "://" + request.getServerName() +":" +request.getServerPort() + request.getContextPath() + "/";%>
<%=basePath %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Shoes Store - Contact Page</title>
<meta name="keywords" content="shoes store, contact, maps, addresses, contact form, free template, ecommerce, CSS, HTML" />
<meta name="description" content="Shoes Store, Contact Page, free template provided " />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/ddsmoothmenu.js">

</script>
<%Tuser tuser = (Tuser)session.getAttribute("tuer"); %>
<script type="text/javascript">
	function checks(){
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		if(username == null || username == ""){
			document.getElementById("errMsg1").innerHTML = "用户名不能为空";
			document.getElementById("errMsg1").style.display = "block";
		}else if(username.length > 10){
			document.getElementById("errMsg1").innerHTML = "用户名不得长于10个字符";
			document.getElementById("errMsg1").style.display = "block";
		}else{
			document.getElementById("errMsg1").style.display = "none";
		}
		if(password == null || password == ""){
			document.getElementById("errMsg2").innerHTML = "密码不能为空";
			document.getElementById("errMsg2").style.display = "block";
		}else if(password.length > 10){
			document.getElementById("errMsg2").innerHTML = "密码不得长于10个字符";
			document.getElementById("errMsg2").style.display = "block";
		}else{
			document.getElementById("errMsg2").style.display = "none";
		}
	}
	
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

<body>

<div id="templatemo_body_wrapper">
<div id="templatemo_wrapper">

	<div id="templatemo_header">
    	<div id="site_title"><h1><a href="LoginServlet">穿美在线鞋城</a></h1></div>
          <div class="cleaner"></div>
    </div> <!-- END of templatemo_header -->

    <div id="templatemo_main">

        <div id="content" class="float_r">
        	<h1>登录</h1>
            <div class="content_half float_l">
                <div id="contact_form">
                   <form method="post" name="contact" action="LoginServlet?flag=loginTuser">
                        
                        <label for="author">帐户:</label> <input type="text" id="username" name="username" onblur="checks()" class="required input_field" /><span id="errMsg1" style="color:red;display: none">账号不能为空</span>
                        <div class="cleaner h10"></div>
                        <label for="email">密码:</label> <input type="password" id="password" name="password" onblur="checks()" class="validate-email required input_field" /><span id="errMsg2" style="color:red;display: none">密码不能为空</span>
                        <div class="cleaner h10"></div>

                        <input type="submit" class="submit_btn" name="submit" id="submit" value="登录" />
                        
                    </form>
                </div>
            </div>

        
        <div class="cleaner h40"></div>
        

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