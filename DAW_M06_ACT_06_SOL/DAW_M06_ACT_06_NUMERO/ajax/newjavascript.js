

window.addEventListener("load", ini, false);
function ini() {
    document.getElementById("inicioXML").addEventListener("click", inicioXML, false);
    document.getElementById("checkAjaxXML").addEventListener("click", checkAjaxXML, false);
    document.getElementById("inicioJSON").addEventListener("click", inicioXML, false);
    document.getElementById("checkAjaxJSON").addEventListener("click", checkAjaxJSON, false);

}
function inicioXML() {
    var xmlHttp = new XMLHttpRequest();
    var urlDestino = "aciertaNumeroXML.php?inicio=si";
    xmlHttp.open("GET", urlDestino, true);
    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4) {
            if (xmlHttp.status == 200) {
                var resp = xmlHttp.responseXML;
                var numero = resp.getElementsByTagName('inicio')[0].innerHTML;
                console.log("Numero generado:" + numero);

                document.getElementById("encontrado").innerHTML = "";
                document.getElementById("mensaje").innerHTML = "Nuevo numero generado";
            }
        }
    }
    xmlHttp.send(null);
}
function checkAjaxXML() {
    var num = document.getElementById("numero").value;
    var xmlHttp = new XMLHttpRequest();
    var urlDestino = "aciertaNumeroXML.php?numero=" + num;
    xmlHttp.open("GET", urlDestino, true);
    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4) {
            //funcion a ejecutar al recibir la respuesta
            if (xmlHttp.status == 200) {
                var resp = xmlHttp.responseXML;
                var encontrado = resp.getElementsByTagName('encontrado')[0].innerHTML;
                var mensaje = resp.getElementsByTagName('mensaje')[0].innerHTML;

                document.getElementById("encontrado").innerHTML = encontrado;
                document.getElementById("mensaje").innerHTML = mensaje;

            }
        }
    };

    xmlHttp.send(null);
}

function inicioJSON() {
    var xmlHttp = new XMLHttpRequest();
    var urlDestino = "aciertaNumeroJSON.php?inicio=si";
    xmlHttp.open("GET", urlDestino, true);
    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4) {
            if (xmlHttp.status == 200) {
                var resptText = xmlHttp.responseText;
                var respJSON = JSON.parse(resptText);
                var numero = respJSON.inicio;
                console.log("Numero generado:" + numero);
                document.getElementById("encontrado").innerHTML = "";
                document.getElementById("mensaje").innerHTML = "Nuevo numero generado";

            }
        }
    }
    xmlHttp.send(null);
}
function checkAjaxJSON() {
    var num = document.getElementById("numero").value;
    var xmlHttp = new XMLHttpRequest();
    var urlDestino = "aciertaNumeroJSON.php?numero=" + num;
    xmlHttp.open("GET", urlDestino, true);
    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4) {
            //funcion a ejecutar al recibir la respuesta
            if (xmlHttp.status == 200) {
                var resptText = xmlHttp.responseText;
                var respJSON = JSON.parse(resptText);
                var encontrado = respJSON.encontrado;
                var mensaje = respJSON.mensaje;
                document.getElementById("encontrado").innerHTML = encontrado;
                document.getElementById("mensaje").innerHTML = mensaje;

            }
        }
    };

    xmlHttp.send(null);
}

