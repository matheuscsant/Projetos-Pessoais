package br.com.cursoudemy.model;

import br.com.cursoudemy.helper.Utils;

public class Produto {
  private static int contador = 1;
  private int codigo;
  private String nome;

  public Produto(String nome, Double preco) {
    this.codigo = Produto.contador;
    this.nome = nome;
    this.preco = preco;
    Produto.contador++;
  }

  public int getCodigo() {
    return codigo;
  }

  private Double preco;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Double getPreco() {
    return preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }

  @Override
  public String toString() {
    return "\nCódigo: " + this.getCodigo() +
        "\nNome: " + this.getNome() +
        "\nPreço: " + Utils.doubleParaString(this.getPreco());
  }
}
