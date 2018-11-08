/* 
 6. Programa en “numero.js” que al cargar el HTML se muestre una cuenta
  atrás desde 4 hasta 0 que se actualice cada 0,1 segundos. 
 */

var intervalo;
var contador=15;
var numero;
window.onload = function () {
    document.getElementById("countdown").innerHTML=contador;
   intervalo= window.setInterval(function(){
        contador--;
        document.getElementById("countdown").innerHTML=contador;
    },1000);
    
    //7.Una vez cargado el HTML se genere un número aleatorio entre 0 y 10.
    numero = Math.floor((Math.random() * 10));
    console.log("numero generado:"+numero);
};

/**se muestre 
        en “numero.html” y en “index.html” un mensaje indicando 
        si el valor dentro del input es mayor, menor o igual 
        al número aleatorio generado. 
 * 
 * @returns {undefined}
 */
function checkNumber(){
    var valor= document.getElementById("numero").value;
    valor = parseInt(valor);
    if(valor===numero){
        window.document.getElementById("mensaje").innerHTML=valor+" es igual a "+numero;
        window.opener.document.getElementById("mensaje").innerHTML=valor+" es igual a "+numero;
    }else{
        if(valor>numero){
            window.document.getElementById("mensaje").innerHTML="has introducido un valor superior";
            window.opener.document.getElementById("mensaje").innerHTML="has introducido un valor superior";
        }else{
            window.document.getElementById("mensaje").innerHTML="has introducido un valor inferior";
            window.opener.document.getElementById("mensaje").innerHTML="has introducido un valor inferior";
        }
        
    }
}