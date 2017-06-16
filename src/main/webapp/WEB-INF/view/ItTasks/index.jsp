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
		<meta charset="utf-8">
		<!-- CSS & JS -->
   		<%@ include file="./../_css&js.jsp" %>
   		
   		<link href="./assets/js/datetimepicker/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
	</head>
	<body>
	
		<!-- 顶部导航条 -->
    	<%@ include file="./../_header.jsp" %>
    	
    	<div class="container-fluid">
      		<div class="row">
    		
	    		<!-- 左侧菜单 -->
	        	<%@ include file="./../_leftSlider.jsp" %>	
		
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" style="margin-top:50px;">
					<h1 class="page-header">数据操作</h1>
					<div class="row">
						<form class="form-horizontal" action="<%=basePath%>ItTasks" method="POST">
							<input type="hidden" name="inputOperate" id="inputOperate" value="0">
							<div class="form-group">
								<label for="inputStartDatetime" class="col-sm-2 control-label">开始时间</label>
								<div class="col-sm-2">
									<input type="text" id="inputStartDatetime" name="inputStartDatetime" value="${ inputStartDatetime }" class="form_date form-control">
								</div>
								<label for="inputEndDatetime" class="col-sm-2 control-label">结束时间</label>
								<div class="col-sm-2">
									<input type="text"  id="inputEndDatetime" name="inputEndDatetime" value="${ inputEndDatetime }" class="form_date form-control">
								</div>
							</div>
							<div class="form-group">
								<label for="inputStartDatetime" class="col-sm-2 control-label">关键字</label>
								<div class="col-sm-6">
									<input type="text"  id="inputKeyword" name="inputKeyword" value="${ inputKeyword }" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-2">
									<button type="button" class="btn btn-default" onclick="submitIT(0);">查询</button>
									<button type="button" class="btn btn-primary" onclick="submitIT(1);">导出</button>
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
						      <th width="13%">申请人</th>
						      <th width="13%">申请时间</th>
						      <th width="20%">申请内容</th>
						      <th width="13%">处理人</th>
						      <th width="13%">完成时间</th>
						      <th width="13%">评分</th>
						      <th width="13%">耗时（分）</th>
						    </tr>
						  </thead>
						  <tbody>
						    <c:forEach items="${ requestScope.task_list }" var="task">
						    	<tr>
						    		<td>${ task.getRname_R() }</td>
						    		<td>${ task.getRDateTime() }</td>
						    		<td>${ task.getFDetail() }</td>
						    		<td>${ task.getDName_R() }</td>
						    		<td>${ task.getCDateTime() }</td>
						    		<td>${ task.getMtGrade() }</td>
						    		<td>${ task.getTakingTime() }</td>
						    	</tr>
						    </c:forEach>
						  </tbody>
						</table>
						</c:if>
					</div>
				
			</div><!-- row -->		
		</div><!-- container-fluid -->
		
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
		function submitIT(param){
			$("#inputOperate").val(param);
			$("form").submit();
		}
		</script>		
	</body>
</html>
