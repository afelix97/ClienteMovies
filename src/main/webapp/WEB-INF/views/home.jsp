<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<tags:template>
	<jsp:attribute name="head">  
		<script type="text/javascript">
			
		</script>
  	</jsp:attribute>  
	<jsp:body>
		<div class="container">
		 <!-- Modal -->
<div class="modal fade" id="modalEditarUsuario" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
	<form class="form" action="/movies/updateUsuario" method="post">
      <div class="modal-body">
        	<div class="form-group row">
				<label class="col-sm-2 col-form-label"></label >
				<div class="col-sm-10">
					<input type="text" id="idModal" class="form-control" name="idModal" required=""/>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Nombre: </label >
				<div class="col-sm-10">
					<input type="text" id="nombreModal" class="form-control" name="nombreModal" maxlength="50" required=""/>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Apellido: </label >
				<div class="col-sm-10">
					<input type="text" id="apellidoModal"  class="form-control" name="apellidoModal" maxlength="50" required=""/>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">nss: </label >
				<div class="col-sm-10">
					<input type="numeric" id="nssModal" class="form-control" name="nssModal"  maxlength="11" minlength="11" required=""/>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">curp: </label >
				<div class="col-sm-10">
					<input type="text" id="curpModal" class="form-control" name="curpModal"  maxlength="18" minlength="18" required=""/>
				</div>
			</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
        <input type="submit" class="btn btn-primary" value="Actualizar" />
      </div>
	</form>
    </div>
  </div>
</div>
		<br>
		<form class="form" action="/movies/insertUsuario" method="post">
			<div class="form-group row">
				<div class="col-md-2"></div>
				<label class="col-sm-2 col-form-label">Nombre: </label >
				<div class="col-sm-6">
					<input type="text"  class="form-control" id="nombre" name="nombre" maxlength="50" required=""/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-2"></div>
				<label class="col-sm-2 col-form-label">Apellido: </label >
				<div class="col-sm-6">
					<input type="text"  class="form-control" id="apellido" name="apellido"  maxlength="50"  required=""/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-2"></div>
				<label class="col-sm-2 col-form-label">nss: </label >
				<div class="col-sm-6">
					<input type="text"  class="form-control" id="nss" name="nss" maxlength="11" minlength="11" required=""/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-2"></div>
				<label class="col-sm-2 col-form-label">curp: </label >
				<div class="col-sm-6">
					<input type="text"  class="form-control" id="curp" name="curp" maxlength="18" minlength="18" required="" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-2"></div>
				<div class="col-md-2">
					<input type="submit" class="btn btn-success"  value="Guardar"/>
				</div>
			</div>
		</form>
		<br>
			<div class="row">
				<table class="table table-bordered">
					<thead  class="thead-dark">
	    				<tr class="text-center">
							<th>#</th>
							<th>Nombre</th>
							<th>nss</th>
							<th>curp</th>
							<th>Accion</th>
						</tr>
					</thead>
	  				<tbody class="text-center">
						<c:forEach var="usuario" items="${listUsuarios}">
							<tr>
								<td>${usuario.id}</td>
								<td>${usuario.nombre} ${usuario.apellido}</td>
								<td>${usuario.nss}</td>
								<td>${usuario.curp}</td>
								<td class="text-center">
									<button id="" type="button" class="btn btn-primary btnEditar" data-toggle="modal" data-target="#modalEditarUsuario" 
									data-id="${usuario.id}" data-nombre="${usuario.nombre}" data-apellido="${usuario.apellido}"
									data-nss="${usuario.nss}" data-curp="${usuario.curp}">Editar</button>
									<a class="btn btn-danger" href="/movies/destroyUsuario/${usuario.id}">Eliminar</a>
								</td>
							</tr>		
						</c:forEach>	
	 				</tbody>
				</table>
			</div>
			<hr>
		</div>
	</jsp:body>
</tags:template>