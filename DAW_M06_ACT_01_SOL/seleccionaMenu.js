/**Funcion que pida si del menu quiere 1-Ensalada 2-Tallarines 3-Arroz
 * y muestre la opcion seleecionada en el elemento con id "primero"
 * o que indique que no es una opcion valida
 */
function seleccionaPrimero() {
    //pide mediante un prompt el numero de opcion  del menu
    var opcion = window.prompt("Qué quieres de primero?"
            + "\n 1-Ensalada" + "\n 2-Tallarines" + "\n 3-Arroz");
    opcion = parseInt(opcion);
    var texto;

    switch (opcion) {
        case 1:
            texto = "Ensalada";
            break;
        case 2:
            texto = "Tallarines";
            break;
        case 3:
            texto = "Arroz";
            break;
        default:
            texto = "No has escogido una opcion valida";

    }
    document.getElementById("primero").innerHTML = texto;
}


/**Funcion que pida si del menu quiere 1-Solomillo 2-Pescado 3-Lasanya
 * y muestre la opcion seleecionada en el elemento con id "segundo"
 * o que indique que no es una opcion valida.
 * Si no se introduce una opción válida se h de volver a preguntar.
 */
function seleccionaSegundo() {
    do {
        //pide mediante un prompt el numero de opcion  del menu
        var opcion = window.prompt("Qué quieres de primero?"
                + "\n 1-Entrecot" + "\n 2-Merluza" + "\n 3-Callos");
        opcion = parseInt(opcion);

        var texto = "";

        switch (opcion) {
            case 1:
                texto = "Entrecot";
                break;
            case 2:
                texto = 'Merluza';
                break;
            case 3:
                texto = 'Callos';
                break;
            default:
                opcion = false;
                texto = "No has escogido una opcion valida";
        }
    } while (!opcion)
    document.getElementById("segundo").innerHTML = texto;
}



