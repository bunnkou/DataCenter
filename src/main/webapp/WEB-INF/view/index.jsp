<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	    <meta name="description" content="">
	    <meta name="author" content="">
	    
	    <title>数据中心</title>
    	
    	<!-- CSS & JS -->
   		<%@ include file="_css&js.jsp" %>
        
  	</head>

  <body>

	<!-- 顶部导航条 -->
    <%@ include file="_header.jsp" %>
    
    <div class="container-fluid">
      <div class="row">
        
        <!-- 左侧菜单 -->
        <%@ include file="_leftSlider.jsp" %>
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        </div>		<!-- 右边内容 -->
        
      </div>
    </div><!-- end container-fluid -->
    
</body>
</html>