<html>
	<head>
		<title>Modern Information Systems Website</title>
	</head>
	<body>
		<form action="filterstops.php" method="post">
			Name: <input type="text" name="name"><br>
			Longitude: <input type="text" name="lon"><br>
			<input type="radio" name="lonDir" value="above" checked="checked">Above<br>
			<input type="radio" name="lonDir" value="below">Below<br>
			Latitude: <input type="text" name="lat"><br>
			<input type="radio" name="latDir" value="above" checked="checked">Above<br>
			<input type="radio" name="latDir" value="below">Below<br>
			<input type="submit" value="Filter stops"><br>
		</form>
	</body>
</html>
