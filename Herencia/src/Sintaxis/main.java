package Sintaxis;

public class main {

	/*
	 * ========================================= TEMA IX: HERENCIA Y POLIMORFISMO
	 * =========================================
	 * 
	 * Ley de Alzheimer de la programación: "Si lees un código que escribiste hace
	 * más de dos semanas, es como si lo vieras por primera vez."
	 * 
	 * ----------------------------------------- 1. HERENCIA
	 * -----------------------------------------
	 * 
	 * La herencia permite crear una clase a partir de otra.
	 * 
	 * Sintaxis:
	 * 
	 * class Hijo extends Padre { }
	 * 
	 * Ventajas: - Reutilización de código. - Organización jerárquica. - Facilita el
	 * mantenimiento.
	 * 
	 * Terminología: - Superclase o clase padre. - Subclase o clase hija.
	 * 
	 * La subclase hereda: - Variables - Métodos
	 * 
	 * Puede además: - Añadir nuevos atributos. - Añadir nuevos métodos. -
	 * Sobrescribir métodos heredados.
	 */

	class Animal {

		protected String nombre;
		protected int edad;

		public Animal(String nombre, int edad) {
			this.nombre = nombre;
			this.edad = edad;
		}

		public void mostrarDatos() {
			System.out.println("Nombre: " + nombre);
			System.out.println("Edad: " + edad);
		}
	}

	/*
	 * ----------------------------------------- SUBCLASE CARNIVORO
	 * -----------------------------------------
	 */

	class Carnivoro extends Animal {

		private double kgCarneDia;

		public Carnivoro(String nombre, int edad, double kgCarneDia) {

			// Llamada obligatoria al constructor del padre
			super(nombre, edad);

			this.kgCarneDia = kgCarneDia;
		}

		public void mostrarCarne() {
			System.out.println("Consume " + kgCarneDia + " Kg de carne al día");
		}
	}

	/*
	 * ----------------------------------------- SUBCLASE HERBIVORO
	 * -----------------------------------------
	 */

	class Herbivoro extends Animal {

		private String tipoHierba;

		public Herbivoro(String nombre, int edad, String tipoHierba) {

			super(nombre, edad);

			this.tipoHierba = tipoHierba;
		}

		public void mostrarHierba() {
			System.out.println("Come: " + tipoHierba);
		}
	}

	/*
	 * ========================================= 2. PROTECTED
	 * =========================================
	 * 
	 * private: Solo accesible dentro de la clase.
	 * 
	 * protected: Accesible desde: - La propia clase. - Las clases hijas.
	 * 
	 * public: Accesible desde cualquier sitio.
	 */

	/*
	 * ========================================= 3. POLIMORFISMO
	 * =========================================
	 * 
	 * Una referencia de la clase padre puede apuntar a un objeto de una clase hija.
	 * 
	 * Ejemplo:
	 */

	class Persona {

		protected String nombre;

		public Persona(String nombre) {
			this.nombre = nombre;
		}
	}

	class Empleado extends Persona {

		protected double sueldoBase;

		public Empleado(String nombre, double sueldo) {
			super(nombre);
			sueldoBase = sueldo;
		}

		public double getSueldo() {
			return sueldoBase;
		}
	}

	class Encargado extends Empleado {

		public Encargado(String nombre, double sueldo) {
			super(nombre, sueldo);
		}

		/*
		 * ========================================= 4. SOBREESCRITURA (OVERRIDING)
		 * =========================================
		 * 
		 * Se redefine un método heredado.
		 * 
		 * Reglas: - Mismo nombre. - Mismos parámetros. - Mismo tipo de retorno.
		 */

		@Override
		public double getSueldo() {

			// Cobra un 10% más
			return sueldoBase * 1.10;
		}
	}

	/*
	 * ========================================= EJEMPLO DE POLIMORFISMO
	 * =========================================
	 */

	class PruebaPolimorfismo {

		public static void main(String[] args) {

			Encargado jefe = new Encargado("Juan", 2000);

			// Referencia padre -> objeto hijo
			Empleado emp = jefe;

			// Se ejecuta el método del objeto real
			System.out.println(emp.getSueldo());

			/*
			 * Salida: 2200
			 * 
			 * Aunque emp sea Empleado, el objeto real es Encargado.
			 */
		}
	}

	/*
	 * ========================================= 5. INSTANCEOF Y CASTING
	 * =========================================
	 * 
	 * instanceof comprueba el tipo real del objeto.
	 * 
	 * Casting convierte una referencia a otro tipo compatible.
	 */

	class EjemploCasting {

		public static void main(String[] args) {

			Empleado e = new Encargado("Pedro", 2500);

			if (e instanceof Encargado) {

				Encargado enc = (Encargado) e;

				System.out.println(enc.getSueldo());
			}
		}
	}

	/*
	 * ========================================= 6. TIPOS DE VINCULACIÓN
	 * =========================================
	 * 
	 * Vinculación temprana: - Tiempo de compilación. - Métodos normales. - Métodos
	 * sobrecargados.
	 * 
	 * Vinculación tardía: - Tiempo de ejecución. - Métodos sobrescritos. - Base del
	 * polimorfismo.
	 */

