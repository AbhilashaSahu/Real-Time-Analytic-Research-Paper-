<style>
p{
border-top: 1px solid #EEEEEE;
margin-top: 0px; margin-bottom: 5px; padding-top: 5px;
}
</style>
<?php
session_start();
require_once 'connection.php';
$username = $_SESSION['user'];

$sql = "SELECT * FROM tbllogin WHERE username!='$username'";
$qry = mysql_query($sql);
if(!$qry)
{
	die("ERROR : ".mysql_error());
}
else
{
		$num_rows = mysql_num_rows($qry);
		if($num_rows > 0)
		{
				while($row=mysql_fetch_assoc($qry))
				{
					//foreach ($fetch as $fe):
					$name = $row['username'];
					echo '<p><img src="images\onlineGreen.png" width="10" height="10">'.$name.'</p>';

				}
		}
}

?>