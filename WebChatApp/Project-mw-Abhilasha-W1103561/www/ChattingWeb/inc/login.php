<?php
	if(!isset($_SESSION)) 
	{ 
		session_start(); 
	}
include('connection.php');
echo $username = $_POST['username'];
$_SESSION['user'] = $username;
$password = $_POST['password'];
	
								
							$sql = "SELECT * FROM tbllogin where username='$username' or password='$password'";
							$result=mysql_query($sql);
								if(!$result)
								{
									die("ERROR : ".mysql_error());
								}
								else
								{
									$num_rows = mysql_num_rows($result);
									if($num_rows==1)
									{
											
										$_SESSION['error'] = "Please provide another username or Password";
										header('location:../index.php');
									}
									else
									{
																	
										$query="Insert Into tbllogin(username,password,fullname,sessionid) values('$username','$password','$username','login')";
										$result1=mysql_query($query);
										header('location:home.php');
									}
								}
?>