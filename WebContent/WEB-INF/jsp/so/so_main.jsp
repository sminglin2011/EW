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
<title>Account Payable</title>
</head>
<body ng-app="so" ng-controller="soCtrl">
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i>
		<a class="btn btn-success radius r btn-refresh"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:;" onclick="javascript:location.reload();" title="<fmt:message key="action.reload" />"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<div class="text-c">
			<form class="form form-horizontal" id="form-ap" ng-submit="keyworkSearch()">
			<input type="text" name="keyword" id="keyword" placeholder=" <fmt:message key="keyword"/>" ng-model="keyword""
				style="width: 250px" class="input-text">
			<button name="" id="" class="btn btn-success" type="submit">
				<i class="Hui-iconfont">&#xe665;</i> <fmt:message key="action.search"/>
			</button>
			</form>
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="l"> <a href="javascript:;" onclick="openWind('<fmt:message key="action.new"/>','newAp.htm')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> <fmt:message key="action.new"/></a></span>
		</div>
		<div class="mt-20">
			<table
				class="table table-border table-bordered table-bg table-hover">
				<thead>
					<tr class="text-c">
						<th width="5%">ST</th>
						<th width="5%">AS</th>
						<th width="10%">Order NO.</th>
						<th width="10%">Event Date</th>
						<th width="15%">Customer</th>
						<th width="5%">NO Pax</th>
						<th width="5%">Terms</th>
						<th width="5%">Amount</th>
						<th width="10%"><fmt:message key="action" /></th>
					</tr>
				</thead>
				<tbody>
					<tr class="text-c" ng-repeat="so in soList">
						<!-- <td>{{$index + 1}}</td> -->
						<td>{{so.postStatus}}</td>
						<td>{{so.ast}}</td>
						<td>{{so.soNumber}}</td>
						<td>{{so.eventDate | date:"yyyy-MM-dd"}}</td>
						<td>{{so.custName}}</td>
						<td>{{so.noPax}}</td>
						<td>{{so.icoTerm}}</td>
						<td>amount</td>
						<td class="f-14 td-manage">
						<a style="text-decoration: none" class="ml-5" 
							ng-click="editAp('<fmt:message key="action.edit"/>','editAp.htm',ap.id)"><i class="Hui-iconfont">&#xe6df;</i>
						</a>
						<a style="text-decoration: none" class="ml-5"><i class="Hui-iconfont">&#xe6e2;</i>
						</a>
						</td>
					</tr>
					
				</tbody>
			</table>
		</div>
	</div>
</body>
<%@ include file="/WEB-INF/jsp/_footer.jsp"%>
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
	var app = angular.module('so', []);
	angular.module('so').controller('soCtrl', function($scope, $http) {
	    $http.get("fetchAllSo.ewsvc").then(function (response) {$scope.soList = response.data;});
	    $scope.keyword = "";
	    $scope.keyworkSearch = function(){
	    	$http.get("keywordFetchAllSo.ewsvc?param=" + $scope.keyword).then(function (response) {$scope.soList = response.data;});
	    }
	});
})();

</script>
</html>