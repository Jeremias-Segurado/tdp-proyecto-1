package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import java.awt.Image;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	//Labels
	private JLabel LU_label;
	private JLabel Apellido_label;
	private JLabel Nombre_label;
	private JLabel Email_label;
	private JLabel GithubURL_label;
	private JLabel TimeMessage_label;
	//TextFields
	private JTextField LU_textField;
	private JTextField Apellido_textField;
	private JTextField Nombre_textField;
	private JTextField Email_textField;
	private JTextField GitURL_textField;
	//Image label
	private ImageIcon imagen;
	private JLabel Image_label;	
	
	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setContentPane(contentPane);		
		setIconImage(new ImageIcon(this.getClass().getResource("/images/tdp.png")).getImage());
		init();
	}
	
	private void init() {
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		//tamaños de componentes
		int altura_labels = 20;		
		int largo_textFields = 300;		
		//Labels
		LU_label = new JLabel("LU");		
		Apellido_label = new JLabel("Apellido");		
		Nombre_label = new JLabel("Nombre");		
		Email_label = new JLabel("E-mail");		
		GithubURL_label = new JLabel("Github URL");
		//Imagen personal
		imagen = new ImageIcon(this.getClass().getResource(studentData.getPathPhoto()));		
		Image_label = new JLabel("");
		Image_label.setHorizontalAlignment(SwingConstants.CENTER);
		Image_label.setIcon(imagen);
		Image_label.setPreferredSize(new Dimension(150, 150));
		Image_label.setSize(Image_label.getPreferredSize());		
		reDimensionar(Image_label, imagen);
		//TextFilds
		setTextFilds();
		//Time label
		TimeMessage_label = new JLabel();
		DateTimeFormatter day_mounth_year = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter hour_minute_seconds = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime open_time = LocalDateTime.now();
		TimeMessage_label.setText("Esta ventana fue generada el "+day_mounth_year.format(open_time)+" a las "+hour_minute_seconds.format(open_time));	
		TimeMessage_label.setFont(new Font("Dialog", Font.BOLD, 14));
		//--------------------------------------------------------
		//Layout de los componentes
		GroupLayout gl_tabInformation = new GroupLayout(tabInformation);
		gl_tabInformation.setHorizontalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING, false)
						.addComponent(LU_label, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
						.addComponent(Apellido_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(Nombre_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(Email_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(GithubURL_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addComponent(Apellido_textField, GroupLayout.PREFERRED_SIZE, largo_textFields, GroupLayout.PREFERRED_SIZE)
						.addComponent(Nombre_textField, GroupLayout.PREFERRED_SIZE, largo_textFields, GroupLayout.PREFERRED_SIZE)
						.addComponent(Email_textField, GroupLayout.PREFERRED_SIZE, largo_textFields, GroupLayout.PREFERRED_SIZE)
						.addComponent(GitURL_textField, GroupLayout.PREFERRED_SIZE, largo_textFields, GroupLayout.PREFERRED_SIZE)
						.addComponent(LU_textField, GroupLayout.PREFERRED_SIZE, largo_textFields, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(70, Short.MAX_VALUE))
		);
		gl_tabInformation.setVerticalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(LU_label, GroupLayout.PREFERRED_SIZE, altura_labels, GroupLayout.PREFERRED_SIZE)
						.addComponent(LU_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.TRAILING)
						.addComponent(Apellido_label, GroupLayout.PREFERRED_SIZE, altura_labels, GroupLayout.PREFERRED_SIZE)
						.addComponent(Apellido_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.TRAILING)
						.addComponent(Nombre_label, GroupLayout.PREFERRED_SIZE, altura_labels, GroupLayout.PREFERRED_SIZE)
						.addComponent(Nombre_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.TRAILING)
						.addComponent(Email_label, GroupLayout.PREFERRED_SIZE, altura_labels, GroupLayout.PREFERRED_SIZE)
						.addComponent(Email_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.TRAILING)
						.addComponent(GithubURL_label, GroupLayout.PREFERRED_SIZE, altura_labels, GroupLayout.PREFERRED_SIZE)
						.addComponent(GitURL_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		
		tabInformation.setLayout(gl_tabInformation);
		contentPane.add(tabbedPane, BorderLayout.WEST);				
		contentPane.add(Image_label, BorderLayout.EAST);		
		contentPane.add(TimeMessage_label, BorderLayout.SOUTH);
	}
	
	private void reDimensionar(JLabel label, ImageIcon grafico) {
		Image imagen = grafico.getImage();
		if (imagen != null) {
			Image newImagen = imagen.getScaledInstance(label.getWidth(), label.getHeight(), java.awt.Image.SCALE_SMOOTH);
			grafico.setImage(newImagen);
			label.repaint();
		}
	}
	
	private void setTextFilds() {
		LU_textField = new JTextField();
		LU_textField.setColumns(10);		
		LU_textField.setEditable(false);
		LU_textField.setBackground(Color.WHITE);
		LU_textField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		LU_textField.setText(Integer.toString(studentData.getId()));
		
		Apellido_textField = new JTextField();
		Apellido_textField.setColumns(10);
		Apellido_textField.setEditable(false);
		Apellido_textField.setBackground(Color.WHITE);
		Apellido_textField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		Apellido_textField.setText(studentData.getLastName());
		
		Nombre_textField = new JTextField();
		Nombre_textField.setColumns(10);
		Nombre_textField.setEditable(false);
		Nombre_textField.setBackground(Color.WHITE);
		Nombre_textField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		Nombre_textField.setText(studentData.getFirstName());
		
		Email_textField = new JTextField();
		Email_textField.setColumns(10);
		Email_textField.setEditable(false);
		Email_textField.setBackground(Color.WHITE);
		Email_textField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		Email_textField.setText(studentData.getMail());
		
		GitURL_textField = new JTextField();
		GitURL_textField.setColumns(10);
		GitURL_textField.setEditable(false);
		GitURL_textField.setBackground(Color.WHITE);
		GitURL_textField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		GitURL_textField.setText(studentData.getGithubURL());			
	}
}
