<?php session_start();?>
<?php
include "navbar.html";
if ($_SESSION['status']=="normal" )
{
echo "Pay now";
}
else {
echo "<a href='login.php'>Please log in</a> or please <a href='SignUp.php'>Sign Up</a>";
}
?>