var _datatable;
var _validator;
var Util = {
		initTable: function (url) {
			_datatable = $('#datatb').DataTable({
				"searching": false,
				"language" : {
					"lengthMenu" : "Muestra _MENU_ registros por pagina",
					"zeroRecords" : "No se encontraron registros",
					"info" : "Mostrando pagina  _PAGE_ de _PAGES_",
					"infoEmpty" : "Ningun registro disponible",
					"infoFiltered" : "(filtrado de _MAX_ registros en total)",
					"paginate" : {
						"previous" : "Anterior",
						"next" : "Siguiente",
					}
				},
				"ajax" : url,
				"type":"GET",
				"columns" : [ {
					"data" : "id"
				}, {
					"data" : "marca"
				}, {
					"data" : "descripcion"
				}, {
					"data" : "precio"
				} ]
			});
			$('#datatb_filter').remove();
			$('#datatb_length').remove();
			$('[data-toggle="tooltip"]').tooltip();
		},
		updateTable: function(url) {
			_datatable.ajax.url(url).load();
		},
		addRecord: function(object) {
			console.log("DATA OBJ: " +  object);
			_datatable.rows.add([object]).draw();
		},
		initModal: function () {
			$('#modalNew').modal({
				backdrop : true,
				backdrop : 'static'
			}).on('hidden.bs.modal', function (e) {
				Util.resetForm();
			});
			Util.resetForm();
		},
		initForm: function () {
			_validator = $('#frmNew').validate( {
				rules: {
					marca: {
						required: true,
						minlength: 3
					},
					descripcion: {
						required: true
					},
					precio: {
						required: true,
						digits: true
					}
				},
				messages: {
					marca: {
						required: "Por favor ingrese el nombre de la marca",
						minlength: "El nombre de la marca debe contener 3 caracteres"
					},
					descripcion: {
						required: "Por favor ingrese la descripcion"
					},
					precio: {
						required: "Por favor ingrese el precio",
						digits: "El precio debe contener valor numerico"
					}
				},
				errorPlacement: function ( error, element ) {
					// Add the `help-block` class to the error element
					error.addClass( "help-block" );

					if ( element.prop( "type" ) === "checkbox" ) {
						error.insertAfter( element.parent( "label" ) );
					} else {
						error.insertAfter( element );
					}
				},
				highlight: function ( element, errorClass, validClass ) {
					$( element ).parents( ".v-error" ).addClass( "has-error" ).removeClass( "has-success" );
				},
				unhighlight: function (element, errorClass, validClass) {
					$( element ).parents( ".v-error" ).addClass( "has-success" ).removeClass( "has-error" );
				}
			} );
		},
		resetForm: function() {
			$('#frmNew').find('input:text, input:password, input:file, select, textarea, input[type=email]').val('');
			$('#frmNew').find('input:radio, input:checkbox').removeAttr('checked')
					.removeAttr('selected');
			$(".v-error").removeClass("has-error").removeClass("has-success");
			_validator.resetForm();
		},
		getFormJson: function (id) {
			return JSON.stringify($('#'+id).serializeObject());
		}
		
}

$.fn.serializeObject = function() {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};