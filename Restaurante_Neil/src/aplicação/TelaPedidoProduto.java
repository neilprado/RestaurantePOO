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

public class TelaPedidoProduto extends JFrame {

	private JPanel contentPane;
	private JTextField inputProduto;
	private JTextField inputMesa;
	private JLabel lblProd;
	private JLabel lblMesa;
	private JButton btnSolicitar;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPedidoProduto frame = new TelaPedidoProduto();
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
	public TelaPedidoProduto() {
		setTitle("Solicitar Produto");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 311, 177);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		inputProduto = new JTextField();
		inputProduto.setBounds(98, 11, 86, 20);
		contentPane.add(inputProduto);
		inputProduto.setColumns(10);

		lblProd = new JLabel("Produto");
		lblProd.setBounds(10, 14, 46, 14);
		contentPane.add(lblProd);

		lblMesa = new JLabel("Mesa número: ");
		lblMesa.setBounds(10, 52, 78, 14);
		contentPane.add(lblMesa);

		inputMesa = new JTextField();
		inputMesa.setBounds(98, 49, 86, 20);
		contentPane.add(inputMesa);
		inputMesa.setColumns(10);

		btnSolicitar = new JButton("Solicitar");
		btnSolicitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				try{
					if(inputProduto.getText().equals("") || inputMesa.getText().equals(""))
						throw new Exception ("Campos em branco, tente novamente!");
					String nome = inputProduto.getText();
					int id = Integer.parseInt(inputMesa.getText());
					Fachada.solicitarProduto(id, nome);
					lblStatus.setText(nome + " solicitado para a mesa " + id + " com sucesso");
					
					inputProduto.setText("");
					inputMesa.setText("");
					inputProduto.requestFocus();
				}
				catch(Exception e2){
					lblStatus.setText(e2.getMessage());
				}
			}
		});
		btnSolicitar.setBounds(83, 80, 115, 23);
		contentPane.add(btnSolicitar);
		
		lblStatus = new JLabel("");
		lblStatus.setBounds(10, 114, 273, 14);
		contentPane.add(lblStatus);
	}
}