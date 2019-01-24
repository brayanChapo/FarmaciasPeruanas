<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="X-UA-Compatible"
	content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Demo SpringBoot</title>
<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link
	href="<c:url value="/resources/css/ie10-viewport-bug-workaround.css" />"
	rel="stylesheet">
<!-- DataTables -->
<link
	href="<c:url value="/resources/css/dataTables.bootstrap.min.css" />"
	rel="stylesheet">
<!-- Custom CSS -->
<link href="<c:url value="/resources/css/custom.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
<style type="text/css">
body {
	padding-top: 0px;
	padding-bottom: 0px;
}

.margin {
	margin-bottom: 45px;
}

.bg-1 {
	/*background-color: #1abc9c; /* Green */
	color: #777;
}

.container-fluid {
	padding-top: 50px;
	padding-bottom: 70px;
}
</style>
</head>
<body>
	<div class="container-fluid bg-1 text-center">
		<h1 class="margin">Bienvenidos a nuestra pagina de consultas de electrodomesticos</h1>
		<img src='<c:url value="/resources/images/tv-celus.jpg" />'
			class="img-responsive margin" style="display: inline" alt="Bird"
			width="360" height="480">
		<form class="form-inline" method="post" action="<c:url value='/home/televisor' />">
			<button type="submit" class="btn btn-primary btn-lg" id="btnStart"
				name="btnStart">
				Televisor <span class="glyphicon glyphicon-play"></span>
			</button>
		</form>
		
		<form class="form-inline" method="post" action="<c:url value='/home/celular' />">
			<button type="submit" class="btn btn-primary btn-lg" id="btnStart"
				name="btnStart">
				Celular <span class="glyphicon glyphicon-play"></span>
			</button>
		</form>
	
	</div>
	
	
	
	<div class="container">
		<footer class="footer">
			<p>2019 &copy; Chapoñan, Inc., Todos los derechos reservados</p>
		</footer>
	</div>
	<!-- Jquery & Bootstrap-->
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src="<c:url value="/resources/js/ie10-viewport-bug-workaround.js"/>"></script>
</body>
</html>