package conta;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		int opcao;
		while(true) {
			System.out.println("\n-------------------------------------------------");
			System.out.println("\n BANCO DO BRASIL COM Z");
			System.out.println("\n-------------------------------------------------");
			System.out.println("\n(1) Criar conta");
			System.out.println("\n(2) Listar todas as contas");
			System.out.println("\n(3) Buscar conta por número");
			System.out.println("\n(4) Atualizar dados da conta");
			System.out.println("\n(5) Apagar conta");
			System.out.println("\n(6) Sacar");
			System.out.println("\n(7) Depositar");
			System.out.println("\n(8) Transferir valores entre contas");
			System.out.println("\n(9) Sair");
			System.out.println("\n-------------------------------------------------");
			System.out.println("\nPor favor, digite a opção: ");
			opcao = leia.nextInt();
			if(opcao==9) {
				System.out.println("/n Banco do Brazil com z - o futuro começa aqui");
				leia.close();
				System.exit(0);
			}
				switch (opcao) {
				case 1:
					System.out.println("\n Criar conta \n ");
					
					break;
				case 2:
					
					System.out.println("\n Listar todas as contas:");
				
					break;
				case 3:
					System.out.println("\n Consultar dados da conta - por número: ");
					break;
				case 4:
					System.out.println("\nAtualizar dados da conta: ");
					break;
				case 5:
					System.out.println("\nApagar a conta: ");
					break;
				case 6:
					System.out.println("\nSaque: ");
					break;
				case 7:
					System.out.println("\nDepósito: ");
					break;
				case 8:
					System.out.println("\nTransferência entre contas: ");
					break;
					default:
					System.out.println("\nOpção inválida!!!");
				}
			}
		}
		
	}


