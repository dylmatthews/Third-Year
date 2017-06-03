<?php
session_start();
?>
<?php

echo $_SESSION['user_id'];
setcookie('firstName','Mike', time()+3600, "www.dylanmatthews.dx.am");
setcookie('lastName','Smith', time()+3600);
setcookie("userInfo[0]","Mary", time()+3600);
setcookie("userInfo[1]","d@gmail.com");

setcookie("userInfo[Firstname]", "Mary");
setcookie("userInfo[lastName]","Peters");


//setcookie('variable', $name);

?>