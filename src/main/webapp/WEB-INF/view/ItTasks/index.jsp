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
   		<link href="./assets/js/bootstrap-table/bootstrap-table.min.css" rel="stylesheet" media="screen">
   		
   		<title>IT任务单统计</title>
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
					
					<c:if test="${ not empty errors }">
						<div class="alert alert-danger" role="alert">
							<button type="button" class="close" data-dismiss="alert" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<c:forEach var="err" items="${ errors }" varStatus="status">
								${ status.count } . ${ err }
							</c:forEach>
						</div>
					</c:if>
					
					<div class="row query-block">
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
									<button type="button" class="btn btn-default" onclick="query();">查询</button>
									<button type="button" class="btn btn-primary" onclick="submitIT(1);">导出</button>
								</div>
							</div>
						</form>
					</div>
															
					<h2 class="sub-header">查询结果</h2>
					<table id="todoTBL" data-icon-size="outline" data-pagination="true" style="word-break:break-all; word-wrap:break-all;"></table>
									
			</div><!-- row -->		
		</div><!-- container-fluid -->
		
		<script type="text/javascript" src="./assets/js/bootstrap-table/bootstrap-table.min.js" charset="UTF-8"></script>
		<script type="text/javascript" src="./assets/js/bootstrap-table/locale/bootstrap-table-zh-CN.min.js" charset="UTF-8"></script>
		<script type="text/javascript" src="./assets/js/datetimepicker/bootstrap-datetimepicker.js" charset="UTF-8"></script>
		<script type="text/javascript" src="./assets/js/datetimepicker/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
		
		<script type="text/javascript">
		var $table = $('#todoTBL');
		
		$(document).ready(function(){
			$('.form_date').datetimepicker({
				format:"yyyy-mm-dd",		
				language: 'zh-CN',
				weekStart: 1,
		        todayBtn:  1,
				autoclose: 1,
				todayHighlight: 1,
				startView: 2,
				minView: 2,
				forceParse: 0
			});
		});
		
		function query()
		{
			$table.bootstrapTable('destroy'); 
			$table.bootstrapTable({
				height: getHeight(),
		    	url: "<%=request.getContextPath()%>/ItTasks/show",
		    	queryParams: queryParams,
		    	dataType: "json",
		    	pagination: true,
		    	pageSize: 20,
				pageList: [20,50],
				sidePagination: "server",
			    columns: [
			    	{field: 'rname_R', title: '申请人', width:'9%'},
			    	{field: 'rdateTime', title: '申请时间', width:'13%'},
			    	{field: 'fdetail', title: '申请内容', width:'32%'},
			    	{field: 'dname_R', title: '处理人', width:'9%'},
			    	{field: 'cdateTime', title: '完成时间', width:'13%'},
			    	{field: 'mtGrade', title: '评分', width:'9%'},
			    	{field: 'takingTime', title: '耗时（分）', width:'13%'}
			    ]
			});	
		}
		
		function queryParams(params) {
			var inputStartDatetime = $('#inputStartDatetime').val(),
				inputEndDatetime = $('#inputEndDatetime').val(),
				inputKeyword = $('#inputKeyword').val();
			return {
				pageSize: params.limit,
				pageNumber: params.offset,
				inputStartDatetime: inputStartDatetime,
				inputEndDatetime: inputEndDatetime,
				inputKeyword: inputKeyword
			};
		}
		
		function getHeight() {
	        return $(window).height() - $('.query-block').outerHeight(true);
	    }
		
		function submitIT(param){
			$("#inputOperate").val(param);
			$("form").submit();
		}
		</script>		
	</body>
</html>
