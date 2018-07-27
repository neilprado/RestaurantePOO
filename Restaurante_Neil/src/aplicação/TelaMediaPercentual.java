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
import java.awt.Font;


public class TelaMediaPercentual extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;
	private JLabel lNome;
	private JButton btnCalculo;
	private JLabel result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMediaPercentual frame = new TelaMediaPercentual();
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
	public TelaMediaPercentual() {
		setTitle("Excluir Garçom");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 284, 147);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		campoNome = new JTextField();
		campoNome.setBounds(10, 48, 115, 20);
		contentPane.add(campoNome);
		campoNome.setColumns(10);

		lNome = new JLabel("Digite abaixo o nome do garçom");
		lNome.setBounds(10, 14, 285, 23);
		contentPane.add(lNome);

		btnCalculo = new JButton("Calcular");
		btnCalculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(campoNome.getText().equals(""))
						throw new Exception ("Campos em branco, tente novamente");
					String apelido = campoNome.getText();
					double p = Fachada.calcularPercentualMedio(apelido);
					
					result.setText("O garçom "+ apelido + " possui um percentual medio de " + p + "%");
					
					campoNome.setText("");
					campoNome.requestFocus();
				}
				catch(Exception erro){
					campoNome.setText("");
					result.setText(erro.getMessage());
				}
			}
		});
		btnCalculo.setBounds(167, 47, 101, 23);
		contentPane.add(btnCalculo);
		
		result = new JLabel("");
		result.setBounds(10, 88, 258, 20);
		contentPane.add(result);
	}
}