	/*
	 * ========================================= 7. SOBRECARGA (OVERLOADING)
	 * =========================================
	 * 
	 * Mismo método. Distintos parámetros.
	 * 
	 * Puede cambiar: - Número de parámetros. - Tipo de parámetros.
	 * 
	 * Puede cambiar también: - Tipo de retorno.
	 */

	class Calculadora {

		public int sumar(int a, int b) {
			return a + b;
		}

		public int sumar(int a, int b, int c) {
			return a + b + c;
		}

		public double sumar(double a, double b) {
			return a + b;
		}
	}

	/*
	 * ========================================= 8. CLASE ABSTRACTA
	 * =========================================
	 * 
	 * Una clase abstracta:
	 * 
	 * - NO puede instanciarse. - Sirve como plantilla. - Puede tener métodos
	 * normales. - Puede tener métodos abstractos.
	 */

	abstract class Vehiculo {

		protected int peso;

		public void setPeso(int peso) {
			this.peso = peso;
		}

		// Método abstracto
		public abstract int getVelocidadActual();
	}

	/*
	 * ----------------------------------------- SUBCLASE COCHE
	 * -----------------------------------------
	 */

	class Coche extends Vehiculo {

		@Override
		public int getVelocidadActual() {
			return 120;
		}
	}

	/*
	 * ----------------------------------------- SUBCLASE MOTO
	 * -----------------------------------------
	 */

	class Moto extends Vehiculo {

		@Override
		public int getVelocidadActual() {
			return 90;
		}
	}

	/*
	 * ========================================= 9. FINAL
	 * =========================================
	 * 
	 * final class: No puede heredarse.
	 * 
	 * final method: No puede sobrescribirse.
	 */

	final class ClaseSegura {

		public final void mostrar() {

			System.out.println("No se puede redefinir");
		}
	}

	/*
	 * ========================================= 10. CLASE OBJECT
	 * =========================================
	 * 
	 * Toda clase hereda de Object.
	 * 
	 * Si no ponemos extends, Java añade automáticamente:
	 * 
	 * extends Object
	 */

	/*
	 * ========================================= 11. MÉTODO toString()
	 * =========================================
	 * 
	 * Se utiliza para mostrar información del objeto.
	 */

	class Empleado2 {

		private String nombre;
		private double sueldo;

		public Empleado2(String nombre, double sueldo) {

			this.nombre = nombre;
			this.sueldo = sueldo;
		}

		@Override
		public String toString() {

			return "Nombre: " + nombre + " | Sueldo: " + sueldo;
		}
	}

	/*
	 * Uso:
	 * 
	 * Empleado2 e = new Empleado2("Juan",2000);
	 * 
	 * System.out.println(e);
	 * 
	 * Salida:
	 * 
	 * Nombre: Juan | Sueldo: 2000
	 */

	/*
	 * ========================================= 12. MÉTODO equals()
	 * =========================================
	 * 
	 * Sirve para comparar objetos.
	 * 
	 * Por defecto: Compara direcciones de memoria.
	 * 
	 * Normalmente se redefine para comparar atributos.
	 */

	class Empleado3 {

		private String dni;

		public Empleado3(String dni) {
			this.dni = dni;
		}

		@Override
		public boolean equals(Object obj) {

			if (!(obj instanceof Empleado3))
				return false;

			Empleado3 otro = (Empleado3) obj;

			return this.dni.equals(otro.dni);
		}
	}

	/*
	 * ========================================= 13. MÉTODO getClass()
	 * =========================================
	 * 
	 * Permite obtener información de la clase del objeto.
	 */

	class EjemploClass {

		public static void main(String[] args) {

			Empleado emp = new Empleado("Juan", 2000);

			System.out.println(emp.getClass().getName());

			/*
			 * Salida:
			 * 
			 * Empleado
			 */
		}
	}

	/*
	 * ========================================= RESUMEN EXAMEN
	 * =========================================
	 * 
	 * HERENCIA -------- class Hijo extends Padre
	 * 
	 * POLIMORFISMO ------------ Padre p = new Hijo();
	 * 
	 * OVERRIDING ---------- Mismo nombre Mismos parámetros Mismo retorno
	 * 
	 * OVERLOADING ----------- Mismo nombre Distintos parámetros
	 * 
	 * ABSTRACT -------- No se puede instanciar.
	 * 
	 * PROTECTED --------- Visible para las clases hijas.
	 * 
	 * INSTANCEOF ---------- Comprueba el tipo real.
	 * 
	 * CASTING -------- (Hijo)objetoPadre
	 * 
	 * OBJECT ------ Clase raíz de Java.
	 * 
	 * toString() ---------- Representación en texto.
	 * 
	 * equals() --------- Comparación de objetos.
	 * 
	 * getClass() ---------- Información de la clase.
	 * 
	 * FINAL ----- No permite herencia o redefinición.
	 */

}