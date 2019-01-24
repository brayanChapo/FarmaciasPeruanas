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
</head>
<body>
	<div class="container">
		<div class="header clearfix">
			<h3 class="text-muted">Televisor</h3>
		</div>
		<div class="searchForm">
			<form id="frmSearch" class="form-inline">

				<div class="input-group input-group-sm">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-barcode"></i></span> <input type="text"
						class="form-control" id="inputSName" aria-describedby=""
						placeholder="Buscar por marca" name="smarca">
				</div>

				<div class="input-group input-group-sm">
					<span class="input-group-addon" id="basic-addon1"><i
						class="glyphicon glyphicon-list-alt"></i></span> <input
						type="email" class="form-control" id="inputSEmail" name="sdescripcion"
						placeholder="Buscar por descripcion" aria-describedby="">
				</div>
				<button type="button" id="btnSearch" name="btnSearch" class="btn btn-primary btn-sm"
				data-toggle="tooltip" data-placement="right" title="Búsqueda por marca, descripcion o ambos">
					<span class="glyphicon glyphicon-search"></span> Buscar
				</button>
				<button type="button" id="btnNew" name="btnNew"
					class="btn btn-primary btn-sm btn-success pull-right">
						<span class="glyphicon glyphicon-plus"></span> Nuevo
				</button>
			</form>
		</div>
		<div class="dataTable">
			<table id="datatb" class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>#</th>
						<th>Marca</th>
						<th>Descripcion</th>
						<th>Precio</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th>#</th>
						<th>Marca</th>
						<th>Descripcion</th>
						<th>Precio</th>
					</tr>
				</tfoot>
			</table>
		</div>
		<c:import url="include/footer.jsp" />
	</div>
	<!-- Jquery & Bootstrap-->
	<script src="<c:url value="/resources/js/jquery.validate.min.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src="<c:url value="/resources/js/ie10-viewport-bug-workaround.js"/>"></script>
	<!-- DataTables -->
	<script src="<c:url value="/resources/js/jquery.dataTables.min.js" />"></script>
	<script
		src="<c:url value="/resources/js/dataTables.bootstrap.min.js" />"></script>
	<!-- Custom -->
	<script
		src="<c:url value="/resources/js/util.js" />"></script>
	<script
		src="<c:url value="/resources/js/functions.js" />"></script>
		
	<script type="text/javascript">
		$(document).ready(function() {
			//TODO: Agregar endpoint para cargar todos los registros >>>>>
			Util.initTable('<c:url value="/televisor/api/records"/>');
			
			$('#btnNew').click(function() {
				Util.initModal();
			});
			$('#btnSearch').click(function () {
				//TODO: Agregar endpoint para buscar registros >>>>>
				Util.updateTable('<c:url value="/televisor/api/records?"/>' + $('#frmSearch').serialize())
				
			});
		});
	</script>
	
	<!-- Modal -->
	<c:import url="include/modal.jsp" />
</body>
</html>