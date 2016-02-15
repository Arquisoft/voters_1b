<?php
$link = mysql_connect("localhost","root","") or die("<h2>No se encuentra el servidor</h2>");
$db = mysql_select_db("usuarios",$link) or die("<h2>Error de conexion</h2>");

//obtenemos los valores del formulario
$email=$_POST['email'];
$password=$_POST['password'];

//Validamos que todos los datos hayan sido completados
$req = (strlen($nombre)*strlen($email)*strlen($password)) or die("No se han llenado todos los campos");

mysql_query("update usuarios set password = "+$password+" where email ="+$email+";");