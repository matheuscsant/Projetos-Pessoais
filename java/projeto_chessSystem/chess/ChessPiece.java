package br.com.cursoUdemy.projetos.projeto_chessSystem.chess;

import br.com.cursoUdemy.projetos.projeto_chessSystem.boardGame.Board;
import br.com.cursoUdemy.projetos.projeto_chessSystem.boardGame.Piece;
import br.com.cursoUdemy.projetos.projeto_chessSystem.boardGame.Position;

public abstract class ChessPiece extends Piece {

  private Color color;
  private int moveCount;

  public ChessPiece(Board board, Color color) {
	super(board);
	this.color = color;
  }

  public Color getColor() {
	return color;
  }

  public int getMoveCount() {
	return moveCount;
  }

  protected void increaseMoveCount() {
	moveCount++;
  }

  protected void decreaseMoveCount() {
	moveCount--;
  }

  protected boolean isThereOpponentPiece(Position position) {
	ChessPiece p = (ChessPiece) getBoard().piece(position);
	return p != null && p.getColor() != this.color;
  }

  public ChessPosition getChessPosition() {
	return ChessPosition.fromPosition(position);
  }
}
