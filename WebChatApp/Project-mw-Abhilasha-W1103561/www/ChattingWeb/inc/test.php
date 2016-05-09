<?php
include('connection.php');
			$username="c";
					$sql1=mysql_query("SELECT max(id) as id FROM user_chat_messages WHERE username='$username'");
					$row1=mysql_fetch_assoc($sql1);
					$id=$row1['id'];
					
						$sql = "select message_content from user_chat_messages where id='$id'";
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
								if($row=mysql_fetch_assoc($qry))
								{
									echo $name = $row['message_content'];
								}
							}
						}
?>