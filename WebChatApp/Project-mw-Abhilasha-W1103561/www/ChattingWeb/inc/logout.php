<?php
session_start(); 
include('connection.php');

$user=$_SESSION['user'];
$result ="Delete from tbllogin Where username='$user'";
$qry = mysql_query($result);
if(!$qry)
{
	die("ERROR : ".mysql_error());
}
else
{
	//unset($_SESSION['sessionid']);
	unset($_SESSION['username']);
	//unset($_SESSION['password']);
	header('location:../index.php');
}
?>