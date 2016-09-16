package main.server;
import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject;

import main.ConsoleGame;
import main.GameManager;
import main.commands.ICommand;
import main.server.model.Player; 

public class ConsoleGameImpl extends UnicastRemoteObject implements ConsoleGame {
	
	public ConsoleGameImpl() throws RemoteException  
	{ 
		super(); 
	} 
	
	@Override
	public GameManager executeCommand(GameManager gameManager, String input) throws RemoteException {
		ICommand command = CommandParser.Parse(input);
		gameManager = command.Execute(gameManager);
		System.out.println("[" + gameManager.getPlayer().getName() + "]" + " Executando comando: " + input);
		return gameManager;
	} 
}
