package br.com.cursoudemy.aplicattion;

import br.com.cursoudemy.entities.Cliente;
import br.com.cursoudemy.entities.Conta;
import br.com.cursoudemy.helper.Utils;

public class Teste {

  public static void main(String[] args) {

    Cliente matheus = new Cliente("Matheus Campanhola Santos", "matheuscampanholasantos123@gmail.com", "123.456.789-10",
        Utils.stringParaDate("01/11/2001"));

    Cliente joyce = new Cliente("Joyce Fernanda", "joycefernanda@gmail.com", "123.456.789-10",
        Utils.stringParaDate("15/05/1998"));

    // System.out.println(matheus);
    // System.out.println();
    // System.out.println(joyce);

    Conta c101 = new Conta(matheus);
    Conta c102 = new Conta(joyce);

    // Depositando um valor positivo

    c101.depositar(500.0);
    c102.depositar(1200.0);

    // Depositando um valor zero

    // c101.depositar(0.0);
    // c102.depositar(0.0);

    // Depositando um valor negativo

    // c101.depositar(-150.0);
    // c102.depositar(-200.0);

    // Sacando um valor positivo no saldo suficiente
    // c101.sacar(200.0);
    // c102.sacar(500.0);

    // Sacando um valor 0
    // c101.sacar(0.0);

    // Sacando um valor negativo
    // c101.sacar(-100.0);

    // Setando um limite para c101
    c101.setLimite(500.0);

    // Sacando um valor maior que o saldo na conta
    // c101.sacar(600.0);

    c102.tranferir(c101, 100.0);

    System.out.println(c101);
    System.out.println();
    System.out.println(c102);
  }
}
