package modelo;

public class PagamentoCartao extends Pagamento {
	private String cartao;
	private int qtdParcelas;
	
	public PagamentoCartao(double valor, String c, int qtd) {
		super(valor);
		this.cartao = c;
		this.qtdParcelas = qtd;
	}
	
	@Override
	public void calcularPagamento(double total) {
		if(getQtdParcelas() == 1 || getQtdParcelas() == 2 && total/getQtdParcelas() >= 100)
			setValorPago(total);
		switch(getQtdParcelas()) {
			case 3:
				setValorPago(total * 1.1);
				break;
			case 4:
				setValorPago(total * 1.2);
				break;
		}
	}
	
	
	public String getCartao() {
		return cartao;
	}
	public void setCartao(String cartao) {
		this.cartao = cartao;
	}
	public int getQtdParcelas() {
		return qtdParcelas;
	}
	public void setQtdParcelas(int qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}
	
	

}
