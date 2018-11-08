console.log("éste mensaje se muestra por consola");

var saludo = " HOLA! ";
//mostramos en el HTML el valor de la variable texto definida en el HTML
window.document.write("mostramos en el HTML el valor de la variable saludo:"+saludo);

//accedemos al elemento con id "titulo" para que contenga el valor "TITULO MODIFICADO"
document.getElementById("titulo").innerHTML="TITULO MODIFICADO";

//accedemos al elemento con id "contenido" para que contenga el valor "TEXTO NUEVO"
document.getElementById("contenido").innerHTML="Vamos a selecc";

/**Al ejecutar la función saluda, introduce en #contenido el valor pasado por parametro
 * 
 * @param {type} texto
 */
function saluda(texto){
    document.getElementById("contenido").innerHTML=texto;
}