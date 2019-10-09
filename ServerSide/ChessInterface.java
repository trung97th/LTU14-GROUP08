package ServerSide;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChessInterface extends Remote{
	public void Test() throws RemoteException;
}
