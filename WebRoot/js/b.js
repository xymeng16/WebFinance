/*! PPmoney-v4.01 2015-08-21 10:55:14 */function PPLoading(a){return a?void $(a).addClass("PPLoading").append('<div class="g-loading-wrap"><div class="g-loading"></div></div>').css("position","relative"):void $(".PPLoading").append('<div class="g-loading-wrap"><div class="g-loading"></div></div>').css("position","relative")}function hideLoading(a){$(a||".PPLoading").removeClass("PPLoading").find(".g-loading-wrap").remove()}function formatDateTime(a,b){"string"==typeof a&&(a=new Date(parseInt(a.replace("/Date(","").replace(")/",""),10))),(null==b||void 0==b)&&(b="yyyy-MM-dd hh:mm");var c={"M+":a.getMonth()+1,"d+":a.getDate(),"h+":a.getHours(),"m+":a.getMinutes(),"s+":a.getSeconds(),"q+":Math.floor((a.getMonth()+3)/3),S:a.getMilliseconds()};/(y+)/.test(b)&&(b=b.replace(RegExp.$1,(a.getFullYear()+"").substr(4-RegExp.$1.length)));for(var d in c)new RegExp("("+d+")").test(b)&&(b=b.replace(RegExp.$1,1==RegExp.$1.length?c[d]:("00"+c[d]).substr((""+c[d]).length)));return b}function formatNumber(a,b){if(b=$.extend({},{decimalSeparator:".",thousandsSeparator:",",decimalPlaces:0,round:!1,prefix:"",suffix:"",defaulValue:0},b),"number"==typeof a&&isFinite(a)||(a*=1),"number"==typeof a&&isFinite(a)){var c=0>a;a=Math.abs(a);var d,e=a+"",f=b.decimalSeparator?b.decimalSeparator:".";if("number"==typeof b.decimalPlaces&&isFinite(b.decimalPlaces)){var g,h=b.decimalPlaces;if(b.round?(g=Math.pow(10,h),e=Math.round(a*g)/g+""):(g=Math.pow(10,h+3),e=Math.floor(Math.round(a*g)/1e3)/(g/1e3)+""),d=e.lastIndexOf("."),h>0)for(0>d?(e+=f,d=e.length-1):"."!==f&&(e=e.replace(".",f));e.length-1-d<h;)e+="0"}if(b.thousandsSeparator){var i=b.thousandsSeparator;d=e.lastIndexOf(f),d=d>-1?d:e.length;for(var j=e.substring(d),k=-1,l=d;l>0;l--)k++,k%3===0&&l!==d&&(!c||l>1)&&(j=i+j),j=e.charAt(l-1)+j;e=j}return e=b.prefix?b.prefix+e:e,e=b.suffix?e+b.suffix:e,(c?"-":"")+e}return b.defaulValue}function formatCurrency(a,b,c){return"number"!=typeof c&&(c=2),b=$.extend({},{decimalSeparator:".",thousandsSeparator:",",decimalPlaces:c,round:!1,prefix:"",suffix:"",defaulValue:0},b),formatNumber(a,b)}function getQueryString(a){var b=new RegExp("(^|&)"+a+"=([^&]*)(&|$)","i"),c=window.location.search.substr(1).match(b);return null!=c?unescape(c[2]):null}function defaultImg(a){$(a).on({error:function(){$(this).attr("src","http://img.ppmoney.com/v4.01/img/index/prj/default.jpg"),$(this).unbind("error")}})}function dbBtnEnable(){var a=$("#InvestableAmount").text();"0.00"==a&&$("#btnTransOut").addClass("pp-btn-disable").attr("disabled","true").attr("href","javascript:void(0)")}function PPCountDown(a){var b={isDay:!1,type:"",unit:!1,timeout:1e3,from:"",to:"",start:new Date,refresh:function(){},callback:function(){}};this.options=$.extend(b,a),this.flag=!0,this.totalTime=0}function lazyEle(){var a=$(".lazyEle");a.each(function(b){var c=$(this).attr("data-src");if(c){var d=new Image;d.src=c,d.index=b,d.onload=function(){a.eq(this.index).attr("src",c)}}c&&$(this).attr("src",c)}),a.on({error:function(){$(this).attr("src","http://img.ppmoney.com/v4.01/img/index/prj/default.jpg"),$(this).unbind("error")}})}function setCookie(a,b,c,d){var e=null==$.cookie(a)?{}:JSON.parse($.cookie(a)),f=e,g=0;g=(new Date).getTime()+60*b*1e3,!f.value||f.expires-(new Date).getTime()<=0?c(function(b,c){g=0==c?g+108e5:g;var e={value:b,expires:g};$.cookie.json=!0,$.cookie(a,e,{path:"/"}),d&&d(b)}):d&&d(f.value)}function ppSmsTimer(a){function b(a){return c.find(".btn-sms").hide(),c.find(".btn-wait").show().text(--a+"秒后可以重新获取"),0==a?(c.find(".btn-sms").show(),void c.find(".btn-wait").hide()):void setTimeout(function(){b(a)},1e3)}var c=$(a.elem);c.on("click",".btn-sms",function(){/^1\d{10}$/.test($(a.phone).val())||void 0==a.phone?$.ajax({type:"post",url:$(this).attr("data-url"),async:!1,data:{phone:$(a.phone).val(),__RequestVerificationToken:a.token},success:function(a){switch(a.State){case-1:PPmoney.dialog.quickClose({content:"发送失败，号码不正�?!"}),b(120);break;case-3:PPmoney.dialog.quickClose({content:"发送失败，号码不存�?!"});break;case-4:PPmoney.dialog.quickClose({content:a.Message});break;case 1:b(120)}}}):PPmoney.dialog.quickClose({content:"请输入正确的手机�?"})}),c.find(".btn-wait").hide();var d=c.find(".btn-wait").attr("data-wait-timer");""!=d&&d>0&&b(parseInt(d)/1e3)}$(function(){$(window).scroll(function(){$(window).scrollTop()>200?($("#back").css("visibility","visible"),$(".g-nav-wrap").addClass("g-pin").animate({top:0},250),$(".g-logo-wrap").addClass("g-pin-h")):($("#back").css("visibility","hidden"),$(".g-nav-wrap").stop(!0,!0).removeClass("g-pin").animate({top:"-44px"},20),$(".g-logo-wrap").removeClass("g-pin-h"))}),$("#back").click(function(){$("html,body").animate({scrollTop:"0px"},1e3)}),document.body.onmousewheel=function(){$("html,body").is(":animated")&&$("html,body").stop()}});var UserCookie={init:window.navigator.cookieEnabled?!0:!1,setItem:function(a,b,c){if(UserCookie.init){var d=new Date;d.setTime(d.getTime()+c),document.cookie=a+"="+escape(b)+(null==c?"":";expires="+d.toGMTString()+"; path=/;"+(window.location.toString().indexOf(".ppmoney.")>0?"domain=.ppmoney.com":""))}},getItem:function(a){if(UserCookie.init){if(document.cookie.length>0){var b=document.cookie.indexOf(a+"=");if(-1!=b){b=b+a.length+1;var c=document.cookie.indexOf(";",b);return-1==c&&(c=document.cookie.length),unescape(document.cookie.substring(b,c))}}return""}},clear:function(){UserCookie.init&&document.cookie.length>0&&document.cookie.clear()},removeItem:function(a){if(UserCookie.init&&document.cookie.length>0){var b=UserCookie.getItem(a);null!=b&&UserCookie.setItem(a,b,-999)}}},UserLocalStorage={init:window.localStorage?!0:!1,setItem:function(a,b,c){if(UserLocalStorage.init){var d=new Date,e={value:JSON.stringify(b),expires:d.getTime()+c};window.localStorage.setItem(a,JSON.stringify(e))}},getItem:function(a){if(UserLocalStorage.init){var b="",c=JSON.parse(window.localStorage.getItem(a));return null!=c&&(new Date).getTime()<=c.expires&&(b=c.value.replace(/"/g,"")),b}},clear:function(){UserLocalStorage.init&&window.localStorage.clear()},removeItem:function(a){UserLocalStorage.init&&window.localStorage.removeItem(a)}},UserData={userData:null,onlyUseCookie:!0,name:location.hostname,expireTime:2592e6,setItem:function(a,b,c){UserData.onlyUseCookie?UserCookie.init&&(c?UserCookie.setItem(a,b,c):UserCookie.setItem(a,b,UserData.expireTime)):UserLocalStorage.init&&(c?UserLocalStorage.setItem(a,b,c):UserLocalStorage.setItem(a,b,UserData.expireTime))},getItem:function(a){if(UserData.onlyUseCookie){if(UserCookie.init)return UserCookie.getItem(a)}else if(UserLocalStorage.init)return UserLocalStorage.getItem(a)},removeItem:function(a){if(UserData.onlyUseCookie){if(UserCookie.init)return UserCookie.removeItem(a)}else if(UserLocalStorage.init)return UserLocalStorage.removeItem(a)}},UtmRegStorage={set:function(){var a=window.location.search;a.indexOf("?")>-1&&(a=a.substr(1));for(var b=a.split("&"),c=!1,d=0;d<b.length;d++){var e=b[d].split("=");if(!(void 0==e||e.length<2))switch(e[0]){case"utm_source":UserData.setItem("utmSource",e[1]),c=!0;break;case"utm_medium":UserData.setItem("utmMedium",e[1]),c=!0;break;case"utm_term":UserData.setItem("utmTerm",e[1]),c=!0;break;case"utm_content":UserData.setItem("utmContent",e[1]),c=!0;break;case"utm_campaign":UserData.setItem("utmCampaign",e[1]),c=!0}}return c&&UserData.setItem("utmEntranceUrl",window.location.href.toString()),c},get:function(){var a={utmEntranceUrl:UserData.getItem("utmEntranceUrl"),utmSource:UserData.getItem("utmSource"),utmMedium:UserData.getItem("utmMedium"),utmTerm:UserData.getItem("utmTerm"),utmContent:UserData.getItem("utmContent"),utmCampaign:UserData.getItem("utmCampaign")};return a},clear:function(){return UserData.removeItem("utmEntranceUrl"),UserData.removeItem("utmSource"),UserData.removeItem("utmMedium"),UserData.removeItem("utmTerm"),UserData.removeItem("utmContent"),UserData.removeItem("utmCampaign"),!0}};UtmRegStorage.set();var showTotalNum=function(a){var b=void 0==a.toString().split(".")[1]?0:a.toString().split(".")[1].length+1,c=new Array;c=a.toString().split("");var d="";for(i=0;i<c.length;i++)if(","!=c[i])switch(d+=c[i],c.length-i){case 9+b:d+="<span>�?</span>";break;case 5+b:d+="<span>�?</span>";break;case 1:d+='<span class="normal">�?</span>'}return d},numFormat=function(a){function b(a){if(a=a.toString().split(".")[0],a.length<=3)return d=a.concat(c),d+e;var f="";f=","+a.substr(a.length-3,3),c=f.concat(c),b(a.substring(0,a.length-3))}var c="",d="",e=a.toString().split(".")[1];return e=void 0!=e?"."+e:"",b(a),d+e},numFormatUnit=function(a,b,c){var b=b||"�?",c=c||1,d=new Array;d=parseInt(a).toString().split("");var e="";if(2==c){for(d=d.slice(0,d.length-4),i=0;i<d.length;i++)if(","!=d[i])switch(e+=d[i],d.length-i){case 5:e+="<span>�?</span>";break;case 1:e+="<span>�?</span>"}}else for(i=0;i<d.length;i++)if(","!=d[i])switch(e+=d[i],d.length-i){case 9:e+="<span>�?</span>";break;case 5:e+="<span>�?</span>";break;case 1:e+="<span>"+b+"</span>"}return e},numFix=function(a){var b=/([0-9]+\.[0-9]{2})[0-9]*/;return Number(a.toString().replace(b,"$1"))};$(function(){$(".btn-ppcode").click(function(a){a.stopPropagation(),$(this).addClass("b-b-ppcode"),$(".main-ppcode").slideDown(300)}),$(document).click(function(){$(".btn-ppcode").removeClass("b-b-ppcode"),$(".main-ppcode").slideUp(300)}),$(".main-ppcode").click(function(){return!1})});var checkTime=function(a){return a=parseInt(a),10>a&&(a="0"+a),a},newDate=function(a){if(Number(a))return new Date(a);if(a.toString().match(/\//)){var b=a.split(" ")[0].split("/"),c=a.split(" ")[1].split(":");return new Date(b[0],b[1]-1,b[2],c[0],c[1],c[2])}return a},newDateString=function(a){var b=a?new Date(a):new Date;return checkTime(b.getFullYear())+"-"+checkTime(b.getMonth()+1)+"-"+checkTime(b.getDate())+" "+checkTime(b.getHours())+":"+checkTime(b.getMinutes())+":"+checkTime(b.getSeconds())},total_second=function(a){var b=a.split(" ")[1].split(":");return 60*b[0]*60+60*b[1]+parseInt(b[2])};PPCountDown.prototype.start=function(){var a=newDate(this.options.from).getTime()+(new Date).getTime()-this.options.start.getTime(),b=newDate(this.options.to).getTime();if(!(b-a>0&&this.flag))return void this.options.callback();this.options.refresh(this,this.formatSecond((b-a)/1e3));var c=this;setTimeout(function(){c.start()},this.options.timeout)},PPCountDown.prototype.stop=function(){this.flag=!1},PPCountDown.prototype.formatSecond=function(a){this.totalTime=a;var b="milli"==this.options.type?"."+parseInt(10*a%10):"";return this.options.unit?this.options.isDay?checkTime(a/60/60/24)+"<span>�?</span>"+checkTime(a/60/60%24)+"<span>�?</span>"+checkTime(a/60%60)+"<span>�?</span>"+checkTime(a%60)+b+"<span>�?</span>":checkTime(a/60/60)+"<span>�?</span>"+checkTime(a/60%60)+"<span>�?</span>"+checkTime(a%60)+b+"<span>�?</span>":this.options.isDay?checkTime(a/60/60/24)+":"+checkTime(a/60/60%24)+":"+checkTime(a/60%60)+":"+checkTime(a%60)+b:checkTime(a/60/60)+":"+checkTime(a/60%60)+":"+checkTime(a%60)+b},function(a){a.fn.numRolling=function(b){var c={times:1e3,point:0,interval:50,callback:function(a){return a}},b=a.extend(c,b),d=this;if(!Number(b.num))return d.html(b.num);var e=Number(b.num)?b.num:parseFloat(b.num);if(0==e)return d.html(e);b.point=void 0==e.toString().split(".")[1]?0:e.toString().split(".")[1].length;var f=b.times/b.interval,g=e/f,h=0;!function i(){var a=(h+=g).toFixed(b.point);return d.html(b.callback(a)),h>e-g?void d.html(b.callback(parseFloat(e).toFixed(b.point))):void setTimeout(i,b.interval)}()}}(jQuery);var PPmoney=PPmoney||{};PPmoney.config={title:"系统提示",emico:"<u class='u2 u2-30'></u>",corico:"<u class='u2 u2-40'></u>",errico:"<u class='u2 u2-50'></u>",unLogin:"您还没登录呢�?",error:"出错了！",fail:"加载失败，网络不给力�?",success:"哇啦啦啦，投资成�?"},PPmoney.dialog={hoverTips:function(a){var b;a.elem.mouseover(function(){var c=dialog({align:a.align||"bottom",content:a.content||$(this).attr("data-tips"),quickClose:!0});c.show($(this).get(0)),$(this).addClass("artDialog-hover"),b=c}).mouseout(function(){b.close().remove(),$(this).removeClass("artDialog-hover")})},tips:function(a){var b=dialog({align:a.align||"top",width:a.width||"auto",height:a.height||"auto",content:a.content,quickClose:a.quickClose||!1}).show(a.elem.get(0));return b},confirm:function(a){"[object String]"===Object.prototype.toString.call(a)&&(a={content:a});var b=top.dialog({title:a.title||PPmoney.config.title,content:'<div class="ui-dialog-confirm">'+a.content+"</div>",width:a.width||"auto",height:a.height||"auto",ok:a.ok||function(){}});return b.showModal().focus()},show:function(a){var b=dialog({title:a.title||PPmoney.config.title,content:'<div class="ui-dialog-confirm">'+a.content+"</div>",width:a.width||"auto",height:a.height||"auto",ok:a.ok||function(){},cancel:a.cancel||function(){}});return b.show()},showModal:function(a){var b=dialog({title:a.title||PPmoney.config.title,content:'<div class="ui-dialog-confirm">'+a.content+"</div>",width:a.width||"auto",height:a.height||"auto",ok:a.ok||function(){},cancel:a.cancel||function(){}});return b.showModal()},quickClose:function(a){"[object String]"===Object.prototype.toString.call(a)&&(a={content:a});var b=top.dialog({content:'<div class="p-20">'+a.content+"</div>",onclose:a.onclose||function(){}});a.onclose?b.showModal():b.show(),setTimeout(function(){a.callback&&a.callback(),b.close().remove()},a.time||2e3)},iframe:function(a){var b=top.dialog({id:a.id||"",title:a.title||PPmoney.config.title,url:a.url,width:a.width||"auto",height:a.height||"auto",skin:"PPLoading",scroll:a.scroll||!1,onshow:function(){PPLoading()},oniframeload:function(){hideLoading(),"auto"===this.options.height&&this.height(this.iframeNode.contentDocument.body.offsetHeight+20)},onclose:function(){},onremove:function(){}}).showModal();return b}},function(a){a.fn.pptab=function(){a.each(this,function(){var b=a(this).hasClass("z-hover")?"mouseover":"click",c=a(this);a(this).find(">.pp-tab-list li").on(b,function(){"undefined"==typeof a(this).attr("data-ignore")&&(a(this).parent().find(">li").removeClass("on"),a(this).addClass("on"),c.find(">.pp-tab-c").removeClass("on").eq(a(this).index()).addClass("on"))})})}}(jQuery),function(a){a.fn.ppcheck=function(b){var c={},b=a.extend(c,b);a.each(this,function(){var b=a(this).attr("class"),c=a(this).find(">input").get(0),d=a(this).find(">input").eq(0).prop("name");/checked/.test(b)&&(c.checked=!0),/disabled/.test(b)&&(c.disabled=!0),/disabled|readonly/.test(b)||a(this).on("click",function(){c.checked=/checked/.test(a(this).attr("class"))?!1:!0,""!=c.getAttribute("data-ignore")&&a.each(a("input[name="+d+"]").not(c),function(b,c){a(c).prop("checked",!1).parent().removeClass("checked")}),a(this).toggleClass("checked")})})}}(jQuery),function(a){a.fn.ppselect=function(b){function c(b,c){b.find(".dropdown-toggle>span").text(a(c).text()),b.find("input[type=hidden]").val(a(c).attr("data-value"))}function d(a){f.find(".pp-dropdown-menu").height(a)}var e={callback:function(){}},b=a.extend(e,b),f=this,g=f.find(".dropdown-toggle>span").text(),h=[],i=f.attr("class"),j=f.find(">input").get(0);return/disabled/.test(i)&&(j.disabled=!0),/disabled|readonly/.test(i)?void 0:(f.find(".dropdown-toggle").unbind("click").on("click",function(b){b.stopPropagation(),/disabled|readonly/.test(f.attr("class"))||(a(".pp-select-box").css("z-index","auto"),a(f).css("z-index","99"),a(".pp-dropdown-menu").slideUp(),f.find(".pp-dropdown-menu").slideDown())}),f.find(".pp-dropdown-menu>li").unbind("click").on({click:function(d){if(d.stopPropagation(),a(".pp-select-box").css("z-index","auto"),a(this).parent().slideUp(),c(f,this),a(this).text()!=g&&(b.callback&&b.callback(),h=b.auto&&b.auto.split(","),b.auto&&h.length>0)){for(var e in h)a(h[e]+" .dropdown-toggle>span").text(g);a(".pp-dropdown-menu").slideUp(),a(h[0]).find(".pp-dropdown-menu").slideDown()}}}),f.find(".pp-dropdown-menu>li").each(function(b,d){return"selected"==a(d).attr("data-selected")?void c(f,d):void 0}),a(document).on("click",function(){a(".pp-dropdown-menu").slideUp(),a(".pp-select-box").css("z-index","auto")}),b.height&&d(b.height),this)}}(jQuery),$(function(){$(".pp-tab").pptab(),$(".pp-pagination-wrap .item-anti").each(function(){$(this).html($(this).text())})}),PPmoney.maskLayer={show:function(){$('<div class="g-mask-layer gray"></div>').appendTo($("body")).height($("html,body").height()).show()},hide:function(){$(".g-mask-layer").hide().remove()}};var funPlaceholder=function(a,b){var c="";if(a&&!("placeholder"in document.createElement("input"))&&(c=a.getAttribute("placeholder"))){var d=document.createElement("label");d.className=b,d.innerHTML=c,d.onclick=function(){this.innerHTML="",a.focus()},a.parentElement.insertBefore(d,a),a.onfocus=function(){d.innerHTML=""},a.onblur=function(){""===this.value&&(d.innerHTML=c)}}};!function(a){a.fn.checkPwdLevel=function(b){var c=this;c.opt={levle:1},a.extend(c.opt,b);var d=c.opt.ele&&a(c.opt.ele).val();c.AuthPasswd=function(a){return a.length>=8?/[a-zA-Z]+/.test(a)&&/\W+/.test(a)?3:/[a-zA-Z]+/.test(a)||/\W+/.test(a)?2:1:0};var e=d?c.AuthPasswd(d):c.opt.level;switch(c.opt.returnEle&&a(c.opt.returnEle).val(e),e){case 1:c.find(".pp-pw-state").eq(0).addClass("em").siblings(".pp-pw-state").removeClass("em");break;case 2:c.find(".pp-pw-state").eq(2).removeClass("em").siblings(".pp-pw-state").addClass("em");break;case 3:c.find(".pp-pw-state").addClass("em");break;default:c.find(".pp-pw-state").removeClass("em")}return e}}(jQuery),function(a){a.fn.ppdateSearch=function(b){var c=this;c.opt={clickBind:[{ele:c.find("#today"),begin:0,end:0},{ele:c.find("#latestMonth"),begin:-1,end:0},{ele:c.find("#threeMonth"),begin:-3,end:0}],search:c.find("#search"),beginInput:c.find("#begin"),endInput:c.find("#end")},a.extend(c.opt,b),c.fillDate=function(a,b){c.opt.beginInput.val(formatDateTime(a,"yyyy-MM-dd")),c.opt.endInput.val(formatDateTime(b,"yyyy-MM-dd"))},c.opt.search.click(function(){c.opt.callback&&c.opt.callback()}),a.each(c.opt.clickBind,function(a,b){b.ele.click(function(){var b=new Date,d=new Date(b.setMonth(b.getMonth()+c.opt.clickBind[a].end)),e=new Date(b.setMonth(b.getMonth()+c.opt.clickBind[a].begin));c.fillDate(e,d),c.opt.callback&&c.opt.callback()})})}}(jQuery);