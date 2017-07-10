<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="col-sm-3 col-md-2 sidebar">

  <ul class="nav nav-sidebar">
    <li id="ItTasks"><a href="<%=request.getContextPath()%>/ItTasks">IT Task</a></li>
    <!--
    	<li id="Timecard"><a href="<%=request.getContextPath()%>/Timecard">Timecard</a></li>
    	<li id="Process"><a href="<%=request.getContextPath()%>/Process">Process</a></li>
    -->
  </ul>
  
</div>

<script>

	$(document).ready(function(){
		var CURRENT_PAGE_NAME = "${ requestScope.CURRENT_PAGE_NAME }";
		if (!CURRENT_PAGE_NAME) return;
		$('.nav-sidebar').find('#'+CURRENT_PAGE_NAME).addClass("active");
	});
	
</script>