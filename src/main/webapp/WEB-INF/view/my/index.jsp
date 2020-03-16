<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 视窗 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>今日头条-个人中心</title>
<link rel="stylesheet" type="text/css"
	href="/resource/bootstrap.min.css" />
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
<!-- 先引入jquery,再引入bootstrap -->
<script type="text/javascript" src="/resource/popper.min.js"></script>
<script type="text/javascript" src="/resource/bootstrap.min.js"></script>

</head>
<body>
	<div class="container-fluid">
		<!-- 头 -->
		<div class="row">
			<div class="col-md-12"
				style="background-color: #563D7C; height: 60px" align="left">
				<a href="/"><img alt="" src="/resource/images/logo.png"
					style="height: 55px; padding-top: 2px; padding-left: 2px"></a> <span
					style="color: white">今日头条-个人中心 </span>


				<div style="float: right">
					<!-- 从session获取当前有没有登录，如果用户已经登录，则不显示登录和注册 -->
					
					<c:if test="${null !=sessionScope.user}">
						<div class="btn-group dropleft">
							<button type="button" class="btn btn-link dropdown-toggle"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">
								<font color="white" size="2px">登录信息</font>
							</button>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="#">${sessionScope.user.username }</a>
								<a class="dropdown-item" href="/my">个人中心</a> <a
									class="dropdown-item" href="/passport/logout">注销</a>
							</div>
						</div>
					</c:if>
				</div>


			</div>

		</div>
		<!-- body -->
		<div class="row" style="padding-top: 5px">
			<!--  左侧菜单 -->
			<div class="col-md-2">

				<ul class="list-group">
					<li class="list-group-item active"><a href="#"
						data="/my/articles"><font color="red">我的文章</font></a></li>
					<li class="list-group-item"><a href="#" data="/my/publish"><font
							color="red">发布文章</font></a></li>
					<li class="list-group-item"><a href="#"><font color="red">我的收藏</font></a></li>
					<li class="list-group-item"><a href="#"><font color="red">我的评论</font></a></li>
					<li class="list-group-item"><a href="#"><font color="red">个人信息</font></a></li>
				</ul>

			</div>
			<!-- 内容显示区域 -->
			<div class="col-md-10" id="center">
				<!-- 先加载kindeditor的样式 -->
				<div style="display: none">
					<jsp:include page="/resource/kindeditor/jsp/demo.jsp"></jsp:include>

				</div>

			</div>

		</div>


	</div>

	<script type="text/javascript">
		//为 li 添加点击事件
		$(function() {

			//默认显示我的文章
			$("#center").load("/my/articles");

			$("li").click(function() {
				var url = $(this).children().attr("data");
				//	alert(url)
				//去除样式
				$("li").removeClass("active");
				//让当前点击的li 添加选中样式
				$(this).addClass("list-group-item active")
				//在中间区域显示url的内容
				$("#center").load(url);
			})

		})
	</script>
</body>
</html>