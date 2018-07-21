package modelo;

public class PagamentoDinheiro extends Pagamento {
	private int percentualDesconto;
	
	public PagamentoDinheiro(double p, int d){
		super(p);
		this.percentualDesconto = d;
	}

	public int getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(int percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}
	
	public void calcularPagamento(double total){
		setValorPago(total - (total * percentualDesconto) / 100);
	}
}
