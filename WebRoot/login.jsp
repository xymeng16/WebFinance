<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<!--app-website:6.1-->
<meta charset="utf-8">
<title>login</title>
<link href="<%=basePath%>/css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/font-style.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/index.css">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/all.js"></script>
<!-- <script type="text/javascript" src="js/VisitorAPI-1.2.1-min.js"></script> -->
<script type="text/javascript">
	function reeeload(){
	
	  document.getElementById("piccode").src="servlet/ImageServlet?"+Math.random();
	}
	</script>
	<%
String usern="";
String passw="";
Cookie[] cookies = request.getCookies();
if (cookies != null) {
	for (Cookie c : cookies) {
		if ("username".equals(c.getName())) {
			usern = c.getValue();
			
		}
		if ("password".equals(c.getName())){
			passw = c.getValue();
		}
	}
}
%>
</head>
<body class="index_niwo holiday_bg">
<div class="niwdoawi_top mw_1180">
    <div class="header w1190 clearfix">
        <div class="fl tel">
            <em class="fs_14 mr_5 tel_ico">客服热线</em><i class="aril">18050039406</i>
           
          
            <div class="webdown"></div>
            </span>
            <span class="hover_sina">
                <a href="" target="_blank"></a>
            </span>
            <span class="hover_weixin toptk">
                <div class="tk">
                    
                </div>
            </span>
        </div>
        <div class="fr login clearfix">
            
            <div class='login_bt'>
                <a href="login.jsp" rel="nofollow" title="登录" class="fff">登录</a>
                <a href="signup.jsp" rel="nofollow" title="注册" class="fff">注册</a>
            </div>
            
            <dl>
                <dt><a href="#" title="账户中心" rel="nofollow" class="txnone" style="color:#ffffff">账户中心</a></dt>
                <dd><a href="#" rel="nofollow" title="充值">充值</a></dd>
                <dd><a href="#" rel="nofollow" title="提现">提现</a></dd>
                <dd><a href="#" rel="nofollow" title="我的投资">我的投资</a></dd>
                <dd><a href="#" target="_blank" rel="nofollow" title="我的借款">我的借款</a></dd>
            </dl>
            <div class="community"><a href="#" target="_blank" rel="nofollow" class="fc_white">关于我们</a></div>
        </div>
    </div>
</div><!--登录-->
<div class="niwdoawi_center mw_1180">
    <div class="w1190 logo clearfix">
        <a href="" title="" class="fl pl_20 logo_a holiday_logo"><img src="images/logo.jpg" height="52" alt=""/></a>
        <div class="fr righ">
            <ul class="nav clearfix">
                <li>
                    <a rel="nofollow" href="index。jsp" title="首页" class="one">首页</a>
                </li>
                <li class="rela">
                    <a href="#" title="我要投资" class="one">我要投资</a>
                </li>
                <li class="rela">
                    <a href="#" title="我要借款" class="one">我要借款</a>
                </li>
                <li class="rela">
                    <a href="#" title="新手导航" class="one">关于我们 </a>
                </li>
                <!-- <li style="margin-right:0;">
                    <a href="" target="_blank" title="社区" class="one">社区 </a>
                </li> -->
            </ul>
        </div>
    </div>
</div><!--nav-->
<div class="formwrapper"> 

<h3 id = "enter">FinancePlatform Sign In</h3> 
    <form action="dologin" method="post" name="apLogin" id="apLogin"> 
    <fieldset> 
        <legend>Login</legend> 
        <div> 
            <label for="Name">Username</label> 
            <input type="text" name="Username" id="Name" size="18" maxlength="30" value="<%=usern %>" /><br /> 
        </div> 
        <div> 
            <label for="password">Password</label> 
            <input type="password" name="Password" id="password" size="18" maxlength="15" value="<%=passw %>" /><br /> 
        </div> 
        <div>
        <label for="checkcode">Checkcode</label>
        <input type="text" name="Checkcode" id="checkcode" size="18" maxlength="30"/>
        <img alt="验证码" id ="piccode" src="servlet/ImageServlet" />
        <a href="javascript:reeeload();">Another</a><br>
        </div>
        <div class="cookiechk"> 
            <label><input type="checkbox" name="Iscookie" id="CookieYN" value="" /> Remember me</label> 
            <input name="login" type="submit" class="buttom" value="login" />
            <input name="signup" type="button" class="buttom"  value="sign up" onclick="javascript:window.location.href='signup.jsp'"/> 
        </div>     
        
    </fieldset> 
    </form><br /> 
    
</div> 
</body>
</html>