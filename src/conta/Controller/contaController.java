package conta.Controller;
import java.util.ArrayList;

import conta.Repository.ContaRepository;
import conta.model.conta;

public class contaController implements ContaRepository {

	private ArrayList<conta> listaContas = new ArrayList<conta>();
	
	@Override
	public void procurarPorNumero(int numero) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub
		
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

}
