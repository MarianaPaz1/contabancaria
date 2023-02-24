package conta.Controller;
import java.util.ArrayList;

import conta.Repository.ContaRepository;
import conta.model.conta;

public class contaController implements ContaRepository {

	private ArrayList<conta> listaContas = new ArrayList<conta>();
	
	@Override
	public void procurarPorNumero(int numero) {
		var conta= buscarNaCollection(numero);
		if(conta !=	null)
			conta.visualizar();
		else
			System.out.println("\n A conta número" + numero + "não foi encontrada");
}
	
		
	

	@Override
	public void listarTodas() {
		for (var conta: listaContas) {
			conta.visualizar();
		}
		
	}

	@Override
	public void cadastrar(conta conta) {
		listaContas.add(conta);
		System.out.println("A conta número: "+ conta.getNumero() + "foi criada com sucesso");
		
	}
	
	public int gerarNumero() {
		return listaContas.size() +1;
	}

	@Override
	public void atualizar(conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());
		if(buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println("\n A conta número: " + conta.getNumero()+ "foi atualizada com sucesso!" );
			
		}else 
			System.out.println("\n A conta número: " + conta.getNumero()+ "não foi encontrada!" );
	}

	@Override
	public void deletar(int numero) {
	var conta = buscarNaCollection(numero);
	if(conta != null) {
		if(listaContas.remove(conta)==true);
		System.out.println("\n Conta número: " +numero+ "foi deletada com sucesso!");
	}else
		System.out.println("\n Conta número: " +numero+ "não foi encontrada!");
	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub
		
	}
	
	public conta buscarNaCollection(int numero) {
		for (var conta: listaContas) {
			if(conta.getNumero()==numero) {
				return conta;
			}
	}
		return null;
	}
	public int retornaTipo(int numero) {
		for (var conta: listaContas) {
			if(conta.getNumero() == numero) {
				return conta.getTipo();
			}
		}
		return 0;
	}
	
		
}
