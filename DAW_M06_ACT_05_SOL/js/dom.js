/**
 * @author Cristian
 2	Programa las funciones necesarias para conseguir que:
 */

/**2.2	Cuando se clique sobre el div #addText se pida al usuario un texto y se modifique el texto de #addText por el indicado por el usuario.
 * @param {Object} e
 */
function addText(){
	var texto = prompt("Introduce un texto?","");
	document.getElementById('addText').innerHTML = texto;
}
/**
 2.3Cuando se clique sobre #setColor se pida al usuario un color y se establezca como color de fondo de #setColor.
 * @param {type} e
 * @returns {undefined}
 */
function setColor(){
    var texto = prompt("Indica un color?","");
    document.getElementById('setColor').style.backgroundColor= texto;
}
/*
 2.4	Cuando se clique sobre #addDiv se cree un DIV, se pida al usuario un texto
  y se añada dentro de #domNodes con el texto indicado por el usuario.
   A demás el nuevo DIV creado debe ser de la clase .addDiv.
 * @returns {undefined}
 */
function addDiv(){
    var elem = document.createElement('DIV');
	elem.innerHTML=prompt("Contenido  del DIV?","");
	elem.className="addDiv";
	document.getElementById('domNodes').appendChild(elem);
}
/*
 2.5	Cuando se clique sobre #addSpan se cree un SPAN, se pida al usuario un 
 texto y se añada el nuevo SPAN dentro de #domNodes con el texto indicado por 
 el usuario. A demás el SPAN creado ha de ser de la clase .span.
 * @returns {undefined}
 */
function addSpan(){
    	var elem = document.createElement('SPAN');
	elem.innerHTML=prompt("Contenido del SPAN?","");
	elem.className="span";
	document.getElementById('domNodes').appendChild(elem);
}
/*
 *2.6Cuando se clique sobre el div #setContentPrev se cree un DIV con el texto
  ‘setContentPrev’ y de la clase .setContentPrev que se añada dentro de #domNodes.
   A demás, al clicar encima el DIV creado se deberá llamar a una función que
   pida un texto al usuario y lo introduzca dentro del elemento anterior.
 * @returns {undefined}
 */
function setContentPrev(){
    var elem = document.createElement('DIV');
    elem.innerHTML='setContentPrev';
    elem.className="setContentPrev";
    elem.onclick=function(){
         this.previousSibling.textContent=prompt("Contenido del TEXT?","");
    };
    document.getElementById('domNodes').appendChild(elem);
}
/*
 2.7 Cuando se clique sobre #delPrevNode cree un DIV con el texto ‘Remove Preview’
  , de la clase .delPrevNode y que se añada dentro de #domNodes. A demás al
   clicar encima se deberá eliminar el nodo elemento anterior. 
   SI no existe nodo anterior, no deberá retornar ningún error ni borrar nada.
 * @returns {undefined}
 */
function delPrevNode(){
	var elem = document.createElement('DIV');
	elem.innerHTML='Remove Preview';
	elem.className="delPrevNode";
	elem.onclick=function(){
            if(this.previousElementSibling){
		document.getElementById('domNodes').removeChild(this.previousElementSibling);
            }
	};
	document.getElementById('domNodes').appendChild(elem);
}
/*
 2.8	Cuando se clique sobre #delNextNode se cree un DIV con el texto ‘Remove Next’, 
 de la clase .delNextNode y que se añada dentro de #domNodes. A demás al clicar 
 encima el DIV creado se debera llamar a una funcion que compruebe si hay un nodo
  elemento despues de el y en tal caso que lo borre.
 * @returns {undefined}
 */
function delNextNode(){
	var elem = document.createElement('DIV');
	elem.innerHTML='Remove Next';
	elem.className="delNextNode";
	elem.onclick=function(){
            if(this.nextElementSibling){
                document.getElementById('domNodes').removeChild(this.nextElementSibling);
            }
	};
	document.getElementById('domNodes').appendChild(elem);
}

/**
 * 2.9	Quando se clique sobre #addAttr se pida al usuario un número, un nombre
 *  de atributo y un valor de atributo, y se añada (o sustituya si ya existe) al
 *   elemento en la posición indicada  el atributo con el valor indicado. 
 *   Si no existe ningún elemento en esa posición debe mostrar un mensaje al
 *   usuario indicando que no existe ese elemento.
 * @returns {undefined}
 */

function addAttr(){
    var numeroElement=prompt("Numero elemento?","");
    var nombreAtribut=prompt("Nombre atributo?","");
    var valorAtribut=prompt("Valor Atributo?","");
    var elem =document.getElementById('domNodes').children[numeroElement];
    if( elem){
         elem.setAttribute(nombreAtribut, valorAtribut);
    }else{
        alert('No existe el elemento indicado');
    }
}

/*
 *2.10	Quando se clique sobre #delAllType se pida al usuario un tipo de dato 
 *(SPAN, DIV...) y se elimine de #domNodes todos aquellos elementos de ese tipo
 * (si es que existe alguno).
 */
function delAllType(){
    var tipoElem=prompt("Indiga el tipo de dato : SPAN, DIV");
    tipoElem=tipoElem.toUpperCase();  //transformamos el tipo a mayusculas para asegurarnos.
    while(document.getElementById('domNodes').getElementsByTagName(tipoElem).length){
            var listElem=document.getElementById('domNodes').getElementsByTagName(tipoElem);
            document.getElementById('domNodes').removeChild(listElem[0]);
    }	
}

