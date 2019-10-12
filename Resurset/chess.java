 package Resurset;

import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import ServerSide.ChessImpl;
import ServerSide.ChessInterface;

public class chess
{
	public static String IP = "192.168.1.185";
	public static String PORT = "1099";
		
	public static void main(String[] args)
	{  
		try {
			ChessInterface stubChess= (ChessInterface)Naming.lookup("rmi://"
											+chess.IP+":"+chess.PORT+"/Chess");
			stubChess.Test();
		} catch (Exception re) {
			System.out.println("Connect Fail");
		}
    }
}
