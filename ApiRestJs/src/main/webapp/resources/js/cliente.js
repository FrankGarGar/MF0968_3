'use strict';
var URL = 'http://localhost:8080/api/';
var page=0;
var size=2;
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
	$(".nav-item:not(:first-child)").on("click",function(e){
		$(".activo").removeClass("activo");
		$(".prev").removeClass("disabled");
		$(".next").removeClass("disabled");
		
		var tabla= $(this).data("tabla");
		$(".title").html('Listado de '+ tabla + '<a class="pa" data-toggle="modal" data-target="#Modal'+ tabla + '"><i class="fas fa-plus"></i></a>');
		
		hacerAjax(tabla,page);
	});
	$("#form-pais").submit(function(e){
		e.preventDefault();
		var tabla = "paises";

		var nombre = $(this).find("#nombre").val();
		var codigo = $(this).find("#codigo").val();
		var pais = {nombre,codigo};
		if(saveObject(tabla,pais)){
			$("#form-pais")[0].reset();
			$(".close").click();
			$(".nav-item:nth-child(4)").click();
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
			$("#form-persona")[0].reset();
			$(".close").click();
			$(".nav-item:nth-child(2)").click();
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
			$("#form-persona")[0].reset();
			$(".close").click();
			$(".nav-item:nth-child(3)").click();
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
			$("#form-persona")[0].reset();
			$(".close").click();
			$(".nav-item:nth-child(5)").click();
			optionsEmpresas();
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
//Listar respuesta del ajax para tabla personas
function obtenerListadoPersonas(tabla,respuesta){
	var tbody= $("#"+tabla+" tbody");
	tbody.empty();
	$(respuesta._embedded.personas).each(function(key){
		var nacionalidades="";
		tbody.append("<tr></tr>");
		tbody.find('tr').last().append('<td>' + this.nombre + '</td><td>' + this.apellidos + ' </td><td>' + this.dni + '</td>');
		
		$(this._embedded.nacionalidades).each(function(key){
			if(key==0){
				nacionalidades+=this.nombre;
			}else{
				nacionalidades+=", "+this.nombre;
			}
		});

		tbody.find("tr").last().append('<td>' + nacionalidades + '</td>');
		tbody.find("tr").last().append('<td><a href="#" class="btn btn-warning"><i class="fas fa-edit"></i></a><a href="#" class="btn btn-danger"><i class="fas fa-trash"></i></a></td>');
	});
}
//Listar respuesta del ajax para tabla paises
function obtenerListadoPaises(tabla,respuesta){
	var tbody= $("#"+tabla+" tbody");
	tbody.empty();
	$(respuesta._embedded.paises).each(function(key){
		tbody.append("<tr></tr>");
		tbody.find('tr').last().append('<td>' + this.nombre + '</td><td>' + this.codigo + ' </td>');
		
		tbody.find("tr").last().append('<td><a href="#" class="btn btn-warning"><i class="fas fa-edit"></i></a><a href="#" class="btn btn-danger"><i class="fas fa-trash"></i></a></td>');
	});
}
//listar respuesta del ajax para tabla empresas
function obtenerListadoEmpresas(tabla,respuesta){
	var tbody= $("#"+tabla+" tbody");
	tbody.empty();
	$(respuesta._embedded.empresas).each(function(key){
		var sedes ="";
		tbody.append("<tr></tr>");
		tbody.find('tr').last().append('<td>' + this.nombre + '</td><td>' + this.codigoEmpresa + ' </td><td>' + this._embedded.presidenteActual.nombre + ' ' + this._embedded.presidenteActual.apellidos + '</td>');
		if(this._embedded.sedes!=undefined){
			$(this._embedded.sedes).each(function(key){
				if(key==0){
					sedes+=this.nombre;
				}else{
					sedes+=", "+this.nombre;
				}
			});
		}
		tbody.find("tr").last().append('<td>' + sedes + '</td>');
		tbody.find("tr").last().append('<td><a href="#" class="btn btn-warning"><i class="fas fa-edit"></i></a><a href="#" class="btn btn-danger"><i class="fas fa-trash"></i></a></td>');
	});
}
//Listar respuesta del ajax para tabla edificios
function obtenerListadoEdificios(tabla,respuesta){
	var tbody= $("#"+tabla+" tbody");
	tbody.empty();
	$(respuesta._embedded.edificios).each(function(key){
		//para el link de la entidad = this._links.self.href
		tbody.append('<tr></tr>');
		tbody.find('tr').last().append('<td>' + this.nombre + '</td><td>' + this.codigoEdificio + ' </td><td>' + this.latitud + '</td><td>' + this.longitud + '</td><td>' + this.altitud + '</td><td>' + this._embedded.dueño.nombre + '</td>');

		tbody.find("tr").last().append('<td><a href="#" class="btn btn-warning"><i class="fas fa-edit"></i></a><a href="#" class="btn btn-danger"><i class="fas fa-trash"></i></a></td>');
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
				paginas+='<a class="btn btn-primary act">' + (i+1) + '</a>';
			}else{
				paginas+='<a class="btn btn-primary" onclick="getPage(this)">' + (i+1) + '</a>';
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
function optionsNacionalidades(){
	$.ajax({
		url:URL+'paises',
		method:'GET',
		dataType:'json'
	}).done(function(respuesta){
		$("#nacionalidades").empty();
		$(respuesta._embedded.paises).each(function(key){
			$("#nacionalidades").append('<option value="' + this._links.self.href + '">' + this.nombre + '</option>');
		});
	}).fail(function(respuesta){
		alert('Fallo al cargar los datos');
	});
}
function optionsEmpresas(){
	$.ajax({
		url:URL+'empresas',
		method:'GET',
		dataType:'json'
	}).done(function(respuesta){
		$("#dueño").empty();
		$(respuesta._embedded.empresas).each(function(key){
			$("#dueño").append('<option value="' + this._links.self.href + '">' + this.nombre + '</option>');
		});
	}).fail(function(respuesta){
		alert('Fallo al cargar los datos');
	});
}
function optionsEdificios(){
	$.ajax({
		url:URL+'edificios',
		method:'GET',
		dataType:'json'
	}).done(function(respuesta){
		$("#sedes").empty();
		$(respuesta._embedded.edificios).each(function(key){
			$("#sedes").append('<option value="' + this._links.self.href + '">' + this.nombre + '</option>');
		});
	}).fail(function(respuesta){
		alert('Fallo al cargar los datos');
	});
}
function optionsPersonas(){
	
	$.ajax({
		url:URL+'personas',
		method:'GET',
		dataType:'json'
	}).done(function(respuesta){
		$("#presidenteActual").empty();
		$(respuesta._embedded.personas).each(function(key){
			$("#presidenteActual").append('<option value="' + this._links.self.href + '">' + this.nombre + '</option>');
		});
	}).fail(function(respuesta){
		alert('Fallo al cargar los datos');
	});
}