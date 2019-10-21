package Resurset;

import java.awt.*;
import java.awt.event.*;
import java.rmi.Naming;
import javax.swing.JOptionPane;
import javax.swing.JDialog;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ServerSide.ChessInterface;

public class windowChessBoard extends objChessBoard {

	private final int refreshRate = 5; 

	private Image[][] imgPlayer = new Image[2][6];
	private String[] strPlayerName = { "Player 1", "Player 2" };
	private String strStatusMsg = "";
	private objCellMatrix cellMatrix = new objCellMatrix();
	private int currentPlayer = 1, startRow = 0, startColumn = 0, pieceBeingDragged = 0;
	private int startingX = 0, startingY = 0, currentX = 0, currentY = 0, refreshCounter = 0;
	private boolean firstTime = true, hasWon = false, isDragging = false;

	private void resetBoard() {
		cellMatrix.resetMatrix();
	}

	public void setupImages(Image[] imgRed, Image[] imgBlue) {

		imgPlayer[0] = imgRed;
		imgPlayer[1] = imgBlue;
		resetBoard();

	}

	protected void drawExtra(Graphics g) {
		System.out.print(vecPaintInstructions.size());

		for (int i = 0; i < vecPaintInstructions.size(); i++) {

			currentInstruction = (objPaintInstruction) vecPaintInstructions.elementAt(i);
			int paintStartRow = currentInstruction.getStartRow();
			System.out.print(paintStartRow);
			int paintStartColumn = currentInstruction.getStartColumn();
			int rowCells = currentInstruction.getRowCells();
			int columnCells = currentInstruction.getColumnCells();

			for (int row = paintStartRow; row < (paintStartRow + rowCells); row++) {

				for (int column = paintStartColumn; column < (paintStartColumn + columnCells); column++) {

					int playerCell = cellMatrix.getPlayerCell(row, column);
					int pieceCell = cellMatrix.getPieceCell(row, column);

					if (playerCell != 0) {

						try {
							g.drawImage(imgPlayer[playerCell - 1][pieceCell], ((column + 1) * 50), ((row + 1) * 50),
									this);
						} catch (ArrayIndexOutOfBoundsException e) {
						}

					}

				}

			}

		}

		if (isDragging) {
			g.drawImage(imgPlayer[currentPlayer - 1][pieceBeingDragged], (currentX - 25), (currentY - 25), this);
		}

		g.setColor(new Color(0, 0, 0));
		g.drawString(strStatusMsg, 50, 475);

		vecPaintInstructions.clear(); // clear all paint instructions
	}

}