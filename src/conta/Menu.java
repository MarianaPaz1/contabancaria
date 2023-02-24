package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.Controller.contaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	// public static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {
		contaController	contas = new contaController();
		Scanner leia= new Scanner(System.in);
		
		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;
System.out.println("\n Criar Conta");
		// Teste da Classe Conta Corrente
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "Jo�ozinha", 10000.0f, 1000.0f);
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria", 2000.0f, 1000.0f);
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana", 2000.0f, 12);
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 126, 2, "Julina", 2000.0f, 15);
		// Teste da Classe Conta Poupan�a
		//ContaPoupanca cp1 = new ContaPoupanca(2, 123, 2, "Lucas", 100000.0f, 15);
		/*cp1.visualizar();
		cp1.sacar(1000.0f);
		cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();*/

		while (true) {

			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO DO BRAZIL COM Z                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a op��o desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);
			
			try {
				opcao = leia.nextInt();
			}catch(InputMismatchException e){
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao=0;
			}

			if (opcao == 9) {
				System.out.println("\nBanco do Brazil com Z - O seu futuro come�a aqui!");
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("\n Criar Conta");
				System.out.println("\n Digite o n�mero da Ag�ncia:");
				agencia= leia.nextInt();
				System.out.println("\n Digite o n�mero do Titular:");
				leia.skip("\\R?");
				titular = leia.nextLine();
				do {
					System.out.println("Digite o Tipo da Conta (1-CC OU 2-CP): ");
					tipo=leia.nextInt();
				}while(tipo<1 && tipo>2);
				System.out.println("Digite o Saldo: ");
				saldo=leia.nextFloat();
				switch (tipo) {
				case 1 ->{
					System.out.println("Digite o limite de cr�dito: ");
					limite=leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 ->{
					System.out.println("Digite o anivers�rio da conta: ");
				aniversario = leia.nextInt();
				contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular,saldo,aniversario));
				}
				}
				keyPress();
				break;
				
				
			case 2:
				System.out.println("\n Listar todas as Contas");

				keyPress();
				break;
			case 3:
				System.out.println("\n Buscar Conta por n�mero");
				System.out.println("\n Digite o n�mero da Conta");
				numero = leia.nextInt();
				contas.procurarPorNumero(numero);
				keyPress();
				break;
			case 4:
				System.out.println("\n Atualizar dados da Conta");
				System.out.println("\n Digite o n�mero da Conta: ");
				numero = leia.nextInt();
				if(contas.buscarNaCollection(numero) != null) {
					System.out.println("\n Digite o n�mero da Ag�ncia: ");
					agencia = leia.nextInt();
					System.out.println("\n Digite o Nome de Titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
					System.out.println("\n Digite o Saldo da Conta: ");
					saldo = leia.nextFloat();
					
					tipo = contas.retornaTipo(numero);
					switch(tipo) {
					case 1 ->{
					System.out.println("\n Digite o limite de cr�dito: ");
					limite = leia.nextFloat();
					contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					
					
					}
					case 2->{
						System.out.println("\n Digite o dia do anivers�rio conta: ");
						aniversario = leia.nextInt();
						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					}
					default ->{
						System.out.println("\n Tipo de conta inv�lido! ");
					}
					}else {
						System.out.println("\n Conta n�o encontrada! ");
				}
			}
				keyPress();
				break;
				
			case 5:
				System.out.println("\n Apagar Conta");
				System.out.println("\n Digite o n�mero da conta: ");
				numero=leia.nextInt();
				contas.deletar(numero);
				keyPress();
				break;
			case 6:
				System.out.println("\n Sacar");

				keyPress();
				break;
			case 7:
				System.out.println("\n Depositar");

				keyPress();
				break;
			case 8:
				System.out.println("\n Transferir");

				keyPress();
				break;
			default:
				System.out.println("\nOp��o Inv�lida" + Cores.TEXT_RESET);
				
				keyPress();
				break;
			}
		}
}


	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Voc� pressionou uma tecla diferente de enter!");

		}
	}
}