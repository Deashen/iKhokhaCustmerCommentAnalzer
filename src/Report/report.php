<?php
$servername = "localhost:3306";
$username = "ubuntu";
$password = "password";
$dbname = "ikhokhadatabase";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

$sql = "SELECT ConditionsDesc,ConditionCount FROM Conditions";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
  // output data of each row
  while($row = $result->fetch_assoc()) {
    echo "Condition Description: " . $row["ConditionsDesc"]. " - Number of occurances: " . $row["ConditionCount"]. " <br>";
  }
} else {
  echo "0 results";
}
$conn->close();
?>