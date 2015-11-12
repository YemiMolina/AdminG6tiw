function usuarioActual() {
	document.getElementById("WelcomeUser").innerHTML = "<span style='color:white; font-size:25px'>Bienvenido(a), " +  localStorage.getItem("currentUser") + "</span>";
}


function check(){

	document.getElementById('oferta1').style.display="block";
	document.getElementById('oferta2').style.display="block";
	document.getElementById('oferta3').style.display="block";
	document.getElementById('oferta4').style.display="block";

	if(document.getElementById("basico").checked==false){
		document.getElementById('oferta1').style.display="none";
		document.getElementById('oferta3').style.display="none";
	}

	if(document.getElementById("avanzado").checked==false){
		document.getElementById('oferta2').style.display="none";
		document.getElementById('oferta4').style.display="none";
	}

	if(document.getElementById("corta").checked==false){
		document.getElementById('oferta1').style.display="none";
		document.getElementById('oferta2').style.display="none";
		document.getElementById('oferta3').style.display="none";
	}

	if(document.getElementById("larga").checked==false){
		document.getElementById('oferta4').style.display="none";
	}

	if(document.getElementById("sin").checked==false){

	}

	if(document.getElementById("uno").checked==false){
		document.getElementById('oferta2').style.display="none";
		document.getElementById('oferta4').style.display="none";
	}
	if(document.getElementById("tres").checked==false){
		document.getElementById('oferta1').style.display="none";
		document.getElementById('oferta3').style.display="none";
	}


	

}