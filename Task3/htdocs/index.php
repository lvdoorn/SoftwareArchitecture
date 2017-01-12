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
		<form action="connectioncheck.php" method="post" id="connections">
			<?php
				$query = "SELECT * FROM Stops";
				echo "Stop 1: <select name=\"stop1\" form=\"connections\">";
				include 'query.php';
				while($row = $result->fetch_assoc()){
	    		echo "<option value=\"" . $row['@id'] . "\">" . $row['@id'] . " " . $row['name'] . "</option>";
				}
				echo "</select><br>";
				$query = "SELECT * FROM Stops";
				echo "Stop 2: <select name=\"stop2\" form=\"connections\">";
				include 'query.php';
				while($row = $result->fetch_assoc()){
	    		echo "<option value=\"" . $row['@id'] . "\">" . $row['@id'] . " " . $row['name'] . "</option>";
				}
				echo "</select><br>";
			?>
			<input type="submit" value="Check connection"><br>
		</form>
	</body>
</html>
