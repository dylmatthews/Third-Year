<?php
include "navbar.html";
?>
<html>
	<head>

	</head>
	<body><br>
		<form name = "login" action = "SignUp.php" method = "POST">
			<label>First Name :</label><input type = "text" name = "firstNameIce" /> <br /><br />
			<label>Surname :</label><input type = "text" name = "lastNameIce" /> <br /><br />
			<label>Email :</label><input type = "text" name = "emailIce" /> <br /><br />
			<label>Password :</label><input type = "password" class="form-control" name = "password" /><br /><br />
			<p> <input type="submit" name = "Submit" value = "Sign Up" /> </p>
		</form>
	</body>
        
</html>



<?php
if(isset($_POST["Submit"])) { 
include"dbConect.php";

$fname = $_POST["firstNameIce"];
$lname = $_POST["lastNameIce"];
$email = $_POST["emailIce"];
$hashed = hash('sha512', $_POST["password"]);
$valid = true;

if (empty($_POST["password"]))
{echo "no password was entered</br></br>";

}

if (empty($fname))
{
	$valid=false;
	echo "no first name was entered</br></br>";
}


 if (empty($lname))
{
	$valid=false;
		echo "no last name was entered<br></br>";
}	

if (empty($email)||checkEmail($email)==false)
{
	
	$valid=false;
	echo "enter a valid email</br></br>";
}



 if ($valid==true)
{


	$sql = "INSERT INTO tblUsers (firstName, lastName, email, password)
        VALUES ('$fname', '$lname', '$email', '$hashed')";
        
        if ($DBConnect->query($sql) === TRUE) {
    echo "New record created successfully";
        } else {
    echo "You already have an account: ". "<br>";
   
    echo "<a href='login.php'>Login Page</a>";
            
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