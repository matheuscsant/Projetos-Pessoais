package br.com.cursoUdemy.projetos.projeto_chessSystem.exceptions;

public class BoardException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public BoardException(String msg) {
	super(msg);
  }
}
