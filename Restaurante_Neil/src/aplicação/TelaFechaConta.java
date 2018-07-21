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

public class TelaFechaConta extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblMesa;
	private JButton btnFechar;
	private JLabel lblmsg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFechaConta frame = new TelaFechaConta();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaFechaConta() {
		setTitle("Fechar Conta");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 311, 147);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(147, 22, 67, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		lblMesa = new JLabel("Mesa");
		lblMesa.setBounds(99, 25, 46, 14);
		contentPane.add(lblMesa);

		btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(textField.getText().equals(""))
						throw new Exception ("Campo em branco, tente novamente");
					int id = Integer.parseInt(textField.getText());
					Fachada.fecharConta(id);
					lblmsg.setText("conta da mesa número: " + id + " fechada");
					
					textField.setText("");
					textField.requestFocus();
				}
				catch(Exception e2){
					lblmsg.setText(e2.getMessage());
				}
			}
		});
		btnFechar.setBounds(99, 53, 115, 23);
		contentPane.add(btnFechar);
		
		lblmsg = new JLabel("");
		lblmsg.setBounds(10, 87, 285, 21);
		contentPane.add(lblmsg);
	}
}