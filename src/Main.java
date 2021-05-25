
import java.util.ArrayList;
import java.util.LinkedList;
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        // crear un nuevo TArbolBBU de nombre "ucu
        TArbolBBU ucu = new TArbolBBU();

        // cargar los alumnos en el árbol "ucu" desde el archivo de datos "datos.txt"
        ManejadorArchivosGenerico manejadorArchivos = new ManejadorArchivosGenerico();
        String[] archivo = manejadorArchivos.leerArchivo("src/Datos.txt");

        for(String l : archivo) {
            String[] contenido = l.split(",");
            if (contenido.length == 3 ) {
                try {
                    int codigo = Integer.parseInt((contenido[0]));
                    String apellido = contenido[1];
                    String carrera = contenido[2];
                    Alumno alumno = new Alumno(codigo, apellido, carrera);
                    TElementoAB<Alumno> elemento = new TElementoAB<Alumno>(carrera, alumno);
                    ucu.insertar(elemento);
                }
                catch (NumberFormatException e) { }
            }
        }
        
        // crear un nueva lista de carreras
        Lista<Carrera> listaCarreras = new Lista<Carrera>();
        
        // invocar el método armarIndicesCarreras
        ucu.armarIndicesCarrreras(listaCarreras);
        
        // escribir el archivo "unaCarrera.txt" con el nombre de la carrera indicada
        Nodo<Carrera> c = listaCarreras.buscar("Informatica");
        Lista<Alumno> alumnos = c.getDato().getIndiceCarrera().inorden();
        INodo<Alumno> aux = alumnos.getPrimero();
        String salida = "";
        while(aux != null){
            salida = salida + aux.getDato().getApellido() + ",";
            aux = aux.getSiguiente();
        }
        manejadorArchivos.escribirArchivo("src/unaCarrera.txt", salida.split(",") );

        // escribir el archivo todasCarreras
        ArrayList<String> todasCarreras = new ArrayList<String>();

        c = listaCarreras.getPrimero();
        String a;

        while (c != null) {
            manejadorArchivos.escribirArchivo("src/todasCarreras.txt", new String[]{c.getDato().getNombreCarrera()});
            a = c.getDato().getIndiceCarrera().inorden().imprimir(",");
            manejadorArchivos.escribirArchivo("src/todasCarreras.txt", a.split(","));

            c = c.getSiguiente();
        }
    }

}

