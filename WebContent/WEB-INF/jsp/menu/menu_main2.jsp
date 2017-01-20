<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<%@ include file="/WEB-INF/jsp/_meta.jsp"%>
<title></title>
</head>
<body ng-app="menu" ng-controller="menuCtrl">
	<nav class="breadcrumb" ng-model="template">
		<a href="javascript:;"
			ng-click=""
			class="btn btn-success radius"> Menu Category</a> <a
			href="javascript:;" onclick="openWind('Menu','menuList.htm')"
			class="btn btn-success radius"> Menu </a> <a
			href="javascript:;" onclick="openWind('MenuItem Group','menuItemGroupMain.htm')"
			class="btn btn-success radius"> MenuItem Group </a> <a
			class="btn btn-success radius r"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="Reload"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div ng-include="template.url">
	<table class="table">
		<tr>
			<td width="100" class="va-t">
				<ul class="menu radius box-shadow">
						<li ng-repeat="menuCategory in menuCategoryList">
						<a href="#" class="dropDown_A">{{menuCategory.categoryName}}<input type="checkbox" title="OnLine">
						<i class="arrow Hui-iconfont">&#xe6d7;</i>
						</a> 
							<!-- 
							<ul class="menu">
								<li><a href="javascript:;">{{menu.menuName}}</a></li>
							</ul> -->
						
						</li>

				</ul>
			</td>
			<td class="va-t"><IFRAME ID="testIframe" Name="testIframe"
					FRAMEBORDER=0 SCROLLING=AUTO width=100% height=500px 
					SRC="menuItemMain.htm"></IFRAME></td>
		</tr>
	</table>
	</div>
	<%@ include file="/WEB-INF/jsp/_footer.jsp"%>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
	<script type="text/javascript">
		function openWind(title, url) {
			var index = layer.open({
				type : 2,
				title : title,
				content : url
			});
			layer.full(index);
		}
		(function(){
			var app = angular.module('menu', []);
			angular.module('menu').controller('menuCtrl', function($scope, $http) {
			    //$http.get("fetchMenuCategory.ewsvc").then(function (response) {$scope.menuCategoryList = response.data;});
			    $scope.temppate = [{ name: 'menuCategory', url: 'menu_category.jsp'},
			        { name: 'template2.html', url: 'template2.html'}];
			    $scope.template = $scope.templates[0];
			    $scope.menuCategoryButton = function() {
			    	
			    }
			});
		})(jQuery)
	</script>
</body>
</html>