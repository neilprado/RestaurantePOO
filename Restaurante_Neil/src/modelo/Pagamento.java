package modelo;

public abstract class Pagamento {
	private double valorPago;
	
	public Pagamento(double p){
		this.valorPago = p;
	}
	
	public abstract void calcularPagamento(double total);

	public double calcularGorjeta(){
		return this.valorPago * 0.1;
	}
	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}

	@Override
	public String toString() {
		return "Pagamento [valorPago=" + valorPago + "]";
	}
	
	
	
}
