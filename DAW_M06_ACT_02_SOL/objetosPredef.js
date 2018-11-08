/*2 Dentro de index.html añade un div con id “listaPropiedades”. 
 * Utiliza la función onload de window para que una vez cargado 
 * todo el HTML se llame a una función que cree dentro 
 * de “listaPropiedades” una lista desordenada HTML 
 * ( <UL> <LI></LI> .... </UL>) como la mostrada a continuación y rellenada con los valores obtenidos*/
window.onload = function () {
    var hoy = new Date();
    dia = hoy.getDate();
    mes = hoy.getMonth();
    year = hoy.getFullYear();
    hora = hoy.getHours();
    minuto = hoy.getMinutes();

    document.getElementById('listaPropiedades').innerHTML =
            "<ul> <li>Valor máximo que puede tener un número en JavaScript: " + Number.MAX_VALUE + "</li>"
            + "<li> Valor mínimo que puede tener un número en JavaScript: " + Number.MIN_VALUE + "</li>"
            + "<li> Altura total de la pantalla: " + window.screen.height + "</li>"
            + "<li> Anchura total de la pantalla: " + window.screen.width + "</li>"
            + "<li> Altura interna " + window.innerHeight + "</li>"
            + "<li>  Anchura interna : " + window.innerWidth + "</li>"
            + "<li>  URL de la página web: " + document.location.href + "</li>"
            + "<li> Título de la página web : " + document.title + "</li>"
            + "<li> Un valor aleatorio entre 0 y 200 (utiliza el objeto Math): " + Math.floor((Math.random() * 200)) + "</li>"
            + "<li> La fecha actual es: " + dia + "-" + mes + "-" + year + "</li>"
            + "<li> La hora actual es: " + hora + ":" + minuto + "</li>"
            + "</ul>";
    
    /*4.	Programa que al cargar la web, el valor  del input con id “nombre” sea el valor guardado en la cookie “nombre_usuario”.*/
    var nombre=  document.cookie;
    var posicion = nombre.lastIndexOf("=");
    nombre = nombre.substring(posicion+1, nombre.length);
    document.getElementById("nombre").value =nombre;
    


};

/**establezca como valor de la cookie “nombre_usuario”
 el texto introducido por el usuario dentro del input.
 * 
 * @returns {undefined}
 */
function setCookie() {
    var nombre = document.getElementById("nombre").value;
    document.cookie = "nombre_usuario=" + nombre;
}

/**
 * 5.	Añade al HTML un botón con el texto “ACIERTA NUMERO”. 
 * Programa que al clicarlo se abra una nueva ventana “numero.html” y que 
 * pasados 15 segundos la ventana se cierre.
 */
function openAciertaNumero(){
    var anchuraPAntalla = window.screen.width/2;
    var alturaPAntalla= window.screen.height/2;
    var posicionTop= alturaPAntalla-300;
    var posicionLeft= anchuraPAntalla-300;
    ventanaAciertaNumero = window.open("numero.html","","width=300,height=300,menubar=no,left="+posicionLeft+",top="+posicionTop);
    //ventanaAciertaNumero = window.open("numero.html","","width=300,height=300;menubar=no;left=0");
    window.setTimeout(function(){
        ventanaAciertaNumero.close();
    },20000)
}
var ventanaAciertaNumero;