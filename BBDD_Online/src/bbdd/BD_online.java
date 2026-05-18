package bbdd;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

import main.ErrorBaseDatos;
import modelos.*;

import java.time.*;


public class BD_online extends BD_Conector{

	private static Statement s;	
	private static ResultSet reg;
	
	public BD_online(String file){
		super(file);
	}
	
	
	public LinkedList<cursos> Cursos()throws ErrorBaseDatos {
		String cadenaSQL = "SELECT * FROM cursos WHERE fechainicio > NOW();";
		LinkedList<cursos> cur = new LinkedList<cursos>();
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				cur.add( new cursos(
						reg.getString("codigo"),
						reg.getString("titulo"),
						reg.getString("categoria"),
						reg.getDouble("precio"),
						reg.getDate("fechainicio").toLocalDate(),
						reg.getInt("plazas")
						));
			}
			s.close();
			this.cerrar();
			return cur;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("NO DEVUELVE LOS CURSOS");
		}
		
	}
	
	public LinkedList<cursos> CursosDisponibles(String cat,double min,double max)throws ErrorBaseDatos {
		String cadenaSQL = "SELECT * FROM cursos WHERE categoria = '"+cat+"' and precio BETWEEN "+min+" and "+max+"";
		LinkedList<cursos> cur = new LinkedList<cursos>();
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				cur.add( new cursos(
						reg.getString("codigo"),
						reg.getString("titulo"),
						reg.getString("categoria"),
						reg.getDouble("precio"),
						reg.getDate("fechainicio").toLocalDate(),
						reg.getInt("plazas")
						));
			}
			s.close();
			this.cerrar();
			return cur;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("NO DEVUELVE LOS CURSOS DISPONIBLES");
		}	
	}
	
	public alumnos BuscarCorreos(String correo)throws ErrorBaseDatos {
		String cadenaSQL = "SELECT * FROM `alumnos` WHERE mail = '"+correo+"'";
		alumnos alum = null;
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			if (reg.next()) {
				alum = new alumnos(
						reg.getString("mail"),
						reg.getString("nombre"),
						reg.getInt("premium"),
						reg.getInt("puntos")
						);
			}
			s.close();
			this.cerrar();
			return alum;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("NO DEVUELVE LOS CURSOS DISPONIBLES");
		}	
	}
	
	public int inscribirse(cursos cur,alumnos alum)throws ErrorBaseDatos {
		
		try {
			this.abrir();
			/*CUANDO LA TABLA TIENE UN CAMPO AUTO INCREMETABLE HACEMOS A INDICAR LOS CAMPOS QUE VAMOS A AÑADIR*/
			PreparedStatement p = c.prepareStatement("INSERT INTO inscripciones (`codigoCurso`, `mailAlumno`, `fechaInscripcion`, `precioFinal`) VALUES (?,?,?,?)");
			p.setString(1, cur.getCodigo());
			p.setString(2, alum.getMail());
			p.setObject(3, LocalDate.now());
			p.setDouble(4, 5000);
			int filas = p.executeUpdate();
			p.close();
			this.cerrar();
			return filas;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("ERROR NO PUEDE ACTUALIZAR EL MOVIMIENTO");
		}
		
	}
	
	public void actualizar(cursos cur)throws ErrorBaseDatos {
		
		try {
			this.abrir();
			PreparedStatement p = c.prepareStatement("UPDATE `cursos` SET `plazas` = plazas-1 WHERE `codigo` = ?");
			p.setString(1, cur.getCodigo());
			p.executeUpdate();
			p.close();
			this.cerrar();
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("ERROR NO PUEDE ACTUALIZAR EL MOVIMIENTO");
		}
		
	}
	
	public LinkedList<cursos> CursosMasCaro()throws ErrorBaseDatos {
		String cadenaSQL = "SELECT * FROM `cursos` ORDER BY `cursos`.`precio`  DESC";
		LinkedList<cursos> cur = new LinkedList<cursos>();
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				cur.add( new cursos(
						reg.getString("codigo"),
						reg.getString("titulo"),
						reg.getString("categoria"),
						reg.getDouble("precio"),
						reg.getDate("fechainicio").toLocalDate(),
						reg.getInt("plazas")
						));
			}
			s.close();
			this.cerrar();
			return cur;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("NO DEVUELVE LOS CURSOS DISPONIBLES");
		}	
	}
	
	public String categoriaMasInscrita() throws ErrorBaseDatos {

		String sql = "SELECT categoria, COUNT(*) total FROM cursos C JOIN inscripciones I ON C.codigo = I.codigoCurso GROUP BY categoria ORDER BY total DESC LIMIT 1";
		String categoria = "";
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(sql);
			if(reg.next()) {
				categoria = reg.getString("categoria");
			}
			s.close();
			this.cerrar();
			return categoria;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("ERROR CATEGORIA");
		}
	}
}
