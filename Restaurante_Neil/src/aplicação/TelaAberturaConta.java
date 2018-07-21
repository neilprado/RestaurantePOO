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
import modelo.Conta;

public class TelaAberturaConta extends JFrame {

	private JPanel contentPane;
	private JTextField texto;
	private JLabel lblNome;
	private JButton btnCriar;
	private JLabel mensagem;

	public TelaAberturaConta() {
		setTitle("Por favor, crie sua conta!!");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 299, 139);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		texto = new JTextField();
		texto.setBounds(54, 11, 86, 20);
		contentPane.add(texto);
		texto.setColumns(10);

		lblNome = new JLabel("Mesa");
		lblNome.setBounds(10, 14, 46, 14);
		contentPane.add(lblNome);

		btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(texto.getText().equals(""))
						throw new Exception ("Campo em branco, tente novamente!");
					int id = Integer.parseInt(texto.getText());
					Conta c = Fachada.criarConta(id);
					mensagem.setText("conta nº "+ c.getNumero() + " da mesa  " + id + " está aberta!");
					
					texto.setText("");
					texto.requestFocus();
				}
				catch(Exception erro){
					mensagem.setText(erro.getMessage());

				}
			}
		});
		btnCriar.setBounds(157, 52, 115, 23);
		contentPane.add(btnCriar);
		
		mensagem = new JLabel("");
		mensagem.setBounds(10, 86, 233, 14);
		contentPane.add(mensagem);
	}
}
