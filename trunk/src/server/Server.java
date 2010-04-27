package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import oldcrap.BeerFunctionality;


import model.Beverage;
import model.Database;

public class Server extends Thread {

	/**
	 * @param args
	 * @throws IOException
	 */
	private BeerFunctionality bf;
	 private ServerSocket server;
	 private Socket incoming;
	 private boolean done;
	 
	public Server(Database db, ServerSocket server){
		bf=new BeerFunctionality(db);
		 done = false;
		this.server =server;
		
	}
	
	public void run() { 
		try {
			server();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	private void server() throws UnknownHostException, IOException {
		
		server.setReuseAddress(true); 
      
       //server.setSoTimeout(0);
       done = false;
        
        while (!done) {
                try{
        		incoming = server.accept();
                }catch(IOException e){
                	break;
                }
                BufferedReader in = null;
                PrintWriter out = null;
                if(!incoming.isClosed()){
                in = new BufferedReader(new InputStreamReader(
                                incoming.getInputStream()));
                out = new PrintWriter(incoming.getOutputStream(), true /* autoFlush */);
                }
                String line=in.readLine();
                
                if (line != null) {
                		
                		if(line.trim().equals("BYE")){
                			// out.println("i am sever, you killed me, god(Simon) has to revive me");
                		}else if(line.trim().equals("")){//om man inte skciakr något 
                										//så hänger sig något =/, dock funkade inte detta
                			out.println("5");
                		}else if(line.trim().equals("roll")){
                			Beverage beer = bf.BeerOfTheMonth();
                			out.println("Beer Of The Month: " + beer.toString());
                		}	
                		else{
                			out.println("i am sever you sent me: " + line);
                		}
                        System.out.print(line + "\n");
                       // String end = in.readLine();
                        //System.out.print(end + "\n");
                        
                        if (line.trim().equals("BYE"))
                                done = true;
                }
                incoming.close();

        }
        System.out.println("server closed");
}
	
	public void killServer(){
		done=true;
		
       //System.exit(1); 
	}
	

}
