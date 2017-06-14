<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
	<head>
		<!-- CSS & JS -->
   		<%@ include file="./../_css&js.jsp" %>
   		
   		<link href="./assets/js/datetimepicker/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
	</head>
	<body>
		<h1 class="page-header">数据操作</h1>
		<div class="row">
			<form class="form-horizontal" action="">
				<div class="form-group">
					<label for="inputStartDatetime" class="col-sm-2 control-label">开始时间</label>
					<div class="col-sm-2">
						<input type="text" id="inputStartDatetime" class="form_date form-control">
					</div>
					<label for="inputEndDatetime" class="col-sm-2 control-label">结束时间</label>
					<div class="col-sm-2">
						<input type="text"  id="inputEndDatetime" class="form_date form-control">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-2">
						<button type="submit" class="btn btn-default">查询</button>
						<button type="submit" class="btn btn-primary">导出</button>
					</div>
				</div>
			</form>
		</div>
		
		<h2 class="sub-header">Section title</h2>
		<div class="table-responsive">
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th>#</th>
			      <th>Header</th>
			      <th>Header</th>
			      <th>Header</th>
			      <th>Header</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <td>1,001</td>
			      <td>Lorem</td>
			      <td>ipsum</td>
			      <td>dolor</td>
			      <td>sit</td>
			    </tr>
			    <tr>
			      <td>1,002</td>
			      <td>amet</td>
			      <td>consectetur</td>
			      <td>adipiscing</td>
			      <td>elit</td>
			    </tr>
			  </tbody>
			</table>
		</div>
		
		<script type="text/javascript" src="./assets/js/datetimepicker/bootstrap-datetimepicker.js" charset="UTF-8"></script>
		<script type="text/javascript">
		$('.form_date').datetimepicker({
			format:"yyyy-mm-dd",			
			weekStart: 1,
	        todayBtn:  1,
			autoclose: 1,
			todayHighlight: 1,
			startView: 2,
			minView: 2,
			forceParse: 0
		});
		</script>		
	</body>
</html>
