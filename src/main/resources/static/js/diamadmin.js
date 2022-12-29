$(document).ready(function(){

    //NAVBAR
    //Ocultar navbar
    if($('#location').val() == "login" || $('#location').val() == "signup") {
      $('.bd-navbar').addClass('d-none');
    }
    
    //REGISTRO
    //Ocultar/Mostrar grupos
    $('#singup-email-group').hide();
    $('#singup-username-group').hide();
    $('#singup-password-group').hide();
    $('.g-recaptcha').hide();
    $('#continuar1').hide();
	$('#continuar2').hide();
	$('#continuar3').hide();
	$('#signup-ok').hide();
    
    $('#singup-email').click(function(){
    	$('#continuar1').show();
    	$('#continuar2').hide();
		$('#continuar3').hide();
    });
    $('#continuar1').click(function(){
    	//Comprobar si el campo singup-email esta vacio
    	if($('#singup-email').val() != ''){
    		$('#error-email-vacio').hide();
			//Comprobar si el email es valido
			//Comprobar si el email ya existe
			
			//Cambio aspecto del input y mostrar siguiente grupo
			$('#singup-email').removeClass('signup-input-ko');
			$('#singup-email').addClass('signup-input-ok');
	    	$('#continuar1').hide();
	    	$('#singup-username-group').show();
	    	$('#continuar2').show();
    	} else {
    		$('#singup-email').removeClass('signup-input-ok');
    		$('#singup-email').addClass('signup-input-ko');
    		$('#error-email-vacio').show();
    		$('#continuar2').hide();
			$('#continuar3').hide();
    	}
    });
    
    $('#singup-username').click(function(){
    	if($('#singup-email').val() != ''){
    		$('#continuar1').hide();
    		$('#continuar2').show();
    		$('#continuar3').hide();
		}    	
    });
    $('#continuar2').click(function(){
    	//Comprobar si el campo singup-username esta vacio
    	if($('#singup-username').val() != ''){
    		$('#error-username-vacio').hide();
    		//Comprobar si el usuario es valido
			//Comprobar si el nombre de usuario ya existe
			
			//Cambio aspecto del input y mostrar siguiente grupo
			$('#singup-username').removeClass('signup-input-ko');
			$('#singup-username').addClass('signup-input-ok');
	    	$('#continuar2').hide();
	    	$('#singup-password-group').show();
	    	$('#continuar3').show();
    	} else {
    		$('#singup-username').removeClass('signup-input-ok');
    		$('#singup-username').addClass('signup-input-ko');
    		$('#error-username-vacio').show();
			$('#continuar3').hide();
    	}
    });
    
    $('#singup-password').click(function(){
    	if($('#singup-email').val() != '' && $('#singup-username').val() != ''){
    		$('#continuar1').hide();
    		$('#continuar2').hide();
    		$('#continuar3').show();
    	}
    });
    $('#continuar3').click(function(){
    	//Comprobar si el campo singup-password esta vacio
    	if($('#singup-password').val() != ''){
    		$('#error-password-vacio').hide();
			//Comprobar si el password cumple los requisitos
			
			//Cambio aspecto del input y mostrar siguiente grupo
			$('#singup-password').removeClass('signup-input-ko');
			$('#singup-password').addClass('signup-input-ok');
	    	$('#continuar3').hide();
	    	$('.g-recaptcha').show();
	    	$('#signup-ok').show();
    	} else {
    		$('#singup-password').removeClass('signup-input-ok');
    		$('#singup-password').addClass('signup-input-ko');
    		$('#error-password-vacio').show();
    	}
    });

    //USUARIOS
    //Doble click para editar usuarios
    $('.filaUsuarios').dblclick(function(){
      $(location).attr('href', "/app/usuarios/detalle/" + $(this).text().trim().charAt(0));
    });
    
    //ANIMACIONES
    //Escribiendo texto en registro de usuarios (signup)
    if($('#location').val() == "signup") {
		async function writeAnimation(DOMElement, delay, errorMargin = 0) {
		  
		    function wait(ms) {
		      return new Promise(resolve => setTimeout(resolve, ms));
		    }
		
		    //You can set the speed of the animaiton in ms with the delay property
		    // Put a number between 0 and 100 to set the posibility of making typos
		
		    //'selected' elements get that blinking underscore at the end with CSS
		    DOMElement.classList.add('selected')
		
		    DOMElement.finalText = DOMElement.textContent
		    DOMElement.finalINNERHTML = DOMElement.innerHTML
		    DOMElement.textContent = '';
		    DOMElement.style.opacity = 1;
		    await wait(delay * 30)
			
		    let i = 0;
		
		    //animation loop.
		    while (DOMElement.textContent != DOMElement.finalText) {
		
		        if (DOMElement.finalText[i] == undefined || DOMElement.hasBeenAnimated == true) {
		
		            //in case something goes wrong, this will prevent an infinite loop
		            //you can skip the animation anytime by setting hasBeenAnimated on the dom element to true.
		
		            DOMElement.textContent = DOMElement.finalText
		            DOMElement.classList.remove('selected')
		            break;
		        }
		
		        DOMElement.textContent += DOMElement.finalText[i]
		        i++;
				
		        //Sometimes there are some mistakes when you are writing. This is a little bit high to Change this to something like 0.007
		        if (Math.random() < errorMargin / 100) {
		
		            //add two random letters
		            DOMElement.textContent += randomLetter();
		            await wait(delay * 5);
		            DOMElement.textContent += randomLetter();
		            await wait(delay * 2);
		
		            //erase them
		            DOMElement.textContent = DOMElement.textContent.substring(0, DOMElement.textContent.length - 1)
		            await wait(delay * 5);
		            DOMElement.textContent = DOMElement.textContent.substring(0, DOMElement.textContent.length - 1)
		            await wait(delay * 5);
		
		        }
		        await wait(delay)
		    }
		    DOMElement.innerHTML = DOMElement.finalINNERHTML;
		    DOMElement.classList.remove('selected')
		}
		
		function randomLetter() {
		    let letters = "abcdefghijklmnñopqrstuvwxyz";
		    return letters[Math.floor(Math.random() * letters.length)]
		}
			
		const animText1 = document.querySelector('.animText1')
		const animText2 = document.querySelector('.animText2')
		
		//you can use an async function to animate one element at a time
		async function animateAll () {
		  await writeAnimation(animText1, 30, 1)
		  await writeAnimation(animText2, 30, 1)
		  $('#singup-email-group').show();
		  $('#continuar1').show();
		};
		
		animateAll();
    }
    
    
});