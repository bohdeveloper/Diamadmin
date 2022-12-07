$(document).ready(function(){

    //USUARIOS
    
    //Doble click para editar usuarios
    $('.filaUsuarios').dblclick(function(){
      $(location).attr('href', "/app/usuarios/detalle/" + $(this).text().trim().charAt(0));
    });
    
});