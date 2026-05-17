package bbdd;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

import main.ErrorBaseDatos;
import modelos.*;

import java.time.*;


public class BD_taller extends BD_Conector{

	private static Statement s;	
	private static ResultSet reg;
	
	public BD_taller(String file){
		super(file);
	}
	
	public ArrayList<Arreglo> Arreglos()throws ErrorBaseDatos {
		String cadenaSQL = "SELECT * FROM arreglos WHERE fechaSalida IS NULL;";
		Arreglo Arreglos=null;
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				Arreglos = new Arreglo(
						reg.getInt("idFactura"),
						reg.getInt("idMecanico"),
						reg.getString("Matricula"),
						reg.getDate("fechaEntrada"),
						reg.getDate("fechaSalida"),
						reg.getDouble("importe")
						);
			}
			s.close();
			this.cerrar();
			return Arreglos;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("ERROR NO DEVUELVE LA TARJETA");
		}
		
	}
	

}
