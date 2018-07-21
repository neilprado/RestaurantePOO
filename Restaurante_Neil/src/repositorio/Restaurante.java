package repositorio;
import java.util.ArrayList;

import modelo.Conta;
import modelo.Garcom;
import modelo.Mesa;
import modelo.Produto;

public class Restaurante {
	private ArrayList<Produto> produtos = new ArrayList<>();
	private ArrayList<Garcom> garcons = new ArrayList<>();
	private ArrayList<Mesa> mesas = new ArrayList<>();
	private ArrayList<Conta> contas = new ArrayList<>();


	public void adicionar (Produto p) {
		produtos.add(p);
	}

	public void adicionar (Garcom g) {
		garcons.add(g);
	}

	public void adicionar (Mesa t) {
		mesas.add(t);
	}
	
	public void adicionar (Conta b) {
		contas.add(b);
	}

	public void remover (Produto p) {
		produtos.remove(p);
	}

	public void remover (Garcom g) {
		garcons.add(g);
	}

	public void remover (Mesa t) {
		mesas.add(t);
	}

	public void remover (Conta b) {
		contas.add(b);
	}

	public Produto localizarProduto (String nome) {
		for (Produto p: produtos) {
			if(p.getNome().equalsIgnoreCase(nome))
				return p;
		}
		return null;
	}

	public Garcom localizarGarcom (String nickname) {
		for (Garcom g: garcons) {
			if(g.getApelido().equalsIgnoreCase(nickname))
				return g;
		}
		return null;
	}

	public Mesa localizarMesa (int id) {
		for (Mesa m: mesas) {
			if(m.getId() == id)
				return m;
		}
		return null;
	}
	
	public Conta localizarConta (int id) {
		for (Conta c: contas) {
			if(c.getNumero() == id)
				return c;
		}
		return null;
	}
	
	public Conta localizarContaPorMesa (int idmesa) {
		Mesa m = localizarMesa(idmesa);
		if (m != null) {
			Conta c = m.ultimaConta();
			if (c!= null)
				return c;
		}
		return null;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public ArrayList<Garcom> getGarcons() {
		return garcons;
	}

	public void setGarcons(ArrayList<Garcom> garcons) {
		this.garcons = garcons;
	}

	public ArrayList<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(ArrayList<Mesa> mesas) {
		this.mesas = mesas;
	}

	public ArrayList<Conta> getContas() {
		return contas;
	}

	public void setContas(ArrayList<Conta> contas) {
		this.contas = contas;
	}
	
	
	
}
