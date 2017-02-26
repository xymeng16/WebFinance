<%@page import="DAO.UserDao"%>
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
<title>withdraw</title>
<link href="<%=basePath%>/css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/font-style.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/index.css">
<link rel="stylesheet" type="text/css" href="css/all.css">
	<link rel="stylesheet" type="text/css" href="css/detail.css">
	
	<link rel="stylesheet" type="text/css" href="css/detail2.css">
	<style type="text/css">

	</style>
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		$('.inactive').click(function(){
			if($(this).siblings('ul').css('display')=='none'){
				$(this).parent('li').siblings('li').removeClass('inactives');
				$(this).addClass('inactives');
				$(this).siblings('ul').slideDown(100).children('li');
				if($(this).parents('li').siblings('li').children('ul').css('display')=='block'){
					$(this).parents('li').siblings('li').children('ul').parent('li').children('a').removeClass('inactives');
					$(this).parents('li').siblings('li').children('ul').slideUp(100);

				}
			}else{
				//控制自身变成+号
				$(this).removeClass('inactives');
				//控制自身菜单下子菜单隐藏
				$(this).siblings('ul').slideUp(100);
				//控制自身子菜单变成+号
				$(this).siblings('ul').children('li').children('ul').parent('li').children('a').addClass('inactives');
				//控制自身菜单下子菜单隐藏
				$(this).siblings('ul').children('li').children('ul').slideUp(100);

				//控制同级菜单只保持一个是展开的（-号显示）
				$(this).siblings('ul').children('li').children('a').removeClass('inactives');
			}
		})
	});
	</script>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/all.js"></script>
<!-- <script type="text/javascript" src="js/VisitorAPI-1.2.1-min.js"></script> -->
<%
String user;
user =(String)request.getSession().getAttribute("username");

%>
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
                <label class="fff">Welcome,<%=usern %></a>
                
            </div>
            
           
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
                    <a rel="nofollow" href="index.jsp" title="首页" class="one">首页</a>
                </li>
                <li class="rela">
                    <a href="servlet/doinvest?pageNos=1" title="我要投资" class="one">我要投资</a>
                </li>
                <li class="rela">
                    <a href="toborrow.jsp" title="我要借款" class="one">我要借款</a>
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
<div class="bodybar">
		<div class="Width">
			<div class="left">
				<div class="list">
					<ul class="yiji">
							<li><a href="pcenter.jsp" class="inactive">个人中心</a>
						<li><a href="withdraw.jsp#" class="inactive">完善信息</a>
							<ul style="display: none">
								<li><a href="detailmess.jsp" class="inactive active">个人详细信息</a>
<%--									<ul>--%>
<%--										<li><a href="#">办公室</a></li>--%>
<%--										<li><a href="#">人事处</a></li>--%>
<%--										<li><a href="#">组联部</a></li>--%>
<%--										<li><a href="#">外联部</a></li>--%>
<%--										<li><a href="#">研究部</a></li>--%>
<%--										<li><a href="#">维权办</a></li>--%>
<%--									</ul>--%>
								</li>
								<li><a href="detailwork.jsp">工作详细信息</a></li>
							</ul>
						</li>
						<li><a href="withdraw.jsp#" class="inactive">钱款操作</a>
							<ul style="display: none">
								<li><a href="pay.jsp" class="inactive active">充值</a></li>
								<li><a href="withdraw.jsp" class="inactive active">提现</a></li>
							</ul>
						</li>
					</ul>
				</div>

			</div>
			<div class="bodybar">
		<div class="Width">
				<div class="formwrapper" style="float:right";> 
			<form action="servlet/dowithdraw" method="post" name="tomess" id ="tomess"> 
    <fieldset> 
        <legend>个人详细信息</legend>
        <div> 
            <label>Number you wanna withdraw</label> 
            <input type="text"  name="Withdraw"  size="18" maxlength="30" value="" /><br /> 
            <input type="submit" value="checked"/>
        </div>  
        </fieldset>
        </form>
        </div>
        </div>
        </div>
</body>
</html>