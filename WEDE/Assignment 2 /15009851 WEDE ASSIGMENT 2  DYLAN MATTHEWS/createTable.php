<?php

include "dbConect.php";
 echo $test."<br>";

       
$file = fopen("script.txt","w"); //oPENS file
$sql =mysqli_query($DBConnect,"SELECT firstName, lastName, email, password from tblUsers");

while($row = mysqli_fetch_array($sql))
{
    $fname = $row['firstName'];
    $lname = $row['lastName'];
    $email = $row['email'];
    $password = $row['password'];

   


    fwrite($file,("insert into tblUsers (firstName, lastName, email, password) values ('".$fname."','".$lname ."','".$email."','".$password."');"."\n"));
}

fclose($file);

echo "Count =".$cnt;



echo "<a href=script.txt>TEST!</a>";
include "dbConect.php";
$result = mysqli_query($DBConnect, "SHOW TABLES LIKE 'tblUsers'");


if($result->num_rows>0){

    echo "<br><br>table exists<br><br>";
     
 
    include "dropTable.php"; //opens drop table script
    
     $sql= "CREATE TABLE tblUsers (
   
     firstName varchar(255) NOT NULL,
     lastName varchar(255) NOT NULL, 
     email varchar(255) NOT NULL primary key,
     password varchar(255) NOT NULL )";
                  
             if ($DBConnect->query($sql) === TRUE) {
            echo "<br><br>Table tblUsers created successfully<br><br>";
        } else {
            echo "<br><br>Error creating table: " . $DBConnect->error;
                }

                  
                  $txt = file_get_contents('script.txt');
                $queries = explode(';', $txt);
                foreach($queries as $sql){
                   mysqli_query($DBConnect,$sql);
                        }
                        
                        echo "<br><br>Inserts are done!!<br><br>";
                  
                /*$file = fopen("script.txt", "r");
                echo "<br><br>opeing file";
                $cnt = 0;

                while (!feof($file)) {
   
                         $l = "'".fgets($file)."'";
                         
                         echo "shit".$l;
                       
                           
                        if ($DBConnect->query($l) === TRUE) {
                            echo "insert successfully";
                        } else {
                            echo "Error inserting: " . $DBConnect->error;
                                }


                        
                        }fclose($file);*/

                        
    
}
else{
echo "Databse does not exists";
    
    }

?>