package FenAuth;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FenAuth extends JFrame {

	FenGestion fg = new FenGestion();
	private JPanel contentPane;
	private final JButton btnNewButton = new JButton("Connexion ");
	private final JTextField textFieldUser = new JTextField();
	private final JPasswordField passwordField = new JPasswordField();
	private JLabel lblNewLabel;
	private JLabel lblMotDePass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					FenAuth frame = new FenAuth();
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
	public FenAuth() {
		initialize();
	}

	private void initialize() {
		setTitle("Authentification");
		textFieldUser.setBounds(223, 11, 201, 79);
		textFieldUser.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new BtnNewButtonActionListener());
		btnNewButton.setBounds(10, 198, 180, 52);

		contentPane.add(btnNewButton);

		contentPane.add(textFieldUser);
		passwordField.setBounds(223, 101, 201, 84);

		contentPane.add(passwordField);

		lblNewLabel = new JLabel("Utilisateur");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 34, 180, 33);
		contentPane.add(lblNewLabel);

		lblMotDePass = new JLabel("Mot de Passe");
		lblMotDePass.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMotDePass.setBounds(10, 125, 180, 33);
		contentPane.add(lblMotDePass);
	}

	private class BtnNewButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			authentifier();
			fg.setTitle("Fenetre de gestion");
			// setVisible(false);
			dispose();
			fg.setVisible(true);
		}

		private boolean authentifier() {
			String id = textFieldUser.getText();
			String pwd = String.valueOf(passwordField.getPassword());
			System.out.println(id + ", " + pwd);
			return true;

		}
	}
}
