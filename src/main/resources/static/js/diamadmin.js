$(document).ready(function(){

    //NAVBAR
    //Ocultar navbar
    if($('#location').val() == "login") {
      $('.bd-navbar').addClass('d-none');
    }
    //Ocultar dropdown administración
    if($('#location').val() == "home") {
      $('.dd_administracion').addClass('d-none');
    }

    //USUARIOS
    //Doble click para editar usuarios
    $('.filaUsuarios').dblclick(function(){
      $(location).attr('href', "/app/usuarios/detalle/" + $(this).text().trim().charAt(0));
    });
    
    //ANIMACIONES
});
