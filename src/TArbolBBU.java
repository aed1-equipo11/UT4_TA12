public class TArbolBBU extends TArbolBB<Alumno> implements IArbolBB<Alumno> {

    public TArbolBBU() {
        super();
    }

    @Override
    public IElementoAB<Alumno> getRaiz() {
        return (TElementoABU)raiz;
    }

    @Override
    public void armarIndicesCarrreras(Lista<Carrera> carreras) {
        if (getRaiz() != null) {
            getRaiz().indizar(carreras);
        }
    }
}