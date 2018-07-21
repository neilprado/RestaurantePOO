package aplicação;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Produto;

public class TelaCadastrarProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textoNome;
	private JTextField textoPreco;
	private JLabel lblNome;
	private JLabel lblPreco;
	private JButton cadastro;
	private JLabel mensagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarProduto frame = new TelaCadastrarProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastrarProduto() {
		setTitle("Cadastro de Produtos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 311, 147);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textoNome = new JTextField();
		textoNome.setBounds(53, 11, 86, 20);
		contentPane.add(textoNome);
		textoNome.setColumns(10);

		lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 14, 46, 14);
		contentPane.add(lblNome);

		lblPreco = new JLabel("Preço");
		lblPreco.setBounds(10, 52, 46, 14);
		contentPane.add(lblPreco);

		textoPreco = new JTextField();
		textoPreco.setBounds(53, 49, 86, 20);
		contentPane.add(textoPreco);
		textoPreco.setColumns(10);

		cadastro = new JButton("Cadastrar");
		cadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(textoNome.getText().equals("") || textoPreco.getText().equals(""))
						throw new Exception ("Campos em branco, tente novamente");
					String nome = textoNome.getText();
					double preco = Double.parseDouble(textoPreco.getText());
					Produto p = Fachada.cadastrarProduto(nome, preco);
					mensagem.setText("Produto "+ p.getNome() + " cadastrado");
					
					textoNome.setText("");
					textoPreco.setText("");
					textoNome.requestFocus();
				}
				catch(Exception erro){
					mensagem.setText(erro.getMessage());
				}
			}
		});
		cadastro.setBounds(149, 32, 115, 23);
		contentPane.add(cadastro);
		
		mensagem = new JLabel("");
		mensagem.setBounds(10, 94, 273, 14);
		contentPane.add(mensagem);
	}
}
