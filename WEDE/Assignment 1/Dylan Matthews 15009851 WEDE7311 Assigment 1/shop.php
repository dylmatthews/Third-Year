
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

        
  echo("<Table>");
  
    echo("<tr><th>Item ID</th><th>Description</th><th>Cost Price</th><th>Selling Price</th><th>Image</th><th> Add to Cart</th></tr>");   //makes column headings
      
   
     
      
       
       for($i=0;$i<15;$i++)
       
       {
      $y=$i+1;
       
       $itemID = "Item$y";
       
       $sql = "Select * from tbl_Item  where ItemID = '$itemID'";
        $result = $DBConnect->query($sql);
     
                  //$result = mysqli_query($DBConnect,$sql);
      if ($result->num_rows > 0) {
    // output data of each row
            while($row = $result->fetch_assoc()) { //inserts rows
                echo "<tr><td>" .$row["ItemID"]."</td><td>". $row["Description"]. "</td><td>" . 'R'.$row["CostPrice"]."</td><td>". 'R'.$row["SellPrice"]. "</td><td><img style='width:50px;height:50px;' src ='Images/$itemID.png'/>"."</td><td> <input type='submit' name = 'Submit' value = 'Add To Cart'onclick='getId(this)' /></td></tr>";
                    }
        } else {
                            echo "0 results";
                                        }
                  //$row =$result->fetch_assoc();;
             // echo ($result."<br>");
       }
       echo "</Table>";
       }

?>


<script>
function  getId(element) {

//var n=document.getElementById(element).childNodes[3].value;
    //var p=document.getElementById(element).childNodes[4].value;
    // alert("n="+n);
    //alert("p="+p);
    
   alert("row" + element.parentNode.parentNode.rowIndex+ " - column" + element.parentNode.cellIndex);
   element.getElementById('');

 
 
   
}

</script>