package projeto_contaBancaria;

import java.util.Scanner;

import conta.model.conta;
import conta.model.contaCorrente;
import conta.model.contaPoupança;
import conta.util.cores;

public class menu {

	public static void main(String[] args) {

		// TESTE CLASSE CONTA CORRENTE
		contaCorrente cc1 = new contaCorrente(2, 123, 1, "Mariana", 1500.0f, 100.0f);
		cc1.visualizar();
		cc1.sacar(1200.0f);
		cc1.visualizar();
		cc1.depositar(500.0f);
		cc1.visualizar();

		// TESTE CLASSE CONTA POUPANÇA
		contaPoupança cp1 = new contaPoupança(3, 213, 2, "Enzo", 10000.0f, 15);
		cp1.visualizar();
		cp1.sacar(1200.0f);
		cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();

		Scanner l = new Scanner(System.in);

		// VARIAVEIS
		int op;

		while (true) {
			System.out.println(cores.TEXT_YELLOW + cores.ANSI_BLACK_BACKGROUND);
			System.out.println("----------------------------------------------------");
			System.out.println("                                                    ");
			System.out.println("             BANCO DO BRAZIL COM Z                  ");
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

			op = l.nextInt();

			if (op == 9) {
				System.out.println(cores.TEXT_WHITE_BOLD + "\nBanco do Brazil - o seu futuro começa aqui!");
				l.close();
				System.exit(0);
			}

			switch (op) {
			case 1:
				System.out.println(cores.TEXT_WHITE_BOLD + "Criar conta\n\n");
				break;

			case 2:
				System.out.println(cores.TEXT_WHITE_BOLD + "Listar todas as contas\n\n");
				break;

			case 3:
				System.out.println(cores.TEXT_WHITE_BOLD + "Consultar dados da conta por número\n\n");
				break;

			case 4:
				System.out.println(cores.TEXT_WHITE_BOLD + "Atualizar dados da conta\n\n");
				break;

			case 5:
				System.out.println(cores.TEXT_WHITE_BOLD + "Apagar conta\n\n");
				break;

			case 6:
				System.out.println(cores.TEXT_WHITE_BOLD + "Sacar\n\n");
				break;

			case 7:
				System.out.println(cores.TEXT_WHITE_BOLD + "Depósito\n\n");
				break;

			case 8:
				System.out.println(cores.TEXT_WHITE_BOLD + "Transferência\n\n");
				break;

			default:
				System.out.println(cores.TEXT_RED_BOLD + "\nOpção inválida!");
				break;
			}

		}

	}

}
