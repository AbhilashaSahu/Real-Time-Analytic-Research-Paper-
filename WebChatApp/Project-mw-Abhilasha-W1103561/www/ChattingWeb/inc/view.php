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
echo "$username";

			$sql = "SELECT DISTINCT message_content,message_time,username,recipient,sender FROM user_chat_messages where sender='$username' OR recipient='$username'";
			$qry = mysql_query($sql);

			while($row=mysql_fetch_assoc($qry))
			{
				$time = date("Y-m-d",strtotime($row['message_time']));
				$now = date("Y-m-d");
				$gettime=$row['message_time'];
				
				if (($row['username'] == $username) && ($time == $now)) {
					$user = '<strong style="color:green;">'.$row['username'].'</strong>'.'-->'.$row['recipient']; 
				}else{
					$user = '<strong style="color:blue;">'.$row['username'].'</strong>'; 			
				}	
				if ($time == $now) {
					$hourAndMinutes = date("h:i A", strtotime($row['message_time']));
				}else{
					$hourAndMinutes = date("Y-m-d", strtotime($row['message_time']));
				}
				
				if($username==$row['recipient'])
				{
					echo '<p><div style="padding-left:50px;"><strong style="color:blue;">'.$row['recipient'].'</strong><em>('.$gettime.')</em>:--'. $row['message_content']. '</div></p>';
				}
				if($username==$row['sender'])
				{
					echo '<p><div style="padding-left:0px;"><strong style="color:blue;">'.$row['recipient'].'</strong><em>('.$gettime.')</em>:--'. $row['message_content']. '</div></p>';
				}
			}

?>