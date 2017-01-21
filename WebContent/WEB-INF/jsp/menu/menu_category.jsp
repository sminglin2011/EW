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
<title>Menu Category</title>
</head>
<body ng-app="zsoft" ng-controller="zsoftCtrl">
	<div class="page-container">
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<form class="form form-horizontal" id="form-menuCategory">
			<div class="row cl">
			<label class="form-label col-xs-2">Menu Category：</label>
			<div class="formControls col-xs-2">
				<input type="hidden" id="id" name="id" ng-model="menuCategory.categoryId" value=1>
				<input type="text" name="categoryName" id="categoryName"  ng-model="menuCategory.categoryName" datatype="s4-50"
				style="width: 250px" class="input-text">
			</div>
			<label class="form-label col-xs-2">Sequence：</label>
			<div class="formControls col-xs-1">
				<input type="text" name="sequence" id="sequence" ng-model="menuCategory.sequence" datatype="n1-3"
				style="width: 50px" class="input-text">
			</div>
			<div class="formControls col-xs-2">
				<div class="check-box">
					<input type="checkbox" id="onlineShow" name="onlineShow" ng-model="menuCategory.online">
					<label for="onlineShow">Show On WebSite</label>
				</div>
			</div>
			<div class="formControls col-xs-2">
				<button name="" id="" class="btn btn-success" type="submit" ng-click="saveMenuCategory()">
				<i class="Hui-iconfont">&#xe632;</i> <fmt:message key="action.save" />
			</button>
			</div>
			</div>
			</form>
		</div>
		<div class="mt-20">
			<table
				class="table table-border table-bordered table-bg table-hover">
				<thead>
					<tr class="text-c">
						<th width="10%"><input type="checkbox" name="" value=""></th>
						<th width="10%">Sequence</th>
						<th width="60">Menu Category</th>
						<th width="10%">Show On WebSite</th>
						<th width="10%">Action</th>
					</tr>
				</thead>
				<tbody>
						<tr class="text-c" ng-repeat="menuCategory in menuCategoryList">
							<td><input type="checkbox" value="" name=""></td>
							<td> {{menuCategory.sequence}}</td>
							<td> <a href="javascript:;" class="btn btn-link radius"
								ng-click="menuUnderCategory(menuCategory)">{{menuCategory.categoryName}}</a></td>
							<td class="onlineShow">{{menuCategory.online}}</td>
							<td class="f-14 td-manage"><a
								style="text-decoration: none" class="ml-5"
								ng-click="editMenuCategory(menuCategory)"
								href="javascript:;" title="<fmt:message key="action.edit" />"><i class="Hui-iconfont">&#xe6df;</i></a>
								<!-- 
								<a style="text-decoration: none" class="ml-5"
								onClick="stock_del(this,${menuCategory.id})" href="javascript:;"
								title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
								 -->
							</td>
						</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
<%@ include file="/WEB-INF/jsp/_footer.jsp"%>
<script type="text/javascript" src="lib/Validform/5.3.2/Validform.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script type="text/javascript">
(function(){
	$('.table').dataTable( {  
		"info": false,
		"paging": false,
        "bSort": false,
        "bLengthChange": false,
        "searching": false
     } );
	var validform = $("#form-menuCategory").Validform({
		tiptype:3,
		beforeSubmit:function(form){ return false;}
	})
	var app = angular.module('zsoft', []);
	angular.module('zsoft').controller('zsoftCtrl', function($scope, $http, $rootScope) {
		
		$scope.menuCategory = {};
	    $http.get("fetchMenuCategory.ewsvc").then(function (response) {$scope.menuCategoryList = response.data;});
	    
	    $scope.editMenuCategory = function(menuCategory){
	    	$scope.menuCategory = menuCategory;
	    	
	    }
	    $scope.menuUnderCategory = function(menuCategory) {
	    	location.replace("menuList.htm?categoryId="+menuCategory.categoryId);
	    }
	    $scope.saveMenuCategory = function(){
	    	console.log("save menuCategory",$scope.menuCategory);
	    	if(validform.check()) {
	    		$http({ // default headerType json/application
	                url:'saveMenuCategory.ewsvc',
	                method: 'POST',            
	                data: $scope.menuCategory
	            }).success(function(data){
	            	if (data.status == 'y') {
						layer.msg(data.msg, { icon : 1, time : 2000 });
						//var index = parent.layer.getFrameIndex(window.name);
						location.reload()
						//parent.layer.close(index);
					} else {
						layer.msg(data.msg, { icon : 5, time : 5000 });
					}
	            }).error(function(data){
	            	layer.msg('system run ajax error,'+data, { icon : 5, time : 5000 });
	            });
	    	}
	    	
	    }
	});
})();
</script>
</html>