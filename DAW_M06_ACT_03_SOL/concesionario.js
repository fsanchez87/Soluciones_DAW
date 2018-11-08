
/**2.	Crea una nueva clase “Extra” para almacenar: el precio y la url de la 
 * imagen del extra y una función “getHTML()” que al ejecutarse retorne un código
 *  HTML con la imagen y el precio del extra.
 * 
 * @returns {Extra}
 */
function Extra() {
   // this.nombre = "";
    this.url = "";
    this.precio = 10;

    this.getHTML = function () {
        return "<span> " +// this.nombre + " "
               
                 "<img src='" + this.url + "'/>"
                 + " " + this.precio+"€</span>";
    };
}

//3.	Una vez realizada la clase “Extra” deberá ser capaz de validar el siguiente código
var extra = new Extra();
extra.nombre = "Airbag";
extra.url = "imgs/concha_azul.jpeg";
console.log(extra.getHTML());

/**4.	Crea un objeto “Coche” que almacene: el nombre del coche, su velocidad,
 *  una array vacía de extras,  una función que reciba un extra y lo añada a su
 *   array y una función que retorne un código HTML con los datos del Coche y 
 *   de los extras
 * 
 * @returns {Coche}
 */
function Coche() {
    this.nombre = "";
    this.velocidadMaxima = 10;
    this.extras = [];
    this.addExtra = function (extra) {
        this.extras.push(extra);
    };
//    this.getExtra = function (nombre) {
//        return this.extras[nombre];
//    };
    this.getHTML = function () {
        var txt = "<span> " + this.nombre + " "
                + " " + this.velocidadMaxima
                + "km/h [";
        for (var k=0;k < this.extras.length;k++) {
            txt += this.extras[k].getHTML();
        }
        txt += "]</span><br />";
        return txt;
    };
}
;
//5.	Una vez realizada la clase “Coche”, deberá ser capaz de validar el siguiente código:
var coche = new Coche();
coche.nombre = "Carricoche";
coche.addExtra(extra);
console.log(coche.getHTML());

/* 6.	Crea un array global extrasDisponibles para almacenar todos los extras
 *  disponibles y añádele el extra creado anteriormente y otro extra.
*/
var extrasDisponibles = [];

var extra2 = new Extra();
extra2.nombre = "Estrella";
extra2.url = "imgs/estrella.jpeg";

extrasDisponibles.push(extra);
extrasDisponibles.push(extra2);

//7.	Programa que una vez cargada la web llame a una función mostrarExtras() 
//9.	Programa que una vez cargada la web llame a una función mostrarCoches() 
window.onload = function () {
    mostrarExtras();
    mostrarCoches();
};

var cochesDisponibles = [];
cochesDisponibles[coche.nombre]=coche;


/**7.que muestre en el HTML todos los extras que contiene extrasDisponibles.
 * @returns {undefined}
 */
function mostrarExtras() {
    document.getElementById("listadoExtras").innerHTML = "";
     document.getElementById("numeroExtra").innerHTML = ""; //13 modifica  mostrarExtras().. para que por cada extra se añada un option al select con el número de extra
    for (var k = 0; k < extrasDisponibles.length; k++) {
        document.getElementById("listadoExtras").innerHTML += extrasDisponibles[k].getHTML();
         document.getElementById("numeroExtra").innerHTML += "<option value='"+k+"'>"+k+"</option>";//13 modifica  mostrarExtras().. para que por cada extra se añada un option al select con el número de extra
    }
}
/**8-que muestre en el HTML todos los coches (con sus extras) que contiene coches disponibles
 * 
 * @returns {undefined}
 */
function mostrarCoches() {
    document.getElementById("listadoCoches").innerHTML = "";
     document.getElementById("numeroCoche").innerHTML = "";  //13 modifica  mostrarCoches() para que por cada coche  se añada un option al select con el nombre del coche.
    for (var k in cochesDisponibles) {
        document.getElementById("listadoCoches").innerHTML += cochesDisponibles[k].getHTML();
         document.getElementById("numeroCoche").innerHTML += "<option value='"+k+"'>"+cochesDisponibles[k].nombre+"</option>"; //13 modifica  mostrarCoches() para que por cada coche  se añada un option al select con el nombre del coche.
    }

}
/**10-programa el botón ADD EXTRA para que añada en extrasDisponibles un nuevo 
 * extra con el precio indicado y la imagen seleccionada del select y actualice
 *  visualmente todos los extras disponibles (llama a mostrarExtras() )
 * 
 * @returns {undefined}
 */
function addNewExtra() {
    var extra = new Extra();
   // extra.nombre = document.getElementById("nombreExtra").value;
    extra.precio = document.getElementById("precioExtra").value;
    extra.url = document.getElementById("urlExtra").value;
    extrasDisponibles.push(extra);
    mostrarExtras();
}


/**11- programa el botón BORRAR para que borre de extrasDisponibles el número de extra indicado
 *  (el número es la posición que ocupa el extra dentro del array de extrasDisponibles)
 * 
 * @returns {undefined}
 */
function borrarExtra() {
    var numero = document.getElementById("numeroBorrar").value;
    extrasDisponibles.splice(numero, 1);
    mostrarExtras();
}

/**12 -programa el botón ADD COCHE para que añada a cohesDisponibles  un nuevo
 *  coche con el nombre y la velocidad máxima indicada y actualice visualmente
 *   todos los coches disponibles (llama a mostrarCoches() )
 * 
 * 
 * @returns {undefined}
 */
function addNewCoche() {
    var coche = new Coche();
    coche.nombre = document.getElementById("nombreCoche").value;
    coche.velocidadMaxima = document.getElementById("velocidadCoche").value;
    coche.addExtra(extra);
    cochesDisponibles[coche.nombre]=coche;
    mostrarCoches();
}

/**14.	Programa el botón ADD EXTRA COCHE para que añada al coche seleccionado 
 *  el número de extra seleccionado  y  actualice visualmente todos los coches disponibles .
 * 
 * @returns {undefined}
 */
function addExtraCoche(){
    var numExtra = document.getElementById("numeroExtra").value;
    var numCoche = document.getElementById("numeroCoche").value;
    var extra = extrasDisponibles[numExtra];
    cochesDisponibles[numCoche].addExtra(extra);
      mostrarCoches();
      
}