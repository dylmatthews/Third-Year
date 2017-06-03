<?php
require "dbConect.php";
if ($DBConnect->query("DROP TABLE tblUsers") === TRUE) {
    echo "Table tblUsers been dropped successfully";
} else {
    echo "Error dropping table table: " . $conn->error;
}


?>