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


public class TelaExcluirGarcom extends JFrame {

	private JPanel contentPane;
	private JTextField texto;
	private JLabel instructions;
	private JButton btnExclude;
	private JLabel resultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExcluirGarcom frame = new TelaExcluirGarcom();
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
	public TelaExcluirGarcom() {
		setTitle("Excluir Garçom");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 271, 147);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		texto = new JTextField();
		texto.setBounds(31, 48, 115, 20);
		contentPane.add(texto);
		texto.setColumns(10);

		instructions = new JLabel("Digite o nome do garçom abaixo: ");
		instructions.setBounds(62, 14, 168, 23);
		contentPane.add(instructions);

		btnExclude = new JButton("Excluir");
		btnExclude.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(texto.getText().equals(""))
						throw new Exception ("Campo em branco, tente novamente");
					String nome = texto.getText();
					Fachada.excluirGarcom(nome);
					
					resultado.setText("garçom "+ nome+ " excluído ");
					
					texto.setText("");
					texto.requestFocus();
				}
				catch(Exception erro){
					texto.setText("");
					resultado.setText(erro.getMessage());
				}
			}
		});
		btnExclude.setBounds(154, 47, 101, 23);
		contentPane.add(btnExclude);
		
		resultado = new JLabel("");
		resultado.setBounds(10, 88, 245, 20);
		contentPane.add(resultado);
	}
}