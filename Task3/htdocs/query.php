<?php
	$username = "root";
	$password = "";
	$hostname = "localhost";
	$dbname = "Software Architecture";
	$dbhandle = new mysqli($hostname, $username, $password, $dbname);

	if($dbhandle->connect_errno > 0){
    		die('Unable to connect to database [' . $db->connect_error . ']');
	}
	
	if(!$result = $dbhandle->query($query)){
    		die('There was an error running the query [' . $dbhandle->error . ']');
	}
?>
