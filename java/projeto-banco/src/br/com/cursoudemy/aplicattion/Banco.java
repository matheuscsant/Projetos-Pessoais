package br.com.cursoudemy.aplicattion;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.cursoudemy.entities.Cliente;
import br.com.cursoudemy.entities.Conta;
import br.com.cursoudemy.helper.Utils;

public class Banco {
  static String nome = "Geek Bank";
  static Scanner teclado = new Scanner(System.in);
  static ArrayList<Conta> contas;

  /**
   * ! Incluido a extensão Better comments; ! - Caso de uso (Não usar!) * - Caso de uso
   * (Importante) ? - Caso de uso (Dúvida)
   */

  /**
   * @param args
   */
  public static void main(String[] args) {
	Banco.contas = new ArrayList<Conta>();
	Banco.menu();
  }

  private static void menu() {
	int opcao = 0;
	System.out.println("==============================================");
	System.out.println("==================== ATM =====================");
	System.out.println("================= " + Banco.nome + " ==================");
	System.out.println("==============================================");
	System.out.println("Selecione uma opção no menu: ");
	System.out.println("1 - Criar conta");
	System.out.println("2 - Alterar limite");
	System.out.println("3 - Efetuar saque");
	System.out.println("4 - Efetuar depósito");
	System.out.println("5 - Efetuar transferência");
	System.out.println("6 - Listar contas");
	System.out.println("7 - Sair do sistema");

	try {
	  opcao = Integer.parseInt(Banco.teclado.nextLine());
	} catch (NumberFormatException e) {
	  System.out.println("Por favor, informe uma opção válida");
	  Utils.pausar(1);
	  Banco.menu();
	}

	switch (opcao) {
	case 1:
	  Banco.criarConta();
	  break;

	case 2:
	  Banco.alteracaoDeLimite();
	  break;

	case 3:
	  Banco.efetuarSaque();
	  break;

	case 4:
	  Banco.efetuarDeposito();
	  break;

	case 5:
	  Banco.efetuarTransferencia();
	  break;

	case 6:
	  Banco.listarContas();
	  break;

	case 7:
	  System.out.println("Até a próxima!");
	  Utils.pausar(2);
	  System.exit(0);
	  break;

	default:
	  System.out.println("Opção inválida.");
	  Utils.pausar(2);
	  Banco.menu();
	  break;
	}
  }

  private static void alteracaoDeLimite() {
	if (Banco.contas.size() > 0) {
	  System.out.println("Informe o número da conta para análise de limite: ");
	  int numero = Banco.teclado.nextInt();
	  Conta c = Banco.buscarContaPorNumero(numero);
	  if (c != null) {
		System.out.println("Analisando seu saldo e limite para possibilidade de aumento");
		Utils.pausar(4);
		c.alterarLimite();
	  }
	  else {
		System.out.println("Não foi encontrada a conta com número: " + numero);
	  }
	}
	else {
	  System.out.println("Não existem contas cadastradas ainda.");
	}

	Banco.teclado.nextLine();
	Utils.pausar(3);
	Banco.menu();
  }

  private static void listarContas() {
	if (Banco.contas.size() > 0) {
	  System.out.println("Listando contas\n");
	  // * Banco.contas.forEach(System.out::println); -> Method Reference
	  // * Banco.contas.forEach(c -> System.out.println(c)); -> Expressão lambda
	  for (Conta conta : contas) {
		System.out.println(conta);
		System.out.println();
		Utils.pausar(1);
	  }
	}
	else {
	  System.out.println("Não existem contas cadastradas ainda.");
	}

	Utils.pausar(3);
	Banco.menu();
  }

  private static void efetuarTransferencia() {
	System.out.println("Informe o número da sua conta: ");
	int numero_o = Banco.teclado.nextInt();

	Conta conta_o = Banco.buscarContaPorNumero(numero_o);

	if (conta_o != null) {
	  System.out.println("Informe o número da conta destino: ");
	  int numero_d = Banco.teclado.nextInt();

	  Conta conta_d = Banco.buscarContaPorNumero(numero_d);

	  if (conta_d != null) {
		System.out.println("Informe o valor da transferência: ");
		Double valor = Banco.teclado.nextDouble();

		conta_o.tranferir(conta_d, valor);
	  }
	  else {
		System.out.println("Não foi encontrado a conta destino número: " + numero_d);
	  }

	}
	else {
	  System.out.println("Não foi encotrado a conta número: " + numero_o);
	}

	Banco.teclado.nextLine();
	Utils.pausar(3);
	Banco.menu();
  }

