package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
public class ConsoleGameClient  
{ 
	public static void main(String[] args)  
	{ 
		GameManager gameManager = new GameManager();
		String IP = "127.0.0.1";
		String PORT = "1020";
		try
		{ 
			StringBuilder builder = new StringBuilder("rmi://");
			builder.append(IP)
			.append(":")
			.append(PORT)
			.append("/ConsoleGameService");

			System.out.println("Conectando ao servidor...");
			ConsoleGame c = (ConsoleGame) Naming.lookup(builder.toString());
			System.out.println("Conectado!\nCliente inicializado!");
			System.out.println("Bem vindo ao Console Survival");

			boolean gameOver = false;
			while(!gameOver){
				
				while(gameManager.getPlayer().getName() == null){
					System.out.print("Primeiro, qual � o seu nome guerreiro(a)?\n");
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					String input = br.readLine();
					gameManager.getPlayer().setName(input);					
				}
				gameOver = gameManager.getPlayer().isDead();
				System.out.print("Entre um comando (escreva help para listar os comandos):\n");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String input = br.readLine();
				gameManager = c.executeCommand(gameManager,input);
				
				System.out.println(gameManager.getMessage());
			}
			System.out.println("Fim de jogo"); 
		}  
		catch (Exception e)  
		{ 	
			System.out.println(e); 
		} 
	}
}
