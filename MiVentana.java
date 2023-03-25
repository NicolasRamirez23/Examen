import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MiVentana extends JFrame {
	JPanel actual=null;
	JPanel anterior=null;
	JPanel bienvenida;
	JPanel login;
	
	public MiVentana() {
		this.setVisible(true);
		this.setSize(525, 700);
		this.setLocationRelativeTo(null);
		this.setTitle("Menu Principal");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.CYAN);
		
		Bienvenida();
		timer();
		repaint();
		revalidate();
		
		
	}
	
	public void timer() {
		
		Timer timer = new Timer();
		
		TimerTask tarea = new TimerTask() {
			@Override
			public void run() {
				Login();
			}
		};
		
		timer.schedule(tarea, 2000);
		
	}
		
	public void Bienvenida() {
		bienvenida = new JPanel();
		bienvenida.setSize(300,120);
		bienvenida.setLocation(100,180);
		bienvenida.setLayout(null);
		bienvenida.setBackground(Color.RED);
		
		JLabel titleinicio = new JLabel("Bienvenido",JLabel.CENTER);
		titleinicio.setFont(new Font("Comic Sans", Font.BOLD,20));
		titleinicio.setSize(260, 40);
		titleinicio.setLocation(20, 40);
		titleinicio.setOpaque(true);
		titleinicio.setBackground(Color.GREEN);
		bienvenida.add(titleinicio);
		
		actual=bienvenida;
		
		add(actual);
		
		repaint();
		revalidate();
	}
	
	
	
	public void Login () {
		login = new JPanel();
		login.setSize(400,290);
		login.setLocation(50,50);
		login.setLayout(null);
		login.setBackground(Color.ORANGE);
		
		JLabel titleinicio = new JLabel("Iniciar Sesion",JLabel.CENTER);
		titleinicio.setFont(new Font("Comic Sans", Font.BOLD,20));
		titleinicio.setSize(280, 40);
		titleinicio.setLocation(60, 40);
		titleinicio.setOpaque(true);
		titleinicio.setBackground(Color.GREEN);
		login.add(titleinicio);
		
		JLabel usuario = new JLabel("Ingrese su usuario",JLabel.CENTER);
		usuario.setFont(new Font("Comic Sans", Font.BOLD,16));
		usuario.setSize(250, 20);
		usuario.setLocation(75, 95);
		usuario.setOpaque(true);
		usuario.setBackground(Color.GREEN);
		login.add(usuario);
		
		JLabel iniciarcontraseña = new JLabel("Contraseña",JLabel.CENTER);
		iniciarcontraseña.setFont(new Font("Comic Sans", Font.BOLD,16));
		iniciarcontraseña.setSize(250, 30);
		iniciarcontraseña.setLocation(75, 155);
		iniciarcontraseña.setOpaque(true);
		iniciarcontraseña.setBackground(Color.GREEN);
		login.add(iniciarcontraseña);
		
		JButton entrarcuentar = new JButton();
		entrarcuentar.setText("Aceptar");
		entrarcuentar.setSize(100, 40);
		entrarcuentar.setLocation(150, 225);
		entrarcuentar.setOpaque(true);
		entrarcuentar.setBackground(Color.white);
		login.add(entrarcuentar);
		
		JTextField username = new JTextField("");
		username.setSize(250, 30);
		username.setLocation(75, 120);
		login.add(username);
		
		JPasswordField password = new JPasswordField();
		password.setSize(250, 30);
		password.setLocation(75, 190);
		login.add(password);
	
		entrarcuentar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String user = username.getText();
				String pwd = new String (password.getPassword());
				
				BufferedReader reader;
				
				Boolean flag = false;
				
				try{
					
					FileReader file = new FileReader("C:\\Users\\ataru\\Desktop\\NERP Programas\\src\\cuentas\\users.txt");
					reader = new BufferedReader(file);
					
					String line = reader.readLine();
					
					while(line != null) {
						
						String data [] = line.split(",");
						 
						if( user.equals(data[0]) ) {
							if( pwd.equals(data[3]) ) {
								flag = true;
							}
						} 
						
						line = reader.readLine();
						
					}
					
					if(flag==true) {
						JOptionPane.showMessageDialog(null,"Correcto","Bienvenido al sistema", JOptionPane.INFORMATION_MESSAGE );
					}else {
						JOptionPane.showMessageDialog(null,"Error","Fuera Perro!", JOptionPane.ERROR_MESSAGE );
					}
					
					
				} catch(IOException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
		anterior=actual;
		actual=login;
		remove(anterior);
		add(actual);
		
		repaint();
		revalidate();
}		
}

