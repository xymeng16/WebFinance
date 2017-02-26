<%@page import="DAO.UserDao"%>
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
<%@ page import ="entity.DetailMess" %>

<!doctype html>
<html>
<head>
<!--app-website:6.1-->
<meta charset="utf-8">
<title>showdetails</title>
<link href="<%=basePath%>/css/style.css" rel="stylesheet" type="text/css" >
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/font-style.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/index.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/all.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/e.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/d.css">
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
<%
ToBorrow tb = (ToBorrow)request.getSession().getAttribute("tb");
DetailMess dm = (DetailMess)request.getSession().getAttribute("dm");
%>
<div class="content">
    <div class="pro-wrap cf">
        <div class="pro-maincontent">
            <div class="pro-subcont1">
                <div class="pro-subcont1-hd cf">
                    <h3 class="pro-subcont1-title ellipsis" title="【新手标】装饰设计公司融资项目(4期)GZ1508201644"><%=tb.getTitle()%></h3>
                        
                </div>
                <div class="pro-subcont1-bd cf">
                    <img src="images/xiaotutu58.jpeg" alt="【新手标】装饰设计公司融资项目(4期)" class="fl" width="180" height="200">
                    <div class="pro-subcont1-txt">
                        <div class="section-info cf">
                            <div class="rate-l cf">
                                <div class="main-rate"><%=tb.getRate()%></div>
                                <div class="rate-txt-wrap">
                                    <p class="rate-txt1">%                                     </p>
                                    <p class="rate-txt2">年化</p>
                                </div>
                            </div>
                            <div class="mod-totle-r">
                                <div class="mod-totle-hd">融资金额</div>
                                <div class="mod-totle-bd">
                                    <p><span class="total-money"><%=tb.getTarget()%></span>万元</p>
                                </div>
                            </div>
                            <div class="mod-totle-r invest-limit-c">
                                <div class="mod-totle-hd">投资期限</div>
                                <div class="mod-totle-bd">
                                    <p>
                                            
                                                <span class="total-time"><%=tb.getTime()%></span>
天                                            
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="section-date">
                            <ul class="cf">
                                <li>
                                    计息方式：                                        <span><%=tb.getCalculationway()%></span>
                                </li>
                                <li class="date">发布日期：<span><%=tb.getDate()%></span></li>
                                <li>还款方式：<span><%=tb.getWaytoback()%></span></li>
                                <li class="date">还款日期：<span><%=tb.getEnddate()%></span></li>
                                
                                
                            </ul>
                        </div>
                            <div class="section-date">
                                <span>申购说明：</span>
                                <span><%=tb.getDescription()%></span>
                            </div>
                      
                    </div>
                </div>
            </div>
            <div class="pro-subcont2">
                <div class="pro-tab">
                    <ul class="pro-nav-tabs cf">
                        <li class="pro-tab-item active">
                            <a href="javascript:void(0)" style="color:black">项目简介</a>
                        </li>
                        <li class="pro-tab-item">
                            <a href="javascript:void(0)" style="color:black">担保情况</a>

                        </li>
                        <li class="pro-tab-item">
                            <a href="javascript:void(0)" style="color:black">投资记录</a>
                        </li>
                    </ul>
                    <div class="pro-tab-content">
                        <div class="pro-tab-pane active">
                    
                            <ul class="pro-tab-intro">
                            
                                <li class="pro-tab-pane-item cf">
                                
                                <div id="intro">
<h2 class="mceNonEditable">● 项目简介</h2>
<div>
<p><strong style="color:black">1、融资项目简介 ：</strong></p>
<p style="color:black">融资人的公司成立于2010年，是一家专业的空间设计策划机构，核心队伍是由一批敬业、创新、务实的优秀设计师组成。公司以严谨的管理、高效的作风和顶尖的作品质量著称。本次借款400万，用作偿还银行一笔到期贷款。以便银行下笔贷款的及时发放。本单为银行过桥业务，流程规范。</p>
<p><strong style="color:black">2、收益说明：</strong></p>
<p style="color:black">融资总额400万，年化收益14%。融资期限7天。</p>
</div>
</div>
<div id="zjyt">
<h2 class="mceNonEditable">● 资金用途</h2>
<div>偿还银行贷款。</div>
</div>

