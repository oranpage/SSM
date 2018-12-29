


<!-- 根据分页查询 -->


<%@page import="net.wanho.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<link rel="stylesheet" href="/css/bootstrap.min.css" />
<script type="text/javascript" src="/js/jquery-3.0.0.js"></script>
<script type="text/javascript" src="/js/jqPaginator.js"></script>
<script type="text/javascript" src="/js/bootstrap-3.3.4.js"></script>

<title>Insert title here</title>
</head>
<body>

<div class="container" >

	<div class="dataTables_filter" align="center">
		<form class="form-inline" action="/student/search"
			  method="post">
			<div class="btn-group">
				<span>姓名：</span>
				<input type="text" class="form-control" id="name" name="name"
					   value="" placeholder="姓名">
			</div>
			<div class="btn-group">
				<span>年龄：</span>
				<input type="text" class="form-control" id="age" name="age"
					   value="" placeholder="年龄">
			</div>
			<div class="btn-group">
				<button type="submit" class="btn btn-success">
					<i class="glyphicon glyphicon-search"></i> 搜索
				</button>
			</div>
		</form>
	</div>

	<div class="pagination-layout" align="center">

		<div class="pagination">
			<ul class="pagination">

			</ul>

		</div>
	</div>

	<div>
	<%-- <%List<Student> list=(List<Student>)request.getAttribute("student"); %> --%>
	<table class="table" border="1px" style="text-align: center" >
		<%--<caption style="text-align: center"><h3 >学生管理系统</h3></caption>--%>

		<thead >
		<tr>
			<th style="text-align: center">学号</th>
			<th style="text-align: center">姓名</th>
			<th style="text-align: center">年龄</th>
			<th colspan="3" style="text-align: center">操作</th>
		</tr>
		</thead>
		<tbody>
		 <%-- <% for(Student s:list){ %>  --%>
			<c:forEach items="${students}" var="s">
		<tr>
			<td>${s.id }</td>
			<td>${s.name }</td>
			<td>${s.age}</td>
			<td><a href="/student/toAdd" class="btn btn-default">增加</a></td>
			<td><a href="/student/delete?id=${s.id }" class="btn btn-default">删除</a></td>
			<td><a href="/student/id?id=${s.id }" class="btn btn-default">修改</a></td>
		</tr>
		<%--  <%} %>  --%>
		</c:forEach>
		</tbody>
	</table>
	</div>

</div>


	<script type="text/javascript">
		window.onload = function() {
			var if_firstime = true;
            var falg= true;
			$(".pagination")
					.jqPaginator(
							{
								totalPages :${totalPages},
								visiblePages :3,
								currentPage : ${currentPage},
								first : '<li class="first"><a href="javascript:void(0);">第一页</a></li>',
								prev : '<li class="prev"><a href="javascript:void(0);">上一页</a></li>',
								next : '<li class="next"><a href="javascript:void(0);">下一页</a></li>',
								last : '<li class="last"><a href="javascript:void(0);">最后一页</a></li>',
								page : '<li class="page"><a href="javascript:void(0);">{{page}}</a></li>',

								onPageChange : function(num) {
//									alert(num)
									/* if_firstime为了防止页面加载时一直调用changePage方法，会造成死循环 */
									 if (if_firstime) {
										if_firstime = false;
									} else if (!if_firstime) {
										changePage(num);
									} 
								}

							})

		}

		function changePage(num) {
			/* 发请求到后台 */
			/* $("#pageNum").val(num);
			$("#frm").submit(); */
//
//			if(flag){
//			    flag=false;
//			}else{
            window.location.href= "/student?pageNum="+ num;

			
			/* window.location.href = "/testpage/UserServlet?" + "&pageNum=" + num; */
		}
	</script>

</body>
</html>