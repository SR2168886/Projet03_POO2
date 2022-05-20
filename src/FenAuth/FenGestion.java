package FenAuth;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FenGestion extends JFrame {

	private JPanel contentPane;
	private final JButton btnDeco = new JButton("D\u00E9connexion");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					FenGestion frame = new FenGestion();
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
	public FenGestion() {
		initialize();
	}
	private void initialize() {setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	btnDeco.addActionListener(new BtnDecoActionListener());
	btnDeco.setBounds(282, 35, 89, 23);

	contentPane.add(btnDeco);
	}

	private class BtnDecoActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			FenAuth fa = new FenAuth();
			setVisible(false);
			fa.setVisible(true);
		}
	}
}
