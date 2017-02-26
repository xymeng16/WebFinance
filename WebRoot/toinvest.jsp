<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import ="DAO.ToBorrowDao" %>
<%@ page import ="entity.ToBorrow" %>

<!doctype html>
<html>
<head>
<!--app-website:6.1-->
<meta charset="utf-8">
<title>toinvest</title>
<link href="<%=basePath%>/css/style.css" rel="stylesheet" type="text/css" >
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/font-style.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/index.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/all.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/detail.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/detail2.css">
	<style type="text/css">

	</style>
	<script type="text/javascript" src="<%=basePath%>/js/jquery-1.11.1.min.js"></script>
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
<%List<ToBorrow> resultList=(List<ToBorrow>)request.getSession().getAttribute("result"); %>
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
						<li><a href="toinvest.jsp#" class="inactive">完善信息</a>
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
						<li><a href="toinvest.jsp#" class="inactive">钱款操作</a>
							<ul style="display: none">
								<li><a href="pay.jsp" class="inactive active">充值</a></li>
								<li><a href="withdraw.jsp" class="inactive active">提现</a></li>
							</ul>
						</li>
					</ul>
				</div>

			</div>
     <div class="mod-list-wrap">
       <div class="mod-list">
        <!--mod-list-nav start-->
      
        <!--mod-list-nav end-->
        <!--mod-list-cont start-->
           <div class="mod-list-cont">
                <div class="list-cont-bd">
                   
                    <div class="pp-content" style="position: relative;">
                    <c:if test = "${fn:length(sessionScope.result) eq 0 }">
                          <span>无借贷信息</span>
                    </c:if>
                   <c:if test = "${fn:length(sessionScope.result) gt 0 }">
                   <c:forEach items="${sessionScope.result}" var="sample">
                            <div class="item-box">
                    <div class="prj-box prj-box01">
                        <a href="servlet/doshowinvest?Id=<c:out value="${sample.id}"></c:out>" ><img src="images/cphah_jiush.jpeg" alt="" width="152" height="166"></a>
                    </div>
                    <div class="prj-box prj-box02">
                        <h2>
                            <div class="prj-name-c ellipsis"><a style="color:black" target="_blank" href="servlet/doshowinvest?Id=<c:out value="${sample.id}"></c:out>" ><c:out value="${sample.title}"></c:out></a></div>
                        </h2>
                        <div class="prj-info cf">
                            <div class="row profit">
                                <span class="t">年化收益</span><br>
                                <div class="row-c">
                                    
                                    <span class="hot"><c:out value="${sample.rate}"></c:out></span><span class="hot percent">%</span>
                                    
                                </div>
                            </div>
                            <div class="row price">
                                <span>投资期限</span><br>
                                <div class="row-c">
                                    
                                    <span class="em"><c:out value="${sample.time}"></c:out></span>天
                                    
                                </div>
                            </div>
                            <div class="row date">
                                <span>融资金额</span><br>
                                <div class="row-c">
                                    
                                    <span class="em"><c:out value="${sample.target}"></c:out></span>万元
                                    
                                </div>
                            </div>
                        </div>
                       
                    </div>
                    <div class="status-box">
                    
                    <div class="prj-box prj-box03">
                        <div class="row progress">
                            <label style="width:80px;float:left">投资进度：</label>
                            <div class="progress-box"><div class="progress-ing" style="width: 0.00%"></div></div>
                          
                        </div>
                        <div class="row">
                            <label style="width:80px;float:left">可投金额：</label><span class="v"><c:out value="${sample.target}"></c:out></span>万元
                        </div>
                        <div class="prj-c-list btn-c">
                            <a target="_blank" href="servlet/doshowinvest?Id=<c:out value="${sample.id}"></c:out>" class="btn btn-invest">立即投资</a>
                        </div>
                    </div>
                    


                </div>
                </div>
                </c:forEach>
                   
                 </c:if>
                </div>
                </div>
                <div class="list-cont-ft">
                <fmt:formatNumber type="number"  maxFractionDigits="0" value="${sessionScope.totalPage}" var="total"></fmt:formatNumber>
                 <div id="PrjPagi" class="pp-pagination-wrap"><div class="pp-pagination"><div class="page-info">第<c:out value="${sessionScope.pageNos}"></c:out>页，共<c:out value="${total}"></c:out> 页
				</div>
				<ul class="pagination">
				<li class="disable"><a href="servlet/doinvest?pageNos=1" style="color:black">首页</a></li>
				 <c:if test="${sessionScope.pageNos>1 }">
				<li class="disable"><a href="servlet/doinvest?pageNos=${sessionScope.pageNos-1}" style="color:black"> 上一页</a></li>
				</c:if>
				 <c:if test="${sessionScope.pageNos==1 }">
				 <li class="disable"><span style="color:black"> 上一页</span></li>
				 </c:if>
				<li class="cur"><c:out value="${sessionScope.pageNos}" ></c:out></li>
				<c:if test="${sessionScope.pageNos < total }">
				<li class="disable"><a href="servlet/doinvest?pageNos=${sessionScope.pageNos+1 }" style="color:black">下一页</a></li>
				</c:if>
				<c:if test="${sessionScope.pageNos == total }">
				<li class="disable"><span style="color:black">下一页</span></li>
				</c:if>
				<li class="disable"><a href="servlet/doinvest?pageNos=${total}" style="color:black">末页</a></li>
				</ul></div></div>
             







           
                   
                       </div>
        </div>
        <!--mod-list-cont end-->
        <div class="clear"></div>
    </div>
</div>
</div>
</div>
</body>
</html>
