package br.com.cursoUdemy.projetos.projeto_chessSystem.boardGame;

public class Position {

  private Integer row;
  private Integer column;

  public Position(Integer row, Integer column) {
	this.row = row;
	this.column = column;
  }

  public Integer getRow() {
    return this.row;
  }

  public void setRow(Integer row) {
    this.row = row;
  }

  public Integer getColumn() {
    return this.column;
  }

  public void setColumn(Integer column) {
    this.column = column;
  }
  
  public void setValues(int row, int column) {
	this.row = row;
	this.column = column;
  }

  @Override
  public String toString() {
    return this.getRow() + ", " + this.getColumn();
  }
}
