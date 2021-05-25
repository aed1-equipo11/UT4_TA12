public class TArbolBBU extends TArbolBB<Alumno> implements IArbolBBU {

    @Override
    public void armarIndicesCarrreras(Lista<Carrera> carreras) {
        if (raiz != null) {
            ((TElementoABU)raiz).indizar(carreras);
        }
    }
}