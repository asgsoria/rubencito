public class AltaMarcas extends JFrame implements ActionListener{

	public AltaMarcas(JTable tabla, ConectarMotor conexion, ModeloTablaMarcas modelo){

		this.conexion = conexion;
		this.tabla = tabla;
		this.modelo = modelo;

		//JOptionPane.showMessageDialog(null, "Valor de modelo:" + modelo.toString() + "\n" + "Valor de Modelo Copiado:" + this.modelo.toString(), "Atención", JOptionPane.INFORMATION_MESSAGE);


		ventana = new JFrame();
		ventana.setLayout(new BorderLayout());
		ventana.setSize(500,120);
		ventana.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		ventana.setVisible(true);

		panelDatos = new JPanel();
		panelDatos.setLayout(new GridLayout(2,2));
		panelBotones = new JPanel();
		panelBotones.setLayout(new FlowLayout());

		eIdMarca = new JLabel("Identificador de Marca:");
		eDescripcionMarca = new JLabel("Descripción de la Marca:");
		tIdMarca = new JTextField();
		tDescripcionMarca = new JTextField();
		tIdMarca.setText("0");
		tIdMarca.setEditable(false);

		botonConfirma = new JButton("Confirma");
		botonLimpia = new JButton("Limpia");
		botonSale = new JButton("Sale");
		botonConfirma.addActionListener(this);
		botonLimpia.addActionListener(this);
		botonSale.addActionListener(this);


		panelDatos.add(eIdMarca);
		panelDatos.add(tIdMarca);
		panelDatos.add(eDescripcionMarca);
		panelDatos.add(tDescripcionMarca);

		panelBotones.add(botonConfirma);
		panelBotones.add(botonLimpia);
		panelBotones.add(botonSale);

		ventana.add(panelDatos, BorderLayout.CENTER);
		ventana.add(panelBotones, BorderLayout.SOUTH);
		tDescripcionMarca.requestFocusInWindow();
	}

	public void actionPerformed(ActionEvent evento){
		if(evento.getSource() == botonConfirma){
			idMarca = Integer.parseInt(tIdMarca.getText());
			descripcionMarca = tDescripcionMarca.getText();
			insertaRegistro(idMarca, descripcionMarca);
		}

		if(evento.getSource() == botonLimpia){
			tDescripcionMarca.setText("");
		}

		if(evento.getSource() == botonSale){
			ventana.dispose();
		}
	}

	public void insertaRegistro(int tipo, String descripcion){
		//sentenciaSql = "INSERT INTO tiposreclamos (idtipo, descripcion ) VALUES( " + tipo + " , " + "\"" +  descripcion + "\"" + " )";
		//JOptionPane.showMessageDialog(null, "Consulta SQL enviada:" + "\n" + sentenciaSql, "AltasMarcas", JOptionPane.INFORMATION_MESSAGE);
		try{
			//conexion.ejecutarUpdate(sentenciaSql);

			//conexion.ejecutarUpdate("BEGIN WORK");

			//modelo.resultado.moveToInsertRow();
			//modelo.resultado.updateInt(1,tipo);
			//modelo.resultado.updateString(2,descripcion);
			//modelo.resultado.insertRow();
			//modelo.resultado.moveToCurrentRow();

			//conexion.connection.commit();

			//conexion.ejecutarUpdate("COMMIT");

			//modelo.fireTableRowsInserted(modelo.getRowCount(), modelo.getRowCount()+1);

			conexion.ejecutarInsert(0,tDescripcionMarca.getText());

			filaInicial = modelo.getRowCount();
			filaFinal = modelo.getRowCount();
			JOptionPane.showMessageDialog( null, "Valor de la variable filaInicial: " + filaInicial + "\nValor de la variable filaFinal: " + filaFinal + "\nCantidad de Registros en el ResultSet: " + modelo.resultado.getRow(), "Atención", JOptionPane.INFORMATION_MESSAGE);
			//modelo.fireTableRowsInserted(filaInicial, filaFinal);
			tipoEvento = 1;
			evento = new TableModelEvent(modelo, filaInicial, filaFinal, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);

			modelo.tableChanged(evento);
			tDescripcionMarca.setText("");

		}
		catch(Exception e){
			try{
				conexion.ejecutarUpdate("ROLLBACK");
			}
			catch(SQLException sqle){
				JOptionPane.showMessageDialog(null, "Error al hacer el ROLLBACK de la transacción de inserción" + sqle.getMessage(), "Atención", JOptionPane.INFORMATION_MESSAGE);
			}
			JOptionPane.showMessageDialog(null, "Error al insertar el registro:" + e.getMessage(), "Atención", JOptionPane.INFORMATION_MESSAGE);
		}
		//catch(SQLException esql){
		//	JOptionPane.showMessageDialog(null, "Error al insertar el registro:" + esql.getMessage(), "Atención", JOptionPane.INFORMATION_MESSAGE);
		//}
	}

	private JFrame ventana;
	private JPanel panelDatos, panelBotones;
	private JLabel eIdMarca, eDescripcionMarca;
	private JTextField tIdMarca, tDescripcionMarca;
	private JButton botonConfirma, botonLimpia, botonSale;
	private int idMarca;
	private String descripcionMarca, sentenciaSql;
	private ConectarMotor conexion;
	private JTable tabla;
	private ModeloTablaMarcas modelo;
	private TableModelEvent evento;
	private int filaInicial, filaFinal, tipoEvento;
}