package modelo;
import java.util.ArrayList;

public class Mesa {
	private int id = 1;
	private boolean ocupada = false;
	private ArrayList<Conta> contas = new ArrayList<>();
	private Garcom garcom;
	
	public Mesa (int id) {	
		this.id = id;
	}
	
	public void adicionar(Conta c) {
		contas.add(c);
		c.setMesa(this);
	}
	
	public void remover(Conta c) {
		contas.remove(c);
		c.setMesa(null);
	}
	
	public Conta localizar (int id) {
		for (Conta c: contas) {
			if(c.getNumero() == id)
				return c;
		}
		return null;
	}
	
	public Conta ultimaConta () {
		if(contas.isEmpty())
			return null;
		return contas.get(contas.size()-1);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isOcupada() {
		return ocupada;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

	public ArrayList<Conta> getContas() {
		return contas;
	}

	public void setContas(ArrayList<Conta> contas) {
		this.contas = contas;
	}

	public Garcom getGarcom() {
		return garcom;
	}

	public void setGarcom(Garcom garcom) {
		this.garcom = garcom;
	}

	@Override
	public String toString() {
		String texto = "[ Mesa [ id= " + id + "] , Ocupada = [ "+ocupada+" ] Garçom = [";
		if(garcom==null) {
			texto+=" não tem garcom ";
		}else {
			texto+=" "+garcom.getApelido()+" ";
		}
		texto+=" ] ]\n";
		return texto;
		
	}
	
	
}
