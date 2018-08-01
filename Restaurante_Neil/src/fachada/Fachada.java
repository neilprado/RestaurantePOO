package fachada;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TreeMap;

import repositorio.Restaurante;
import modelo.Conta;
import modelo.Garcom;
import modelo.Mesa;
import modelo.Pagamento;
import modelo.PagamentoCartao;
import modelo.PagamentoDinheiro;
import modelo.Produto;

public class Fachada {
	private static Restaurante restaurante = new Restaurante();
	private static int idconta = 0;

	public static ArrayList<Produto> listarProdutos(){
		return restaurante.getProdutos();
	}

	public static ArrayList<Produto> listarProdutos(String nome){
		ArrayList<Produto> prods = new ArrayList<>();

		for(Produto p: restaurante.getProdutos()) {
			if(p.getNome().contains(nome.toLowerCase()))
				prods.add(p);
		}
		return prods;
	}

	public static TreeMap<String, Garcom> listarGarcons(){
		return restaurante.getGarcons();
	}

	public static ArrayList<Mesa> listarMesas(){
		return restaurante.getMesas();
	}

	public static ArrayList<Conta> listarContas(){
		return restaurante.getContas();
	}

	public static void criarMesas(int n) throws Exception {
		Mesa m;
		if (n <= 0)
			throw new Exception ("N�mero de mesas inv�lido");
		else {
			for(int i = 1; i<=n; i++) {
				m = new Mesa(i);
				restaurante.adicionar(m);
			}
		}
	}

	public static Produto cadastrarProduto(String nome, double preco) throws Exception {
		Produto p = restaurante.localizarProduto(nome);
		if (p != null)
			throw new Exception (nome + " j� cadastrado!");
		else {
			p = new Produto (nome, preco);
			restaurante.adicionar(p);
			return p;
		}
	}

	public static Garcom cadastrarGarcom(String apelido, int inicio, int fim) throws Exception {
		Garcom g = restaurante.localizarGarcom(apelido);
		if (g!= null)
			throw new Exception("Sinto muito, gar�om j� cadastado!");
		if(fim - inicio != 4)
			throw new Exception ("Intervalos de mesa diferente de cinco");
		TreeMap<String, Garcom> garcons = restaurante.getGarcons();

		for (Garcom ga : garcons.values()) {
			for(Mesa me : ga.getMesas())
				if(me.getId()==inicio || me.getId()==fim)
					throw new Exception("N�o pode cadastrar essa mesa para o garcom" + apelido);

		}

		g = new Garcom(apelido);
		ArrayList<Mesa> mesas = new ArrayList<>();
		for(int i = inicio; i<= fim; i++)
			mesas.add(restaurante.localizarMesa(i));

		for(Mesa m: mesas)
			g.adicionar(m);
		restaurante.adicionar(g);
		return g;
	}

	/* ESSE M�TODO AINDA PRECISA SER MEXIDO */
	public static Conta criarConta(int id) throws Exception {
		Mesa m = restaurante.localizarMesa(id);
		if(m == null) 
			throw new Exception("Mesa " + id + " n�o cadastrada");
		else if (m.getGarcom() == null)
			throw new Exception ("Sinto muito, mesa " + id + " sem gar�om. Imposs�vel abrir a conta");
		else if (m.isOcupada())
			throw new Exception ("Mesa " + id + " ocupada");
		else {
			idconta++;
			Conta c = new Conta(idconta);
			m.adicionar(c);
			c.setMesa(m);
			c.getMesa().setOcupada(true);
			restaurante.adicionar(c);
			return c;
		}
	}

	public static Conta consultarConta(int id) throws Exception {
		Conta c = restaurante.localizarContaPorMesa(id);
		if(c == null)
			throw new Exception("Conta " + id + " n�o localizada");
		else
			return c;
	}

	public static Produto solicitarProduto(int id, String nome) throws Exception {
		Produto p = restaurante.localizarProduto(nome);
		if(p == null)
			throw new Exception("Produto " + nome + " n�o localizado" );
		else {
			Mesa m = restaurante.localizarMesa(id);
			if (m == null)
				throw new Exception ("Mesa " + id + " inexistente");
			else if (!m.isOcupada())
				throw new Exception ("Mesa " + id + " desocupada, a conta n�o est� em aberto");
			restaurante.localizarContaPorMesa(id).adicionar(p);
			return p;
		}

	}

	public static void cancelarConta(int id) throws Exception {
		Conta c = restaurante.localizarContaPorMesa(id);
		if(c == null)
			throw new Exception("Conta da mesa " + id + " n�o encontrada");
		else if(!c.getMesa().isOcupada())
			throw new Exception ("A mesa " + id + " n�o est� ocupada, n�o h� contas em aberto" );
		c.getMesa().setOcupada(false);
		c.getMesa().remover(c);
		restaurante.remover(c);


	}

