package Resurset;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class chessGUI {

	private windowChessBoard mainChessBoard;
	private objCreateAppletImage createImage;
	private JButton cmdNewGame, cmdSetNames;
	private JTextField txtPlayerOne, txtPlayerTwo;
	private JLabel lblPlayerOne, lblPlayerTwo;
	private String[] strRedPieces = { "bPawn.gif", "bRook.gif", "bKnight.gif", "bBishop.gif", "bQueen.gif",
			"bKing.gif" };
	private String[] strBluePieces = { "pawn.gif", "Rook.gif", "Knight.gif", "Bishop.gif", "Queen.gif", "King.gif" };
	private Color clrBlue = new Color(184, 184, 184);
	private MediaTracker mt;

	public void chessGUI() {
	}

	public Container createGUI(JFrame mainApp) { 

		JPanel panRoot = new JPanel(new BorderLayout());
		panRoot.setOpaque(true);
		panRoot.setPreferredSize(new Dimension(550, 650));

		mainChessBoard = new windowChessBoard();
		createImage = new objCreateAppletImage();

		mainChessBoard.setSize(new Dimension(500, 500));

		cmdNewGame = new JButton("New Game");
		cmdSetNames = new JButton("Set Names");

		txtPlayerOne = new JTextField("Player 1", 10);
		txtPlayerTwo = new JTextField("Player 2", 10);

		lblPlayerOne = new JLabel("    ", JLabel.RIGHT);
		lblPlayerTwo = new JLabel("    ", JLabel.RIGHT);

		try {

			Image[] imgRed = new Image[6];
			Image[] imgBlue = new Image[6];
			mt = new MediaTracker(mainApp);

			for (int i = 0; i < 6; i++) {
				imgRed[i] = createImage.getImage(this, "images/" + strRedPieces[i], 5000);
				imgBlue[i] = createImage.getImage(this, "images/" + strBluePieces[i], 5000);
				mt.addImage(imgRed[i], 0);
				mt.addImage(imgBlue[i], 0);

			}

			try {
				mt.waitForID(0);
			} catch (InterruptedException e) {
			}

			mainChessBoard.setupImages(imgRed, imgBlue);

		} catch (NullPointerException e) {

			JOptionPane.showMessageDialog(null,
					"Unable to load images. There should be a folder called images with all the chess pieces in it. Try downloading this programme again",
					"Unable to load images", JOptionPane.WARNING_MESSAGE);
			cmdNewGame.setEnabled(false);
			cmdSetNames.setEnabled(false);

		}

		JPanel panBottomHalf = new JPanel(new BorderLayout());
		JPanel panNameArea = new JPanel(new GridLayout(3, 1, 2, 2));
		JPanel panPlayerOne = new JPanel();
		JPanel panPlayerTwo = new JPanel();
		JPanel panNameButton = new JPanel();
		JPanel panNewGame = new JPanel();

		panRoot.add(mainChessBoard, BorderLayout.NORTH);
		panRoot.add(panBottomHalf, BorderLayout.SOUTH);
		panBottomHalf.add(panNameArea, BorderLayout.WEST);
		panNameArea.add(panPlayerOne);
		panPlayerOne.add(lblPlayerOne);
		panPlayerOne.add(txtPlayerOne);
		panNameArea.add(panPlayerTwo);
		panPlayerTwo.add(lblPlayerTwo);
		panPlayerTwo.add(txtPlayerTwo);
		panNameArea.add(panNameButton);
		panNameButton.add(cmdSetNames);
		panBottomHalf.add(panNewGame, BorderLayout.SOUTH);
		panNewGame.add(cmdNewGame);

		panRoot.setBackground(clrBlue);
		panBottomHalf.setBackground(clrBlue);
		panNameArea.setBackground(clrBlue);
		panPlayerOne.setBackground(clrBlue);
		panPlayerTwo.setBackground(clrBlue);
		panNameButton.setBackground(clrBlue);
		panNewGame.setBackground(clrBlue);

		lblPlayerOne.setBackground(new Color(0, 0, 0));
		lblPlayerTwo.setBackground(new Color(255, 255, 255));

		cmdNewGame.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		return panRoot;

	}

}