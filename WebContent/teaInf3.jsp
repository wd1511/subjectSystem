<%@ page language="java"  import="subjectSystem.teacher,java.util.*" contentType="text/html; charset=UTF-8"
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
<%teacher a = (teacher)request.getAttribute("newteacher");%>
你好，<%=a.getTeacherName()%>，密码修改成功。
<br>
<input type="button" value="返回" onclick="javascript:location.href='teaInf4.action?teacherID=<%=a.getTeacherID() %>'"> 
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