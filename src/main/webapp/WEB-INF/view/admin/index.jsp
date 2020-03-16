<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="/resource/bootstrap.min.css" />
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/bootstrap.min.js"></script>

<title>今日头条-管理员中心</title>
</head>
<body>

  <div class="container-fluid">

   <div class="row" style="background-color: #009FD9; height: 55px">
     <div class="col-md-12">
      <img alt="" src="/resource/images/1.jpg" width="55px" height="55px">
      <font color="write">今日头条-管理员中心</font>
     </div>
   
   </div>
   <div class="row" style="padding-top: 10px;height: 550px">
     <!-- 左侧菜单 -->
     <div class="col-md-2 rounded" style="background-color: #ccc ; text-align: center; margin-left: 13px" >
     
        <nav class="nav flex-column">
        <a class="list-group-item list-group-item active" href="#" data="/admin/articles">文章审核</a>
        <a class="list-group-item list-group-item" href="#" data="/admin/users">用户管理</a>
        <a class="list-group-item list-group-item" href="#" data="/admin/articles">栏目管理</a>
        <a class="list-group-item list-group-item" href="#" data="/admin/articles">分类管理</a>
        <a class="list-group-item list-group-item" href="#" data="/admin/articles">系统设置</a>
        </nav>
        
     </div>
     <!-- 右侧具体内容 -->
     <div class="col-md-9" id="center"></div>
   </div>
  
  </div>

</div>
<script type="text/javascript">


//点击样式切换
$(function(){
	  
	$("#center").load("/admin/articles");
	
	  $("a").click(function(){
		 var url = $(this).attr("data");
		 //去除样式
		 $("a").removeClass("active");
		 //让当前点击的li 添加选中样式
		 $(this).addClass("list-group-item active")
		 //在中间区域显示url的内容
		 $("#center").load(url);
	  })
  })




</script>
</body>
</html>