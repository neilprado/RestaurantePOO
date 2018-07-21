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

public class TelaCancelaConta extends JFrame {

	private JPanel contentPane;
	private JTextField numMesa;
	private JLabel lblTexto;
	private JButton btnCancelar;
	private JLabel lblMensagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCancelaConta frame = new TelaCancelaConta();
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
	public TelaCancelaConta() {
		setTitle("Cancelar Conta");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 281, 174);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTexto = new JLabel("Mesa número: ");
		lblTexto.setBounds(48, 52, 86, 14);
		contentPane.add(lblTexto);

		numMesa = new JTextField();
		numMesa.setBounds(130, 49, 74, 20);
		contentPane.add(numMesa);
		numMesa.setColumns(10);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(numMesa.getText().equals(""))
						throw new Exception ("Campo em branco, tente novamente");
					int id = Integer.parseInt(numMesa.getText());
					Fachada.cancelarConta(id);
					lblMensagem.setText("conta da mesa "+ id + " cancelada");
					
					numMesa.setText("");
					numMesa.requestFocus();
				}
				catch(Exception erro){
					lblMensagem.setText(erro.getMessage());
				}
			}
		});
		btnCancelar.setBounds(71, 77, 115, 23);
		contentPane.add(btnCancelar);
		
		lblMensagem = new JLabel("");
		lblMensagem.setBounds(0, 121, 273, 14);
		contentPane.add(lblMensagem);
	}
}