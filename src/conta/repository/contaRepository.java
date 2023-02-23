package conta.repository;
import conta.model.conta;
public interface contaRepository {
	
	//CRUD DA CONTA
	public void procurarPorNumero(int numero);
	public void listarTodas();
	public void cadastrar(conta cont);
	public void atualizar(conta cont);
	public void deletar(int numero);
	
	//METODOS BANCARIOS
	public void sacar(int numero, float valor);
	public void depoistar(int numero, float valor);
	public void transferir(int numeroOrigem, int numeroDestino, float valor);
	
}
