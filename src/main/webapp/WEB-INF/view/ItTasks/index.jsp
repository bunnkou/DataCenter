<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<form class="form-horizontal" action="<%=basePath%>ItTasks" method="POST">
				<div class="form-group">
					<label for="inputStartDatetime" class="col-sm-2 control-label">开始时间</label>
					<div class="col-sm-2">
						<input type="text" id="inputStartDatetime" name="inputStartDatetime" class="form_date form-control">
					</div>
					<label for="inputEndDatetime" class="col-sm-2 control-label">结束时间</label>
					<div class="col-sm-2">
						<input type="text"  id="inputEndDatetime" name="inputEndDatetime" class="form_date form-control">
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
		
		<c:if test="${ requestScope.task_list != null }">
		<h2 class="sub-header">查询结果</h2>
		<div class="table-responsive">
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th width="10%">申请人</th>
			      <th width="10%">申请时间</th>
			      <th width="50%">申请内容</th>
			      <th width="10%">处理人</th>
			      <th width="10%">完成时间</th>
			      <th width="10%">评分</th>
			    </tr>
			  </thead>
			  <tbody>
			    <c:forEach items="${ requestScope.task_list }" var="task">
			    	<tr>
			    		<td>${ task.getRname() }</td>
			    		<td>${ task.getRDateTime() }</td>
			    		<td>${ task.getFDetail() }</td>
			    		<td>${ task.getDName() }</td>
			    		<td>${ task.getCDateTime() }</td>
			    		<td>${ task.getMtGrade() }</td>
			    	</tr>
			    </c:forEach>
			  </tbody>
			</table>
			</c:if>
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
