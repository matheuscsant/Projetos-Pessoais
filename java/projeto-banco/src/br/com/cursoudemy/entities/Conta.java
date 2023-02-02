package br.com.cursoudemy.entities;

import br.com.cursoudemy.helper.Utils;

public class Conta {
  private static int codigo = 1001;
  private int numero;
  private Cliente cliente;
  private Double saldo = 0.0;
  private Double limite = 0.0;
  private Double saldoTotal;

  public Conta(Cliente cliente) {
    this.numero = Conta.codigo;
    this.cliente = cliente;
    Conta.codigo++;
    this.atualizaSaldoTotal();
  }

  private void atualizaSaldoTotal() {
    this.saldoTotal = this.getSaldo() + this.getLimite();
  }

  /**
   * @return int
   */
  public int getNumero() {
    return numero;
  }

  /**
   * @return Cliente
   */
  public Cliente getCliente() {
    return cliente;
  }

  /**
   * @param cliente
   */
  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  /**
   * @return Double
   */
  public Double getSaldo() {
    return saldo;
  }

  /**
   * @param saldo
   */
  public void setSaldo(Double saldo) {
    this.saldo = saldo;
  }

  /**
   * @return Double
   */
  public Double getLimite() {
    return limite;
  }

  /**
   * @param limite
   */
  public void setLimite(Double limite) {
    this.limite = limite;
    this.atualizaSaldoTotal();
  }

  /**
   * @return Double
   */
  public Double getSaldoTotal() {
    return saldoTotal;
  }

  /**
   * @return String
   */
  @Override
  public String toString() {
    return "Número da Conta: " + this.getNumero() +
        "\nCliente: " + this.cliente.getNome() +
        this.cliente.validaCpfCnpj() +
        "\nTipo de Cliente: " + this.cliente.getTipoCliente() +
        "\nLimite Disponível: " + Utils.doubleParaString(this.getLimite()) +
        "\nSaldo Total: " + Utils.doubleParaString(this.getSaldoTotal());
  }

  /**
   * @param valor para depósito
   */
  public void depositar(Double valor) {
    if (valor > 0) {
      this.saldo = this.getSaldo() + valor;
      this.atualizaSaldoTotal();
      System.out.println("Depósito efetuado com sucesso!");
    } else {
      System.out.println("Erro ao efetuar depósito. Tente novamente.");
    }

  }

  /**
   * @param valor para saque
   */
  public void sacar(Double valor) {
    if (valor > 0 && this.getSaldoTotal() >= valor) {
      if (this.getSaldo() >= valor) {
        this.saldo = this.getSaldo() - valor;
        this.atualizaSaldoTotal();
        System.out.println("Saque efetuado com sucesso!");
      } else {
        Double restante = this.getSaldo() - valor;
        this.limite = this.getLimite() + restante;
        this.saldo = 0.0;
        this.atualizaSaldoTotal();
        System.out.println("Saque efetuado com sucesso!");
      }
    } else {
      System.out.println("Saque não realizado. Tente novamente");
    }
  }

  /**
   * @param destino
   * @param valor   para a conta destino
   */
  public void tranferir(Conta destino, Double valor) {
    if (valor > 0 && this.getSaldoTotal() >= valor) {
      if (this.getSaldo() >= valor) {
        this.saldo = this.getSaldo() - valor;
        destino.saldo = destino.getSaldo() + valor;
        this.atualizaSaldoTotal();
        destino.atualizaSaldoTotal();
        System.out.println("Tranferência realizada com sucesso!");
      } else {
        Double restante = this.getSaldo() - valor;
        this.limite = this.getLimite() + restante;
        this.saldo = 0.0;
        destino.saldo = destino.getSaldo() + valor;
        this.atualizaSaldoTotal();
        destino.atualizaSaldoTotal();
        System.out.println("Tranferência realizada com sucesso!");
      }
    } else {
      System.out.println("Tranferência não realizada, tente novamente.");
    }
  }

  public void alterarLimite() {
    int contador = 0;
    for (int i = 1000; i < this.getSaldo(); i += 1000) {
      contador++;
    }
    Double novoLimite = 200.0 * contador;
    if (this.getLimite() < novoLimite) {
      this.setLimite(novoLimite);
      this.atualizaSaldoTotal();
      System.out.println("Novo limite liberado!");
      System.out.println("Agora seu limite é de: " + Utils.doubleParaString(novoLimite));
    } else if (novoLimite.equals(this.getLimite())) {
      System.out.println("Limite inalterado, tente novamente mais tarde.");
    } else {
      if (novoLimite < this.getLimite()) {
        this.setLimite(novoLimite);
        this.atualizaSaldoTotal();
        System.out
            .println("Devido a analises feitas, abaixamos seu limite para: " + Utils.doubleParaString(novoLimite));
      } else {
        System.out.println("Limite não liberado, tente novamente mais tarde.");
      }

    }
  }

}