  private static void efetuarDeposito() {
	System.out.println("Informe o número da conta: ");
	int numero = Banco.teclado.nextInt();
	Conta conta = Banco.buscarContaPorNumero(numero);

	if (conta != null) {
	  System.out.println("Informe o valor para depósito: ");
	  Double valor = Banco.teclado.nextDouble();

	  conta.depositar(valor);
	}
	else {
	  System.out.println("Não foi encontrada a conta número: " + numero);
	}

	Banco.teclado.nextLine();
	Utils.pausar(3);
	Banco.menu();
  }

  private static void efetuarSaque() {
	System.out.println("Informe o número da conta: ");
	int numero = Banco.teclado.nextInt();
	Conta conta = Banco.buscarContaPorNumero(numero);

	if (conta != null) {
	  System.out.println("Informe o valor para saque: ");
	  Double valor = Banco.teclado.nextDouble();

	  conta.sacar(valor);
	}
	else {
	  System.out.println("Não foi encontrada a conta número: " + numero);
	}

	Banco.teclado.nextLine();
	Utils.pausar(3);
	Banco.menu();
  }

  /**
   * @param numero
   *          da conta para buscar na lista
   * @return Conta do número informado se encontrado
   */
  private static Conta buscarContaPorNumero(int numero) {
	Conta cRetorno = null;
	if (Banco.contas.size() > 0) {
	  for (Conta c : Banco.contas) {
		if (c.getNumero() == numero) {
		  cRetorno = c;
		  return cRetorno;
		}
	  }
	}
	return cRetorno;
  }

  private static void criarConta() {

	System.out.println("Informe se deseja cadastrar uma conta PJ ou PF: ");
	String tipoConta = teclado.nextLine();

	if (tipoConta.equalsIgnoreCase("PF")) {
	  System.out.println("Informe os dados do cliente: ");

	  System.out.println("Nome do cliente: ");
	  String nome = Banco.teclado.nextLine();

	  System.out.println("Email do cliente: ");
	  String email = Banco.teclado.nextLine();

	  System.out.println("CPF do cliente: ");
	  String cpf = Banco.teclado.nextLine();

	  System.out.println("Data de nascimento do cliente: ");
	  String data_nascimento = Banco.teclado.nextLine();

	  Cliente cliente = new Cliente(nome, email, cpf, Utils.stringParaDate(data_nascimento));
	  Conta conta = new Conta(cliente);
	  Banco.contas.add(conta);

	  System.out.println("Conta criada com sucesso!");
	  System.out.println("Dados da conta criada: ");
	  System.out.println();
	  System.out.println(conta);
	  System.out.println();
	}
	else if (tipoConta.equalsIgnoreCase("PJ")) {
	  System.out.println("Informe os dados do cliente: ");

	  System.out.println("Nome do cliente: ");
	  String nome = Banco.teclado.nextLine();

	  System.out.println("Email do cliente: ");
	  String email = Banco.teclado.nextLine();

	  System.out.println("CNPJ do cliente: ");
	  String cnpj = Banco.teclado.nextLine();

	  System.out.println("Data de nascimento do cliente: ");
	  String data_nascimento = Banco.teclado.nextLine();

	  Cliente cliente = new Cliente(nome, email, cnpj, Utils.stringParaDate(data_nascimento));
	  Conta conta = new Conta(cliente);
	  Banco.contas.add(conta);

	  System.out.println("Conta criada com sucesso!");
	  System.out.println("Dados da conta criada: ");
	  System.out.println();
	  System.out.println(conta);
	  System.out.println();
	}
	else {
	  System.out.println("Resposta inválida, tente novamente.");
	}

	Utils.pausar(5);
	Banco.menu();
  }
}
