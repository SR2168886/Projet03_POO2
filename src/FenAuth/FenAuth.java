package FenAuth;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FenAuth extends JFrame {

	FenGestion fg = new FenGestion();
	private JPanel contentPane;
	private final JButton btnNewButton = new JButton("Connexion ");
	private final JTextField textField = new JTextField();
	private final JPasswordField passwordField = new JPasswordField();

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
		textField.setBounds(77, 23, 201, 20);
		textField.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnNewButton.addActionListener(new BtnNewButtonActionListener());
		btnNewButton.setBounds(129, 165, 89, 23);

		contentPane.add(btnNewButton);

		contentPane.add(textField);
		passwordField.setBounds(77, 65, 201, 31);

		contentPane.add(passwordField);
	}


	private class BtnNewButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			authentifier();
			fg.setTitle("Fenetre de gestion");
			//setVisible(false);
			dispose();
			fg.setVisible(true);
		}

		private boolean authentifier() {
			String id = textField.getText();
			String pwd =String.valueOf( passwordField.getPassword());
			System.out.println(id+", "+pwd);
			return true;

		}
	}
}
