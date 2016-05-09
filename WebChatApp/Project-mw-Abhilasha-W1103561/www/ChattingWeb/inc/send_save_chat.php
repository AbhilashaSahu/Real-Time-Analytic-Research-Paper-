<?php
session_start();
require_once 'connection.php';

$username = $_POST['username'];
$message = $_POST['message'];
$_SESSION[messg]=$message;
$recipient = $_POST['recipient'];
 //$date=date("Y-m-d");
 $qry=mysql_query("SELECT SYSDATE()");
 $result=mysql_fetch_assoc($qry);
 $get=$result['SYSDATE()'];

$sql = "INSERT INTO user_chat_messages(username,message_content,message_time,recipient,sender)VALUES
	('$username','$message','$get','$recipient','$username')";
$qry = mysql_query($sql);
//$qry->execute(array(':a'=>,':b'=>$message,':c'=>$date,':d'=>$recipient,':e'=>$username));
?>