package colecciones.metodogenerico;

class Utilidades {
    // M�todo gen�rico que imprime cualquier tipo de array
    public static <T> void imprimirArray(T[] array) {
        for (T elemento : array) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }
}



