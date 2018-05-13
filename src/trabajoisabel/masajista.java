package trabajoisabel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import org.omg.Messaging.SyncScopeHelper;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.acl.Group;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButtonMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class masajista extends JFrame  {
	

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					masajista frame = new masajista();
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
	public masajista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 70, 21);
		contentPane.add(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmPresupuestp = new JMenuItem("Nueva hoja");
		mnArchivo.add(mntmPresupuestp);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mnArchivo.add(mntmGuardar);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(mntmSalir);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(10, 33, 70, 15);
		contentPane.add(lblCliente);
		
		JLabel lblMasajista = new JLabel("Masajista");
		lblMasajista.setBounds(0, 60, 70, 15);
		contentPane.add(lblMasajista);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Juan", "Carla", "Pedro", "Sandra", "Lucas"}));
		comboBox_1.setBounds(108, 57, 104, 21);
		contentPane.add(comboBox_1);
		
		textField = new JTextField();
		textField.setBounds(98, 31, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSala = new JLabel("Sala");
		lblSala.setBounds(10, 87, 70, 15);
		contentPane.add(lblSala);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(56, 81, 51, 21);
		contentPane.add(spinner);
		
		
		
		
		JRadioButton rdbtnNoche = new JRadioButton("Noche");
		rdbtnNoche.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		rdbtnNoche.setBounds(76, 119, 81, 23);
		contentPane.add(rdbtnNoche);
		
		JRadioButton rdbtnDa = new JRadioButton("Día");
		rdbtnDa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
			}
			
		});
		rdbtnDa.setSelected(true);
		rdbtnDa.setBounds(10, 119, 64, 23);
		contentPane.add(rdbtnDa);
		
		ButtonGroup group = new ButtonGroup();
	    group.add(rdbtnDa);
	    group.add(rdbtnNoche);
		
		
		
		JButton btnAadir = new JButton("Añadir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				String [] btanadir=new String[4];
				btanadir[0]=textField.getText();
				btanadir[1]=(String)comboBox_1.getSelectedItem();
				if(rdbtnDa.isSelected()==true){
					btanadir[3]="Día";
				}else{
					btanadir[3]="Noche";
				}
				
			        model.addRow(btanadir);
			        table.setModel(model); 
				
			}
		});
		btnAadir.setBounds(0, 300, 117, 25);
		contentPane.add(btnAadir);
		
		
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(149, 300, 117, 25);
		contentPane.add(btnModificar);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		
		 model.addRow(btanadir);
	        table.setModel(model); 
		
		
		
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(299, 300, 117, 25);
		contentPane.add(btnEliminar);
		
		
		
		
		
		
	
		
		JLabel lblTipoDeMasaje = new JLabel("Tipo de masaje");
		lblTipoDeMasaje.setBounds(249, 6, 129, 15);
		contentPane.add(lblTipoDeMasaje);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(233, 33, 183, 106);
		contentPane.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 150, 448, 138);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cliente", "Masajista", "Sala", "D\u00EDa", "Tipo de masaje"
			}
		));
		table.getColumnModel().getColumn(4).setPreferredWidth(152);
	}
}
