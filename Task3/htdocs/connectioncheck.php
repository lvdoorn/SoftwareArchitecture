<html>
	<body>
		<?php
		  $s1 = $_POST['stop1'];
		  $s2 = $_POST['stop2'];
			$query = "SELECT DISTINCT name FROM Routes WHERE id IN (SELECT s1.route_id FROM (SELECT * FROM Mapping WHERE stop_id = $s1) s1 JOIN (SELECT * FROM Mapping WHERE stop_id = $s2) s2 ON s1.route_id = s2.route_id)";
			include "query.php";
			while($row = $result->fetch_assoc()){
	    	echo $row['name'] . "<br>";
			}
		?>
	</body>
</html>
