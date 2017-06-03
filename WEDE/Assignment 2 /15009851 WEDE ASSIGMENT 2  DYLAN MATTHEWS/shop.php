<?php session_start();?>
<?php
include "navbar.html";
?>
<html>

	<head>

	</head>
	<body>
        <form name = "shop" action = "shop.php" method = "POST"><br />
        <p> <input type="submit" name = "Submit" value = "Show Shop" /></p>
		</form>
	</body>
</html>

<?php
echo "<meta name='viewport' content='width=device-width, initial-scale=1.0'>";
if(isset($_POST["Submit"])) {
include "dbConect.php";

       if ($_SESSION['status']=="normal" )
       {
       
       echo "<a href='checkOutPage.php'>Check Out</a>";
  echo("<Table>");
  
    echo("<tr id='somerow'><th>Item ID</th><th>Description</th><th>Cost Price</th><th>Selling Price</th><th>Image</th><th> Add to Cart</th></tr>");   //makes column headings
      
   
     
      
       
       for($i=0;$i<15;$i++)
       
       {
      $y=$i+1;
       
       $itemID = "Item$y";
       
       $sql = "Select * from tbl_Item  where ItemID = '$itemID'";
        $result = $DBConnect->query($sql);
     
                  //$result = mysqli_query($DBConnect,$sql);                                                                                                                                                                                            //input type="submit" name = "Submit" value = "Show Shop"input type="submit" name = "Submit" value = "Show Shop"
      if ($result->num_rows > 0) {
    // output data of each row
         while($row = $result->fetch_assoc()) { //inserts rows
                echo "<tr><td>" .$row["ItemID"]."</td>
                <td>". $row["Description"]. "</td>
                <td>" . 'R'.$row["CostPrice"]."</td>
                <td>". 'R'.$row["SellPrice"]. "</td>
                <td><img style='width:50px;height:50px;' src ='Images/$itemID.png'/>"."</td>
                <td> <input type='submit' name = 'cart' value = 'Add To Cart'onclick='getId(this)' /></td></tr>";
                    }
        } else {
                            echo "0 results";
                                        }
                  //$row =$result->fetch_assoc();;
             // echo ($result."<br>");
       }
       echo "</Table>";
       }else if ($_SESSION['status']=="admin" )
       {
         echo "<a href='CheckOutPage.php'>Check Out</a>";
       echo("<Table>");
  
    echo("<tr id='somerow'><th>Item ID</th>
    <th>Description</th>
    <th>Cost Price</th>
    <th>Selling Price</th>
    <th>Image</th>
    <th> Add to Cart</th>
    <th>Add</th>
    <th>Edit</th>
    <th>Delete</th></tr>");   //makes column headings
      
       for($i=0;$i<15;$i++)
       
       {
      $y=$i+1;
       
       $itemID = "Item$y";
       
       $sql = "Select * from tbl_Item  where ItemID = '$itemID'";
        $result = $DBConnect->query($sql);
     
                  //$result = mysqli_query($DBConnect,$sql);                                                                                                                                                                                            //input type="submit" name = "Submit" value = "Show Shop"input type="submit" name = "Submit" value = "Show Shop"
      if ($result->num_rows > 0) {
    // output data of each row
         while($row = $result->fetch_assoc()) { //inserts rows
                echo "<tr><td>" .$row["ItemID"]."</td>
                <td>". $row["Description"]. "</td>
                <td>" . 'R'.$row["CostPrice"]."</td>
                <td>". 'R'.$row["SellPrice"]."</td>
                <td><img style='width:50px;height:50px;' src ='Images/$itemID.png'/>"."</td>
                <td> <input type='submit' name = 'cart' value = 'Add To Cart'onclick='getId(this)' /></td>
                <td> <input type='submit' name = 'add' value = 'add'onclick='add(this)' /></td>
                <td> <input type='submit' name = 'edit' value = 'edit'onclick='edit(this)' /></td>
                <td><input type='submit' name = 'delete' value = 'delete'onclick='delete(this)' /></td></tr>";
                    }
        } else {
                            echo "0 results";
                                        }
                  //$row =$result->fetch_assoc();;
             // echo ($result."<br>");
       }
       echo "</Table>";
       
       }
       else {
      
        echo "<a href='checkOutPage.php'>Check Out</a>";
       
         echo("<Table>");
  
    echo("<tr id='somerow'><th>Item ID</th><th>Description</th><th>Cost Price</th><th>Selling Price</th><th>Image</th><th> Add to Cart</th></tr>");   //makes column headings
      
   
     
      
       
       for($i=0;$i<15;$i++)
       
       {
      $y=$i+1;
       
       $itemID = "Item$y";
       
       $sql = "Select * from tbl_Item  where ItemID = '$itemID'";
        $result = $DBConnect->query($sql);
     
                  //$result = mysqli_query($DBConnect,$sql);                                                                                                                                                                                            //input type="submit" name = "Submit" value = "Show Shop"input type="submit" name = "Submit" value = "Show Shop"
      if ($result->num_rows > 0) {
    // output data of each row
         while($row = $result->fetch_assoc()) { //inserts rows
                echo "<tr><td>" .$row["ItemID"]."</td>
                <td>". $row["Description"]. "</td>
                <td>" . 'R'.$row["CostPrice"]."</td>
                <td>". 'R'.$row["SellPrice"]. "</td>
                <td><img style='width:50px;height:50px;' src ='Images/$itemID.png'/>"."</td>
                <td> <input type='submit' name = 'cart' value = 'Add To Cart'onclick='notLoggedIn(this)' /></td></tr>";
                    }
        } else {
                            echo "0 results";
                                        }
                  //$row =$result->fetch_assoc();;
             // echo ($result."<br>");
       }
       echo "</Table>";
       }
       
       }

?>

<script>
function  getId(element) {

//var n=document.getElementById(element).childNodes[3].value;
    //var p=document.getElementById(element).childNodes[4].value;
    // alert("n="+n);
    //alert("p="+p);
 var name = element.parentNode.parentNode.innerText;
 

 var res  = name.split(" ");
   alert(name);
  
   //element.getElementById('');
   
   
}

</script>
<script>
function  notLoggedIn(element) {

//var n=document.getElementById(element).childNodes[3].value;
    //var p=document.getElementById(element).childNodes[4].value;
    // alert("n="+n);
    //alert("p="+p);
 var name = element.parentNode.parentNode.innerText;
 

   alert("Login to add to cart");
  
   //element.getElementById('');
   
   
}

</script>

<script>
function  add(element) {

 

   alert("Added item by one");

   
}

</script>

<script>
function  edit(element) {

 

   alert("You can edit the item now");

   
}

</script>

<script>
function  delete(element) {

 

   alert("Item deleted");

   
}

</script>
