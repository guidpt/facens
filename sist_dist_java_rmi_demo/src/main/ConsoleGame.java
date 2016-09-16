package main;

import java.rmi.Remote; 
import java.rmi.RemoteException; 
   
public interface ConsoleGame extends Remote 
{ 
	GameManager executeCommand(GameManager player, String input) throws RemoteException; 
}