</li>
                            </ul>
                        </div>
                        <div class="pro-tab-pane">
                            <ul class="pro-tab-intro">
                                <li class="pro-tab-pane-item cf"><div id="hkly">
<h2 class="mceNonEditable">● 还款来源</h2>
<div>银行贷款。</div>
</div>
<div id="measure">
<h2 class="mceNonEditable">● 保障措施</h2>
<div>
<p><strong style="color:black">1、融资主体担保措施：</strong></p>
<p><span style="font-size: 10px;color:black">(1)融资人做为借款主体，签署借款合同，借款借据。</span></p>
<p style="color:black">(2)融资人的公司作连带责任保证，签署保证合同；</p>
<p style="color:black">(3)融资人提供名下位于天河区一套价值696万房产作协议抵押给我司，签署抵押合同；</p>
<p style="color:black">(4)收取融资人身份证原件，银行卡原件及U盾、密码。</p>
</div>
</div>
<div id="dbfsm">
<h2 class="mceNonEditable">● 担保方说明</h2>
<div>
<p><strong style="color:black">1、第三方担保说明：</strong></p>
<p style="color:black">担保机构为广东纳斯达，成立于2008年12月，注册资本金人民币2亿元，是经广东省金融办批准取得经营许可证的大型专业公司，许可证号为：粤8800116。与工商银行广东省分行、建设银行广东省分行、国家开发银行广东省分行、中国银行广东省分行、民生银行广州分行、广发银行广州分行以及上述银行所属支行金融机构建立了战略合作关系，目前授信额度为10亿元。</p>
</div>
</div></li>
                            </ul>
                        </div>
                        <div class="pro-tab-pane">
                            <div class="pro-tab-record">
                                <div class="pro-record-box">
                                    <table class="table m-t30">
                                        <thead>
                                            <tr>
                                                <th>序号</th>
                                                <th>投资人</th>
                                                <th>债权人</th>
                                                <th>投资金额</th>
                                                <th>申购时间</th>
                                                <th>投资方式</th>
                                            </tr>
                                        </thead>
                                        <tbody id="record_panel" class="" style="position: relative;"><tr><td>831</td><td>谢先生</td><td>谢先生</td><td>3,446.00元</td><td>2015-08-21 13:18:06</td><td>APP手动</td></tr><tr><td>830</td><td>许先生</td><td>许先生</td><td>100.00元</td><td>2015-08-21 13:15:48</td><td>APP手动</td></tr><tr><td>829</td><td>陈先生</td><td>陈先生</td><td>100.00元</td><td>2015-08-21 13:11:49</td><td>PC手动</td></tr><tr><td>828</td><td>徐先生</td><td>徐先生</td><td>100.00元</td><td>2015-08-21 13:11:32</td><td>PC手动</td></tr><tr><td>827</td><td>黄先生</td><td>黄先生</td><td>100.00元</td><td>2015-08-21 13:11:32</td><td>APP手动</td></tr><tr><td>826</td><td>刘女士</td><td>刘女士</td><td>1,000.00元</td><td>2015-08-21 13:09:19</td><td>APP手动</td></tr></tbody>
                                    </table>
                                </div>
                                <div id="recordPagi" class="pp-pagination-wrap"><div class="pp-pagination"><div class="page-info">第1页/共139页</div><ul class="pagination"><li class="disable"><u class="u-pp-2-0"></u>首页</li><li class="disable"><u class="u-pp-2-0"></u>上一页</li><li class="cur">1</li><li onclick="loadInvestRecords(2)">2</li><li onclick="loadInvestRecords(3)">3</li><li onclick="loadInvestRecords(4)">4</li><li onclick="loadInvestRecords(5)">5</li><li onclick="loadInvestRecords(6)">6</li><li class="disable">...</li><li onclick="loadInvestRecords(2)">下一页<u class="u-pp-3-0"></u></li><li onclick="loadInvestRecords(139)" class="">尾页<u class="u-pp-3-0"></u></li></ul></div></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="pro-sidebar">
            <!-- status2 start -->
                <div id="pro-subside1-finished" class="pro-subside1 pro-subside1-finished">
                    <div class="pro-subside1-cont">
                        <div class="p-lr10">
                            <div><span>投资进度：</span><span class="fr" style="color:#99999B">50.08%</span>
                                
                            </div>
                            <div class="gy_treasur_bg1 fl">
                                    <div class="gy_treasur_bg2" style="width:50.08%;">
                                        
                                    </div>
                                </div><br>
                            <div class="progress-box"><div class="progress-ing" style="width: 86.06%"></div></div>
                            <div style="padding:10px 0;"><span style="color:#99999B">融资金额</span><span class="fr">499,181,00元</span></div>
                            <div style="margin-bottom:10px;">
                                可投余额
                                <div style="padding:3px 0;">
                                    <label ><input name="Fruit" type="radio" value="" /><span style="color:#99999B;">监管账户</span> </label>
                                    <span  class="fr"><%=UserDao.getProperty(tb.getUsername()) %>元<a href="pay.jsp" style="background:#46BBF1;color:#FFFFFF;padding:2px;">充值</a></span>
                                </div>
                               
                            </div>
                            <div style="border-top:1px solid #D5D5D5;padding-top:5px;">
                                监管账户投资：
                                <div>
                                    <form action="servlet/fruit" method="post" id="ffoo">
                                    <label><input name="Fruit" type="text" value=""  style="width:168px; height:40px; background:#FFF;border-radius: 3px; color:#98999B;position: relative;text-indent: 10px;"/><
                                    <input type="text" value="元" readonly style="width:15px; height:40px; background:#FFF;border-radius: 3px; color:#98999B;position: absolute;left:180px;border-left:none;border-right:none; "/>
                                    </label></form>
                                  
                                </div>                           
                            </div>
                            <% int tto=100*Integer.parseInt(tb.getRate());%>
                            <div style="padding:10px 0;">每投资1万元收益<span style="color:red;"><%=tto %>元(年)</span></div>

                        </div>
                    
                        <a href="javascript:document.getElementById('ffoo').submit();"><div class="btn btn-invest">立即投资</div></a>
                    </div>
                    <div style="background:#F5F5F5;line-height:40px;">
                        <img src="images/xiaoptixing.png" style="margin-top:8px;margin-left:5px;"> 小p提醒：投资有风险，我们有保障<a href="" style="color:#46B9F0">[详情]</a>
                    </div>
                </div>
            <!-- status2 end -->
            <div class="pro-subside2">
                <div class="agreement">
                    <a href="">
                    <img src="images/fanbenxieyi.png" style="margin-top:3px;margin-right:5px;">
                    <span>查看协议范本</span>
                    <span class="fr">></span>
                    </a>
                </div>
                <!--小贷公司-->
           <div class="mod-prove"><h3>项目证明</h3><div class="mod-prove-bd" style="width: 236px; height: 100px; overflow: hidden;"><ul style="position: relative; left: 0px; width: 100%;"><li class="cf" style="float: left; width: 236px;"><div class="mod-prove-sub"><h4>身份证</h4><a class="fancybox-thumbs" data-fancybox-group="gallery" href="/Finance/upload/<%=dm.getIdcardfile() %>" title="身份证"><img src="/Finance/upload/<%=dm.getIdcardfile() %>" alt="身份证"></a></div><div class="mod-prove-sub"><h4>房产证</h4><a class="fancybox-thumbs" data-fancybox-group="gallery" href="/Finance/upload/<%=dm.getHousefile() %>" title="房产证"><img src="/Finance/upload/<%=dm.getHousefile() %>" alt="房产证"></a></div></li></ul></div></div><div class="mod-prove"><h3>担保证明</h3><div class="mod-prove-bd" style="width: 236px; height: 100px; overflow: hidden;"><ul style="position: relative; left: 0px; width: 100%;"><li class="cf" style="float: left; width: 236px;"><div class="mod-prove-sub"><h4>担保函</h4><a class="fancybox-thumbs" data-fancybox-group="gallery" href="https://ppmoneyimg.b0.upaiyun.com/TinyMCE/xulu400/担保函.jpg" title="担保函"><img src="https://ppmoneyimg.b0.upaiyun.com/TinyMCE/xulu400/担保函.jpg!121x76" alt="担保函"></a></div></li></ul></div></div></div>
        </div>
    </div>
</div>
<script type="text/javascript" src="js/detail.js"></script>

</body>
</html>
