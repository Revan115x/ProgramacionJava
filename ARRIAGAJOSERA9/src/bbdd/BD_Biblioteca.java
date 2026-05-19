package bbdd;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

import main.ErrorBaseDatos;
import modelos.*;

import java.time.*;


public class BD_Biblioteca extends BD_Conector{

	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Biblioteca(String file){
		super(file);
	}
	
	public usuarios MostrarUsuario(String nombre)throws ErrorBaseDatos {
		String cadenaSQL = "SELECT * FROM usuarios WHERE nombre = '"+nombre+"'";
		usuarios user = null;
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			if (reg.next()) {
				user = new usuarios(
						reg.getInt("numero"),
						reg.getString("nombre"),
						reg.getString("apellidos"),
						reg.getString("tipo"),
						reg.getInt("penalizado")
						);
			}
			s.close();
			this.cerrar();
			return user;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("ERROR CON EL USUARIO");
		}
		
	}
	
	public ArrayList<libros> MostrarLibrosUser(int num)throws ErrorBaseDatos {
		String cadenaSQL = "SELECT l.isbn,l.titulo,l.autor,l.editorial,l.numejemplares,l.prestados "
				+ "FROM `usuarios` u JOIN `prestamos` p ON u.numero=p.codigousuario "
				+ "JOIN `libros` l on l.isbn=p.isbnlibro WHERE u.numero = "+num+";"
				+ "";
		ArrayList<libros> lib = new ArrayList<libros>();
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				lib.add(new libros(reg.getString("isbn"),
						reg.getString("titulo"),
						reg.getString("autor"),
						reg.getString("editorial"),
						reg.getInt("numejemplares"),
						reg.getInt("prestados")
						));
			}
			s.close();
			this.cerrar();
			return lib;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("ERROR CON EL USUARIO");
		}
		
	}

	public libros verificarLibro(String isbn)throws ErrorBaseDatos {
		String cadenaSQL = "SELECT * FROM `libros` WHERE `isbn` = '"+isbn+"' AND numejemplares > 0;";
		libros lib = null;
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			if (reg.next()) {
				lib = new libros(reg.getString("isbn"),
						reg.getString("titulo"),
						reg.getString("autor"),
						reg.getString("editorial"),
						reg.getInt("numejemplares"),
						reg.getInt("prestados")
						);
			}
			s.close();
			this.cerrar();
			return lib;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("ERROR CON EL USUARIO");
		}
		
	}
	
	public int altaprestamo(prestamos pres1)throws ErrorBaseDatos {
		try {
			this.abrir();
			PreparedStatement p = c.prepareStatement("INSERT INTO `prestamos`(`codigousuario`, `isbnlibro`, `fechadevolucion`) VALUES (?,?,?)");
			p.setInt(1,pres1.getCodigousuario());
			p.setString(2,pres1.getIsbnlibro());
			p.setObject(3, LocalDate.now().plusDays(15));
			int filas = p.executeUpdate();
			p.close();
			this.cerrar();
			return filas;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("NO SE PUEDE AGREGAR");
		}
	}
	
	public int AñadirEjemplares(ArrayList<libros> libros) throws ErrorBaseDatos {
		try {
			this.abrir();
			int filas=0;
			PreparedStatement p = c.prepareStatement("UPDATE `libros` SET `numejemplares`= ? WHERE `isbn` = ? ");
			for (libros lib : libros) {
				p.setInt(1, lib.getNumejemplares());
				p.setString(2, lib.getIsbn());
				filas+= p.executeUpdate();
			}
			p.close();
			this.cerrar();
			return filas;
		} catch (SQLException e) {
			throw new ErrorBaseDatos("No se puede realizar el alta");
		}
	}

}
