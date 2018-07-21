package aplica��o;

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


public class TelaGorjeta extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblApelido;
	private JButton btnCalcular;
	private JLabel lblMensagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGorjeta frame = new TelaGorjeta();
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
	public TelaGorjeta() {
		setTitle("C�lculo da Gorjeta do Gar�om");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 311, 103);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(49, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		lblApelido = new JLabel("Nome");
		lblApelido.setBounds(10, 14, 46, 14);
		contentPane.add(lblApelido);

		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(textField.getText().equals(""))
						throw new Exception("Campo em branco, tente novamente");
					String apelido = textField.getText();
					double gorjeta = Fachada.calcularGorjeta(apelido);
					
					lblMensagem.setText("gar�om "+ apelido+ " tem uma gorjeta de R$ "+ gorjeta);
					
					textField.setText("");
					textField.requestFocus();
				}
				catch(Exception erro){
					lblMensagem.setText(erro.getMessage());
				}
			}
		});
		btnCalcular.setBounds(168, 10, 115, 23);
		contentPane.add(btnCalcular);
		
		lblMensagem = new JLabel("");
		lblMensagem.setBounds(10, 42, 273, 21);
		contentPane.add(lblMensagem);
	}
}