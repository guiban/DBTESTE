package br.com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.dao.UsuarioDAO;
import br.com.models.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UsuarioGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioGUI frame = new UsuarioGUI();
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
	public UsuarioGUI() {
		setTitle("Cadastro de Usuário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(137, 63, 45, 15);
		panel.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(187, 61, 114, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setBounds(137, 92, 31, 15);
		panel.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(187, 92, 114, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(126, 127, 42, 15);
		panel.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setBounds(187, 127, 114, 19);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(108, 158, 67, 15);
		panel.add(lblTelefone);
		
		textField_3 = new JTextField();
		textField_3.setBounds(187, 158, 114, 19);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// instanciando a classe Usuario do pacote modelo e criando seu objeto usuarios
				Usuario usuarios = new Usuario();
				usuarios.setNome(textField.getText());
				usuarios.setCpf(textField_1.getText());
				usuarios.setEmail(textField_2.getText());
				usuarios.setTelefone(textField_3.getText());

				// fazendo a validação dos dados
				if ((textField.getText().isEmpty()) || (textField_1.getText().isEmpty()) || (textField_2.getText().isEmpty()) || (textField_3.getText().isEmpty())) {
				   JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios");
				}
				else {

				    // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
				    UsuarioDAO dao = new UsuarioDAO();
				    dao.adiciona(usuarios);
				    JOptionPane.showMessageDialog(null, "Usuário "+textField.getText()+" inserido com sucesso! ");
				}

				// apaga os dados preenchidos nos campos de texto
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}
		});
		btnCadastrar.setBounds(89, 207, 114, 25);
		panel.add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}
		});
		btnLimpar.setBounds(254, 207, 117, 25);
		panel.add(btnLimpar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0); 
			}
		});
		btnSair.setBounds(352, 12, 76, 25);
		panel.add(btnSair);
	}
}
