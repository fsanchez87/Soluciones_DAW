/**
 * Para facilitar la escritura podemos crear una función como esta que reaize
 * lo mismo que document.getElementById();
 * @param {type} idElement
 * @returns {Element}
 */
function gEBI(idElement) {
    return document.getElementById(idElement);
}
/**Valida los campos de un formulario. Retorna False si hay algún error.
 * @param {type} formulari
 * @returns {Boolean}
 */
function validarFormulario() {
     var textArea = gEBI('resulFormuario');
    textArea.innerHTML = '';
    var formOK = true;
    /*3Controla que si no se selecciona algún tipo de alimento (Congelado, Fruta o Snak) no se envíe el formulario al clicar en Regístrate..*/
var congelado =gEBI('Congelado').checked;
var fruta=gEBI('Fruta').checked
var snack=gEBI('Snack').checked
    if (!fruta  && !congelado   && !snack) {
        
       textArea.innerHTML += "Error Hay que seleccionar algun tipo de comida \n";
        formOK = false;
    } else {
       
    }

    /*a.No se debe enviar el formulario si alguno de los inputs es incorrecto.*/

    if (!checkInputNombre()) {
        formOK = false;
    }
    if (!chechInputCodigo()) {
        formOK = false;
    }

    if (!checkInputFecha()) {
        formOK = false;
    }
    return formOK; //si se ha producido algun error, retornará false y no se enviará el formulario
}
function checkInputNombreKeyUp(){
      var textArea = gEBI('resulFormuario');
    textArea.innerHTML = '';
    checkInputNombre();
}
function chechInputCodigoKeyUp(){
     var textArea = gEBI('resulFormuario');
    textArea.innerHTML = '';
    chechInputCodigo();
}
function checkInputFechaKeyUp(){
    var textArea = gEBI('resulFormuario');
    textArea.innerHTML = '';
    checkInputFecha();
}
function checkInputFecha() {
    var textArea = gEBI('resulFormuario');
    /*d InputDia , inputMes y inputAno deben formar una fecha válida.*/
    var dia = gEBI('inputDia').value;
    var mes = gEBI('inputMes').value;
    var ano = gEBI('inputAno').value;
    //var  d = new Date(ano, mes, dia);
    var date = new Date();
    date.setFullYear(ano, mes, dia);
    if (date.getDay()) {
        textArea.innerHTML += "Válido  fecha:" + date.toUTCString() + ". \n";
        return true;
    } else {
        textArea.innerHTML += "Inválido  fecha:" + date.toUTCString() + ". \n";
        return false;
    }
}
function checkInputNombre() {
    var textArea = gEBI('resulFormuario');
    /*a.InputNombre  no puede empezar por un número y debe contener entre 3 y 20 caracteres.*/
    var nombre = new String(gEBI('inputNombre').value);

    var primerCaracter = nombre.substring(0, 1);

    if (isNaN(primerCaracter)) {//comprovamos si el primer caracter es una letra
        if (nombre.length >= 3 && nombre.length <= 20) {
            textArea.innerHTML += "Válido  nombre:" + nombre + ". \n";
            return true;
        } else {
            textArea.innerHTML += "Inválido  nombre:" + nombre + " debe contener entre 3 y 20 caracteres. \n";
            return false;
        }
    } else {
        textArea.innerHTML += "Inválido  nombre:" + nombre + " no puede empezar por numero \n";
        return false;
    }
}

function chechInputCodigo() {
    var textArea = gEBI('resulFormuario');
    /*c.c.	InputCodigo debe tener 13 números, ninguna letra (puedes utilizar una expresión regular para validar).*/
    var codi = gEBI('inputCodigo').value;
    if ((/^\d{13}$/.test(codi))) {
        textArea.innerHTML += "Válido  codigo:" + codi + ". \n";
        return true;
    } else {
        textArea.innerHTML += "Inválido  codigo, debe tener 13 números, ninguna letra :" + codi + ". \n";
        return false;
    }
}
/**
 5.	Programa con JavaScript que al clicar sobre Guardar Datos se guarden 
 todos los datos de los inputs (excepto del checkbox) en una cookie para cada 
 input. Pej: para el input inputNombre crea una cookie que guarde su valor, 
 ...
 * @returns {undefined}
 */
function guardarDatos() {

    var nombre = gEBI('inputNombre').value;    //obtenemos el valor dentro del input
    setCookie('inputNombre', nombre, 10); //lo guardamos en una cookie llamada "nombre" que caducará en 10 dias

    var codi = gEBI('inputCodigo').value;
    setCookie('inputCodigo', codi, 10);

    var inputDia = gEBI('inputDia').value;
    setCookie('inputDia', inputDia, 10);

    var inputMes = gEBI('inputMes').value;
    setCookie('inputMes', inputMes, 10);

    var inputAno = gEBI('inputAno').value;
    setCookie('inputAno', inputAno, 10);

    var oferta = gEBI('oferta').value;
    setCookie('oferta', oferta, 10);

    var Congelado = gEBI('Congelado').checked;
    setCookie('Congelado', Congelado, 10);
    var Fruta = gEBI('Fruta').checked;
    setCookie('Fruta', Fruta, 10);
    var Snack = gEBI('Snack').checked;
    setCookie('Snack', Snack, 10);
}
/**
 * 6.Programa con JavaScript que al clicar sobre Recupera Datos se sustituyan 
 * el valor de los inputs por el valor almacenado en su correspondiente cookie.
 */
function recuperarDatos() {
    /*8.Controla que si no existe cookie para un valor se muestre el input
     *  correspondiente a ese valor en blanco con el || ''. Si el resultado de la
     *  izquierda de || es null o undefined, se aplica el resultado de la derecha*/
    var nombre = getCookie('inputNombre') || ''; //obtenemos el valor de la cookie nombre, o bien una cadena vacia  
    gEBI('inputNombre').value = nombre;   //establecemos el valor del input a el valor obtenidode la cookie

    var inputTelef = getCookie('inputCodigo') || '';
    gEBI('inputCodigo').value = inputTelef;

    var inputDia = getCookie('inputDia') || '';
    gEBI('inputDia').value = inputDia;

    var inputMes = getCookie('inputMes') || '';
    gEBI('inputMes').value = inputMes;

    var inputAno = getCookie('inputAno') || '';
    gEBI('inputAno').value = inputAno;

    var oferta = getCookie('oferta') || '';
    gEBI('oferta').value = oferta;

    var Congelado = getCookie('Congelado') || 'false';
    if(Congelado=="false"){
        gEBI('Congelado').checked = false;
    }else{
        gEBI('Congelado').checked =Congelado;
    }
    
    
    var Fruta = getCookie('Fruta') || 'false';
      if(Fruta=="false"){
        gEBI('Fruta').checked = false;
    }else{
        gEBI('Fruta').checked =Fruta;
    }
    
    var Snack = getCookie('Snack') || 'false';
      if(Snack=="false"){
        gEBI('Snack').checked = false;
    }else{
        gEBI('Snack').checked =Snack;
    }
}


/**
 * Function to Set a Cookie
 * http://www.w3schools.com/js/js_cookies.asp
 * @param {type} cname
 * @param {type} cvalue
 * @param {type} exdays
 * @returns {undefined}
 */
function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toGMTString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}
/**
 * Function to Get a Cookie
 * http://www.w3schools.com/js/js_cookies.asp
 * @param {type} cname
 * @returns {String}
 */
function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i].trim();
        if (c.indexOf(name) == 0)
            return c.substring(name.length, c.length);
    }
    return "";
}