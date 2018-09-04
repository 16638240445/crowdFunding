/**
 * ajax获取省市级联菜单
 */

// 由于jsp中${pageContext.request.contextPath}在js中无法识别，所以使用js来获取访问的路径
function getRealPath(){
	//获取当前网址，如： http://localhost:8083/myproj/view/ahha.jsp
	var curWwwPath=window.document.location.href;
	//获取主机地址之后的目录，如： myproj/view/ahha.jsp
	var pathName=window.document.location.pathname;
	var pos=curWwwPath.indexOf(pathName);
	//获取主机地址，如： http://localhost:8080
	var localhostPaht=curWwwPath.substring(0,pos);
	//获取带"/"的项目名，如：/ahha
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	 
	//得到了 服务器名称和项目名称
	var realPath=localhostPaht+projectName;
	
	return realPath;
}

// 声明全局变量pageContext
var pageContext = getRealPath();

// 初始化省市级联菜单
$(function(){
	getProvince();
})

// 获取省份的ajax请求
function getProvince() {
	var parentId = $("select[name=province]").val();
	$.ajax({
				url : pageContext + "/publish/findProvince.action",
				method : "post",
				dataType : "json",
				async : true,
				success : function(data) {
					var provinceList = data.provinces;
					for (var i = 0; i < provinceList.length; i++) {
						// 浏览器控制台打印
						console.log(provinceList[i].regionId + "、"
								+ provinceList[i].regionName);
						var option = "<option value=\"" + provinceList[i].regionId
								+ "\"";
						option += ">" + provinceList[i].regionName + "</option>"; // 动态添加数据
						$("select[name=province]").append(option);
					}
				},
				error : function() {
					alert("对不起，省份出错啦！");
				}
			});
}
// 获取市的ajax请求
function getCity(id) {
	$.ajax({
		url : pageContext + "/publish/findProvinceCity.action",
		data : {
			"id" : id
		},
		method : "post",
		dataType : "json",
		async : true,
		success : function(data) {
			$("select[name='city']").empty();
			var cityList = data.cities;
			for (var i = 0; i < cityList.length; i++) {
				console.log(cityList[i].regionId + "、" + cityList[i].regionName);
				var option = "<option value=\"" + cityList[i].regionId + "\"";
				option += ">" + cityList[i].regionName + "</option>"; // 动态添加数据
				$("select[name=city]").append(option);
			}
		},
		error : function() {
			alert("对不起，城市出错啦！");
		}
	});
}