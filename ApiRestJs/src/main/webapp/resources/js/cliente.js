'use strict';
var URL = 'http://localhost:8080/api/';
$(function(){
	//OBTENER LISTADO DE CUALQUIER TABLA
		//Se obtiene el attributo data-tabla del boton q se pulse y se añade a la url
		var page=1;
		var size=1;
	$(".nav-item:not(:first-child),.next,.prev").on("click",function(e){

		//Termianr de arreglar
		if($(".activo").length==1 && ){
			var tabla = $(".activo").data("tabla");
			var indpage=parseInt($(".page-actual").html());
			if($(this).hasClass("next")){
				page=indpage+1;
			}else{

				page=indpage-1;
			}
			if(page==0 && !$(".prev").hasClass('disabled')){
				$(".prev").addClass('disabled');
			}else{
				if($(".prev").hasClass('disabled')){
					$(".prev").removeClass('disabled');
				}
			}
			
		}else{
			var tabla= $(this).data("tabla");
			page=0;
		}
		
		console.log($(".activo"));
		console.log(page);
		$(".title").text('Listado de '+ tabla)
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
			$("#" + tabla+",.buttons").removeClass('dn');
			$("#" + tabla).addClass('activo');
			$(".page-actual").html(page++);
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
			alert('Fallo al cargar los datos')
		});
	});
});

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
function obtenerListadoPaises(tabla,respuesta){
	var tbody= $("#"+tabla+" tbody");
	tbody.empty();
	$(respuesta._embedded.paises).each(function(key){
		tbody.append("<tr></tr>");
		tbody.find('tr').last().append('<td>' + this.nombre + '</td><td>' + this.codigo + ' </td>');
		
		tbody.find("tr").last().append('<td><a href="#" class="btn btn-warning"><i class="fas fa-edit"></i></a><a href="#" class="btn btn-danger"><i class="fas fa-trash"></i></a></td>');
	});
}
function obtenerListadoEmpresas(tabla,respuesta){
	var tbody= $("#"+tabla+" tbody");
	tbody.empty();
	$(respuesta._embedded.empresas).each(function(key){
		var sedes ="";
		console.log(this);
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