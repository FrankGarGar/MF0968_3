'use strict';
//var URL = window.location.href + '/api/';
var URL = 'http://localhost:8080/api/';
var page=0;
var size=4;
$(function(){
	optionsNacionalidades();
	optionsEmpresas();
	optionsEdificios();
	optionsPersonas();
	//Obtener listado al clickear next or prev		
	$(".buttons>a").on("click",function(e){
		$(".prev").removeClass("disabled");
		$(".next").removeClass("disabled");
		var page=parseInt($(".act").html())-1;
		if($(this).hasClass("prev") && page>=1){
			page = page-1;
		}else{
			page = page+1;
		}
		var tabla = $(".activo").data("tabla");
		pedirListadoPaginado(tabla,page);
	});
	/*BUSCADOR DE LETRAS NUMS Y SIMBOLOS TOLERANTE DE MAYUSCULAS Y MINUSCULAS*/
		$(".search").keyup(function(e){
			searchText();
		});
		//ON PASTE 
		$(".search").bind("paste", function(e){
		    setTimeout(function(e) {
		    	searchText();
	        }, 50);
		} );
	$(".nav-item:not(:first-child)").on("click",function(e){
		$(".activo").removeClass("activo");
		$(".prev").removeClass("disabled");
		$(".next").removeClass("disabled");
		
		var tabla= $(this).data("tabla");
		var html=`Listado de ${tabla} 
					<a class="pa" data-toggle="modal" data-target="#Modal${tabla}">
						<i class="fas fa-plus"></i>
					</a>`;
		$(".title").html(html);
		
		pedirListadoPaginado(tabla,page);
	});
	$("#form-pais").submit(function(e){
		e.preventDefault();
		const tabla = "paises";

		const nombre = $(this).find("#nombre").val();
		const codigo = $(this).find("#codigo").val();
		const pais = {nombre,codigo};
		saveObject(tabla,pais);
		
	});
	$("#form-persona").submit(function(e){
		e.preventDefault();
		var tabla = "personas";

		const nombre = $(this).find("#nombre").val();
		const apellidos = $(this).find("#apellidos").val();
		const dni = $(this).find("#dni").val();
		const nacionalidades = $(this).find("#nacionalidades").val();
		
		const persona = {nombre,apellidos,dni,nacionalidades};
		saveObject(tabla,persona);
		
	});
	$("#form-edificio").submit(function(e){
		e.preventDefault();
		const tabla = "edificios";

		const nombre = $(this).find("#nombre").val();
		const codigoEdificio = $(this).find("#codigoEdificio").val();
		const latitud = $(this).find("#latitud").val();
		const longitud = $(this).find("#longitud").val();
		const altitud = $(this).find("#altitud").val();
		const dueño = $(this).find("#dueño").val();
		const edificio = {nombre,codigoEdificio,latitud,longitud,altitud,dueño};
		saveObject(tabla,edificio);

	});
	$("#form-empresa").submit(function(e){
		e.preventDefault();
		const tabla = "empresas";

		const nombre = $(this).find("#nombre").val();
		const codigoEmpresa = $(this).find("#codigoEmpresa").val();
		const presidenteActual = $(this).find("#presidenteActual").val();
		const sedes = $(this).find("#sedes").val();
		const edificio = {nombre,codigoEmpresa,presidenteActual,sedes};
		saveObject(tabla,edificio);
	});
	$("#form-edit-pais").submit(function(e){
		e.preventDefault();
		const id = $(this).find("#id-pais").val();
		const tabla = "paises";
		const nombre = $(this).find("#nombre").val();
		const codigo = $(this).find("#codigo").val();
		const pais = {id,nombre,codigo};
		const td =$(".activo tbody tr td:last-child");
		editObject(tabla,pais,td);
		
	});
	$("#form-edit-persona").submit(function(e){
		e.preventDefault();
		const id = $(this).find("#id-persona").val();
		const tabla = "personas";
		const nombre = $(this).find("#nombre").val();
		const apellidos = $(this).find("#apellidos").val();
		const dni = $(this).find("#dni").val();
		const nacionalidades = $(this).find("#nacionalidades").val();
		const persona = {id,nombre,apellidos,dni,nacionalidades};
		const td =$(".activo tbody tr td:last-child");
		editObject(tabla,persona,td);
		
			
	});
	$("#form-edit-edificio").submit(function(e){
		e.preventDefault();
		const id = $(this).find("#id-edificio").val();
		const tabla = "edificios";
		const nombre = $(this).find("#nombre").val();
		const codigoEdificio = $(this).find("#codigoEdificio").val();
		const latitud = $(this).find("#latitud").val();
		const longitud = $(this).find("#longitud").val();
		const altitud = $(this).find("#altitud").val();
		const dueño = $(this).find("#dueño").val();
		const edificio = {id,nombre,codigoEdificio,latitud,longitud,altitud,dueño};
		const td =$(".activo tbody tr td:last-child");
		editObject(tabla,edificio,td);
			
	});
	$("#form-edit-empresa").submit(function(e){
		e.preventDefault();
		const id = $(this).find("#id-empresa").val();
		const tabla = "empresas";
		const nombre = $(this).find("#nombre").val();
		const codigoEmpresa = $(this).find("#codigoEmpresa").val();
		const presidenteActual = $(this).find("#presidenteActual").val();
		const sedes = $(this).find("#sedes").val();
		const edificio = {id,nombre,codigoEmpresa,presidenteActual,sedes};
		const td =$(".activo tbody tr td:last-child");
		editObject(tabla,edificio,td);
		
	});
});
function searchText(){
	const valor= $(".search").val().toLowerCase();
	var y=0;
	var str="";
	$(".activo tbody tr").each(function(key){
		y=0;
		$($(this).find("td")).each(function(key2){
			str = $(this).html().toLowerCase();
			if(str.indexOf(valor)<0){
				y++;
			}else{
				y=0;
				return false;
			}
		});
		if(y!=0){
			if($(this).hasClass("dntr")){
			
			}else{
				$(this).addClass("dntr");
			}
		}else{
			if($(this).hasClass("dntr")){
				$(this).removeClass("dntr");
			}
		}
	});
}
function saveObject(tabla,object){
	const opcionesAjax = {
            url: URL+tabla,
            method: 'POST',
            data: JSON.stringify(object),
            contentType: 'application/json',
            dataType: 'json'
        };
	let msj;
	let tipo;
	$.ajax(opcionesAjax)
	.done(function(respuesta){
		if(tabla=="paises"){
			optionsNacionalidades();
			msj= "País guardado correctamente!";
			$("#form-pais")[0].reset();
		}else if(tabla=="personas"){
			optionsPersonas();
			msj= "Persona guardada correctamente!";
			$("#form-persona")[0].reset();
		}else if(tabla=="empresas"){
			optionsEmpresas();
			msj= "Empresa guardada correctamente!";
			$("#form-empresa")[0].reset();
		}else if(tabla=="edificios"){
			optionsEdificios();
			msj= "Edificio guardado correctamente!";
			$("#form-edificio")[0].reset();
		}

		tipo ='success';
	}).fail(function(respuesta){
		if(tabla=="paises"){
			msj = "Error al intentar guardar el país. Por favor vuelva a intentarlo";
		}else if(tabla=="personas"){
			msj = "Error al intentar guardar la persona. Por favor vuelva a intentarlo";
		}else if(tabla=="empresas"){
			msj = "Error al intentar guardar la empresa. Por favor vuelva a intentarlo";
		}else if(tabla=="edificios"){
			msj = "Error al intentar guardar el edificio. Por favor vuelva a intentarlo";
		}

		tipo='danger';
	}).always(function(){
		$(".close").click()
		messageStatus(msj,tipo);
	});
	
}
function editObject(tabla,object,td){
	const urlObjeto = URL+tabla+'/'+object.id
	const opcionesAjax = {
            url: urlObjeto,
            method: 'PUT',
            data: JSON.stringify(object),
            contentType: 'application/json',
            dataType: 'json'
        };
	let msj;
	let tipo;
	$.ajax(opcionesAjax)
	.done(function(respuesta){
		if(tabla=="paises"){
			msj= 'País con id: ' + respuesta.id + ' editado correctamente!';
			$(td).each(function(e){
				if($(this).find(".btn-warning").data("url")==urlObjeto){
					$(this).prev().html(respuesta.codigo);
					$(this).prev().prev().html(respuesta.nombre);
					return false;
				}
			});
			optionsNacionalidades();
		}else if(tabla=="personas"){
			msj= 'Persona con id: ' + respuesta.id + ' editada correctamente!';
			let nacionalidades="";
			$(td).each(function(e){
				if($(this).find(".btn-warning").data("url")==urlObjeto){
					$(respuesta._embedded.nacionalidades).each(function(key){
						nacionalidades+=this.nombre + ',';
					});
					nacionalidades = nacionalidades.substring(0,nacionalidades.length-1);
					$(this).prev().html(nacionalidades);
					$(this).prev().prev().html(respuesta.dni);
					$(this).prev().prev().prev().html(respuesta.apellidos);
					$(this).prev().prev().prev().prev().html(respuesta.nombre);
					return false;
				}
			});
			optionsPersonas();
		}else if(tabla=="empresas"){
			msj= 'Empresa con id: ' + respuesta.id + ' editada correctamente!';
			let sedes="";
			console.log(respuesta);
			$(td).each(function(e){
				if($(this).find(".btn-warning").data("url")==urlObjeto){
					$(respuesta._embedded.sedes).each(function(key){
						sedes+=this.nombre + ',';
					});
					sedes = sedes.substring(0,sedes.length-1);
					$(this).prev().html(sedes);
					$(this).prev().prev().html(respuesta._embedded.presidenteActual.nombre);
					$(this).prev().prev().prev().html(respuesta.codigoEmpresa);
					$(this).prev().prev().prev().prev().html(respuesta.nombre);
					return false;
				}
			});
		}else if(tabla=="edificios"){
			msj= 'Edificio con id: ' + respuesta.id + ' editada correctamente!';
			$(td).each(function(e){
				if($(this).find(".btn-warning").data("url")==urlObjeto){
					
					$(this).prev().html(respuesta._embedded.dueño.nombre);
					$(this).prev().prev().html(respuesta.altitud);
					$(this).prev().prev().prev().html(respuesta.longitud);
					$(this).prev().prev().prev().prev().html(respuesta.latitud);
					$(this).prev().prev().prev().prev().prev().html(respuesta.codigoEdificio);
					$(this).prev().prev().prev().prev().prev().prev().html(respuesta.nombre);
					return false;
				}
			});
			optionsEdificios();
		}

		tipo ='success';
	}).fail(function(respuesta){
		if(tabla=="paises"){
			msj = "Error al intentar editar el país con el id: " + objeto.id;
		}else if(tabla=="personas"){
			msj = "Error al intentar editar la persona con el id: " + objeto.id;
		}else if(tabla=="empresas"){
			msj = "Error al intentar editar la empresa con el id: " + objeto.id;
		}else if(tabla=="edificios"){
			msj = "Error al intentar editar el edificio con el id: " + objeto.id;
		}
		
		
		tipo='danger';
	}).always(function(respuesta){
		$(".close").click();
		messageStatus(msj,tipo);
	});
	
}
//Listar respuesta del ajax para tabla personas
function obtenerListadoPersonas(tabla,respuesta){
	let tbody= $("#"+tabla+" tbody");
	tbody.empty();
	let nacionalidades;
	let html;
	let personas = respuesta._embedded.personas;
	$(personas).each(function(key){
		nacionalidades="";
		$(this._embedded.nacionalidades).each(function(key){
			if(key==0){
				nacionalidades+=this.nombre;
			}else{
				nacionalidades+=", "+this.nombre;
			}
		});
		html=`
			<tr>
				<td>${this.nombre}</td>
				<td>${this.apellidos}</td>
				<td>${this.dni}</td>
				<td>${nacionalidades}</td>
				<td>
					<a href="#" class="btn btn-warning" data-url="${this._links.self.href}" onclick="fillFormPersonas(this);" data-toggle="modal" data-target="#ModalEditpersonas">
						<i class="fas fa-edit"></i>
					</a>
					<a href="#" class="btn btn-danger" data-url="${this._links.self.href}" onclick="deleteRegister(this);">
						<i class="fas fa-trash"></i>
					</a>
				</td>
			</tr>`;
		tbody.append(html);
	});
}
//Listar respuesta del ajax para tabla paises
function obtenerListadoPaises(tabla,respuesta){
	let tbody= $("#"+tabla+" tbody");
	tbody.empty();
	let html;
	let paises= respuesta._embedded.paises;
	$(paises).each(function(key){
		html=`
			<tr>
				<td>${this.nombre}</td>
				<td>${this.codigo}</td>
				<td>
					<a href="#" class="btn btn-warning" data-url="${this._links.self.href}" onclick="fillFormPaises(this);" data-toggle="modal" data-target="#ModalEditpaises">
						<i class="fas fa-edit"></i>
					</a>
					<a href="#" class="btn btn-danger" data-url="${this._links.self.href}" onclick="deleteRegister(this);">
						<i class="fas fa-trash"></i>
					</a>
				</td>
			</tr>`;
		tbody.append(html);
	});
}
//listar respuesta del ajax para tabla empresas
function obtenerListadoEmpresas(tabla,respuesta){
	let tbody= $("#"+tabla+" tbody");
	tbody.empty();
	let html;
	let sedes;
	let empresas= respuesta._embedded.empresas;
	$(empresas).each(function(key){
		sedes ="";
		if(this._embedded.sedes!=undefined){
			$(this._embedded.sedes).each(function(key){
				if(key==0){
					sedes+=this.nombre;
				}else{
					sedes+=", "+this.nombre;
				}
			});
		}
		html=`
			<tr>
				<td>${this.nombre}</td>
				<td>${this.codigoEmpresa}</td>
				<td>${this._embedded.presidenteActual.nombre + ' ' + this._embedded.presidenteActual.apellidos }</td>
				<td>${sedes}</td>
				<td>
					<a href="#" class="btn btn-warning" data-url="${this._links.self.href}" onclick="fillFormEmpresas(this);" data-toggle="modal" data-target="#ModalEditempresas">
						<i class="fas fa-edit"></i>
					</a>
					<a href="#" class="btn btn-danger" data-url="${this._links.self.href}" onclick="deleteRegister(this);">
						<i class="fas fa-trash"></i>
					</a>
				</td>
			</tr>`;

		tbody.append(html);
	});
}
//Listar respuesta del ajax para tabla edificios
function obtenerListadoEdificios(tabla,respuesta){
	let tbody= $("#"+tabla+" tbody");
	tbody.empty();
	let html;
	let edificios= respuesta._embedded.edificios;
	$(edificios).each(function(key){
		
		html=`
			<tr>
				<td>${this.nombre}</td>
				<td>${this.codigoEdificio}</td>
				<td>${this.latitud}</td>
				<td>${this.longitud}</td>
				<td>${this.altitud}</td>
				<td>${this._embedded.dueño.nombre}</td>
				<td>
					<a href="#" class="btn btn-warning" data-url="${this._links.self.href}" onclick="fillFormEdificios(this);" data-toggle="modal" data-target="#ModalEditedificios">
						<i class="fas fa-edit"></i>
					</a>
					<a href="#" class="btn btn-danger" data-url="${this._links.self.href}" onclick="deleteRegister(this);">
						<i class="fas fa-trash"></i>
					</a>
				</td>
			</tr>`;
		tbody.append(html);
	});
}
//Obtener pagina y hacer el ajax 
function getPage(t){
	$(".prev").removeClass("disabled");
	$(".next").removeClass("disabled");
	let page=parseInt($(t).html())-1;

	let tabla = $(".activo").data("tabla");
	pedirListadoPaginado(tabla,page);
}
//Ajax para listado de tablas
function pedirListadoPaginado(tabla,page){
	$.ajax({
		url:URL+tabla+'?page='+page+'&size='+size,
		method:'GET',
		dataType:'json'
	}).done(function(respuesta){
		$("table").each(function(e){
			if(!$(this).hasClass('dn')){
				$(this).addClass('dn');
			}
		});
		let pageAct = respuesta.page.number;
		let totalPages = respuesta.page.totalPages-1;
		$(".pages").empty();
		let paginas = "";
		for(var i=0;i<=totalPages;i++){
			if(i==pageAct){
				paginas+=`<a class="btn btn-primary act">${(i+1)}</a>`;
			}else{
				paginas+=`<a class="btn btn-primary" onclick="getPage(this)">${(i+1)}</a>`;
			}
		}
		$(".pages").html(paginas);

		if($(".pages a").length==1){
			$(".next").addClass("disabled");
			$(".prev").addClass("disabled");
		}else if((parseInt($(".pages a.act").html())-1)==totalPages){
			$(".next").addClass("disabled");
			$(".prev").removeClass("disabled");
		}else if((parseInt($(".pages a.act").html())-1)==0){
			$(".prev").addClass("disabled");
			$(".next").removeClass("disabled");
		}else{
			$(".prev").removeClass("disabled");
			$(".next").removeClass("disabled");
		}
		$("#" + tabla+",.buttons").removeClass('dn');
		$("#" + tabla).addClass('activo');
		if(tabla==='personas'){
			obtenerListadoPersonas(tabla,respuesta);
		}else if(tabla==='paises'){
			obtenerListadoPaises(tabla,respuesta);
		}else if(tabla==='empresas'){
			obtenerListadoEmpresas(tabla,respuesta);
		}else if(tabla==='edificios'){
			obtenerListadoEdificios(tabla,respuesta);
		}
	}).fail(function(respuesta){
		msj="Error al cargar el listado. Vuelve a intentarlo";
	});
}
//RELLENAR SELECT DE PAISES
function optionsNacionalidades(){
	$.ajax({
		url:URL+'paises',
		method:'GET',
		dataType:'json'
	}).done(function(respuesta){
		$(".nacionalidades").empty();
		$(respuesta._embedded.paises).each(function(key){
			$(".nacionalidades").append(`<option value="${this._links.self.href}">${this.nombre}</option>`);
		});
	}).fail(function(respuesta){
		console.log('Fallo al recargar el select de nacionalidades');
	});
}
//RELLENAR SELECT DE EMPRESAS
function optionsEmpresas(){
	$.ajax({
		url:URL+'empresas',
		method:'GET',
		dataType:'json'
	}).done(function(respuesta){
		$(".dueño").empty();
		$(respuesta._embedded.empresas).each(function(key){
			$(".dueño").append(`<option value="${this._links.self.href}">${this.nombre}</option>`);
		});
	}).fail(function(respuesta){
		console.log('Fallo al recargar el select de empresas');
	});
}
//RELLENAR SELECT DE EDIFICIOS
function optionsEdificios(){
	$.ajax({
		url:URL+'edificios',
		method:'GET',
		dataType:'json'
	}).done(function(respuesta){
		$(".sedes").empty();
		$(respuesta._embedded.edificios).each(function(key){
			$(".sedes").append(`<option value="${this._links.self.href}">${this.nombre}</option>`);
		});
	}).fail(function(respuesta){
		console.log('Fallo al recargar el select de edificios');
	});
}
//RELLENAR SELECT DE PERSONAS
function optionsPersonas(){
	
	$.ajax({
		url:URL+'personas',
		method:'GET',
		dataType:'json'
	}).done(function(respuesta){
		$(".presidenteActual").empty();
		$(respuesta._embedded.personas).each(function(key){
			$(".presidenteActual").append(`<option value="${this._links.self.href}">${this.nombre}</option>`);
		});
	}).fail(function(respuesta){
		console.log('Fallo al recargar el select de personas');
	});
}
/*BORRAR CUALQUIER REGISTRO DE CUALQUIER TABLA*/
function deleteRegister(t){
	let res= confirm("¿Estás seguro de borrar este registro?");
	let msj;
	let tipo;
	if(res){
		$.ajax({
			url:$(t).data("url"),
			method:'DELETE',
			contentType: "application/json"
		}).done(function(respuesta){
			$(t).parent().parent().remove();
			msj='Registro eliminado existosamente';
			tipo='success';
			messageStatus(msj,tipo);
		}).fail(function(respuesta){
			msj='Error al eliminar el registro. Vuelve a intentarlo';
			tipo='danger';
			messageStatus(msj,tipo);
		});
		
	}else{
		
	}
	
}
function fillFormPersonas(t){
	$.ajax({
		url:$(t).data("url"),
		method:'GET',
		contentType: "application/json"
	}).done(function(respuesta){
		$("#form-edit-persona")[0].reset();
		$("#form-edit-persona #nombre").val(respuesta.nombre);
		$("#form-edit-persona #apellidos").val(respuesta.apellidos);
		$("#form-edit-persona #dni").val(respuesta.dni);
		$("#form-edit-persona #id-persona").val(respuesta.id);
		var nacionalidad;
		$(respuesta._embedded.nacionalidades).each(function(key){
			nacionalidad=this;
			$("#form-edit-persona #nacionalidades option").each(function(key2){
				if($(this).html()==nacionalidad.nombre){
					$(this).attr("selected",true);
	
				}
			});
		});
	}).fail(function(respuesta){
		let msj="No se pudo cargar el registro";
		let tipo="danger";
		messageStatus(msj,tipo);
	});
}
function fillFormPaises(t){
	$.ajax({
		url:$(t).data("url"),
		method:'GET',
		contentType: "application/json"
	}).done(function(respuesta){
		$("#form-edit-pais #nombre").val(respuesta.nombre);
		$("#form-edit-pais #codigo").val(respuesta.codigo);
		$("#form-edit-pais #id-pais").val(respuesta.id);
	}).fail(function(respuesta){
		let msj="No se pudo cargar el registro";
		let tipo="danger";
		messageStatus(msj,tipo);
	});
}
function fillFormEmpresas(t){
	$.ajax({
		url:$(t).data("url"),
		method:'GET',
		contentType: "application/json"
	}).done(function(respuesta){
		$("#form-edit-empresa")[0].reset();
		$("#form-edit-empresa #id-empresa").val(respuesta.id);
		$("#form-edit-empresa #nombre").val(respuesta.nombre);
		$("#form-edit-empresa #codigoEmpresa").val(respuesta.codigoEmpresa);
		$("#form-edit-empresa #presidenteActual").val(respuesta.presidenteActual);
		let presidenteActual = respuesta._embedded.presidenteActual.nombre;
		$("#form-edit-empresa #presidenteActual option").each(function(key2){
			if($(this).html()==presidenteActual){
				$(this).attr("selected",true);

			}else{
				$(this).attr("selected",false);
			}
		});
		let sede;
		$(respuesta._embedded.sedes).each(function(key){
			sede=this;
			$("#form-edit-empresa #sedes option").each(function(key2){
				if($(this).html()==sede.nombre){
					$(this).attr("selected",true);
	
				}
			});
		});
	}).fail(function(respuesta){
		let msj="No se pudo cargar el registro";
		let tipo="danger";
		messageStatus(msj,tipo);
	});
}
function fillFormEdificios(t){
	$.ajax({
		url:$(t).data("url"),
		method:'GET',
		contentType: "application/json"
	}).done(function(respuesta){
		$("#form-edit-edificio")[0].reset();
		$("#form-edit-edificio #id-edificio").val(respuesta.id);
		$("#form-edit-edificio #nombre").val(respuesta.nombre);
		$("#form-edit-edificio #codigoEdificio").val(respuesta.codigoEdificio);
		$("#form-edit-edificio #latitud").val(respuesta.latitud);
		$("#form-edit-edificio #longitud").val(respuesta.longitud);
		$("#form-edit-edificio #altitud").val(respuesta.altitud);
		$("#form-edit-edificio #dueño").val(respuesta.dueño);
		let dueño = respuesta._embedded.dueño.nombre;
			$("#form-edit-edificio #dueño option").each(function(key2){
				if($(this).html()==dueño){
					$(this).attr("selected",true);
	
				}else{
					$(this).attr("selected",false);
				}
			});
	}).fail(function(respuesta){
		let msj="No se pudo cargar el registro";
		let tipo="danger";
		messageStatus(msj,tipo);
	});
}
function messageStatus(msj,tipo){
	if($(".alert-dismissible").length!=0){
		$(".alert-dismissible").remove();
	}
	$(".title").before(`<div class="alert alert-${tipo} alert-dismissible fade show" role="alert">
								  ${msj}
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
								  	<span aria-hidden="true">&times;</span>
								  </button>
							  </div>`);
}
