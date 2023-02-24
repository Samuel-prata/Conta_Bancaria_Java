package conta.controller;

import java.util.ArrayList;

import conta.model.conta;
import conta.repository.contaRepository;

public class contaController implements contaRepository {

	private ArrayList<conta> listaContas = new ArrayList<conta>();

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscar(numero);
		if (conta != null) {
			conta.visualizar();
		}
		System.out.println("\nConta não encontrada ou não existe no sistema!");
	}

	@Override
	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar();
		}

	}

	@Override
	public void cadastrar(conta cont) {
		listaContas.add(cont);
		System.out.println("\nConta de número: " + cont.getNumero() + " Foi criada com sucesso");

	}

	@Override
	public void atualizar(conta cont) {
		var buscaConta = buscar(cont.getNumero());

		if (buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), cont);
			System.out.println("A conta de número: " + cont.getNumero() + " foi atualizada!!");
		} else {
			System.out.println("A conta de número: " + cont.getNumero() + " não foi encontrada !!");
		}
	}

	@Override
	public void deletar(int numero) {
		var del = buscar(numero);
		
		if(del != null) {
			if(listaContas.remove(del) == true) {
				System.out.println("\nA conta de número: "+del.getNumero()+" Foi deletada com sucesso!");
			}
		}else {
			System.out.println("\nA conta com número: "+del.getNumero()+" não foi encontrado!");
		}

	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void depoistar(int numero, float valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public int gerador() {
		return listaContas.size() + 1;
	}

	@Override
	public conta buscar(int numero) {
		for (var c : listaContas) {
			if (c.getNumero() == numero) {
				return c;
			}
		}
		return null;
	}

	public int retornaTipo(int numero) {

		for (var c : listaContas) {
			if (c.getNumero() == numero) {
				return c.getTipo();
			}
		}

		return 0;
	}

}
