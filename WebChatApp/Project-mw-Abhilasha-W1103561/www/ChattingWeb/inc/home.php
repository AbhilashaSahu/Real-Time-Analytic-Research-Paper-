<?php
	if(!isset($_SESSION)) 
	{ 
		session_start(); 
		include('connection.php');
		$username = $_SESSION['user'];
	}
?>
<html lang="EN">
	<head>
		<meta charset="utf-8">
		<title><?php
					include('connection.php');
					$username=$_SESSION['user'];
					$sql1=mysql_query("SELECT max(id) as id FROM user_chat_messages WHERE recipient='$username'");
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
		
				?></title>
		<style>
			body {
				font-family:"Tahoma",Arial Narrow;
				font-size: 12px;
				background-image:url(images/content_bg.jpg);
			}
			.holder {
				padding:3px;
				margin-left:auto;
				margin-right:auto;
				margin-top:10%;
				display:table;
				border:solid 1px #cccccc;
				border-width: thin;
			}
			.style {
				bottom:0px;
				border:1px solid #666;
				background-color:#FFF;
				border-radius:3px;
				-webkit-border-radius:3px;
				-moz-border-radius:3px;
				box-shadow:0 0 5px #000;			
				-moz-box-shadow:0 0 5px #000;			
				-webkit-box-shadow:0 0 5px #000;			
			}
			.alpha {
				float:right;
				width:300px;
				padding:2px;
				border:1px solid #666;
				background-color:#FFF;
				border-radius: 3px;
				}
			.refresh {
				border: 1px solid #3366FF;
				border-left: 4px solid #3366FF;
				color: green;
				font-family: tahoma;
				font-size: 12px;
				height: 225px;
				overflow: auto;
				width: 270px;
				padding:10px;
				background-color:#FFFFFF;
			}	
			#post_button{
				border: 1px solid #3366FF;
				background-color:#3366FF;
				width: 50px;
				color:#FFFFFF;
				font-weight: bold;
				margin-left: -04px; padding-top: 4px; padding-bottom: 4px;
				cursor:pointer;
			}
			#textb{
				border: 1px solid #3366FF;
				border-left: 4px solid #3366FF;
				padding-top: 5px;
				padding-bottom: 5px;
				padding-left: 5px;
				width: 220px;
			}
			#texta{
				border: 1px solid #3366FF;
				border-left: 4px solid #3366FF;
				width: 210px;
				margin-bottom: 10px;
				padding:5px;
			}
			#johnlei{
				margin-left:3px;
				color: #ffffff;
				text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);
				background-color: #49afcd;
				*background-color: #2f96b4;
				background-image: -moz-linear-gradient(top, #5bc0de, #2f96b4);
				background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#5bc0de), to(#2f96b4));
				background-image: -webkit-linear-gradient(top, #5bc0de, #2f96b4);
				background-image: -o-linear-gradient(top, #5bc0de, #2f96b4);
				background-image: linear-gradient(to bottom, #5bc0de, #2f96b4);
				background-repeat: repeat-x;
				border-color: #2f96b4 #2f96b4 #1f6377;
				border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25);
				filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ff5bc0de', endColorstr='#ff2f96b4', GradientType=0);
				filter: progid:DXImageTransform.Microsoft.gradient(enabled=false);
				float:right;
				cursor:pointer;	
				height: 53px;
				width:70px;
			}
			#johnlei:hover,
			#johnlei:active,
			#johnlei.active,
			#johnlei.disabled,
			#johnlei[disabled] {
				color: #ffffff;
				background-color: #51a351;
				*background-color: #499249;
			}
			#johnlei:active,
			#johnlei.active {
				background-color: #408140;
			}
			#johnlei:hover{
				background-color: #2f96b4;
			}
		</style>
		<script src="js/jquery.js"></script>
	</head>
<body>
	<div>
		<div class="style">	
				<div class="alpha">
					<b align="center">You can view online friends here:</b><br><br>
					<div class="refresh1">
					</div>
					<br/>
		</div>
		</div>
	<div class="holder">
		<label="welcomemsg">WELCOME: </label><label for="name"><?php echo $username; ?> <a href="logout.php"><h3>Logout</h3></a></label>
			<div class="style">	
				<div class="alpha">
					<b align="center">You can view your chats here:</b><br><br>
					<input name="user" type="hidden" id="texta" value="<?php echo $username ?>"/>
					<div>
						<div class="refresh">
						</div>
						<!--<div class="refresh2">
						</div>-->
					</div>
					<br/>
					<form name="newMessage" class="newMessage" action="" onsubmit="return false">
						<select name="recipient" id="recipient" style="width:270px;">
							<option>--Send Chat To--</option>
								<?php 
									$sql = "SELECT * FROM tbllogin where username!='$username' ORDER BY username";
									$qry =mysql_query($sql);
									while($row=mysql_fetch_assoc($qry))
									{
										$name = $row['username'];
								?>
									<option title="<?php echo $name; ?>"><?php echo $row['username']; ?> </option>
								<?php } ?>
						</select>
					<textarea name="textb" id="textb">Enter your message here</textarea>
					<input name="submit" type="submit" value="Send" id="johnlei" />
				</form>
			</div>
		</div>
		<script src="js/sendchat.js" type="text/javascript"></script>
		<script src="js/refresh.js" type="text/javascript"></script>
	</div>	
		
		<!--<script src="js/refresh.js" type="text/javascript"></script>-->
		<script src="js/refresh1.js" type="text/javascript"></script>
	</div>
	</body>
</html>