package bbdd;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import CINE.*;
import colegio.ErrorBaseDatos;

import java.time.*;
import modelos.reservas;
import modelos.salas;

public class DB_CINE extends BD_Conector{

	private static Statement s;	
	private static ResultSet reg;
	
	public DB_CINE(String file){
		super(file);
	}
	
	/*public  Vector<String> listado() throws ErrorBaseDatos{
		String cadenaSQL="SELECT pelicula,aforo,sala,plazas_ocupadas from salas";
		Vector<String> listacine=new Vector<String>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				listacine.add(reg.getString(1));
			}			
			s.close();
			this.cerrar();
			return listacine;
		}
		catch ( SQLException e){
		//	System.out.println(e.getMessage());
			throw new ErrorBaseDatos("Listando");
			
		}
	}*/
	
	public  Vector<salas> listado() throws ErrorBaseDatos{
		String cadenaSQL="SELECT * from salas";
		Vector<salas> listacine=new Vector<salas>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				listacine.add(new salas(reg.getString(1),reg.getInt(2),reg.getInt(3),reg.getInt(4)));
			}			
			s.close();
			this.cerrar();
			return listacine;
		}
		catch ( SQLException e){
		//	System.out.println(e.getMessage());
			throw new ErrorBaseDatos("Listando cursos");
			
		}
	}
	
	public  int añadir ( reservas a) throws ErrorBaseDatos{	
		String cadenaSQL="INSERT INTO reservas VALUES('" + a.getPrecio() + "','" +a.getEntradas()+ "'.'"+a.getSala()+"','"+a.getTelefono()+"')";
			
		
		try{
			this.abrir();
			s=c.createStatement();
			int filas=s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return filas;
		}
		catch ( SQLException e){			
			throw new ErrorBaseDatos("No se puede realizar el alta");
		}
	}

}
