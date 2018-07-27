package aplicação;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import fachada.Fachada;
import modelo.Conta;
import modelo.Garcom;
import modelo.Mesa;
import modelo.Produto;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaPrincipal {

	private JFrame frmPrincipal;
	private JMenu menuProduto;
	private JMenuItem itemCadastrarP;
	private JMenuItem itemListarP;
	private JMenu menuGarcom;
	private JMenuItem itemCadastrarG;
	private JMenuItem itemListarG;
	private JMenuItem itemCalcularGorjeta;
	private JMenu menuMesa;
	private JMenuItem itemListarM;
	private JMenuItem itemSolicitarProd;
	private JMenuItem itemPagarConta;
	private JMenuItem itemExcluir;
	private JMenuItem itemPercMed;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrincipal = new JFrame();
		frmPrincipal.setTitle("Le Pistole - Neil John");
		try {
			frmPrincipal.setContentPane(new FundoTela("img1.jpg"));
		} catch (IOException e1) {
		}	

		frmPrincipal.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				try{
					//  pre-cadastro
					Fachada.criarMesas(20);	
					Produto p;
					p = Fachada.cadastrarProduto("Foie gras", 210.0);
					p = Fachada.cadastrarProduto("Sauerkraut", 15.0);
					p = Fachada.cadastrarProduto("Fondue", 31.0);
					p = Fachada.cadastrarProduto("Skarfur", 120.0);
					p = Fachada.cadastrarProduto("Pierogi", 18.0);
					p = Fachada.cadastrarProduto("Szarlotka", 45.0);
					p = Fachada.cadastrarProduto("Borscht", 21.0);
					p = Fachada.cadastrarProduto("Miód Pitny", 17.0);
					p = Fachada.cadastrarProduto("Suco", 10.0);
					p = Fachada.cadastrarProduto("Água", 3.0);
					p = Fachada.cadastrarProduto("Refrigerante", 5.0);
					p = Fachada.cadastrarProduto("Cerveja", 10.0);
					Garcom g;
					g = Fachada.cadastrarGarcom("Pierre", 1, 5);
					g = Fachada.cadastrarGarcom("Bartosz", 6, 10);
					g = Fachada.cadastrarGarcom("Magnús", 11, 15);
					g = Fachada.cadastrarGarcom("Anton", 16, 20);
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			@Override
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(null, "Volte Sempre!!");
			}
		});

		frmPrincipal.setBounds(100, 100, 450, 320);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrincipal.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		frmPrincipal.setJMenuBar(menuBar);

		menuProduto = new JMenu("   Produto   ");
		menuBar.add(menuProduto);

		itemCadastrarP = new JMenuItem("Cadastrar");
		itemCadastrarP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrarProduto t = new TelaCadastrarProduto();
				t.setVisible(true);
			}
		});
		menuProduto.add(itemCadastrarP);

		itemListarP = new JMenuItem("Listar");
		itemListarP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListaProduto t = new TelaListaProduto();
				t.setVisible(true);
			}
		});
		menuProduto.add(itemListarP);
		
 
		menuMesa = new JMenu("       Mesa       ");
		menuBar.add(menuMesa);

		itemListarM = new JMenuItem("Listar");
		itemListarM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListaMesas t = new TelaListaMesas();
				t.setVisible(true);
			}
		});
		menuMesa.add(itemListarM);
		
		itemSolicitarProd = new JMenuItem("Sol. Produto");
		itemSolicitarProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaPedidoProduto t = new TelaPedidoProduto();
				t.setVisible(true);
			}
		});
		menuMesa.add(itemSolicitarProd);

		
		menuGarcom = new JMenu("   Garçom   ");
		menuBar.add(menuGarcom);

		itemCadastrarG = new JMenuItem("Cadastrar");
		itemCadastrarG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrarGarcom t = new TelaCadastrarGarcom();
				t.setVisible(true);
			}
		});
		menuGarcom.add(itemCadastrarG);

		itemListarG = new JMenuItem("Listar");
		itemListarG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListaGarcons t = new TelaListaGarcons();
				t.setVisible(true);
			}
		});
		menuGarcom.add(itemListarG);
		
		
		itemCalcularGorjeta = new JMenuItem("Gorjeta");
		itemCalcularGorjeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaGorjeta t = new TelaGorjeta();
				t.setVisible(true);
			}
		});
		menuGarcom.add(itemCalcularGorjeta);
		
		itemExcluir = new JMenuItem("Excluir");
		itemExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaExcluirGarcom j = new TelaExcluirGarcom();
				j.setVisible(true);
			}
		});
		
		menuGarcom.add(itemExcluir);
		
		itemPercMed = new JMenuItem("Perc Med");
		itemPercMed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaMediaPercentual tm = new TelaMediaPercentual();
				tm.setVisible(true);
			}
		});
		menuGarcom.add(itemPercMed);
		
		JMenu mnConta = new JMenu("     Conta     ");
		menuBar.add(mnConta); 

		JMenuItem mntmCriar = new JMenuItem("Criar");
		mntmCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAberturaConta t = new TelaAberturaConta();
				t.setVisible(true);
			}
		});
		mnConta.add(mntmCriar);

		JMenuItem mntmListarConta = new JMenuItem("Listar");
		mntmListarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaConta t = new TelaListaConta();
				t.setVisible(true);
			}
		});
		mnConta.add(mntmListarConta);

		JMenuItem mntmConsultarConta = new JMenuItem("Consultar");
		mntmConsultarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaConsultaConta t = new TelaConsultaConta();
				t.setVisible(true);
			}
		});
		mnConta.add(mntmConsultarConta);
		
		JMenuItem mntmCancelarConta = new JMenuItem("Cancelar");
		mntmCancelarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCancelaConta t = new TelaCancelaConta();
				t.setVisible(true);
			}
		});
		mnConta.add(mntmCancelarConta);
		
		JMenuItem mntmTransferirConta = new JMenuItem("Transferir");
		mntmTransferirConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaTransferenciaContas t = new TelaTransferenciaContas();
				t.setVisible(true);
			}
		});
		mnConta.add(mntmTransferirConta);
		
		JMenuItem mntmFecharConta = new JMenuItem("Fechar");
		mntmFecharConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaFechaConta t = new TelaFechaConta();
				t.setVisible(true);
			}
		});
		mnConta.add(mntmFecharConta);
		

		JMenuItem itemPagarConta = new JMenuItem("Pagar");
		itemPagarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaPagamentoConta j = new TelaPagamentoConta();
				j.setVisible(true);
			}
		});
		mnConta.add(itemPagarConta);
	
	}
}
