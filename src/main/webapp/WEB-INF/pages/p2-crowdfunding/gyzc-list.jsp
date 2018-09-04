<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="Keywords" content="关键词,关键词">
    <meta name="description" content="">
    <title></title>
    <script type="text/javascript" src="<%=basePath %>js/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="<%=basePath %>js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="<%=basePath %>js/select-widget-min.js"></script>
    <link rel="stylesheet" href="<%=basePath %>css/drop-down.css" />
    <link rel="stylesheet" href="<%=basePath %>css/base.css" type="text/css"/>
    <link rel="stylesheet" href="<%=basePath %>css/headbott.css" type="text/css"/>
    <link rel="stylesheet" href="<%=basePath %>css/product-list.css" type="text/css"/>
</head>

<body>
<!-- 头部 -->
<jsp:include page="frontHead.jsp"></jsp:include>
<!-- 头部 -->

<div class="product-con">
<h1 class="product-con_tit">公益众筹</h1>
    <div class="product-con_nav">
        <a class="lnav_bg" href=""><i><img src="<%=basePath %>images/ii_04.png" alt=""/></i>全部</a>
        <a href=""><i><img src="<%=basePath %>images/ii_06.png" alt=""/></i>教育助学</a>
        <a href=""><i><img src="<%=basePath %>images/ii_08.png" alt=""/></i>爱心环保</a>
        <a href=""><i><img src="<%=basePath %>images/ii_10.png" alt=""/></i>扶贫助困</a>
        <a href=""><i><img src="<%=basePath %>images/ii_12.png" alt=""/></i>公益创业</a>
        <a href=""><i><img src="<%=basePath %>images/ii_14.png" alt=""/></i>公益活动</a>
           <div class="select-li">
               <span>状态:</span>
               <select name="drop2" class="ui-select">
               <option value="">全部</option>
               <option value="1">全部2</option>
               <option value="2">全部4</option>
               <option value="3">全部5</option>
           </select>
           </div>
        <div class="select-li2">
               <span>排序:</span>
               <select name="drop2" class="ui-select">
               <option value="">全部</option>
               <option value="1">全部2</option>
               <option value="2">全部4</option>
               <option value="3">全部5</option>
           </select>
           </div>

    </div>

    <div class="product-list-l">
        <ul>
            <li class="zcz">
                <div class="product-list-lpic">
                    <a href="product-detail.html"><img src="<%=basePath %>images/prr-dduu_27.jpg" alt=""/></a>
                    <div class="product_one">制作中</div>
                </div>
                <p><a href="">NGDS新游戏手柄 手机一秒变游戏机</a></p>
                <div class="product-list-lmin">
                    <dl>
                        <dt>133.3%</dt>
                        <dd>达成率</dd>
                    </dl><dl>
                    <dt>88888.3</dt>
                    <dd>已筹金额</dd>
                </dl><dl>
                    <dt>8515</dt>
                    <dd>支持人数</dd>
                </dl>
                </div>
            </li>
            <li class="yrz">
                <div class="product-list-lpic">
                    <a href=""><img src="<%=basePath %>images/prr-dduu_27.jpg" alt=""/></a>
                    <div class="product_one">预热中</div>
                </div>
                <p><a href="">NGDS新游戏手柄 手机一秒变游戏机</a></p>
                <div class="product-list-lmin">
                    <dl>
                        <dt>133.3%</dt>
                        <dd>达成率</dd>
                    </dl><dl>
                    <dt>88888.3</dt>
                    <dd>已筹金额</dd>
                </dl><dl>
                    <dt>8515</dt>
                    <dd>支持人数</dd>
                </dl>
                </div>
            </li>

            <li class="cz">
                <div class="product-list-lpic">
                    <a href=""><img src="<%=basePath %>images/prr-dduu_27.jpg" alt=""/></a>
                    <div class="product_one">项目成功</div>
                </div>
                <p><a href="">NGDS新游戏手柄 手机一秒变游戏机</a></p>
                <div class="product-list-lmin">
                    <dl>
                        <dt>133.3%</dt>
                        <dd>达成率</dd>
                    </dl><dl>
                    <dt>88888.3</dt>
                    <dd>已筹金额</dd>
                </dl><dl>
                    <dt>8515</dt>
                    <dd>支持人数</dd>
                </dl>
                </div>
            </li>
            <li class="zcz">
                <div class="product-list-lpic">
                    <a href=""><img src="<%=basePath %>images/prr-dduu_27.jpg" alt=""/></a>
                    <div class="product_one">筹款中</div>
                </div>
                <p><a href="">NGDS新游戏手柄 手机一秒变游戏机</a></p>
                <div class="product-list-lmin">
                    <dl>
                        <dt>133.3%</dt>
                        <dd>达成率</dd>
                    </dl><dl>
                    <dt>88888.3</dt>
                    <dd>已筹金额</dd>
                </dl><dl>
                    <dt>8515</dt>
                    <dd>支持人数</dd>
                </dl>
                </div>
            </li><li class="cz">
                <div class="product-list-lpic">
                    <a href=""><img src="<%=basePath %>images/prr-dduu_27.jpg" alt=""/></a>
                    <div class="product_one">筹款中</div>
                </div>
                <p><a href="">NGDS新游戏手柄 手机一秒变游戏机</a></p>
                <div class="product-list-lmin">
                    <dl>
                        <dt>133.3%</dt>
                        <dd>达成率</dd>
                    </dl><dl>
                    <dt>88888.3</dt>
                    <dd>已筹金额</dd>
                </dl><dl>
                    <dt>8515</dt>
                    <dd>支持人数</dd>
                </dl>
                </div>
            </li><li class="yrz">
                <div class="product-list-lpic">
                    <a href=""><img src="<%=basePath %>images/prr-dduu_27.jpg" alt=""/></a>
                    <div class="product_one">筹款中</div>
                </div>
                <p><a href="">NGDS新游戏手柄 手机一秒变游戏机</a></p>
                <div class="product-list-lmin">
                    <dl>
                        <dt>133.3%</dt>
                        <dd>达成率</dd>
                    </dl><dl>
                    <dt>88888.3</dt>
                    <dd>已筹金额</dd>
                </dl><dl>
                    <dt>8515</dt>
                    <dd>支持人数</dd>
                </dl>
                </div>
            </li><li class="yrz">
                <div class="product-list-lpic">
                    <a href=""><img src="<%=basePath %>images/prr-dduu_27.jpg" alt=""/></a>
                    <div class="product_one">筹款中</div>
                </div>
                <p><a href="">NGDS新游戏手柄 手机一秒变游戏机</a></p>
                <div class="product-list-lmin">
                    <dl>
                        <dt>133.3%</dt>
                        <dd>达成率</dd>
                    </dl><dl>
                    <dt>88888.3</dt>
                    <dd>已筹金额</dd>
                </dl><dl>
                    <dt>8515</dt>
                    <dd>支持人数</dd>
                </dl>
                </div>
            </li><li class="zcz">
                <div class="product-list-lpic">
                    <a href=""><img src="<%=basePath %>images/prr-dduu_27.jpg" alt=""/></a>
                    <div class="product_one">筹款中</div>
                </div>
                <p><a href="">NGDS新游戏手柄 手机一秒变游戏机</a></p>
                <div class="product-list-lmin">
                    <dl>
                        <dt>133.3%</dt>
                        <dd>达成率</dd>
                    </dl><dl>
                    <dt>88888.3</dt>
                    <dd>已筹金额</dd>
                </dl><dl>
                    <dt>8515</dt>
                    <dd>支持人数</dd>
                </dl>
                </div>
            </li><li class="zcz">
                <div class="product-list-lpic">
                    <a href=""><img src="<%=basePath %>images/prr-dduu_27.jpg" alt=""/></a>
                    <div class="product_one">筹款中</div>
                </div>
                <p><a href="">NGDS新游戏手柄 手机一秒变游戏机</a></p>
                <div class="product-list-lmin">
                    <dl>
                        <dt>133.3%</dt>
                        <dd>达成率</dd>
                    </dl><dl>
                    <dt>88888.3</dt>
                    <dd>已筹金额</dd>
                </dl><dl>
                    <dt>8515</dt>
                    <dd>支持人数</dd>
                </dl>
                </div>
            </li><li class="yrz">
                <div class="product-list-lpic">
                    <a href=""><img src="<%=basePath %>images/prr-dduu_27.jpg" alt=""/></a>
                    <div class="product_one">筹款中</div>
                </div>
                <p><a href="">NGDS新游戏手柄 手机一秒变游戏机</a></p>
                <div class="product-list-lmin">
                    <dl>
                        <dt>133.3%</dt>
                        <dd>达成率</dd>
                    </dl><dl>
                    <dt>88888.3</dt>
                    <dd>已筹金额</dd>
                </dl><dl>
                    <dt>8515</dt>
                    <dd>支持人数</dd>
                </dl>
                </div>
            </li><li class="zcz">
                <div class="product-list-lpic">
                    <a href=""><img src="<%=basePath %>images/prr-dduu_27.jpg" alt=""/></a>
                    <div class="product_one">筹款中</div>
                </div>
                <p><a href="">NGDS新游戏手柄 手机一秒变游戏机</a></p>
                <div class="product-list-lmin">
                    <dl>
                        <dt>133.3%</dt>
                        <dd>达成率</dd>
                    </dl><dl>
                    <dt>88888.3</dt>
                    <dd>已筹金额</dd>
                </dl><dl>
                    <dt>8515</dt>
                    <dd>支持人数</dd>
                </dl>
                </div>
            </li>
            <li class="cz">
                <div class="product-list-lpic">
                    <a href=""><img src="<%=basePath %>images/prr-dduu_27.jpg" alt=""/></a>
                    <div class="product_one">筹款中</div>
                </div>
                <p><a href="">NGDS新游戏手柄 手机一秒变游戏机</a></p>
                <div class="product-list-lmin">
                    <dl>
                        <dt>133.3%</dt>
                        <dd>达成率</dd>
                    </dl><dl>
                    <dt>88888.3</dt>
                    <dd>已筹金额</dd>
                </dl><dl>
                    <dt>8515</dt>
                    <dd>支持人数</dd>
                </dl>
                </div>
            </li>
        </ul>
    </div>
<div class="product-ym">

        <a class="product-ym_bg" href="">1</a>
        <a href="">2</a>
        <span>...</span>
        <a href="">43</a>
        <a href="">44</a>
        <a href="">45</a>
    <a class="product-ym_xyy" href="">下一页&gt;</a>
    </ul>
</div>
</div>
<div id="bottom">
    <div class="bot-con1">
        <ul>
            <li class="bot-con1-li1">我们已经做到 </li>
            <li>单项支持人数<span class="inde-span1"></span></li>
            <li>单项筹款金额<span class="inde-span2"></span></li>
            <li>累计筹款金额<span class="inde-span3"></span></li>
        </ul>
    </div>
    <div class="bot-con1 bot-con2">
        <ul>
            <li class="bot-con1-li1">发起项目流程 </li>
            <li><span class="inde-span4"></span>发起人创建项目</li>
            <li><span class="inde-span5"></span>项目获得支持</li>
            <li><span class="inde-span6"></span>发起人发放回报</li>
            <li><span class="inde-span7"></span>用户收到回报</li>
        </ul>
    </div>
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
</html>