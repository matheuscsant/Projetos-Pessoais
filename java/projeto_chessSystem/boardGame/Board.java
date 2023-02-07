package br.com.cursoUdemy.projetos.projeto_chessSystem.boardGame;

import br.com.cursoUdemy.projetos.projeto_chessSystem.exceptions.BoardException;

public class Board {
  private Integer rows;
  private Integer columns;
  private Piece[][] pieces;

  public Board(Integer rows, Integer columns) {
	if (rows < 1 || columns < 1) {
	  throw new BoardException(
		  "Erro ao criar tabuleiro: e necessario que tenha pelo menos uma linha ou coluna");
	}
	this.columns = columns;
	this.rows = rows;
	pieces = new Piece[rows][columns];
  }

  public Integer getColumns() {
	return columns;
  }

  public Integer getRows() {
	return rows;
  }

  public Piece piece(Integer row, Integer column) {
	if (!positionExists(row, column)) {
	  throw new BoardException("Posicao nao encontrada no tabuleiro.");
	}
	return pieces[row][column];
  }

  public Piece piece(Position position) {
	if (!positionExists(position)) {
	  throw new BoardException("Posicao nao encontrada no tabuleiro.");
	}
	return pieces[position.getRow()][position.getColumn()];
  }

  public void placePiece(Piece piece, Position position) {
	if (thereIsAPiece(position)) {
	  throw new BoardException("Ja existe uma peca nessa posicao: " + position);
	}
	pieces[position.getRow()][position.getColumn()] = piece;
	piece.position = position;
  }
  
  public Piece removePiece(Position position) {
	if (!positionExists(position)) {
	  throw new BoardException("Posicao nao encontrada no tabuleiro");
	}
	if (piece(position) == null) {
	  return null;
	}
	Piece aux = piece(position);
	aux.position = null;
	pieces[position.getRow()][position.getColumn()] = null;
	return aux;
  }

  private boolean positionExists(int row, int column) {
	return row >= 0 && row < this.rows && column >= 0 && column < this.columns;
  }

  public boolean positionExists(Position position) {
	return positionExists(position.getRow(), position.getColumn());
  }

  public boolean thereIsAPiece(Position position) {
	if (!positionExists(position)) {
	  throw new BoardException("Posicao nao encontrada no tabuleiro.");
	}
	return piece(position) != null;
  }
}
