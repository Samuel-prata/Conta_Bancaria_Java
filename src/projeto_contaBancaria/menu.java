package projeto_contaBancaria;

import java.util.Scanner;

public class menu {

	public static void main(String[] args) {
Scanner l = new Scanner (System.in);
		
		//VARIAVEIS
		int op;
		
		while (true) {
					
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
			System.out.println("                                                    ");
			
			op = l.nextInt();
			
			if(op == 9) {
				System.out.println("\nBanco do Brazil - o seu futuro começa aqui!");
				l.close();
				System.exit(0);
			}
			
			switch(op) {
			case 1: 
				System.out.println("Criar conta\n\n");
				break;
				
			case 2: 
				System.out.println("Listar todas as contas\n\n");
				break;
				
			case 3: 
				System.out.println("Consultar dados da conta por número\n\n");
				break;
				
			case 4: 
				System.out.println("Atualizar dados da conta\n\n");
				break;
				
			case 5: 
				System.out.println("Apagar conta\n\n");
				break;
				
			case 6: 
				System.out.println("Sacar\n\n");
				break;
				
			case 7: 
				System.out.println("Depósito\n\n");
				break;
				
			case 8: 
				System.out.println("Transferência\n\n");
				break; 
				
			default:
				System.out.println("\nOpção inválida!");
				break;
			}
		
		
		}

	}

}
