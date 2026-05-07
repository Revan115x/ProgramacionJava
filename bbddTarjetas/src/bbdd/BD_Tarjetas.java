package bbdd;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

import modelos.Cuenta;
import modelos.Movimiento;
import modelos.Tarjeta;

import java.time.*;

import tarjetas.*;

public class BD_Tarjetas extends BD_Conector {

	private static Statement s;
	private static ResultSet reg;

	public BD_Tarjetas(String file) {
		super(file);
	}

	public ArrayList<Cuenta> mostrarCuentas(String dni) throws ErrorBaseDatos {
		String cadenaSQL = "SELECT * FROM cuentas WHERE titular1='" + dni + "' OR titular2='" + dni + "' OR titular3='"
				+ dni + "'";
		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				cuentas.add(new Cuenta(reg.getInt("número"), reg.getString("titular1"), reg.getString("titular2"),
						reg.getString("titular3"), reg.getDouble("saldo"), reg.getDate("fecha").toLocalDate()));
			}
			s.close();
			this.cerrar();
			return cuentas;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("Error al buscar alumno");

		}

	}

	// Añadir Tarjeta.
	public int añadir_Tarjeta(Tarjeta tar) throws ErrorBaseDatos {
		String cadenaSQL = "INSERT INTO tarjetas VALUES (" + tar.getNumero() + "," + tar.getNumeroCuenta() + ",'"
				+ tar.getTitular() + "'," + tar.getLimite() + ",'" + tar.getTipo() + "','" + tar.getCaducidad() + "','"
				+ tar.getClave() + "'," + tar.getBloqueada() + ")";

		try {
			this.abrir();
			s = c.createStatement();
			int filas = s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return filas;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("No se puede realizar el alta de la tarjeta");
		}
	}

	// NUMERO DE CUENTA MAXIMO.
	public int Maximocuenta() throws ErrorBaseDatos {
		String cadenaSQL = "SELECT MAX(numero) FROM tarjetas ";
		int max = 0;
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				max = reg.getInt(1);
			}
			s.close();
			this.cerrar();
			return max;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("ERROR AL DEVOLVER LA CUENTA MAXIMA");

		}
	}

	public ArrayList<Tarjeta>  MostrarTarjeta(int num) throws ErrorBaseDatos {
		String cadenaSQL = "SELECT * FROM tarjetas WHERE numero = " + num;
		ArrayList<Tarjeta> tarjeta = new ArrayList<Tarjeta>();
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				tarjeta.add(new Tarjeta(
					    reg.getInt("numero"),
					    reg.getInt("cuenta"),
					    reg.getString("titular"),
					    reg.getDouble("limite"),
					    reg.getString("tipo"),
					    reg.getDate("caducidad").toLocalDate(),
					    reg.getString("clave"),
					    reg.getInt("bloqueada")
					));
			}
			s.close();
			this.cerrar();
			return tarjeta;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("ERROR NO DEVUELVE LA TARJETA");

		}
	}

}
