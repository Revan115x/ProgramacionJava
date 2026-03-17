package Sintaxis;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import static java.nio.file.StandardOpenOption.*;

public class main {

    public static void main(String[] args) {

        /***********************************STREAMS*****************************************/

        /*
         * Los programas necesitan comunicarse con el entorno (leer datos y mostrar resultados).
         * En Java esto se hace con STREAMS (flujos de datos).
         *
         * Un stream:
         * - Es una conexión entre el programa y una fuente/destino de datos.
         * - Representa una cadena de datos (longitud desconocida).
         *
         * Tipos:
         * - Binarios (bytes)
         * - Texto (caracteres)
         *
         * Dirección:
         * - Entrada → el programa recibe datos
         * - Salida → el programa envía datos
         */

        /***********************************CLASE PATH*****************************************/

        /*
         * Path:
         * - Representa la ruta de un archivo o carpeta.
         * - No abre ni manipula contenido.
         * - Permite:
         *   • Recuperar partes de la ruta (nombre archivo, carpeta padre)
         *   • Eliminar redundancias (normalizar la ruta)
         *   • Unir rutas (resolve)
         *   • Crear rutas relativas a otra
         *   • Comparar rutas
         */

        Path p1 = Paths.get("D:/tmp/foo");
        Path p2 = Paths.get(System.getProperty("user.home"), "logs", "foo.log");

        System.out.println("Nombre archivo: " + p1.getFileName());
        System.out.println("Carpeta padre: " + p1.getParent());
        System.out.println("Ruta normalizada: " + p1.normalize());
        System.out.println("Ruta combinada: " + p1.resolve("otro.txt"));

        /***********************************CLASE FILES*****************************************/

        /*
         * Files:
         * - Permite trabajar con archivos y directorios usando Path.
         *
         * Operaciones principales:
         * 1) Verificación:
         *    - Files.exists(Path p) → devuelve true si existe.
         *    - Files.isRegularFile(Path p) → true si es archivo normal.
         *    - Files.isDirectory(Path p) → true si es carpeta.
         *
         * 2) Crear:
         *    - Files.createFile(Path p) → crea archivo vacío.
         *    - Files.createDirectory(Path p) → crea carpeta.
         *
         * 3) Borrar:
         *    - Files.delete(Path p) → elimina archivo o carpeta (lanza excepción si no existe).
         *    - Files.deleteIfExists(Path p) → elimina si existe, no lanza excepción.
         *
         * 4) Copiar/Mover:
         *    - Files.copy(origen, destino) → copia archivo o carpeta.
         *    - Files.move(origen, destino) → mueve o renombra archivo o carpeta.
         *
         * 5) Recorrer directorios:
         *    - DirectoryStream<Path> stream = Files.newDirectoryStream(Path p)
         *      → permite iterar los archivos dentro de un directorio.
         */

        Path archivo = Paths.get("ejemplo.txt");

        try {
            if (!Files.exists(archivo)) {
                Files.createFile(archivo);
            }

            // Escribir texto
            List<String> lineas = Arrays.asList("Hola", "Mundo");
            Files.write(archivo, lineas, CREATE, WRITE);
            
            //IMPORTANTE EXPORTAR ESTO "import static java.nio.file.StandardOpenOption.*;"
            Files.write(archivo, lineas, WRITE, APPEND,TRUNCATE_EXISTING,CREATE_NEW,CREATE,DELETE_ON_CLOSE);

            // Leer texto
            List<String> leido = Files.readAllLines(archivo);
            for (String l : leido) {
                System.out.println(l);
            }

            // Copiar archivo
            Path copia = Paths.get("copia.txt");
            Files.copy(archivo, copia, REPLACE_EXISTING);

            // Mover archivo
            Path movido = Paths.get("movido.txt");
            Files.move(archivo, movido, REPLACE_EXISTING);

            // Borrar archivo
            Files.deleteIfExists(copia);
            

        } catch (IOException e) {
            System.out.println("Error con archivos: " + e.getMessage());
        }

        /***********************************RECORRER DIRECTORIOS*****************************************/

        try {
            Path dir = Paths.get(".");
            if (Files.isDirectory(dir)) {
                DirectoryStream<Path> stream = Files.newDirectoryStream(dir);
                for (Path p : stream) {
                    System.out.println("Archivo/directorio: " + p.getFileName());
                }
            }
        } catch (IOException e) {
            System.out.println("Error al recorrer directorio: " + e.getMessage());
        }

        /***********************************JAVA.IO vs JAVA.NIO*****************************************/

        /*
         * java.io → antiguo
         *   - Basado en streams
         *   - Lectura/escritura secuencial
         *   - Bloqueante (espera a completar operación)
         *
         * java.nio → moderno (Java 7)
         *   - Basado en buffers
         *   - Permite moverse adelante/atrás
         *   - No bloqueante (el programa puede seguir ejecutándose mientras se procesa)
         */

        /***********************************OPEN OPTIONS*****************************************/

        /*
         * OpenOptions:
         * - WRITE → abrir archivo para escritura
         * - APPEND → añadir al final
         * - TRUNCATE_EXISTING → borrar contenido
         * - CREATE → crea si no existe
         * - CREATE_NEW → crear nuevo, lanza error si existe
         * - DELETE_ON_CLOSE → borra archivo al cerrar stream
         */

        /***********************************ARCHIVOS PEQUEÑOS*****************************************/

        try {
            byte[] datos = Files.readAllBytes(Paths.get("binario.dat"));
            Files.write(Paths.get("binario2.dat"), datos, CREATE, WRITE);

            List<String> texto = Files.readAllLines(Paths.get("texto.txt"));
            Files.write(Paths.get("texto2.txt"), texto, CREATE, WRITE);

        } catch (IOException e) {
            System.out.println("Error lectura/escritura completa: " + e.getMessage());
        }

        /***********************************BINARIO SIN BUFFER*****************************************/

        try (FileOutputStream fos = new FileOutputStream("binario.dat")) {
            fos.write(65);
        } catch (IOException e) {
            System.out.println("Error binario: " + e.getMessage());
        }

        try (FileInputStream fis = new FileInputStream("binario.dat")) {
            int dato = fis.read();
            System.out.println((char) dato);
        } catch (IOException e) {
            System.out.println("Error binario: " + e.getMessage());
        }

        /***********************************TEXTO CON BUFFER*****************************************/

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("texto.txt"))) {
            bw.write("Hola mundo");
        } catch (IOException e) {
            System.out.println("Error buffer: " + e.getMessage());
        }

        try (BufferedReader br = new BufferedReader(new FileReader("texto.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error buffer: " + e.getMessage());
        }

        /***********************************ACCESO ALEATORIO*****************************************/

        try (RandomAccessFile raf = new RandomAccessFile("aleatorio.txt", "rw")) {
            raf.writeUTF("Hola");
            raf.seek(0);
            System.out.println(raf.readUTF());
        } catch (IOException e) {
            System.out.println("Error aleatorio: " + e.getMessage());
        }

        /***********************************RESUMEN*****************************************/

        /*
         * - Streams → comunicación datos
         * - Path → rutas de archivos y carpetas
         * - Files → operaciones sobre archivos/directorios
         * - java.io → antiguo, secuencial, bloqueante
         * - java.nio → moderno, buffers, no bloqueante
         */
    }
}