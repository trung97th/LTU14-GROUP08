package ServerSide;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ChessImpl extends UnicastRemoteObject implements ChessInterface{
	
	public ChessImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void Test() throws RemoteException {
		System.out.println("Hello World");
	}

}