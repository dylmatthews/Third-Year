<?php session_start();?>
<?php
include "navbar.html";

?>

<html>

	<head>

	</head>
	<body>
		<form name = "login" action = "adminLogin.php" method = "POST"><br />
			<label>Email: </label><input type = "text" name = "emailIce" /> <br /><br />
			<label>Password :</label><input type = "password" class="form-control"name = "password" /><br /><br />
                         <br><br>
                                                  
			<p> <input type="submit" name = "Submit" value = "Admin login" /></p>
		</form>
	</body>
</html>


<?php

if(isset($_POST["Submit"])) {

include"dbConect.php";


$email = $_POST["emailIce"];

$hashed = hash('sha512', $_POST["password"]);

$valid = false;

if ($hashed=="cf83e1357eefb8bdf1542850d66d8007d620e4050b5715dc83f4a921d36ce9ce47d0d13c5d85f2b0ff8318d2877eec2f63b931bd47417a81a538327af927da3e")
{
	
	echo "no password was entered</br></br>";
}

	

 if (empty($email)||checkEmail($email)==false)
{
	
	$valid=false;
	echo "enter a valid email</br></br>";
}



 if ((checkEmail($email)==true)&&!(hashed=="cf83e1357eefb8bdf1542850d66d8007d620e4050b5715dc83f4a921d36ce9ce47d0d13c5d85f2b0ff8318d2877eec2f63b931bd47417a81a538327af927da3e"))
{
	
	$valid=true;
	
}


if ($valid==true)
{
	$sql = "SELECT email FROM tblUsers WHERE email = '$email' and password = '$hashed'";
        
      $result = mysqli_query($DBConnect,$sql);
       
      $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
      $active = $row['active'];
      
      $count = mysqli_num_rows($result);
      
      // If result matched $myusername and $mypassword, table row must be 1 row
		
      if($count == 1) {
      
      $_SESSION['status'] = 'admin';
      echo "Login succesful</br></br>";
      echo "<a href= 'shop.php'>View The Shop</a>";

        $_SESSION['email'] = $row["email"] ;

          
 
     
     
         
      }else {
         $error = "Your Login Name or Password is invalid";
         echo $error;
         
         
      }
   }
   }
	


function checkEmail ($add)
	{
	if(preg_match("/^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)*(\.[[A-Za-z]{2,})$/i", $add) == 1)
			{
				return true;
			}
			else 
			{
				return false;
				
			}
	}


?>