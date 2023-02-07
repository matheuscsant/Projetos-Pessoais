package br.com.cursoUdemy.projetos.projeto_chessSystem.application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.com.cursoUdemy.projetos.projeto_chessSystem.chess.ChessMatch;
import br.com.cursoUdemy.projetos.projeto_chessSystem.chess.ChessPiece;
import br.com.cursoUdemy.projetos.projeto_chessSystem.chess.ChessPosition;
import br.com.cursoUdemy.projetos.projeto_chessSystem.exceptions.ChessException;

public class Program {

  public static void main(String[] args) {

	ChessMatch chessMatch = new ChessMatch();
	Scanner teclado = new Scanner(System.in);
	List<ChessPiece> captured = new ArrayList<>();

	while (!chessMatch.getCheckMate()) {
	  try {
		UI.clearScreen();
		UI.printMatch(chessMatch, captured);
		System.out.println();
		System.out.print("Source: ");
		ChessPosition source = UI.readChessPosition(teclado);

		boolean[][] possibleMoves = chessMatch.possibleMoves(source);
		UI.clearScreen();
		UI.printBoard(chessMatch.getPieces(), possibleMoves);

		System.out.println();
		System.out.print("Target: ");
		ChessPosition target = UI.readChessPosition(teclado);

		ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

		if (capturedPiece != null) {
		  captured.add(capturedPiece);
		}

		if (chessMatch.getPromoted() != null) {
		  System.out.print("Enter piece for promotion (B/N/R/Q): ");
		  String type = teclado.nextLine().toUpperCase();
		  while (!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q")) {
			System.out.print("Invalid value! Enter piece for promotion (B/N/R/Q): ");
			type = teclado.nextLine().toUpperCase();
		  }
		  chessMatch.replacePromotedPiece(type);
		}
	  } catch (ChessException e) {
		System.out.println(e.getMessage());
		teclado.nextLine();
	  } catch (InputMismatchException e) {
		System.out.println(e.getMessage());
		teclado.nextLine();
	  }

	}

	UI.clearScreen();
	UI.printMatch(chessMatch, captured);

  }

}
