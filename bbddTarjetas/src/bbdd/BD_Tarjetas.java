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

}
