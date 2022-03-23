<?php
// Incluimos el archivo de configuración
define('MYSQL_HOST', 'mysql');
define('MYSQL_DATABASE', 'netflix');
define('MYSQL_USER', 'root');
define('MYSQL_PASSWORD', 'root');

$mysqli = mysqli_connect(MYSQL_HOST, MYSQL_USER, MYSQL_PASSWORD, MYSQL_DATABASE);
// Obtenemos los datos de los alumnos de la base de datos y los ordenamos por apellidos
$result = mysqli_query(
    $mysqli,
    "SELECT e.id_empleado, e.nombre, e.apellidos, e.email, e.activo, d.direccion, d.distrito
 FROM empleado AS e JOIN direccion AS d 
 ON e.id_direccion = d.id_direccion"
);
?>

<!doctype html>
<html lang="en">

<head>
    <title>Lista empleados y </title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>

<body>

    <div class="container">


        <table class="table table-striped">

            <tr>
                <td>Nombre</td>
                <td>Apellido</td>
                <td>Email</td>
                <td>Direccion</td>
                <td>Activo</td>
                <td>Activar</td>
            </tr>

            <?php
            // Obtenemos el id del usuario que está votando

            while ($res = mysqli_fetch_array($result)) {
                $id = $res['id_empleado'];
                echo "<tr>";
                echo "<td>" . $res['nombre'] . "</td>";
                echo "<td>" . $res['apellidos'] . "</td>";
                echo "<td>" . $res['email'] . "</td>";
                echo "<td>" . $res['distrito'] . " " . $res['direccion'] . "</td>";
                echo "<td>" . $res['activo'] . "</td>";
                echo "<td><a class=\"btn btn-info\" href=\"activar.php?id=$id\">act/desact</a></td>";
                echo "</tr>";
            }
            mysqli_close($msqli);
            ?>

        </table>
    </div>
</body>

</html>