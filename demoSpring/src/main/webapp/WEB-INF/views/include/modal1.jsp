<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="modalNew" class="modal fade" role="dialog" tabindex="-1" aria-hidden="false">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Nuevo Registro</h4>
			</div>
			<form id="frmNew" name="frmNew">
			<div class="modal-body">
				
		          <div class="form-group form-group-sm v-error">
		            <label for="recipient-name" class="form-control-label">Marca:</label>
		            <span class="input-group-addon"><i class="glyphicon glyphicon-barcode"></i></span>
		            <input type="text" class="form-control" id="marca" name="marca">
		          </div>
		          <div class="form-group form-group-sm v-error">
		            <label for="message-text" class="form-control-label">Descripcion:</label>
			        <span class="input-group-addon" id="basic-addon1"><i class="glyphicon glyphicon-list-alt"></i></span>
		            <input type="text" class="form-control" id="descripcion" name="descripcion">
		          </div>
		          <div class="form-group form-group-sm v-error">
		            <label for="message-text" class="form-control-label">Precio:</label>
			        <span class="input-group-addon" id="basic-addon1">$</span>
		            <input type="number" class="form-control" min="0.00" id="precio" name="precio">
		          </div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-sm btn-success" id="btnSave" >
					<span class="glyphicon glyphicon-floppy-disk"></span> Guardar
				</button>
			</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		Util.initForm();
		$('#btnSave').click(function(){
		    if ($("#frmNew").valid()) {
		    	//TODO: Agregar lógica para guardar un registro >>>>>
		    	saveRecord('frmNew','<c:url value="/celular/api/records"/>');
		    	
		    	$('#modalNew').modal('toggle');
		    	Util.resetForm();
		    }
		});
	});
</script>
