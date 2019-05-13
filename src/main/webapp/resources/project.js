// Project JS here
$(document).ready(function ()
{
	
	$('.btnEditar').on("click", function() {
		
		var id = $(this).data('id');
		var nombre = $(this).data('nombre');
		var apellido= $(this).data('apellido');
		var nss = $(this).data('nss');
		var curp = $(this).data('curp');
		
		
		$('#idModal').val(id);
		$('#nombreModal').val(nombre);
		$('#apellidoModal').val(apellido);
		$('#nssModal').val(nss);
		$('#curpModal').val(curp);
	});
	
	obtenerFoco();
	ocultarInput("idModal");
	
});  
function obtenerFoco()
{
	if($('#nombre').val() == "")
	{
		$('#nombre').focus();
	}
	else if($('#apellido').val() == "")
	{
		$('#apellido').focus();
	}else if($('#nss').val() == "")
	{
		$('#nss').focus();
	}
	else if($('#curp').val() == "")
	{
		$('#curp').focus();
	}
}
function ocultarInput(sInput)
{
	$("#"+sInput+"").hide();
}
function mostrarInput(sInput)
{
	$("#"+sInput+"").hide();
}