	public static void transferirConta(int mesa_origem, int mesa_destino) throws Exception {
		Conta origem = restaurante.localizarContaPorMesa(mesa_origem);
		if(origem == null)
			throw new Exception ("Mesa " + mesa_origem + " inv�lida" );
		else if (!origem.getMesa().isOcupada())
			throw new Exception ("A mesa " + mesa_origem + " n�o est� ocupada, n�o h� contas em aberto" );
		Conta destino = restaurante.localizarContaPorMesa(mesa_destino);
		if(destino == null)
			throw new Exception ("Mesa " + mesa_destino + " inv�lida" );
		else if (!destino.getMesa().isOcupada())
			throw new Exception ("A mesa " + mesa_destino + " n�o est� ocupada, n�o h� contas em aberto" );
		if(!origem.getMesa().getGarcom().getApelido().equals(destino.getMesa().getGarcom().getApelido()))
			throw new Exception ("Imposs�vel transferir contas, gar�ons distintos!");
		for(Produto p: origem.getProdutos())
			destino.adicionar(p);
		cancelarConta(mesa_origem);
	}

	public static void fecharConta(int idmesa) throws Exception {
		Conta c = restaurante.localizarContaPorMesa(idmesa);
		if (c == null)
			throw new Exception ("Conta da mesa " + idmesa + " n�o encontrada");
		else if (!c.getMesa().isOcupada())
			throw new Exception ("Mesa " + idmesa + " sem contas em aberto");
		else {
			String data = Calendar.getInstance().getTime().toString();
			c.setDtfechamento(data);
			c.getMesa().setOcupada(false);
		}
	}

	public static double calcularGorjeta(String apelido) throws Exception {
		Garcom g = restaurante.localizarGarcom(apelido);
		double gorjeta = 0;
		if (g == null) 
			throw new Exception("Gar�om " + apelido + " n�o cadastrado!" );
		else {
			ArrayList<Conta> contas = restaurante.getContas();
			for (Conta c: contas) {
				if(c.getMesa().getGarcom().getApelido().equalsIgnoreCase(apelido))
					gorjeta += c.getPagamento().calcularGorjeta();
			}
		}
		return (gorjeta * 10)/100;
	}
	
	public static Pagamento pagarConta(int id, String tipo, int p, String card, int quantidade) throws Exception {
		Conta c = restaurante.localizarMesa(id).ultimaConta();	
		if (!tipo.equalsIgnoreCase("Dinheiro") && !tipo.equalsIgnoreCase("Cart�o"))
			throw new Exception ("Tipo de pagamento inv�lido, tente novamente!");
		if (c.getDtfechamento() == null)
			throw new Exception("A conta da mesa " + id + " est� aberta");
		if (p < 0 || p > 5)
			throw new Exception ("Desconto fora do intervalo permitido");
		if (tipo.equalsIgnoreCase("Dinheiro")) {
			Pagamento p1 = new PagamentoDinheiro(c.getTotal(), p);
			p1.calcularPagamento(c.getTotal());
			c.setPagamento(p1);
			return p1;			
		}else if (tipo.equalsIgnoreCase("Cart�o")) {
			Pagamento p2 = new PagamentoCartao(c.getTotal(), card, quantidade);
			if(quantidade > 1) {
				if (c.getTotal()/quantidade<100)
					throw new Exception ("Valor da parcela inv�lida");
			}
			p2.calcularPagamento(c.getTotal());
			c.setPagamento(p2);
			return p2;
		}
		return null;
	}
	
	public static void excluirGarcom(String apelido) throws Exception{
		Garcom g = restaurante.localizarGarcom(apelido);
		
		if (g == null)
			throw new Exception ("Gar�om " + apelido + " inexistente");
		for (Mesa m: g.getMesas()) {
			if(m.isOcupada())
				throw new Exception ("Gar�om " + apelido + " est� atendendo, imposs�vel remov�-lo");
		}
		for (Mesa m: g.getMesas())
			m.setGarcom(null);
		restaurante.remover(g);
	}
	
	public static double calcularPercentualMedio(String apelido) throws Exception{
		double total = 0;
		int num = 0;
		Garcom g = restaurante.localizarGarcom(apelido);
		if(g == null)
			throw new Exception ("Gar��m " + apelido + " inexistente");
		for(Mesa m: g.getMesas()) {
			for (Conta c: m.getContas()) {
				if(c.getPagamento() != null && c.getPagamento().getClass().getSimpleName().equals("PagamentoDinheiro")) {
					PagamentoDinheiro p1 = (PagamentoDinheiro) c.getPagamento();
					total += p1.getPercentualDesconto();
					num++;
				}
			}
		}
		
		if(total == 0)
			return 0;
		return total/num;
		
		
	}
}
