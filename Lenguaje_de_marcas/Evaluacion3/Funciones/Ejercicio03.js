function negrita(){
    document.execCommand("bold", false, null);
}
function cursiva(){
    document.execCommand("italic", false, null);
}
function subrayado(){
    document.execCommand("underline", false, null);
}
function alineai(){
    document.execCommand("justifyleft", false, null);
}
function alineac(){
    document.execCommand("justifycenter", false, null);
}
function alinead(){
    document.execCommand("justifyright", false, null);
}
function alineaf(){
    document.execCommand("justifyfull", false, null);
}
function listaNoOrdenada(){
    document.execCommand("insertunorderedlist", false, null);
    document.execCommand("justifyleft", false, null);
}
function listaOrdenada(){
    document.execCommand("insertorderedlist", false, null);
    document.execCommand("justifyleft", false, null);
}
function subi(){
    document.execCommand("subscript", false, null);
}
function supi(){
    document.execCommand("superscript", false, null);
}
function fontColor(){
    var color = prompt("Introduce el color de la fuente");
    document.execCommand("forecolor", false, color);
}
function backColor(){
    var color = prompt("Introduce el color de fondo");
    document.execCommand("backcolor", false, color);
}
function insertarImg(){
    var imagen = prompt("Introduce el nombre de la imagen");
    document.execCommand("insertimage", false, "Imagenes/" + imagen + ".png");
}
function hipervinculo(){
    var direccion = prompt("Introduce la URL: ", "http://")
    document.execCommand("createlink", false, direccion);
}
function publicar(){
    var conte = document.getElementById("contenido").innerHTML;
    document.getElementById("mensajes").innerHTML = conte;
}
