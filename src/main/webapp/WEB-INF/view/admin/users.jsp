<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文章审核</title>
</head>
<body>
<div class="form-group form-inline " >

 文章标题：
 <input type="text" name="username" class="form-control form-control-sm" value="${user.username }"> &nbsp;&nbsp;
用户状态：
 <select name="locked" class="form-control form-control-sm col-sm-1">
  <option value="0" ${user.locked=="0"?"selected":"" }>正常</option>
  <option value="1" ${user.locked=="1"?"selected":"" }>禁用</option>
 </div>
 </select>
 &nbsp;&nbsp;
 <button type="button" onclick="query()" class="btn btn-warning btn-sm">查询</button>
 <hr>
	<table class="table table-bordered table-hover table-sm" style="text-align: center;">
		<tr>
			<td>序号</td>
			<td>用户名</td>
			<td>昵称</td>
			<td>性别</td>
			<td>生日</td>
			<td>注册时间</td>
			<td>用户状态</td>
		</tr>
		<c:forEach items="${info.list}" var="user" varStatus="i">
			<tr>
				<td>${i.count }</td>
				<td>${user.username }</td>
				<td>${user.nickname }</td>
				<td>${user.gender==0?"女":"男" }</td>
				<td>${user.birthday }</td>
				<td><fmt:formatDate value="${user.created}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
				
				<td>
				   <!-- 用户正常状态 -->
				  <c:if test="${user.locked==0}">
				   <button type="button" class="btn btn-info btn-sm" onclick="update(${user.id},this)">正常</button>
				  </c:if>
				    <!-- 用户禁用状态 -->
				 <c:if test="${user.locked==1}">
				   <button type="button" class="btn btn-danger btn-sm" onclick="update(${user.id},this)">禁用</button>
				  </c:if>
				
				</td>
			</tr>


		</c:forEach>

     
	</table>
	
	
	

	
	
	

  <jsp:include page="/WEB-INF/view/common/pages.jsp"></jsp:include>
  
  <script type="text/javascript">
  
  // 改变用户状态 locked:   0:正常  1： 禁用
  function update(id,obj){
	  var locked = $(obj).text()=="正常"?1:0;
			  
	  $.post("/admin/updateUser",{id:id,locked:locked},function(flag){
		  if(flag){
			  $(obj).text($(obj).text()=="正常"?"禁用":"正常")  ;//改变按钮内容  
			  $(obj).attr("class",locked==0?"btn btn-info btn-sm":"btn btn-danger btn-sm");
		  }
	  });
	  
  }
  
  
  // 查询
  function query(){
	  var locked=$("[name='locked']").val();
	  var username=$("[name='username']").val();
	  $("#center").load("/admin/users?locked="+locked+"&username="+username);
  }
  
  function goPage(page){
		//在中间区域加载
		$("#center").load("/admin/users?page="+page);
	}
  
  
  </script>
</body>
</html>