package br.com.cursoUdemy.projetos.projeto_chessSystem.chess;

import br.com.cursoUdemy.projetos.projeto_chessSystem.boardGame.Position;
import br.com.cursoUdemy.projetos.projeto_chessSystem.exceptions.ChessException;

public class ChessPosition {

  private char column;
  private int row;

  public ChessPosition(char column, int row) {
	if (column < 'a' || column > 'h' || row < 1 || row > 8) {
	  throw new ChessException("Erro ao instanciar ChessPosition. Posicoes v�lida de a1 a h8");
	}
	this.column = column;
	this.row = row;
  }

  public char getColumn() {
	return column;
  }

  public int getRow() {
	return row;
  }

  protected Position toPosition() {
	return new Position(8 - this.row, column - 'a');
  }

  protected static ChessPosition fromPosition(Position position) {
	return new ChessPosition((char) ('a' + position.getColumn()), 8 - position.getRow());
  }

  @Override
  public String toString() {
	return "" + this.column + this.row;
  }

}
