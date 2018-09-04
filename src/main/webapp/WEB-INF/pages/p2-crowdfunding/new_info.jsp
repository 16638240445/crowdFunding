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
    <title></title>
</head>
<body>
<!--上部导航栏开始-->
<!-- 头部 -->
<jsp:include page="frontHead.jsp"></jsp:include>
<!-- 头部 -->
<!--上不导航栏结束-->
<!--中间核心-->
<div class="product">
    <!--头上表格-->
    <div class="product-table">
        <div class="product-left">
            <table class="table table-bordered">
                <tr class="text-center">
					<td class="title-td"><a href="<%=basePath %>publish/front/newProduct.action">基本信息</a></td>
                    <td class="active title-td"><a href="<%=basePath %>publish/front/newInfo.action">项目信息</a></td>
                    <td class="title-td"><a href="<%=basePath %>publish/front/newDetail.action">详细描述</a></td>
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
                <h4>创建你的项目信息</h4>
            </div>
            <div class="btn-save">
                <button class="btn btn-default" onClick="saveDraft()">保存草稿</button>
            </div>

        </div>
        <div class="clear"></div>
        <hr>
        <!--表单-->
        <form id="projectinfoForm" enctype="multipart/form-data" >
            <div class="my-form">
                 <div class="product-info-input">
                    <b>设置封面：</b>
                    <input type="file" id="psFile" name="photo">
                </div> 
                <div class="product-info-input"><b>项目标题：</b><input class="text" type="text" placeholder="给自己的项目起个漂亮的名字吧" id="psName" name="psName"></div>
                <div class="product-info-input"><b>筹款目的：</b><div class="text-area"><textarea rows="2" placeholder="一句话介绍一下你的项目吧" id="psGoal" name="psGoal"></textarea></div></div>
                 <div class="product-info-select">
                 <!-- <input type="hidden" name="psAddress"> -->
                    <div class="product-info-text"><b>项目地点：</b></div>
                    <div class="product-info-select1">
                        <select class="info-select1" id="province" name="province" onchange="getCity(this.value)">
                            <option>请选择</option>
                        </select>
                    </div>
                    <div class="product-info-select2">
                        <select class="info-select2" id="city" name="city" >
                            <option>请选择</option>
                        </select>
                    </div>
                </div> 

                <div class="product-info-input"><b>筹资金额：</b><input class="text" type="text" placeholder="输入你需要的金额，最少500元" id="psMoney" name="psMoney">元</div>
                <div class="product-info-input"><b>筹资天数：</b><input class="text" type="text" placeholder="" id="psDays" name="psDays">天</div>
            </div>
        </form>
    </div>
</div>
<!--底部开始-->
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
<script type="text/javascript" src="<%=basePath %>js/project/address.js"></script>
	<script type="text/javascript">
		function saveDraft(){
			var psAddress =$('#province').val()+"#"+$('#city').val();
			var form = new FormData(document.getElementById("projectinfoForm"))	
			form.append("psAddress",psAddress);
			//var psFile = $('#psFile').val();
			//var psName = $('#psName').val();
			//var psGoal = $('#psGoal').val();
			//var psAddress =$('#province').val()+"#"+$('#city').val();  
			//var psMoney = $('#psMoney').val();
			//var psDays = $('#psDays').val();
			$.ajax({
				url:"${pageContext.request.contextPath}/publish/putInNewInfo.action",
				method:"post",
				dataType:"json",
				data:form,
				//data:{"psFile":psFile,"psName":psName,"psGoal":psGoal,"psAddress":psAddress,"psMoney":psMoney,"psDays":psDays},
				processData:false,
	            contentType:false,
				success: function(data){
					alert("====="+data.msg);
				},
				error: function() {
					alert("*****保存失败" );
				}
			});
			  //get()//此处为上传文件的进度条
		}
	</script>
</html>