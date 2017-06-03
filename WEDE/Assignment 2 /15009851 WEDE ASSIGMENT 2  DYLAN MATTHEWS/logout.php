<?php
session_start();
?>


<?php
include "navbar.html";
// remove all session variables
session_unset();

echo "You have logged out";
?>