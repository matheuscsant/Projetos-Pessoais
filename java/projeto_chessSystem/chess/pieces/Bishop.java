package br.com.cursoUdemy.projetos.projeto_chessSystem.chess.pieces;

import br.com.cursoUdemy.projetos.projeto_chessSystem.boardGame.Board;
import br.com.cursoUdemy.projetos.projeto_chessSystem.boardGame.Position;
import br.com.cursoUdemy.projetos.projeto_chessSystem.chess.ChessPiece;
import br.com.cursoUdemy.projetos.projeto_chessSystem.chess.Color;

public class Bishop extends ChessPiece {

  public Bishop(Board board, Color color) {
	super(board, color);
  }

  @Override
  public String toString() {
	return "B";
  }

  @Override
  public boolean[][] possibleMoves() {
	boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

	Position p = new Position(0, 0);

	// nw
	p.setValues(position.getRow() - 1, position.getColumn() - 1);
	while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
	  mat[p.getRow()][p.getColumn()] = true;
	  p.setValues(p.getRow() - 1, p.getColumn() - 1);
	}
	if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
	  mat[p.getRow()][p.getColumn()] = true;
	}

	// ne
	p.setValues(position.getRow() - 1, position.getColumn() + 1);
	while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
	  mat[p.getRow()][p.getColumn()] = true;
	  p.setValues(p.getRow() - 1, p.getColumn() + 1);
	}
	if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
	  mat[p.getRow()][p.getColumn()] = true;
	}

	// se
	p.setValues(position.getRow() + 1, position.getColumn() + 1);
	while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
	  mat[p.getRow()][p.getColumn()] = true;
	  p.setValues(p.getRow() + 1, p.getColumn() + 1);
	}
	if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
	  mat[p.getRow()][p.getColumn()] = true;
	}

	// sw
	p.setValues(position.getRow() + 1, position.getColumn() - 1);
	while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
	  mat[p.getRow()][p.getColumn()] = true;
	  p.setValues(p.getRow() + 1, p.getColumn() - 1);
	}
	if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
	  mat[p.getRow()][p.getColumn()] = true;
	}

	return mat;
  }

}
