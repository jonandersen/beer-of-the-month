

<html><body style="text-align:center"><h1>
</h1>
<form action="index2.php" method="post">

Send to server: <input type="text" name="textfieldsend" /><br>
<p></p>
<input type="submit" name="sendbutton" value="send"/><br>

<?php //<input type="submit" name="closebutton" value="killserver"/><br> ?>


</form>



<?php

// set some variables


if(isset($_POST["sendbutton"])){

	$socket = socket_create(AF_INET, SOCK_STREAM, SOL_TCP);
        
	
        if($socket === false) exit('blurg');
 
        socket_bind($socket, '192.168.1.2');
        
        socket_connect($socket, '192.168.1.2', 49289);
       
        $line=$_POST["textfieldsend"];
        socket_write($socket,$line);
	
	//socket_write($socket,"BYE");

	socket_shutdown($socket, 1);
        
        echo socket_read($socket, 1000);
	
	socket_shutdown($socket, 0);
        
        socket_close($socket);

}

if(isset($_POST["closebutton"])){
        
        $socket = socket_create(AF_INET, SOCK_STREAM, SOL_TCP);
        
	echo "test";
        if($socket === false) exit('blurg');
 
        socket_bind($socket, '192.168.1.2');
        
        socket_connect($socket, '192.168.1.2', 49289);
	
	socket_write($socket,"BYE");

	socket_shutdown($socket, 1);
        
        echo socket_read($socket, 1000);
	
	socket_shutdown($socket, 0);
        
        socket_close($socket);

}
			
?>
</body></html>

