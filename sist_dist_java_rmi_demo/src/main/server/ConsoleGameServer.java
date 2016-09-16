package main.server;
import main.*;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry; 

public class ConsoleGameServer  
{ 
	private String IP = "127.0.0.1";
	private String PORT = "1020";
    ConsoleGameServer() 
    { 
        try
        { 
        	System.out.println("Inicializando o servidor...");
        	LocateRegistry.createRegistry(Integer.parseInt(PORT));
            ConsoleGame c = new ConsoleGameImpl();
            
            StringBuilder builder = new StringBuilder("rmi://");
            builder.append(IP)
            		.append(":")
            		.append(PORT)
            		.append("/ConsoleGameService");
            		
            Naming.rebind(builder.toString(), c); 
        	System.out.println("Servidor inicializado no endereço: " + IP + ":" + PORT);
        }  
        catch (Exception e)  
        { 
            e.printStackTrace(); 
        } 
    } 
    public static void main(String[] args)  
    { 
        new ConsoleGameServer(); 
    } 
}   
