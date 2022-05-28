package Biblio;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FenAuth extends JFrame {

	private JPanel contentPane;
	private final JButton btnNewButton = new JButton("Connexion ");
	private final JTextField textFieldUser = new JTextField();
	private final JPasswordField passwordField = new JPasswordField();
	private JLabel lblUser;

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
		textFieldUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
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
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setBounds(223, 101, 201, 84);

		contentPane.add(passwordField);

		lblUser = new JLabel("Utilisateur");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUser.setBounds(10, 34, 180, 33);
		contentPane.add(lblUser);

		JLabel lblPassword = new JLabel("Mot de Passe");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(10, 125, 180, 33);
		contentPane.add(lblPassword);
	}

	private class BtnNewButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (lireBaseDeDonnees()) {
				FenBiblio fb = new FenBiblio();
				fb.setVisible(true);
				dispose();
			}
		}

		public boolean lireBaseDeDonnees() {
			String ligne;
			try (FileReader fr = new FileReader("./src/resources/motsdepasses.txt");
					BufferedReader br = new BufferedReader(fr);) {

				while (br.ready()) {
					ligne = br.readLine();

					StringTokenizer str = new StringTokenizer(ligne, "[\t,]");

					String user = str.nextToken();
					String password = str.nextToken();

					if (user.equals(textFieldUser.getText())) {
						if (password.equals(String.valueOf(passwordField.getPassword())))
							return true;
					}

				}
				return false;
			} catch (NumberFormatException | IOException | NoSuchElementException e) {
				System.out.println("Type d'erreur: " + e.getMessage());
			}
			return false;
		}
	}
}
