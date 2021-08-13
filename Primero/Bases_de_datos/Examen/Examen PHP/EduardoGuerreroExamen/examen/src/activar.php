<?php
// Incluimos el archivo de configuración
define('MYSQL_HOST', 'mysql');
define('MYSQL_DATABASE', 'netflix');
define('MYSQL_USER', 'root');
define('MYSQL_PASSWORD', 'root');

$mysqli = mysqli_connect(MYSQL_HOST, MYSQL_USER, MYSQL_PASSWORD, MYSQL_DATABASE);
// Obtenemos los datos de los alumnos de la base de datos y los ordenamos por apellidos
$id = $_GET['id'];
$res = mysqli_query($mysqli, "UPDATE empleado SET activo = NOT activo WHERE id_empleado = " . $id . ";");
if ($res) {
    echo "cambio con exito";
    header("refresh:5;url=lista_empleados.php", 5);
    exit();
} else {
    echo "error";
}
