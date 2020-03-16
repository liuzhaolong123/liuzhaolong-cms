<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 视窗 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${article.title }</title>
<link rel="stylesheet" type="text/css"
	href="/resource/bootstrap.min.css" />

<link rel="stylesheet" type="text/css" href="/resource/index.css" />
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
<!-- 先引入jquery,再引入bootstrap -->
<script type="text/javascript" src="/resource/bootstrap.min.js"></script>
</head>
<body>

	<div class="container-fluid">
		<!-- head -->
		<div class="row">
			<div class="col-md-12"
				style="background-color: #222222; height: 34px">
				<font color="white" size="2px" style="margin-left: 10px">下载APP</font>
			</div>

		</div>

		<div class="row" style="margin-top: 10px">
			<div class="col-md-1"></div>
			<div class="col-md-7">
				<h2>${article.title }</h2>
				<p>${article.user.username}
					<fmt:formatDate value="${article.created}"
						pattern="yyyy-MM-dd HH:mm:ss" />
				</p>
				<hr>
				${article.content}

				<hr>
				<!-- 文章评论 -->
				<div>
					<h5>文章评论：</h5>
					<textarea rows="8" cols="20" style="width: 753px" name="content"></textarea>
 					<button type="button" onclick="addComment()" class="btn btn-info">提交评论</button>
				</div>
				
				<div>
				  <!-- 显示评论内容 -->
				  <c:forEach items="${info.list}" var="comment">
				   <h5> ${comment.user.username} ${comment.created}</h5>
				    
				    ${comment.content }
				  <hr>
				  </c:forEach>
				</div>

			</div>

			<div class="col-md-4"></div>
		</div>

 

	</div>
	
	<script type="text/javascript">
	
	function addComment(){
		var articleId='${article.id}';
		var content=$("[name='content']").val();
		$.post("/addComment",{articleId:articleId,content:content},function(flag){
			if(flag){
				alert("评论成功");
				window.location.reload();
			}else{
				alert("评论失败，需要登录后才能评论")
			}
		})
		
	}
	
	</script>
</body>
</html>