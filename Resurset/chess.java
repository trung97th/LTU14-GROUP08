 package Resurset;

import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ServerSide.ChessImpl;
import ServerSide.ChessInterface;

public class chess extends JFrame
{
	public static String IP   = "10.70.1.67";
	public static String PORT = "1099";
		
	public static void main(String[] args)
	{  
		try {
			ChessInterface stubChess= (ChessInterface)Naming.lookup("rmi://"+chess.IP+":"+chess.PORT+"/Chess");
			stubChess.Test();
			
			JFrame.setDefaultLookAndFeelDecorated(true); //Make it look nice
	        JFrame frame = new JFrame("Chess Game"); //Title
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	        
	        JPanel panRoot = new JPanel(new BorderLayout());
			panRoot.setOpaque(true);
			panRoot.setPreferredSize(new Dimension(550, 650));

	        
	        chessGUI chessWindow = new chessGUI();
	        frame.setContentPane(chessWindow.createGUI(frame));

//	        frame.addWindowFocusListener(chessWindow);
	        
	        frame.setSize(550,650);
	        frame.setResizable(false);
	        frame.setVisible(true);  
	        frame.pack();
		} catch (Exception re) {
			System.out.println("Connect Fail");
		}
    }
}
