package bbdd;

import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

import main.ErrorBaseDatos;
import modelos.*;
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
	
	public ArrayList<Anuncios> Anuncios ()throws ErrorBaseDatos {
		String cadenaSQL = "SELECT * FROM anuncios";
		ArrayList<Anuncios>Anuncio= new ArrayList<Anuncios>();
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				Anuncio.add( new Anuncios (reg.getString("codigo"),
						reg.getString("categoria"),
						reg.getDouble("precioVenta"),
						reg.getString("mail"),
						reg.getDouble("peso")
						));
			}
			s.close();
			this.cerrar();
			return Anuncio;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("ERROR NO DEVUELVE LA TARJETA");
		}
	}
	
	public ArrayList<Anuncios> AnuncioPrecio (String categoria,double max,double min)throws ErrorBaseDatos {
		String cadenaSQL = "SELECT * FROM anuncios WHERE categoria = '"+categoria+"' AND precioventa BETWEEN "+ min +" AND " + max+"";
		ArrayList<Anuncios>Anuncio= new ArrayList<Anuncios>();
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				Anuncio.add( new Anuncios (reg.getString("codigo"),
						reg.getString("categoria"),
						reg.getDouble("precioVenta"),
						reg.getString("mail"),
						reg.getDouble("peso")
						));
			}
			s.close();
			this.cerrar();
			return Anuncio;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("ERROR NO DEVUELVE LA TARJETA");
		}
	}
	
	public int vendidos(Vendidos vend)throws ErrorBaseDatos {
		try {
			this.abrir();
			PreparedStatement p = c.prepareStatement("INSERT INTO `vendidos`(`codigo`, `mailcomprador`, `precioventa`, `fecha`) VALUES (?,?,?,?)");
			p.setString(1,vend.getCodigo());
			p.setString(2,vend.getMailComprador());
			p.setDouble(3,vend.getPrecioVenta()); 
			p.setTimestamp(4, Timestamp.valueOf(vend.getFecha()));
			int filas = p.executeUpdate();
			p.close();
			this.cerrar();
			return filas;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("ERROR NO DEVUELVE LA TARJETA");
		}
	}
	
	public void eliminarAnuncio(String cod)throws ErrorBaseDatos {
		try {
			this.abrir();
			PreparedStatement p = c.prepareStatement("DELETE FROM `anuncios` WHERE `codigo` = ?" );
			p.setString(1,cod); 
			p.executeUpdate();
			p.close();
			this.cerrar();
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("ERROR NO DEVUELVE LA TARJETA");
		}
	}
	

}
