package br.com.cursoudemy.entities;

import java.time.LocalDate;

import br.com.cursoudemy.helper.Utils;

public class Cliente {
  private static int contador = 101;
  private int codigo;
  private String nome, email, cpfouCnpj, tipoCliente;
  private LocalDate dataNascimento;
  private LocalDate dataCadastro;
  private final int VALIDADOR_CPF_CNPJ = 13;

  /**
   * @return String
   */
  public String getTipoCliente() {
	return tipoCliente;
  }

  public Cliente(String nome, String email, String cpfOuCnpj, LocalDate dataNascimento) {
	this.codigo = Cliente.contador;
	this.nome = nome;
	this.email = email;
	this.cpfouCnpj = cpfOuCnpj;
	this.tipoCliente = (cpfOuCnpj.length() > VALIDADOR_CPF_CNPJ ? "Pessoa Júridica" : "Pessoa Fisíca");
	this.dataNascimento = dataNascimento;
	this.dataCadastro = LocalDate.now();
	Cliente.contador++;
  }

  /**
   * @return int
   */
  public int getCodigo() {
	return codigo;
  }

  /**
   * @return String
   */
  public String getNome() {
	return nome;
  }

  /**
   * @param nome
   */
  public void setNome(String nome) {
	this.nome = nome;
  }

  /**
   * @return String
   */
  public String getEmail() {
	return email;
  }

  /**
   * @param email
   */
  public void setEmail(String email) {
	this.email = email;
  }

  /**
   * @return String
   */
  public String getCpfouCnpj() {
	return cpfouCnpj;
  }

  /**
   * @param cpf
   */
  public void setCpfouCnpj(String cpf) {
	this.cpfouCnpj = cpf;
  }

  /**
   * @return Date
   */
  public LocalDate getDataNascimento() {
	return dataNascimento;
  }

  /**
   * @param dataNascimento
   */
  public void setDataNascimento(LocalDate dataNascimento) {
	this.dataNascimento = dataNascimento;
  }

  /**
   * @return Date
   */
  public LocalDate getDataCadastro() {
	return dataCadastro;
  }

  /**
   * @return String
   */
  @Override
  public String toString() {
	return "Código: " + this.getCodigo() + "\nNome: " + this.getNome() + "\nEmail: " + this.getEmail()
		+ validaCpfCnpj() + "\nData de Nascimento: " + Utils.dateParaString(this.getDataNascimento())
		+ "\nData de Cadastro: " + Utils.dateParaString(this.getDataCadastro());
  }

  String validaCpfCnpj() {
	if (this.getCpfouCnpj().length() > VALIDADOR_CPF_CNPJ) {
	  return "\nCNPJ: " + Utils.formatarStringParaCNPJ(cpfouCnpj);
	}
	else {
	  return "\nCPF: " + Utils.formatarStringParaCPF(cpfouCnpj);
	}
  }

}
