package aplicação;

/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/
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

public class TelaPagamentoConta extends JFrame {

	private JPanel contentPane;
	private JTextField idMesa;
	private JLabel mesa;
	private JButton btnPago;
	private JLabel result;
	private JTextField pag;
	private JTextField p;
	private JTextField c;
	private JTextField qnt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPagamentoConta frame = new TelaPagamentoConta();
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
	public TelaPagamentoConta() {
		setTitle("Pagar Conta");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 208);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		mesa = new JLabel("Mesa:");
		mesa.setBounds(141, 11, 38, 14);
		contentPane.add(mesa);

		idMesa = new JTextField();
		idMesa.setBounds(178, 8, 28, 20);
		contentPane.add(idMesa);
		idMesa.setColumns(10);
		
		JLabel formaPag = new JLabel("Forma de Pagamento:");
		formaPag.setBounds(10, 41, 106, 14);
		contentPane.add(formaPag);
		
		pag = new JTextField();
		pag.setColumns(10);
		pag.setBounds(122, 38, 57, 20);
		contentPane.add(pag);
		
		JLabel txtCartao = new JLabel("cart\u00E3o:");
		txtCartao.setBounds(10, 69, 46, 14);
		contentPane.add(txtCartao);
		
		c = new JTextField();
		c.setColumns(10);
		c.setBounds(98, 66, 81, 20);
		contentPane.add(c);

		JLabel numeroParc = new JLabel("Parcelas:");
		numeroParc.setBounds(234, 69, 57, 14);
		contentPane.add(numeroParc);
				
		qnt = new JTextField();
		qnt.setColumns(10);
		qnt.setBounds(306, 69, 28, 20);
		contentPane.add(qnt);

		JLabel desc = new JLabel("Desconto: ");
		desc.setBounds(234, 41, 57, 14);
		contentPane.add(desc);

		p = new JTextField();
		p.setColumns(10);
		p.setBounds(306, 38, 28, 20);
		contentPane.add(p);
				
		result = new JLabel("");
		result.setBounds(10, 149, 324, 20);
		contentPane.add(result);
		
		btnPago = new JButton("Pagar");
		btnPago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(idMesa.getText().equals("") || pag.getText().equals(""))
						throw new Exception ("Campos em branco, tente novamente");
					int id = Integer.parseInt(idMesa.getText());
					String tipoPagamento = pag.getText();
					int perc = Integer.parseInt(p.getText());
					String cartao = c.getText();
					int qtd = Integer.parseInt(qnt.getText());
					
					Fachada.pagarConta(id, tipoPagamento, perc, cartao, qtd);
					result.setText("Mesa nº "+ id + " pagou sua conta. Valor pago: R$"+ Fachada.consultarConta(id).getPagamento().getValorPago());
					
					idMesa.setText("");
					pag.setText("");
					p.setText("");
					c.setText("");
					qnt.setText("");
					idMesa.requestFocus();
				}
				catch(Exception erro){
					result.setText(erro.getMessage());
				}
			}
		});
		btnPago.setBounds(129, 99, 115, 23);
		contentPane.add(btnPago);

	}
}