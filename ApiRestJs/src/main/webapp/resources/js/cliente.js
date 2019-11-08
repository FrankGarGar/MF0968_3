'use strict';
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
		hacerAjax(tabla,page);
	});
	/*BUSCADOR DE LETRAS NUMS Y SIMBOLOS TOLERANTE DE MAYUSCULAS Y MINUSCULAS*/
	$(".search").keyup(function(e){
		var valor= $(this).val().toLowerCase();
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
	});
	$(".nav-item:not(:first-child)").on("click",function(e){
		$(".activo").removeClass("activo");
		$(".prev").removeClass("disabled");
		$(".next").removeClass("disabled");
		
		var tabla= $(this).data("tabla");
		var html=`Listado de ${tabla} <a class="pa" data-toggle="modal" data-target="#Modal${tabla}"><i class="fas fa-plus"></i></a>`;
		$(".title").html(html);
		
		hacerAjax(tabla,page);
	});
	$("#form-pais").submit(function(e){
		e.preventDefault();
		var tabla = "paises";

		var nombre = $(this).find("#nombre").val();
		var codigo = $(this).find("#codigo").val();
		var pais = {nombre,codigo};
		if(saveObject(tabla,pais)){
			optionsNacionalidades();
		}else{
			
		}
		
	});
	$("#form-persona").submit(function(e){
		e.preventDefault();
		var tabla = "personas";

		var nombre = $(this).find("#nombre").val();
		var apellidos = $(this).find("#apellidos").val();
		var dni = $(this).find("#dni").val();
		var nacionalidades = $(this).find("#nacionalidades").val();
		
		var persona = {nombre,apellidos,dni,nacionalidades};
		if(saveObject(tabla,persona)){
			optionsPersonas();
		}else{
			
		}
	});
	$("#form-edificio").submit(function(e){
		e.preventDefault();
		var tabla = "edificios";

		var nombre = $(this).find("#nombre").val();
		var codigoEdificio = $(this).find("#codigoEdificio").val();
		var latitud = $(this).find("#latitud").val();
		var longitud = $(this).find("#longitud").val();
		var altitud = $(this).find("#altitud").val();
		var dueño = $(this).find("#dueño").val();
		var edificio = {nombre,codigoEdificio,latitud,longitud,altitud,dueño};
		if(saveObject(tabla,edificio)){
			optionsEdificios();
		}else{
			
		}
	});
	$("#form-empresa").submit(function(e){
		e.preventDefault();
		var tabla = "empresas";

		var nombre = $(this).find("#nombre").val();
		var codigoEmpresa = $(this).find("#codigoEmpresa").val();
		var presidenteActual = $(this).find("#presidenteActual").val();
		var sedes = $(this).find("#sedes").val();
		var edificio = {nombre,codigoEmpresa,presidenteActual,sedes};
		if(saveObject(tabla,edificio)){
			optionsEmpresas();
		}else{
			
		}
	});
	$("#form-edit-pais").submit(function(e){
		e.preventDefault();
		var tabla = $(this).find("#id-pais").val();
		var nombre = $(this).find("#nombre").val();
		var codigo = $(this).find("#codigo").val();
		var pais = {nombre,codigo};
		if(editObject(tabla,pais)){
			optionsNacionalidades();
		}else{
			
		}
		
	});
	$("#form-edit-persona").submit(function(e){
		e.preventDefault();
		var tabla = $(this).find("#id-persona").val();
		var nombre = $(this).find("#nombre").val();
		var apellidos = $(this).find("#apellidos").val();
		var dni = $(this).find("#dni").val();
		var nacionalidades = $(this).find("#nacionalidades").val();
		
		var persona = {nombre,apellidos,dni,nacionalidades};
		if(editObject(tabla,persona)){
			optionsPersonas();
		}else{
			
		}
	});
	$("#form-edit-edificio").submit(function(e){
		e.preventDefault();
		var tabla = $(this).find("#id-edificio").val();
		var nombre = $(this).find("#nombre").val();
		var codigoEdificio = $(this).find("#codigoEdificio").val();
		var latitud = $(this).find("#latitud").val();
		var longitud = $(this).find("#longitud").val();
		var altitud = $(this).find("#altitud").val();
		var dueño = $(this).find("#dueño").val();
		var edificio = {nombre,codigoEdificio,latitud,longitud,altitud,dueño};
		if(editObject(tabla,edificio)){
			optionsEdificios();
		}else{
			
		}
	});
	$("#form-edit-empresa").submit(function(e){
		e.preventDefault();
		var tabla = $(this).find("#id-empresa").val();

		var nombre = $(this).find("#nombre").val();
		var codigoEmpresa = $(this).find("#codigoEmpresa").val();
		var presidenteActual = $(this).find("#presidenteActual").val();
		var sedes = $(this).find("#sedes").val();
		var edificio = {nombre,codigoEmpresa,presidenteActual,sedes};
		if(editObject(tabla,edificio)){
			optionsEmpresas();
			console.log($(".activo tbody tr td:last-child"));
		}else{
			
		}
	});
});
function saveObject(tabla,object){
	var opcionesAjax = {
            url: URL+tabla,
            method: 'POST',
            data: JSON.stringify(object),
            contentType: 'application/json',
            dataType: 'json'
        };
	$.ajax(opcionesAjax)
	.done(function(respuesta){
		$(".close").click();
		return true;
	}).fail(function(respuesta){
		alert('Fallo al guardar el/la ' + tabla);
		return false;
	});
}
function editObject(tabla,object){
	var opcionesAjax = {
            url: tabla,
            method: 'PUT',
            data: JSON.stringify(object),
            contentType: 'application/json',
            dataType: 'json'
        };
	$.ajax(opcionesAjax)
	.done(function(respuesta){
		$(".close").click();
		$(".pages .act").click();
		return true;
	}).fail(function(respuesta){
		alert('Fallo al guardar el/la ' + tabla);
		return false;
	});
}
//Listar respuesta del ajax para tabla personas
function obtenerListadoPersonas(tabla,respuesta){
	var tbody= $("#"+tabla+" tbody");
	tbody.empty();
	var nacionalidades;
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
					<a href="#" class="btn btn-warning" data-url="' + this._links.self.href + '" onclick="fillFormPersonas(this);" data-toggle="modal" data-target="#ModalEditpersonas">
						<i class="fas fa-edit"></i>
					</a>
					<a href="#" class="btn btn-danger" data-url="' + this._links.self.href + '" onclick="deleteRegister(this);">
						<i class="fas fa-trash"></i>
					</a>
				</td>
			</tr>`;
		tbody.append(html);
	});
}
//Listar respuesta del ajax para tabla paises
function obtenerListadoPaises(tabla,respuesta){
	var tbody= $("#"+tabla+" tbody");
	tbody.empty();
	let html;
	let paises= respuesta._embedded.paises;
	$(paises).each(function(key){
		html=`
			<tr>
				<td>${this.nombre}</td>
				<td>${this.codigo}</td>
				<td>
					<a href="#" class="btn btn-warning" data-url="' + this._links.self.href + '" onclick="fillFormPaises(this);" data-toggle="modal" data-target="#ModalEditpaises">
						<i class="fas fa-edit"></i>
					</a>
					<a href="#" class="btn btn-danger" data-url="' + this._links.self.href + '" onclick="deleteRegister(this);">
						<i class="fas fa-trash"></i>
					</a>
				</td>
			</tr>`;
		tbody.append(html);
	});
}
//listar respuesta del ajax para tabla empresas
function obtenerListadoEmpresas(tabla,respuesta){
	var tbody= $("#"+tabla+" tbody");
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
					<a href="#" class="btn btn-warning" data-url="' + this._links.self.href + '" onclick="fillFormEmpresas(this);" data-toggle="modal" data-target="#ModalEditempresas">
						<i class="fas fa-edit"></i>
					</a>
					<a href="#" class="btn btn-danger" data-url="' + this._links.self.href + '" onclick="deleteRegister(this);">
						<i class="fas fa-trash"></i>
					</a>
				</td>
			</tr>`;

		tbody.append(html);
	});
}
//Listar respuesta del ajax para tabla edificios
function obtenerListadoEdificios(tabla,respuesta){
	var tbody= $("#"+tabla+" tbody");
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
				<td>${sedes}</td>
				<td>
					<a href="#" class="btn btn-warning" data-url="' + this._links.self.href + '" onclick="fillFormEmpresas(this);" data-toggle="modal" data-target="#ModalEditempresas">
						<i class="fas fa-edit"></i>
					</a>
					<a href="#" class="btn btn-danger" data-url="' + this._links.self.href + '" onclick="deleteRegister(this);">
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
	var page=parseInt($(t).html())-1;

	var tabla = $(".activo").data("tabla");
	hacerAjax(tabla,page);
}
//Ajax para listado de tablas
function hacerAjax(tabla,page){
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
		var pageAct = respuesta.page.number;
		var totalPages = respuesta.page.totalPages-1;
		$(".pages").empty();
		var paginas = "";
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
		alert('Fallo al cargar los datos');
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
		alert('Fallo al cargar los datos');
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
		alert('Fallo al cargar los datos');
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
		alert('Fallo al cargar los datos');
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
		alert('Fallo al cargar los datos');
	});
}
/*BORRAR CUALQUIER REGISTRO DE CUALQUIER TABLA*/
function deleteRegister(t){
	var res= confirm("¿Estás seguro de borrar este registro?");
	if(res){
		$.ajax({
			url:$(t).data("url"),
			method:'DELETE',
			contentType: "application/json"
		}).done(function(respuesta){
			$(t).parent().parent().remove();
		}).fail(function(respuesta){
			alert('Fallo al cargar Eliminar el registro');
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
		$("#form-edit-persona #id-persona").val(respuesta._links.self.href);
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
		alert('Fallo al cargar Eliminar el registro');
	});
}
function fillFormPaises(t){
	$.ajax({
		url:$(t).data("url"),
		method:'GET',
		contentType: "application/json"
	}).done(function(respuesta){
		console.log(respuesta);
		$("#form-edit-pais #nombre").val(respuesta.nombre);
		$("#form-edit-pais #codigo").val(respuesta.codigo);
		$("#form-edit-pais #id-pais").val(respuesta._links.self.href);
	}).fail(function(respuesta){
		alert('Fallo al cargar Eliminar el registro');
	});
}
function fillFormEmpresas(t){
	$.ajax({
		url:$(t).data("url"),
		method:'GET',
		contentType: "application/json"
	}).done(function(respuesta){
		$("#form-edit-empresa #id-empresa").val(respuesta._links.self.href);
		$("#form-edit-empresa #nombre").val(respuesta.nombre);
		$("#form-edit-empresa #codigoEmpresa").val(respuesta.codigoEmpresa);
		$("#form-edit-empresa #presidenteActual").val(respuesta.presidenteActual);
		var presidenteActual = respuesta._embedded.presidenteActual.nombre;
		$("#form-edit-empresa #presidenteActual option").each(function(key2){
			if($(this).html()==presidenteActual){
				$(this).attr("selected",true);

			}else{
				$(this).attr("selected",false);
			}
		});
		var sede;
		$(respuesta._embedded.sedes).each(function(key){
			sede=this;
			$("#form-edit-empresa #sedes option").each(function(key2){
				if($(this).html()==sede.nombre){
					$(this).attr("selected",true);
	
				}
			});
		});
	}).fail(function(respuesta){
		alert('Fallo al cargar Eliminar el registro');
	});
}
function fillFormEdificios(t){
	$.ajax({
		url:$(t).data("url"),
		method:'GET',
		contentType: "application/json"
	}).done(function(respuesta){
		$("#form-edit-edificio #id-edificio").val(respuesta._links.self.href);
		$("#form-edit-edificio #nombre").val(respuesta.nombre);
		$("#form-edit-edificio #codigoEdificio").val(respuesta.codigoEdificio);
		$("#form-edit-edificio #latitud").val(respuesta.latitud);
		$("#form-edit-edificio #longitud").val(respuesta.longitud);
		$("#form-edit-edificio #altitud").val(respuesta.altitud);
		$("#form-edit-edificio #dueño").val(respuesta.dueño);
		var dueño = respuesta._embedded.dueño.nombre;
			$("#form-edit-edificio #dueño option").each(function(key2){
				if($(this).html()==dueño){
					$(this).attr("selected",true);
	
				}else{
					$(this).attr("selected",false);
				}
			});
	}).fail(function(respuesta){
		alert('Fallo al cargar Eliminar el registro');
	});
}
