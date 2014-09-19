
<html lang="en">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Login Form</title>
<link rel="stylesheet" href="./public/css/login.css">
<!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body>
	<section class="container">
		<div class="login">
			<h1>欢迎使用上机系统</h1>
			
			<form method="post" action="login">
				<p>
					<input type="text" name="user" placeholder="Username" required>
				</p>
				<p>
					<input type="password" name="pass" placeholder="Password" required>
				</p>
				<p class="remember_me">
					<label> 学生<input type="radio" name="jiaose"
						id="remember_me" value="1" checked="defalut"> 职工<input
						type="radio" name="jiaose" id="remember_me" value="2">
					</label>
				</p>
				<p class="submit">
					<input type="submit" name="commit" value="Login">
				</p>
			</form>
		</div>
	</section>
</body>
</html>
