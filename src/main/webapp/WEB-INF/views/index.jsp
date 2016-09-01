<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">
<meta name="author" content="">

<title>Index</title>

<%@include file="/static/common/header.jsp"%>


</head>

<body>
	<div class="container">
		<div class="panel panel-success">
		 	<div class="panel-heading">Cadvisor</div>
			<div class="panel-body">
				<a id="machine" class="btn btn-primary">Manchine</a>
				<a id="docker" class="btn btn-success">Docker</a>
				<a id="containers" class="btn btn-info">Containers</a>
				<a id="subcontainers" class="btn btn-warning">subcontainers</a>
			</div>
		</div>
		<div class="panel panel-danger">
		 	<div class="panel-heading">Weave</div>
			<div class="panel-body">
				<a id="hosts" class="btn btn-primary">Hosts</a>
				<a id="containers2" class="btn btn-success">Containers2</a>
				<a id="subcontainer" class="btn btn-success">SubContainer</a>
			</div>
		</div>
		<div id="show"></div>
	</div>


	<!--js  -->
	<script type="text/javascript" src="${ctx}/js/index.js"></script>
</body>
</html>