$(function(){
	var URL = 'http://localhost:8080/myproject/api/';
	const tabla ="productos";

	$.ajax({
		url:URL+"productos",
		method:'GET',
		dataType:'json'
	}).done(function(respuesta){
		let tbody= $("#table-remoto tbody");
		tbody.empty();
		
		let html;
		
		let productos= respuesta._embedded.productos;
		console.log(productos);
		$(productos).each(function(key){
			html=`
				<tr>
					<td>${this.id}</td>
					<td>${this.nombre}</td>
					<td><img style="height:80px;" src="${this.imagen }" class="img-fluid"
								alt="${this.nombre}" title="${this.nombre}"></td>
					<td>${this.descripcion}</td>
					<td>${this.precio}</td>
					<td>
						<a href="#" class="btn btn-warning" data-toggle="modal" data-target="#ModalEditpaises">
							<i class="fas fa-edit"></i>
						</a>
						<a href="#" class="btn btn-danger">
							<i class="fas fa-trash"></i>
						</a>
					</td>
				</tr>`;
			tbody.append(html);
		});
	}).fail(function(respuesta){
		msj="Error al cargar el listado. Vuelve a intentarlo";
	});
});
