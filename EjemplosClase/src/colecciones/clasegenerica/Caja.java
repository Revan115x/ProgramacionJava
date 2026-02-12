package colecciones.clasegenerica;


	// Definimos una clase gen�rica Caja<T>
	class Caja<T> {
	    private T contenido;

	    public void setContenido(T contenido) {
	        this.contenido = contenido;
	    }

	    public T getContenido() {
	        return contenido;
	    }
	}

	

