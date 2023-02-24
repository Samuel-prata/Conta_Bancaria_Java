package projeto_contaBancaria;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.contaController;
import conta.model.conta;
import conta.model.contaCorrente;
import conta.model.contaPoupança;
import conta.util.cores;

public class menu {

	public static void main(String[] args) {

		// CONTROLLER
		contaController contas = new contaController();

		// VARIAVEIS
		int op, numero, agencia, tipo, aniversario;
		String nomeTitular;
		float saldo, limite;

		// TESTE CLASSE CONTA CORRENTE
		//contaCorrente cc1 = new contaCorrente(2, 123, 1, "Mariana", 1500.0f, 100.0f);
		// cc1.visualizar();
		// cc1.sacar(1200.0f);
		// cc1.depositar(500.0f);
		// cc1.visualizar();

		// TESTE CLASSE CONTA POUPANÇA
		// contaPoupança cp1 = new contaPoupança(3, 213, 2, "Enzo", 10000.0f, 15);
		// cp1.visualizar();
		// cp1.sacar(1200.0f);
		// cp1.depositar(5000.0f);
		// cp1.visualizar();

		Scanner l = new Scanner(System.in);

		while (true) {
			System.out.println(cores.TEXT_YELLOW + cores.ANSI_BLACK_BACKGROUND);
			System.out.println("----------------------------------------------------");
			System.out.println("                                                    ");
			System.out.println("             BANCO SAM-THUNDER                      ");
			System.out.println("                                                    ");
			System.out.println("----------------------------------------------------");
			System.out.println("                                                    ");
			System.out.println("          1. Criar conta                            ");
			System.out.println("          2. listar toda as contas                  ");
			System.out.println("          3. Buscar conta por numero                ");
			System.out.println("          4. Atualizar dados da conta               ");
			System.out.println("          5. Apagar conta                           ");
			System.out.println("          6. Sacar                                  ");
			System.out.println("          7. Depositar                              ");
			System.out.println("          8. Transferir valor entre contas          ");
			System.out.println("          9. Sair                                   ");
			System.out.println("                                                    ");
			System.out.println("----------------------------------------------------");
			System.out.println("Entre com a opção desejada:                         ");
			System.out.println("                                                    " + cores.TEXT_RESET);


			try {
				op = l.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros: ");
				l.nextLine();
				op = 0;
			}

			if (op == 9) {
				System.out.println(cores.TEXT_WHITE_BOLD + "\nSAMTHUNDER - o banco mais rápido do Brasil!");
				l.close();
				System.exit(0);
			}

			switch (op) {

			case 1:
				System.out.println(cores.TEXT_WHITE_BOLD + "Criar conta\n\n");
				System.out.println("\nDigite o número da agência: ");
				agencia = l.nextInt();

				System.out.println("\nDigite o nome do titular: ");
				l.skip("\\R?");
				nomeTitular = l.nextLine();

				do {
					System.out.println("\nDigite o tipo de conta");
					System.out.println("(1) Para CC (Conta corrente)");
					System.out.println("(2) Para CP (Conta Poupança)");
					tipo = l.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("\nDigite o Saldo: ");
				saldo = l.nextFloat();

				switch (tipo) {

				case 1 -> {
					System.out.println("\nDigite o limite de crédito: ");
					limite = l.nextFloat();
					contas.cadastrar(new contaCorrente(contas.gerador(), agencia, tipo, nomeTitular, saldo, limite));
				}

				case 2 -> {
					System.out.println("\nDigite o aniversário da conta: ");
					aniversario = l.nextInt();
					contas.cadastrar(
							new contaPoupança(contas.gerador(), agencia, tipo, nomeTitular, saldo, aniversario));
				}

				}

				keyPress();
				break;

			case 2:
				System.out.println(cores.TEXT_WHITE_BOLD + "Listar todas as contas\n\n");
				contas.listarTodas();
				keyPress();
				break;

			case 3:
				System.out.println(cores.TEXT_WHITE_BOLD + "Consultar dados da conta por número\n\n");
				System.out.println("\nDigite o número da conta: ");
				numero = l.nextInt();

				contas.procurarPorNumero(numero);

				keyPress();
				break;

			case 4:
				System.out.println(cores.TEXT_WHITE_BOLD + "Atualizar dados da conta\n\n");

				System.out.println("\nDigite o numero da conta: ");
				l.skip("\\R?");
				numero = l.nextInt();

				if (contas.buscar(numero) != null) {
					System.out.println("\nDigite o número da agência: ");
					agencia = l.nextInt();

					System.out.println("\nDigite o nome do titular: ");
					l.skip("\\R?");
					nomeTitular = l.nextLine();

					do {
						System.out.println("\nDigite o tipo de conta");
						System.out.println("(1) Para CC (Conta corrente)");
						System.out.println("(2) Para CP (Conta Poupança)");
						tipo = l.nextInt();
					} while (tipo < 1 && tipo > 2);

					System.out.println("\nDigite o Saldo: ");
					saldo = l.nextFloat();

					switch (tipo) {

					case 1 -> {
						System.out.println("\nDigite o limite de crédito: ");
						limite = l.nextFloat();
						contas.atualizar(new contaCorrente(numero, agencia, tipo, nomeTitular, saldo, limite));
					}

					case 2 -> {
						System.out.println("\nDigite o aniversário da conta: ");
						aniversario = l.nextInt();
						contas.atualizar(new contaPoupança(numero, agencia, tipo, nomeTitular, saldo, aniversario));
					}

					}
				} else {
					System.out.println("\nConta não encontrada!");
				}

				keyPress();
				break;

			case 5:
				System.out.println(cores.TEXT_WHITE_BOLD + "Apagar conta\n\n");

				System.out.println("\nDigite o número da conta: ");
				numero = l.nextInt();
				contas.deletar(numero);

				keyPress();
				break;

			case 6:
				System.out.println(cores.TEXT_WHITE_BOLD + "Sacar\n\n");
				keyPress();
				break;

			case 7:
				System.out.println(cores.TEXT_WHITE_BOLD + "Depósito\n\n");
				keyPress();
				break;

			case 8:
				System.out.println(cores.TEXT_WHITE_BOLD + "Transferência\n\n");
				keyPress();
				break;

			default:
				System.out.println(cores.TEXT_RED_BOLD + "\nOpção inválida!");
				keyPress();
				break;
			}

		}

	}

	public static void keyPress() {

		try {
			System.out.println(cores.TEXT_RESET + "\nPressione ENTER para continuar...");
			System.in.read();
			System.out.println();
		} catch (IOException e) {
			System.out.println("\nVocê digitou uma tecla diferente de ENTER...");
		}
	}
}
