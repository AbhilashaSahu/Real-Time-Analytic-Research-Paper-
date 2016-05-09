<?php
    $host='localhost';
    $username = 'root';
    $password = '';

    try {
        $con = mysql_connect($host, $username, $password);
		$db=mysql_select_db('dbchat');
    } catch (PDOException $e) {
        $error_message = $e->getMessage();
        include('../errors/err.php');
        exit();
    }
?>