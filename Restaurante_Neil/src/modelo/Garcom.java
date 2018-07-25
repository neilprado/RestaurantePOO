package modelo;
import java.util.ArrayList;

public class Garcom implements Comparable<Garcom> {
	private String apelido;
	private ArrayList<Mesa> mesas = new ArrayList<>();
	
	public Garcom(String apelido) {
		this.apelido = apelido;
	}

	public void adicionar(Mesa m) {
		mesas.add(m);
		m.setGarcom(this);
	}
	
	public void remover (Mesa m) {
		mesas.remove(m);
		m.setGarcom(null);
	}
	
	public Mesa localizar (int id) {
		for(Mesa m: mesas) {
			if(m.getId() == id)
				return m;
		}
		return null;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public ArrayList<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(ArrayList<Mesa> mesas) {
		this.mesas = mesas;
	}

	@Override
	public String toString() {
		String texto = "Garcom [apelido= " + apelido + "] , mesas=[ ";
		if(mesas.isEmpty()) {
			texto+= "não tem mesas";
		}else {
			for(Mesa m: mesas) {
				texto+=m.getId()+" ,";
			}
		}
		texto+=" ]\n";
		return texto;
	}

	@Override
	public int compareTo(Garcom g1) {
		return this.getApelido().compareToIgnoreCase(g1.getApelido());
	}
	
}
