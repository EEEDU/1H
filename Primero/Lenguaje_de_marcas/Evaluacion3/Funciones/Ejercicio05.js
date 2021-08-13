function empezar(ev){
    ev.dataTransfer.effectAllowed='move';
    ev.dataTransfer.setData("Data", ev.target.getAttribute('id'));
    ev.dataTransfer.setDragImage(ev.target, 25, 25);
    return true;
}
function terminar(ev){
    ev.dataTransfer.clearData("Data");
    return true;
}
function encima(ev) {
    var arrastraId= ev.dataTransfer.getData("Data");
    var contenedorId= ev.target.getAttribute('id');
    if(contenedorId== 'des1') return false;
    if((contenedorId=='des2') && (arrastraId=="ar2"))return false;
    if((contenedorId=='des3') && (arrastraId=="ar3"))return false;

}
function soltar(ev) {
    var arrastraId= ev.dataTransfer.getData("Data");
    ev.target.appendChild(document.getElementById(arrastraId));
    ev.stopPropagation();
    return false;
}