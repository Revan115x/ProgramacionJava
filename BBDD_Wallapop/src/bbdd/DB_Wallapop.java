package bbdd;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

import main.ErrorBaseDatos;
import modelos.Usuarios;
import modelos.Anuncios;
import modelos.Vendidos;
import java.time.*;
import main.*;


public class DB_Wallapop extends BD_Conector{

	private static Statement s;	
	private static ResultSet reg;
	
	public DB_Wallapop(String file){
		super(file);
	}
	
	public Usuarios Usuario(String mail) throws ErrorBaseDatos {
		String cadenaSQL = "SELECT * FROM usuarios WHERE mail ='" + mail + "'";
		Usuarios user=null;
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			if (reg.next()) {
				user = new Usuarios(
						reg.getString("mail"),
						reg.getString("nombre"),
						reg.getString("ciudad"),
						reg.getDouble("valoracion")
						);
			}
			s.close();
			this.cerrar();
			return user;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("ERROR NO DEVUELVE LA TARJETA");
		}
		
	}
	
	public Usuarios Usuario2(String mail) throws ErrorBaseDatos {
		try {
		this.abrir();
		PreparedStatement p = c.prepareStatement("SELECT * FROM usuarios WHERE mail = ?");
		p.setString(1, mail);
		Usuarios user=null;
		reg=p.executeQuery();
		if (reg.next()) {
			user = new Usuarios(
					reg.getString("mail"),
					reg.getString("nombre"),
					reg.getString("ciudad"),
					reg.getDouble("valoracion")
					);
		}
		p.close();
		this.cerrar();
		return user;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("ERROR NO DEVUELVE LA TARJETA");
		}
		
	}
	

}
