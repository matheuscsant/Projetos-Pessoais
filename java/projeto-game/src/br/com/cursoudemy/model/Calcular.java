package br.com.cursoudemy.model;

import java.util.Random;

import br.com.cursoudemy.exercicios.ex_sec4.Functions_Ex_Sec4;

public class Calcular {
  private int dificuldade, valor1, valor2, operacao, resultado;

  public Calcular(int dificuldade) {

    Random rand = new Random();

    this.operacao = rand.nextInt(5); // 0 - somar, 1 - subtração, 2 - multiplicar, 3 - divisão, 4 - ao quadrado
    this.dificuldade = dificuldade;

    controladorDeDificuldade(dificuldade, rand);
  }

  /**
   * @param dificuldade
   * @param rand
   */
  private void controladorDeDificuldade(int dificuldade, Random rand) {
    if (dificuldade == 1) {
      // Fácil
      this.valor1 = rand.nextInt(10); // 0 a 9
      this.valor2 = rand.nextInt(10); // 0 a 9
    } else if (dificuldade == 2) {
      // Médio
      this.valor1 = rand.nextInt(100); // 0 a 99
      this.valor2 = rand.nextInt(100); // 0 a 99
    } else if (dificuldade == 3) {
      // Dificil
      this.valor1 = rand.nextInt(1000); // 0 a 999
      this.valor2 = rand.nextInt(1000); // 0 a 999
    } else if (dificuldade == 4) {
      // Insano
      this.valor1 = rand.nextInt(10000); // 0 a 9999
      this.valor2 = rand.nextInt(10000); // 0 a 9999
    } else {
      // Ultra
      this.valor1 = rand.nextInt(100000); // 0 a 99999
      this.valor2 = rand.nextInt(100000); // 0 a 99999
    }
  }

  /**
   * @return int valor da dificuldade
   */
  public int getDificuldade() {
    return dificuldade;
  }

  /**
   * @return int valor1
   */
  public int getValor1() {
    return valor1;
  }

  /**
   * @return int valor2
   */
  public int getValor2() {
    return valor2;
  }

  /**
   * @return int operação a ser realizada
   */
  public int getOperacao() {
    return operacao;
  }

  /**
   * @return int resultado
   */
  public int getResultado() {
    return resultado;
  }

  /**
   * @return String
   */
  @Override
  public String toString() {
    String op;
    if (this.getOperacao() == 0) {
      op = "Somar";
    } else if (this.getOperacao() == 1) {
      op = "Subtração";
    } else if (this.getOperacao() == 2) {
      op = "Multiplicação";
    } else {
      op = "Operação desconhecida";
    }
    return "Valor 1: " + this.getValor1() +
        "\nValor 2: " + this.getValor2() +
        "\nDificuldade: " + this.getDificuldade() +
        "\nOperação: " + op;
  }

  /**
   * @param resposta valor do usuário para verificação
   * @return boolean true = acertou - false = errou
   */
  public boolean somar(int resposta) {
    this.resultado = (int) Functions_Ex_Sec4.soma((double) this.getValor1(), (double) this.getValor2());
    boolean certo = false;

    if (resposta == this.getResultado()) {
      System.out.println("Resposta correta!");
      certo = true;
    } else {
      System.out.println("Resposta errada!");
    }
    System.out.println(this.getValor1() + " + " + this.getValor2() + " = " + this.getResultado());
    return certo;
  }

  /**
   * @param resposta valor do usuário para verificação
   * @return boolean true = acertou - false = errou
   */
  public boolean subtracao(int resposta) {
    this.resultado = (int) Functions_Ex_Sec4.subtracao((double) this.getValor1(), (double) this.getValor2());
    boolean certo = false;

    if (resposta == this.getResultado()) {
      System.out.println("Resposta correta!");
      certo = true;
    } else {
      System.out.println("Resposta errada!");
    }
    System.out.println(this.getValor1() + " - " + this.getValor2() + " = " + this.getResultado());
    return certo;
  }

  /**
   * @param resposta valor do usuário para verificação
   * @return boolean true = acertou - false = errou
   */
  public boolean multiplicacao(int resposta) {
    this.resultado = (int) Functions_Ex_Sec4.multiplicacao((double) this.getValor1(), (double) this.getValor2());
    boolean certo = false;

    if (resposta == this.getResultado()) {
      System.out.println("Resposta correta!");
      certo = true;
    } else {
      System.out.println("Resposta errada!");
    }
    System.out.println(this.getValor1() + " x " + this.getValor2() + " = " + this.getResultado());
    return certo;
  }

  /**
   * @param resposta valor do usuário para verificação
   * @return boolean true = acertou - false = errou
   */
  public boolean divisao(int resposta) {
    this.resultado = (int) Functions_Ex_Sec4.divisao((double) this.getValor1(), (double) this.getValor2());
    boolean certo = false;

    if (resposta == this.getResultado()) {
      System.out.println("Resposta correta!");
      certo = true;
    } else {
      System.out.println("Resposta errada!");
    }
    System.out.println(this.getValor1() + " / " + this.getValor2() + " = " + this.getResultado());
    return certo;
  }

  /**
   * @param resposta valor do usuário para verificação
   * @return boolean true = acertou - false = errou
   */
  public boolean aoQuadrado(int resposta) {
    this.resultado = (int) Math.pow(getValor1(), 2);
    boolean certo = false;

    if (resposta == this.getResultado()) {
      System.out.println("Resposta correta!");
      certo = true;
    } else {
      System.out.println("Resposta errada!");
    }
    System.out.println(this.getValor1() + "² = " + this.getResultado());
    return certo;
  }

}
