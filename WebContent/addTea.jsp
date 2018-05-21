<%@ page language="java"  import="subjectSystem.student,java.util.*,subjectSystem.subject" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title></title>

    <!-- Bootstrap Core CSS -->
    <link href="/subjectSystem/css/bootstrap.min.css" rel="stylesheet" type="text/css">

    <!-- Fonts -->
    <link href="/subjectSystem/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="/subjectSystem/css/animate.css" rel="stylesheet" />
    <!-- Squad theme CSS -->
    <link href="/subjectSystem/css/style.css" rel="stylesheet">
	<link href="/subjectSystem/color/default.css" rel="stylesheet">

</head>

<body>
	
	 <section id="intro" class="intro">
		<div class="slogan">
		
		<div class="container-fluid">
			<div class="row-fluid">
<%LinkedList<String> sid = (LinkedList<String>)request.getAttribute("sid");%>
<%LinkedList<String> sname = (LinkedList<String>)request.getAttribute("sname");%>
添加老师：
<form action = "addTea1.action" method = "post">
职工号：<%=" " %>:<input type = "text" name = "id"><br>
姓名：<%=" " %>:<input type = "text" name = "name"><br>
birthday(例如19900101)：<%=" " %>:<input type = "text" name = "birthday"><br>
sex(男或女)：<%=" " %>:<input type = "text" name = "sex"><br>
学院：<select  name="school" onChange="return change3()" class="editbox1" >
	<%for(int i=0;i<sid.size();i++){ %>
		<option value=<%=sid.get(i) %>> <%=sid.get(i)%><%=sname.get(i) %> </option> 
	<%} %>
	</select>
<br>
电话号码：<%=" " %>:<input type = "text" name = "phoneNum"><br>
密码：<%=" " %>:<input type = "text" name = "password"><br>
<input type = "submit" value = "添加">
<input type="button" value="返回" onclick="javascript:location.href='manager.jsp'"> 
</form>
</div>
		</div>
	</div>
		
			
		</div>
    </section>
	
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-lg-12">
					<div class="wow shake" data-wow-delay="0.4s">
					<div class="page-scroll marginbot-30">
						<a href="#intro" id="totop" class="btn btn-circle">
							<i class="fa fa-angle-double-up animated"></i>
						</a>
					</div>
					</div>
					<p>&copy;by wd</p>
                    <!-- 
                        All links in the footer should remain intact. 
                        Licenseing information is available at: http://bootstraptaste.com/license/
                        You can buy this theme without footer links online at: http://bootstraptaste.com/buy/?theme=Squadfree
                    -->
				</div>
			</div>	
		</div>
	</footer>
	
	<!-- Core JavaScript Files -->
    <script src="/subjectSystem/js/jquery.min.js"></script>
    <script src="/subjectSystem/js/bootstrap.min.js"></script>
    <script src="/subjectSystem/js/jquery.easing.min.js"></script>	
	<script src="/subjectSystem/js/jquery.scrollTo.js"></script>
	<script src="/subjectSystem/js/wow.min.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="/subjectSystem/js/custom.js"></script>
</body>
</html>