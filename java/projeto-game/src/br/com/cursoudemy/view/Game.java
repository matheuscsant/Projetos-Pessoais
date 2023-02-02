package br.com.cursoudemy.view;

import java.util.Scanner;

import br.com.cursoudemy.model.Calcular;

public class Game {

  static Scanner teclado = new Scanner(System.in);
  static int pontos = 0;
  static Calcular calc;

  public static void main(String[] args) {
    Game.jogar();
  }

  public static void jogar() {
    System.out.println("Informe o nível de dificuldade desejado [1, 2, 3, 4]: ");
    int dificuldade = Game.teclado.nextInt();

    Game.calc = new Calcular(dificuldade);

    System.out.println("Informe o resultado para a seguinte operação: ");

    if (calc.getOperacao() == 0) {
      // Somar
      System.out.println(calc.getValor1() + " + " + calc.getValor2());
      int resposta = Game.teclado.nextInt();

      if (calc.somar(resposta)) {
        // Ganha 1 ponto
        Game.pontos += 1;
        System.out.println("Você tem " + Game.pontos + " ponto(s).");
      }
    } else if (calc.getOperacao() == 1) {
      // Subtração
      System.out.println(calc.getValor1() + " - " + calc.getValor2());
      int resposta = Game.teclado.nextInt();

      if (calc.subtracao(resposta)) {
        // Ganha 1 ponto
        Game.pontos += 1;
        System.out.println("Você tem " + Game.pontos + " ponto(s).");
      }
    } else if (calc.getOperacao() == 2) {
      // Multiplicação
      System.out.println(calc.getValor1() + " x " + calc.getValor2());
      int resposta = Game.teclado.nextInt();

      if (calc.multiplicacao(resposta)) {
        // Ganha 1 ponto
        Game.pontos += 1;
        System.out.println("Você tem " + Game.pontos + " ponto(s).");
      }
    } else if (calc.getOperacao() == 3) {
      // Divisão
      System.out.println(calc.getValor1() + " / " + calc.getValor2());
      int resposta = Game.teclado.nextInt();

      if (calc.divisao(resposta)) {
        // Ganha 1 ponto
        Game.pontos += 1;
        System.out.println("Você tem " + Game.pontos + " ponto(s).");
      }
    } else if (calc.getOperacao() == 4) {
      // Ao Quadrado
      System.out.println(calc.getValor1() + "²");
      int resposta = Game.teclado.nextInt();

      if (calc.aoQuadrado(resposta)) {
        // Ganha 1 ponto
        Game.pontos += 1;
        System.out.println("Você tem " + Game.pontos + " ponto(s).");
      }
    } else {
      System.out.println("A operação " + calc.getOperacao() + " não é reconhecida.");
    }

    System.out.println("Deseja continuar? [1 - Sim, 2 - Não]");
    int continuar = Game.teclado.nextInt();
    if (continuar == 1) {
      Game.jogar();
    } else {
      System.out.println("Você fez " + Game.pontos + " ponto(s).");
      System.out.println("Até a próxima!");
      System.exit(0);
    }
  }
}
