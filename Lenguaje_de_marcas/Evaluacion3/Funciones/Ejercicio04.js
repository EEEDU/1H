function almacenar(codigo){
    if(sessionStorage.getItem(codigo) == null){
        sessionStorage.setItem(codigo, 1);
    }
    else{
        sessionStorage.setItem(codigo, parseInt(sessionStorage.getItem(codigo)) + 1);
    }
    ver();
} 

function ver(){
    if(sessionStorage.length == 0){
        cesta.innerHTML = "<h5>No tienes nada en el carrito</h5>"
    }
    else{
        cesta.innerHTML = "<table class='pro'><tr><th>PRODUCTO</th><th>UNDIDADES</th></tr></table>"
        for(var i=0; i<sessionStorage.length; i++){
            if(sessionStorage.key(i) != null){
                cesta.innerHTML += "<table class='pro'><tr><td>" + sessionStorage.key(i) + "</td><td>" + sessionStorage.getItem(sessionStorage.key(i)) + "</td><td><img id='borrar' src='Imagenes/iconos2/eliminar.jpg' onclick = eliminar('" + sessionStorage.key(i) + "')></img></td></tr></table>"
            }
        }
    }
}

function eliminar(nombre){
    if (parseInt(sessionStorage.getItem(nombre)) > 1){
        sessionStorage.setItem(nombre, parseInt(sessionStorage.getItem(nombre)) - 1);
    }
    else{
        sessionStorage.removeItem(nombre);
    }
    ver();
}

function limpiar(){
    sessionStorage.clear();
    ver();
}