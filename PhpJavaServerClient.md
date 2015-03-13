Jag har fösökt få en php client att skicka info till en java server (en klass jag skapat)

Här är koden som funkade för mig.

Vad som händer med denna koden är att du skickar meddelandet i socket\_write till java klassen som i sin tur skickar tillbaks.

jag hade host till 127.0.0.1 först men det funkade inte och var tvungen och skriva mitt lokala närtverksaddress: 192.168.1.2

note 49289 är random port jag har öppen.

Angående sockets i php så måste de vara "enabled", kolla med <?php phpinfo(); ?>, sök på sockets ska stå att de är enabled. Om inte så måste php.ini ändras. semikolon vid socket extension tas bort och om inte redan gjorts sätta path på extension\_dir till ext mappen.



```

<?php


$socket = socket_create(AF_INET, SOCK_STREAM, SOL_TCP);
	
	if($socket === false) exit('blurg');
 
	socket_bind($socket, '192.168.1.2');
	
	socket_connect($socket, '192.168.1.2', 49289);
	
	socket_write($socket, "i am php, you are the server, give me some feedback\n");
	
	socket_write($socket,"BYE");

	socket_shutdown($socket, 1);
        
        echo socket_read($socket, 1000);
	
	socket_shutdown($socket, 0);
        
        socket_close($socket);

?>

```


```
public static void main(String[] args) throws IOException {

		ServerSocket server = new ServerSocket(49289, 5, InetAddress
				.getLocalHost());
		boolean done = false;
		Socket incoming = null;
		while (!done) {
			incoming = server.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					incoming.getInputStream()));
			PrintWriter out = new PrintWriter(incoming.getOutputStream(), true /* autoFlush */);

			String line=in.readLine();
			if (line != null) {

				out.println("hej");

				System.out.print(line + "\n");
                                String end = in.readLine();
				System.out.print(end + "\n");
                                
				if (end.trim().equals("BYE"))
					done = true;
			}

		}
		incoming.close();
	}

```