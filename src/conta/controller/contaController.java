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

		if (del != null) {
			if (listaContas.remove(del) == true) {
				System.out.println("\nA conta de número: " + del.getNumero() + " Foi deletada com sucesso!");
			}
		} else {
			System.out.println("\nA conta com número: " + del.getNumero() + " não foi encontrado!");
		}

	}

	@Override
	public void sacar(int numero, float valor) {
		var buscar = buscar(numero);

		if (buscar != null) {

			if (listaContas.get(listaContas.indexOf(buscar)).sacar(valor) == true) {
				System.out.println("\nO saque da conta" + numero + " foi efetuado com sucesso!");
			}
			System.out.println("\nConta não encontrada!");
		}

	}

	@Override
	public void depoistar(int numero, float valor) {
		var busca = buscar(numero);

		if (buscar(numero) != null) {
			var indice = listaContas.indexOf(busca);
			listaContas.get(indice).depositar(valor);
			System.out.println("\nO depósito na conta " + numero + " foi efetuado com sucesso!");
		} else {
			System.out.println("\nA conta não foi encontrada!");
		}

	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var numOrigem = buscar(numeroOrigem);
		var numDest = buscar(numeroDestino);

		if (buscar(numeroOrigem) != null && buscar(numeroDestino) != null) {
			
			if (listaContas.get(listaContas.indexOf(numOrigem)).sacar(valor) == true) {
				listaContas.get(listaContas.indexOf(numDest)).depositar(valor);
				System.out.println("\nTransferência realizada com sucesso!");
			}
			
		} else {
			System.out.println("\nA conta de origem e/ou destino não foram encontradas");
		}

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
