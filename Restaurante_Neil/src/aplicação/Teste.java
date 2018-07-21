package aplicação;
import java.util.ArrayList;

import fachada.Fachada;
import modelo.Produto;
import modelo.Garcom;
import modelo.Mesa;
import modelo.Conta;

public class Teste {

	public static void main (String[] args) {  
		parte1();
		parte2();
		parte3();
		System.out.println("fim do teste");
	}

	public static void parte1(){
		try {   
			Produto p;
			p = Fachada.cadastrarProduto("feijoada", 25.0);
			p = Fachada.cadastrarProduto("bode guisado", 20.0);
			p = Fachada.cadastrarProduto("galinhada", 15.0);
			p = Fachada.cadastrarProduto("cerveja", 6.0);
			p = Fachada.cadastrarProduto("refrigerante", 5.0);
			p = Fachada.cadastrarProduto("agua", 2.0);
			ArrayList<Produto> produtos = Fachada.listarProdutos();


			Fachada.criarMesas(20);     // 20 mesas
			ArrayList<Mesa> mesas = Fachada.listarMesas();

			Garcom g;
			g = Fachada.cadastrarGarcom("baixinho", 1,5);
			g = Fachada.cadastrarGarcom("esperto", 6,10);
			g = Fachada.cadastrarGarcom("zezinho", 6,10);
			g = Fachada.cadastrarGarcom("Chafundifórnio", 16,20);
			ArrayList<Garcom> garcons = Fachada.listarGarcons();
			

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	 public static void parte2() {
		try {
			Fachada.criarConta(1);  //mesa 1
			Fachada.solicitarProduto(1, "galinhada");
			Fachada.solicitarProduto(1, "cerveja");
			Fachada.solicitarProduto(1, "refrigerante");
			Fachada.solicitarProduto(1, "cerveja");
			Fachada.solicitarProduto(1, "cerveja");
			Fachada.fecharConta(1);
			System.out.println("conta da mesa 1: \n"+ Fachada.consultarConta(1)); 


			Fachada.criarConta(6);  //mesa 5
			Fachada.solicitarProduto(6, "feijoada");
			Fachada.solicitarProduto(6, "cerveja");
			Fachada.fecharConta(6);
			System.out.println("conta da mesa 5: \n"+ Fachada.consultarConta(6)); 


			double gorjeta = Fachada.calcularGorjeta("baixinho");
			System.out.println("gorjeta do baixinho="+gorjeta);

			ArrayList<Conta> contas = Fachada.listarContas();
			System.out.println("contas existentes:");
			System.out.println(contas);

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void parte3() {
		try {
			Fachada.criarConta(11);  //mesa 1
			Fachada.solicitarProduto(11, "galinhada");
			Fachada.solicitarProduto(11, "cerveja");
			Fachada.fecharConta(11);
			System.out.println("conta da mesa 11: \n"+ Fachada.consultarConta(11)); 
			
			Fachada.criarConta(11);
			Fachada.solicitarProduto(11, "agua");
			Fachada.solicitarProduto(11, "refrigerante");
			System.out.println("conta da mesa 11: \n"+ Fachada.consultarConta(11)); 

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}