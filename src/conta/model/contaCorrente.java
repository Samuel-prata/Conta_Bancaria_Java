package conta.model;

public class contaCorrente extends conta {

	private float limite;

	public contaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;

	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

	public boolean sacar(float valor) {
		if (this.getSaldo() + this.getLimite() < valor) {
			System.out.println("\nSalod insuficiente!");
			return false;
		}
		this.setSaldo(getSaldo() - valor);
		return true;
	}
	public void visualizar() {
		super.visualizar();
		System.out.println("\nLimite de crédito: "+this.limite);
	}
}
