package bbdd;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

import modelos.Cuenta;
import modelos.Movimiento;
import modelos.Tarjeta;

import java.time.*;


import tarjetas.*;

public class BD_Tarjetas extends BD_Conector{

	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Tarjetas(String file){
		super(file);
	}
	
	
	// Dado un DNI , mostrar todas las cuentas donde el titular sea el del DNI.
	
	public ArrayList<Cuenta> mostrarCuentas (String dni) throws ErrorBaseDatos{
		String cadenaSQL="SELECT * FROM cuentas WHERE titular1='"+dni+"' OR titular2='"+dni+"' OR titular3='"+dni+"'";
		ArrayList<Cuenta> cuentas=new ArrayList<Cuenta>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				cuentas.add(new Cuenta(reg.getInt("número"), reg.getString("titular1"), reg.getString("titular2"), reg.getString("titular3"), reg.getDouble("saldo"), reg.getDate("fecha").toLocalDate()));
			}			
			s.close();
			this.cerrar();
			return cuentas;
		}
		catch ( SQLException e){
		    this.cerrar();
			throw new ErrorBaseDatos("Error al buscar alumno");
			
		}
		
		
	}
	
 // Añadir Tarjeta. 
	public int añadir_Tarjeta(Tarjeta tar) throws ErrorBaseDatos{	
		String cadenaSQL="INSERT INTO tarjetas VALUES ("+tar.getNumero()+","+tar.getNumeroCuenta()+
				",'"+tar.getTitular()+"',"+tar.getLimite()+",'"+tar.getTipo()+"','"+tar.getCaducidad()+"','"+tar.getClave()+"',"+tar.getBloqueada()+")";
		
		try{
			this.abrir();
			s=c.createStatement();
			int filas=s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return filas;
		}
		catch ( SQLException e){
			this.cerrar();
			throw new ErrorBaseDatos("No se puede realizar el alta de la tarjeta");
		}
	}
	
	// Buscar Cuenta
	public Cuenta buscarCuenta(int numCuenta) throws ErrorBaseDatos {
		String cadenaSQL="SELECT * FROM cuentas WHERE número='"+numCuenta+"'";
		Cuenta ct = null;
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			if ( reg.next()){
				ct=new Cuenta(reg.getInt("número"),reg.getString("titular1"),reg.getString("titular2"),reg.getString("titular3"),reg.getDouble("saldo"),reg.getDate("fecha").toLocalDate());
			}			
			s.close();
			this.cerrar();
			return ct;
		}
		catch ( SQLException e){
		    this.cerrar();
			throw new ErrorBaseDatos("Error al buscar cuenta");
			
		}
	}
	
	// buscar el numero de tarjeta mas alto.
	public int BuscarUltimoNumTarjeta() throws ErrorBaseDatos{
		String cadenaSQL="SELECT MAX(numero) from tarjetas";
		int ultimo=0;
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			if ( reg.next()){
				ultimo=reg.getInt(1);
			}			
			s.close();
			this.cerrar();
			return ultimo;
		}
		catch ( SQLException e){
		    this.cerrar();
			throw new ErrorBaseDatos("Error al buscar alumno");
		}
	}
	
	  //  SACAR DINERO DE LA TARJETA DE DEBITO
	 // 1. Buscar la tarjeta con su numTarjeta y clave y comprobar datos básicos
	public void sacarDineroDebito(int numTarjeta, String clave, double importe) throws ErrorBaseDatos {
	    String sqlTarjeta = "SELECT * FROM tarjetas WHERE numero=" + numTarjeta + " AND clave='" + clave + "'";
	    try {
	        this.abrir();
	        s = c.createStatement();
	        reg = s.executeQuery(sqlTarjeta);
	        
	        if (!reg.next()) {
	            throw new ErrorBaseDatos("Número de tarjeta o clave incorrectos.");
	        }

	        // 2. Comprobar que sea de débito y no esté bloqueada
	        if (!reg.getString("tipo").equalsIgnoreCase("D")) {
	            throw new ErrorBaseDatos("La tarjeta no es de débito.");
	        }
	        if (reg.getInt("bloqueada") != 0) {
	            throw new ErrorBaseDatos("La tarjeta está bloqueada.");
	        }

	        int numCuenta = reg.getInt("cuenta");
	        s.close();

	        // 3. Comprobar saldo de la cuenta asociada
	        Statement s2 = c.createStatement();
	        ResultSet reg2 = s2.executeQuery("SELECT saldo FROM cuentas WHERE número=" + numCuenta);
	        
	        if (reg2.next()) {
	            double saldoActual = reg2.getDouble("saldo");
	            if (saldoActual < importe) {
	                throw new ErrorBaseDatos("Saldo insuficiente en la cuenta asociada.");
	            }

	            // 4. Descontar el importe (Operación de actualización)
	            double nuevoSaldo = saldoActual - importe;
	            int filas = s2.executeUpdate("UPDATE cuentas SET saldo=" + nuevoSaldo + " WHERE número=" + numCuenta);
	            
	            if (filas == 1) {
	                System.out.println("Operación realizada con éxito. Nuevo saldo: " + nuevoSaldo);
	            }
	        } else {
	            throw new ErrorBaseDatos("No se encontró la cuenta asociada a la tarjeta.");
	        }
	        
	        s2.close();
	        this.cerrar();
	    } catch (SQLException e) {
	        this.cerrar();
	        throw new ErrorBaseDatos("Error técnico al procesar el reintegro.");
	    }
	}
	
	
	// SACAR DINERO DE LA TARJETA DE CREDITO
	public void validarTarjetaCredito(int numTarjeta, String clave, double importe) throws ErrorBaseDatos {
	    String sql = "SELECT * FROM tarjetas WHERE numero=" + numTarjeta + " AND clave='" + clave + "'";
	    try {
	        this.abrir();
	        s = c.createStatement();
	        reg = s.executeQuery(sql);
	        
	        if (!reg.next()) {
	            throw new ErrorBaseDatos("Número de tarjeta o clave incorrectos.");
	        }

	        // Comprobar que sea de crédito ('C')
	        if (!reg.getString("tipo").equalsIgnoreCase("C")) {
	            throw new ErrorBaseDatos("La tarjeta no es de crédito.");
	        }
	        
	        // Comprobar que no esté bloqueada
	        if (reg.getInt("bloqueada") != 0) {
	            throw new ErrorBaseDatos("La tarjeta está bloqueada.");
	        }

	        // Comprobar que el importe no supere el límite de la tarjeta
	        double limite = reg.getDouble("limite");
	        if (importe > limite) {
	            throw new ErrorBaseDatos("El importe supera el límite de crédito (" + limite + ").");
	        }

	        s.close();
	        this.cerrar();
	    } catch (SQLException e) {
	        this.cerrar();
	        throw new ErrorBaseDatos("Error al validar la tarjeta de crédito.");
	    }
	}
	
	
	public  int añadir_Movimiento(Movimiento m) throws ErrorBaseDatos{	
		String cadenaSQL="INSERT INTO movimientos (tarjeta,cargado,importe,fecha) VALUES("+m.getNumTarjeta()+","+m.isCargado()+","+m.getImporte()+",'"+m.getFecha()+"')";
		try{
			this.abrir();
			s=c.createStatement();
			int filas=s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return filas;
		}
		catch ( SQLException e){
			this.cerrar();
			throw new ErrorBaseDatos("No se puede realizar el alta");
		}
	}
	
	/*
	public  int añadir_Alumno( Alumno al) throws ErrorBaseDatos{	
		String cadenaSQL="INSERT INTO alumnos VALUES('" + al.getNombre() + "','" +
		al.getDni()+"','"+ al.getTelenono() +"',"+ al.getMatricula()+",'"+
				al.getCurso()+"','"+al.getFechaMatricula()+"')"; 	
		
		try{
			this.abrir();
			s=c.createStatement();
			int filas=s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return filas;
		}
		catch ( SQLException e){
			this.cerrar();
			throw new ErrorBaseDatos("No se puede realizar el alta");
		}
	}
	
	public int borrarAlumno(String dni) throws ErrorBaseDatos{	
		String cadenaSQL="DELETE FROM alumnos WHERE dni='"+dni+"'";
		
		try{
			this.abrir();
			s=c.createStatement();
			int filas=s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return filas;
		}
		catch ( SQLException e){
			this.cerrar();
			throw new ErrorBaseDatos("No se puede realizar la baja");
		}
	}
	
	public Alumno buscarAlumno(String dni) throws ErrorBaseDatos {
		String cadenaSQL="SELECT * FROM alumnos WHERE dni='"+dni+"'";
		Alumno al = null;
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			if ( reg.next()){
				new Alumno(reg.getString("dni"),reg.getString("nombre"),reg.getString("curso"),reg.getInt("matricula"),reg.getString("telefono"),reg.getDate("fechaMatricula").toLocalDate());
			}			
			s.close();
			this.cerrar();
			return al;
		}
		catch ( SQLException e){
		    this.cerrar();
			throw new ErrorBaseDatos("Error al buscar alumno");
			
		}
	}
	
	
	public ArrayList<Alumno> buscarAlumno_Mat(int mat) throws ErrorBaseDatos {
		String cadenaSQL="SELECT * FROM alumnos WHERE dni > "+ mat;
		ArrayList<Alumno> alumnos=new ArrayList<Alumno>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				alumnos.add(new Alumno(reg.getString("dni"),reg.getString("nombre"),reg.getString("curso"),reg.getInt("matricula"),reg.getString("telefono"),reg.getDate("fechaMatricula").toLocalDate()));
			}			
			s.close();
			this.cerrar();
			return alumnos;
		}
		catch ( SQLException e){
		    this.cerrar();
			throw new ErrorBaseDatos("Error al buscar alumno");
			
		}
	}
	
	
	
	public  ArrayList<Alumno> listadoAlumnosCurso(String curso) throws ErrorBaseDatos{
		String cadenaSQL="SELECT * from alumnos WHERE curso='"+curso+"'";
		ArrayList<Alumno> listaCursos=new ArrayList<Alumno>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				// La fecha que se extrae de la bbdd es sql.Date, hay que transformarla a LocalDate
				java.sql.Date f=reg.getDate("fechaMatricula");
				LocalDate fBuena=f.toLocalDate();
				//reg.getDate("fechaMatricula").toLocalDate();  Método mas corto
				listaCursos.add(new Alumno(reg.getString("dni"),reg.getString("nombre"),reg.getString("curso"),reg.getInt("matricula"),reg.getString("telefono"),fBuena));
				
			}
			s.close();
			this.cerrar();
			return listaCursos;
		}
		catch ( SQLException e){	
			this.cerrar();
			throw new ErrorBaseDatos("Listando alumnos curso");	
		}
	}
	
	
	public  Vector<String> listadoCursos() throws ErrorBaseDatos{
		String cadenaSQL="SELECT curso from cursos";
		Vector<String> listaCursos=new Vector<String>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				listaCursos.add(reg.getString(1));
			}			
			s.close();
			this.cerrar();
			return listaCursos;
		}
		catch ( SQLException e){
		    this.cerrar();
			throw new ErrorBaseDatos("Listando cursos");
			
		}
	}
	
	/**
	 * @param curso 
	 * @param descr
	 * @param aula
	 * @return el numero de filas afectadas, en este caso retorna 1 fila, al insertar un curso.
	 * @throws ErrorBaseDatos
	 */
	/*
	public int añadirCurso(String curso, String descr, String aula) throws ErrorBaseDatos {
		String cadenaSQL="INSERT INTO cursos VALUES('"+curso+"','"+descr +"','"+aula+"')";
		try {
			this.abrir();
			s=c.createStatement();
			int filas=s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return filas;
			
		}catch(SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("error al añadir nuevo curso");
		}
		
	}
	
	public  void listadoAlumnosPorCurso() throws ErrorBaseDatos{
		String cadenaSQL="SELECT curso from cursos";
	    String curso="";
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				curso=reg.getString(1);
				System.out.println("CURSO:"+curso);
				Statement s2=c.createStatement();
				ResultSet reg2=s2.executeQuery("select nombre from alumnos where curso='"+curso+"'");
				while ( reg2.next()){
					System.out.println("\t"+reg2.getString(1));
				}			
				s2.close();
			}			
			s.close();
			this.cerrar();
			return;
		}
		catch ( SQLException e){
		    this.cerrar();
			throw new ErrorBaseDatos("Listando cursos");
			
		}
	}
	*/
	
}
