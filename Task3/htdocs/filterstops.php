<html>
	<body>
		<?php
			$name = $_POST['name'];
			$lonDir = $_POST['lonDir'];
			$latDir = $_POST['latDir'];
			$lon = $_POST['lon'];
			$lat = $_POST['lat'];
			$query = "SELECT * FROM Stops WHERE name LIKE '%$name%' ";
			if (strlen($lon)) {
				if ($lonDir == 'above') {
					$query .= "AND `@lon` >= " . floatval($lon);
				} else {
					$query .= "AND `@lon` <= $lon";
				}
			}
			if (strlen($lat)) {
				if ($latDir == 'above') {
					$query .= " AND `@lat` >= " . floatval($lat);
				} else {
					$query .= " AND `@lat` <= $lat";
				}
			}
			include 'query.php';
			while($row = $result->fetch_assoc()){
	    		echo $row['@id'] . " " . $row['@lon'] . " " . $row['@lat'] . " " . $row['name'] . '<br />';
			}
		?>
	</body>
</html>
