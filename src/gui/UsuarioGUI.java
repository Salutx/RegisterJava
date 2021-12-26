package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.TitledBorder;

import dao.UsuarioDAO;
import modelo.Usuario;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 291, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Usu\u00E1rio");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 218, 14);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Cadastrar novo usu\u00E1rio", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 36, 260, 215);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 26, 49, 14);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(90, 26, 159, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("CPF:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 61, 49, 14);
		panel.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(90, 61, 159, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(90, 92, 159, 20);
		panel.add(textField_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Email:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(10, 92, 49, 14);
		panel.add(lblNewLabel_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(90, 123, 159, 20);
		panel.add(textField_3);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Telefone:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2.setBounds(10, 123, 70, 14);
		panel.add(lblNewLabel_1_1_2);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Usuario usuarios = new Usuario();
				usuarios.setNome(textField.getText());
				usuarios.setCpf(textField_1.getText());
				usuarios.setEmail(textField_2.getText());
				usuarios.setTelefone(textField_3.getText());
			
				if ((textField.getText().isEmpty()) || (textField_1.getText().isEmpty()) || (textField_2.getText().isEmpty()) || (textField_3.getText().isEmpty())) {
					JOptionPane.showMessageDialog(null, "Preencha corretamente todos os campos!");
				} else {
					UsuarioDAO dao = new UsuarioDAO();
					
					dao.adiciona(usuarios);
					JOptionPane.showMessageDialog(null, "Usuario " + textField.getText() + " inserido com sucesso!");
				
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
				}
			}
		});
		btnNewButton.setBounds(36, 165, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			
			}
		});
		btnLimpar.setBounds(135, 165, 89, 23);
		panel.add(btnLimpar);
		
		JButton btnLimpar_1 = new JButton("Sair");
		btnLimpar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				System.exit(0);
			
			}
		});
		btnLimpar_1.setBounds(47, 262, 181, 23);
		contentPane.add(btnLimpar_1);
	}
}
