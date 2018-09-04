<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<%=basePath %>css/bootstrap.min.css" type="text/css"/>
    <link href="<%=basePath %>css/reg.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="<%=basePath %>css/base.css" type="text/css"/>
    <link rel="stylesheet" href="<%=basePath %>css/headbott.css" type="text/css"/>
    <link rel="stylesheet" href="<%=basePath %>css/index.css" type="text/css"/>
    <link rel="stylesheet" href="<%=basePath %>css/ly-list.css" type="text/css"/>
    <link rel="stylesheet" href="<%=basePath %>css/reg.css" type="text/css"/>
    <link rel="stylesheet" href="<%=basePath %>css/detail.css" type="text/css"/>
    <title>Title</title>
</head>
<body>
<!-- 头部 -->
<jsp:include page="frontHead.jsp"></jsp:include>
<!-- 头部 -->
<!--中间-->
<div class="product">
    <!--头上表格-->
    <div class="product-table">
        <div class="product-left">
            <table class="table table-bordered">
                <tr class="text-center">
					<td class="title-td"><a href="<%=basePath %>publish/front/newProduct.action">基本信息</a></td>
                    <td class="title-td"><a href="<%=basePath %>publish/front/newInfo.action">项目信息</a></td>
                    <td class="active title-td"><a href="<%=basePath %>publish/front/newDetail.action">详细描述</a></td>
                    <td class="title-td"><a href="<%=basePath %>publish/front/newBack.action">回报设置</a></td>
                </tr>
            </table>
        </div>
        <div class="product-right">
            <table class="table table-bordered">
                <tr class="text-center">
                    <td class="title-td">预览</td>
                </tr>

            </table>

        </div>
    </div>
    <!--下部foem表单-->
    <div class="product-form">
        <!--上标题-->
        <div class="product-title">
            <div class="my-h4">
                <h4>描述你的项目详情</h4>
            </div>
            <div class="btn-save">
                <button class="btn btn-default" onClick="saveDraft()">保存草稿</button>
            </div>

        </div>
        <div class="clear"></div>
        <hr>
        <!--表单-->
        <!--宣传视频-->
        <div>
            <form>
                <div class="detail"><b>宣传视频：</b><input type="text" class="detail-input" placeholder="填写视频在线播放地址" id="psVideo"></div>
            </form>
        </div>
        <div class="clear"></div>
        <hr>
        <!--编辑信息表单-->
        <form action="#">
            <div class="my-form">
                <div class="detail"><b>项目故事：</b><div><textarea rows="2" placeholder="一句话介绍一下你的项目吧" id="psStory"></textarea></div></div>
                <div class="detail"><b>更多支持：</b><div><textarea rows="2" placeholder="一句话介绍一下你的项目吧" id="psSupport"></textarea></div></div>
                <div class="detail"><b>提供回报：</b><div><textarea rows="2" placeholder="一句话介绍一下你的项目吧" id="psRepay"></textarea></div></div>
                <div class="detail"><b>关于我：</b><div><textarea rows="2" placeholder="一句话介绍一下你的项目吧" id="psAboutme"></textarea></div></div>
            </div>
        </form>
    </div>
</div>
<!--下部-->
<div id="bottom">
    <div class="bottom-ggt"><a href=""><img src="<%=basePath %>images/bottbom_68.jpg" alt=""/></a></div>
    <div class="zc-yqlink">
        <ul>
            <li><a href="">阿里巴巴集团</a></li>
            <li><a href="">淘宝网</a></li>
            <li><a href="">天猫</a></li>
            <li><a href="">聚划算</a></li>
            <li><a href="">全球速卖通</a></li>
            <li><a href="">阿里巴巴国际交易市场</a></li>
            <li><a href="">1688</a></li>
            <li><a href="">阿里妈妈</a></li>
            <li><a href="">阿里旅行</a></li>
            <li><a href="">阿里云计算</a></li>
            <li><a href="">阿里巴巴集团</a></li>
            <li><a href="">淘宝网</a></li>
            <li><a href="">天猫</a></li>
            <li><a href="">聚划算</a></li>
            <li><a href="">全球速卖通</a></li>
            <li><a href="">阿里巴巴国际交易市场</a></li>
            <li><a href="">1688</a></li>
            <li><a href="">阿里妈妈</a></li>
            <li><a href="">阿里云计算</a></li>
        </ul>
    </div>
    <div class="footer-bd">

        <a href=" ">关于淘宝</a>
        <a href=" ">合作伙伴</a>
        <a href=" ">营销中心</a>
        <a href=" ">廉正举报</a>
        <a href=" ">联系客服</a>
        <a href=" ">开放平台</a>
        <a href=" ">诚征英才</a>
        <a href=" ">联系我们</a>
        <a href=" ">网站地图</a>
        <a href=" ">法律声明</a>　　　
        <em>© 2003-2015 Taobao.com 版权所有</em><br>

        <br>
        <span>网络文化经营许可证：<a href=" ">浙网文[2013]0268-027号</a></span>
        <b>|</b>
        <span data-spm-protocol="i">增值电信业务经营许可证：<a href="">浙B2-20080224-1</a></span>
        <b>|</b>
        <span>信息网络传播视听节目许可证：1109364号</span>
        <b>|</b>
        <span>举报电话:0571-81683755</span>
    </div>
</div>
</body>
<script type="text/javascript" src="<%=basePath %>js/jquery.min.js" ></script>
	<script type="text/javascript">
		function saveDraft(){
			var psVideo = $('#psVideo').val();
			var psStory = $('#psStory').val();
			var psSupport = $('#psSupport').val();
			var psRepay = $('#psRepay').val();
			var psAboutme = $('#psAboutme').val();
			$.ajax({
				url:"${pageContext.request.contextPath}/publish/putInNewDetail.action",
				method:"post",
				dataType:"json",
				data:{"psVideo":psVideo,"psStory":psStory,"psSupport":psSupport,"psRepay":psRepay,"psAboutme":psAboutme},
				success: function(data){
					alert("====="+data.msg);
				},
				error: function() {
					alert("*****保存失败" );
				}
			})
		}
	</script>
</html>