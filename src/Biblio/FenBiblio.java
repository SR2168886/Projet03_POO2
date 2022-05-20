package Biblio;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;



public class FenBiblio extends JFrame {
	Biblio b = new Biblio();
	private JPanel contentPane;
	private final JComboBox comboBoxCode = new JComboBox();
	private final JTextField textFieldTitre = new JTextField();
	private final JTextField textFieldAuteur = new JTextField();
	private final JTextField textFieldAnnee = new JTextField();
	private final JTextField textFieldTotalCopie = new JTextField();
	private final JRadioButton rdbtnOui = new JRadioButton("Oui");
	private final JRadioButton rdbtnNon = new JRadioButton("Non");
	private final JTextPane textPane = new JTextPane();
	private final JButton btnCharger = new JButton("Charger");
	private final JButton btnAjouter = new JButton("Ajouter");
	private final JButton btnSupprimer = new JButton("Supprimer");
	private final JButton btnEmprunter = new JButton("Emprunter");
	private final JButton btnRetourner = new JButton("Retourner");
	private final JButton btnTrier = new JButton("Trier");
	private final JButton btnChercher = new JButton("Chercher");
	private final JButton btnquitter = new JButton("quitter ");
	private final JComboBox comboBoxGenre = new JComboBox();
	private final JLabel lblNewLabel = new JLabel("Titre");
	private final JLabel lblNewLabel_1 = new JLabel("Auteur");
	private final JLabel lblNewLabel_2 = new JLabel("Ann\u00E9e");
	private final JLabel lblNewLabel_3 = new JLabel("Total copie:");
	private final JLabel lblNewLabel_4 = new JLabel("Code");
	private final JLabel lblNewLabel_5 = new JLabel("Genre");
	private final JLabel lblNewLabel_6 = new JLabel("Disponible:");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					FenBiblio frame = new FenBiblio();
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
	public FenBiblio() {
		textFieldTotalCopie.setBounds(94, 137, 86, 20);
		textFieldTotalCopie.setColumns(10);
		textFieldAnnee.setBounds(66, 106, 102, 20);
		textFieldAnnee.setColumns(10);
		textFieldAuteur.setBounds(66, 75, 217, 20);
		textFieldAuteur.setColumns(10);
		textFieldTitre.setBounds(66, 44, 309, 20);
		textFieldTitre.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		comboBoxCode.setBounds(66, 11, 102, 22);

		contentPane.add(comboBoxCode);

		contentPane.add(textFieldTitre);

		contentPane.add(textFieldAuteur);

		contentPane.add(textFieldAnnee);

		contentPane.add(textFieldTotalCopie);
		rdbtnOui.setBounds(66, 177, 41, 23);

		contentPane.add(rdbtnOui);
		rdbtnNon.setBounds(135, 177, 45, 23);

		contentPane.add(rdbtnNon);
		textPane.setBounds(10, 256, 711, 145);

		contentPane.add(textPane);
		btnCharger.addActionListener(new BtnChargerActionListener());
		btnCharger.setBounds(34, 201, 112, 44);

		contentPane.add(btnCharger);
		btnAjouter.addActionListener(new BtnAjouterActionListener());
		btnAjouter.setBounds(156, 201, 102, 44);

		contentPane.add(btnAjouter);
		btnSupprimer.addActionListener(new BtnSupprimerActionListener());
		btnSupprimer.setBounds(268, 201, 107, 44);

		contentPane.add(btnSupprimer);
		btnEmprunter.addActionListener(new BtnEmprunterActionListener());
		btnEmprunter.setBounds(395, 201, 102, 44);

		contentPane.add(btnEmprunter);
		btnRetourner.addActionListener(new BtnRetournerActionListener());
		btnRetourner.setBounds(507, 201, 102, 44);

		contentPane.add(btnRetourner);
		btnTrier.addActionListener(new BtnSauvegarderActionListener());
		btnTrier.setBounds(619, 201, 102, 44);

		contentPane.add(btnTrier);
		btnChercher.addActionListener(new BtnChercherActionListener());
		btnChercher.setBounds(477, 38, 80, 32);

		contentPane.add(btnChercher);
		btnquitter.addActionListener(new BtnquitterActionListener());
		btnquitter.setBounds(635, 11, 86, 32);

		contentPane.add(btnquitter);
		comboBoxGenre.setBounds(313, 105, 136, 22);
		comboBoxGenre.addItem("Roman");
		comboBoxGenre.addItem("Fiction");
		comboBoxGenre.addItem("technique");
		comboBoxGenre.addItem("ETC");

		contentPane.add(comboBoxGenre);
		lblNewLabel.setBounds(10, 47, 46, 14);

		contentPane.add(lblNewLabel);
		lblNewLabel_1.setBounds(10, 78, 46, 14);

		contentPane.add(lblNewLabel_1);
		lblNewLabel_2.setBounds(10, 109, 46, 14);

		contentPane.add(lblNewLabel_2);
		lblNewLabel_3.setBounds(8, 140, 67, 14);

		contentPane.add(lblNewLabel_3);
		lblNewLabel_4.setBounds(10, 15, 46, 14);

		contentPane.add(lblNewLabel_4);
		lblNewLabel_5.setBounds(255, 109, 46, 14);

		contentPane.add(lblNewLabel_5);
		lblNewLabel_6.setBounds(0, 181, 60, 14);

		contentPane.add(lblNewLabel_6);
	}
	private class BtnAjouterActionListener implements ActionListener {  //ajouter un livre
		@Override
		public void actionPerformed(ActionEvent e) {

			int annee= Integer.parseInt(textFieldAnnee.getText());
			int totalCopie = Integer.parseInt(textFieldTotalCopie.getText());

			b.ajout(textFieldTitre.getText(), textFieldAuteur.getText(),
					annee,comboBoxGenre.getSelectedItem().toString(),
					totalCopie, totalCopie);
			comboBoxCode.addItem(b.livres[b.getNbLivre()-1].getCode());
			textPane.setText(b.toString());
		}
	}
	private class BtnSupprimerActionListener implements ActionListener {   //boutons qui supprime le livre associé au code sélectionné
		@Override
		public void actionPerformed(ActionEvent e) {
			b.supression(comboBoxCode.getSelectedItem().toString());
			comboBoxCode.remove(comboBoxCode.getSelectedIndex());
		}
	}
	private class BtnEmprunterActionListener implements ActionListener { //diminue le nombre de livre dispo de 1
		@Override
		public void actionPerformed(ActionEvent e) {
			if(rdbtnOui.isSelected()) {
				b.pret(comboBoxCode.getSelectedItem().toString());
			}

			if (rdbtnNon.isSelected()) {
				JOptionPane.showMessageDialog(rootPane, "Livre non dispo");;
			}

		}

	}

	private class BtnRetournerActionListener implements ActionListener { //augmente livre de dispo de 1
		@Override
		public void actionPerformed(ActionEvent e) {
			b.retour(comboBoxCode.getSelectedItem().toString());
		}
	}
	private class BtnChercherActionListener implements ActionListener {  //btn qui cherche par le nom et retourne le string de livre
		@Override
		public void actionPerformed(ActionEvent e) {

			int position=b.rechercheN(textFieldTitre.getText());
			textPane.setText(b.livres[position].toString());

		}
	}
	private class BtnSauvegarderActionListener implements ActionListener { //btn Trier
		@Override
		public void actionPerformed(ActionEvent e) {
			textPane.setText(b.toString());
			remplirCombo();
		}
	}
	private class BtnChargerActionListener implements ActionListener { //btn chargement
		@Override
		public void actionPerformed(ActionEvent e) {
			b.chargement();
			remplirCombo();

		}
	}
	private class BtnquitterActionListener implements ActionListener {     //boutons quitter
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);

		}
	}
	public void remplirCombo() {
		comboBoxCode.removeAllItems();
		for(Livre l : b.getLivres()) {
			if(l!=null) {
				comboBoxCode.addItem(l.getCode());
			}
		}

	}
}
